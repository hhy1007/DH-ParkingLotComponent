/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.parked;

import java.util.List;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.condition.cur.ParkedCarportCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkedHis;

/**
 * 历史车位业务层接口
 * 
 * @author liudongteng
 * @since 2018年1月12日
 */
public interface ParkedHisService {

  /**
   * 历史车位表分页查询
   * 
   * @param condition
   * @return Page<ParkParkedHis>
   */
  Page<ParkParkedHis> selectPageList(ParkedCarportCondition condition);


  /**
   * 根据车位编号查询
   * 
   * @param carportCode
   * @return ParkParkedHis
   */
  List<ParkParkedHis> selectByCarportCode(String carportCode);

  /**
   * 根据车牌号码查询
   * 
   * @param carNum
   * @return ParkParkedHis
   */
  List<ParkParkedHis> selectByCarNum(String carNum);
}
