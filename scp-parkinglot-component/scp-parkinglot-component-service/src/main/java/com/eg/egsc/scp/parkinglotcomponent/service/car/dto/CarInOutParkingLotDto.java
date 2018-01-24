/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.car.dto;

import java.io.Serializable;
import java.util.Date;

import com.eg.egsc.scp.parkinglotcomponent.dto.rule.ChargeInfoDto;
import com.eg.egsc.scp.parkinglotcomponent.service.rule.dto.RuleDto;

/**
 * 车辆进出场时Dto类
 * 
 * @Class Name CarEnterParkingLotDto
 * @Author xiaoxiaojie
 * @Create In 2017年12月22日
 */
public class CarInOutParkingLotDto implements Serializable {

    /**
     * @Field long serialVersionUID
     */
    private static final long serialVersionUID = 5817777501705921982L;

    private String devCode;// 抓拍车辆的设备编号

    private String carNum;// 车牌号

    private int operateType;// 是否开闸

    private String imgUrl;// 车辆图片

    private String numUrl;// 车牌图片

    private String cardNumber;// 卡号

    private String ownerId;// 业主id

    private Short carType;// 汽车类型

    private String parkPackageId;// 套餐id

    private String carMode;

    private String carNumColor;// 车牌颜色

    private short direct;// 1-进，2-出

    private short carportType;// 车位类型

    private Date carInOutCurrentTime;// 车辆进出场时间

    private String channelId;// 通道id

    private String channelName;// 通道名称

    private String channelIP;// 通道ip

    private String parkinglotUuid;// 车场id

    private String parkCode;// 车场编号

    private String defaultRuleId;// 车场默认进场规则id

    private RuleDto ruleDto;// 车辆进出场规则

    private ChargeInfoDto feeRuleDto;// 收费规则

    private String money;// 消费的金额

    public String getDevCode() {
        return devCode;
    }

    public void setDevCode(String devCode) {
        this.devCode = devCode;
    }

    public String getChannelIP() {
        return channelIP;
    }

    public void setChannelIP(String channelIP) {
        this.channelIP = channelIP;
    }

    public String getParkinglotUuid() {
        return parkinglotUuid;
    }

    public void setParkinglotUuid(String parkinglotUuid) {
        this.parkinglotUuid = parkinglotUuid;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }


    public String getDefaultRuleId() {
        return defaultRuleId;
    }

    public void setDefaultRuleId(String defaultRuleId) {
        this.defaultRuleId = defaultRuleId;
    }

    public String getNumUrl() {
        return numUrl;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public void setNumUrl(String numUrl) {
        this.numUrl = numUrl;
    }

    public String getChannelName() {
        return channelName;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Short getCarType() {
        return carType;
    }

    public void setCarType(Short carType) {
        this.carType = carType;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getParkPackageId() {
        return parkPackageId;
    }

    public void setParkPackageId(String parkPackageId) {
        this.parkPackageId = parkPackageId;
    }

    public String getCarMode() {
        return carMode;
    }

    public void setCarMode(String carMode) {
        this.carMode = carMode;
    }

    public String getCarNumColor() {
        return carNumColor;
    }

    public void setCarNumColor(String carNumColor) {
        this.carNumColor = carNumColor;
    }

    public short getDirect() {
        return direct;
    }

    public void setDirect(short direct) {
        this.direct = direct;
    }

    public short getCarportType() {
        return carportType;
    }

    public void setCarportType(short carportType) {
        this.carportType = carportType;
    }

    public Date getCarInOutCurrentTime() {
        return carInOutCurrentTime;
    }

    public void setCarInOutCurrentTime(Date carEnterCurrentTime) {
        this.carInOutCurrentTime = carEnterCurrentTime;
    }

    public RuleDto getRuleDto() {
        return ruleDto;
    }

    public void setRuleDto(RuleDto ruleDto) {
        this.ruleDto = ruleDto;
    }

    public ChargeInfoDto getFeeRuleDto() {
        return feeRuleDto;
    }

    public void setFeeRuleDto(ChargeInfoDto feeRuleDto) {
        this.feeRuleDto = feeRuleDto;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public int getOperateType() {
        return operateType;
    }

    public void setOperateType(int operateType) {
        this.operateType = operateType;
    }

    public String getParkCode() {
        return parkCode;
    }

    public void setParkCode(String parkCode) {
        this.parkCode = parkCode;
    }

}
