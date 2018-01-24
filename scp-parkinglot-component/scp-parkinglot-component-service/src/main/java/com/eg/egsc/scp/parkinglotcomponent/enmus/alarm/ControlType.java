/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus.alarm;
/**
 * 道闸开关类型
 * @Class Name ControlType
 * @Author wangziqiang
 * @Create In 2018年1月2日
 */
public enum ControlType {
   
  OPEN(1),//开
  CLOSE(2);//关
  
  private Integer type;
  
  private ControlType(Integer type) {
    this.type =type;
  }
   /**
    * 得到相对应的类型枚举
    * @Methods Name getEnum
    * @Create In 2018年1月2日 By wangziqiang
    * @param type
    * @return ControlType
    */
  public static ControlType getEnum(Integer type) {
    for (ControlType controlType : ControlType.values()) {
      if(controlType.getType().intValue() == type) {
        return controlType;
      }
    }
    return null;
  }
  
  public Integer getType() {
    return type;
  }
}
