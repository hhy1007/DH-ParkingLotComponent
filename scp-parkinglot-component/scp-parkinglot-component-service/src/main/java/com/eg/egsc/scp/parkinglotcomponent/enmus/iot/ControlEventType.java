/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus.iot;

/**
 * 向设备发送消息事件ID
 * @Class Name EventTypeId
 * @Author zhangli
 * @Create In 2018年1月11日
 */
public enum ControlEventType {

    /**
     * 开闸
     * @Field ControlEventType GATE_CONTROL 
     */
    GATE_CONTROL(2001),

    /**
     * 下发固定凭证结果
     * @Field ControlEventType LOAD_CERTIFICATE 
     */
    LOAD_CERTIFICATE(2002),

    /**
     * 删除凭证状态
     * @Field ControlEventType DELETE_CERTIFICATE 
     */
    DELETE_CERTIFICATE(2003),
    
    /**
     * 下发余位
     * @Field ControlEventType SEND_IDLE 
     */
    SEND_IDLE(2004),

    /**
     * 下发led
     * @Field ControlEventType SEND_LED 
     */
    SEND_LED(2005),
    
    /**
     * 下发led
     * @Field ControlEventType SEND_LED 
     */
    SEND_VOICE(2006);

    private Integer type;

    private ControlEventType(Integer type) {
        this.type = type;
    }

    public static ControlEventType getEnum(Integer type) {
        if (type == null) {
            return null;
        }
        for (ControlEventType controlEventType : ControlEventType.values()) {
            if (controlEventType.getType().intValue() == type) {
                return controlEventType;
            }
        }
        return null;
    }

    public Integer getType() {
        return type;
    }
}
