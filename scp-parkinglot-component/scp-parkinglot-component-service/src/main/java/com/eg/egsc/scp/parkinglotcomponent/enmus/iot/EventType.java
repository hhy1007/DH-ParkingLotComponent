/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus.iot;

/**
 * 接入网关上报事件类型
 * 
 * @Class Name EventType
 * @Author zhangli
 * @Create In 2017年12月27日
 */
public enum EventType {

    /**
     * 抓拍、刷卡记录上传
     * @Field EventType UPLOAD_RECORD 
     */
    UPLOAD_RECORD(1001),

    /**
     * 车位探测器状态上传
     * @Field EventType UPLOAD_CARPORT_RECORD 
     */
    UPLOAD_CARPORT_RECORD(1002),

    /**
     * 开闸状态返回
     * @Field EventType GATE_CONTROL 
     */
    GATE_CONTROL(1003),

    /**
     * 下发固定凭证结果返回
     * @Field EventType LOAD_CERTIFICATE 
     */
    LOAD_CERTIFICATE(1004),

    /**
     * 删除凭证状态返回
     * @Field EventType DELETE_CERTIFICATE 
     */
    DELETE_CERTIFICATE(1005);

    private Integer type;

    private EventType(Integer type) {
        this.type = type;
    }

    public static EventType getEnum(Integer type) {
        if (type == null) {
            return null;
        }
        for (EventType eventType : EventType.values()) {
            if (eventType.getType().intValue() == type) {
                return eventType;
            }
        }
        return null;
    }

    public Integer getType() {
        return type;
    }
}
