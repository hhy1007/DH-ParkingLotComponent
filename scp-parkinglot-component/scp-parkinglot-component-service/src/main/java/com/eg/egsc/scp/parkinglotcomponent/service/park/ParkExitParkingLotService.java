/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.park;

import com.eg.egsc.scp.parkinglotcomponent.service.car.dto.CarInOutParkingLotDto;
import com.eg.egsc.scp.parkinglotcomponent.service.integration.dto.CarInOutDto;

/**
 * 自定义停车场出口逻辑业务层接口实现
 * 
 * @Class Name IParkExitParkingLotService
 * @Author wangziqiang
 * @Create In 2017年12月22日
 */
public interface ParkExitParkingLotService {
    /**
     * 出场逻辑业务sevice
     * 
     * @Methods Name exitParkingLot
     * @Create In 2017年12月22日 By wangziqiang
     * @param parkExitParkingLot void
     */
    void exitParkingLot(CarInOutParkingLotDto carInOutParkingLotDto);

    /**
     * 重新计费service
     * 
     * @Methods Name reBilling
     * @Create In 2017年12月26日 By wangziqiang
     * @param CarInOutDto
     * @return CarInOutDto
     */
    CarInOutDto reBilling(CarInOutDto carInOutDto);

    /**
     * 模糊查询
     * 
     * @Methods Name SelectCarInOutInformation
     * @Create In 2018年1月4日 By wangziqiang
     * @param vagueParkCarDto
     * @return CarInOutDto
     */
    CarInOutDto selectCarInOutInformation(CarInOutDto carInOutDto);
}
