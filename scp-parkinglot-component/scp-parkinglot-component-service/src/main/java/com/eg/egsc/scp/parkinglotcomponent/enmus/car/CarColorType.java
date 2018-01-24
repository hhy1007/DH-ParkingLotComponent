/**
 * @Probject Name: scp-parkinglot-component-service
 * @Path: com.eg.egsc.scp.parkinglotcomponent.enmus.carCarColorType.java
 * @Create By xiaoxiaojie
 * @Create In 2018年1月12日 下午4:39:56
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus.car;

/**
 * @Class Name CarColorType
 * @Author xiaoxiaojie
 * @Create In 2018年1月12日
 */
public enum CarColorType {
    
    BLUE("0", "蓝色"),
    YELLOW("1", "黄色");

    private String type;
    
    private String desc;
    
    private CarColorType(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }
    
    public static CarColorType getEnum(String type) {
        for (CarColorType carColorType : CarColorType.values()) {
            if (carColorType.getType().equals(type)) {
                return carColorType;
            }
        }
        return BLUE;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
    
    
}
