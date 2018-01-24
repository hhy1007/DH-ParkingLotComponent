/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.park.dto;

/**
 * @Class Name IcInformationDto
 * @Author wangziqiang
 * @Create In 2018年1月8日
 */
public class IcInformationDto {
    private String devCode;// 刷卡设备ID

    private String cardNumber;// 卡号id

    private int operateType;// 手动或自动开闸 0-自动开闸 1-手动开闸

    private String ownerId;// 车主Id

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

    public int getOperateType() {
        return operateType;
    }

    public void setOperateType(int operateType) {
        this.operateType = operateType;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

}
