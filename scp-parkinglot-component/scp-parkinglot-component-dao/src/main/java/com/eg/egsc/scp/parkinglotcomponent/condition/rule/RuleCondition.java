/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.condition.rule;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageCondition;
/**
 * 进出规则信息查询过滤条件
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public class RuleCondition extends PageCondition{

	 private String id;

	 private String ruleName;//进出规则名称

	public String getId() {
		return id;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	
	public String getRuleName() {
        return ruleName;
    }
	
	public void setId(String id) {
        this.id = id;
    }
}
