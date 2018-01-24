/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.extmapper.charge;

import java.util.List;

import com.eg.egsc.scp.parkinglotcomponent.condition.charge.ChargeCondition;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.charge.entity.Charge;

/**
 * 充值自定义mapper
 * 
 * @author huangyuhong
 * @since 2018年1月12日
 */
public interface ChargeMapper {
    
    /**
     * 根据条件查询数量
     * 
     * @param condition
     * @return int
     */
    int countByExample(ChargeCondition condition);
    
    /**
     * 根据条件分页查询
     * 
     * @param condition
     * @return List<Charge>
     */
    List<Charge> selectByExampleWithRowbounds(ChargeCondition condition);
    
    /**
     * 根据条件查询
     * 
     * @param condition
     * @return List<Charge>
     */
    List<Charge> selectByExample(ChargeCondition condition);

}
