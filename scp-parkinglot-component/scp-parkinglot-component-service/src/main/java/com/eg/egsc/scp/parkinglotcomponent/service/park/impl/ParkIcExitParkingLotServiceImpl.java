/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.park.impl;

import java.text.ParseException;
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
import com.alibaba.fastjson.JSONObject;
import com.eg.egsc.scp.parkinglotcomponent.common.exception.ExceptionFactory;
import com.eg.egsc.scp.parkinglotcomponent.condition.access.AccessCurCondition;
import com.eg.egsc.scp.parkinglotcomponent.condition.authpackage.ParkAuthPackageCondition;
import com.eg.egsc.scp.parkinglotcomponent.condition.channel.ChannelRelCondition;
import com.eg.egsc.scp.parkinglotcomponent.condition.park.ParkingLotCondition;
import com.eg.egsc.scp.parkinglotcomponent.condition.rule.FeeRuleCondition;
import com.eg.egsc.scp.parkinglotcomponent.condition.rule.RuleCondition;
import com.eg.egsc.scp.parkinglotcomponent.dao.access.AccessCurDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.authpackage.ParkAuthPackageDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.channel.ParkChannelDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.channel.ParkChannelRelDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.park.ParkParkingLotDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.rule.ParkFeeRuleDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.rule.ParkRuleDao;
import com.eg.egsc.scp.parkinglotcomponent.dto.rule.ChargeInfoDto;
import com.eg.egsc.scp.parkinglotcomponent.dto.rule.FeeRuleDto;
import com.eg.egsc.scp.parkinglotcomponent.enmus.OperateType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.alarm.ChannelDirectType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.alarm.ControlType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.alarm.OpenWay;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.CarModeType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.rule.MonthCarTurnTemp;
import com.eg.egsc.scp.parkinglotcomponent.enmus.rule.SeatFullTurnTemp;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAccessCur;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAuthPackage;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannelRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkFeeRule;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkingLot;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkRule;
import com.eg.egsc.scp.parkinglotcomponent.redis.RedisKey;
import com.eg.egsc.scp.parkinglotcomponent.service.access.RoadGateService;
import com.eg.egsc.scp.parkinglotcomponent.service.car.impl.CarEnterParkingLotServiceImpl;
import com.eg.egsc.scp.parkinglotcomponent.service.integration.IntegrationAppService;
import com.eg.egsc.scp.parkinglotcomponent.service.integration.dto.CarInOutDto;
import com.eg.egsc.scp.parkinglotcomponent.service.park.ParkIcExitParkingLotService;
import com.eg.egsc.scp.parkinglotcomponent.service.park.ParkParkingLotInformationStoredService;
import com.eg.egsc.scp.parkinglotcomponent.service.park.dto.IcInformationDto;
import com.eg.egsc.scp.parkinglotcomponent.service.park.dto.OutParkParkingByIcDto;
import com.eg.egsc.scp.parkinglotcomponent.service.park.dto.ReBillingDto;
import com.eg.egsc.scp.parkinglotcomponent.service.rule.ParkFeeRuleService;
import com.eg.egsc.scp.parkinglotcomponent.service.rule.dto.ResponseBillingDto;
import com.eg.egsc.scp.parkinglotcomponent.service.rule.dto.RuleDetailDto;
import com.eg.egsc.scp.parkinglotcomponent.service.rule.dto.RuleDto;
import com.eg.egsc.scp.parkinglotcomponent.util.DateUtil;

/**
 * IC刷卡service实现类
 * 
 * @Class Name ParkIcExitParkingLotSerivce
 * @Author wangziqiang
 * @Create In 2017年12月28日
 */
@Service
public class ParkIcExitParkingLotServiceImpl implements ParkIcExitParkingLotService {
    @Autowired
    private ParkChannelRelDao parkChannelRelDao;// 通道关系DAO
    @Autowired
    private ParkChannelDao parkChannelDao;// 通道DTO
    @Autowired
    private AccessCurDao accessCurDao;// 在场车辆DAO
    @Autowired
    private ParkParkingLotDao parkParkingLotDao;// 停车场DTO
    @Autowired
    private ParkAuthPackageDao parkAuthPackageDao;// 通过授权套餐id获取授权套餐
    @Autowired
    private IntegrationAppService integrationAppServiceImpl;// 调用停车场应用serivce
    @Autowired
    private RoadGateService roadGateServiceImpl;// 抬杆service
    @Autowired
    private ParkRuleDao parkRuleDao;// 出入规则DAO
    @Autowired
    private ParkFeeRuleDao parkFeeRuleDao;// 收费规则
    @Autowired
    private ParkFeeRuleService parkFeeRuleServiceImpl;// 收费服务
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;// redis模板类=
    @Autowired
    private CarEnterParkingLotServiceImpl carEnterParkingLotServiceImpl;// 车辆进入逻辑serivce
    @Autowired
    private ParkExitParkingLotServiceImpl parkExitParkingLotServiceImpl;// 出场逻辑
    @Autowired
    private ParkParkingLotInformationStoredService parkParkingLotInformationStoredServiceImpl;// 存储serivce

    protected final Logger logger = LoggerFactory.getLogger(ParkIcExitParkingLotServiceImpl.class);

    @Override
    public void exitParkParkingByIc(IcInformationDto icInformationDto) {
        OutParkParkingByIcDto outParkParkingByIcDto = initOutParkParkingByIcDto(icInformationDto);
        Short direct = 0;
        if (null != outParkParkingByIcDto.getParkChannel()) {
            direct = outParkParkingByIcDto.getParkChannel().getDirect();
        }
        if (ChannelDirectType.EXPROTATION.getType().shortValue() != direct.shortValue()) {
            return;
        }
        int operateType = icInformationDto.getOperateType();
        if (OperateType.AUTO.getType().intValue() == operateType) {// 自动开闸
            judgeAutoAllFlow(outParkParkingByIcDto);
        } else {// 手动开闸
            ParkAccessCur parkAccessCur = outParkParkingByIcDto.getParkAccessCur();
            if (null != parkAccessCur) {// 有在场记录
                judgeAllFlow(outParkParkingByIcDto);
            } else {

                ParkAuthPackage parkAuthPackage = outParkParkingByIcDto.getParkAuthPackage();
                if (null != parkAuthPackage) {
                    judgeAllFlow(outParkParkingByIcDto);
                } else {
                    CarInOutDto carInOutDto = getCarInOutDto(outParkParkingByIcDto);
                    this.integrationAppServiceImpl.carInOutEvent(carInOutDto);
                }
            }
        }
    }

    /**
     * 自动开杆流程
     * 
     * @Methods Name judgeAutoAllFlow
     * @Create In 2018年1月10日 By wangziqiang
     * @param outParkParkingByIcDto void
     */
    private void judgeAutoAllFlow(OutParkParkingByIcDto outParkParkingByIcDto) {
        CarInOutDto carInOutDto = getCarInOutDto(outParkParkingByIcDto);
        parkParkingLotInformationStoredServiceImpl.autoStoreCarInformation(carInOutDto);
        // 发送应用
        this.integrationAppServiceImpl.carInOutEvent(carInOutDto);

    }

    /**
     * 手动开闸判断流程
     * 
     * @Methods Name judgeAllFlow
     * @Create In 2018年1月10日 By wangziqiang
     * @param outParkParkingByIcDto void
     */
    private void judgeAllFlow(OutParkParkingByIcDto outParkParkingByIcDto) {
        ParkAuthPackage parkAuthPackage = outParkParkingByIcDto.getParkAuthPackage();
        if (null != parkAuthPackage) {// 有套餐
            Date validStartTime = parkAuthPackage.getValidStartTime();
            Date validEndTime = parkAuthPackage.getValidEndTime();
            Date nowDate = new Date();
            boolean result = DateUtil.compareDate(validStartTime, validEndTime, nowDate);
            if (result) {// 未过有效期
                // 进一步判断业主车辆有几个
                judgeTwoAllFlow(outParkParkingByIcDto);
            } else {// 已过有效期
                // 计算通用费用
                getParkMoneyAndRedis(outParkParkingByIcDto);
            }
        } else {// 无套餐，转临停
            getParkMoneyAndRedis(outParkParkingByIcDto);
        }
    }

    /**
     * 进一步判断业主车辆有几个
     * 
     * @Methods Name judgeTwoAllFlow
     * @Create In 2018年1月22日 By wangziqiang
     * @param outParkParkingByIcDto void
     */
    private void judgeTwoAllFlow(OutParkParkingByIcDto outParkParkingByIcDto) {
        CarInOutDto carInOutDto = getCarInOutDto(outParkParkingByIcDto);
        String ownerId = outParkParkingByIcDto.getParkAuthPackage().getOwnerId();
        String outSluiceCode = outParkParkingByIcDto.getOutSluiceCode();
        RuleDto ruleDto = outParkParkingByIcDto.getRuleDto();
        if (null == ruleDto) {// 没有规则Dto
            this.integrationAppServiceImpl.carInOutEvent(carInOutDto);
            throw ExceptionFactory.createSysException("parkinglot.common.clazzisblank");
        }
        RuleDetailDto ruleDetailDto = ruleDto.getRuleDetailDto();
        boolean result = parkExitParkingLotServiceImpl.carIsOverAllowances(ownerId);
        if (!result) {// 超过了
            Integer privateParkSeatFullTurnTemp = ruleDetailDto.getPrivateParkSeatFullTurnTemp();
            if (SeatFullTurnTemp.NTI.getType().intValue() == privateParkSeatFullTurnTemp
                    .intValue()) {// 不转
                judgeThreeAllFlow(ruleDetailDto, carInOutDto, outSluiceCode);
            } else {
                carInOutDto = calculateFeelAndSaveRedis(outParkParkingByIcDto);
            }
        } else {// 未超
            judgeThreeAllFlow(ruleDetailDto, carInOutDto, outSluiceCode);
        }
        this.integrationAppServiceImpl.carInOutEvent(carInOutDto);
    }

    /**
     * 判断出人规则进入出行
     * 
     * @Methods Name judgeThreeAllFlow
     * @Create In 2018年1月23日 By wangziqiang
     * @param ruleDetailDto
     * @param carInOutDto
     * @param outSluiceCode void
     */
    private void judgeThreeAllFlow(RuleDetailDto ruleDetailDto, CarInOutDto carInOutDto,
            String outSluiceCode) {
        if (OpenWay.INTOUTLOTBYMACHINE.getType().intValue() == ruleDetailDto.getOpenWay().intValue()
                || OpenWay.INTLOTBYMAN.getType().intValue() == ruleDetailDto.getOpenWay()
                        .intValue()) {// 自动开闸
            parkExitParkingLotServiceImpl.setParkConsumeRecord(carInOutDto, null);
            sendCurOffMsg(outSluiceCode, ControlType.OPEN.getType().intValue(), carInOutDto);
        } else {// 人工开闸
            parkExitParkingLotServiceImpl.setParkConsumeRecord(carInOutDto, null);
        }
    }

    /**
     * 超过允许的在场数量进行计费
     * 
     * @Methods Name calculateFeelAndSaveRedis
     * @Create In 2018年1月22日 By wangziqiang
     * @param outParkParkingByIcDto
     * @return CarInOutDto
     */
    private CarInOutDto calculateFeelAndSaveRedis(OutParkParkingByIcDto outParkParkingByIcDto) {
        String money = "0.00";
        CarInOutDto carInOutDto = getCarInOutDto(outParkParkingByIcDto, money);
        Date endTime = outParkParkingByIcDto.getEndTime();
        ParkAccessCur parkAccessCur = outParkParkingByIcDto.getParkAccessCur();
        if (null != parkAccessCur) {// 在线车辆记录有
            ResponseBillingDto responseBillingDto = this.markCharging(parkAccessCur, endTime);
            money = responseBillingDto.getCharges();
            parkExitParkingLotServiceImpl.setParkConsumeRecord(carInOutDto, responseBillingDto);
        }
        ReBillingDto billingDto = getRillingDto(outParkParkingByIcDto, money);
        this.redisTemplate.opsForHash().put(RedisKey.KEY_CHANNEL_ID,
                outParkParkingByIcDto.getParkChannel().getUuid(), billingDto);
        return carInOutDto;
    }

    /**
     * 计算费用并且存在redis里面
     * 
     * @Methods Name getParkMoneyAndRedis
     * @Create In 2018年1月8日 By wangziqiang
     * @param outParkParkingByIcDto void
     */
    private void getParkMoneyAndRedis(OutParkParkingByIcDto outParkParkingByIcDto) {
        CarInOutDto carInOutDto = getCarInOutDto(outParkParkingByIcDto);
        if (null == outParkParkingByIcDto.getRuleDto()) {
            this.integrationAppServiceImpl.carInOutEvent(carInOutDto);
            throw ExceptionFactory.createSysException("parkinglot.common.clazzisblank");
        }
        RuleDetailDto ruleDetailDto = outParkParkingByIcDto.getRuleDto().getRuleDetailDto();
        Integer monthCarEndTurnTemp = ruleDetailDto.getMonthCarEndTurnTemp();
        if (MonthCarTurnTemp.MNTI.getType().intValue() == monthCarEndTurnTemp.intValue()) {
            judgeTwoAllFlow(outParkParkingByIcDto);
        } else {// 转临停
            carInOutDto = calculateFeelAndSaveRedis(outParkParkingByIcDto);
            this.integrationAppServiceImpl.carInOutEvent(carInOutDto);
        }
    }

    /**
     * 得到需要缴费的CARINOUT类
     * 
     * @Methods Name getCarInOutDto
     * @Create In 2018年1月8日 By wangziqiang
     * @param outParkParkingByIcDto
     * @param money
     * @return CarInOutDto
     */
    private CarInOutDto getCarInOutDto(OutParkParkingByIcDto outParkParkingByIcDto, String money) {
        CarInOutDto carInOutDto = new CarInOutDto();
        ParkAccessCur parkAccessCur = outParkParkingByIcDto.getParkAccessCur();
        if (null != parkAccessCur) {
            String carMode = parkAccessCur.getCarMode();
            carInOutDto.setCarMode(String.valueOf(carMode));
            carInOutDto.setCarType(parkAccessCur.getCarType());
            String ownerId = parkAccessCur.getOwnerId();
            carInOutDto.setOwnerId(ownerId);
            String ownerName = carEnterParkingLotServiceImpl.getOwnerNameById(ownerId);
            carInOutDto.setOwnerName(ownerName);
            carInOutDto.setParkAccessCur(parkAccessCur);
            carInOutDto.setParkCode(parkAccessCur.getParkCode());
        }
        if (null != outParkParkingByIcDto.getParkParkingLot()) {
            carInOutDto.setParkingLotId(outParkParkingByIcDto.getParkParkingLot().getUuid());
        }
        if (null != outParkParkingByIcDto.getParkAuthPackage()) {
            carInOutDto.setParkingLotId(outParkParkingByIcDto.getParkAuthPackage().getUuid());
        }
        carInOutDto.setOutTime(outParkParkingByIcDto.getEndTime());
        carInOutDto.setOutSluiceCode(outParkParkingByIcDto.getOutSluiceCode());
        carInOutDto.setDevCode(outParkParkingByIcDto.getDevCode());
        carInOutDto.setMoney(money);
        carInOutDto.setControlType(outParkParkingByIcDto.getOperateType());
        if (null != outParkParkingByIcDto.getParkChannel()) {
            carInOutDto.setChannelId(outParkParkingByIcDto.getParkChannel().getUuid());
            carInOutDto.setChannelIp(outParkParkingByIcDto.getParkChannel().getIp());
            carInOutDto.setChannelName(outParkParkingByIcDto.getParkChannel().getName());
        }
        return carInOutDto;
    }

    /**
     * 初始化缓存类
     * 
     * @Methods Name getRillingDto
     * @Create In 2018年1月8日 By wangziqiang
     * @param outParkParkingByIcDto
     * @return ReBillingDto
     */
    private ReBillingDto getRillingDto(OutParkParkingByIcDto outParkParkingByIcDto, String money) {
        ReBillingDto reBillingDto = new ReBillingDto();
        reBillingDto.setDevCode(outParkParkingByIcDto.getDevCode());
        if (null != outParkParkingByIcDto.getParkChannel()) {
            reBillingDto.setDirect(outParkParkingByIcDto.getParkChannel().getDirect());
            reBillingDto.setChannelId(outParkParkingByIcDto.getParkChannel().getUuid());
        }
        if (null != outParkParkingByIcDto.getParkParkingLot()) {
            reBillingDto.setParkingLotId(outParkParkingByIcDto.getParkParkingLot().getUuid());
        }
        reBillingDto.setMoney(money);
        reBillingDto.setOutSluiceCode(outParkParkingByIcDto.getOutSluiceCode());
        reBillingDto.setOutTime(DateUtil.dateToString(outParkParkingByIcDto.getEndTime(),
                DateUtil.YYYY_MM_DD_HH_MM_SS));
        reBillingDto.setParkAccessCur(outParkParkingByIcDto.getParkAccessCur());
        return reBillingDto;
    }

    /**
     * 通过outParkParkingByIcDto得到CarInOutDto
     * 
     * @Methods Name getCarInOutDto
     * @Create In 2018年1月8日 By wangziqiang
     * @param outParkParkingByIcDto
     * @return CarInOutDto
     */
    private CarInOutDto getCarInOutDto(OutParkParkingByIcDto outParkParkingByIcDto) {
        CarInOutDto carInOutDto = new CarInOutDto();
        ParkAccessCur parkAccessCur = outParkParkingByIcDto.getParkAccessCur();
        if (null != parkAccessCur) {
            Short enterMode = parkAccessCur.getEnterMode();
            carInOutDto.setCarMode(String.valueOf(enterMode));
            carInOutDto.setCarType(parkAccessCur.getCarType());
            carInOutDto.setOwnerId(parkAccessCur.getOwnerId());
            carInOutDto.setParkAccessCur(parkAccessCur);
            carInOutDto.setParkCode(parkAccessCur.getParkCode());
            carInOutDto.setParkingLotId(outParkParkingByIcDto.getParkParkingLot().getUuid());
        }
        carInOutDto.setOutTime(outParkParkingByIcDto.getEndTime());
        carInOutDto.setOutSluiceCode(outParkParkingByIcDto.getOutSluiceCode());
        carInOutDto.setDevCode(outParkParkingByIcDto.getDevCode());
        carInOutDto.setMoney("0.00");
        if (null != outParkParkingByIcDto.getParkChannel()) {
            carInOutDto.setChannelId(outParkParkingByIcDto.getParkChannel().getUuid());
            carInOutDto.setChannelIp(outParkParkingByIcDto.getParkChannel().getIp());
            carInOutDto.setChannelName(outParkParkingByIcDto.getParkChannel().getName());
        }
        if (null != outParkParkingByIcDto.getRuleDto()) {
            carInOutDto.setRuleName(outParkParkingByIcDto.getRuleDto().getRuleName());

        }
        carInOutDto.setControlType(outParkParkingByIcDto.getOperateType());
        return carInOutDto;
    }

    /**
     * 通过刷卡设备上报的信息初始化类
     * 
     * @Methods Name initOutParkParkingByIcDto
     * @Create In 2018年1月8日 By wangziqiang
     * @param icInformationDto
     * @return OutParkParkingByIcDto
     */
    protected OutParkParkingByIcDto initOutParkParkingByIcDto(IcInformationDto icInformationDto) {
        OutParkParkingByIcDto outParkParkingByIcDto = new OutParkParkingByIcDto();
        outParkParkingByIcDto.setEndTime(new Date());
        String devCode = icInformationDto.getDevCode();// 刷卡设备
        int operateType = icInformationDto.getOperateType();
        outParkParkingByIcDto.setOperateType(operateType);
        outParkParkingByIcDto.setDevCode(devCode);
        ParkChannel channel = this.getChannelByCode(devCode);
        outParkParkingByIcDto.setParkChannel(channel);
        if (null == channel) {
            return outParkParkingByIcDto;
        }
        // 停车场code
        String parkCode = channel.getParkCode();
        String channelId = channel.getUuid();
        String barrierGateDevCode = parkExitParkingLotServiceImpl.getBarrierGateDevCode(channelId);
        outParkParkingByIcDto.setOutSluiceCode(barrierGateDevCode);
        Object object = this.redisTemplate.opsForHash().get(RedisKey.KEY_CHANNEL_ID, channelId);
        if (object instanceof ReBillingDto) {
            ReBillingDto reBillingDto = (ReBillingDto) object;
            String carPic = reBillingDto.getCarPic();
            outParkParkingByIcDto.setOutImgurl(carPic);
        }
        // 查询在场记录
        String cardNumber = icInformationDto.getCardNumber();
        ParkAccessCur parkAccessCur = getParkAccessCur(cardNumber);
        outParkParkingByIcDto.setParkAccessCur(parkAccessCur);
        if (null != parkAccessCur) {// 有在场车辆记录
            String parkPackageId = parkAccessCur.getParkPackageId();
            ParkAuthPackage parkAuthPackage = getParkAuthPackage(parkPackageId);
            executInitDto(parkCode, outParkParkingByIcDto, parkAuthPackage);
        } else if (StringUtils.isNotBlank(cardNumber)) {
            executeNoCurInitDto(parkCode, cardNumber, outParkParkingByIcDto);
        }
        return outParkParkingByIcDto;
    }

    /**
     * 初始化ruleDto
     * 
     * @Methods Name executInitDto
     * @Create In 2018年1月10日 By wangziqiang
     * @param parkCode
     * @param outParkParkingByIcDto
     * @param parkAuthPackage void
     */
    private void executInitDto(String parkCode, OutParkParkingByIcDto outParkParkingByIcDto,
            ParkAuthPackage parkAuthPackage) {
        ParkParkingLot parkParkingLot = getParkParkingLot(parkCode);
        outParkParkingByIcDto.setParkParkingLot(parkParkingLot);
        outParkParkingByIcDto.setParkAuthPackage(parkAuthPackage);
        RuleDto ruleDto = null;
        if (null != parkAuthPackage) {// 授权套餐存在
            String parkRuleId = parkAuthPackage.getParkRuleId();
            if (StringUtils.isNotBlank(parkRuleId)) {// 规则不为空
                ruleDto = getRuleDto(parkRuleId);
            } else {// 取默认规则
                if (null != parkParkingLot) {
                    String defaultParkRuleId = parkParkingLot.getParkRuleId();
                    ruleDto = getRuleDto(defaultParkRuleId);
                }
            }
        } else {// 取默认出行规则
            if (null != parkParkingLot) {
                String defaultParkRuleId = parkParkingLot.getParkRuleId();
                ruleDto = getRuleDto(defaultParkRuleId);
            }
        }
        outParkParkingByIcDto.setRuleDto(ruleDto);
        if (null != parkParkingLot) {
            String defaultFeeRuleId = parkParkingLot.getFeeRuleId();
            FeeRuleDto feeRuleDto = getFeeRuleDto(defaultFeeRuleId);
            outParkParkingByIcDto.setFeeRuleDto(feeRuleDto);
        }

    }

    /**
     * 得到收费规则
     * 
     * @param defaultFeeRuleId
     * @Methods Name getFeeRuleDto
     * @Create In 2018年1月8日 By wangziqiang
     * @return FeeRuleDto
     */
    private FeeRuleDto getFeeRuleDto(String defaultFeeRuleId) {
        FeeRuleCondition condition = new FeeRuleCondition();
        condition.setId(defaultFeeRuleId);
        List<ParkFeeRule> list = this.parkFeeRuleDao.selectList(condition);
        if (CollectionUtils.isNotEmpty(list)) {
            ParkFeeRule parkFeeRule = list.get(0);
            FeeRuleDto feeRuleDto = new FeeRuleDto();
            BeanUtils.copyProperties(parkFeeRule, feeRuleDto);
            List<ChargeInfoDto> chargeInfoDtoList =
                    JSONObject.parseArray(parkFeeRule.getDetail(), ChargeInfoDto.class);
            feeRuleDto.setChargeInfoDtoList(chargeInfoDtoList);
            return feeRuleDto;
        }
        return null;
    }

    /**
     * 得到RuleDto ById
     * 
     * @Methods Name getRuleDto
     * @Create In 2018年1月8日 By wangziqiang
     * @param parkRuleId
     * @return RuleDto
     */
    private RuleDto getRuleDto(String parkRuleId) {
        RuleCondition condition = new RuleCondition();
        condition.setId(parkRuleId);
        List<ParkRule> list = this.parkRuleDao.selectList(condition);
        if (CollectionUtils.isNotEmpty(list)) {
            RuleDto ruleDto = new RuleDto();
            ParkRule parkRule = list.get(0);
            BeanUtils.copyProperties(parkRule, ruleDto);
            RuleDetailDto ruleDetailDto =
                    JSONObject.parseObject(parkRule.getDetail(), RuleDetailDto.class);
            ruleDto.setRuleDetailDto(ruleDetailDto);
            return ruleDto;
        }
        return null;
    }

    /**
     * 通过parkPackageId得到ParkAuthPackage
     * 
     * @Methods Name getParkAuthPackage
     * @Create In 2018年1月8日 By wangziqiang
     * @param parkPackageId
     * @return ParkAuthPackage
     */
    private ParkAuthPackage getParkAuthPackage(String parkPackageId) {
        return parkAuthPackageDao.getMapper().selectByPrimaryKey(parkPackageId);
    }

    /**
     * 通过停车场code得到ParkParkingLot
     * 
     * @Methods Name getParkParkingLot
     * @Create In 2018年1月8日 By wangziqiang
     * @param parkCode
     * @return ParkParkingLot
     */
    private ParkParkingLot getParkParkingLot(String parkCode) {
        ParkingLotCondition parkingLotCondition = new ParkingLotCondition();
        parkingLotCondition.setParkCode(parkCode);
        List<ParkParkingLot> list = this.parkParkingLotDao.selectList(parkingLotCondition);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 通过卡片number去查询在场车辆记录
     * 
     * @Methods Name getParkAccessCur
     * @Create In 2018年1月8日 By wangziqiang
     * @param cardNumber
     * @return ParkAccessCur
     */
    private ParkAccessCur getParkAccessCur(String cardNumber) {
        AccessCurCondition accessCurCondition = new AccessCurCondition();
        accessCurCondition.setCardNumber(cardNumber);
        List<ParkAccessCur> list = this.accessCurDao.selectList(accessCurCondition);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 通过decode来得到channel信息
     * 
     * @Methods Name getChannelByCode
     * @Create In 2018年1月8日 By wangziqiang
     * @param devCode
     * @return ParkChannel
     */
    private ParkChannel getChannelByCode(String devCode) {
        ChannelRelCondition condition = new ChannelRelCondition();
        condition.setDevCode(devCode);
        ParkChannelRel channelRel = getParkChannelRel(condition);
        if (null != channelRel) {
            return parkChannelDao.getMapper().selectByPrimaryKey(channelRel.getChannelId());
        }
        return null;
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
     * 计算费用
     * 
     * @Methods Name markCharging
     * @Create In 2018年1月8日 By wangziqiang
     * @param parkAccessCur
     * @param carModeInt
     * @param endTime
     * @return ResponseBillingDto
     */
    ResponseBillingDto markCharging(ParkAccessCur parkAccessCur, Date endTime) {
        try {
            int carModeInt = Integer.parseInt(CarModeType.SMALLCAR.getType());
            if (null != parkAccessCur) {
                String carMode = parkAccessCur.getCarMode();
                if (StringUtils.isNotBlank(carMode)) {
                    carModeInt = Integer.parseInt(carMode);
                }
            }
            return this.parkFeeRuleServiceImpl.universalBillingInterface(parkAccessCur, carModeInt,
                    endTime);
        } catch (ParseException e) {
            logger.info(e.getMessage());
        }
        return null;
    }

    /**
     * 根据卡号进行初始化
     * 
     * @param cardNumber
     * 
     * @Methods Name executeNoCurInitDto
     * @Create In 2018年1月10日 By wangziqiang
     * @param ownerId void
     * @param parkCode
     * @param outParkParkingByIcDto
     */
    private void executeNoCurInitDto(String parkCode, String cardNumber,
            OutParkParkingByIcDto outParkParkingByIcDto) {
        ParkAuthPackageCondition condition = new ParkAuthPackageCondition();
        condition.setCardNumber(cardNumber);
        List<ParkAuthPackage> list = parkAuthPackageDao.selectExampleList(condition);
        ParkAuthPackage parkAuthPackage = null;
        if (CollectionUtils.isNotEmpty(list)) {
            parkAuthPackage = list.get(0);
        }
        executInitDto(parkCode, outParkParkingByIcDto, parkAuthPackage);
    }
}
