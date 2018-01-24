/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.extmapper.parked;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.condition.cur.ParkedCarportCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkLedCarportRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkedCur;

/**
 * 车位功能 持久层接口
 * 
 * @author gongqian
 * @since 2018年1月12日
 */
public interface ParkedCurMapper {

  /**
   * 更新车位状态
   * 
   * @param parkParkedCur
   * @return int
   */
  public int updateParkType(ParkParkedCur parkParkedCur);

  /**
   * 根据车位ID查询区域空余车位数
   * 
   * @param carportId
   * @return int
   */
  public Integer selectAreaIdleByCarportId(ParkLedCarportRel parkLedCarportRel);

  /**
   * 实时车位表分页查询
   * 
   * @param condition
   * @return List<ParkParkedHis>
   */
  Page<ParkParkedCur> selectPageList(ParkedCarportCondition condition);

  /**
   * 实时车位根据车位号码查询
   * 
   * @param carportCode
   * @return List<ParkParkedCur>
   */
  List<ParkParkedCur> selectByCarportCode(@Param("carportCode") String carportCode);

  /**
   * 实时车位根据车牌号码查询
   * 
   * @param carNum
   * @return List<ParkParkedCur>
   */
  List<ParkParkedCur> selectByCarNum(@Param("carNum") String carNum);

}
