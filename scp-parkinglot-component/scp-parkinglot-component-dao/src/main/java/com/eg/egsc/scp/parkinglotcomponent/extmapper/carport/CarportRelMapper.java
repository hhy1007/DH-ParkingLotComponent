/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.extmapper.carport;

import java.util.List;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkLedCarportRel;

/**
 * 自定义sql语句(复杂的sql 或 多表关联查询是可自定义sql语句)
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public interface CarportRelMapper {

    /**
     * 批量新增诱导屏
     * 
     * @param parkLedCarportRels
     * @return int
     */
    int insertBatchCarportRel(List<ParkLedCarportRel> parkLedCarportRels);
}
