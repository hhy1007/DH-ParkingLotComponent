/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus.car;


/**
 * 车辆下发表状态
 * 
 * @author huangyuhong
 * @since 2018年1月18日
 */
public enum CarDevRelStatus {
    
    SEND("SEND", "下发中"),

    SUCCESS("SUCCESS", "下发成功"),

    FAILED("FAILED", "下发失败"),
    
    OFFLINE("OFFLINE", "设备不在线");

    private String type;
    
    private String desc;

    private CarDevRelStatus(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static CarDevRelStatus getEnum(String type) {
        for (CarDevRelStatus carDevRelStatus : CarDevRelStatus.values()) {
            if (carDevRelStatus.getType().equals(type)) {
                return carDevRelStatus;
            }
        }
        return null;
    }
    
    public static CarDevRelStatus getEnumByDesc(String desc) {
        for (CarDevRelStatus carDevRelStatus : CarDevRelStatus.values()) {
            if (carDevRelStatus.getType().equals(desc)) {
                return carDevRelStatus;
            }
        }
        return null;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
    
}
