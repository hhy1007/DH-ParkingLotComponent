/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.dto.rule;

/**
 * 高峰期
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public class PeakPeriodDto {
    private String startTime;//高峰期开始时间
    
    private String endTime;//高峰期结束时间
    
    private Integer cash;//3.5元
    
    private Integer each;//每30分钟

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getCash() {
        return cash;
    }

    public void setCash(Integer cash) {
        this.cash = cash;
    }

    public Integer getEach() {
        return each;
    }

    public void setEach(Integer each) {
        this.each = each;
    }
    
    
}
