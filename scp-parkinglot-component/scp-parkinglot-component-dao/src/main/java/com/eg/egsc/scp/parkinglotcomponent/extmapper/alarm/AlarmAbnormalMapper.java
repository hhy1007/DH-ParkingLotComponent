/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.extmapper.alarm;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 临停车长时间未出场告警持久层接口
 * 
 * @author gongqian
 * @since 2018年1月22日
 */
public interface AlarmAbnormalMapper {

  /**
   * 查询车辆在场记录和车位实时停车得到停车时长
   * 
   * @param carNum
   * @return List<Map<String, Object>>
   */
  public List<Map<String, Object>> selectAlarmAbnormal(@Param("carNum") String carNum);
}
