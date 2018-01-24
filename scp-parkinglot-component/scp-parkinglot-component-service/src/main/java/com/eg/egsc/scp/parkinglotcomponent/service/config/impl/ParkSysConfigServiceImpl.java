/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.config.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageRequest;
import com.eg.egsc.scp.parkinglotcomponent.condition.config.ParkSysConfigCondition;
import com.eg.egsc.scp.parkinglotcomponent.dao.config.ParkSysConfigDao;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkSysConfigMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkSysConfig;
import com.eg.egsc.scp.parkinglotcomponent.service.config.ParkSysConfigService;

/**
 * 系统设置表接口实现
 * 
 * @author liudongteng
 * @since 2018年1月22日
 */
@Service
public class ParkSysConfigServiceImpl implements ParkSysConfigService {
  protected final Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private ParkSysConfigDao parkSysConfigDao;
  @Autowired
  private ParkSysConfigMapper parkSysConfigMapper;

  @Override
  public Page<ParkSysConfig> selectPageList(ParkSysConfigCondition condition) {
    PageRequest<ParkSysConfigCondition> pageRequest = new PageRequest<>();
    pageRequest.setCurrentPage(condition.getCurrentPage());
    pageRequest.setPageSize(condition.getPageSize());
    pageRequest.setFilters(condition);
    return parkSysConfigDao.selectPageList(pageRequest);

  }

  @Override
  @Transactional
  public int updateConfigByConfigSeq(ParkSysConfig parkSysConfig) {
    this.updateValid(parkSysConfig);
    if (null == parkSysConfig.getConfigSeq()) {
      parkSysConfig.getConfigSeq();
    }
    return parkSysConfigMapper.updateByPrimaryKeySelective(parkSysConfig);
  }

  private void updateValid(ParkSysConfig parkSysConfig) {

  }

}
