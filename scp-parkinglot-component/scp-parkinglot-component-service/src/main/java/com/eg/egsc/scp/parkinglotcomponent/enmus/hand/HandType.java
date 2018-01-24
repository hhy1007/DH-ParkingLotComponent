/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus.hand;

/**
 * @Class Name HandType
 * @Author wangziqiang
 * @Create In 2018年1月5日
 */
public enum HandType {
  MANUAL((short)1);//手动开闸
  private short type;

  private HandType(short type) {
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
  public static HandType getEnum(short type) {
    for (HandType handType : HandType.values()) {
      if (handType.getType() == type) {
        return handType;
      }
    }
    return null;
  }

  public short getType() {
    return type;
  }
}
