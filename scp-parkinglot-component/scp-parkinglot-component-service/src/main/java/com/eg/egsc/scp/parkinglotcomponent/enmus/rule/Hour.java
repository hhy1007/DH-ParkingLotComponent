/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus.rule;

/**
 * 小时类枚举类
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public enum Hour {

    ZERO(0, "o时"),

    TEN(10, "10时");

    private Integer type;

    private String desc;

    private Hour(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static Hour getEnum(Integer type) {
        for (Hour zeroOneFlag : Hour.values()) {
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
