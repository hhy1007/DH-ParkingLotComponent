/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.client.charge;

import com.eg.egsc.scp.parkinglotcomponent.dto.charge.ChargeOnlineDto;

/**
 * 缴费接口client
 * 
 * @author huangyuhong
 * @since 2018年1月15日
 */
public interface ChargeClient {
    
    /**
     * 线上缴费
     * 
     * @param chargeOnlineDto
     * @return int
     */
    int chargeOnline(ChargeOnlineDto chargeOnlineDto);

}
