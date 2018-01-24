/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.reservation.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageRequest;
import com.eg.egsc.scp.parkinglotcomponent.common.exception.ExceptionFactory;
import com.eg.egsc.scp.parkinglotcomponent.condition.reservation.ParkReservationCondition;
import com.eg.egsc.scp.parkinglotcomponent.dao.reservation.ParkReservationDao;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkReservationMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkReservation;
import com.eg.egsc.scp.parkinglotcomponent.service.reservation.ParkReservationService;
import com.eg.egsc.scp.parkinglotcomponent.util.ErrorCodeConstant;
import com.eg.egsc.scp.parkinglotcomponent.util.UuidUtil;

/**
 * 线上预约接口实现
 * 
 * @author huangyuhong
 * @since 2018年1月12日
 */
@Service
public class ParkReservationServiceImpl implements ParkReservationService {
    
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParkReservationMapper parkReservationMapper;// 数据库通用操作接口

    @Autowired
    private ParkReservationDao parkReservationDao;// 数据库自定义操作接口

    @Override
    @Transactional
    public int insert(ParkReservation parkReservation) {
        this.valid(parkReservation);
        parkReservation.setUuid(UuidUtil.generate());
        if (parkReservation.getCreateTime() == null) {
            parkReservation.setCreateTime(new Date());
        }
        return parkReservationMapper.insert(parkReservation);
    }
    
    private void valid(ParkReservation parkReservation) {
        if (StringUtils.isBlank(parkReservation.getCarNum())
                || StringUtils.isBlank(parkReservation.getParkCode())) {
            throw ExceptionFactory.createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
    }

    @Override
    @Transactional
    public int update(ParkReservation parkReservation) {
        if (parkReservation.getUuid() == null) {
            return 0;
        }
        if (parkReservation.getUpdateTime() == null) {
            parkReservation.setUpdateTime(new Date());
        }
        return parkReservationMapper.updateByPrimaryKey(parkReservation);
    }

    @Override
    @Transactional
    public int deleteByIds(List<String> ids) {
        logger.info("deleteByIds: {}", ids);
        return parkReservationDao.deleteByIds(ids);
    }

    @Override
    public Page<ParkReservation> selectPageList(ParkReservationCondition condition) {
        PageRequest<ParkReservationCondition> pageRequest = new PageRequest<>();
        pageRequest.setCurrentPage(condition.getCurrentPage());
        pageRequest.setPageSize(condition.getPageSize());
        pageRequest.setFilters(condition);
        return parkReservationDao.selectPageList(pageRequest);
    }

    @Override
    public List<ParkReservation> selectList(ParkReservationCondition condition) {
        return parkReservationDao.selectList(condition);
    }

    @Override
    public ParkReservation selectByPrimaryKey(String id) {
        if(StringUtils.isBlank(id)) {
            return null;
        }
        return parkReservationDao.selectById(id);
    }

}
