/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.park;

import com.eg.egsc.scp.parkinglotcomponent.service.integration.dto.CarInOutDto;

/**
 * 汽车出场时抬杆后信息信息的存储和更改
 * 
 * @Class Name ParkParkingLotInformationStoredService
 * @Author wangziqiang
 * @Create In 2017年12月25日
 */
public interface ParkParkingLotInformationStoredService {
    /**
     * 汽车信息结构信息化存储service
     * 
     * @Methods Name storeCarInformation
     * @Create In 2017年12月25日 By wangziqiang
     * @param carInOutDto
     * @return String
     */
    void storeCarInformation(CarInOutDto carInOutDto);

    /**
     * 自动汽车信息结构信息化存储service
     * 
     * @Methods Name autoStoreCarInformation
     * @Create In 2018年1月5日 By wangziqiang
     * @param reBillingDto
     * @return Map<String, Object>
     */
    void autoStoreCarInformation(CarInOutDto carInOutDto);


}
