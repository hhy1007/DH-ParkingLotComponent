/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus;

/**
 * @Class Name OperateType
 * @Author wangziqiang
 * @Create In 2018年1月2日
 */
public enum OperateType {

  AUTO(0), // 自动开闸
  MANUAL(1);//手动开闸
  private Integer type;

  private OperateType(Integer type) {
    this.type = type;
  }

  /**
   * 取得相应的枚举类型
   * 
   * @Methods Name getEnum
   * @Create In 2018年1月2日 By wangziqiang
   * @param type
   * @return ChannelDirect
   */
  public static OperateType getEnum(Integer type) {
    for (OperateType operateType : OperateType.values()) {
      if (operateType.getType().intValue() == type) {
        return operateType;
      }
    }
    return null;
  }

  public Integer getType() {
    return type;
  }

}
