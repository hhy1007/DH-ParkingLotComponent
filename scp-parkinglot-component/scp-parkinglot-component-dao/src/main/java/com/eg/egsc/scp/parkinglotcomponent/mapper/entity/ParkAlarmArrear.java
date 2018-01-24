package com.eg.egsc.scp.parkinglotcomponent.mapper.entity;

import java.util.Date;

public class ParkAlarmArrear {
    private String uuid;

    private String carportCode;

    private String carNum;

    private String ownerId;

    private String ownerName;

    private String ownerPhone;

    private Short carportType;

    private Integer feeAmount;

    private Short chargeState;

    private Integer arrearAmount;

    private Short alarmState;

    private String relieveUser;

    private String courtUuid;

    private Date createTime;

    private Date updateTime;

    private String createUser;

    private String updateUser;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCarportCode() {
        return carportCode;
    }

    public void setCarportCode(String carportCode) {
        this.carportCode = carportCode;
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

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public Short getCarportType() {
        return carportType;
    }

    public void setCarportType(Short carportType) {
        this.carportType = carportType;
    }

    public Integer getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(Integer feeAmount) {
        this.feeAmount = feeAmount;
    }

    public Short getChargeState() {
        return chargeState;
    }

    public void setChargeState(Short chargeState) {
        this.chargeState = chargeState;
    }

    public Integer getArrearAmount() {
        return arrearAmount;
    }

    public void setArrearAmount(Integer arrearAmount) {
        this.arrearAmount = arrearAmount;
    }

    public Short getAlarmState() {
        return alarmState;
    }

    public void setAlarmState(Short alarmState) {
        this.alarmState = alarmState;
    }

    public String getRelieveUser() {
        return relieveUser;
    }

    public void setRelieveUser(String relieveUser) {
        this.relieveUser = relieveUser;
    }

    public String getCourtUuid() {
        return courtUuid;
    }

    public void setCourtUuid(String courtUuid) {
        this.courtUuid = courtUuid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ParkAlarmArrear other = (ParkAlarmArrear) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getCarportCode() == null ? other.getCarportCode() == null : this.getCarportCode().equals(other.getCarportCode()))
            && (this.getCarNum() == null ? other.getCarNum() == null : this.getCarNum().equals(other.getCarNum()))
            && (this.getOwnerId() == null ? other.getOwnerId() == null : this.getOwnerId().equals(other.getOwnerId()))
            && (this.getOwnerName() == null ? other.getOwnerName() == null : this.getOwnerName().equals(other.getOwnerName()))
            && (this.getOwnerPhone() == null ? other.getOwnerPhone() == null : this.getOwnerPhone().equals(other.getOwnerPhone()))
            && (this.getCarportType() == null ? other.getCarportType() == null : this.getCarportType().equals(other.getCarportType()))
            && (this.getFeeAmount() == null ? other.getFeeAmount() == null : this.getFeeAmount().equals(other.getFeeAmount()))
            && (this.getChargeState() == null ? other.getChargeState() == null : this.getChargeState().equals(other.getChargeState()))
            && (this.getArrearAmount() == null ? other.getArrearAmount() == null : this.getArrearAmount().equals(other.getArrearAmount()))
            && (this.getAlarmState() == null ? other.getAlarmState() == null : this.getAlarmState().equals(other.getAlarmState()))
            && (this.getRelieveUser() == null ? other.getRelieveUser() == null : this.getRelieveUser().equals(other.getRelieveUser()))
            && (this.getCourtUuid() == null ? other.getCourtUuid() == null : this.getCourtUuid().equals(other.getCourtUuid()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getCarportCode() == null) ? 0 : getCarportCode().hashCode());
        result = prime * result + ((getCarNum() == null) ? 0 : getCarNum().hashCode());
        result = prime * result + ((getOwnerId() == null) ? 0 : getOwnerId().hashCode());
        result = prime * result + ((getOwnerName() == null) ? 0 : getOwnerName().hashCode());
        result = prime * result + ((getOwnerPhone() == null) ? 0 : getOwnerPhone().hashCode());
        result = prime * result + ((getCarportType() == null) ? 0 : getCarportType().hashCode());
        result = prime * result + ((getFeeAmount() == null) ? 0 : getFeeAmount().hashCode());
        result = prime * result + ((getChargeState() == null) ? 0 : getChargeState().hashCode());
        result = prime * result + ((getArrearAmount() == null) ? 0 : getArrearAmount().hashCode());
        result = prime * result + ((getAlarmState() == null) ? 0 : getAlarmState().hashCode());
        result = prime * result + ((getRelieveUser() == null) ? 0 : getRelieveUser().hashCode());
        result = prime * result + ((getCourtUuid() == null) ? 0 : getCourtUuid().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uuid=").append(uuid);
        sb.append(", carportCode=").append(carportCode);
        sb.append(", carNum=").append(carNum);
        sb.append(", ownerId=").append(ownerId);
        sb.append(", ownerName=").append(ownerName);
        sb.append(", ownerPhone=").append(ownerPhone);
        sb.append(", carportType=").append(carportType);
        sb.append(", feeAmount=").append(feeAmount);
        sb.append(", chargeState=").append(chargeState);
        sb.append(", arrearAmount=").append(arrearAmount);
        sb.append(", alarmState=").append(alarmState);
        sb.append(", relieveUser=").append(relieveUser);
        sb.append(", courtUuid=").append(courtUuid);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateUser=").append(updateUser);
        sb.append("]");
        return sb.toString();
    }
}