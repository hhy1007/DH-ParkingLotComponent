/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus.car;

public enum CarEnterMode {
    BRUSHCARD((short)0,"刷卡"),
    AUTO((short)1,"自动识别"),
    MANUAL((short)2,"手动识别"),
    RESERVED((short)3,"預約停車");
    
    private Short type;
    
    private String desc;
    
    private CarEnterMode(Short type,String desc) {
        this.type=type;
        this.desc=desc;
    }
    
    public static CarEnterMode getEnum(Short type){
        for(CarEnterMode carMode : CarEnterMode.values()){
            if(carMode.getType().intValue() == type){
                return carMode;
            }
        }
        return AUTO;
    }
    public Short getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
    
    
}
