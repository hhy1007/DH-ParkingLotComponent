/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.config;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.condition.config.ParkSysConfigCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkSysConfig;

/**
 * 系统设置表业务层接口
 * 
 * @author liudongteng
 * @since 2018年1月22日
 */
public interface ParkSysConfigService {
  /**
   * 系统设置表分页查询
   * 
   * @param condition
   * @return Page<ParkSysConfig>
   */
  Page<ParkSysConfig> selectPageList(ParkSysConfigCondition condition);
  
  /**
   * 根据配置序列修改表
   * 
   * @param parkSysConfig
   * @return int
   */
  int updateConfigByConfigSeq(ParkSysConfig parkSysConfig);
}
