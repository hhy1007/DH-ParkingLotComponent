/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.extmapper.carport.map;

import java.util.List;
import com.eg.egsc.scp.parkinglotcomponent.condition.park.map.MapCarportsCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarport;

/**
 * 自定义sql语句(复杂的sql 或 多表关联查询是可自定义sql语句)
 * 
 * @author huangzhiqiang
 * @since 2018年1月12日
 */
public interface MapCarportsMapper {

    /**
     * 根据Request参数自定义sql查询车位数量
     * 
     * @param mapCarportCondition
     * @return int
     */
    int countByExample(MapCarportsCondition mapCarportCondition);

    /**
     * 根据Request参数自定义sql查询车位信息
     * 
     * @param mapCarportCondition
     * @return List<ParkCarport>
     */
    List<ParkCarport> selectByExampleWithRowbounds(MapCarportsCondition mapCarportCondition);
}
