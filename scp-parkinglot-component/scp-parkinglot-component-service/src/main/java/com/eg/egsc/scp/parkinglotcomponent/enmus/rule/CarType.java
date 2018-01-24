/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus.rule;

/**
 * 车类型
 * @author fengrongjun
 * @since 2018年1月12日
 */
public enum CarType {

    SMALLCAR(0, "小车"), 
    
    CART(1, "大车"), 
    
    SUPERCAR(2, "超大车"), 
    
    MOTORCYCLE(3, "摩托车");

    private Integer type;

    private String desc;

    private CarType(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static CarType getEnum(Integer type) {
        for (CarType zeroOneFlag : CarType.values()) {
            if (zeroOneFlag.getType().intValue() == type) {
                return zeroOneFlag;
            }
        }
        return null;
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
