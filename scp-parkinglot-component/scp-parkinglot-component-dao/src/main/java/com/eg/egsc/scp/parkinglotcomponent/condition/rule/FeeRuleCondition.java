/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.condition.rule;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageCondition;

/**
 * 收费规则管理信息查询过滤条件
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public class FeeRuleCondition extends PageCondition{
    
    private String id;
    
    private String ruleName;// 进出规则的名称

    private String ruleType;//类型:time-按次,interval-时段
    
    private String detail;// 规则内容
    
    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public String getRuleType() {
        return ruleType;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }
    
    public String getRuleName() {
        return ruleName;
    }
    
    public String getId() {
        return id;
    }
}
