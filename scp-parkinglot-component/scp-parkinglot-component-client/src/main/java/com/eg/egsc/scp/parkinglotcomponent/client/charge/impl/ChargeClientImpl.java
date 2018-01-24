/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.client.charge.impl;

import org.springframework.stereotype.Component;

import com.eg.egsc.framework.client.core.BaseApiClient;
import com.eg.egsc.framework.client.dto.ResponseDto;
import com.eg.egsc.scp.parkinglotcomponent.client.charge.ChargeClient;
import com.eg.egsc.scp.parkinglotcomponent.dto.charge.ChargeOnlineDto;

/**
 * 缴费接口client实现类
 * 
 * @author huangyuhong
 * @since 2018年1月15日
 */
@Component
public class ChargeClientImpl extends BaseApiClient implements ChargeClient {
    
    @Override
    public int chargeOnline(ChargeOnlineDto chargeOnlineDto) {
        ResponseDto res = post("/api/charge/chargeOnline", chargeOnlineDto);
        return Integer.valueOf(String.valueOf(res.getData())).intValue();
    }

    @Override
    protected String getContextPath() {
        return "/scp-parkinglotcomponent";
    }

}
