/**
 * @Probject Name: scp-parkinglot-component-service
 * @Path: com.eg.egsc.scp.parkinglotcomponent.enmus.ruleMonthCarTurnTemp.java
 * @Create By wangziqiang
 * @Create In 2018年1月19日 下午2:25:29
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus.rule;

/**
 * 月保车过期转不转临停
 * @Class Name MonthCarTurnTemp
 * @Author wangziqiang
 * @Create In 2018年1月19日
 */
public enum MonthCarTurnTemp {
    MTURN(1, "转临停车"),

    MNTI(0, "不转临停");

    private Integer type;

    private String desc;

    private MonthCarTurnTemp(Integer type, String desc) {
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
    public static MonthCarTurnTemp getEnum(Integer type) {
        for (MonthCarTurnTemp monthCarTurnTemp : MonthCarTurnTemp.values()) {
            if (monthCarTurnTemp.getType().intValue() == type) {
                return monthCarTurnTemp;
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
