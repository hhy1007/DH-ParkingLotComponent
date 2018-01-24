/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.extmapper.access.entity;

import java.util.Date;

import com.eg.egsc.scp.parkinglotcomponent.extmapper.park.entity.ParkingLot;


/**
 * 入场记录信息(自定义)
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public class AccessCur {

    private String carNum;// 车牌号码

    private String id;

    private Date updateTime;// 最后缴费时间

    private String cardNumber;// 卡号

    private String ownerId;// 车主ID

    private Integer payedMoney;// 已缴费用

    private Short carportType;// 车位类型：1-月租，2-产权，0-临停

    private String inChannelId;// 入场通道ID

    private String inCameraCode;// 入场抓拍相机编号

    private String inNumUrl;// 入场车牌图片

    private String inImgUrl;// 入场车辆图片

    private Short enterMode;// 已缴费用

    private Short needPay;// 是否需收费：0-否，1-是

    private String parkPackageId;// 使用套餐ID

    private Short carType;// 停，1-普通车；2-专有车

    private ParkingLot parkingLot;// 停车场信息

    private String parkCode;// 停车场编号

    private Date createTime;// 入场时间

    public String getId() {
        return id;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public String getCarNum() {
        return carNum;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getParkCode() {
        return parkCode;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }


    public String getCardNumber() {
        return cardNumber;
    }

    public void setParkCode(String parkCode) {
        this.parkCode = parkCode;
    }

    public Short getCarportType() {
        return carportType;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCarportType(Short carportType) {
        this.carportType = carportType;
    }

    public String getParkPackageId() {
        return parkPackageId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getInCameraCode() {
        return inCameraCode;
    }

    public void setParkPackageId(String parkPackageId) {
        this.parkPackageId = parkPackageId;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getInChannelId() {
        return inChannelId;
    }

    public void setInCameraCode(String inCameraCode) {
        this.inCameraCode = inCameraCode;
    }

    public void setInChannelId(String inChannelId) {
        this.inChannelId = inChannelId;
    }

    public String getInImgUrl() {
        return inImgUrl;
    }

    public String getInNumUrl() {
        return inNumUrl;
    }

    public void setInImgUrl(String inImgUrl) {
        this.inImgUrl = inImgUrl;
    }

    public Short getEnterMode() {
        return enterMode;
    }

    public void setInNumUrl(String inNumUrl) {
        this.inNumUrl = inNumUrl;
    }

    public Short getNeedPay() {
        return needPay;
    }

    public Integer getPayedMoney() {
        return payedMoney;
    }

    public void setEnterMode(Short enterMode) {
        this.enterMode = enterMode;
    }

    public void setNeedPay(Short needPay) {
        this.needPay = needPay;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setPayedMoney(Integer payedMoney) {
        this.payedMoney = payedMoney;
    }

    public Short getCarType() {
        return carType;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setCarType(Short carType) {
        this.carType = carType;
    }

}
