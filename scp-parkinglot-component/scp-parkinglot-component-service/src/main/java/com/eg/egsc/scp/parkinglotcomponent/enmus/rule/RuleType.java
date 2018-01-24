/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus.rule;

/**
 * 收费规则的类型枚举类
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public enum RuleType {

    TIME("time", "收费按次"),
    
    INTERVAL("interval", "收费按时段");
    
    private String type;
    
    private String desc;
    
    private RuleType (String type, String desc){
        this.type = type;
        this.desc = desc;
    }

   public static RuleType getEnum(String type){
        for(RuleType zeroOneFlag : RuleType.values()){
            if(zeroOneFlag.getType() .equals( type)){
                return zeroOneFlag;
            }
        }
        return null;
    }
    
    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
