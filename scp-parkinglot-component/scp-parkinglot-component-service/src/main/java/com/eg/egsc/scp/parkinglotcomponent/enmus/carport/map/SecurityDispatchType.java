/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus.carport.map;

/**
 * 保安派遣状态
 * 
 * @author huangzhiqiang
 * @since 2018年1月16日
 */
public enum SecurityDispatchType {

    NOTDISPATCH((short) 0), // 未派遣

    DISPATCH((short) 1);// 已派遣

    private Short type;

    private SecurityDispatchType(Short type) {
        this.type = type;
    }

    public static SecurityDispatchType getEnum(Short type) {
        for (SecurityDispatchType securityDispatchType : SecurityDispatchType.values()) {
            if (securityDispatchType.getType().intValue() == type) {
                return securityDispatchType;
            }
        }
        return null;
    }

    public Short getType() {
        return type;
    }
}
