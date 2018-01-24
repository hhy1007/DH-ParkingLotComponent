/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.carport.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageRequest;
import com.eg.egsc.scp.parkinglotcomponent.common.exception.ExceptionFactory;
import com.eg.egsc.scp.parkinglotcomponent.condition.park.CarportRelCondition;
import com.eg.egsc.scp.parkinglotcomponent.dao.carport.ParkCarportRelDao;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkLedCarportRelMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkLedCarportRel;
import com.eg.egsc.scp.parkinglotcomponent.service.carport.ParkCarportRelService;
import com.eg.egsc.scp.parkinglotcomponent.util.ErrorCodeConstant;
import com.eg.egsc.scp.parkinglotcomponent.util.UuidUtil;

/**
 * 诱导屏绑定车位管理业务层接口实现
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
@Service
public class ParkCarportRelServiceImpl implements ParkCarportRelService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParkLedCarportRelMapper parkLedCarportRelMapper;// 数据库通用操作接口

    @Autowired
    private ParkCarportRelDao parkCarportRelDao;// 数据库自定义操作接口


    private void valid(ParkLedCarportRel parkLedCarportRel) {
        if (StringUtils.isBlank(parkLedCarportRel.getLedCode())) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        if (StringUtils.isBlank(parkLedCarportRel.getCarportId())) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
    }

    @Override
    public int insert(ParkLedCarportRel parkLedCarportRel) {
        this.valid(parkLedCarportRel);
        parkLedCarportRel.setUuid(UuidUtil.generate());
        if (null == parkLedCarportRel.getCreateTime()) {
            parkLedCarportRel.setCreateTime(new Date());
        }
        return parkLedCarportRelMapper.insert(parkLedCarportRel);
    }

    @Override
    public int update(ParkLedCarportRel parkLedCarportRel) {
        this.valid(parkLedCarportRel);
        return parkLedCarportRelMapper.updateByPrimaryKey(parkLedCarportRel);
    }

    @Override
    public int deleteByIds(List<String> ids) {
        return parkCarportRelDao.deleteByIds(ids);
    }

    @Override
    public Page<ParkLedCarportRel> selectPageList(CarportRelCondition condition) {
        PageRequest<CarportRelCondition> pageRequest = new PageRequest<>();
        pageRequest.setCurrentPage(condition.getCurrentPage());
        pageRequest.setPageSize(condition.getPageSize());
        pageRequest.setFilters(condition);
        return parkCarportRelDao.selectPageList(pageRequest);
    }

    @Override
    public List<ParkLedCarportRel> selectList(CarportRelCondition condition) {
        return parkCarportRelDao.selectList(condition);
    }

    @Override
    public List<ParkLedCarportRel> selectLedCarportRelByLedCode(String ledCode) {
        return parkCarportRelDao.selectLedCarportRelByLedCode(ledCode);
    }

    @Override
    public int deleteByLedCode(String ledCode) {
        return parkCarportRelDao.deleteByLedCode(ledCode);
    }

    @Override
    public ParkLedCarportRel selectByPrimaryKey(String uuid) {
        return parkLedCarportRelMapper.selectByPrimaryKey(uuid);
    }

}
