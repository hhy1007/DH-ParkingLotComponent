/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.carport;

import java.util.List;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.condition.park.CarportCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarport;

/**
 * 车位管理业务层接口实现
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public interface ParkCarportService {

    /**
     * 是否可用：1-正常，0-不可用
     * 
     * @param uuid
     * @param enableFlag
     * @return int
     */
    int updateEnableFlagByUuid(String uuid, Short enableFlag);
    
    /**
     * 根据id查询车位信息
     * 
     * @param uuid
     * @return ParkCarport
     */
    ParkCarport selectByPrimaryKey(String uuid);
    
    /**
     * 批量新增车位
     * 
     * @param parkCarports
     * @return int
     */
    int insertBatchCarport(List<ParkCarport> parkCarports);
    
    /**
     * 根据多个停车场编号和车位和车位编号模糊分页查询没有授权的车位信息
     * 
     * @param carportCondition
     * @return Page<ParkCarport>
     */
    Page<ParkCarport> selectByParkId(CarportCondition carportCondition);

    /**
     * 添加车位
     * 
     * @param parkCarport
     * @return int
     */
    int insert(ParkCarport parkCarport);

    /**
     * 更新车位
     * 
     * @param parkCarport
     * @return int
     */
    int update(ParkCarport parkCarport);

    /**
     * 删除车位
     * 
     * @param ids
     * @return int
     */
    int deleteByIds(List<String> ids);

    /**
     * 车位信息分页查询
     * 
     * @param condition
     * @return Page<ParkCarport>
     */
    Page<ParkCarport> selectPageList(CarportCondition condition);

    /**
     * 停车场信息查询
     * 
     * @param condition
     * @return List<ParkCarport>
     */
    List<ParkCarport> selectList(CarportCondition condition);

}
