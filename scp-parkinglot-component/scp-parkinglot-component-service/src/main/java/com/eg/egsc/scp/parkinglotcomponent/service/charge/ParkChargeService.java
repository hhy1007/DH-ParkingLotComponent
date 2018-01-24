/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.charge;

import java.util.List;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.condition.charge.ChargeCondition;
import com.eg.egsc.scp.parkinglotcomponent.dto.charge.ChargeOnlineDto;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCharge;
import com.eg.egsc.scp.parkinglotcomponent.service.charge.dto.ChargeDto;

/**
 * 授权套餐业务层接口
 * 
 * @author huangyuhong
 * @since 2018年1月12日
 */
public interface ParkChargeService {
    
   
    /**
     * 充值更新相关信息
     * 
     * @param parkCharge
     * @return int
     */
    int charge(ParkCharge parkCharge);
    
    /**
     * 分页条件查询
     * 
     * @param condition
     * @return Page<ChargeDto>
     */
    Page<ChargeDto> selectPageChargeList(ChargeCondition condition);
    
    /**
     * 条件查询
     * 
     * @param condition
     * @return List<ChargeDto>
     */
    List<ChargeDto> selectChargeList(ChargeCondition condition);
    
    /**
     * 线上充值
     * 
     * @param parkCharge
     * @return int
     */
    int chargeOnline(ChargeOnlineDto chargeOnlineDto);
    
}
