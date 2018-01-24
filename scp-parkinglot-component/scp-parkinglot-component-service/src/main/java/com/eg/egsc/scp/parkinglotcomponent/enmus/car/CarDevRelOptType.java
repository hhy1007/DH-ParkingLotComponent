/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus.car;

/**
 * 车辆下发表操作类型
 * 
 * @author huangyuhong
 * @since 2018年1月18日
 */
public enum CarDevRelOptType {
    ADD("ADD", "增加"),

    DEL("DEL", "删除"),

    UPDATE("UPDATE", "修改");

    private String type;
    
    private String desc;

    private CarDevRelOptType(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static CarDevRelOptType getEnum(String type) {
        for (CarDevRelOptType carDevRelOptType : CarDevRelOptType.values()) {
            if (carDevRelOptType.getType().equals(type)) {
                return carDevRelOptType;
            }
        }
        return null;
    }
    
    public static CarDevRelOptType getEnumByDesc(String desc) {
        for (CarDevRelOptType carDevRelOptType : CarDevRelOptType.values()) {
            if (carDevRelOptType.getType().equals(desc)) {
                return carDevRelOptType;
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
