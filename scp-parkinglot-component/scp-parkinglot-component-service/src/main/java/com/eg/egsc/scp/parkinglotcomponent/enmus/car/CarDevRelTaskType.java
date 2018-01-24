/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus.car;

/**
 * 车辆下发任务类型
 * 
 * @author huangyuhong
 * @since 2018年1月22日
 */
public enum CarDevRelTaskType {

    CARNUM((short) 0, "车牌下发"),

    CARD((short) 1, "卡片下发");

    private Short type;

    private String desc;

    private CarDevRelTaskType(Short type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static CarDevRelTaskType getEnum(Short type) {
        for (CarDevRelTaskType carDevRelTaskType : CarDevRelTaskType.values()) {
            if (carDevRelTaskType.getType().shortValue() == type) {
                return carDevRelTaskType;
            }
        }
        return null;
    }

    public Short getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

}
