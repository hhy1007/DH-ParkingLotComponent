/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus.access;

/**
 * 1,0标记
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public enum NeedPay {

    YES((short)1, "yes"),
    
    NO((short)0, "no");
    
    private short type;
    
    private String desc;
    
    private NeedPay (short type, String desc){
        this.type = type;
        this.desc = desc;
    }

   public static NeedPay getEnum(short type){
        for(NeedPay zeroOneFlag : NeedPay.values()){
            if(zeroOneFlag.getType() == type){
                return zeroOneFlag;
            }
        }
        return NO;
    }
    
    public short getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
