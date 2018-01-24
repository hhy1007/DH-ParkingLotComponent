/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.carport.map;

import java.util.List;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.condition.park.map.MapCarportsCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAlarmAbnormal;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAlarmArrear;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAlarmOccupy;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarport;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkedCur;
import com.eg.egsc.scp.parkinglotcomponent.service.carport.map.dto.CarportsInfoDto;
import com.eg.egsc.scp.parkinglotcomponent.web.vo.carport.map.MapCarportsVo;

/**
 * 地图展示车位使用业务接口
 * 
 * @author huangzhiqiang
 * @since 2018年1月12日
 */
public interface MapCarportsService {

    /**
     * 修改车位在地图上的坐标位置
     * 
     * @param mapCarportsVo
     * @return int
     */
    int updateCarportslocation(MapCarportsVo mapCarportsVo);

    /**
     * 此方法用于分页查询
     * 
     * @param mapCarportCondition
     * @return Page<ParkCarport>
     */
    Page<ParkCarport> selectPageList(MapCarportsCondition mapCarportCondition);

    /**
     * 车位欠费预警查询业务接口
     * 
     * @return List<ParkAlarmArrear>
     */
    List<ParkAlarmArrear> parkingFeeCheck();// 传入对象(属性)视地图后台确定..预计有mapId

    /**
     * 解除车位欠费预警状态
     * 
     * @param parkAlarmArrear
     * @return int
     */
    int releaseParkAlarmArrear(ParkAlarmArrear parkAlarmArrear);

    /**
     * 统计车位欠费预警数量
     * 
     * @return int
     */
    int countParkAlarmArrear();

    /**
     * 车位占用预警查询业务接口
     * 
     * @return List<ParkAlarmOccupy>
     */
    List<ParkAlarmOccupy> carportOccupuiedCheck();// 传入对象(属性)视地图后台确定.

    /**
     * 解除车位占用预警状态
     * 
     * @param parkAlarmOccupy
     * @return int
     */
    int releaseParkAlarmOccupy(ParkAlarmOccupy parkAlarmOccupy);

    /**
     * 统计车位占用预警数量
     * 
     * @return int
     */
    int countParkAlarmOccupy();

    /**
     * 车辆异常预警查询业务接口
     * 
     * @return List<ParkAlarmAbnormal>
     */
    List<ParkAlarmAbnormal> carAbnormalcheck();// 传入对象(属性)视地图后台确定.

    /**
     * 解除车辆异常预警
     * 
     * @param parkAlarmAbnormal
     * @return int
     */
    int releaseParkAlarmAbnormal(ParkAlarmAbnormal parkAlarmAbnormal);

    /**
     * 统计车辆异常数量
     * 
     * @return int
     */
    int countParkAlarmAbnormal();

    /**
     * 查询实时车位停车信息
     * 
     * @param mapCarportCondition
     * @return List<ParkParkedCur>
     */
    List<ParkParkedCur> selectList();

    /**
     * 查询车位信息的数量(各种车位状态的数量)
     * 
     * @param id 停车场id
     * @return CarportsInfoDto
     */
    CarportsInfoDto countAllKindsCarport(String id);
}

