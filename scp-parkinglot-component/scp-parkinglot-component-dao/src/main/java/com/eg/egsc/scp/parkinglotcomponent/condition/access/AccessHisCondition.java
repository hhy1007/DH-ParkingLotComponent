/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.condition.access;

import java.util.Date;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageCondition;

public class AccessHisCondition extends PageCondition {

    private String id;

    private String parkCode;

    private String carNum;

    private Date inTime;

    private String cardNumber;

    private String inSluiceCode;

    private String inCameraCode;

    private String outCameraCode;

    private String outCarNum;

    private Date outTime;

    private Short carType;

    private String outSluiceCode;

    private String forceOperator;

    private Short carStatus;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setParkCode(String parkCode) {
        this.parkCode = parkCode;
    }

    public String getParkCode() {
        return parkCode;
    }

    public void setInCameraCode(String inCameraCode) {
        this.inCameraCode = inCameraCode;
    }

    public String getInCameraCode() {
        return inCameraCode;
    }
    
    public void setInSluiceCode(String inSluiceCode) {
        this.inSluiceCode = inSluiceCode;
    }

    public String getInSluiceCode() {
        return inSluiceCode;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getInTime() {
        return inTime;
    }
    public void setOutCarNum(String outCarNum) {
        this.outCarNum = outCarNum;
    }

    public String getOutCarNum() {
        return outCarNum;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutCameraCode(String outCameraCode) {
        this.outCameraCode = outCameraCode;
    }

    public String getOutCameraCode() {
        return outCameraCode;
    }

    public void setOutSluiceCode(String outSluiceCode) {
        this.outSluiceCode = outSluiceCode;
    }

    public String getOutSluiceCode() {
        return outSluiceCode;
    }

    public void setCarType(Short carType) {
        this.carType = carType;
    }

    public Short getCarType() {
        return carType;
    }

    public void setCarStatus(Short carStatus) {
        this.carStatus = carStatus;
    }

    public Short getCarStatus() {
        return carStatus;
    }

    public void setForceOperator(String forceOperator) {
        this.forceOperator = forceOperator;
    }

    public String getForceOperator() {
        return forceOperator;
    }
    
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}
