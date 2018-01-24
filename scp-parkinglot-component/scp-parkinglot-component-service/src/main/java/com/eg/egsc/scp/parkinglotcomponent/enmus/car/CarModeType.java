/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus.car;


/**
 * @Class Name CarModeType
 * @Author xiaoxiaojie
 * @Create In 2018年1月12日
 */
public enum CarModeType {
    SMALLCAR("0", "小车"), 
    
    BIGCART("1", "大车"), 
    
    SUPERCAR("2", "超大车"), 
    
    MOTORCYCLE("3", "摩托车");

    private String type;

    private String desc;

    private CarModeType(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static CarModeType getEnum(String type) {
        for (CarModeType carModeType : CarModeType.values()) {
            if (carModeType.getType().equalsIgnoreCase(type)) {
                return carModeType;
            }
        }
        return SMALLCAR;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
