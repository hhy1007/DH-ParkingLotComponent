/**
 * @Probject Name: scp-parkinglot-component-service
 * @Path: com.eg.egsc.scp.parkinglotcomponent.enmus.ruleSeatFullTurnTemp.java
 * @Create By wangziqiang
 * @Create In 2018年1月19日 下午12:02:33 
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus.rule;

/**
 * 个人车位已满是否三转临停车
 * 
 * @Class Name SeatFullTurnTemp
 * @Author wangziqiang
 * @Create In 2018年1月19日
 */
public enum SeatFullTurnTemp {
    TURN(1, "转临停车"),

    NTI(0, "不转临停");

    private Integer type;

    private String desc;

    private SeatFullTurnTemp(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }
    /**
     * 通过类型得到 SeatFullTurnTemp
     * @Methods Name getEnum
     * @Create In 2018年1月19日 By wangziqiang
     * @param type
     * @return SeatFullTurnTemp
     */
    public static SeatFullTurnTemp getEnum(Integer type) {
        for (SeatFullTurnTemp seatFullTurnTemp : SeatFullTurnTemp.values()) {
            if (seatFullTurnTemp.getType().intValue() == type) {
                return seatFullTurnTemp;
            }
        }
        return null;
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

}
