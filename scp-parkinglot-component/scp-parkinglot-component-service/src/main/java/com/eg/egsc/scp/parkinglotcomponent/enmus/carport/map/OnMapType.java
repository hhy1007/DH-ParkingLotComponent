/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus.carport.map;

/**
 * 绑定地图类型
 * 
 * @author huangzhiqiang
 * @since 2018年1月16日
 */
public enum OnMapType {

    ONMAP(1), // 绑定地图

    OUTOFMAP(0);// 未绑定地图

    private Integer type;

    private OnMapType(Integer type) {
        this.type = type;
    }

    public static OnMapType getEnum(Integer type) {
        for (OnMapType onMapType : OnMapType.values()) {
            if (onMapType.getType().intValue() == type) {
                return onMapType;
            }
        }
        return null;
    }

    public Integer getType() {
        return type;
    }

}
