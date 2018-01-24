/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.rule;

import java.util.List;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.condition.rule.RuleCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkRule;
import com.eg.egsc.scp.parkinglotcomponent.service.rule.dto.RuleDto;

/**
 * 进出规则管理业务层接口实现
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public interface ParkRuleService {

    /**
     * 根据id查询进出规则通道绑定信息
     * 
     * @param uuid
     * @return ParkRule
     */
    ParkRule selectByPrimaryKey(String uuid);
    
    /**
     * 根据多个id规则编号查询规则信息
     * 
     * @param ids
     * @return List<ParkRule>
     */
    List<ParkRule> selectByRuleIds(List<String> ids);

    /**
     * 添加进出规则
     * 
     * @param ruleDto
     * @return int
     */
    int insert(RuleDto ruleDto);

    /**
     * 更新进出规则
     * 
     * @param ruleDto
     * @return int
     */
    int update(RuleDto ruleDto);

    /**
     * 删除进出规则
     * 
     * @param ids
     * @return int
     */
    int deleteByIds(List<String> ids);

    /**
     * 进出规则信息分页查询
     * 
     * @param condition
     * @return Page<ParkRule>
     */
    Page<ParkRule> selectPageList(RuleCondition condition);

    /**
     * 进出规则信息查询
     * 
     * @param condition
     * @return List<ParkRule>
     */
    List<ParkRule> selectList(RuleCondition condition);

}
