/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.extmapper.access;

import java.util.List;

import com.eg.egsc.scp.parkinglotcomponent.extmapper.access.entity.AccessCur;

/**
 * 入场记录mapper(自定义)
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public interface AccessCurMapper {

    /**
     * 根据入场id查询停车场信息和收费规则信息
     * 
     * @param id
     * @return AccessCur
     */
    AccessCur selectAccessCurAndParkingLotAndParkFeeRuleByPrimaryKey(String id);
    
    /**
     * 根据套餐id查询在场车辆个数
     * @Methods Name countByPackageId
     * @Create In 2018年1月22日 By xiaoxiaojie
     * @param packageIds
     * @return int
     */
    int countByPackageId(List<String> packageIds);
}
