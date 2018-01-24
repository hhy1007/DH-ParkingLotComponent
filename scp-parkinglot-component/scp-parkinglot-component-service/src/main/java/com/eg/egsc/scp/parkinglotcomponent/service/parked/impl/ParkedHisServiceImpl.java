/**
 * 
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.parked.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageRequest;
import com.eg.egsc.scp.parkinglotcomponent.common.exception.ExceptionFactory;
import com.eg.egsc.scp.parkinglotcomponent.condition.cur.ParkedCarportCondition;
import com.eg.egsc.scp.parkinglotcomponent.dao.parked.ParkedHisDao;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkedHis;
import com.eg.egsc.scp.parkinglotcomponent.service.parked.ParkedHisService;
import com.eg.egsc.scp.parkinglotcomponent.util.ErrorCodeConstant;

/**
 * 历史车位业务层接口实现
 * 
 * @author liudongteng
 * @since 2018年1月12日
 */
@Service
public class ParkedHisServiceImpl implements ParkedHisService {
  protected final Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 数据库自定义接口
   */
  @Autowired
  private ParkedHisDao parkedHisDao;


  @Override
  public Page<ParkParkedHis> selectPageList(ParkedCarportCondition condition) {
    PageRequest<ParkedCarportCondition> pageRequest = new PageRequest<>();
    pageRequest.setCurrentPage(condition.getCurrentPage());
    pageRequest.setPageSize(condition.getPageSize());
    pageRequest.setFilters(condition);
    return parkedHisDao.selectPageList(pageRequest);
  }

  @Override
  public List<ParkParkedHis> selectByCarportCode(String carportCode) {
    if (StringUtils.isBlank(carportCode)) {
      throw ExceptionFactory.createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
    }
    return parkedHisDao.selectByCarportCode(carportCode);
  }

  @Override
  public List<ParkParkedHis> selectByCarNum(String carNum) {
    if (StringUtils.isBlank(carNum)) {
      throw ExceptionFactory.createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
    }
    return parkedHisDao.selectByCarNum(carNum);
  }

}
