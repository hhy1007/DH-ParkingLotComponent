/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.dto.charge;

import java.util.Date;

import com.eg.egsc.framework.client.dto.BaseBusinessDto;

/**
 * 线上充值DTO
 * 
 * @author huangyuhong
 * @since 2018年1月12日
 */
public class ChargeOnlineDto extends BaseBusinessDto{
    
    /**
     * @Field long serialVersionUID 
     */
    private static final long serialVersionUID = -119367541764222378L;

    private Integer money;
    
    private String carNum;
    
    private Date month;
    
    private Short carportType;
    
    private String carportCode;

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    public Short getCarportType() {
        return carportType;
    }

    public void setCarportType(Short carportType) {
        this.carportType = carportType;
    }

    public String getCarportCode() {
        return carportCode;
    }

    public void setCarportCode(String carportCode) {
        this.carportCode = carportCode;
    }

   
}
