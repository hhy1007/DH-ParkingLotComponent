/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.dto.rule;

import java.util.Date;

import com.eg.egsc.framework.client.dto.BaseBusinessDto;

/**
 * 按收费规则api请求的参数
 * 
 * @author fengrongjun
 * @since 2018年1月15日
 */
public class RequestFeeRuleDto extends BaseBusinessDto {

    private static final long serialVersionUID = -9006334012910014406L;

    private Date startTime;// 停车的开始时间

    private Date endTime;// 停车的结束时间

    private Integer carType;// 0:小车，1：大车，2：超大车 3：摩托车
    
    private String sumMoney;//收费金额

    private FeeRuleDto feeRuleDto;
    
    public String getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(String sumMoney) {
        this.sumMoney = sumMoney;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getCarType() {
        return carType;
    }

    public void setCarType(Integer carType) {
        this.carType = carType;
    }

    public FeeRuleDto getFeeRuleDto() {
        return feeRuleDto;
    }

    public void setFeeRuleDto(FeeRuleDto feeRuleDto) {
        this.feeRuleDto = feeRuleDto;
    }


}
