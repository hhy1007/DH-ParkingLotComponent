/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.integration.dto;

import java.util.Date;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAccessCur;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkConsumeRecord;

/**
 * 车辆进出事件参数
 * 
 * @Class Name CarInOutDto
 * @Author zhangli
 * @Create In 2017年12月17日
 */
public class CarInOutDto {

    private String carNum;// 车牌

    private String ownerId;// 业主id

    private String ownerName;// 业主姓名

    private String cardNumber;// 卡号

    private int controlType;// 开闸方式 0-自动开闸、1-确认开闸、2-人工放行

    private Date inTime;// 入场时间

    private Date outTime;// 出场时间

    private String ruleName;// 规则名称
    
    private String parkPackageId;//套餐id

    private String channelId;// 车道id 用于查询redis的value

    private String channelName;// 通道名字

    private String channelIp;// 通道ip

    private String devCode;// 抓拍记录相机Id 或者ic刷卡设备

    private short direct;// 1-进，2-出

    private short carType;// 汽车类型 0-普通车 1-特殊车

    private short carportType;// 车位类型

    private String money;// 缴费金额

    private String carMode;// 车型 0-小车，1-大车，2-超大车，3-摩托车

    private ParkConsumeRecord parkConsumeRecord;// 消费记录

    private ParkAccessCur parkAccessCur;// 在场记录

    private String inImgUrl;// 进场车辆图片

    private String outCarPic;// 出时车辆图片

    private String outNumUrl;// 出时车牌图片

    private String parkingLotId;// 停车场id

    private String outSluiceCode;// 出时抬杆编号

    private String parkCode;// 车场编号

    private String remark;// 备注 预留字段

    private String timeLength;// 时长

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public short getCarType() {
        return carType;
    }

    public void setCarType(short carType) {
        this.carType = carType;
    }

    public short getCarportType() {
        return carportType;
    }

    public void setCarportType(short carportType) {
        this.carportType = carportType;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getCarMode() {
        return carMode;
    }

    public void setCarMode(String carMode) {
        this.carMode = carMode;
    }


    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public ParkConsumeRecord getParkConsumeRecord() {
        return parkConsumeRecord;
    }

    public void setParkConsumeRecord(ParkConsumeRecord parkConsumeRecord) {
        this.parkConsumeRecord = parkConsumeRecord;
    }

    public ParkAccessCur getParkAccessCur() {
        return parkAccessCur;
    }

    public void setParkAccessCur(ParkAccessCur parkAccessCur) {
        this.parkAccessCur = parkAccessCur;
    }

    public String getDevCode() {
        return devCode;
    }

    public void setDevCode(String devCode) {
        this.devCode = devCode;
    }

    public String getOutCarPic() {
        return outCarPic;
    }

    public void setOutCarPic(String outCarPic) {
        this.outCarPic = outCarPic;
    }

    public String getOutNumUrl() {
        return outNumUrl;
    }

    public void setOutNumUrl(String outNumUrl) {
        this.outNumUrl = outNumUrl;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOutSluiceCode() {
        return outSluiceCode;
    }

    public void setOutSluiceCode(String outSluiceCode) {
        this.outSluiceCode = outSluiceCode;
    }

    public String getParkCode() {
        return parkCode;
    }

    public void setParkCode(String parkCode) {
        this.parkCode = parkCode;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }
    
    public String getParkPackageId() {
        return parkPackageId;
    }

    public void setParkPackageId(String parkPackageId) {
        this.parkPackageId = parkPackageId;
    }

    public short getDirect() {
        return direct;
    }

    public void setDirect(short direct) {
        this.direct = direct;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelIp() {
        return channelIp;
    }

    public void setChannelIp(String channelIp) {
        this.channelIp = channelIp;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getInImgUrl() {
        return inImgUrl;
    }

    public void setInImgUrl(String inImgUrl) {
        this.inImgUrl = inImgUrl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getControlType() {
        return controlType;
    }

    public void setControlType(int controlType) {
        this.controlType = controlType;
    }

    public String getTimeLength() {
        return timeLength;
    }

    public void setTimeLength(String timeLength) {
        this.timeLength = timeLength;
    }


}
