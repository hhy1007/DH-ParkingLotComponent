/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.dto.rule;

/**
 * 非高峰期
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public class NonPeakPeriodDto {
    
    private Integer cash;//3.5元
    
    private String startTime;//非高峰期开始时间
    
    private Integer each;//每30分钟
    
    private String endTime;//非高峰期结束时间

    public String getEndTime() {
        return endTime;
    }
    
    public String getStartTime() {
        return startTime;
    }

    public Integer getEach() {
        return each;
    }
    
    public Integer getCash() {
        return cash;
    }

    public void setEach(Integer each) {
        this.each = each;
    }
    
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setCash(Integer cash) {
        this.cash = cash;
    }


}
