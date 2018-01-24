/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus.alarm;

/**
 * 报警类型
 * @Class Name AlarmType
 * @Author zhangli
 * @Create In 2017年12月19日
 */
public enum AlarmType {

    BLACKLIST(0), //黑名单报警

    CARPORT(1), //车位占用报警
    
    ARREARS(2); //业主欠费报警
    
    private Integer type;
    
    private AlarmType (Integer type){
        this.type = type;
    }

   public static AlarmType getEnum(Integer type){
        for(AlarmType alarmType : AlarmType.values()){
            if(alarmType.getType().intValue() == type){
                return alarmType;
            }
        }
        return null;
    }
    
    public Integer getType() {
        return type;
    }
}
