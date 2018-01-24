/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus.rule;

/**
 * true,false标记
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public enum BaseFlagFeeRule {

    YES("true", "yes"),

    NO("false", "no");

    private String type;

    private String desc;

    private BaseFlagFeeRule(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static BaseFlagFeeRule getEnum(String type) {
        for (BaseFlagFeeRule zeroOneFlag : BaseFlagFeeRule.values()) {
            if (zeroOneFlag.getType().equals(type)) {
                return zeroOneFlag;
            }
        }
        return NO;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
