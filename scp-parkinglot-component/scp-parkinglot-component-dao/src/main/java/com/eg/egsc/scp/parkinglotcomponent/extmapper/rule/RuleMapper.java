/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.extmapper.rule;

import java.util.List;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkRule;

/**
 * 自定义进出规则mapper
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public interface RuleMapper {

    /**
     * 根据多个id规则编号查询规则信息
     * 
     * @param ids
     * @return List<ParkRule>
     */
    List<ParkRule> selectByRuleIds(List<String> ids);
}
