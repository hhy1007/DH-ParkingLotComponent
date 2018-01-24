/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.integration.dto;

/**
 * 报警信息上报参数
 * 
 * @Class Name AlarmDto
 * @Author zhangli
 * @Create In 2017年12月19日
 */
public class AlarmDto {

    /**
     * 报警类型
     * @Field byte alarmType 
     */
    private byte alarmType;

    public byte getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(byte alarmType) {
        this.alarmType = alarmType;
    }
    
    
}
