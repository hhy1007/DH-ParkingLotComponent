/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus.carport.map;

/**
 * 车位欠费异常类型
 * 
 * @author huangzhiqiang
 * @since 2018年1月16日
 */
public enum ParkAlarmArrearType {

    PAID((short) 2), // 已缴费状态

    EXPIRE((short) 0), // 即将到期

    ARREAR((short) 1);// 欠费

    private Short type;

    private ParkAlarmArrearType(Short type) {
        this.type = type;
    }

    public static ParkAlarmArrearType getEnum(Short type) {
        for (ParkAlarmArrearType alarmType : ParkAlarmArrearType.values()) {
            if (alarmType.getType().intValue() == type) {
                return alarmType;
            }
        }
        return null;
    }

    public Short getType() {
        return type;
    }
}
