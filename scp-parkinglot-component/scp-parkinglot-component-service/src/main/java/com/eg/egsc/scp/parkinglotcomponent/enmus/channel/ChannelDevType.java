/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus.channel;

/**
 * 通道设备类型
 * 
 * @author huangyuhong
 * @since 2018年1月18日
 */
public enum ChannelDevType {
    BARRIERGATE((short)0, "道闸"), 

    CAMERA((short)1, "出入口相机"), 
    
    LED((short)2, "led"); 
    
    private Short type;
    
    private String desc;

    private ChannelDevType (Short type, String desc){
        this.type = type;
        this.desc = desc;
    }

   public static ChannelDevType getEnum(Short type){
        for(ChannelDevType carType : ChannelDevType.values()){
            if(carType.getType().shortValue() == type.shortValue()){
                return carType;
            }
        }
        return null;
    }
   
   public static ChannelDevType getEnumByDec(String desc) {
       for(ChannelDevType carType : ChannelDevType.values()){
           if(carType.getDesc().equals(desc)){
               return carType;
           }
       }
       return null;
   }
    
    public Short getType() {
        return type;
    }
    
    public String getDesc() {
        return desc;
    }
}
