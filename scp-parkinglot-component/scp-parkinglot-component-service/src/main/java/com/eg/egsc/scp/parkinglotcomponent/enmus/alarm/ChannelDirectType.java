/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus.alarm;
/**
 * 车道方向三
 * @Class Name ChannelDirect
 * @Author wangziqiang
 * @Create In 2018年1月2日
 */
public enum ChannelDirectType {
 
  ENTRANCE((short)0),//进口道
  
  EXPROTATION((short)1);//出口道
  
  private Short type;
  
  private ChannelDirectType(Short type) {
    this.type =type;
  }
  
  /**
   * 取得相应的枚举类型
   * @Methods Name getEnum
   * @Create In 2018年1月2日 By wangziqiang
   * @param type
   * @return ChannelDirect
   */
  public static ChannelDirectType getEnum(Short type) {
    for (ChannelDirectType channelDirect : ChannelDirectType.values()) {
      if(channelDirect.getType().shortValue() == type.shortValue()) {
        return channelDirect;
      }
    }
    return null;
  }
  
  public Short getType() {
    return type;
  }
}
