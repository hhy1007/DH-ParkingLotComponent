/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.car.impl;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.eg.egsc.scp.parkinglotcomponent.dao.car.CarDao;
import com.eg.egsc.scp.parkinglotcomponent.enmus.OperateType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.alarm.CarType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.alarm.ControlType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.CarEnterMode;
import com.eg.egsc.scp.parkinglotcomponent.enmus.carport.CarportType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.rule.MonthCarTurnTemp;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.authpackage.entity.AuthPackage;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCar;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkingLot;
import com.eg.egsc.scp.parkinglotcomponent.redis.RedisKey;
import com.eg.egsc.scp.parkinglotcomponent.service.access.RoadGateService;
import com.eg.egsc.scp.parkinglotcomponent.service.car.CarEnterParkingLotService;
import com.eg.egsc.scp.parkinglotcomponent.service.car.SwipeCarInParkinglotService;
import com.eg.egsc.scp.parkinglotcomponent.service.car.dto.CarInOutParkingLotDto;
import com.eg.egsc.scp.parkinglotcomponent.service.car.dto.ICCardDto;
import com.eg.egsc.scp.parkinglotcomponent.service.integration.dto.CarInOutDto;
import com.eg.egsc.scp.parkinglotcomponent.service.rule.dto.RuleDto;
import com.eg.egsc.scp.parkinglotcomponent.util.Constants;
import com.eg.egsc.scp.parkinglotcomponent.util.DateUtil;

/**
 * 刷卡进入停车场接口实现
 * 
 * @Class Name SwipeCarInParkinglotServiceImpl
 * @Author xiaoxiaojie
 * @Create In 2018年1月9日
 */
@Service
public class SwipeCarInParkinglotServiceImpl implements SwipeCarInParkinglotService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CarEnterParkingLotService carEnterParkingLotServiceImpl;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    private CarDao carDao;
    @Autowired
    private RoadGateService roadGateServiceImpl;// 道闸服务

    @Override
    public CarInOutParkingLotDto initCarInParkinglotInfo(ICCardDto icCardDto) {
        
        CarInOutParkingLotDto tempDto = new CarInOutParkingLotDto();
        Date inTime = new Date();// 入场时间
        String devCode = icCardDto.getDevCode();// 设备编号
        String carNum = icCardDto.getCarNum();
        String cardNumber = icCardDto.getCardNumber();
        ParkChannel channel = carEnterParkingLotServiceImpl.getChannelInfo(devCode);
        if (channel == null) {
            return tempDto;
        }

        // 先从缓存里取数据
        CarInOutParkingLotDto carInOutParkingLotDto = (CarInOutParkingLotDto) redisTemplate
                .opsForHash().get(RedisKey.KEY_CHANNEL_ID, channel.getUuid());
        logger.info(
                "get redisCache CarInOutParkingLotDto:" + JSON.toJSONString(carInOutParkingLotDto));
        if (carInOutParkingLotDto != null) {
            carInOutParkingLotDto.setCarNum(carNum);
            carInOutParkingLotDto.setCarInOutCurrentTime(inTime);
            carInOutParkingLotDto.setDevCode(devCode);
            carInOutParkingLotDto.setCardNumber(cardNumber);
            return carInOutParkingLotDto;
        }

        ParkParkingLot parkingLot =
                carEnterParkingLotServiceImpl.queryParkingLotInfoByParkCode(channel.getParkCode());
        if (parkingLot == null) {
            return tempDto;
        }
       
        tempDto.setDevCode(devCode);
        tempDto.setCarNum(carNum);
        tempDto.setCardNumber(cardNumber);
        short direct = channel.getDirect().shortValue();
        tempDto.setDirect(direct);
        tempDto.setCarInOutCurrentTime(inTime);
        tempDto.setCarportType(CarportType.INTHEPARK.getType());
        tempDto.setChannelId(channel.getUuid());
        tempDto.setChannelName(channel.getName());
        tempDto.setChannelIP(channel.getIp());
        tempDto.setParkinglotUuid(parkingLot.getUuid());
        tempDto.setParkCode(parkingLot.getParkCode());
        tempDto.setDefaultRuleId(parkingLot.getParkRuleId());
        ParkCar car = carDao.selectCarByCarNum(carNum);
        if (car != null) {
            tempDto.setOwnerId(car.getOwnerId());
            tempDto.setCarMode(car.getCarMode());
            tempDto.setCarType(car.getCarType());
        } else {
            tempDto.setCarType(CarType.TEMPORARY.getType());
        }
        return tempDto;
    }

    /**
     * 刷卡流程处理
     * 
     * @Methods Name swipeEnterParkinglotOperator
     * @Create In 2018年1月10日 By xiaoxiaojie
     * @param carInOutParkingLotDto void
     */
    public void swipeEnterParkinglotOperator(CarInOutParkingLotDto carInOutParkingLotDto,
            ICCardDto icCardDto) {

        if (!carEnterParkingLotServiceImpl.validData(carInOutParkingLotDto))
            return;

        String carNum = carInOutParkingLotDto.getCarNum();
        String ownerId = icCardDto.getOwnerId();
        String parkCode = carInOutParkingLotDto.getParkCode();
        ParkParkingLot parkingLot =
                carEnterParkingLotServiceImpl.queryParkingLotInfoByParkCode(parkCode);
        RuleDto defaultRuleDto =
                carEnterParkingLotServiceImpl.getCarInOutRule(parkingLot.getParkRuleId());
        AuthPackage packageInfo =
                carEnterParkingLotServiceImpl.getAuthPackageInfo(carNum, ownerId, parkCode);
        // 判断是否已开闸
        if (OperateType.AUTO.getType().intValue() == carInOutParkingLotDto.getOperateType()) {
            if (packageInfo != null) {
                carInOutParkingLotDto.setParkPackageId(packageInfo.getId());
                RuleDto ruleDto =
                        carEnterParkingLotServiceImpl.getCarInOutRule(packageInfo.getParkRuleId());
                carInOutParkingLotDto.setRuleDto(ruleDto);
            }
            carEnterParkingLotServiceImpl.handleNoticeAndData(carInOutParkingLotDto,
                    CarEnterMode.BRUSHCARD.getType());
            return;
        }
        if (StringUtils.isBlank(ownerId)) {
            // 开闸指令
            carInOutParkingLotDto.setRuleDto(defaultRuleDto);
            CarInOutDto carInOutDto =
                    carEnterParkingLotServiceImpl.buildCarInOutDtoInfo(carInOutParkingLotDto);
            String isSuccess =
                    roadGateServiceImpl.cutOffRoadGateCommand(carInOutParkingLotDto.getDevCode(),
                            ControlType.OPEN.getType().intValue(), carInOutDto);
            if (Constants.SUCCESS.equals(isSuccess)) {
                carEnterParkingLotServiceImpl.handleNoticeAndData(carInOutParkingLotDto,
                        CarEnterMode.BRUSHCARD.getType());
            } else {
                // 告警通知应用
                logger.error("cutOffRoadGate filad!");
            }
            return;
        }
        if (packageInfo == null) {
            carEnterParkingLotServiceImpl.parkCarByRule(carInOutParkingLotDto, defaultRuleDto);
            return;
        }

        carInOutParkingLotDto.setParkPackageId(packageInfo.getId());
        carInOutParkingLotDto.setCarportType(packageInfo.getCarportType());
        RuleDto ruleDto =
                carEnterParkingLotServiceImpl.getCarInOutRule(packageInfo.getParkRuleId());
        if (DateUtil.compareDate(packageInfo.getValidStartTime(), packageInfo.getValidEndTime(),
                carInOutParkingLotDto.getCarInOutCurrentTime())) {
            int intValue = ruleDto.getRuleDetailDto().getPrivateParkSeatFullTurnTemp().intValue();
            if (carEnterParkingLotServiceImpl.privateCarPortIsFull(ownerId, parkCode)
                    && intValue == MonthCarTurnTemp.MTURN.getType().intValue()) {
                carInOutParkingLotDto.setCarportType(CarportType.INTHEPARK.getType());
                carEnterParkingLotServiceImpl.parkCarByRule(carInOutParkingLotDto, defaultRuleDto);
                return;
            }
            carEnterParkingLotServiceImpl.parkCarByRule(carInOutParkingLotDto, ruleDto);
        } else {
            carEnterParkingLotServiceImpl.handleOverdueMonthCar(carInOutParkingLotDto,
                    defaultRuleDto, ruleDto);
        }


    }

}
