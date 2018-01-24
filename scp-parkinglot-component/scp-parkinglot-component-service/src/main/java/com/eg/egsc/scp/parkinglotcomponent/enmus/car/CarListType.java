/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus.car;

/**
 * 黑白名单类型
 * 
 * @author huangyuhong
 * @since 2018年1月18日
 */
public enum CarListType {
    NORMAL((short)0, "普通车"), //普通车

    WHITE((short)1, "白名单"), //白名单
    
    BLACK((short)2, "黑名单"); //黑名单
    
    private Short type;
    
    private String desc;

    private CarListType (Short type, String desc){
        this.type = type;
        this.desc = desc;
    }

   public static CarListType getEnum(Short type){
        for(CarListType carType : CarListType.values()){
            if(carType.getType().shortValue() == type.shortValue()){
                return carType;
            }
        }
        return null;
    }
   
   public static CarListType getEnumByDec(String desc) {
       for(CarListType carType : CarListType.values()){
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
