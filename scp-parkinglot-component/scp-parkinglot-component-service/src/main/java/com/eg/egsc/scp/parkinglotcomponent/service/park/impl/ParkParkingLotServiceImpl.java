/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.park.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageRequest;
import com.eg.egsc.scp.parkinglotcomponent.basic.util.SqlUtil;
import com.eg.egsc.scp.parkinglotcomponent.common.exception.ExceptionFactory;
import com.eg.egsc.scp.parkinglotcomponent.condition.park.ParkingLotCondition;
import com.eg.egsc.scp.parkinglotcomponent.dao.channel.ParkChannelDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.channel.ParkChannelRelDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.park.ParkParkingLotDao;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.CarDevRelOptType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.CarDevRelStatus;
import com.eg.egsc.scp.parkinglotcomponent.enmus.channel.ChannelDevType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.dev.DevType;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.car.CarDevRelMapper;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.channel.entity.Channel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkParkingLotMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarDevRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannelRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkingLot;
import com.eg.egsc.scp.parkinglotcomponent.service.park.ParkParkingLotService;
import com.eg.egsc.scp.parkinglotcomponent.util.ErrorCodeConstant;
import com.eg.egsc.scp.parkinglotcomponent.util.UuidUtil;

/**
 * 停车场管理业务层接口实现
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
@Service
public class ParkParkingLotServiceImpl implements ParkParkingLotService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParkParkingLotMapper parkParkingLotMapper;// 数据库通用操作接口

    @Autowired
    private ParkParkingLotDao parkParkingLotDao;// 数据库自定义操作接口

    @Autowired
    private ParkChannelDao parkChannelDao;

    @Autowired
    private ParkChannelRelDao parkChannelRelDao;

    @Autowired
    private CarDevRelMapper carDevRelMapper;// 数据库自定义操作接口

    @Override
    @Transactional
    public int insert(ParkParkingLot parkParkingLot) {
        this.insertValid(parkParkingLot);
        parkParkingLot.setUuid(UuidUtil.generate());
        if (null == parkParkingLot.getCreateTime()) {
            parkParkingLot.setCreateTime(new Date());
        }
        if (null == parkParkingLot.getDeleteFlag()) {
            parkParkingLot.setDeleteFlag(SqlUtil.FLAG_NORMAL);
        }
        return parkParkingLotMapper.insert(parkParkingLot);
    }

    private void insertValid(ParkParkingLot parkParkingLot) {
        if (StringUtils.isBlank(parkParkingLot.getParkCode())
                || StringUtils.isBlank(parkParkingLot.getParkName())) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        ParkParkingLot parkingLot = parkParkingLotDao.selectParkParkingLot(parkParkingLot);
        if (null != parkingLot) {
            throw ExceptionFactory.createSysException(
                    ErrorCodeConstant.PARKINGLOT_PARKINGLOT_PLATE_NUMBER_REPEATE);
        }
    }

    private void updateValid(ParkParkingLot parkParkingLot) {
        if (StringUtils.isBlank(parkParkingLot.getParkCode())
                || StringUtils.isBlank(parkParkingLot.getParkName())) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        ParkParkingLot parkingLot = parkParkingLotDao.selectParkParkingLotByName(parkParkingLot);
        if (null != parkingLot) {
            throw ExceptionFactory.createSysException(
                    ErrorCodeConstant.PARKINGLOT_PARKINGLOT_PLATE_NUMBER_REPEATE);
        }
    }

    @Override
    @Transactional
    public int update(ParkParkingLot parkParkingLot) {
        this.updateValid(parkParkingLot);
        if (null == parkParkingLot.getUpdateTime()) {
            parkParkingLot.setUpdateTime(new Date());
        }
        return parkParkingLotMapper.updateByPrimaryKey(parkParkingLot);
    }

    @Override
    @Transactional
    public int deleteByIds(List<String> ids) {
        List<Channel> channelList = parkChannelDao.selectParkingLotAndChannel(ids);// 查询通道信息
        List<ParkChannelRel> channelRels = new ArrayList<>();
        List<String> channelIds = new ArrayList<>();
        if (!CollectionUtils.isEmpty(channelList)) {
            for (Channel channel : channelList) {
                channelIds.add(channel.getId());
            }
        }
        if (!CollectionUtils.isEmpty(channelIds)) {
            List<ParkChannelRel> channelRelList = parkChannelRelDao.selectByChannelIds(channelIds);// 根据通道id查询通道绑定信息
            if (CollectionUtils.isNotEmpty(channelRelList)) {
                for (ParkChannelRel parkChannelRel : channelRelList) {
                    if (DevType.CARMERA.getType().equals(parkChannelRel.getDevType())) {
                        channelRels.add(parkChannelRel);
                    }
                }
            }
        }
        if (CollectionUtils.isNotEmpty(channelRels)) {
            this.deleteCarDevRels(channelRels);
        }
        if (CollectionUtils.isNotEmpty(channelIds)) {
            this.parkChannelRelDao.deleteByChannelRelIds(channelIds);
            this.parkChannelDao.deleteByIds(channelIds);
        }
        return parkParkingLotDao.deleteByIds(ids);// 删除停车场信息
    }

    /**
     * 根据设备号批量删除下发信息
     * 
     * @param channelRels void
     */
    private void deleteCarDevRels(List<ParkChannelRel> channelRels) {
        List<String> devCodes = new ArrayList<>();
        for (ParkChannelRel parkChannelRel : channelRels) {
            if (parkChannelRel.getDevType().shortValue() == ChannelDevType.CAMERA.getType()) {
                devCodes.add(parkChannelRel.getDevCode());
            }
        }
        if (CollectionUtils.isNotEmpty(devCodes)) {
            ParkCarDevRel carDevRel = new ParkCarDevRel();
            carDevRel.setOptType(CarDevRelOptType.DEL.getType());
            carDevRel.setStatus(CarDevRelStatus.SEND.getType());
            carDevRelMapper.updateStatusByDevCodes(carDevRel, devCodes);
        }
    }

    @Override
    public Page<ParkParkingLot> selectPageList(ParkingLotCondition condition) {
        PageRequest<ParkingLotCondition> pageRequest = new PageRequest<>();
        pageRequest.setCurrentPage(condition.getCurrentPage());
        pageRequest.setPageSize(condition.getPageSize());
        pageRequest.setFilters(condition);
        return parkParkingLotDao.selectPageList(pageRequest);
    }

    @Override
    public List<ParkParkingLot> selectList(ParkingLotCondition condition) {
        return parkParkingLotDao.selectList(condition);
    }

    @Override
    public ParkParkingLot selectByPrimaryKey(String uuid) {
        return parkParkingLotDao.selectByPrimaryKey(uuid);
    }

}
