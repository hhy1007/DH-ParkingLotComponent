/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.rule.dto;

/**
 * 通用计费接口返回的信息
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public class ResponseBillingDto {
    
    private Integer theStopTime = 0;//停车时长

    private String charges;//收费金额

    public String getCharges() {
        return charges;
    }
    
    public void setTheStopTime(Integer theStopTime) {
        this.theStopTime = theStopTime;
    }

    public Integer getTheStopTime() {
        return theStopTime;
    }

    public void setCharges(String charges) {
        this.charges = charges;
    }

}
