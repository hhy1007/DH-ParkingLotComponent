/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus.car;

/**
 * 车辆类型
 * 
 * @author huangyuhong
 * @since 2018年1月22日
 */
public enum ParkCarType {

    COMMON((short)0, "普通车"),   
    
    SPECIAL((short)1, "特殊车");
    
    private Short type;
    
    private String desc;

    private ParkCarType(Short type, String desc) {
      this.type = type;
      this.desc = desc;
    }
    
    public static ParkCarType getEnum(Short type) {
      for (ParkCarType parkCarType : ParkCarType.values()) {
        if(parkCarType.getType().shortValue() == type.shortValue()){
          return parkCarType;
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
