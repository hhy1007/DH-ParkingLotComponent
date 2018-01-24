/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.rule.impl;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageRequest;
import com.eg.egsc.scp.parkinglotcomponent.basic.util.SqlUtil;
import com.eg.egsc.scp.parkinglotcomponent.common.exception.ExceptionFactory;
import com.eg.egsc.scp.parkinglotcomponent.condition.rule.FeeRuleCondition;
import com.eg.egsc.scp.parkinglotcomponent.dao.access.AccessCurDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.park.ParkParkingLotDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.rule.ParkFeeRuleDao;
import com.eg.egsc.scp.parkinglotcomponent.dto.rule.ChargeDetailDto;
import com.eg.egsc.scp.parkinglotcomponent.dto.rule.ChargeInfoDto;
import com.eg.egsc.scp.parkinglotcomponent.dto.rule.FeeRuleDto;
import com.eg.egsc.scp.parkinglotcomponent.dto.rule.FreeTimeDto;
import com.eg.egsc.scp.parkinglotcomponent.dto.rule.NonPeakPeriodDto;
import com.eg.egsc.scp.parkinglotcomponent.dto.rule.PeakPeriodDto;
import com.eg.egsc.scp.parkinglotcomponent.enmus.access.NeedPay;
import com.eg.egsc.scp.parkinglotcomponent.enmus.access.PayedMoney;
import com.eg.egsc.scp.parkinglotcomponent.enmus.carport.CarportType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.rule.BaseFlagFeeRule;
import com.eg.egsc.scp.parkinglotcomponent.enmus.rule.CarType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.rule.RuleType;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.access.entity.AccessCur;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAccessCur;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkFeeRule;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkingLot;
import com.eg.egsc.scp.parkinglotcomponent.service.rule.ParkFeeRuleService;
import com.eg.egsc.scp.parkinglotcomponent.service.rule.dto.ResponseBillingDto;
import com.eg.egsc.scp.parkinglotcomponent.util.Constants;
import com.eg.egsc.scp.parkinglotcomponent.util.DateUtil;
import com.eg.egsc.scp.parkinglotcomponent.util.ErrorCodeConstant;
import com.eg.egsc.scp.parkinglotcomponent.util.UuidUtil;

/**
 * 收费规则管理管理业务层接口实现
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
@Service
public class ParkFeeRuleServiceImpl implements ParkFeeRuleService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParkFeeRuleDao parkFeeRuleDao;// 数据库自定义操作接口

    @Autowired
    private ParkParkingLotDao parkParkingLotDao;

    @Autowired
    private AccessCurDao accessCurDao;

    private ResponseBillingDto toCalculateMoney(AccessCur accessCur,
            ResponseBillingDto responseBillingDto, String money, Integer theStopTime) {
        String[] submoney = money.split("\\.");// 把金额的小数点切掉
        String sumMoney = submoney[0] + submoney[1];// 把收费金额单位为元转换成分
        DecimalFormat df = Constants.DF;
        responseBillingDto.setTheStopTime(theStopTime);
        if (null != accessCur.getPayedMoney()
                && PayedMoney.ZERO.getType() < Integer.parseInt(sumMoney)
                && PayedMoney.ZERO.getType() < accessCur.getPayedMoney()) {// 总金额大于o元 并且
            responseBillingDto.setCharges(String.valueOf(
                    df.format((double) ((Integer.parseInt(sumMoney) - accessCur.getPayedMoney())
                            / (double) Constants.MONEYPOINTS))));// 减去缴费金额
            return responseBillingDto;
        } else {
            responseBillingDto.setCharges(String.valueOf(df.format(
                    (double) ((Integer.parseInt(sumMoney)) / (double) Constants.MONEYPOINTS))));
            return responseBillingDto;
        }
    }

    @Override
    public ResponseBillingDto universalBillingInterface(ParkAccessCur parkAccessCur,
            Integer carType, Date endTime) throws ParseException {
        if (null == carType) {// 车辆类型是否为null
            carType = CarType.SMALLCAR.getType();// null 设置默认值为0
        }
        if (null == endTime) {// 停车的结束时间是否为null
            endTime = new Date();// null 设置当前时间
        }
        ResponseBillingDto responseBillingDto = new ResponseBillingDto();
        if (null == parkAccessCur || null != parkAccessCur.getCarportType()
                && CarportType.MONTHWARRANTY.getType() == parkAccessCur.getCarportType()) {// 入场记录是否有效或者是月保车
            responseBillingDto.setCharges("0.00");
            return responseBillingDto;
        }
        if (null != parkAccessCur.getCarportType()
                && CarportType.INTHEPARK.getType() == parkAccessCur.getCarportType()) {// 临停车
            AccessCur accessCur =
                    accessCurDao.selectAccessCurAndParkingLotAndParkFeeRuleByPrimaryKey(
                            parkAccessCur.getUuid());// 根据入场记录的id查询入场记录，停车场，收费规则的信息
            if (null != accessCur && NeedPay.YES.getType() == accessCur.getNeedPay()) {// 是否需要缴费
                ParkFeeRule parkFeeRule = accessCur.getParkingLot().getParkFeeRule();// 获取收费规则信息
                FeeRuleDto feeRuleDto = new FeeRuleDto();
                BeanUtils.copyProperties(parkFeeRule, feeRuleDto);// 把parkFeeRule字段的值复制给feeRuleDto
                Long stopTime = ((endTime.getTime() - accessCur.getCreateTime().getTime())
                        / Constants.TIMEPOINTS);// 停车的时长
                Integer theStopTime = stopTime.intValue();// 转成成integer
                String money = this.computationsFeeRule(accessCur.getCreateTime(), endTime, carType,
                        feeRuleDto);// 按收费规则计算
                return this.toCalculateMoney(accessCur, responseBillingDto, money, theStopTime);
            }
        }
        responseBillingDto.setCharges("0.00");
        return responseBillingDto;
    }

    @Override
    public int insert(FeeRuleDto feeRuleDto) {
        ParkFeeRule parkFeeRule = new ParkFeeRule();
        BeanUtils.copyProperties(feeRuleDto, parkFeeRule);
        this.insertValid(parkFeeRule);
        parkFeeRule.setDetail(JSON.toJSONString(feeRuleDto.getChargeInfoDtoList()));
        parkFeeRule.setUuid(UuidUtil.generate());
        if (null == parkFeeRule.getCreateTime()) {
            parkFeeRule.setCreateTime(new Date());
        }
        if (null == parkFeeRule.getDeleteFlag()) {
            parkFeeRule.setDeleteFlag(SqlUtil.FLAG_NORMAL);
        }
        return parkFeeRuleDao.insert(parkFeeRule);
    }

    @Override
    public int update(FeeRuleDto feeRuleDto) {
        ParkFeeRule parkFeeRule = new ParkFeeRule();
        BeanUtils.copyProperties(feeRuleDto, parkFeeRule);
        this.updateValid(parkFeeRule);
        parkFeeRule.setDetail(JSON.toJSONString(feeRuleDto.getChargeInfoDtoList()));
        if (null == parkFeeRule.getUpdateTime()) {
            parkFeeRule.setUpdateTime(new Date());
        }
        return parkFeeRuleDao.updateByPrimaryKey(parkFeeRule);
    }

    private void insertValid(ParkFeeRule parkFeeRule) {
        if (StringUtils.isBlank(parkFeeRule.getRuleName())) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        List<ParkFeeRule> list =
                parkFeeRuleDao.selectParkFeeRuleByRuleName(parkFeeRule.getRuleName());
        if (CollectionUtils.isNotEmpty(list)) {
            throw ExceptionFactory.createSysException(
                    ErrorCodeConstant.PARKINGLOT_FEE_RULE_NAME_PLATE_NUMBER_REPEATE);
        }
    }

    private void updateValid(ParkFeeRule parkFeeRule) {
        if (StringUtils.isBlank(parkFeeRule.getRuleName())) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        List<ParkFeeRule> list = parkFeeRuleDao.selectParkFeeRuleByRuleNameIsNotId(parkFeeRule);
        if (CollectionUtils.isNotEmpty(list)) {
            throw ExceptionFactory.createSysException(
                    ErrorCodeConstant.PARKINGLOT_FEE_RULE_NAME_PLATE_NUMBER_REPEATE);
        }
    }

    @Override
    public int deleteByIds(List<String> ids) {
        List<ParkParkingLot> list =
                parkParkingLotDao.selectParkParkingLotAndParkPackageParkRel(ids);
        if (CollectionUtils.isNotEmpty(list)) {// 收费规则是否已经使用
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_FEE_RULE_PLATE_NUMBER_REPEATE);
        }
        return parkFeeRuleDao.deleteByIds(ids);
    }

    @Override
    public Page<ParkFeeRule> selectPageList(FeeRuleCondition condition) {
        PageRequest<FeeRuleCondition> pageRequest = new PageRequest<>();
        pageRequest.setCurrentPage(condition.getCurrentPage());
        pageRequest.setPageSize(condition.getPageSize());
        pageRequest.setFilters(condition);
        return parkFeeRuleDao.selectPageList(pageRequest);
    }

    @Override
    public List<ParkFeeRule> selectList(FeeRuleCondition condition) {
        return parkFeeRuleDao.selectList(condition);
    }

    private ChargeInfoDto getChargeInfoDto(List<ChargeInfoDto> chargeInfoDtoList, Integer carType) {
        ChargeInfoDto chargeInfoDto = new ChargeInfoDto();// 收费信息
        if (CollectionUtils.isNotEmpty(chargeInfoDtoList)) {// 集合是否为空
            for (ChargeInfoDto chargeInfo : chargeInfoDtoList) {
                if (carType.equals(chargeInfo.getCarType())) {// 比较车辆的类型
                    chargeInfoDto = chargeInfo;
                    break;// 跳出循环
                }
            }

        }
        return chargeInfoDto;
    }

    private Integer peakPeriodCharge(Date nonPeakPeriodEndTimeAddDay, PeakPeriodDto peakPeriodDto,
            NonPeakPeriodDto nonPeakPeriodDto, Date nonPeakPeriodStartTime,
            Integer paringTimeInteger) {
        Long nonPeakPeriodParingChargeTime =
                (nonPeakPeriodEndTimeAddDay.getTime() - nonPeakPeriodStartTime.getTime())
                        / Constants.TIMEPOINTS;// 停车非高峰期时长
        Integer nonPeakPeriodEachTime = (int) Math.ceil(nonPeakPeriodParingChargeTime.doubleValue()
                / nonPeakPeriodDto.getEach().doubleValue());// 得到非高峰期按收费时间计算
        Integer nonPeakPeriodMoney = nonPeakPeriodEachTime * nonPeakPeriodDto.getCash();// 非高峰期的收费金额
        Integer peakPeriodParingChargeTime =
                paringTimeInteger - nonPeakPeriodParingChargeTime.intValue();// 停车的时长-非高峰期的时长=在高峰期的时长
        Integer peakPeriodEachTime = (int) Math.ceil(
                peakPeriodParingChargeTime.doubleValue() / peakPeriodDto.getEach().doubleValue());// 高峰期按收费时间计算
        Integer peakPeriodMoney = peakPeriodEachTime * peakPeriodDto.getCash();// 得到高峰期总金额
        return peakPeriodMoney + nonPeakPeriodMoney;// 收费总金额
    }

    private Integer nonPeakPeriodCharge(PeakPeriodDto peakPeriodDto,
            NonPeakPeriodDto nonPeakPeriodDto, Integer paringTimeInteger,
            Long peakPeriodParingTime) {
        if (paringTimeInteger > peakPeriodParingTime.intValue()) {// 停车的时间在非高峰期内结束的时间经过高峰期在非高峰期内
            Integer peakPeriodEachTime = (int) Math.ceil(
                    peakPeriodParingTime.doubleValue() / peakPeriodDto.getEach().doubleValue());// 高峰期按收费时间计算
            Integer peakPeriodMoney = peakPeriodEachTime * peakPeriodDto.getCash();// 得到高峰期总金额
            Integer nonPeakPeriodparingTime = paringTimeInteger - peakPeriodParingTime.intValue();// 得到非高峰期停车分钟数
            Integer nonPeakPeriodEachTime = (int) Math.ceil(nonPeakPeriodparingTime.doubleValue()
                    / nonPeakPeriodDto.getEach().doubleValue());// 得到非高峰期按收费时间计算
            Integer nonPeakPeriodMoney = nonPeakPeriodEachTime * nonPeakPeriodDto.getCash();
            return peakPeriodMoney + nonPeakPeriodMoney;// 收费总金额
        } else {
            Integer eachTime = (int) Math.ceil(
                    paringTimeInteger.doubleValue() / nonPeakPeriodDto.getEach().doubleValue());// 按收费时间计算
            return eachTime * nonPeakPeriodDto.getCash();// 收费总金额
        }
    }

    private String chargeMoney(ChargeInfoDto chargeInfoDto, Integer paringTimeInteger,
            Date startTime, Date endTime) throws ParseException {
        ChargeDetailDto chargeDetailDto = chargeInfoDto.getChargeDetailDto();// 获取价格明細对象
        PeakPeriodDto peakPeriodDto = chargeDetailDto.getPeakPeriodDto();// 获取高峰期对象
        NonPeakPeriodDto nonPeakPeriodDto = chargeDetailDto.getNonPeakPeriodDto();// 获取非高峰期对象
        Date peakPeriodStartTime = DateUtil.stringToDate(peakPeriodDto.getStartTime(),
                DateUtil.DEFAULT_TIME_FORMAT_HM);// 把高峰期的开始时间转换成date
        Date peakPeriodEndTime =
                DateUtil.stringToDate(peakPeriodDto.getEndTime(), DateUtil.DEFAULT_TIME_FORMAT_HM);// 把高峰期的结束时间转换成date
        Date nonPeakPeriodStartTime = DateUtil.stringToDate(nonPeakPeriodDto.getStartTime(),
                DateUtil.DEFAULT_TIME_FORMAT_HM);
        Date nonPeakPeriodEndTime = DateUtil.stringToDate(nonPeakPeriodDto.getEndTime(),
                DateUtil.DEFAULT_TIME_FORMAT_HM);
        Date startTimeSubYearMonthDay = DateUtil.dateSubYearMonthDay(startTime);// 去掉当前的年月日
        Date endTimeSubYearMonthDay = DateUtil.dateSubYearMonthDay(endTime);
        Integer money = null;
        String sumMoney = null;
        DecimalFormat df = Constants.DF;// 保留两位小数
        if (DateUtil.compareDate(peakPeriodStartTime, peakPeriodEndTime, startTimeSubYearMonthDay)
                && DateUtil.compareDate(peakPeriodStartTime, peakPeriodEndTime,
                        endTimeSubYearMonthDay)) {// 在高峰期内
            Date nonPeakPeriodEndTimeAddDay = DateUtil.dateAddDay(nonPeakPeriodEndTime);// 非高峰期加一天
            Long nonPeakPeriodParingTime =
                    (nonPeakPeriodEndTimeAddDay.getTime() - nonPeakPeriodStartTime.getTime())
                            / Constants.TIMEPOINTS;// 非高峰期时长
            if (paringTimeInteger > nonPeakPeriodParingTime.intValue()) {// 停车的时间在高峰期结束的时间是否在同一天之内
                money = this.peakPeriodCharge(nonPeakPeriodEndTimeAddDay, peakPeriodDto,
                        nonPeakPeriodDto, nonPeakPeriodStartTime, paringTimeInteger);// 收费总金额
                sumMoney = df.format(money.doubleValue() / (double) Constants.MONEYPOINTS);// 转换成元
            } else {
                Integer eachTime = (int) Math.ceil(
                        paringTimeInteger.doubleValue() / peakPeriodDto.getEach().doubleValue());// 每30分钟收一次钱
                money = eachTime * peakPeriodDto.getCash();// 收费总金额
                sumMoney = df.format(money.doubleValue() / (double) Constants.MONEYPOINTS);// 转换成元
            }
        } else if (DateUtil.compareDate(peakPeriodStartTime, peakPeriodEndTime,
                startTimeSubYearMonthDay)
                && !DateUtil.compareDate(nonPeakPeriodStartTime, nonPeakPeriodEndTime,
                        endTimeSubYearMonthDay)) {
            // 停车的开始时间在高峰期内，结束时间在非高峰期内
            Long peakPeriodParingTimeLong =
                    (peakPeriodEndTime.getTime() - startTimeSubYearMonthDay.getTime())
                            / Constants.TIMEPOINTS;// 得到高峰期停车分钟数
            Integer peakPeriodEachTime = (int) Math.ceil(
                    peakPeriodParingTimeLong.doubleValue() / peakPeriodDto.getEach().doubleValue());// 高峰期按收费时间计算
            Integer peakPeriodMoney = peakPeriodEachTime * peakPeriodDto.getCash();// 得到高峰期总金额

            Integer nonPeakPeriodParingTime =
                    paringTimeInteger - peakPeriodParingTimeLong.intValue();// 得到非高峰期停车分钟数
            Integer nonPeakPeriodEachTime = (int) Math.ceil(nonPeakPeriodParingTime.doubleValue()
                    / nonPeakPeriodDto.getEach().doubleValue());// 得到非高峰期按收费时间计算
            Integer nonPeakPeriodMoney = nonPeakPeriodEachTime * nonPeakPeriodDto.getCash();
            money = peakPeriodMoney + nonPeakPeriodMoney;// 收费总金额
            sumMoney = df.format(money.doubleValue() / (double) Constants.MONEYPOINTS);// 转换成元
        } else if (DateUtil.compareDate(peakPeriodStartTime, peakPeriodEndTime,
                endTimeSubYearMonthDay)// 停车的开始时间在非高峰期内 并且在结束时间高峰期内
                && !DateUtil.compareDate(nonPeakPeriodStartTime, nonPeakPeriodEndTime,
                        startTimeSubYearMonthDay)) {
            Long peakPeriodParingTimeLong =
                    (endTimeSubYearMonthDay.getTime() - peakPeriodStartTime.getTime())
                            / Constants.TIMEPOINTS;// 得到高峰期停车分钟数
            Integer peakPeriodEachTime = (int) Math.ceil(
                    peakPeriodParingTimeLong.doubleValue() / peakPeriodDto.getEach().doubleValue());// 高峰期按收费时间计算
            Integer peakPeriodMoney = peakPeriodEachTime * peakPeriodDto.getCash();// 得到高峰期总金额
            Integer nonPeakPeriodParingTime =
                    paringTimeInteger - peakPeriodParingTimeLong.intValue();// 得到非高峰期停车分钟数
            Integer nonPeakPeriodEachTime = (int) Math.ceil(nonPeakPeriodParingTime.doubleValue()
                    / nonPeakPeriodDto.getEach().doubleValue());// 得到非高峰期按收费时间计算
            Integer nonPeakPeriodMoney = nonPeakPeriodEachTime * nonPeakPeriodDto.getCash();
            money = peakPeriodMoney + nonPeakPeriodMoney;// 收费总金额
            sumMoney = df.format(money.doubleValue() / (double) Constants.MONEYPOINTS);// 转换成元
        } else if (!DateUtil.compareDate(nonPeakPeriodStartTime, nonPeakPeriodEndTime,
                startTimeSubYearMonthDay)
                && !DateUtil.compareDate(nonPeakPeriodStartTime, nonPeakPeriodEndTime,
                        endTimeSubYearMonthDay)) {// 非高峰期内
            Long peakPeriodParingTime =
                    (peakPeriodEndTime.getTime() - peakPeriodStartTime.getTime())
                            / Constants.TIMEPOINTS;// 高峰期时长
            money = this.nonPeakPeriodCharge(peakPeriodDto, nonPeakPeriodDto, paringTimeInteger,
                    peakPeriodParingTime);
            sumMoney = df.format(money.doubleValue() / (double) Constants.MONEYPOINTS);// 转换成元
        }
        if (money != null && money > chargeInfoDto.getHighestFee()) {// 每期的收费金额大于全天最高收费
            return df.format(
                    chargeInfoDto.getHighestFee().doubleValue() / (double) Constants.MONEYPOINTS);// 全天最高收费
        }
        return sumMoney;
    }

    @Override
    public String computationsFeeRule(Date startTime, Date endTime, Integer carType,
            FeeRuleDto feeRuleDto) throws ParseException {
        if (null == startTime || null == endTime || null == carType || null == feeRuleDto) {// 开始时间，结束时间，车辆类型，计费规则是否有效
            return "0.00";
        }
        if (startTime.getTime() > endTime.getTime()) {
            throw ExceptionFactory.createSysException(
                    ErrorCodeConstant.PARKINGLOT_FEE_RULE_TIME_PLATE_NUMBER_REPEATE);
        }
        List<ChargeInfoDto> chargeInfoDtoList =
                JSON.parseArray(feeRuleDto.getDetail(), ChargeInfoDto.class);
        ChargeInfoDto chargeInfoDto = this.getChargeInfoDto(chargeInfoDtoList, carType);
        Long paringTimeLong = (endTime.getTime() - startTime.getTime()) / Constants.TIMEPOINTS;// 得到停车分钟数
        Integer paringTimeInteger = paringTimeLong.intValue();// Long转换integer
        DecimalFormat df = Constants.DF;// 保留两位小数
        if (paringTimeInteger > Constants.DAYPOINTS) {
            return df.format(
                    chargeInfoDto.getHighestFee().doubleValue() / (double) Constants.MONEYPOINTS);
        }
        FreeTimeDto freeTimeDto = chargeInfoDto.getFreeTime();
        if (RuleType.TIME.getType().equals(feeRuleDto.getRuleType())
                && paringTimeInteger > freeTimeDto.getTime()) {// 按次并且停车的时间要大于免费时间
            return df.format(
                    chargeInfoDto.getTimeCharge().doubleValue() / (double) Constants.MONEYPOINTS);// 按次直接返回按次收费金额(单位为分转换成元)
        } else if (RuleType.INTERVAL.getType().equals(feeRuleDto.getRuleType())) {// 按时
            if (BaseFlagFeeRule.NO.getType().equals(freeTimeDto.getIsContain())
                    && paringTimeInteger < freeTimeDto.getTime()) {// 如果免费的时间是不包含的，停车的时间要小于免费的时间，不收钱
                return "0.00";
            } else if (BaseFlagFeeRule.YES.getType().equals(freeTimeDto.getIsContain())
                    && paringTimeInteger <= freeTimeDto.getTime()) {// 如果免费的时间是包含的。停车的时间要小于等于免费的时间，不收钱
                return "0.00";
            } else if (BaseFlagFeeRule.YES.getType().equals(chargeInfoDto.getAvailable())) {// 启用全天最高收费
                return df.format(chargeInfoDto.getHighestFee().doubleValue()
                        / (double) Constants.MONEYPOINTS);
            } else {
                return this.chargeMoney(chargeInfoDto, paringTimeInteger, startTime, endTime);
            }
        }
        return "0.00";
    }

    @Override
    public ParkFeeRule selectByPrimaryKey(String uuid) {
        return parkFeeRuleDao.selectByPrimaryKey(uuid);
    }


}
