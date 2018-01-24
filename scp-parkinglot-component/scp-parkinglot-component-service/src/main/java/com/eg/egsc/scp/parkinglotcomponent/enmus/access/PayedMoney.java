/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus.access;

/**
 * 0标记
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public enum PayedMoney {

    ZERO(0, "0元");
    
    private Integer type;
    
    private String desc;
    
    private PayedMoney (Integer type, String desc){
        this.type = type;
        this.desc = desc;
    }

   public static PayedMoney getEnum(Integer type){
        for(PayedMoney zeroOneFlag : PayedMoney.values()){
            if(zeroOneFlag.getType().intValue() == type){
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
