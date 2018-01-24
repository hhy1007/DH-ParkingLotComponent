/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.vo.access;

import java.util.Date;

import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseConvert;
import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseVo;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAccessHis;

public class AccesshisVo implements BaseVo<ParkAccessHis> {

    private String uuid;
    private String carNum;

    private String ownerId;

    private String parkCode;

    private String cardNumber;

    private Short carportType;

    private String packageId;

    private String inChannelId;

    private Date createTime;

    private String inCameraCode;

    private String inSluiceCode;

    private String inImgUrl;

    private String outCarNum;

    private String carMode;

    private String inMemo;

    private String outMemo;

    private String outChannelId;

    private Date updateTime;

    private String outCameraCode;

    private String outSluiceCode;

    private String outImgUrl;

    private Short enterMode;

    private Integer payedMoney;

    private Date lastPayedTime;

    private Short carType;

    private Short carStatus;

    private String createUser;

    private String updateUser;

    private String forceOperator;

    private String courtUuid;


    public String getUuid() {
        return uuid;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getParkCode() {
        return parkCode;
    }

    public void setParkCode(String parkCode) {
        this.parkCode = parkCode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }


    public String getCarMode() {
        return carMode;
    }

    public void setCarMode(String carMode) {
        this.carMode = carMode;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Short getCarportType() {
        return carportType;
    }

    public void setCarportType(Short carportType) {
        this.carportType = carportType;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getInChannelId() {
        return inChannelId;
    }


    public String getInMemo() {
        return inMemo;
    }

    public void setInMemo(String inMemo) {
        this.inMemo = inMemo;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public void setInChannelId(String inChannelId) {
        this.inChannelId = inChannelId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getInCameraCode() {
        return inCameraCode;
    }

    public void setInCameraCode(String inCameraCode) {
        this.inCameraCode = inCameraCode;
    }

    public String getInSluiceCode() {
        return inSluiceCode;
    }

    public void setInSluiceCode(String inSluiceCode) {
        this.inSluiceCode = inSluiceCode;
    }

    public String getInImgUrl() {
        return inImgUrl;
    }

    public void setInImgUrl(String inImgUrl) {
        this.inImgUrl = inImgUrl;
    }

    public String getOutCarNum() {
        return outCarNum;
    }

    public void setOutCarNum(String outCarNum) {
        this.outCarNum = outCarNum;
    }



    public String getOutMemo() {
        return outMemo;
    }

    public void setOutMemo(String outMemo) {
        this.outMemo = outMemo;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getOutChannelId() {
        return outChannelId;
    }

    public void setOutChannelId(String outChannelId) {
        this.outChannelId = outChannelId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getOutCameraCode() {
        return outCameraCode;
    }

    public void setOutCameraCode(String outCameraCode) {
        this.outCameraCode = outCameraCode;
    }

    public String getOutSluiceCode() {
        return outSluiceCode;
    }

    public void setOutSluiceCode(String outSluiceCode) {
        this.outSluiceCode = outSluiceCode;
    }

    public String getOutImgUrl() {
        return outImgUrl;
    }

    public void setOutImgUrl(String outImgUrl) {
        this.outImgUrl = outImgUrl;
    }

    public Short getEnterMode() {
        return enterMode;
    }

    public void setEnterMode(Short enterMode) {
        this.enterMode = enterMode;
    }

    public Integer getPayedMoney() {
        return payedMoney;
    }

    public void setPayedMoney(Integer payedMoney) {
        this.payedMoney = payedMoney;
    }

    public Date getLastPayedTime() {
        return lastPayedTime;
    }

    public void setLastPayedTime(Date lastPayedTime) {
        this.lastPayedTime = lastPayedTime;
    }

    public Short getCarType() {
        return carType;
    }

    public void setCarType(Short carType) {
        this.carType = carType;
    }

    public Short getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(Short carStatus) {
        this.carStatus = carStatus;
    }

    public String getForceOperator() {
        return forceOperator;
    }

    public void setForceOperator(String forceOperator) {
        this.forceOperator = forceOperator;
    }


    public String getCourtUuid() {
        return courtUuid;
    }

    public void setCourtUuid(String courtUuid) {
        this.courtUuid = courtUuid;
    }

    @Override
    public void convertPOToVO(ParkAccessHis poObj) {
        if (poObj != null) {
            BaseConvert.convertPOToVO(poObj, this);
        }

    }

    @Override
    public ParkAccessHis convertVOToPO() {
        ParkAccessHis accesshis = new ParkAccessHis();
        BaseConvert.convertVOToPO(this, accesshis);
        return accesshis;
    }
}
