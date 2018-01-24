/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.car;

import com.eg.egsc.scp.parkinglotcomponent.service.car.dto.CarInOutParkingLotDto;
import com.eg.egsc.scp.parkinglotcomponent.service.car.dto.ICCardDto;

/**
 * 刷卡进入停车场接口
 * @Class Name SwipeEnterParkinglotService
 * @Author xiaoxiaojie
 * @Create In 2018年1月9日
 */
public interface SwipeCarInParkinglotService {
    
    /**
     * 初始化车辆刷卡事件数据
     * @Methods Name initCarInParkinglotInfo
     * @Create In 2018年1月10日 By xiaoxiaojie
     * @param icCardDto void
     */
    CarInOutParkingLotDto initCarInParkinglotInfo(ICCardDto icCardDto);
    
    /**
     * 刷卡流程处理
     * @Methods Name swipeEnterParkinglotOperator
     * @Create In 2018年1月10日 By xiaoxiaojie
     * @param carInOutParkingLotDto
     * @param icCardDto void
     */
    void swipeEnterParkinglotOperator(CarInOutParkingLotDto carInOutParkingLotDto,
            ICCardDto icCardDto);
}
