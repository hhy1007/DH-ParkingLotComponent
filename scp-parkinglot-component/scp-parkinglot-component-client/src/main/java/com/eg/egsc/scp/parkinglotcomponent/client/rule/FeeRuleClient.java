/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.client.rule;

import com.eg.egsc.scp.parkinglotcomponent.dto.rule.RequestFeeRuleDto;

/**
 * 按收费规则计费接口client
 * 
 * @author fengrongjun
 * @since 2018年1月15日
 */
public interface FeeRuleClient {
    RequestFeeRuleDto computationsFeeRule(RequestFeeRuleDto requestFeeRuleDto);
}
