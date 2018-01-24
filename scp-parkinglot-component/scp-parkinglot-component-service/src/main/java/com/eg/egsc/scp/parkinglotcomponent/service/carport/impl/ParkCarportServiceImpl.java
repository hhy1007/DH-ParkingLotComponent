/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.carport.impl;

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
import com.eg.egsc.scp.parkinglotcomponent.condition.park.CarportCondition;
import com.eg.egsc.scp.parkinglotcomponent.dao.carport.ParkCarportDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.carport.ParkCarportRelDao;
import com.eg.egsc.scp.parkinglotcomponent.enmus.DeleteFlag;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkAuthPackageMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkCarportMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkLedCarportRelMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAuthPackage;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAuthPackageCriteria;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarport;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkLedCarportRel;
import com.eg.egsc.scp.parkinglotcomponent.service.carport.ParkCarportService;
import com.eg.egsc.scp.parkinglotcomponent.util.Constants;
import com.eg.egsc.scp.parkinglotcomponent.util.ErrorCodeConstant;
import com.eg.egsc.scp.parkinglotcomponent.util.UuidUtil;

import io.jsonwebtoken.lang.Collections;

/**
 * 车位管理业务层接口实现
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
@Service
public class ParkCarportServiceImpl implements ParkCarportService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParkCarportMapper parkCarportMapper;// 数据库通用操作接口

    @Autowired
    private ParkCarportDao parkCarportDao;// 数据库自定义操作接口

    @Autowired
    private ParkAuthPackageMapper parkAuthpackageMapper;

    @Autowired
    private ParkLedCarportRelMapper parkLedCarportRelMapper;// 数据库通用操作接口

    @Autowired
    private ParkCarportRelDao parkCarportRelDao;

    private void valid(ParkCarport parkCarport) {
        if (StringUtils.isBlank(parkCarport.getCarportCode())) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        List<ParkCarport> list =
                parkCarportDao.selectParkCarportByCarportCode(parkCarport.getCarportCode());// 根据车位Id查询车位信息
        if (CollectionUtils.isNotEmpty(list)) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_CARPORT_PLATE_NUMBER_REPEATE);
        }
    }


    @Override
    @Transactional
    public int insert(ParkCarport parkCarport) {
        this.valid(parkCarport);
        parkCarport.setUuid(UuidUtil.generate());
        if (null == parkCarport.getCreateTime()) {
            parkCarport.setCreateTime(new Date());
        }
        if (null == parkCarport.getDeleteFlag()) {
            parkCarport.setDeleteFlag(SqlUtil.FLAG_NORMAL);
        }
        parkCarport.setDeleteFlag(DeleteFlag.NORMAL.getType());
        parkCarportMapper.insert(parkCarport);
        ParkLedCarportRel parkLedCarportRel = new ParkLedCarportRel();
        parkLedCarportRel.setUuid(UuidUtil.generate());
        parkLedCarportRel.setLedCode(UuidUtil.generate());
        parkLedCarportRel.setCarportId(parkCarport.getUuid());
        parkLedCarportRel.setCreateTime(parkCarport.getCreateTime());
        parkLedCarportRel.setCreateUser(parkCarport.getCreateUser());
        return parkLedCarportRelMapper.insert(parkLedCarportRel);
    }

    @Override
    @Transactional
    public int update(ParkCarport parkCarport) {
        if (StringUtils.isBlank(parkCarport.getCarportCode())) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        if (null == parkCarport.getUpdateTime()) {
            parkCarport.setUpdateTime(new Date());
        }
        return parkCarportMapper.updateByPrimaryKey(parkCarport);
    }

    @Override
    public int deleteByIds(List<String> ids) {
        ParkAuthPackageCriteria duc = new ParkAuthPackageCriteria();
        ParkAuthPackageCriteria.Criteria ducc = duc.createCriteria();
        ducc.andCarportCodeIn(ids);
        ducc.andDeleteFlagEqualTo(SqlUtil.FLAG_DELETE);
        List<ParkAuthPackage> parkAuthPackagList = parkAuthpackageMapper.selectByExample(duc);// 查詢服務套餐表
        if (CollectionUtils.isNotEmpty(parkAuthPackagList)) {// 车位是否已绑定查詢服務套餐
            throw ExceptionFactory.createSysException(
                    ErrorCodeConstant.PARKINGLOT_CARPORT_PACKAGE_PLATE_NUMBER_REPEATE);
        }
        return parkCarportDao.deleteByIds(ids);
    }

    @Override
    public Page<ParkCarport> selectPageList(CarportCondition condition) {
        PageRequest<CarportCondition> pageRequest = new PageRequest<>();
        pageRequest.setCurrentPage(condition.getCurrentPage());
        pageRequest.setPageSize(condition.getPageSize());
        pageRequest.setFilters(condition);
        return parkCarportDao.selectPageList(pageRequest);
    }

    @Override
    public List<ParkCarport> selectList(CarportCondition condition) {
        return parkCarportDao.selectList(condition);
    }

    @Override
    public Page<ParkCarport> selectByParkId(CarportCondition condition) {
        if (StringUtils.isNotBlank(condition.getCarportCode())) {
            condition.setCarportCode("%" + condition.getCarportCode() + "%");
        }
        PageRequest<CarportCondition> pageRequest = new PageRequest<>();
        pageRequest.setCurrentPage(condition.getCurrentPage());
        pageRequest.setPageSize(condition.getPageSize());
        pageRequest.setFilters(condition);
        return parkCarportDao.selectByParkId(pageRequest);
    }

    private void insertBatchCarportAndCarportRel(List<ParkCarport> subParkCarportList,
            List<ParkLedCarportRel> parkLedCarportRels) {
        if (CollectionUtils.isNotEmpty(subParkCarportList)) {
            for (ParkCarport parkCarport : subParkCarportList) {
                this.valid(parkCarport);
                parkCarport.setUuid(UuidUtil.generate());// 把每个车位id生成一个随机数
                if (null == parkCarport.getCreateTime()) {// 创建的时间是否为null
                    parkCarport.setCreateTime(new Date());// 获取当前时间
                }
                if (null == parkCarport.getDeleteFlag()) {
                    parkCarport.setDeleteFlag(SqlUtil.FLAG_NORMAL);
                }
            }
            parkCarportDao.insertBatchCarport(subParkCarportList);
            for (ParkCarport parkCarport2 : subParkCarportList) {
                ParkLedCarportRel parkLedCarportRel = new ParkLedCarportRel();
                parkLedCarportRel.setUuid(UuidUtil.generate());
                parkLedCarportRel.setCarportId(parkCarport2.getUuid());
                parkLedCarportRel.setLedCode(UuidUtil.generate());
                parkLedCarportRel.setCreateTime(parkCarport2.getCreateTime());
                parkLedCarportRel.setCreateUser(parkCarport2.getCreateUser());
                parkLedCarportRels.add(parkLedCarportRel);
            }
            parkCarportRelDao.insertBatchCarportRel(parkLedCarportRels);
            parkLedCarportRels.clear();
            subParkCarportList.clear();// 清空集合
        }
    }

    @Override
    @Transactional
    public int insertBatchCarport(List<ParkCarport> parkCarports) {
        Integer sumCount = Constants.SUM_COUNCT;// 记录批量新增车位返回影响的总行数
        if (!Collections.isEmpty(parkCarports)) {
            Integer pageSize = Constants.PAGESIZE;// 每次插入500条数据
            Integer totalCount = parkCarports.size();// 总条数
            Integer pageSum = (int) Math.ceil(totalCount.doubleValue() / pageSize.doubleValue());// 插入的次数
            List<ParkCarport> subParkCarportList;// 保存截取的数据
            List<ParkLedCarportRel> parkLedCarportRels = new ArrayList<>();
            for (int i = 1; i <= pageSum; i++) {
                if (i == pageSum) {// 是否是最后一页
                    subParkCarportList = parkCarports.subList((i - Constants.PAGEINDEX) * pageSize, totalCount);// 截取到最后一条
                } else {
                    subParkCarportList = parkCarports.subList((i - Constants.PAGEINDEX) * pageSize, i * pageSize);// 每次截取500条数据
                }
                sumCount += subParkCarportList.size();
                this.insertBatchCarportAndCarportRel(subParkCarportList, parkLedCarportRels);
            }
        }
        return sumCount;
    }


    @Override
    public ParkCarport selectByPrimaryKey(String uuid) {
        return parkCarportDao.selectByPrimaryKey(uuid);
    }

    @Override
    public int updateEnableFlagByUuid(String uuid, Short enableFlag) {
        return parkCarportDao.updateEnableFlagByUuid(uuid, enableFlag);
    }


}
