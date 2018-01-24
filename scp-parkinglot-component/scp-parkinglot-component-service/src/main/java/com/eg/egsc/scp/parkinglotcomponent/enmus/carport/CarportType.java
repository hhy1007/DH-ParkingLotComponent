/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus.carport;

/**
 * 车位类型枚举类
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public enum CarportType {

    INTHEPARK((short)0, "临停"),
    
    MONTHWARRANTY((short)1, "月租"),
    
    PROPERTYRIGHTS((short)2, "产权");
    
    private short type;
    
    private String desc;
    
    private CarportType (short type, String desc){
        this.type = type;
        this.desc = desc;
    }

   public static CarportType getEnum(short type){
        for(CarportType zeroOneFlag : CarportType.values()){
            if(zeroOneFlag.getType() == type){
                return zeroOneFlag;
            }
        }
        return null;
    }
    
    public short getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
