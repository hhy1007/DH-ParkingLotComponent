/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.condition.consume;

import java.util.Date;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageCondition;

/**
 * 消费记录查询条件
 * @Class Name ConsumeRecordCondition
 * @Author xiaoxiaojie
 * @Create In 2017年12月18日
 */
public class ConsumeRecordCondition extends PageCondition {
    
    private String carNum;//车牌编号
    
    private Short feeType;//收费类型

    private Date consumeStartTime;//收费开始时间
    
    private Date consumeEndTime;//收费结束时间

    public Date getConsumeStartTime() {
        return consumeStartTime;
    }

    public void setConsumeStartTime(Date consumeStartTime) {
        this.consumeStartTime = consumeStartTime;
    }

    public Date getConsumeEndTime() {
        return consumeEndTime;
    }

    public void setConsumeEndTime(Date consumeEndTime) {
        this.consumeEndTime = consumeEndTime;
    }

    public Short getFeeType() {
        return feeType;
    }

    public void setFeeType(Short feeType) {
        this.feeType = feeType;
    }

   

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }
    
    
}
