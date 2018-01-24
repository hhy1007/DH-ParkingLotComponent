/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus.rule;

/**
 * @Class Name MonthCarTurnTempType
 * @Author xiaoxiaojie
 * @Create In 2018年1月19日
 */
public enum MonthCarTurnTempType {
    KEEPMONTHCAR(0, "过期还是按月保车进出场"), 
    
    TURNTEMP(1, "过期按临停车进出场"), 
    
    NOENTRY(2, "不让进");
    

    private Integer type;

    private String desc;

    private MonthCarTurnTempType(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static MonthCarTurnTempType getEnum(Integer type) {
        for (MonthCarTurnTempType monthCarType : MonthCarTurnTempType.values()) {
            if (monthCarType.getType().intValue() == type) {
                return monthCarType;
            }
        }
        return TURNTEMP;
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
