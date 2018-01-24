/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus.carport.map;

/**
 * 车辆异常类型
 * 
 * @author huangzhiqiang
 * @since 2018年1月16日
 */
public enum CarStatusType {

    ILLEGAL((short) 0), // 违停车辆

    NOMAL((short) 1);// 正常车辆

    private Short type;

    private CarStatusType(Short type) {
        this.type = type;
    }

    public static CarStatusType getEnum(Short type) {
        for (CarStatusType abnormalType : CarStatusType.values()) {
            if (abnormalType.getType().intValue() == type) {
                return abnormalType;
            }
        }
        return null;
    }

    public Short getType() {
        return type;
    }
}

