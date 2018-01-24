/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.condition.access;

import java.util.Date;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageCondition;

/**
 * 车辆信息查询过滤条件
 * 
 * @Class Name AccesscurCondition
 * @Author xiangdaoping
 * @Create In 2017年12月15日
 */
public class AccessCurCondition extends PageCondition {

    private String id;

    private String parkCode;// 车场编号

    private String carNum;// 车牌号码

    private String carNumFzzz;// 模糊查询

    private String orderByClause;// 排序字段

    private String cardNumber;

    private Date inTime;

    private String inCameraCode;

    private Short enterMode;

    private Short carType;

    private String ownerId;//车主 

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInCameraCode(String inCameraCode) {
        this.inCameraCode = inCameraCode;
    }

    public String getInCameraCode() {
        return inCameraCode;
    }

    public void setEnterMode(Short enterMode) {
        this.enterMode = enterMode;
    }

    public Short getEnterMode() {
        return enterMode;
    }

    public void setCarType(Short carType) {
        this.carType = carType;
    }

    public Short getCarType() {
        return carType;
    }

    public void setParkCode(String parkCode) {
        this.parkCode = parkCode;
    }

    public String getParkCode() {
        return parkCode;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNumFzzz(String carNumFzzz) {
        this.carNumFzzz = carNumFzzz;
    }

    public String getCarNumFzzz() {
        return carNumFzzz;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
    
}
