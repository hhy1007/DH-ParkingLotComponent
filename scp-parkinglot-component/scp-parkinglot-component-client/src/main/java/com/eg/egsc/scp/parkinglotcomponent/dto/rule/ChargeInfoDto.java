/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.dto.rule;

import java.io.Serializable;

/**
 * 收费规则管理管理基本信息dto类
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public class ChargeInfoDto implements Serializable {
    
    /**
     * @Field long serialVersionUID 
     */
    private static final long serialVersionUID = -5409882028508552711L;

    private FreeTimeDto freeTime;//免费时间
    
    private Integer highestFee;//全天最高收费
    
    private Integer carType;//0：小车，1：大车，2：超大车，3：摩托车
    
    private ChargeDetailDto chargeDetailDto;//价格明细
    
    private String available;//0：未启用，1：已启用
    
    private Integer timeCharge;//按次收费
    

    public Integer getTimeCharge() {
        return timeCharge;
    }
    
    public String getAvailable() {
        return available;
    }
    
    public Integer getCarType() {
        return carType;
    }
    
    public FreeTimeDto getFreeTime() {
        return freeTime;
    }

    public void setTimeCharge(Integer timeCharge) {
        this.timeCharge = timeCharge;
    }
    
    public void setAvailable(String available) {
        this.available = available;
    }
    
    public void setFreeTime(FreeTimeDto freeTime) {
        this.freeTime = freeTime;
    }
    
    public void setHighestFee(Integer highestFee) {
        this.highestFee = highestFee;
    }
    
    public void setChargeDetailDto(ChargeDetailDto chargeDetailDto) {
        this.chargeDetailDto = chargeDetailDto;
    }

    public void setCarType(Integer carType) {
        this.carType = carType;
    }

    public Integer getHighestFee() {
        return highestFee;
    }

    public ChargeDetailDto getChargeDetailDto() {
        return chargeDetailDto;
    }
}
