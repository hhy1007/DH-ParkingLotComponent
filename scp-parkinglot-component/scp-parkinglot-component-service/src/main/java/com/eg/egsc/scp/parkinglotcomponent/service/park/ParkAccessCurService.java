/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.park;

import java.util.List;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.condition.access.AccessCurCondition;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.access.entity.AccessCur;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAccessCur;

/**
 * 在场车辆接口服务
 * @Class Name IParkParkAccessCurService
 * @Author xiaoxiaojie
 * @Create In 2017年12月25日
 */
public interface ParkAccessCurService {
    
    /**
     * <p>添加在场车辆记录
     * @Methods Name insert
     * @Create In 2017年12月25日 By xiaoxiaojie
     * @param parkAccessCur
     * @return int
     */
    int insert(ParkAccessCur parkAccessCur);
    
    
    /**
     * <p>更新在场车辆记录
     * @Methods Name update
     * @Create In 2017年12月25日 By xiaoxiaojie
     * @param parkAccessCur
     * @return int
     */
    int update(ParkAccessCur parkAccessCur);
    
    /**
     * <p>根据id 查询在场车辆信息
     * @Methods Name selectByPrimaryKey
     * @Create In 2017年12月25日 By xiaoxiaojie
     * @param id
     * @return ParkAccessCur
     */
    ParkAccessCur selectByPrimaryKey(String id);
    
    /**
     * 根据入场id查询停车场信息和收费规则信息
     * 
     * @Methods Name selectAccessCurAndParkingLotAndParkFeeRuleByPrimaryKey
     * @Create In 2017年12月22日 By fengrongjun
     * @return String
     */
    AccessCur selectAccessCurAndParkingLotAndParkFeeRuleByPrimaryKey(String id);

    /**
     * 在场车辆分页查询
     * 
     * @Methods Name selectPageList
     * @Create In 2017年12月15日 By xiangdaoping
     * @param condition
     * @return Page<ParkAccessCur>
     */
    Page<ParkAccessCur> selectPageList(AccessCurCondition condition);

    /**
     * 批量删除车辆
     * 
     * @Methods Name deleteByIds
     * @Create In 2017年12月15日 By xiangdaoping
     * @param ids
     * @return int
     */
    int deleteByIds(List<String> ids);

    /**
     * 在场车辆信息查询
     * 
     * @Methods Name selectList
     * @Create In 2017年12月15日 By xangdaoping
     * @param condition
     * @return List<ParkCar>
     */
    List<ParkAccessCur> selectList(AccessCurCondition condition);
    
    
}
