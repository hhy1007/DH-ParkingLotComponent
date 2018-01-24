/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.vo.consume;

import java.util.Date;

import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseConvert;
import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseVo;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkConsumeRecord;

public class ConsumeRecordVo implements BaseVo<ParkConsumeRecord> {

    private String uuid;

    private String carNum;

    private String cardNumber;

    private String ownerId;

    private Date consumeTime;

    private Integer consumeAmount;

    private Date createTime;

    private Integer feeAmount;

    private String serialNumber;

    private Date updateTime;

    private Short feeType;

    private Integer favorableAmount;

    private Short favorableType;

    private String courtUuid;

    private String favorableTicketNumber;

    private String operatorId;

    private String operatorName;

    private String updateUser;

    private String timeLength;

    private String accessId;

    private String createUser;

    private String memo;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
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


    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCourtUuid() {
        return courtUuid;
    }

    public void setCourtUuid(String courtUuid) {
        this.courtUuid = courtUuid;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Date getConsumeTime() {
        return consumeTime;
    }

    public void setConsumeTime(Date consumeTime) {
        this.consumeTime = consumeTime;
    }

    public Integer getConsumeAmount() {
        return consumeAmount;
    }

    public void setConsumeAmount(Integer consumeAmount) {
        this.consumeAmount = consumeAmount;
    }

    public Integer getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(Integer feeAmount) {
        this.feeAmount = feeAmount;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Short getFeeType() {
        return feeType;
    }

    public void setFeeType(Short feeType) {
        this.feeType = feeType;
    }

    public Integer getFavorableAmount() {
        return favorableAmount;
    }

    public void setFavorableAmount(Integer favorableAmount) {
        this.favorableAmount = favorableAmount;
    }

    public Short getFavorableType() {
        return favorableType;
    }

    public void setFavorableType(Short favorableType) {
        this.favorableType = favorableType;
    }

    public String getFavorableTicketNumber() {
        return favorableTicketNumber;
    }

    public void setFavorableTicketNumber(String favorableTicketNumber) {
        this.favorableTicketNumber = favorableTicketNumber;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getTimeLength() {
        return timeLength;
    }

    public void setTimeLength(String timeLength) {
        this.timeLength = timeLength;
    }

    public String getAccessId() {
        return accessId;
    }

    public void setAccessId(String accessId) {
        this.accessId = accessId;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public void convertPOToVO(ParkConsumeRecord poObj) {
        if (poObj != null) {
            BaseConvert.convertPOToVO(poObj, this);
        }

    }

    @Override
    public ParkConsumeRecord convertVOToPO() {
        ParkConsumeRecord parkConsumeRecord = new ParkConsumeRecord();
        BaseConvert.convertVOToPO(this, parkConsumeRecord);
        return parkConsumeRecord;
    }

}
