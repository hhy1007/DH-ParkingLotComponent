/**
 * @Probject Name: scp-parkinglot-component-service
 * @Path: com.eg.egsc.scp.parkinglotcomponent.service.park.implParkExitParkingLotService.java
 * @Create By wangziqiang
 * @Create In 2017年12月23日 上午9:22:54
 */
package com.eg.egsc.scp.parkinglotcomponent.service.park.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alibaba.fastjson.JSONObject;
import com.eg.egsc.scp.parkinglotcomponent.common.exception.ExceptionFactory;
import com.eg.egsc.scp.parkinglotcomponent.condition.access.AccessCurCondition;
import com.eg.egsc.scp.parkinglotcomponent.condition.authpackage.ParkAuthPackageCondition;
import com.eg.egsc.scp.parkinglotcomponent.condition.channel.ChannelRelCondition;
import com.eg.egsc.scp.parkinglotcomponent.dao.access.AccessCurDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.authpackage.ParkAuthPackageDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.car.CarDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.carcapture.ParkCarCaptureDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.channel.ParkChannelDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.channel.ParkChannelRelDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.park.ParkParkingLotDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.rule.ParkRuleDao;
import com.eg.egsc.scp.parkinglotcomponent.enmus.DeleteFlag;
import com.eg.egsc.scp.parkinglotcomponent.enmus.OperateType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.access.NeedPay;
import com.eg.egsc.scp.parkinglotcomponent.enmus.alarm.CarType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.alarm.ChannelDirectType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.alarm.ControlType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.alarm.OpenWay;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.CarModeType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.carport.CarportType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.dev.DevType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.rule.MonthCarTurnTemp;
import com.eg.egsc.scp.parkinglotcomponent.enmus.rule.SeatFullTurnTemp;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.authpackage.entity.AuthPackage;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAccessCur;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCar;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarCapture;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannelRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkConsumeRecord;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkingLot;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkRule;
import com.eg.egsc.scp.parkinglotcomponent.redis.RedisKey;
import com.eg.egsc.scp.parkinglotcomponent.service.access.RoadGateService;
import com.eg.egsc.scp.parkinglotcomponent.service.car.CarEnterParkingLotService;
import com.eg.egsc.scp.parkinglotcomponent.service.car.dto.CarInOutParkingLotDto;
import com.eg.egsc.scp.parkinglotcomponent.service.integration.IntegrationAppService;
import com.eg.egsc.scp.parkinglotcomponent.service.integration.dto.CarInOutDto;
import com.eg.egsc.scp.parkinglotcomponent.service.park.ParkAccessCurService;
import com.eg.egsc.scp.parkinglotcomponent.service.park.ParkExitParkingLotService;
import com.eg.egsc.scp.parkinglotcomponent.service.park.ParkParkingLotInformationStoredService;
import com.eg.egsc.scp.parkinglotcomponent.service.park.dto.ReBillingDto;
import com.eg.egsc.scp.parkinglotcomponent.service.rule.ParkFeeRuleService;
import com.eg.egsc.scp.parkinglotcomponent.service.rule.dto.ResponseBillingDto;
import com.eg.egsc.scp.parkinglotcomponent.service.rule.dto.RuleDetailDto;
import com.eg.egsc.scp.parkinglotcomponent.service.rule.dto.RuleDto;
import com.eg.egsc.scp.parkinglotcomponent.util.DateUtil;
import com.eg.egsc.scp.parkinglotcomponent.util.UuidUtil;

@Service
public class ParkExitParkingLotServiceImpl implements ParkExitParkingLotService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParkAuthPackageDao parkAuthPackageDao;// 数据库授权规则表

    @Autowired
    private ParkCarCaptureDao parkCarCaptureDao;// 图片抓拍记录Dao

    @Autowired
    private ParkFeeRuleService parkFeeRuleServiceImpl;// 收费规则serivce

    @Autowired
    private ParkAccessCurService parkAccessCurServiceImpl;// 在线车辆信息

    @Autowired
    private ParkChannelRelDao parkChannelRelDao;// 消息绑定Dao

    @Autowired
    private RoadGateService roadGateServiceImpl;// 开闸service

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate; // redis模版

    @Autowired
    private IntegrationAppService integrationAppServiceImpl;// 应用类

    @Autowired
    private ParkRuleDao parkRuleDao;// 规则dao

    @Autowired
    private AccessCurDao accessCurDao;// 在线车辆DAO

    @Autowired
    private ParkParkingLotInformationStoredService parkParkingLotInformationStoredServiceImpl;// 存储serivce

    @Autowired
    private CarEnterParkingLotService carEnterParkingLotServiceImpl;// 车辆进入逻辑serivce

    @Autowired
    private ParkChannelDao parkChannelDao;// 通道DAO

    @Autowired
    private ParkParkingLotDao parkParkingLotDao;// 停车场DAO

    @Autowired
    private CarDao carDao;// 车辆DAO

    private ThreadLocal<ParkCar> tl = new ThreadLocal<>();

    @Override
    @Transactional
    public void exitParkingLot(CarInOutParkingLotDto carInOutParkingLotDto) {
        tl.set(getParkCar(carInOutParkingLotDto));
        short direct = carInOutParkingLotDto.getDirect();
        if (ChannelDirectType.EXPROTATION.getType().shortValue() != direct) {// 不是出口道
            return;
        }
        // 抓拍记录操作
        ParkCarCapture parkCarCapture = getParkCarCapture(carInOutParkingLotDto);
        parkCarCaptureDao.getMapper().insert(parkCarCapture);
        int operateType = carInOutParkingLotDto.getOperateType();
        // 获取道闸设备编号
        String channelId = carInOutParkingLotDto.getChannelId();
        String barrierGateDevCode = getBarrierGateDevCode(channelId);
        String carNum = carInOutParkingLotDto.getCarNum();
        if (OperateType.AUTO.getType().intValue() == operateType) {// 自动开闸
            // 自动开闸逻辑
            excucteAutoFlow(carNum, carInOutParkingLotDto, barrierGateDevCode);
        } else if (OperateType.MANUAL.getType().intValue() == operateType) {// 人工开凿
            excucteMatchFlow(carNum, carInOutParkingLotDto, barrierGateDevCode);
        }
    }


    @Override
    public CarInOutDto reBilling(CarInOutDto carInOutDto) {
        Date endTime = carInOutDto.getOutTime();
        ParkAccessCur parkAccessCur = carInOutDto.getParkAccessCur();
        String carMode = carInOutDto.getCarMode();
        int carModeInt = Integer.parseInt(CarModeType.SMALLCAR.getType());
        if (StringUtils.isNotBlank(carMode)) {
            carModeInt = Integer.parseInt(carMode);
        }
        ResponseBillingDto responseBillingDto = markCharging(parkAccessCur, carModeInt, endTime);
        setParkConsumeRecord(carInOutDto, responseBillingDto);
        return carInOutDto;
    }

    @Override
    public CarInOutDto selectCarInOutInformation(CarInOutDto carInOutDto) {
        String vagueCarNum = carInOutDto.getCarNum();
        String channelId = carInOutDto.getChannelId();
        AccessCurCondition accessCurCondition = new AccessCurCondition();
        accessCurCondition.setCarNum(vagueCarNum);
        accessCurCondition.setOrderByClause("inTime");
        List<ParkAccessCur> list = accessCurDao.selectList(accessCurCondition);
        String money = "0.00";
        if (CollectionUtils.isNotEmpty(list)) {
            ParkAccessCur parkAccessCur = list.get(0);
            carInOutDto.setParkAccessCur(parkAccessCur);
            String carNum = parkAccessCur.getCarNum();
            Short carType = parkAccessCur.getCarType();
            String carMode = parkAccessCur.getCarMode();
            int carModeInt = Integer.parseInt(CarModeType.SMALLCAR.getType());
            if (StringUtils.isNotBlank(carMode)) {
                carModeInt = Integer.parseInt(carMode);
            }
            carInOutDto.setCarNum(carNum);
            if (null != carType) {
                carInOutDto.setCarType(carType);
            }
            Short needPay = parkAccessCur.getNeedPay();
            if (NeedPay.YES.getType() == needPay) {// 是要缴费
                // 算钱
                Date endTime = carInOutDto.getOutTime();
                ResponseBillingDto universalBilling = null;
                try {
                    universalBilling = parkFeeRuleServiceImpl
                            .universalBillingInterface(parkAccessCur, carModeInt, endTime);
                    setParkConsumeRecord(carInOutDto, universalBilling);
                    money = universalBilling.getCharges();
                } catch (ParseException e) {
                    throw ExceptionFactory
                            .createSysException("parkinglot.fee.rule.number.parse.failure");
                }
            }
            carInOutDto.setOwnerId(parkAccessCur.getOwnerId());
            // redis缓存更新
            Object object = redisTemplate.opsForHash().get(RedisKey.KEY_CHANNEL_ID, channelId);
            if (object instanceof ReBillingDto) {
                ReBillingDto reBillingDto = (ReBillingDto) object;
                reBillingDto.setMoney(money);
                reBillingDto.setParkAccessCur(parkAccessCur);
                reBillingDto.setCarNum(carNum);
                redisTemplate.opsForHash().put(RedisKey.KEY_CHANNEL_ID, channelId, reBillingDto);
            }
            return carInOutDto;
        }
        return null;
    }

    /**
     * 往CarInOutParkingLotDto set packages ruleDto
     * 
     * @Methods Name continueInitCarInOutParkingLotDto
     * @Create In 2018年1月19日 By wangziqiang
     * @param carInOutParkingLotDto
     * @param parkAccessCur void
     */
    private void continueInitCarInOutParkingLotDto(CarInOutParkingLotDto carInOutParkingLotDto,
            ParkAccessCur parkAccessCur) {
        ParkCar parkCar = tl.get();
        String channelId = carInOutParkingLotDto.getChannelId();
        AuthPackage packages = getAuthPackage(parkAccessCur, parkCar, channelId);
        if (null != packages) {
            carInOutParkingLotDto.setParkPackageId(packages.getId());
        }
        setRuleDto(carInOutParkingLotDto, packages);
    }

    /**
     * 执行人工开闸
     * 
     * @Methods Name excucteMatchFlow
     * @Create In 2018年1月11日 By wangziqiang
     * @param carNum
     * @param carInOutParkingLotDto
     * @param barrierGateDevCode void
     */
    private void excucteMatchFlow(String carNum, CarInOutParkingLotDto carInOutParkingLotDto,
            String barrierGateDevCode) {
        if (StringUtils.isNotBlank(carNum)) {// 有车牌
            AccessCurCondition condition = new AccessCurCondition();
            condition.setCarNum(carNum);
            ParkAccessCur parkAccessCur = getOneAccessCur(condition);
            if (null != parkAccessCur) {// 是有在场车辆记录
                Short carType = parkAccessCur.getCarType();
                carType = getCarType(carType);
                judgeAllFlow(barrierGateDevCode, carType, carInOutParkingLotDto, parkAccessCur);
            } else {// 无在场车辆信息
                ParkCar parkCar = tl.get();
                if (null == parkCar) {// 无车，通知应用
                    CarInOutDto carInOutDto =
                            this.getCarInOutDto(carInOutParkingLotDto, barrierGateDevCode);
                    this.integrationAppServiceImpl.carInOutEvent(carInOutDto);
                } else {
                    Short carType = parkCar.getCarType();
                    carType = getCarType(carType);
                    judgeAllFlow(barrierGateDevCode, carType, carInOutParkingLotDto, parkAccessCur);
                }
            }
        } else {// 无车牌，通知应用
            CarInOutDto carInOutDto =
                    this.getCarInOutDto(carInOutParkingLotDto, barrierGateDevCode);
            ReBillingDto reBillingDto =
                    getReBillingDto(carInOutParkingLotDto, null, "0.00", barrierGateDevCode);
            this.redisTemplate.opsForHash().put(RedisKey.KEY_CHANNEL_ID,
                    carInOutParkingLotDto.getChannelId(), reBillingDto);
            this.integrationAppServiceImpl.carInOutEvent(carInOutDto);
        }
    }

    /**
     * 自动开闸流程
     * 
     * @Methods Name excucteAutoFlow
     * @Create In 2018年1月11日 By wangziqiang
     * @param carNum
     * @param carInOutParkingLotDto void
     */
    private void excucteAutoFlow(String carNum, CarInOutParkingLotDto carInOutParkingLotDto,
            String barrierGateDevCode) {
        // 自动开闸逻辑
        ParkAccessCur parkAccessCur = null;
        if (StringUtils.isNotBlank(carNum)) {
            AccessCurCondition condition = new AccessCurCondition();
            condition.setCarNum(carNum);
            parkAccessCur = this.getOneAccessCur(condition);
        }
        // 初始化
        if (StringUtils.isNotBlank(carInOutParkingLotDto.getCarNum())) {
            continueInitCarInOutParkingLotDto(carInOutParkingLotDto, parkAccessCur);
        }
        CarInOutDto carInOutDto =
                getCarInOutDto(carInOutParkingLotDto, parkAccessCur, barrierGateDevCode);
        parkParkingLotInformationStoredServiceImpl.autoStoreCarInformation(carInOutDto);
        // 发送应用
        this.integrationAppServiceImpl.carInOutEvent(carInOutDto);
    }

    /**
     * 发消息给mq生产者
     * 
     * @param controlType
     * @param barrierGateDevCode
     * @Methods Name sendCurOffMsg
     * @Create In 2017年12月29日 By wangziqiang
     * @param curOffMessageDto void
     */
    private void sendCurOffMsg(String devCode, int controlType, CarInOutDto carInOutDto) {
        this.roadGateServiceImpl.cutOffRoadGateCommand(devCode, controlType, carInOutDto);
    }

    /**
     * 查询通道绑定信息
     * 
     * @Methods Name getParkChannelRel
     * @Create In 2017年12月29日 By wangziqiang
     * @param channelId
     * @return ParkChannelRel
     */
    private ParkChannelRel getParkChannelRel(ChannelRelCondition condition) {
        List<ParkChannelRel> selectList = parkChannelRelDao.selectList(condition);
        if (CollectionUtils.isNotEmpty(selectList)) {
            return selectList.get(0);
        }
        return null;
    }

    /**
     * 手动开凿模式下
     * 
     * @Methods Name judgeAllFlow
     * @Create In 2018年1月3日 By wangziqiang
     * @param barrierGateDevCode
     * @param carType
     * @param carInOutParkingLotDto
     * @param parkCar
     * @param parkAccessCur void
     * @param barrierGateDevCode2
     */
    private void judgeAllFlow(String barrierGateDevCode, Short carType,
            CarInOutParkingLotDto carInOutParkingLotDto, ParkAccessCur parkAccessCur) {
        continueInitCarInOutParkingLotDto(carInOutParkingLotDto, parkAccessCur);
        CarInOutDto carInOutDto =
                getCarInOutDto(carInOutParkingLotDto, parkAccessCur, barrierGateDevCode);
        if (CarType.SPECIALVEHICLE.getType().intValue() == (int) carType) {// 是特殊车
            // 通知 应用
            setParkConsumeRecord(carInOutDto, null);
            sendCurOffMsg(barrierGateDevCode, ControlType.OPEN.getType().intValue(), carInOutDto);
            this.integrationAppServiceImpl.carInOutEvent(carInOutDto);
        } else { 
            String parkPackageId = carInOutParkingLotDto.getParkPackageId();
            if (StringUtils.isNotBlank(parkPackageId)) {// 有套餐
                boolean result = getResult(parkPackageId);
                carInOutDto.setParkPackageId(parkPackageId);
                if (result) {// 有效期内
                    RuleDetailDto ruleDetailDto =
                            carInOutParkingLotDto.getRuleDto().getRuleDetailDto();
                    judgeTwoAllFlow(ruleDetailDto, carInOutDto, barrierGateDevCode, parkAccessCur,
                            carInOutParkingLotDto);
                } else {
                    // 调用收费和通知应用
                    getParkMoneyAndRedis(parkAccessCur, carInOutParkingLotDto, barrierGateDevCode);
                }
            } else {// 没有月保产权
                // 调用收费和通知应用
                getParkMoneyAndRedis(parkAccessCur, carInOutParkingLotDto, barrierGateDevCode);
            }
        }
    }

    /**
     * 手动开闸模式有效期内的套餐下进一步判断流程
     * 
     * @Methods Name judgeTwoAllFlow
     * @Create In 2018年1月12日 By wangziqiang
     * @param result
     * @param parkAccessCur
     * @param barrierGateDevCode
     * @param carInOutParkingLotDto
     * @param parkAccessCur
     * @param carInOutParkingLotDto void
     */
    private void judgeTwoAllFlow(RuleDetailDto ruleDetailDto, CarInOutDto carInOutDto,
            String barrierGateDevCode, ParkAccessCur parkAccessCur,
            CarInOutParkingLotDto carInOutParkingLotDto) {
        String ownerId = carInOutDto.getOwnerId();
        boolean result = carIsOverAllowances(ownerId);
        if (!result) {// 超过了所允许车量
            Integer privateParkSeatFullTurnTemp = ruleDetailDto.getPrivateParkSeatFullTurnTemp();
            if (SeatFullTurnTemp.NTI.getType().intValue() == privateParkSeatFullTurnTemp
                    .intValue()) {// 不转
                judgeThreeAllFlow(ruleDetailDto, carInOutDto, barrierGateDevCode);
                setRuleName(carInOutParkingLotDto, carInOutDto);
            } else {// 转临停
                // 调用收费
                String parkPackageId = carInOutDto.getParkPackageId();
                carInOutDto = calculateFeelAndSaveRedis(parkAccessCur, carInOutParkingLotDto,
                        barrierGateDevCode);
                setRuleName(carInOutParkingLotDto, carInOutDto);
                carInOutDto.setParkPackageId(parkPackageId);
                // 通知 应用
            }
        } else {
            judgeThreeAllFlow(ruleDetailDto, carInOutDto, barrierGateDevCode);
            setRuleName(carInOutParkingLotDto, carInOutDto);
        }
        this.integrationAppServiceImpl.carInOutEvent(carInOutDto);
    }

    /**
     * 手动模式下 判断放行规则
     * 
     * @Methods Name judgeThreeAllFlow
     * @Create In 2018年1月22日 By wangziqiang
     * @param ruleDetailDto
     * @param carInOutDto
     * @param barrierGateDevCode void
     */
    private void judgeThreeAllFlow(RuleDetailDto ruleDetailDto, CarInOutDto carInOutDto,
            String barrierGateDevCode) {
        if (OpenWay.INTOUTLOTBYMACHINE.getType().intValue() == ruleDetailDto.getOpenWay().intValue()
                || OpenWay.INTLOTBYMAN.getType().intValue() == ruleDetailDto.getOpenWay()
                        .intValue()) {// 自动开闸
            setParkConsumeRecord(carInOutDto, null);
            sendCurOffMsg(barrierGateDevCode, ControlType.OPEN.getType().intValue(), carInOutDto);
        } else {// 人工开闸
            setParkConsumeRecord(carInOutDto, null);
        }
    }

    /**
     * 过期车要转临停的，计算费用和进行缓存
     * 
     * @Methods Name calculateFeelAndSaveRedis
     * @Create In 2018年1月19日 By wangziqiang
     * @param parkAccessCur
     * @param carInOutParkingLotDto
     * @param barrierGateDevCode
     * @param money
     * @return CarInOutDto
     */
    private CarInOutDto calculateFeelAndSaveRedis(ParkAccessCur parkAccessCur,
            CarInOutParkingLotDto carInOutParkingLotDto, String barrierGateDevCode) {
        String money = "0.00";
        Date endTime = carInOutParkingLotDto.getCarInOutCurrentTime();
        String carMode = CarModeType.SMALLCAR.getType();
        CarInOutDto carInOutDto =
                getCarInOutDto(carInOutParkingLotDto, parkAccessCur, barrierGateDevCode);
        if (null != parkAccessCur) {// 在线车辆记录有
            int carModeInt = 0;
            if (StringUtils.isNotBlank(carMode)) {
                carModeInt = Integer.parseInt(carMode);
            }
            ResponseBillingDto responseBillingDto =
                    markCharging(parkAccessCur, carModeInt, endTime);
            money = responseBillingDto.getCharges();
            setParkConsumeRecord(carInOutDto, responseBillingDto);
        }
        ReBillingDto billingDto =
                getReBillingDto(carInOutParkingLotDto, parkAccessCur, money, barrierGateDevCode);
        this.redisTemplate.opsForHash().put(RedisKey.KEY_CHANNEL_ID,
                carInOutParkingLotDto.getChannelId(), billingDto);
        return carInOutDto;
    }

    /**
     * 判断是在有效期中
     * 
     * @Methods Name getRusult
     * @Create In 2018年1月16日 By wangziqiang
     * @param authPackage
     * @return boolean
     */
    boolean getResult(String parkPackageId) {
        AuthPackage authPackage = this.parkAuthPackageDao.selectByPrimaryKey(parkPackageId);
        Date startTime = authPackage.getValidStartTime();
        Date endTime = authPackage.getValidEndTime();
        Date nowTime = new Date();
        return DateUtil.compareDate(startTime, endTime, nowTime);
    }

    /**
     * 设置规则名字
     * 
     * @Methods Name setRuleName
     * @Create In 2018年1月19日 By wangziqiang
     * @param carInOutParkingLotDto
     * @param carInOutDto void
     */
    private void setRuleName(CarInOutParkingLotDto carInOutParkingLotDto, CarInOutDto carInOutDto) {
        if (null != carInOutParkingLotDto.getRuleDto()) {
            carInOutDto.setRuleName(carInOutParkingLotDto.getRuleDto().getRuleName());
        }
    }

    /**
     * 判断车辆是否超过有效套餐量
     * 
     * @Methods Name carIsOverAllowances
     * @Create In 2018年1月19日 By wangziqiang
     * @param ownerId
     * @return boolean
     */
    boolean carIsOverAllowances(String ownerId) {
        ParkAuthPackageCondition condition = new ParkAuthPackageCondition();
        condition.setOwnerId(ownerId);
        condition.setNowDate(new Date());
        condition.setDeleteFlag(DeleteFlag.NORMAL.getType());
        int countNumber = this.parkAuthPackageDao.countNumber(condition);
        AccessCurCondition curCondition = new AccessCurCondition();
        curCondition.setOwnerId(ownerId);
        int curCountNumber = this.accessCurDao.countNumber(curCondition);
        return ((countNumber - curCountNumber) < 0 ? false : true);
    }

    /**
     * 初始化消费记录
     * 
     * @Methods Name getParkConsumeRecord
     * @Create In 2018年1月11日 By wangziqiang
     * @param carInOutDto
     * @param responseBillingDto
     * @return ParkConsumeRecord
     */
    void setParkConsumeRecord(CarInOutDto carInOutDto, ResponseBillingDto responseBillingDto) {
        String money = carInOutDto.getMoney();
        String timeLength = "0";
        if (null != responseBillingDto) {
            money = responseBillingDto.getCharges();
            Integer theStopTime = responseBillingDto.getTheStopTime();
            if (null != theStopTime) {
                timeLength = String.valueOf(theStopTime);
            }
        }
        carInOutDto.setMoney(money);
        carInOutDto.setTimeLength(timeLength);
        ParkConsumeRecord parkConsumeRecord = new ParkConsumeRecord();
        int consumeAmount = 0;
        if (StringUtils.isNotBlank(money)) {
            double douMoney = Double.parseDouble(money) * 100;
            consumeAmount = (int) douMoney;
        }
        parkConsumeRecord.setUuid(UuidUtil.generate());
        parkConsumeRecord.setConsumeAmount(consumeAmount);
        parkConsumeRecord.setFeeAmount(consumeAmount);
        parkConsumeRecord.setCreateTime(new Date());
        parkConsumeRecord.setCardNumber(carInOutDto.getCarNum());
        parkConsumeRecord.setOwnerId(carInOutDto.getOwnerId());
        parkConsumeRecord.setTimeLength(carInOutDto.getTimeLength());
        parkConsumeRecord.setOwnerId(carInOutDto.getOwnerId());
        carInOutDto.setParkConsumeRecord(parkConsumeRecord);
    }


    /**
     * 判断过期套餐是否要转临停
     * 
     * @Methods Name getParkMoneyAndRedis
     * @Create In 2018年1月3日 By wangziqiang
     * @param parkAccessCur
     * @param carInOutParkingLotDto
     * @param parkCar
     * @param money void
     */
    private void getParkMoneyAndRedis(ParkAccessCur parkAccessCur,
            CarInOutParkingLotDto carInOutParkingLotDto, String barrierGateDevCode) {
        CarInOutDto carInOutDto =
                getCarInOutDto(carInOutParkingLotDto, parkAccessCur, barrierGateDevCode);
        if (null == carInOutParkingLotDto.getRuleDto()) {
            this.integrationAppServiceImpl.carInOutEvent(carInOutDto);
            throw ExceptionFactory.createSysException("parkinglot.common.clazzisblank");
        }
        RuleDetailDto ruleDetailDto = carInOutParkingLotDto.getRuleDto().getRuleDetailDto();
        Integer monthCarEndTurnTemp = ruleDetailDto.getMonthCarEndTurnTemp();
        if (MonthCarTurnTemp.MNTI.getType().intValue() == monthCarEndTurnTemp.intValue()) {
            carInOutDto.setRuleName(carInOutParkingLotDto.getRuleDto().getRuleName());
            judgeTwoAllFlow(ruleDetailDto, carInOutDto, barrierGateDevCode, parkAccessCur,
                    carInOutParkingLotDto);
        } else {// 转临停
            carInOutDto = calculateFeelAndSaveRedis(parkAccessCur, carInOutParkingLotDto,
                    barrierGateDevCode);
            carInOutDto.setRuleName(carInOutParkingLotDto.getRuleDto().getRuleName());
            this.integrationAppServiceImpl.carInOutEvent(carInOutDto);

        }

    }

    /**
     * 计算费用
     * 
     * @Methods Name markCharging
     * @Create In 2018年1月8日 By wangziqiang
     * @param parkAccessCur
     * @param carModeInt
     * @param endTime
     * @return ResponseBillingDto
     */
    private ResponseBillingDto markCharging(ParkAccessCur parkAccessCur, int carModeInt,
            Date endTime) {

        try {
            return this.parkFeeRuleServiceImpl.universalBillingInterface(parkAccessCur, carModeInt,
                    endTime);
        } catch (ParseException e) {
            logger.error(e.getMessage());
        }
        return null;

    }

    /**
     * 得到开杆的设备id
     * 
     * @Methods Name getBarrierGateDevCode
     * @Create In 2018年1月4日 By wangziqiang
     * @param channelId
     * @return String
     */
    String getBarrierGateDevCode(String channelId) {
        String barrierGateDevCode = "";
        ChannelRelCondition condition = new ChannelRelCondition();
        condition.setChannelId(channelId);
        condition.setDevType(DevType.BARRIERGATE.getType().shortValue());// 选着为道闸类型
        ParkChannelRel parkChannelRel = getParkChannelRel(condition);
        if (null != parkChannelRel) {
            barrierGateDevCode = parkChannelRel.getDevCode();
            return barrierGateDevCode;
        }
        return "";
    }

    /**
     * 得到出入规则
     * 
     * @Methods Name getRuleDto
     * @Create In 2018年1月4日 By wangziqiang
     * @param carInOutParkingLotDto
     * @param authPackage void
     * 
     */
    private void setRuleDto(CarInOutParkingLotDto carInOutParkingLotDto, AuthPackage authPackage) {
        String parkingLotId = carInOutParkingLotDto.getParkinglotUuid();
        String carNum = carInOutParkingLotDto.getCarNum();
        ParkCar car = tl.get();
        String channelId = carInOutParkingLotDto.getChannelId();
        Date currentTime = new Date();
        // 获取产权和月保授权套餐内的进出规则
        // 获取临停默认进场规则
        ParkParkingLot parkParkingLot = getOneParkingLot(parkingLotId);
        RuleDto ruleDto = getCarInOutRule(parkParkingLot.getParkRuleId());
        if (StringUtils.isNotBlank(carNum) && null != car && StringUtils.isNotBlank(channelId)
                && null != authPackage) {
            int carportType = authPackage.getCarportType().intValue();
            if (CarportType.INTHEPARK.getType() != carportType && DateUtil.compareDate(
                    authPackage.getValidStartTime(), authPackage.getValidEndTime(), currentTime)) {
                ruleDto = getCarInOutRule(authPackage.getParkRuleId());
            }
        }
        carInOutParkingLotDto.setRuleDto(ruleDto);

    }

    /**
     * 根据授权套餐的规则id查询规则
     * 
     * @Methods Name queryParkRuleByPackage
     * @Create In 2018年1月4日 By wangziqiang
     * @param ruleId
     * @return ParkRule
     */
    private ParkRule queryParkRuleByPackage(String ruleId) {
        if (StringUtils.isBlank(ruleId)) {
            return null;
        }
        List<String> ids = new ArrayList<>(1);
        ids.add(ruleId);
        List<ParkRule> list = parkRuleDao.selectByRuleIds(ids);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 根据车牌,业主Id,停车场编号查询授权套餐
     * 
     * @Methods Name getAuthPackageInfo
     * @Create In 2018年1月4日 By wangziqiang
     * @param carNum
     * @param ownerId
     * @param parkCode
     * @return AuthPackage
     */
    public AuthPackage getAuthPackageInfo(String carNum, String ownerId, String parkCode) {

        if (StringUtils.isBlank(ownerId)) {
            return null;
        }
        ParkAuthPackageCondition authPackageCondition = new ParkAuthPackageCondition();
        authPackageCondition.setCarNum(carNum);
        authPackageCondition.setOwnerId(ownerId);
        authPackageCondition.setParkCode(parkCode);
        List<AuthPackage> list = parkAuthPackageDao.selectList(authPackageCondition);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 有车牌下的得到CarInoutDto
     * 
     * @Methods Name getCarInOutDto
     * @Create In 2018年1月5日 By wangziqiang
     * @param carInOutParkingLotDto
     * @param parkAccessCur
     * @param barrierGateDevCode
     * @return CarInOutDto
     */
    private CarInOutDto getCarInOutDto(CarInOutParkingLotDto carInOutParkingLotDto,
            ParkAccessCur parkAccessCur, String barrierGateDevCode) {
        CarInOutDto carInOutDto = new CarInOutDto();
        String money = "0.00";
        carInOutDto.setMoney(money);
        carInOutDto.setCarNum(carInOutParkingLotDto.getCarNum());
        ParkCar parkCar = tl.get();
        if (null != parkCar) {
            carInOutDto.setCarMode(parkCar.getCarMode());
            String ownerId = parkCar.getOwnerId();
            carInOutDto.setOwnerId(ownerId);
            String ownerName = carEnterParkingLotServiceImpl.getOwnerNameById(ownerId);
            carInOutDto.setOwnerName(ownerName);
            short carType = getCarType(parkCar.getCarType()).shortValue();
            carInOutDto.setCarType(carType);
        } else {
            carInOutDto.setCarMode(carInOutParkingLotDto.getCarMode());
        }

        carInOutDto.setChannelId(carInOutParkingLotDto.getChannelId());
        carInOutDto.setChannelIp(carInOutParkingLotDto.getChannelIP());
        carInOutDto.setChannelName(carInOutParkingLotDto.getChannelName());
        carInOutDto.setParkCode(carInOutParkingLotDto.getParkCode());
        carInOutDto.setParkingLotId(carInOutParkingLotDto.getParkinglotUuid());
        carInOutDto.setParkAccessCur(parkAccessCur);
        if (null != parkAccessCur) {
            carInOutDto.setInImgUrl(parkAccessCur.getInImgUrl());
            carInOutDto.setInTime(parkAccessCur.getCreateTime());
        }
        carInOutDto.setDirect(carInOutParkingLotDto.getDirect());
        carInOutDto.setDevCode(carInOutParkingLotDto.getDevCode());
        carInOutDto.setOutNumUrl(carInOutParkingLotDto.getNumUrl());
        carInOutDto.setOutSluiceCode(barrierGateDevCode);
        carInOutDto.setOutTime(carInOutParkingLotDto.getCarInOutCurrentTime());
        RuleDto ruleDto = carInOutParkingLotDto.getRuleDto();
        if (null != ruleDto) {
            carInOutDto.setRuleName(ruleDto.getRuleName());
        }
        carInOutDto.setOutCarPic(carInOutParkingLotDto.getImgUrl());
        carInOutDto.setControlType(carInOutParkingLotDto.getOperateType());
        carInOutDto.setParkPackageId(carInOutParkingLotDto.getParkPackageId());
        logger.info("result : {}" + JSONObject.toJSONString(carInOutDto));
        return carInOutDto;
    }

    /**
     * 无车牌CarInoutDto
     * 
     * @Methods Name getCarInOutDto
     * @Create In 2018年1月5日 By wangziqiang
     * @param carInOutParkingLotDto
     * @param parkAccessCur
     * @param barrierGateDevCode
     * @return CarInOutDto
     */
    private CarInOutDto getCarInOutDto(CarInOutParkingLotDto carInOutParkingLotDto,
            String barrierGateDevCode) {
        String money = "0.00";
        CarInOutDto carInOutDto = new CarInOutDto();
        carInOutDto.setCarNum(carInOutParkingLotDto.getCarNum());
        carInOutDto.setMoney(money);
        carInOutDto.setDirect(carInOutParkingLotDto.getDirect());
        carInOutDto.setDevCode(carInOutParkingLotDto.getDevCode());// 相机编号id
        carInOutDto.setOutNumUrl(carInOutParkingLotDto.getNumUrl());
        carInOutDto.setOutSluiceCode(barrierGateDevCode);
        carInOutDto.setOutTime(carInOutParkingLotDto.getCarInOutCurrentTime());
        carInOutDto.setOutCarPic(carInOutParkingLotDto.getImgUrl());
        ParkCar parkCar = tl.get();
        if (null != parkCar) {
            carInOutDto.setOwnerId(parkCar.getOwnerId());
            String ownerName = carEnterParkingLotServiceImpl.getOwnerNameById(parkCar.getOwnerId());
            carInOutDto.setOwnerName(ownerName);
        }
        carInOutDto.setChannelId(carInOutParkingLotDto.getChannelId());
        carInOutDto.setChannelIp(carInOutParkingLotDto.getChannelIP());
        carInOutDto.setChannelName(carInOutParkingLotDto.getChannelName());
        carInOutDto.setParkCode(carInOutParkingLotDto.getParkCode());
        carInOutDto.setParkingLotId(carInOutParkingLotDto.getParkinglotUuid());
        carInOutDto.setCarMode(carInOutParkingLotDto.getCarMode());
        carInOutDto.setControlType(carInOutParkingLotDto.getOperateType());
        logger.info("result : {}" + JSONObject.toJSONString(carInOutDto));
        return carInOutDto;
    }

    /**
     * 得到停车场
     * 
     * @Methods Name getOneParkingLot
     * @Create In 2018年1月23日 By wangziqiang
     * @param parkingLotId
     * @return ParkParkingLot
     */
    private ParkParkingLot getOneParkingLot(String parkingLotId) {
        return parkParkingLotDao.selectByPrimaryKey(parkingLotId);       
    }


    /**
     * 得到套餐
     * 
     * @Methods Name getAuthPackage
     * @Create In 2018年1月12日 By wangziqiang
     * @param parkAccessCur
     * @param car
     * @param channelId
     * @return AuthPackage
     */
    private AuthPackage getAuthPackage(ParkAccessCur parkAccessCur, ParkCar car, String channelId) {
        if (null != parkAccessCur) {
            String parkPackageId = parkAccessCur.getParkPackageId();
            return this.parkAuthPackageDao.selectByPrimaryKey(parkPackageId);
        }
        if (null != car) {
            String carNum = car.getCarNum();
            ParkChannel parkChannel = getOneChannel(channelId);
            return getAuthPackageInfo(carNum, car.getOwnerId(), parkChannel.getParkCode());
        }
        return null;
    }


    /**
     * 得到通道
     * 
     * @Methods Name getOneChannel
     * @Create In 2018年1月23日 By wangziqiang
     * @param channelId
     * @return ParkChannel
     */
    private ParkChannel getOneChannel(String channelId) {
        return parkChannelDao.selectByPrimaryKey(channelId);        
    }


    /**
     * 根据车牌查在场车辆
     * 
     * @Methods Name getOneAccessCur
     * @Create In 2018年1月3日 By wangziqiang
     * @param condition
     * @return ParkAccessCur
     */
    private ParkAccessCur getOneAccessCur(AccessCurCondition condition) {
        List<ParkAccessCur> parkAccessCurList = parkAccessCurServiceImpl.selectList(condition);
        if (CollectionUtils.isNotEmpty(parkAccessCurList)) {
            return parkAccessCurList.get(0);
        }
        return null;
    }


    /**
     * 得到car
     * 
     * @Methods Name initInOutCar
     * @Create In 2018年1月23日 By wangziqiang
     * @param carInOutParkingLotDto void
     */
    private ParkCar getParkCar(CarInOutParkingLotDto carInOutParkingLotDto) {
        String carNum = carInOutParkingLotDto.getCarNum();
        if (StringUtils.isNotBlank(carNum)) {
            return carDao.selectCarByCarNum(carNum);
        }
        return null;
    }


    /**
     * 得到出入规则
     * 
     * @Methods Name getCarInOutRule
     * @Create In 2018年1月4日 By wangziqiang
     * @param parkRuleId
     * @return RuleDto
     */
    private RuleDto getCarInOutRule(String parkRuleId) {
        ParkRule rule = queryParkRuleByPackage(parkRuleId);
        RuleDto dto = new RuleDto();
        if (null != rule) {
            RuleDto ruleDto = new RuleDto();
            BeanUtils.copyProperties(rule, ruleDto);
            RuleDetailDto ruleDetailDto =
                    JSONObject.parseObject(rule.getDetail(), RuleDetailDto.class);
            ruleDto.setRuleDetailDto(ruleDetailDto);
            return ruleDto;
        }
        return dto;
    }


    /**
     * 判断carType是否有空
     * 
     * @Methods Name getCarType
     * @Create In 2018年1月15日 By wangziqiang
     * @param carType
     * @return Short
     */
    private Short getCarType(Short carType) {
        if (null == carType) {
            carType = CarType.PASSENEGER.getType().shortValue();
        }
        return carType;
    }


    /**
     * 设置返回类
     * 
     * @param money
     * @Methods Name getReBillingDto
     * @Create In 2017年12月26日 By wangziqiang
     * @param parkExitParkingLot enterTime money feeRuleDto
     * @return ReBillingDto
     */
    private ReBillingDto getReBillingDto(CarInOutParkingLotDto carInOutParkingLotDto,
            ParkAccessCur parkAccessCur, String money, String barrierGateDevCode) {
        ReBillingDto reBillingDto = new ReBillingDto();
        reBillingDto.setCarNum(carInOutParkingLotDto.getCarNum());
        reBillingDto.setCarPic(carInOutParkingLotDto.getImgUrl());
        reBillingDto.setDirect(carInOutParkingLotDto.getDirect());
        reBillingDto.setMoney(money);
        reBillingDto.setParkAccessCur(parkAccessCur);
        String outTime = "";
        Date carExitCurrentTime = carInOutParkingLotDto.getCarInOutCurrentTime();
        if (null != carExitCurrentTime) {
            outTime = DateUtil.dateToString(carExitCurrentTime, DateUtil.YYYY_MM_DD_HH_MM_SS);
        }
        reBillingDto.setOutTime(outTime);

        reBillingDto.setParkingLotId(carInOutParkingLotDto.getParkinglotUuid());
        reBillingDto.setChannelId(carInOutParkingLotDto.getChannelId());
        reBillingDto.setOutSluiceCode(barrierGateDevCode);
        return reBillingDto;
    }


    /**
     * 抓拍记录类
     * 
     * @Methods Name getParkCarCapture
     * @Create In 2017年12月26日 By wangziqiang
     * @param carInOutParkingLotDto
     * @return ParkCarCapture
     */
    private ParkCarCapture getParkCarCapture(CarInOutParkingLotDto carInOutParkingLotDto) {
        ParkCarCapture parkCarCapture = new ParkCarCapture();
        ParkCar parkCar = tl.get();
        if (null != parkCar) {// 登记了的车
            parkCarCapture.setCarMode(parkCar.getCarMode());
            parkCarCapture.setCarNumColor(parkCar.getCarNumColor());
            parkCarCapture.setCarBrand(parkCar.getCarBrand());
        } else {// 未登记的车
            parkCarCapture.setCarMode(carInOutParkingLotDto.getCarMode());
        }
        parkCarCapture.setCameraCode(carInOutParkingLotDto.getDevCode());
        parkCarCapture.setCreateTime(carInOutParkingLotDto.getCarInOutCurrentTime());
        parkCarCapture.setCarNum(carInOutParkingLotDto.getCarNum());
        parkCarCapture.setChannelId(carInOutParkingLotDto.getChannelId());
        parkCarCapture.setUuid(UuidUtil.generate());
        parkCarCapture.setImgUrl(carInOutParkingLotDto.getImgUrl());
        parkCarCapture.setNumUrl(carInOutParkingLotDto.getNumUrl());
        parkCarCapture.setDirect(carInOutParkingLotDto.getDirect());
        return parkCarCapture;
    }
}
