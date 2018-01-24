/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.mdm;

import com.eg.egsc.scp.mdm.component.dto.BaseUserDto;

/**
 * 业主操作下发接口
 * 
 * @author huangyuhong
 * @since 2018年1月16日
 */
public interface MdmOperateService {
    
    /**
     * 删除业主相关信息(车辆,套餐,设备权限)
     * 
     * @param baseUserDto
     * @return int
     */
    public int deleteOwnerRel(BaseUserDto baseUserDto);

}
