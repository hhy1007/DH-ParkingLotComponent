/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.extmapper.alarm;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 车位即将到期预警持久层接口
 * 
 * @author gongqian
 * @since 2018年1月22日
 */
public interface AlarmArrearMapper {

  /**
   * 根据车辆授权套餐表查询套餐有效期结束时间
   * 
   * @param carportCode
   * @return List<Map<String, Object>>
   */
  public List<Map<String, Object>> selectAlarmArrear(@Param("carportCode") String carportCode);
}
