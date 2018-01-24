/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.park.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageRequest;
import com.eg.egsc.scp.parkinglotcomponent.common.exception.ExceptionFactory;
import com.eg.egsc.scp.parkinglotcomponent.condition.access.AccessHisCondition;
import com.eg.egsc.scp.parkinglotcomponent.dao.access.AccessHisDao;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkAccessHisMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAccessHis;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAccessHisCriteria;
import com.eg.egsc.scp.parkinglotcomponent.service.park.ParkAccessHisService;
import com.eg.egsc.scp.parkinglotcomponent.util.ErrorCodeConstant;
import com.eg.egsc.scp.parkinglotcomponent.util.UuidUtil;

/**
 * 车辆进出历史接口实现
 * @Class Name ParkAccessHisService
 * @Author xiaoxiaojie
 * @Create In 2017年12月25日
 */
@Service
public class ParkAccessHisServiceImpl implements ParkAccessHisService {
    
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    ParkAccessHisMapper parkAccessHisMapper;
    
    @Autowired
    private AccessHisDao accessHisDao;//数据库自定义操作接口
    
    @Override
    @Transactional
    public int insert(ParkAccessHis parkAccessHis) {
        insertValid(parkAccessHis);
        if(StringUtils.isBlank(parkAccessHis.getUuid())) {
            parkAccessHis.setUuid(UuidUtil.generate());
        }
        return parkAccessHisMapper.insert(parkAccessHis);
    }

    @Override
    @Transactional
    public int update(ParkAccessHis parkAccessHis) {
        updateValid(parkAccessHis);
        return parkAccessHisMapper.updateByPrimaryKey(parkAccessHis);
    }

    @Override
    @Transactional
    public int deleteById(String id) {
        logger.info("deleteAccessHisById {}",id);
        return parkAccessHisMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ParkAccessHis selectByPrimaryKey(String id) {
        if(StringUtils.isBlank(id)) {
            throw ExceptionFactory.createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        return parkAccessHisMapper.selectByPrimaryKey(id);
    }
    
    
    
    private void insertValid(ParkAccessHis parkAccessHis) {
        if(StringUtils.isBlank(parkAccessHis.getCarNum())
                || StringUtils.isBlank(parkAccessHis.getParkCode())) {
            throw ExceptionFactory.createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
    }
    
    
    private void updateValid(ParkAccessHis parkAccessHis) {
        if(StringUtils.isBlank(parkAccessHis.getUuid()) || StringUtils.isBlank(parkAccessHis.getCarNum()) 
                || StringUtils.isBlank(parkAccessHis.getParkCode())) {
            throw ExceptionFactory.createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        
    }
    
    public ParkAccessHis selectByCarNumAndParkCode(String carNum,String parkCode) {
        if(StringUtils.isBlank(carNum) || StringUtils.isBlank(parkCode)) {
            return null;
        }
        ParkAccessHisCriteria duc = new ParkAccessHisCriteria();
        ParkAccessHisCriteria.Criteria ducc = duc.createCriteria();
        ducc.andCarNumEqualTo(carNum);
        ducc.andParkCodeEqualTo(parkCode);
        List<ParkAccessHis> list = parkAccessHisMapper.selectByExample(duc);
        if(CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }
    
    @Override
    public Page<ParkAccessHis> selectPageList(AccessHisCondition condition) {
        PageRequest<AccessHisCondition> pageRequest =new PageRequest<>();
        pageRequest.setCurrentPage(condition.getCurrentPage());
        pageRequest.setPageSize(condition.getPageSize());
        pageRequest.setFilters(condition);      
        return accessHisDao.selectPageList(pageRequest);
    }

    @Override
    public List<ParkAccessHis> selectList(AccessHisCondition condition) {
        return accessHisDao.selectList(condition);
    }
}
