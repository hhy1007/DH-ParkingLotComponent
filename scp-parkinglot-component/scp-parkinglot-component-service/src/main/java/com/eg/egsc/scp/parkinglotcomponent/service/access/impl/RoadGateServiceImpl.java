/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.access.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.eg.egsc.scp.parkinglotcomponent.dao.car.CarDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.hand.ParkHandRecordDao;
import com.eg.egsc.scp.parkinglotcomponent.enmus.alarm.CarType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.alarm.ChannelDirectType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.CarEnterMode;
import com.eg.egsc.scp.parkinglotcomponent.enmus.hand.HandType;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.authpackage.entity.AuthPackage;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCar;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkHandRecord;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkingLot;
import com.eg.egsc.scp.parkinglotcomponent.mq.producer.IotbusProducer;
import com.eg.egsc.scp.parkinglotcomponent.redis.RedisKey;
import com.eg.egsc.scp.parkinglotcomponent.service.access.RoadGateService;
import com.eg.egsc.scp.parkinglotcomponent.service.car.CarEnterParkingLotService;
import com.eg.egsc.scp.parkinglotcomponent.service.car.dto.CarInOutParkingLotDto;
import com.eg.egsc.scp.parkinglotcomponent.service.integration.dto.CarInOutDto;
import com.eg.egsc.scp.parkinglotcomponent.service.park.ParkParkingLotInformationStoredService;
import com.eg.egsc.scp.parkinglotcomponent.service.rule.dto.RuleDto;
import com.eg.egsc.scp.parkinglotcomponent.util.Constants;
import com.eg.egsc.scp.parkinglotcomponent.util.UuidUtil;

@Service
public class RoadGateServiceImpl implements RoadGateService {


    @Autowired
    IotbusProducer senderIotbus;

    @Autowired
    private ParkHandRecordDao parkHandRecordDao;// 异常操作DAO

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    private CarEnterParkingLotService carEnterParkingLotServiceImpl;

    @Autowired
    private CarDao carDao;

    @Autowired
    private ParkParkingLotInformationStoredService parkParkingLotInformationStoredServiceImpl;// 储存信息

    @Override
    public String cutOffRoadGateCommand(String devCode, int controlType, CarInOutDto carInOutDto) {

        /*
         * 1.根据设备编号判断设备是否在线，不在线直接返回"设备不在线"
         */
        // 2.设备在线，封装开闸指令，发送信息到mq
        Map<String, String> message = new HashMap<>();
        message.put("devCode", devCode);
        message.put("operatorType", controlType + "");
        message.put("carInOutDto", JSONObject.toJSONString(carInOutDto));
        senderIotbus.sendBarrierCommandToIot(message, UuidUtil.generate(), devCode);
        if (ChannelDirectType.EXPROTATION.getType().shortValue() == carInOutDto.getDirect()) {// 出场
            parkParkingLotInformationStoredServiceImpl.storeCarInformation(carInOutDto);
        }
        return Constants.SUCCESS;
    }


    @Override
    public String manualCutOffRoadGateCommand(String devCode, int controlType,
            CarInOutDto carInOutDto, String staffId, String staffName) {
        /*
         * 1.根据设备编号判断设备是否在线，不在线直接返回"设备不在线"
         */
        // 2.设备在线，封装开闸指令，发送信息到mq
        cutOffRoadGateCommand(devCode, controlType, carInOutDto);
        String cameraCode = carInOutDto.getDevCode();
        ParkHandRecord parkHandRecord = new ParkHandRecord();
        parkHandRecord.setUuid(UuidUtil.generate());
        parkHandRecord.setCameraCode(cameraCode);
        parkHandRecord.setCarNum(carInOutDto.getCarNum());
        parkHandRecord.setChannelId(carInOutDto.getChannelId());
        parkHandRecord.setCreateUser(staffId);
        parkHandRecord.setCreateUserName(staffName);
        parkHandRecord.setCreateTime(new Date());
        parkHandRecord.setImgUrl(carInOutDto.getOutCarPic());
        parkHandRecord.setNumUrl(carInOutDto.getOutNumUrl());
        parkHandRecord.setOwnerId(carInOutDto.getOwnerId());
        parkHandRecord.setParkCode(carInOutDto.getParkCode());
        parkHandRecord.setType(HandType.MANUAL.getType());
        this.parkHandRecordDao.insertOneParkHandRecord(parkHandRecord);

        return Constants.SUCCESS;
    }

    public void confirmCutOffRoadGateCommand(String devCode, int controlType,
            CarInOutDto carInOutDto) {
        // 调用开闸指令
        cutOffRoadGateCommand(devCode, controlType, carInOutDto);
        if (ChannelDirectType.EXPROTATION.getType().shortValue() == carInOutDto.getDirect()) {// 出场
            parkParkingLotInformationStoredServiceImpl.storeCarInformation(carInOutDto);
            return;
        }
        String channelId = carInOutDto.getChannelId();
        if (StringUtils.isBlank(channelId))
            return;
        String carNum = carInOutDto.getCarNum();
        // 获取缓存信息
        CarInOutParkingLotDto carInOutParkingLotDto = (CarInOutParkingLotDto) redisTemplate
                .opsForHash().get(RedisKey.KEY_CHANNEL_ID, channelId);
        if (carInOutParkingLotDto != null
                && carNum.equalsIgnoreCase(carInOutParkingLotDto.getCarNum())) {
            carEnterParkingLotServiceImpl.saveCarInOutData(carInOutParkingLotDto,
                    CarEnterMode.MANUAL.getType());
            return;
        }

        ParkCar car = carDao.selectCarByCarNum(carNum);
        RuleDto ruleDto = null;
        AuthPackage packageInfo = carEnterParkingLotServiceImpl.getAuthPackageInfo(carNum,
                carInOutDto.getOwnerId(), carInOutDto.getParkCode());
        if (packageInfo != null) {
            ruleDto = carEnterParkingLotServiceImpl.getCarInOutRule(packageInfo.getParkRuleId());
        }
        ParkChannel channel = carEnterParkingLotServiceImpl.getChannelInfo(devCode);
        ParkParkingLot parkingLot = carEnterParkingLotServiceImpl
                .queryParkingLotInfoByParkCode(carInOutDto.getParkCode());
        if (channel == null || parkingLot == null) {
            return;
        }
        if (carInOutParkingLotDto == null) {
            carInOutParkingLotDto = new CarInOutParkingLotDto();
            carInOutParkingLotDto.setDevCode(carInOutDto.getDevCode());
            carInOutParkingLotDto.setChannelId(channel.getUuid());
            carInOutParkingLotDto.setChannelName(channel.getName());
            carInOutParkingLotDto.setChannelIP(channel.getIp());
            carInOutParkingLotDto.setCarInOutCurrentTime(carInOutDto.getInTime());
            carInOutParkingLotDto.setOperateType(carInOutDto.getControlType());
            carInOutParkingLotDto.setCardNumber(carInOutDto.getCardNumber());
            carInOutParkingLotDto.setCarMode(carInOutDto.getCarMode());
            carInOutParkingLotDto.setCarportType(carInOutDto.getCarportType());
            carInOutParkingLotDto.setDirect(carInOutDto.getDirect());
            carInOutParkingLotDto.setImgUrl(carInOutDto.getInImgUrl());
            carInOutParkingLotDto.setParkinglotUuid(parkingLot.getUuid());
            carInOutParkingLotDto.setParkCode(parkingLot.getParkCode());
            carInOutParkingLotDto.setDefaultRuleId(parkingLot.getParkRuleId());
            carInOutParkingLotDto.setParkPackageId(carInOutDto.getParkPackageId());
            carInOutParkingLotDto.setCarNum(carNum);
            if (car != null) {
                carInOutParkingLotDto.setOwnerId(car.getOwnerId());
                carInOutParkingLotDto.setCarMode(car.getCarMode());
                carInOutParkingLotDto.setCarType(car.getCarType());
            } else {
                carInOutParkingLotDto.setCarType(CarType.TEMPORARY.getType());
            }
            carInOutParkingLotDto.setRuleDto(ruleDto);
            carEnterParkingLotServiceImpl.saveCarInOutData(carInOutParkingLotDto,
                    CarEnterMode.MANUAL.getType());
            return;
        }
        merge(carNum, carInOutParkingLotDto, car, ruleDto, packageInfo);
    }


    public void merge(String carNum, CarInOutParkingLotDto carInOutParkingLotDto, ParkCar car,
            RuleDto ruleDto, AuthPackage packageInfo) {
        if (!carNum.equalsIgnoreCase(carInOutParkingLotDto.getCarNum())) {
            carInOutParkingLotDto.setCarNum(carNum);
            if (car != null) {
                carInOutParkingLotDto.setOwnerId(car.getOwnerId());
                carInOutParkingLotDto.setCarMode(car.getCarMode());
                carInOutParkingLotDto.setCarType(car.getCarType());
            } else {
                carInOutParkingLotDto.setCarType(CarType.TEMPORARY.getType());
            }
            carInOutParkingLotDto.setRuleDto(ruleDto);
            if (packageInfo != null) {
                carInOutParkingLotDto.setParkPackageId(packageInfo.getId());
            }
        }
        carEnterParkingLotServiceImpl.saveCarInOutData(carInOutParkingLotDto,
                CarEnterMode.MANUAL.getType());
    }
}

