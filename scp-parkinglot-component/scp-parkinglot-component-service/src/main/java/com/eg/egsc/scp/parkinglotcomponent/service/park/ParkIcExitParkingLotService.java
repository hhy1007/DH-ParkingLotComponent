/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.park;

import com.eg.egsc.scp.parkinglotcomponent.service.park.dto.IcInformationDto;

/**
 * 刷IC卡进行收费service
 * 
 * @Class Name IParkIcExitParkingLotService
 * @Author wangziqiang
 * @Create In 2017年12月28日
 */
public interface ParkIcExitParkingLotService {
    /**
     * 通过IC卡离开停车场逻辑
     * 
     * @Methods Name exitParkParkingByIc
     * @Create In 2017年12月28日 By wangziqiang
     * @param carInOutParkingLotDto
     * @return void
     */
    void exitParkParkingByIc(IcInformationDto icInformationDto);

}
