/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.channel.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageRequest;
import com.eg.egsc.scp.parkinglotcomponent.common.exception.ExceptionFactory;
import com.eg.egsc.scp.parkinglotcomponent.condition.authpackage.ParkAuthPackageCondition;
import com.eg.egsc.scp.parkinglotcomponent.condition.channel.ChannelRelCondition;
import com.eg.egsc.scp.parkinglotcomponent.dao.authpackage.ParkAuthPackageDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.car.ParkCarDevRelDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.channel.ParkChannelRelDao;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.CarDevRelOptType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.CarDevRelStatus;
import com.eg.egsc.scp.parkinglotcomponent.enmus.channel.ChannelDevType;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.authpackage.entity.AuthPackage;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.car.CarDevRelMapper;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.channel.ChannelRelMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkChannelMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkChannelRelMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarDevRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannelRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkPackageCarRel;
import com.eg.egsc.scp.parkinglotcomponent.service.channel.ParkChannelRelService;
import com.eg.egsc.scp.parkinglotcomponent.util.Constants;
import com.eg.egsc.scp.parkinglotcomponent.util.ErrorCodeConstant;
import com.eg.egsc.scp.parkinglotcomponent.util.UuidUtil;

/**
 * 车场通道邦定管理业务层接口实现
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
@Service
public class ParkChannelRelServiceImpl implements ParkChannelRelService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParkChannelRelMapper parkChannelRelMapper;// 数据库通用操作接口

    @Autowired
    private ParkChannelRelDao parkChannelRelDao;// 数据库自定义操作接口

    @Autowired
    private ParkChannelMapper parkChannelMapper;// 数据库通用操作接口

    @Autowired
    private ParkAuthPackageDao parkAuthPackageDao;// 数据库自定义操作接口

    @Autowired
    private ParkCarDevRelDao parkCarDevRelDao;// 数据库自定义操作接口

    @Autowired
    private CarDevRelMapper carDevRelMapper;// 数据库自定义操作接口

    @Autowired
    private ChannelRelMapper channelRelMapper;// 数据库自定义操作接口

    private void insertValid(ParkChannelRel parkChannelRel) {
        if (StringUtils.isBlank(parkChannelRel.getDevCode())) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        if (StringUtils.isBlank(parkChannelRel.getChannelId())) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        List<ParkChannelRel> list =
                parkChannelRelDao.selectParkChannelRelByDevCode(parkChannelRel.getDevCode());
        if (!CollectionUtils.isEmpty(list)) {
            throw ExceptionFactory.createSysException(
                    ErrorCodeConstant.PARKINGLOT_CHANNEL_REL_PLATE_NUMBER_REPEATE);
        }
    }

    private void updateValid(ParkChannelRel parkChannelRel) {
        if (StringUtils.isBlank(parkChannelRel.getDevCode())) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        if (StringUtils.isBlank(parkChannelRel.getChannelId())) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        List<ParkChannelRel> list =
                parkChannelRelDao.selectParkChannelRelByDevCodeIsNotId(parkChannelRel);
        if (!CollectionUtils.isEmpty(list)) {
            throw ExceptionFactory.createSysException(
                    ErrorCodeConstant.PARKINGLOT_CHANNEL_REL_PLATE_NUMBER_REPEATE);
        }
    }

    @Override
    @Transactional
    public int insert(ParkChannelRel parkChannelRel) {
        this.insertValid(parkChannelRel);
        parkChannelRel.setUuid(UuidUtil.generate());
        if (null == parkChannelRel.getCreateTime()) {
            parkChannelRel.setCreateTime(new Date());
        }
        if (null != parkChannelRel.getDevType()
                && ChannelDevType.CAMERA.getType() == parkChannelRel.getDevType().shortValue()) {
            this.insertCarDevRel(parkChannelRel);
        }
        return parkChannelRelMapper.insert(parkChannelRel);
    }

    /**
     * 车辆下发表新增
     * 
     * @param ParkChannelRel
     */
    private void insertCarDevRel(ParkChannelRel parkChannelRel) {
        // 车辆下发表新增，查询相关信息
        String channelId = parkChannelRel.getChannelId();
        ParkChannel channel = parkChannelMapper.selectByPrimaryKey(channelId);
        String parkCode = channel.getParkCode();
        ParkAuthPackageCondition packageCondition = new ParkAuthPackageCondition();
        packageCondition.setParkCode(parkCode);
        List<AuthPackage> packageList = parkAuthPackageDao.selectList(packageCondition);
        Map<String, AuthPackage> carNumMap = new HashMap<>();
        if (CollectionUtils.isNotEmpty(packageList)) {
            this.dealSameCarNum(packageList, carNumMap);
        }
        // 插入到车辆下发表中
        List<ParkCarDevRel> carDevRelList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(carNumMap.entrySet())) {
            for (Entry<String, AuthPackage> entry : carNumMap.entrySet()) {
                ParkCarDevRel carDevRel = new ParkCarDevRel();
                AuthPackage authPackageEntry = entry.getValue();
                carDevRel.setCarNum(entry.getKey());
                carDevRel.setUuid(UuidUtil.generate());
                carDevRel.setStartTime(authPackageEntry.getValidStartTime());
                carDevRel.setEndTime(authPackageEntry.getValidEndTime());
                carDevRel.setParkCode(parkCode);
                carDevRel.setCreateTime(new Date());
                carDevRel.setOptType(CarDevRelOptType.ADD.getType());
                carDevRel.setStatus(CarDevRelStatus.SEND.getType());
                carDevRelList.add(carDevRel);
            }
        }
        if (CollectionUtils.isNotEmpty(carDevRelList)) {
            parkCarDevRelDao.insertPackageCarRelBatch(carDevRelList);
        }
    }

    /**
     * 处理相同车牌号，选择到期时间最迟的套餐相关信息
     * 
     * @param packageList
     * @param carNumMap void
     */
    private void dealSameCarNum(List<AuthPackage> packageList, Map<String, AuthPackage> carNumMap) {
        for (AuthPackage authPackage : packageList) {
            for (ParkPackageCarRel carRel : authPackage.getParkPackageCarRel()) {
                String carNum = carRel.getCarNum();
                if (carNumMap.get(carNum) == null) {
                    carNumMap.put(carNum, authPackage);
                } else {
                    Date oldEndTime = carNumMap.get(carNum).getValidEndTime();
                    Date newEndTime = authPackage.getValidEndTime();
                    if (oldEndTime != null && newEndTime != null
                            && oldEndTime.getTime() < newEndTime.getTime()) {
                        carNumMap.put(carNum, authPackage);
                    }
                }
            }
        }
    }



    @Override
    @Transactional
    public int update(ParkChannelRel parkChannelRel) {
        this.updateValid(parkChannelRel);
        if (null == parkChannelRel.getUpdateTime()) {
            parkChannelRel.setUpdateTime(new Date());
        }
        ParkChannelRel oldChannelRel =
                parkChannelRelMapper.selectByPrimaryKey(parkChannelRel.getUuid());
        if(null == oldChannelRel) {
            return Constants.RESULT;
        }
        if (null != oldChannelRel.getDevType()
                && oldChannelRel.getDevCode().equals(parkChannelRel.getDevCode())) {
            if (oldChannelRel.getDevType().shortValue() != ChannelDevType.CAMERA.getType()
                    && parkChannelRel.getDevType().shortValue() == ChannelDevType.CAMERA
                            .getType()) {
                this.insert(parkChannelRel);
            }
            if (oldChannelRel.getDevType().shortValue() == ChannelDevType.CAMERA.getType()
                    && parkChannelRel.getDevType().shortValue() != ChannelDevType.CAMERA
                            .getType()) {
                List<ParkChannelRel> parkChannelRels = new ArrayList<>();
                parkChannelRels.add(oldChannelRel);
                this.deleteCarDevRels(parkChannelRels);
                this.insertCarDevRel(parkChannelRel);
            }
        } else {
            if (null != oldChannelRel.getDevType()
                    && oldChannelRel.getDevType().shortValue() == ChannelDevType.CAMERA.getType()) {
                List<ParkChannelRel> parkChannelRels = new ArrayList<>();
                parkChannelRels.add(oldChannelRel);
                this.deleteCarDevRels(parkChannelRels);
            }
            if (null != oldChannelRel.getDevType() && parkChannelRel
                    .getDevType().shortValue() == ChannelDevType.CAMERA.getType()) {
                this.insertCarDevRel(parkChannelRel);
            }
        }
        return parkChannelRelMapper.updateByPrimaryKey(parkChannelRel);
    }

    @Override
    public int deleteByIds(List<String> ids) {
        List<ParkChannelRel> channelRels = channelRelMapper.selectByIds(ids);
        deleteCarDevRels(channelRels);
        return parkChannelRelDao.deleteByIds(ids);
    }

    /**
     * 根据设备号批量删除下发信息
     * 
     * @param channelRels void
     */
    private void deleteCarDevRels(List<ParkChannelRel> channelRels) {
        List<String> devCodes = new ArrayList<>();
        for (ParkChannelRel parkChannelRel : channelRels) {
            if (ChannelDevType.CAMERA.getType() == parkChannelRel.getDevType().shortValue()) {
                devCodes.add(parkChannelRel.getDevCode());
            }
        }
        if (CollectionUtils.isNotEmpty(devCodes)) {
            ParkCarDevRel carDevRel = new ParkCarDevRel();
            carDevRel.setStatus(CarDevRelStatus.SEND.getType());
            carDevRel.setOptType(CarDevRelOptType.DEL.getType());
            carDevRelMapper.updateStatusByDevCodes(carDevRel, devCodes);
        }
    }

    @Override
    public Page<ParkChannelRel> selectPageList(ChannelRelCondition condition) {
        PageRequest<ChannelRelCondition> pageRequest = new PageRequest<>();
        pageRequest.setCurrentPage(condition.getCurrentPage());
        pageRequest.setPageSize(condition.getPageSize());
        pageRequest.setFilters(condition);
        return parkChannelRelDao.selectPageList(pageRequest);
    }

    @Override
    public List<ParkChannelRel> selectList(ChannelRelCondition condition) {
        return parkChannelRelDao.selectList(condition);
    }

    @Override
    public List<ParkChannelRel> selectChannelRelByIds(List<String> channeIds) {
        return parkChannelRelDao.selectChannelRelByIds(channeIds);
    }

    @Override
    public List<ParkChannelRel> selectChannelRelByDevCode(String devCode) {
        return parkChannelRelDao.selectChannelRelByDevCode(devCode);
    }

    @Override
    public int deleteByDevCode(String devCode) {
        return parkChannelRelDao.deleteByDevCode(devCode);
    }

    @Override
    public ParkChannelRel selectByPrimaryKey(String uuid) {
        return parkChannelRelMapper.selectByPrimaryKey(uuid);
    }
}
