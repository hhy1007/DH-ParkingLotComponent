/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.park;

import com.eg.egsc.scp.parkinglotcomponent.service.park.dto.ReFeesDto;

/**
 * @Class Name IParkSelfFeesSerivce
 * @Author wangziqiang
 * @Create In 2018年1月9日
 */
public interface ParkSelfFeesService {

    /**
     * 查询返回缴费金额
     * 
     * @Methods Name demandFees
     * @Create In 2018年1月9日 By wangziqiang
     * @param carNum
     * @param nowTime
     * @param cardNumber
     * @return ReFeesDto
     */
    ReFeesDto demandFees(String carNum, String cardNumber, String nowTime);

    /**
     * 更新在场车辆记录
     * 
     * @Methods Name updateParkAccessCur
     * @Create In 2018年1月9日 By wangziqiang
     * @param carNum
     * @param cardNumber
     * @param money
     * @return int
     */
    int updateParkAccessCur(String carNum, String cardNumber, String money);
}
