/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.channel.impl;

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
import com.eg.egsc.scp.parkinglotcomponent.condition.channel.ChannelCondition;
import com.eg.egsc.scp.parkinglotcomponent.dao.channel.ParkChannelDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.channel.ParkChannelRelDao;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkChannelMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannelRel;
import com.eg.egsc.scp.parkinglotcomponent.service.channel.ParkChannelService;
import com.eg.egsc.scp.parkinglotcomponent.util.ErrorCodeConstant;
import com.eg.egsc.scp.parkinglotcomponent.util.UuidUtil;

/**
 * 车场通道管理业务层接口实现
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
@Service
public class ParkChannelServiceImpl implements ParkChannelService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParkChannelMapper parkChannelMapper;// 数据库通用操作接口

    @Autowired
    private ParkChannelDao parkChannelDao;// 数据库自定义操作接口

    @Autowired
    private ParkChannelRelDao parkChannelRelDao;

    private void insertValid(ParkChannel parkChannel) {
        if (StringUtils.isBlank(parkChannel.getName())) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        if (StringUtils.isBlank(parkChannel.getParkCode())) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        if (null == parkChannel.getType()) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        if (null == parkChannel.getDirect()) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        List<ParkChannel> list = parkChannelDao.selectParkChannelByName(parkChannel.getName());
        if (CollectionUtils.isNotEmpty(list)) {
            throw ExceptionFactory.createSysException(
                    ErrorCodeConstant.PARKINGLOT_CHANNEL_NAME_PLATE_NUMBER_REPEATE);
        }
    }

    private void updateValid(ParkChannel parkChannel) {
        if (StringUtils.isBlank(parkChannel.getName())) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        if (StringUtils.isBlank(parkChannel.getParkCode())) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        if (null == parkChannel.getType()) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        if (null == parkChannel.getDirect()) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        List<ParkChannel> list = parkChannelDao.selectParkChannelByNameIsNotId(parkChannel);
        if (CollectionUtils.isNotEmpty(list)) {
            throw ExceptionFactory.createSysException(
                    ErrorCodeConstant.PARKINGLOT_CHANNEL_NAME_PLATE_NUMBER_REPEATE);
        }
    }

    @Override
    @Transactional
    public int insert(ParkChannel parkChannel) {
        this.insertValid(parkChannel);
        parkChannel.setUuid(UuidUtil.generate());
        if (null == parkChannel.getCreateTime()) {
            parkChannel.setCreateTime(new Date());
        }
        if (null == parkChannel.getDeleteFlag()) {
            parkChannel.setDeleteFlag(SqlUtil.FLAG_NORMAL);
        }
        return parkChannelMapper.insert(parkChannel);
    }

    @Override
    @Transactional
    public int update(ParkChannel parkChannel) {
        this.updateValid(parkChannel);
        if (null == parkChannel.getUpdateTime()) {
            parkChannel.setUpdateTime(new Date());
        }
        return parkChannelMapper.updateByPrimaryKey(parkChannel);
    }

    @Override
    @Transactional
    public int deleteByIds(List<String> ids) {
        List<ParkChannelRel> parkChannelRelList = parkChannelRelDao.selectChannelRelByIds(ids);// 查询通道与通道绑定信息
        if (CollectionUtils.isNotEmpty(parkChannelRelList)) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_CHANNEL_PLATE_NUMBER_REPEATE);
        }
        return parkChannelDao.deleteByIds(ids);
    }

    @Override
    public Page<ParkChannel> selectPageList(ChannelCondition condition) {
        PageRequest<ChannelCondition> pageRequest = new PageRequest<>();
        pageRequest.setCurrentPage(condition.getCurrentPage());
        pageRequest.setPageSize(condition.getPageSize());
        pageRequest.setFilters(condition);
        return parkChannelDao.selectPageList(pageRequest);
    }

    @Override
    public List<ParkChannel> selectList(ChannelCondition condition) {
        return parkChannelDao.selectList(condition);
    }

    @Override
    public ParkChannel selectByPrimaryKey(String uuid) {
        return parkChannelDao.selectByPrimaryKey(uuid);
    }

}
