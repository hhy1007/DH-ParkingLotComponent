/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.integration;

import com.eg.egsc.scp.parkinglotcomponent.mq.message.DeviceStatusDto;
import com.eg.egsc.scp.parkinglotcomponent.service.integration.dto.AlarmDto;
import com.eg.egsc.scp.parkinglotcomponent.service.integration.dto.CarInOutDto;
import com.eg.egsc.scp.parkinglotcomponent.service.integration.dto.CarportStateDto;
import com.eg.egsc.scp.parkinglotcomponent.service.integration.dto.IdleChangeDto;

/**
 * 组件调用停车场应用的接口，接口由停车场应用实现
 * 
 * @Class Name IIntegrationAppService
 * @Author zhangli
 * @Create In 2017年12月17日
 */
public interface IntegrationAppService {

    /**
     * 车辆进出事件通知
     * 
     * @Methods Name carInOutEvent
     * @Create In 2017年12月17日 By zhangli
     * @param carInOutDto void
     */
    void carInOutEvent(CarInOutDto carInOutDto);
    
    /**
     * 报警信息通知
     * 
     * @Methods Name alarmEvent
     * @Create In 2017年12月19日 By zhangli
     * @param alarmDto
     * @return boolean
     */
    void alarmEvent(AlarmDto alarmDto);
    
    /**
     * 停车场余位变更通知
     * 
     * @Methods Name idleChangeEvent
     * @Create In 2017年12月17日 By zhangli
     * @param idleChangeDto void
     */
    void idleChangeEvent(IdleChangeDto idleChangeDto);
    
    /**
     * 车位状态变更通知
     * 
     * @Methods Name carportStateChangeEvent
     * @Create In 2017年12月19日 By zhangli
     * @param carportStateDto void
     */
    void carportStateChangeEvent(CarportStateDto carportStateDto);
    
    /**
     * 设备状态变更消息通知
     * @param deviceStatusDto void
     */
    void deviceStatusChangeEvent(DeviceStatusDto deviceStatusDto);
}
