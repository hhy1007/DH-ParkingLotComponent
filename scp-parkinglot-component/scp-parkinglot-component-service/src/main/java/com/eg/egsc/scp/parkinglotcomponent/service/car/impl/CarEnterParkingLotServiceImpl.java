/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.car.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.eg.egsc.scp.mdm.component.client.UserClient;
import com.eg.egsc.scp.mdm.component.dto.BaseUserDto;
import com.eg.egsc.scp.parkinglotcomponent.common.result.ResultCode;
import com.eg.egsc.scp.parkinglotcomponent.common.result.ResultMessage;
import com.eg.egsc.scp.parkinglotcomponent.condition.authpackage.ParkAuthPackageCondition;
import com.eg.egsc.scp.parkinglotcomponent.dao.access.AccessCurDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.car.CarDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.channel.ParkChannelRelDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.park.ParkParkingLotDao;
import com.eg.egsc.scp.parkinglotcomponent.enmus.OperateType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.alarm.CarType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.alarm.ChannelDirectType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.alarm.ControlType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.alarm.OpenWay;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.CarColorType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.CarEnterMode;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.CarListType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.CarModeType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.CarStatus;
import com.eg.egsc.scp.parkinglotcomponent.enmus.carport.CarportType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.channel.ChannelDevType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.rule.MonthCarTurnTemp;
import com.eg.egsc.scp.parkinglotcomponent.enmus.rule.MonthCarTurnTempType;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.authpackage.AuthPackageMapper;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.authpackage.entity.AuthPackage;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkAccessCurMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkCarportMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkChannelMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkChannelRelMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkParkingLotMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkReservationMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkRuleMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAccessCur;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAccessCurCriteria;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAccessHis;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCar;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarCapture;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannelRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannelRelCriteria;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkingLot;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkingLotCriteria;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkReservation;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkReservationCriteria;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkRule;
import com.eg.egsc.scp.parkinglotcomponent.redis.RedisKey;
import com.eg.egsc.scp.parkinglotcomponent.service.access.impl.RoadGateServiceImpl;
import com.eg.egsc.scp.parkinglotcomponent.service.car.CarEnterParkingLotService;
import com.eg.egsc.scp.parkinglotcomponent.service.car.dto.CarInOutParkingLotDto;
import com.eg.egsc.scp.parkinglotcomponent.service.car.dto.PictureCaptureDto;
import com.eg.egsc.scp.parkinglotcomponent.service.carcapture.CarCaptureService;
import com.eg.egsc.scp.parkinglotcomponent.service.integration.IntegrationAppService;
import com.eg.egsc.scp.parkinglotcomponent.service.integration.dto.CarInOutDto;
import com.eg.egsc.scp.parkinglotcomponent.service.integration.dto.IdleChangeDto;
import com.eg.egsc.scp.parkinglotcomponent.service.park.ParkAccessCurService;
import com.eg.egsc.scp.parkinglotcomponent.service.park.ParkAccessHisService;
import com.eg.egsc.scp.parkinglotcomponent.service.rule.dto.RuleDetailDto;
import com.eg.egsc.scp.parkinglotcomponent.service.rule.dto.RuleDto;
import com.eg.egsc.scp.parkinglotcomponent.util.Constants;
import com.eg.egsc.scp.parkinglotcomponent.util.DateUtil;
import com.eg.egsc.scp.parkinglotcomponent.util.UuidUtil;



@Service
public class CarEnterParkingLotServiceImpl implements CarEnterParkingLotService {


    protected final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private ParkChannelRelDao parkChannelRelDao;// 数据库自定义操作接口

    @Autowired
    private ParkChannelRelMapper parkChannelRelMapper;

    @Autowired
    private ParkChannelMapper parkChannelMapper;// 车道信息表

    @Autowired
    private CarDao carDao;

    @Autowired
    private ParkParkingLotDao parkParkingLotDao;// 车场信息

    @Autowired
    private ParkParkingLotMapper parkParkingLotMapper;

    @Autowired
    ParkCarportMapper parkCarportMapper;// 车位表

    @Autowired
    private AuthPackageMapper authPackageMapper;// 自定义授权套餐

    @Autowired
    private ParkRuleMapper parkRuleMapper;// 规则表

    @Autowired
    private ParkReservationMapper parkReservationMapper;// 预约登记表

    @Autowired
    private RoadGateServiceImpl roadGateServiceImpl;// 道闸服务

    @Autowired
    private ParkAccessCurService parkAccessCurServiceImpl;

    @Autowired
    private ParkAccessCurMapper parkAccessCurMapper;

    @Autowired
    private AccessCurDao accessCurDao;

    @Autowired
    private ParkAccessHisService parkAccessHisServiceImpl;

    @Autowired
    private CarCaptureService carCaptureServiceImpl;

    @Autowired
    private IntegrationAppService integrationAppServiceImpl;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    private UserClient userClientImpl;// 主数据服务

    /**
     * 初始化车辆进出停车场Dto类
     * 
     * @Methods Name initCarEnterParkingLotDto
     * @Create In 2017年12月22日 By xiaoxiaojie
     * @param devCode
     * @param carNum
     * @return CarEnterParkingLotDto
     */
    public CarInOutParkingLotDto initCarEnterParkingLotDto(PictureCaptureDto pictureCaptureDto) {
        Date currentTime = new Date();
        CarInOutParkingLotDto carEnterParkingLotDto = new CarInOutParkingLotDto();
        String devCode = pictureCaptureDto.getDevCode();
        String carNum = pictureCaptureDto.getCarNum();
        String numColor = pictureCaptureDto.getCarNumColor();
        if (CarColorType.YELLOW.getType().equalsIgnoreCase(numColor)) {
            carEnterParkingLotDto.setCarMode(CarModeType.BIGCART.getType());
        } else {
            carEnterParkingLotDto.setCarMode(CarModeType.SMALLCAR.getType());
        }
        carEnterParkingLotDto.setDevCode(devCode);
        carEnterParkingLotDto.setCarNum(carNum);
        carEnterParkingLotDto.setOperateType(pictureCaptureDto.getControlType());
        carEnterParkingLotDto.setImgUrl(pictureCaptureDto.getImgUrl());
        carEnterParkingLotDto.setNumUrl(pictureCaptureDto.getNumUrl());

        ParkChannel channel = getChannelInfo(devCode);

        if (channel == null) {
            return carEnterParkingLotDto;
        }
        carEnterParkingLotDto.setChannelId(channel.getUuid());
        carEnterParkingLotDto.setChannelName(channel.getName());
        carEnterParkingLotDto.setChannelIP(channel.getIp());
        ParkParkingLot parkingLot = queryParkingLotInfoByParkCode(channel.getParkCode());
        if (parkingLot == null) {
            return carEnterParkingLotDto;
        }
        carEnterParkingLotDto.setParkinglotUuid(parkingLot.getUuid());
        carEnterParkingLotDto.setParkCode(parkingLot.getParkCode());
        carEnterParkingLotDto.setDefaultRuleId(parkingLot.getParkRuleId());
        short direct = judgeChannelDirect(channel);
        carEnterParkingLotDto.setDirect(direct);
        carEnterParkingLotDto.setCarInOutCurrentTime(currentTime);
        carEnterParkingLotDto.setCarportType(CarportType.INTHEPARK.getType());
        ParkCar car = getCarInfoByCarNum(carNum);
        if (car != null) {
            carEnterParkingLotDto.setOwnerId(car.getOwnerId());
            carEnterParkingLotDto.setCarMode(car.getCarMode());
            carEnterParkingLotDto.setCarType(car.getCarType());
        } else {
            carEnterParkingLotDto.setCarType(CarType.TEMPORARY.getType());
        }
        return carEnterParkingLotDto;
    }

    /**
     * 处理车辆进场逻辑
     * 
     * @Methods Name carEnterParkingLotOperator
     * @Create In 2017年12月22日 By xiaoxiaojie
     * @param carInOutParkingLotDto void
     */
    public void carEnterParkingLotOperator(CarInOutParkingLotDto carInOutParkingLotDto) {

        if (!validData(carInOutParkingLotDto))
            return;

        String carNum = carInOutParkingLotDto.getCarNum();
        ParkCar car = getCarInfoByCarNum(carNum);
        // 保存抓拍记录
        saveCarCaptureService(carInOutParkingLotDto, car);


        // 判断是否已开闸
        if (OperateType.AUTO.getType().intValue() == carInOutParkingLotDto.getOperateType()) {
            handleCutOffCar(carInOutParkingLotDto, carNum, car);
            return;
        }

        RuleDto defaultRuleDto = getCarInOutRule(carInOutParkingLotDto.getDefaultRuleId());
        if (StringUtils.isBlank(carNum)) {
            // 无牌车辆，通知应用，人工开闸或发卡
            carInOutParkingLotDto.setOperateType(OperateType.MANUAL.getType().intValue());
            carInOutParkingLotDto.setRuleDto(defaultRuleDto);
            String channelId = carInOutParkingLotDto.getChannelId();
            redisTemplate.opsForHash().put(RedisKey.KEY_CHANNEL_ID, channelId,
                    carInOutParkingLotDto);
            carEnterParkingLotNotice(carInOutParkingLotDto);
            return;
        }

        if (car == null) {
            // 外部车辆，查询预约登记表
            handleOutCarEnterParkinglot(carInOutParkingLotDto, carNum, defaultRuleDto);
            return;
        }
        String ownerId = car.getOwnerId();
        String parkCode = carInOutParkingLotDto.getParkCode();
        AuthPackage authPackage = getAuthPackageInfo(carNum, ownerId, parkCode);
        // 黑名单车
        if (CarListType.BLACK.getType() == car.getListType().shortValue()) {
            // 不是放行，通知停车场应用
            carInOutParkingLotDto.setOperateType(OperateType.MANUAL.getType().intValue());
            carInOutParkingLotDto.setRuleDto(defaultRuleDto);
            if (authPackage != null) {
                carInOutParkingLotDto.setParkPackageId(authPackage.getId());
                carInOutParkingLotDto.setRuleDto(getCarInOutRule(authPackage.getParkRuleId()));
            }
            carEnterParkingLotNotice(carInOutParkingLotDto);
            return;
        }

        if (car.getCarType().intValue() == CarType.SPECIALVEHICLE.getType().intValue()) {
            // 特殊车辆，调用开闸指令 直接放行。
            handleSpecialCarEnterParkinglot(carInOutParkingLotDto, car, defaultRuleDto);
            return;
        }

        // 普通车进场逻辑
        if (authPackage == null) {
            // 临停
            parkCarByRule(carInOutParkingLotDto, defaultRuleDto);
            return;
        }
        carInOutParkingLotDto.setParkPackageId(authPackage.getId());
        carInOutParkingLotDto.setCarportType(authPackage.getCarportType());
        RuleDto ruleDto = getCarInOutRule(authPackage.getParkRuleId());
        if (DateUtil.compareDate(authPackage.getValidStartTime(), authPackage.getValidEndTime(),
                carInOutParkingLotDto.getCarInOutCurrentTime())) {
            // 判断个人车位是否已满
            int isTurnTemp = ruleDto.getRuleDetailDto().getPrivateParkSeatFullTurnTemp().intValue();
            if (privateCarPortIsFull(ownerId, parkCode)
                    && isTurnTemp == MonthCarTurnTemp.MTURN.getType().intValue()) {
                carInOutParkingLotDto.setCarportType(CarportType.INTHEPARK.getType());
                parkCarByRule(carInOutParkingLotDto, defaultRuleDto);
                return;
            }
            parkCarByRule(carInOutParkingLotDto, ruleDto);
        } else {
            handleOverdueMonthCar(carInOutParkingLotDto, defaultRuleDto, ruleDto);
        }

    }

    /**
     * 处理过期的月保产权车
     * 
     * @Methods Name HandleOverdueMonthCar
     * @Create In 2018年1月22日 By xiaoxiaojie
     * @param carInOutParkingLotDto
     * @param defaultRuleDto
     * @param ruleDto void
     */
    public void handleOverdueMonthCar(CarInOutParkingLotDto carInOutParkingLotDto,
            RuleDto defaultRuleDto, RuleDto ruleDto) {
        MonthCarTurnTempType carTurnTempType =
                MonthCarTurnTempType.getEnum(ruleDto.getRuleDetailDto().getMonthCarEndTurnTemp());
        switch (carTurnTempType) {
            case KEEPMONTHCAR:
                logger.debug("KEEPMONTHCAR");
                parkCarByRule(carInOutParkingLotDto, ruleDto);
                break;
            case TURNTEMP:
                logger.debug("TURNTEMP");
                carInOutParkingLotDto.setCarportType(CarportType.INTHEPARK.getType());
                parkCarByRule(carInOutParkingLotDto, defaultRuleDto);
                break;
            case NOENTRY:
                logger.debug("NOENTRY");
                // 不让进
                break;
            default:
                break;
        }
    }

    /**
     * 判断个人车位是否已满
     * 
     * @Methods Name privateCarPortIsFull
     * @Create In 2018年1月22日 By xiaoxiaojie
     * @param ownerId
     * @param parkCode
     * @return boolean
     */
    public boolean privateCarPortIsFull(String ownerId, String parkCode) {
        ParkAuthPackageCondition condition = new ParkAuthPackageCondition();
        condition.setOwnerId(ownerId);
        condition.setParkCode(parkCode);
        List<AuthPackage> lists = authPackageMapper.selectByExample(condition);
        if (CollectionUtils.isEmpty(lists)) {
            return true;
        }
        List<String> packageIds = new ArrayList<>();
        for (AuthPackage list : lists) {
            packageIds.add(list.getId());
        }
        int count = accessCurDao.countByPackageIds(packageIds);
        return lists.size() <= count;
    }

    /**
     * 处理已经开闸的车辆入场
     * 
     * @Methods Name handleCutOffCar
     * @Create In 2018年1月5日 By xiaoxiaojie
     * @param carInOutParkingLotDto
     * @param carNum
     * @param car void
     */
    private void handleCutOffCar(CarInOutParkingLotDto carInOutParkingLotDto, String carNum,
            ParkCar car) {
        if (car != null) {
            AuthPackage packageInfo = getAuthPackageInfo(carNum, car.getOwnerId(),
                    carInOutParkingLotDto.getParkCode());
            if (packageInfo != null) {
                carInOutParkingLotDto.setParkPackageId(packageInfo.getId());
                carInOutParkingLotDto.setRuleDto(getCarInOutRule(packageInfo.getParkRuleId()));
            }
        }

        handleNoticeAndData(carInOutParkingLotDto, CarEnterMode.AUTO.getType());
    }

    /**
     * 特殊车入场逻辑处理
     * 
     * @Methods Name handleSpecialCarEnterParkinglot
     * @Create In 2018年1月4日 By xiaoxiaojie
     * @param carInOutParkingLotDto
     * @param car
     * @param defaultRuleDto void
     */
    private void handleSpecialCarEnterParkinglot(CarInOutParkingLotDto carInOutParkingLotDto,
            ParkCar car, RuleDto defaultRuleDto) {
        carInOutParkingLotDto.setRuleDto(defaultRuleDto);
        if (DateUtil.compareDate(car.getValidStartTime(), car.getValidEndTime(),
                carInOutParkingLotDto.getCarInOutCurrentTime())) {
            AuthPackage packageInfo = getAuthPackageInfo(carInOutParkingLotDto.getCarNum(),
                    car.getOwnerId(), carInOutParkingLotDto.getParkCode());
            if (packageInfo != null) {
                carInOutParkingLotDto.setParkPackageId(packageInfo.getId());
                carInOutParkingLotDto.setRuleDto(getCarInOutRule(packageInfo.getParkRuleId()));
            }
            carInOutParkingLotDto.setOperateType(OperateType.AUTO.getType().intValue());
            handleCutOffAndNotice(carInOutParkingLotDto, CarEnterMode.AUTO.getType());
        } else {
            // 临停
            parkCarByRule(carInOutParkingLotDto, defaultRuleDto);
        }
    }

    /**
     * 处理外部车入场逻辑
     * 
     * @Methods Name handleOutCarEnterParkinglot
     * @Create In 2018年1月4日 By xiaoxiaojie
     * @param carInOutParkingLotDto
     * @param carNum
     * @param defaultRuleDto void
     */
    private void handleOutCarEnterParkinglot(CarInOutParkingLotDto carInOutParkingLotDto,
            String carNum, RuleDto defaultRuleDto) {
        carInOutParkingLotDto.setRuleDto(defaultRuleDto);
        ParkReservation parkReservation =
                getReservationInfoByCarNum(carNum, carInOutParkingLotDto.getParkCode());
        if (parkReservation != null && DateUtil.compareDate(parkReservation.getStartTime(),
                parkReservation.getEndTime(), carInOutParkingLotDto.getCarInOutCurrentTime())) {
            carInOutParkingLotDto.setOperateType(OperateType.AUTO.getType().intValue());
            handleCutOffAndNotice(carInOutParkingLotDto, CarEnterMode.RESERVED.getType());
        } else {
            // 临停
            parkCarByRule(carInOutParkingLotDto, defaultRuleDto);
        }
    }

    /**
     * 开闸处理函数
     * 
     * @Methods Name handleCutOffAndNotice
     * @Create In 2018年1月4日 By xiaoxiaojie
     * @param carInOutParkingLotDto void
     */
    public void handleCutOffAndNotice(CarInOutParkingLotDto carInOutParkingLotDto,
            Short enterMode) {
        String isSuccess = roadGateServiceImpl.cutOffRoadGateCommand(
                carInOutParkingLotDto.getDevCode(), ControlType.OPEN.getType().intValue(),
                buildCarInOutDtoInfo(carInOutParkingLotDto));
        if (Constants.SUCCESS.equals(isSuccess)) {
            handleNoticeAndData(carInOutParkingLotDto, enterMode);
        } else {
            logger.error("cutOffRoadGate filad!");
            carEnterParkingLotNotice(carInOutParkingLotDto);
        }
    }

    /**
     * 封装车辆入场dto信息
     * 
     * @Methods Name buildCarInOutDtoInfo
     * @Create In 2018年1月8日 By xiaoxiaojie
     * @param carInOutParkingLotDto
     * @return CarInOutDto
     */
    public CarInOutDto buildCarInOutDtoInfo(CarInOutParkingLotDto carInOutParkingLotDto) {
        CarInOutDto carInOutDto = new CarInOutDto();
        carInOutDto.setCarNum(carInOutParkingLotDto.getCarNum());
        RuleDto ruleDto = carInOutParkingLotDto.getRuleDto();
        String ownerId = carInOutParkingLotDto.getOwnerId();
        carInOutDto.setOwnerId(ownerId);
        carInOutDto.setOwnerName(getOwnerNameById(ownerId));
        short carType = null == carInOutParkingLotDto.getCarType() ? (short) 0
                : carInOutParkingLotDto.getCarType();
        carInOutDto.setCarType(carType);
        carInOutDto.setCarMode(carInOutParkingLotDto.getCarMode());
        if (ruleDto != null) {
            carInOutDto.setRuleName(ruleDto.getRuleName());
        }
        carInOutDto.setDirect(carInOutParkingLotDto.getDirect());
        carInOutDto.setParkPackageId(carInOutParkingLotDto.getParkPackageId());
        carInOutDto.setCardNumber(carInOutParkingLotDto.getCardNumber());
        carInOutDto.setCarportType(carInOutParkingLotDto.getCarportType());
        carInOutDto.setControlType(carInOutParkingLotDto.getOperateType());
        carInOutDto.setInTime(carInOutParkingLotDto.getCarInOutCurrentTime());
        carInOutDto.setChannelId(carInOutParkingLotDto.getChannelId());
        carInOutDto.setChannelName(carInOutParkingLotDto.getChannelName());
        carInOutDto.setChannelIp(carInOutParkingLotDto.getChannelIP());
        carInOutDto.setInImgUrl(carInOutParkingLotDto.getImgUrl());
        carInOutDto.setDevCode(carInOutParkingLotDto.getDevCode());
        carInOutDto.setParkCode(carInOutParkingLotDto.getParkCode());
        return carInOutDto;
    }

    /**
     * 根据进出规则处理车辆入场
     * 
     * @Methods Name parkCarByRule
     * @Create In 2018年1月4日 By xiaoxiaojie
     * @param carInOutParkingLotDto
     * @param ruleDto void
     */
    public void parkCarByRule(CarInOutParkingLotDto carInOutParkingLotDto, RuleDto ruleDto) {
        if (ruleDto == null || ruleDto.getRuleDetailDto() == null) {
            logger.error("ruleDto is null or get RuleDetailDto is null!");
            // 不自动放行，通知停车场应用
            carInOutParkingLotDto.setOperateType(OperateType.MANUAL.getType().intValue());
            redisTemplate.opsForHash().put(RedisKey.KEY_CHANNEL_ID,
                    carInOutParkingLotDto.getChannelId(), carInOutParkingLotDto);
            carEnterParkingLotNotice(carInOutParkingLotDto);
            return;
        }
        carInOutParkingLotDto.setRuleDto(ruleDto);
        int way = ruleDto.getRuleDetailDto().getOpenWay().intValue();
        if (way == OpenWay.INTOUTLOTBYMACHINE.getType().intValue()
                || way == OpenWay.OUTLOTBYMAN.getType().intValue()) {
            carInOutParkingLotDto.setOperateType(OperateType.AUTO.getType().intValue());
            handleCutOffAndNotice(carInOutParkingLotDto, CarEnterMode.AUTO.getType());
        } else {
            // 不是自动放行，通知停车场应用
            carInOutParkingLotDto.setOperateType(OperateType.MANUAL.getType().intValue());
            redisTemplate.opsForHash().put(RedisKey.KEY_CHANNEL_ID,
                    carInOutParkingLotDto.getChannelId(), carInOutParkingLotDto);
            carEnterParkingLotNotice(carInOutParkingLotDto);
        }
    }

    /**
     * 验证车辆入场数据
     * 
     * @Methods Name validData
     * @Create In 2018年1月4日 By xiaoxiaojie
     * @param carInOutParkingLotDto
     * @return boolean
     */
    public boolean validData(CarInOutParkingLotDto carInOutParkingLotDto) {
        return !(carInOutParkingLotDto.getDirect() != ChannelDirectType.ENTRANCE.getType()
                || StringUtils.isBlank(carInOutParkingLotDto.getChannelId())
                || StringUtils.isBlank(carInOutParkingLotDto.getParkinglotUuid()));
    }

    /**
     * 处理停车场应用通知和保存数据方法
     * 
     * @Methods Name handleNoticeAndData
     * @Create In 2018年1月4日 By xiaoxiaojie
     * @param carInOutParkingLotDto void
     */
    public void handleNoticeAndData(CarInOutParkingLotDto carInOutParkingLotDto, Short enterMode) {
        // 保存结构化数据
        saveCarInOutData(carInOutParkingLotDto, enterMode);
        // 通知停车场应用
        carEnterParkingLotNotice(carInOutParkingLotDto);
    }

    /**
     * 车辆入场通知停车场App
     * 
     * @Methods Name carEnterParkingLotNotice
     * @Create In 2017年12月28日 By xiaoxiaojie void
     */
    public void carEnterParkingLotNotice(CarInOutParkingLotDto carInOutParkingLotDto) {
        CarInOutDto carInOutDto = buildCarInOutDtoInfo(carInOutParkingLotDto);
        integrationAppServiceImpl.carInOutEvent(carInOutDto);
    }

    /**
     * 保存结构化数据，1.在场车辆记录表。2.停车历史记录表。3.余位。
     * 
     * @Methods Name saveCarInOutData
     * @Create In 2017年12月28日 By xiaoxiaojie
     * @param carInOutParkingLotDto void
     */
    public void saveCarInOutData(CarInOutParkingLotDto carInOutParkingLotDto, Short enterMode) {

        String uuid = UuidUtil.generate();
        saveParkAccessCurInfo(carInOutParkingLotDto, uuid, enterMode);
        saveParkAccessHisInfo(carInOutParkingLotDto, uuid, enterMode);
        // 更新停车场余位-1
        noticeParkingLotAppIdleChanged(carInOutParkingLotDto);
        parkParkingLotDao.updateParkingLotSelfReductionOrSelfAdd(
                carInOutParkingLotDto.getParkinglotUuid(), false);

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.eg.egsc.scp.parkinglotcomponent.service.car.ICarEnterParkingLotService#modifyCarInOutDto(
     * com.eg.egsc.scp.parkinglotcomponent.service.integration.dto.CarInOutDto)
     */
    @Override
    public ResultMessage modifyCarInOutDto(CarInOutDto carInOutDto) {
        String carNum = carInOutDto.getCarNum();
        if (StringUtils.isBlank(carNum)) {
            return ResultMessage.createErrorResult(ResultCode.FAILED, "车牌不能为空", null);
        }
        ParkAccessCurCriteria duc = new ParkAccessCurCriteria();
        ParkAccessCurCriteria.Criteria ducc = duc.createCriteria();
        ducc.andCarNumEqualTo(carNum);
        List<ParkAccessCur> list = parkAccessCurMapper.selectByExample(duc);
        if (CollectionUtils.isNotEmpty(list)) {
            return ResultMessage.createErrorResult(ResultCode.FAILED, "停车场已存在该车辆", null);
        }
        ParkCar car = getCarInfoByCarNum(carNum);
        ParkParkingLot parkingLot = queryParkingLotInfoByParkCode(carInOutDto.getParkCode());
        if (car != null) {
            carInOutDto.setOwnerId(car.getOwnerId());
            carInOutDto.setOwnerName(getOwnerNameById(car.getOwnerId()));
            AuthPackage authPackage =
                    getAuthPackageInfo(carNum, car.getOwnerId(), carInOutDto.getParkCode());
            if (authPackage != null) {
                RuleDto inOutRule = getCarInOutRule(authPackage.getParkRuleId());
                carInOutDto.setParkPackageId(authPackage.getId());
                if (inOutRule != null) {
                    carInOutDto.setRuleName(inOutRule.getRuleName());
                } else {
                    if (parkingLot != null) {
                        RuleDto outRule = getCarInOutRule(parkingLot.getParkRuleId());
                        carInOutDto.setRuleName(outRule.getRuleName());
                    }
                }
            }
        }
        return ResultMessage.createSuccessResult(carInOutDto);
    }

    /**
     * 通知停车场app余位更新
     * 
     * @Methods Name noticeParkingLotAppIdleChanged
     * @Create In 2017年12月28日 By xiaoxiaojie
     * @param carInOutParkingLotDto void
     */
    public void noticeParkingLotAppIdleChanged(CarInOutParkingLotDto carInOutParkingLotDto) {
        ParkParkingLot parkingLot =
                queryParkingLotInfoByParkCode(carInOutParkingLotDto.getParkCode());
        IdleChangeDto idleChangeDto = new IdleChangeDto();
        idleChangeDto.setParkCode(carInOutParkingLotDto.getParkCode());
        idleChangeDto.setCurChange(1);
        idleChangeDto.setTotal(parkingLot.getTotal());
        if (null == parkingLot.getIdle()) {
            idleChangeDto.setIdle(0);
        } else {
            idleChangeDto.setIdle(parkingLot.getIdle().intValue() - 1);
        }
        integrationAppServiceImpl.idleChangeEvent(idleChangeDto);
    }

    /**
     * 保存在场车辆记录表
     * 
     * @Methods Name saveParkAccessCurInfo
     * @Create In 2017年12月28日 By xiaoxiaojie
     * @param carInOutParkingLotDto
     * @param uuid void
     */
    public void saveParkAccessCurInfo(CarInOutParkingLotDto carInOutParkingLotDto, String uuid,
            Short enterMode) {
        ParkAccessCur accessCur = new ParkAccessCur();
        accessCur.setUuid(uuid);
        accessCur.setCarNum(carInOutParkingLotDto.getCarNum());
        accessCur.setOwnerId(carInOutParkingLotDto.getOwnerId());
        accessCur.setCarType(carInOutParkingLotDto.getCarType());
        accessCur.setCarMode(carInOutParkingLotDto.getCarMode());
        accessCur.setCardNumber(carInOutParkingLotDto.getCardNumber());
        accessCur.setParkCode(carInOutParkingLotDto.getParkCode());
        accessCur.setCarportType(carInOutParkingLotDto.getCarportType());
        accessCur.setParkPackageId(carInOutParkingLotDto.getParkPackageId());
        accessCur.setInChannelId(carInOutParkingLotDto.getChannelId());
        accessCur.setCreateTime(carInOutParkingLotDto.getCarInOutCurrentTime());
        accessCur.setUpdateTime(carInOutParkingLotDto.getCarInOutCurrentTime());
        accessCur.setInCameraCode(carInOutParkingLotDto.getDevCode());
        accessCur.setInImgUrl(carInOutParkingLotDto.getImgUrl());
        accessCur.setInNumUrl(carInOutParkingLotDto.getNumUrl());
        accessCur.setEnterMode(enterMode);
        parkAccessCurServiceImpl.insert(accessCur);
    }

    /**
     * 保存停车历史记录表
     * 
     * @Methods Name saveParkAccessHisInfo
     * @Create In 2017年12月28日 By xiaoxiaojie
     * @param carInOutParkingLotDto
     * @param uuid void
     */
    public void saveParkAccessHisInfo(CarInOutParkingLotDto carInOutParkingLotDto, String uuid,
            Short enterMode) {
        ParkAccessHis accessHis = new ParkAccessHis();
        accessHis.setUuid(uuid);
        accessHis.setCarNum(carInOutParkingLotDto.getCarNum());
        accessHis.setOwnerId(carInOutParkingLotDto.getOwnerId());
        accessHis.setCarType(carInOutParkingLotDto.getCarType());
        accessHis.setCarMode(carInOutParkingLotDto.getCarMode());
        accessHis.setCardNumber(carInOutParkingLotDto.getCardNumber());
        accessHis.setPackageId(carInOutParkingLotDto.getParkPackageId());
        accessHis.setParkCode(carInOutParkingLotDto.getParkCode());
        accessHis.setCarportType(carInOutParkingLotDto.getCarportType());
        accessHis.setInChannelId(carInOutParkingLotDto.getChannelId());
        accessHis.setCreateTime(carInOutParkingLotDto.getCarInOutCurrentTime());
        accessHis.setUpdateTime(carInOutParkingLotDto.getCarInOutCurrentTime());
        accessHis.setInCameraCode(carInOutParkingLotDto.getDevCode());
        accessHis.setInImgUrl(carInOutParkingLotDto.getImgUrl());
        String gateDevCode = queryBarrierGateDevCode(accessHis.getInChannelId(),
                ChannelDevType.BARRIERGATE.getType());// 道闸设备编号
        accessHis.setInSluiceCode(gateDevCode);
        accessHis.setEnterMode(enterMode);// 自动识别
        accessHis.setCarStatus(CarStatus.ENTER.getStatus());// 入场
        parkAccessHisServiceImpl.insert(accessHis);
    }

    /**
     * 保存抓拍记录表
     * 
     * @Methods Name saveCarCaptureService
     * @Create In 2017年12月28日 By xiaoxiaojie
     * @param carInOutParkingLotDto void
     */
    public void saveCarCaptureService(CarInOutParkingLotDto carInOutParkingLotDto, ParkCar car) {

        ParkCarCapture parkCarCapture = new ParkCarCapture();
        if (car != null) {
            parkCarCapture.setCarNumColor(car.getCarNumColor());
            parkCarCapture.setCarMode(car.getCarMode());
            parkCarCapture.setCarBrand(car.getCarBrand());
        } else {
            parkCarCapture.setCarMode(carInOutParkingLotDto.getCarMode());
        }
        parkCarCapture.setDirect(carInOutParkingLotDto.getDirect());
        parkCarCapture.setCarNum(carInOutParkingLotDto.getCarNum());
        parkCarCapture.setCreateTime(carInOutParkingLotDto.getCarInOutCurrentTime());
        parkCarCapture.setUpdateTime(carInOutParkingLotDto.getCarInOutCurrentTime());
        parkCarCapture.setChannelId(carInOutParkingLotDto.getChannelId());
        parkCarCapture.setCameraCode(carInOutParkingLotDto.getDevCode());
        parkCarCapture.setImgUrl(carInOutParkingLotDto.getImgUrl());
        parkCarCapture.setNumUrl(carInOutParkingLotDto.getNumUrl());
        carCaptureServiceImpl.insert(parkCarCapture);
    }

    /**
     * 获取进出场规则
     * 
     * @Methods Name getCarInOutRule
     * @Create In 2017年12月22日 By xiaoxiaojie
     * @param parkRuleId
     * @return RuleDto
     */
    public RuleDto getCarInOutRule(String parkRuleId) {
        ParkRule rule = queryParkRuleByPackage(parkRuleId);
        if (rule == null) {
            return null;
        }
        RuleDto dto = new RuleDto();
        BeanUtils.copyProperties(rule, dto);
        RuleDetailDto ruleDetailDto = JSONObject.parseObject(rule.getDetail(), RuleDetailDto.class);
        dto.setRuleDetailDto(ruleDetailDto);
        return dto;
    }

    /**
     * 根据设备编号devCode 查询车道信息
     * 
     * @Methods Name queryChannelRelList
     * @Create In 2017年12月19日 By xiaoxiaojie
     * @return ParkChannelRel
     */
    public ParkChannelRel queryChannelRelListByDevCode(String devCode) {
        if (StringUtils.isBlank(devCode)) {
            return null;
        }
        List<ParkChannelRel> list = parkChannelRelDao.selectParkChannelRelByDevCode(devCode);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 获得车道信息
     * 
     * @Methods Name getChannelInfo
     * @Create In 2017年12月21日 By xiaoxiaojie
     * @param devCode
     * @return ParkChannel
     */
    public ParkChannel getChannelInfo(String devCode) {
        ParkChannelRel channelRel = queryChannelRelListByDevCode(devCode);
        if (channelRel != null) {
            return parkChannelMapper.selectByPrimaryKey(channelRel.getChannelId());
        }
        return null;
    }

    /**
     * 判断车道行驶方向 1-进,2-出
     * 
     * @Methods Name judgeChannelDirect
     * @Create In 2017年12月19日 By xiaoxiaojie
     * @param channelRel
     * @return Short
     */
    public short judgeChannelDirect(ParkChannel channel) {
        if (channel == null) {
            return 0;
        }
        return channel.getDirect().shortValue();
    }

    /**
     * 根据车牌查询车辆信息
     * 
     * @Methods Name getCarInfoByCarNum
     * @Create In 2017年12月20日 By xiaoxiaojie
     * @param carNum
     * @return ParkCar
     */
    public ParkCar getCarInfoByCarNum(String carNum) {
        return carDao.selectCarByCarNum(carNum);
    }

    /**
     * 根据车牌号查询预约登记信息
     * 
     * @Methods Name getReservationInfoByCarNum
     * @Create In 2017年12月20日 By xiaoxiaojie
     * @param carNum
     * @param parkCode
     * @return ParkReservation
     */
    public ParkReservation getReservationInfoByCarNum(String carNum, String parkCode) {
        if (StringUtils.isBlank(carNum) || StringUtils.isBlank(parkCode)) {
            return null;
        }
        ParkReservationCriteria duc = new ParkReservationCriteria();
        ParkReservationCriteria.Criteria ducc = duc.createCriteria();
        ducc.andCarNumEqualTo(carNum);
        ducc.andParkCodeEqualTo(parkCode);
        List<ParkReservation> list = parkReservationMapper.selectByExample(duc);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 根据车牌,业主Id,停车场编号查询授权套餐
     * 
     * @Methods Name getAuthPackageInfo
     * @Create In 2017年12月21日 By xiaoxiaojie
     * @param carNum
     * @param ownerId
     * @param parkCode
     * @return AuthPackage
     */
    public AuthPackage getAuthPackageInfo(String carNum, String ownerId, String parkCode) {
        if (StringUtils.isBlank(carNum) || StringUtils.isBlank(ownerId)
                || StringUtils.isBlank(parkCode)) {
            return null;
        }
        ParkAuthPackageCondition authPackageCondition = new ParkAuthPackageCondition();
        authPackageCondition.setCarNum(carNum);
        authPackageCondition.setOwnerId(ownerId);
        authPackageCondition.setParkCode(parkCode);
        List<AuthPackage> list = authPackageMapper.selectByExample(authPackageCondition);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }


    /**
     * 根据授权套餐的规则id查询规则
     * 
     * @Methods Name queryParkRuleByPackage
     * @Create In 2017年12月20日 By xiaoxiaojie
     * @param ruleId
     * @return ParkRule
     */
    public ParkRule queryParkRuleByPackage(String ruleId) {
        if (StringUtils.isBlank(ruleId)) {
            return null;
        }
        return parkRuleMapper.selectByPrimaryKey(ruleId);
    }



    /**
     * 根据通道ID和设备类型查询设备编号
     * 
     * @Methods Name queryBarrierGateDevCode
     * @Create In 2017年12月21日 By xiaoxiaojie
     * @param channelId
     * @param devType
     * @return String
     */
    public String queryBarrierGateDevCode(String channelId, Short devType) {
        if (StringUtils.isBlank(channelId) || devType == null) {
            return null;
        }
        ParkChannelRelCriteria duc = new ParkChannelRelCriteria();
        ParkChannelRelCriteria.Criteria ducc = duc.createCriteria();
        ducc.andChannelIdEqualTo(channelId);
        ducc.andDevTypeEqualTo(devType);
        List<ParkChannelRel> list = parkChannelRelMapper.selectByExample(duc);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0).getDevCode();
        }
        return null;
    }

    /**
     * 根据车场编号查询车场信息
     * 
     * @Methods Name queryParkingLotInfoByParkCode
     * @Create In 2017年12月22日 By xiaoxiaojie
     * @param parkCode
     * @return ParkParkingLot
     */
    public ParkParkingLot queryParkingLotInfoByParkCode(String parkCode) {
        if (StringUtils.isBlank(parkCode)) {
            return null;
        }
        ParkParkingLotCriteria duc = new ParkParkingLotCriteria();
        ParkParkingLotCriteria.Criteria ducc = duc.createCriteria();
        ducc.andParkCodeEqualTo(parkCode);
        List<ParkParkingLot> list = parkParkingLotMapper.selectByExample(duc);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 根据业主id查询业主名称
     * 
     * @Methods Name getOwnerNameById
     * @Create In 2018年1月9日 By xiaoxiaojie
     * @param ownerId
     * @return String
     */
    public String getOwnerNameById(String ownerId) {
        if (StringUtils.isBlank(ownerId)) {
            return "";
        }
        BaseUserDto userDto = new BaseUserDto();
        userDto.setUuid(ownerId);
        List<BaseUserDto> list = userClientImpl.getUser(userDto);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0).getName();
        }
        return "";
    }
}
