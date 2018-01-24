/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.client.rule.impl;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.eg.egsc.framework.client.core.BaseApiClient;
import com.eg.egsc.framework.client.dto.ResponseDto;
import com.eg.egsc.scp.parkinglotcomponent.client.rule.FeeRuleClient;
import com.eg.egsc.scp.parkinglotcomponent.dto.rule.RequestFeeRuleDto;

/**
 * 按收费规则计费接口client实现类
 * 
 * @author fengrongjun
 * @since 2018年1月15日
 */
@Component
public class FeeRuleClientImpl extends BaseApiClient implements FeeRuleClient {
    
    @Override
    public RequestFeeRuleDto computationsFeeRule(RequestFeeRuleDto requestFeeRuleDto) {
        ResponseDto res = post("/api/rule/feeRule", requestFeeRuleDto);
        return JSONObject.parseObject(JSONObject.toJSONString(res.getData()), RequestFeeRuleDto.class);
    }

    @Override
    protected String getContextPath() {
        return "/scp-parkinglotcomponent";
    }

}
