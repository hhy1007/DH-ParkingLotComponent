/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.carcapture.impl;

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
import com.eg.egsc.scp.parkinglotcomponent.condition.carcapture.CarCaptureCondition;
import com.eg.egsc.scp.parkinglotcomponent.dao.carcapture.ParkCarCaptureDao;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkCarCaptureMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarCapture;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarCaptureCriteria;
import com.eg.egsc.scp.parkinglotcomponent.service.carcapture.CarCaptureService;
import com.eg.egsc.scp.parkinglotcomponent.util.ErrorCodeConstant;
import com.eg.egsc.scp.parkinglotcomponent.util.UuidUtil;

/**
 * 抓拍业务层接口实现
 * 
 * @Class Name CarCaptureService
 * @Author xiangdaoping
 * @Create In 2017年12月15日
 */
@Service
public class CarCaptureServiceImpl implements CarCaptureService {

  protected final Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private ParkCarCaptureDao carCaptureDao;// 数据库自定义操作接口

  @Autowired
  ParkCarCaptureMapper parkCarCaptureMapper;

  @Override
  public Page<ParkCarCapture> selectPageList(CarCaptureCondition condition) {
    PageRequest<CarCaptureCondition> pageRequest = new PageRequest<>();
    pageRequest.setCurrentPage(condition.getCurrentPage());
    pageRequest.setPageSize(condition.getPageSize());
    pageRequest.setFilters(condition);
    return carCaptureDao.selectPageList(pageRequest);

  }

  @Override
  public List<ParkCarCapture> selectList(CarCaptureCondition condition) {
    return carCaptureDao.selectList(condition);
  }

  @Override
  @Transactional
  public int insert(ParkCarCapture parkCarCapture) {
    if(StringUtils.isBlank(parkCarCapture.getUuid())) {
        parkCarCapture.setUuid(UuidUtil.generate());
    }  
    return parkCarCaptureMapper.insert(parkCarCapture);

  }

  @Override
  @Transactional
  public int deleteById(String id) {
    logger.info("deleteById {}", id);
    return parkCarCaptureMapper.deleteByPrimaryKey(id);
  }

  @Override
  @Transactional
  public int update(ParkCarCapture parkCarCapture) {
    updateValid(parkCarCapture);
    return parkCarCaptureMapper.updateByPrimaryKey(parkCarCapture);
  }

  @Override
  public ParkCarCapture selectByPrimaryKey(String id) {
    if (StringUtils.isBlank(id)) {
      throw ExceptionFactory.createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
    }
    return parkCarCaptureMapper.selectByPrimaryKey(id);
  }




  private void updateValid(ParkCarCapture parkCarCapture) {
    if (StringUtils.isBlank(parkCarCapture.getUuid())
        || StringUtils.isBlank(parkCarCapture.getCarNum())) {
      throw ExceptionFactory.createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
    }
    ParkCarCapture carCapture = selectByCarNum(parkCarCapture.getCarNum());
    if (carCapture == null) {
      throw ExceptionFactory.createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
    }
  }

  public ParkCarCapture selectByCarNum(String carNum) {
    ParkCarCaptureCriteria duc = new ParkCarCaptureCriteria();
    ParkCarCaptureCriteria.Criteria ducc = duc.createCriteria();
    ducc.andCarNumEqualTo(carNum);
    List<ParkCarCapture> list = parkCarCaptureMapper.selectByExample(duc);
    if (CollectionUtils.isNotEmpty(list)) {
      return list.get(0);
    }
    return null;
  }
}
