/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.extmapper.carport;

import java.util.List;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageRequest;
import com.eg.egsc.scp.parkinglotcomponent.condition.park.CarportCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarport;

/**
 * 自定义sql语句(复杂的sql 或 多表关联查询是可自定义sql语句)
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public interface CarportMapper {

    
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
     * @param pageRequest
     * @return int
     */
    int selectCountByParkId(PageRequest<CarportCondition> pageRequest);

    /**
     * 根据多个停车场编号和车位和车位编号查询没有授权的车位信息
     * 
     * @param pageRequest
     * @return List<ParkCarport>
     */
    List<ParkCarport> selectByParkId(PageRequest<CarportCondition> pageRequest);
    
    /**
     * 根据车位编号更新车位信息
     * 
     * @param carRecord
     * @return int
     */
    int updateByCode(ParkCarport carRecord);
    
    
}
