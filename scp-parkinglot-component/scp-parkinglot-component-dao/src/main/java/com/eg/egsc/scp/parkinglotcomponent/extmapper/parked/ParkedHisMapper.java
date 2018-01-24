/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.extmapper.parked;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.condition.cur.ParkedCarportCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkedHis;

/**
 * 扩展历史车位类
 * 
 * @author liudongteng
 * @since 2018年1月12日
 */
public interface ParkedHisMapper {
  /**
   * 历史车位分页查询
   * 
   * @param condition
   * @return List<ParkParkedHis>
   */
  Page<ParkParkedHis> selectPageList(ParkedCarportCondition condition);

  /**
   * 历史车位根据车位号查询
   * 
   * @param carportCode
   * @return List<ParkParkedHis>
   */
  List<ParkParkedHis> selectByCarportCode(@Param("carportCode") String carportCode);

  /**
   * 历史车位根据车牌号查询
   * 
   * @param carNum
   * @return List<ParkParkedHis>
   */
  List<ParkParkedHis> selectByCarNum(@Param("carNum") String carNum);
}
