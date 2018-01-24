/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus.dev;

/**
 * @Class Name DevType
 * @Author wangziqiang
 * @Create In 2018年1月5日
 */
public enum DevType {
  
  BARRIERGATE((short)0),//道闸
  CARMERA((short)1),//相机
  LEG((short)2);//led
  
  private Short type;
  
  private DevType(Short type) {
    this.type = type;
  }
  /**
   * 通过type 拿到相应的DevType
   * @Methods Name getEnum
   * @Create In 2018年1月5日 By wangziqiang
   * @param type
   * @return DevType
   */
  public static DevType getEnum(Short type) {
    for (DevType devType : DevType.values()) {
      if( devType.getType().shortValue()==type ) {
        return devType;
      }
    }
    return null;    
  }
  
  
  
  public Short getType() {
    return type;
  }
   
  
  
}
