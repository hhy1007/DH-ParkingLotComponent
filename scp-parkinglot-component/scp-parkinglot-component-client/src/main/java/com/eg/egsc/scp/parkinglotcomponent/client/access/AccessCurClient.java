/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.client.access;

import com.eg.egsc.scp.parkinglotcomponent.dto.access.AccessCurDto;

/**
 * @Class Name AccessCurClient
 * @Author wangziqiang
 * @Create In 2018年1月10日
 */
public interface AccessCurClient {
    /**
     * 查询应缴费用
     * 
     * @Methods Name selectAccessCurByExample
     * @Create In 2018年1月10日 By wangziqiang
     * @param accessCurDto
     * @return AccessCurDto
     */
    AccessCurDto selectAccessCurByExample(AccessCurDto accessCurDto);

    /**
     * 
     * @Methods Name updateAccessCurByExample
     * @Create In 2018年1月10日 By wangziqiang
     * @param accessCurDto
     * @return AccessCurDto
     */
    AccessCurDto updateAccessCurByExample(AccessCurDto accessCurDto);

}
