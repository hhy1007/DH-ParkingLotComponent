/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus.alarm;
/**
 * 放行方式
 * @Class Name OpenWay
 * @Author wangziqiang
 * @Create In 2018年1月2日
 */
public enum OpenWay {
    INTOUTLOTBYMAN(0),//进出人工确认放行
    INTOUTLOTBYMACHINE(1), //进出自动放行
    INTLOTBYMAN(2),//进场人工确认放行   
    OUTLOTBYMAN(3);//出场人工确认放行
    
    private Integer type;
    
    private OpenWay(Integer type) {
      this.type = type;
    }
    /**
     * 查询得到符合条件的枚举
     * @Methods Name getEnum
     * @Create In 2018年1月2日 By wangziqiang
     * @param type
     * @return OpenWay
     */
    public static OpenWay getEnum(Integer type) {
      for (OpenWay openWay : OpenWay.values()) {
        if(openWay.getType().intValue() == type) {
          return openWay;
        }
      }
      return null;
    }
    
    public Integer getType(){    
      return type;
    }
}
