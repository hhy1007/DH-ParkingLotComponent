/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus.carport.map;

/**
 * 地图展示模块预警状态
 * 
 * @author huangzhiqiang
 * @since 2018年1月16日
 */
public enum MapCarportsAlarmType {

    WARNING((short) 1), // 预警状态

    RELEASEWARNING((short) 0);// 无预警状态

    private Short type;

    private MapCarportsAlarmType(Short type) {
        this.type = type;
    }

    public static MapCarportsAlarmType getEnum(Short type) {
        for (MapCarportsAlarmType alarmType : MapCarportsAlarmType.values()) {
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
