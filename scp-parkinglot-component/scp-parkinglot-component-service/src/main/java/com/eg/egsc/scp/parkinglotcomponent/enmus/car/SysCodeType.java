/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus.car;

/**
 * 字典表大类型
 * 
 * @author huangyuhong
 * @since 2018年1月18日
 */
public enum SysCodeType {
    NUMCOLOR("1", "车牌颜色"), 

    BRAND("2", "汽车品牌"),
    
    COLOR("3", "汽车颜色"),
    
    MODE("4", "车型"); 
    
    private String type;
    
    private String desc;

    private SysCodeType (String type, String desc){
        this.type = type;
        this.desc = desc;
    }

   public static SysCodeType getEnum(String type){
        for(SysCodeType carType : SysCodeType.values()){
            if(carType.getType().equals(type)){
                return carType;
            }
        }
        return null;
    }
   
   public static SysCodeType getEnumByDec(String desc) {
       for(SysCodeType carType : SysCodeType.values()){
           if(carType.getDesc().equals(desc)){
               return carType;
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
