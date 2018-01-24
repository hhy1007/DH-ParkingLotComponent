/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.car.dto;

/**
 * 刷卡上报dto类
 * @Class Name ICCardDto
 * @Author xiaoxiaojie
 * @Create In 2018年1月9日
 */
public class ICCardDto {
    
    private String devCode;//设备编号
    
    private String cardNumber;//卡号
    
    private String ownerId;//业主id
    
    private String carNum;//车牌

    public String getDevCode() {
        return devCode;
    }

    public void setDevCode(String devCode) {
        this.devCode = devCode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }
    
    
}
