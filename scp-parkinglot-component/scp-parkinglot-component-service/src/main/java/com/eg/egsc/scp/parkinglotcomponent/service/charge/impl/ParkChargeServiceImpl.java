/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.charge.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.eg.egsc.scp.mdm.component.client.UserClient;
import com.eg.egsc.scp.mdm.component.dto.BaseUserDto;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageRequest;
import com.eg.egsc.scp.parkinglotcomponent.common.exception.ExceptionFactory;
import com.eg.egsc.scp.parkinglotcomponent.condition.authpackage.ParkAuthPackageCondition;
import com.eg.egsc.scp.parkinglotcomponent.condition.car.CarDevRelConditon;
import com.eg.egsc.scp.parkinglotcomponent.condition.charge.ChargeCondition;
import com.eg.egsc.scp.parkinglotcomponent.dao.authpackage.ParkAuthPackageDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.car.ParkCarDevRelDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.charge.ParkChargeDao;
import com.eg.egsc.scp.parkinglotcomponent.dto.charge.ChargeOnlineDto;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.CarDevRelOptType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.CarDevRelStatus;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.CarListType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.channel.ChannelDevType;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.authpackage.entity.AuthPackage;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.car.CarDevRelMapper;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.channel.ChannelMapper;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.channel.entity.ChannelRel;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.charge.entity.Charge;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkAuthPackageMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkChargeMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkRuleMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAuthPackage;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarDevRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannelRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCharge;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkPackageCarRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkPackageParkRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkRule;
import com.eg.egsc.scp.parkinglotcomponent.service.charge.ParkChargeService;
import com.eg.egsc.scp.parkinglotcomponent.service.charge.dto.ChargeDto;
import com.eg.egsc.scp.parkinglotcomponent.service.rule.dto.RuleDetailDto;
import com.eg.egsc.scp.parkinglotcomponent.util.DateUtil;
import com.eg.egsc.scp.parkinglotcomponent.util.ErrorCodeConstant;
import com.eg.egsc.scp.parkinglotcomponent.util.UuidUtil;


/**
 * 充值业务层接口实现
 * 
 * @author huangyuhong
 * @since 2018年1月12日
 */
@Service
public class ParkChargeServiceImpl implements ParkChargeService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected ParkChargeMapper parkChargeMapper;// 自定义操作接口

    @Autowired
    protected ParkChargeDao parkChargeDao;// 充值操作接口

    @Autowired
    protected ParkAuthPackageMapper parkAuthPackageMapper;// 数据库通用操作接口

    @Autowired
    protected ParkAuthPackageDao parkAuthPackageDao;// 授权套餐接口

    @Autowired
    protected ParkRuleMapper parkRuleMapper;// 进出规则通用接口

    @Autowired
    protected UserClient userClientImpl;// 主数据接口

    @Autowired
    protected CarDevRelMapper carDevRelMapper;// 数据库自定义SQL语句操作接口

    @Autowired
    protected ChannelMapper channelMapper;// 通道操作接口

    @Autowired
    protected ParkCarDevRelDao parkCarDevRelDao;// 车辆下发接口


    @Override
    @Transactional
    public int chargeOnline(ChargeOnlineDto chargeOnlineDto) {
        this.chargeOnlineValid(chargeOnlineDto);
        // 根据条件查询授权套餐
        ParkAuthPackageCondition packageCondition = new ParkAuthPackageCondition();
        packageCondition.setCarNum(chargeOnlineDto.getCarNum());
        packageCondition.setCarportCode(chargeOnlineDto.getCarportCode());
        List<AuthPackage> packageList = parkAuthPackageDao.selectList(packageCondition);
        if (CollectionUtils.isEmpty(packageList)) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        AuthPackage authPackage = packageList.get(0);
        // 创建充值实体
        ParkCharge parkCharge = new ParkCharge();
        parkCharge.setOriginalStartTime(authPackage.getValidStartTime());
        parkCharge.setOriginalEndTime(authPackage.getValidEndTime());
        Boolean hasChange = true;
        // 验证充值金额以及充值月份
        ParkRule parkRule = parkRuleMapper.selectByPrimaryKey(authPackage.getParkRuleId());
        String feeDetail = parkRule.getDetail();
        RuleDetailDto ruleDetailDto = JSON.parseObject(feeDetail, RuleDetailDto.class);
        if (ruleDetailDto.getPayMoney().intValue() != chargeOnlineDto.getMoney().intValue()) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_CHARGE_MONEY_UNEQUAL);
        }
        if (authPackage.getValidStartTime() == null && authPackage.getValidEndTime() == null) {
            hasChange = false;
            authPackage.setValidStartTime(new Date());
            authPackage.setValidEndTime(authPackage.getValidStartTime());
        } else {
            if (!DateUtil.compareDate(authPackage.getValidStartTime(),
                    DateUtil.getPlusMonthDate(authPackage.getValidEndTime(), 1),
                    chargeOnlineDto.getMonth())) {
                throw ExceptionFactory
                        .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
            }
        }
        // 更新套餐表
        Date newEndTime = DateUtil.getPlusMonthDate(authPackage.getValidEndTime(), 1);
        authPackage.setUpdateTime(new Date());
        authPackage.setValidEndTime(newEndTime);

        ParkAuthPackage parkAuthPackage = new ParkAuthPackage();
        parkAuthPackage.setUuid(authPackage.getId());
        BeanUtils.copyProperties(authPackage, parkAuthPackage);
        parkAuthPackageMapper.updateByPrimaryKey(parkAuthPackage);
        // 修改车辆下发相关
        List<String> parkCodes = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(authPackage.getParkPackageParkRel())) {
            for (ParkPackageParkRel parkPackageParkRel : authPackage.getParkPackageParkRel()) {
                parkCodes.add(parkPackageParkRel.getParkCode());
            }
        }
        List<String> carNums = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(authPackage.getParkPackageCarRel())) {
            for (ParkPackageCarRel packageCarRel : authPackage.getParkPackageCarRel()) {
                carNums.add(packageCarRel.getCarNum());
            }
        }
        this.updateCarDevRel(authPackage, hasChange, carNums, parkCodes);
        // 生成充值记录
        parkCharge.setUuid(UuidUtil.generate());
        parkCharge.setChargeNumber((short) 1);
        parkCharge.setOwnerId(authPackage.getOwnerId());
        parkCharge.setCarportCode(authPackage.getCarportCode());
        parkCharge.setStartTime(parkAuthPackage.getValidStartTime());
        parkCharge.setEndTime(parkAuthPackage.getValidEndTime());
        parkCharge.setMoney(chargeOnlineDto.getMoney());
        parkCharge.setMemo("线上缴费");
        parkCharge.setPackageId(parkAuthPackage.getUuid());
        parkCharge.setCreateTime(new Date());
        return parkChargeMapper.insert(parkCharge);
    }

    private void chargeOnlineValid(ChargeOnlineDto chargeOnlineDto) {
        if (StringUtils.isBlank(chargeOnlineDto.getCarNum())
                || StringUtils.isBlank(chargeOnlineDto.getCarportCode())
                || chargeOnlineDto.getMoney() == null || chargeOnlineDto.getMonth() == null) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
    }

    @Override
    @Transactional
    public int charge(ParkCharge parkCharge) {
        this.baseValid(parkCharge);
        AuthPackage authPackage = parkAuthPackageDao.selectByPrimaryKey(parkCharge.getPackageId());
        if (authPackage == null) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        ParkRule parkRule = parkRuleMapper.selectByPrimaryKey(authPackage.getParkRuleId());
        String feeDetail = parkRule.getDetail();
        RuleDetailDto ruleDetailDto = JSON.parseObject(feeDetail, RuleDetailDto.class);
        Boolean hasChange = this.chargeValid(parkCharge, authPackage, ruleDetailDto);
        Date newEndTime = DateUtil.getPlusMonthDate(parkCharge.getOriginalEndTime(),
                parkCharge.getChargeNumber());
        authPackage.setValidStartTime(parkCharge.getOriginalStartTime());
        authPackage.setValidEndTime(newEndTime);
        authPackage.setUpdateTime(new Date());
        // 更新套餐表
        ParkAuthPackage parkAuthPackage = new ParkAuthPackage();
        BeanUtils.copyProperties(authPackage, parkAuthPackage);
        parkAuthPackage.setUuid(authPackage.getId());
        parkAuthPackageMapper.updateByPrimaryKey(parkAuthPackage);
        List<String> carNums = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(authPackage.getParkPackageCarRel())) {
            for (ParkPackageCarRel packageCarRel : authPackage.getParkPackageCarRel()) {
                carNums.add(packageCarRel.getCarNum());
            }
        }
        List<String> parkCodes = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(parkCodes)) {
            for (ParkPackageParkRel parkPackageParkRel : authPackage.getParkPackageParkRel()) {
                parkCodes.add(parkPackageParkRel.getParkCode());
            }
        }
        this.updateCarDevRel(authPackage, hasChange, carNums, parkCodes);
        // 生成充值记录
        parkCharge.setUuid(UuidUtil.generate());
        parkCharge.setCarportCode(authPackage.getCarportCode());
        parkCharge.setOwnerId(authPackage.getOwnerId());
        if (parkCharge.getCreateTime() == null) {
            parkCharge.setCreateTime(new Date());
        }
        if (parkCharge.getUpdateTime() == null) {
            parkCharge.setUpdateTime(parkCharge.getCreateTime());
        }
        parkCharge.setStartTime(parkCharge.getOriginalStartTime());
        parkCharge.setEndTime(authPackage.getValidEndTime());
        return parkChargeMapper.insert(parkCharge);
    }


    /**
     * 充值参数验证
     * 
     * @param parkCharge
     * @param authPackage
     * @param ruleDetailDto
     * @return Boolean
     */
    private Boolean chargeValid(ParkCharge parkCharge, AuthPackage authPackage,
            RuleDetailDto ruleDetailDto) {
        Boolean hasChange = true;
        if (parkCharge.getMoney() / parkCharge.getChargeNumber() != ruleDetailDto.getPayMoney()) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_CHARGE_MONEY_UNEQUAL);
        }
        if (authPackage.getValidStartTime() != null && authPackage.getValidEndTime() != null) {
            if (parkCharge.getOriginalEndTime().getTime() != authPackage.getValidEndTime().getTime()
                    || parkCharge.getOriginalStartTime().getTime() != authPackage
                            .getValidStartTime().getTime()) {
                throw ExceptionFactory
                        .createSysException(ErrorCodeConstant.PARKINGLOT_CHARGE_CHARGE_REPEATE);
            }
        } else {
            hasChange = false;
            if (parkCharge.getOriginalStartTime().getTime() != parkCharge.getOriginalEndTime()
                    .getTime()) {
                throw ExceptionFactory
                        .createSysException(ErrorCodeConstant.PARKINGLOT_CHARGE_CHARGE_REPEATE);
            }
        }
        return hasChange;
    }


    /**
     * 更新车辆下发信息
     * 
     * @param authPackage
     * @param hasChange
     * @param carNums
     * @param parkCodes void
     */
    private void updateCarDevRel(AuthPackage authPackage, Boolean hasChange, List<String> carNums,
            List<String> parkCodes) {
        if (CollectionUtils.isEmpty(carNums) || CollectionUtils.isEmpty(parkCodes)) {
            return;
        }
        if (hasChange) {
            List<CarDevRelConditon> condition = new ArrayList<>();
            CarDevRelConditon carDevRelDto = new CarDevRelConditon();
            carDevRelDto.setCarNumList(carNums);
            carDevRelDto.setParkCodeList(parkCodes);
            condition.add(carDevRelDto);
            // 更新车辆下发表
            ParkCarDevRel parkCarDevRel = new ParkCarDevRel();
            parkCarDevRel.setStartTime(authPackage.getValidStartTime());
            parkCarDevRel.setEndTime(authPackage.getValidEndTime());
            parkCarDevRel.setOptType(CarDevRelOptType.UPDATE.getType());
            parkCarDevRel.setStatus(CarDevRelStatus.SEND.getType());
            carDevRelMapper.updateStatusByCarNumsAndParkCodes(parkCarDevRel, condition);
        } else {
            // 车辆下发表新增
            List<ParkCarDevRel> carDevRels = new ArrayList<>();
            List<ChannelRel> channelByParkCodes = channelMapper
                    .selectChannelByParkCodesAndDevType(ChannelDevType.CAMERA.getType(), parkCodes);
            // 遍历获得车牌号 车场号 设备号
            if (CollectionUtils.isNotEmpty(channelByParkCodes)) {
                this.setCarDevRels(carNums, carDevRels, channelByParkCodes);
            }
            if (CollectionUtils.isNotEmpty(carDevRels)) {
                parkCarDevRelDao.insertPackageCarRelBatch(carDevRels);
            }
        }
    }

    /**
     * 设置下发表相关数据
     * 
     * @param carNums
     * @param carDevRels
     * @param channelByParkCodes void
     */
    private void setCarDevRels(List<String> carNums, List<ParkCarDevRel> carDevRels,
            List<ChannelRel> channelByParkCodes) {
        for (String carNum : carNums) {
            for (ChannelRel channelRel : channelByParkCodes) {
                for (ParkChannelRel parkChannelRel : channelRel.getParkChannelRelList()) {
                    ParkCarDevRel parkCarDevRel = new ParkCarDevRel();
                    parkCarDevRel.setUuid(UuidUtil.generate());
                    parkCarDevRel.setCarNum(carNum);
                    parkCarDevRel.setParkCode(channelRel.getParkCode());
                    parkCarDevRel.setDevCode(parkChannelRel.getDevCode());
                    parkCarDevRel.setCreateTime(new Date());
                    parkCarDevRel.setListType(CarListType.NORMAL.getType());
                    parkCarDevRel.setOptType(CarDevRelOptType.ADD.getType());
                    parkCarDevRel.setStatus(CarDevRelStatus.SEND.getType());
                    carDevRels.add(parkCarDevRel);
                }
            }
        }
    }

    /**
     * 基本参数验证
     * 
     * @param parkCharge void
     */
    private void baseValid(ParkCharge parkCharge) {
        if (StringUtils.isBlank(parkCharge.getPackageId()) || parkCharge.getMoney() == null
                || parkCharge.getOriginalStartTime() == null
                || parkCharge.getOriginalEndTime() == null) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
    }

    @Override
    public Page<ChargeDto> selectPageChargeList(ChargeCondition condition) {
        PageRequest<ChargeCondition> pageRequest = new PageRequest<>();
        pageRequest.setCurrentPage(condition.getCurrentPage());
        pageRequest.setPageSize(condition.getPageSize());
        pageRequest.setFilters(condition);
        Page<Charge> parkChargeList = parkChargeDao.selectPageList(pageRequest);
        List<Charge> chargeList = parkChargeList.getResult();
        if (CollectionUtils.isNotEmpty(chargeList)) {
            List<ChargeDto> chargeDtoList = this.changeChargeDto(chargeList);
            return new Page<>(pageRequest, parkChargeList.getTotalCount(), chargeDtoList);
        }
        return null;
    }

    @Override
    public List<ChargeDto> selectChargeList(ChargeCondition condition) {
        List<Charge> chargeList = parkChargeDao.selectList(condition);
        if (CollectionUtils.isEmpty(chargeList)) {
            return Collections.emptyList();
        }
        if (CollectionUtils.isNotEmpty(chargeList)) {
            return changeChargeDto(chargeList);
        }
        return Collections.emptyList();
    }

    /**
     * 通过ownerID查询名字并赋值到ChargeDto
     * 
     * @param chargeList
     * @return List<ChargeDto>
     */
    private List<ChargeDto> changeChargeDto(List<Charge> chargeList) {
        HashSet<String> ownerIds = new HashSet<>();
        StringBuilder ids = new StringBuilder("");
        if (CollectionUtils.isNotEmpty(chargeList)) {
            for (Charge charge : chargeList) {
                ownerIds.add(charge.getOwnerId());
            }
        }
        if (CollectionUtils.isNotEmpty(ownerIds)) {
            for (String ownerId : ownerIds) {
                ids.append(ownerId);
                ids.append(",");
            }
            ids.deleteCharAt(ids.length() - 1);
        }
        BaseUserDto baseUserDto = new BaseUserDto();
        baseUserDto.setUuid(ids.toString());
        List<BaseUserDto> userList = userClientImpl.getUser(baseUserDto);
        Map<String, String> ownerNames = new HashMap<>();
        if (CollectionUtils.isNotEmpty(userList)) {
            for (BaseUserDto userDto : userList) {
                ownerNames.put(userDto.getUuid(), userDto.getName());
            }
        }
        List<ChargeDto> resutl = new ArrayList<>();
        for (Charge charge : chargeList) {
            ChargeDto chargeDto = new ChargeDto();
            BeanUtils.copyProperties(charge, chargeDto);
            for (ParkPackageCarRel parkPackageCarRel : charge.getParkPackageCarRel()) {
                chargeDto.getCarNumList().add(parkPackageCarRel.getCarNum());
            }
            chargeDto.setChargeMoney(charge.getMoney());
            chargeDto.setOwnerName(ownerNames.get(charge.getOwnerId()));
            chargeDto.setChargeTime(charge.getCreateTime());
            resutl.add(chargeDto);
        }
        return resutl;
    }

}
