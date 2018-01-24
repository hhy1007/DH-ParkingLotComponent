/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus.alarm;
/**
 * 车辆类型
 * @Class Name CarType
 * @Author wangziqiang
 * @Create In 2018年1月2日
 */
public enum CarType {
  
  PASSENEGER((short)0),    //普通车
  
  SPECIALVEHICLE((short)1),//特殊车
  
  TEMPORARY((short)2);//临停车
  
  private Short type;

  private CarType(Short type) {
    this.type = type;
  }
  /**
   * 得到相对应的类型枚举
   * @Methods Name getEnum
   * @Create In 2018年1月2日 By wangziqiang
   * @param type
   * @return ControlType
   */
  public static CarType getEnum(Short type) {
    for (CarType carType : CarType.values()) {
      if(carType.getType().intValue() == type){
        return carType;
      }
    }  
    return null;
  }
  public Short getType() {
    return type;
  }
  
  
}
