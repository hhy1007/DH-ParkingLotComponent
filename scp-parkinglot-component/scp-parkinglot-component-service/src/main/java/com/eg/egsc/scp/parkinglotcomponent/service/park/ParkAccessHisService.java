/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.park;

import java.util.List;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.condition.access.AccessHisCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAccessHis;

/**
 * 车辆进出历史接口服务
 * @Class Name IParkAccessHis
 * @Author xiaoxiaojie
 * @Create In 2017年12月25日
 */
public interface ParkAccessHisService {
    
    /**
     * 添加车辆进出历史记录
     * @Methods Name insert
     * @Create In 2017年12月25日 By xiaoxiaojie
     * @param parkAccessHis
     * @return int
     */
    int insert(ParkAccessHis parkAccessHis);
    
    /**
     * 更新车辆进出历史记录
     * @Methods Name update
     * @Create In 2017年12月25日 By xiaoxiaojie
     * @param parkAccessHis
     * @return int
     */
    int update(ParkAccessHis parkAccessHis);
    
    /**
     * 根据id 删除车辆进出历史记录
     * @Methods Name deleteById
     * @Create In 2017年12月25日 By xiaoxiaojie
     * @param id
     * @return int
     */
    int deleteById(String id);
    
    /**
     * 根据id 查询车辆进出历史记录
     * @Methods Name selectByPrimaryKey
     * @Create In 2017年12月25日 By xiaoxiaojie
     * @param id
     * @return ParkAccessHis
     */
    ParkAccessHis selectByPrimaryKey(String id);
    
    /**
     * 根据车牌和车场编号获取车辆历史纪录
     * @Methods Name selectByCarNumAndParkCode
     * @Create In 2018年1月16日 By xiaoxiaojie
     * @param carNum
     * @param parkCode
     * @return ParkAccessHis
     */
    ParkAccessHis selectByCarNumAndParkCode(String carNum,String parkCode);
    /**
     * 车辆进出分页查询
     * 
     * @Methods Name selectPageList
     * @Create In 2017年12月15日 By xiangdaoping
     * @param condition
     * @return Page<ParkAccessHis>
     */
    Page<ParkAccessHis> selectPageList(AccessHisCondition condition);
    
    /**
     * 车辆进出信息查询
     * 
     * @Methods Name selectList
     * @Create In 2017年12月15日 By xangdaoping
     * @param condition
     * @return List<ParkAccessHis>
     */
    List<ParkAccessHis> selectList(AccessHisCondition condition);
}
