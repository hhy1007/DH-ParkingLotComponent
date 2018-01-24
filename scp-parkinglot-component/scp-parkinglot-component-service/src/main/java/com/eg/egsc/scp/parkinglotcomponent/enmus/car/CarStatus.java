/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus.car;

/**
 * 车辆停车状态枚举类
 * @Class Name CarStatus
 * @Author xiaoxiaojie
 * @Create In 2018年1月5日
 */
public enum CarStatus {
    
    ENTER((short)0,"入场"),
    OUT((short)1,"出场"),
    ONLYOUTCAR((short)2,"只有出车");
    
    private Short status;
    
    private String desc;
    
    private CarStatus(Short status,String desc) {
        this.status = status;
        this.desc = desc;
    }
    public static CarStatus getEnum(Short status){
        for(CarStatus carStatu : CarStatus.values()){
            if(carStatu.getStatus().intValue() == status){
                return carStatu;
            }
        }
        return null;
    }
    
    public Short getStatus() {
        return status;
    }
    
    public String getDesc() {
        return desc;
    }
    
}
