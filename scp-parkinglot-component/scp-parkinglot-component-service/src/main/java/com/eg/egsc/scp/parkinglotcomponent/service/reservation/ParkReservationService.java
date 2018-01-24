/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.reservation;

import java.util.List;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.condition.reservation.ParkReservationCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkReservation;

/**
 * 线上预约接口
 * 
 * @author huangyuhong
 * @since 2018年1月12日
 */
public interface ParkReservationService {
    
    /**
     * 车辆预约记录新增
     * 
     * @param parkReservation
     * @return int
     */
    int insert(ParkReservation parkReservation);
    
    /**
     * 车辆预约记录修改
     * 
     * @param parkReservation
     * @return int
     */
    int update(ParkReservation parkReservation);
    
    /**
     * 删除车辆预约
     * 
     * @param ids
     * @return int
     */
    int deleteByIds(List<String> ids);
    
    /**
     * 预约车辆分页查询
     * 
     * @param condition
     * @return Page<ParkReservation>
     */
    Page<ParkReservation> selectPageList(ParkReservationCondition condition);
    
    /**
     * 预约车辆查询
     * 
     * @param condition
     * @return List<ParkReservation>
     */
    List<ParkReservation> selectList(ParkReservationCondition condition);
    
    /**
     * 根据ID查询预约车辆
     * 
     * @param id
     * @return ParkReservation
     */
    ParkReservation selectByPrimaryKey(String id);
    
}
