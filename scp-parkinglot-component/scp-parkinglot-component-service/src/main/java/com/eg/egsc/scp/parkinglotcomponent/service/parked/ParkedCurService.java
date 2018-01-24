/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.parked;

import java.util.List;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.condition.cur.ParkedCarportCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkLedCarportRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkedCur;

/**
 * 车位功能 业务层接口
 * 
 * @author gongqian
 * @since 2018年1月12日
 */
public interface ParkedCurService {

  /**
   * 车位状态变更
   * 
   * @param parkParkedCur
   * @return int
   */
  void updateParkingStatus(ParkParkedCur parkParkedCur);

  /**
   * 更新车辆诱导屏
   * 
   * @param parkParkedCur
   * @return int
   */
  Integer updateLedCarport(ParkLedCarportRel parkLedCarportRel);

  /**
   * 实时车位表分页查询
   * 
   * @param condition
   * @return Page<ParkParkedHis>
   */
  Page<ParkParkedCur> selectPageList(ParkedCarportCondition condition);

  /**
   * 根据车位编号查询
   * 
   * @param carportCode
   * @return ParkParkedCur
   */
  List<ParkParkedCur> selectByCarportCode(String carportCode);

  /**
   * 根据车牌号码查询
   * 
   * @param carNum
   * @return ParkParkedCur
   */
  List<ParkParkedCur> selectByCarNum(String carNum);

}
