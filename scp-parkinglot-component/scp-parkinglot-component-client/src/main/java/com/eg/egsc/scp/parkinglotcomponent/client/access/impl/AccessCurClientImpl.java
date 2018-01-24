/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.client.access.impl;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.eg.egsc.framework.client.core.BaseApiClient;
import com.eg.egsc.framework.client.dto.ResponseDto;
import com.eg.egsc.scp.parkinglotcomponent.client.access.AccessCurClient;
import com.eg.egsc.scp.parkinglotcomponent.dto.access.AccessCurDto;

/**
 * AccessCurClient 实现类
 * 
 * @Class Name AccessCurClientImpl
 * @Author wangziqiang
 * @Create In 2018年1月10日
 */
@Component
public class AccessCurClientImpl extends BaseApiClient implements AccessCurClient {

    @Override
    public AccessCurDto selectAccessCurByExample(AccessCurDto accessCurDto) {
        ResponseDto res = post("/api/access/getAccessCur", accessCurDto);
        return JSONObject.parseObject(JSONObject.toJSONString(res.getData()), AccessCurDto.class);
    }

    @Override
    protected String getContextPath() {
        return "/scp-parkinglotcomponent";
    }

    @Override
    public AccessCurDto updateAccessCurByExample(AccessCurDto accessCurDto) {
        ResponseDto res = post("/api/access/updateAccessCur", accessCurDto);
        return JSONObject.parseObject(JSONObject.toJSONString(res.getData()), AccessCurDto.class);
    }

}
