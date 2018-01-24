package com.eg.egsc.scp.parkinglotcomponent.mapper.entity;

import java.util.Date;

public class ParkAccessCur {
    private String uuid;

    private String carNum;

    private String ownerId;

    private String parkCode;

    private String cardNumber;

    private Short carportType;

    private String parkPackageId;

    private String inCameraCode;

    private String inChannelId;

    private String inImgUrl;

    private String inNumUrl;

    private String inMemo;

    private Short enterMode;

    private Short needPay;

    private Integer payedMoney;

    private Short carType;

    private String carMode;

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

    public Short getCarportType() {
        return carportType;
    }

    public void setCarportType(Short carportType) {
        this.carportType = carportType;
    }

    public String getParkPackageId() {
        return parkPackageId;
    }

    public void setParkPackageId(String parkPackageId) {
        this.parkPackageId = parkPackageId;
    }

    public String getInCameraCode() {
        return inCameraCode;
    }

    public void setInCameraCode(String inCameraCode) {
        this.inCameraCode = inCameraCode;
    }

    public String getInChannelId() {
        return inChannelId;
    }

    public void setInChannelId(String inChannelId) {
        this.inChannelId = inChannelId;
    }

    public String getInImgUrl() {
        return inImgUrl;
    }

    public void setInImgUrl(String inImgUrl) {
        this.inImgUrl = inImgUrl;
    }

    public String getInNumUrl() {
        return inNumUrl;
    }

    public void setInNumUrl(String inNumUrl) {
        this.inNumUrl = inNumUrl;
    }

    public String getInMemo() {
        return inMemo;
    }

    public void setInMemo(String inMemo) {
        this.inMemo = inMemo;
    }

    public Short getEnterMode() {
        return enterMode;
    }

    public void setEnterMode(Short enterMode) {
        this.enterMode = enterMode;
    }

    public Short getNeedPay() {
        return needPay;
    }

    public void setNeedPay(Short needPay) {
        this.needPay = needPay;
    }

    public Integer getPayedMoney() {
        return payedMoney;
    }

    public void setPayedMoney(Integer payedMoney) {
        this.payedMoney = payedMoney;
    }

    public Short getCarType() {
        return carType;
    }

    public void setCarType(Short carType) {
        this.carType = carType;
    }

    public String getCarMode() {
        return carMode;
    }

    public void setCarMode(String carMode) {
        this.carMode = carMode;
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
        ParkAccessCur other = (ParkAccessCur) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getCarNum() == null ? other.getCarNum() == null : this.getCarNum().equals(other.getCarNum()))
            && (this.getOwnerId() == null ? other.getOwnerId() == null : this.getOwnerId().equals(other.getOwnerId()))
            && (this.getParkCode() == null ? other.getParkCode() == null : this.getParkCode().equals(other.getParkCode()))
            && (this.getCardNumber() == null ? other.getCardNumber() == null : this.getCardNumber().equals(other.getCardNumber()))
            && (this.getCarportType() == null ? other.getCarportType() == null : this.getCarportType().equals(other.getCarportType()))
            && (this.getParkPackageId() == null ? other.getParkPackageId() == null : this.getParkPackageId().equals(other.getParkPackageId()))
            && (this.getInCameraCode() == null ? other.getInCameraCode() == null : this.getInCameraCode().equals(other.getInCameraCode()))
            && (this.getInChannelId() == null ? other.getInChannelId() == null : this.getInChannelId().equals(other.getInChannelId()))
            && (this.getInImgUrl() == null ? other.getInImgUrl() == null : this.getInImgUrl().equals(other.getInImgUrl()))
            && (this.getInNumUrl() == null ? other.getInNumUrl() == null : this.getInNumUrl().equals(other.getInNumUrl()))
            && (this.getInMemo() == null ? other.getInMemo() == null : this.getInMemo().equals(other.getInMemo()))
            && (this.getEnterMode() == null ? other.getEnterMode() == null : this.getEnterMode().equals(other.getEnterMode()))
            && (this.getNeedPay() == null ? other.getNeedPay() == null : this.getNeedPay().equals(other.getNeedPay()))
            && (this.getPayedMoney() == null ? other.getPayedMoney() == null : this.getPayedMoney().equals(other.getPayedMoney()))
            && (this.getCarType() == null ? other.getCarType() == null : this.getCarType().equals(other.getCarType()))
            && (this.getCarMode() == null ? other.getCarMode() == null : this.getCarMode().equals(other.getCarMode()))
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
        result = prime * result + ((getCarNum() == null) ? 0 : getCarNum().hashCode());
        result = prime * result + ((getOwnerId() == null) ? 0 : getOwnerId().hashCode());
        result = prime * result + ((getParkCode() == null) ? 0 : getParkCode().hashCode());
        result = prime * result + ((getCardNumber() == null) ? 0 : getCardNumber().hashCode());
        result = prime * result + ((getCarportType() == null) ? 0 : getCarportType().hashCode());
        result = prime * result + ((getParkPackageId() == null) ? 0 : getParkPackageId().hashCode());
        result = prime * result + ((getInCameraCode() == null) ? 0 : getInCameraCode().hashCode());
        result = prime * result + ((getInChannelId() == null) ? 0 : getInChannelId().hashCode());
        result = prime * result + ((getInImgUrl() == null) ? 0 : getInImgUrl().hashCode());
        result = prime * result + ((getInNumUrl() == null) ? 0 : getInNumUrl().hashCode());
        result = prime * result + ((getInMemo() == null) ? 0 : getInMemo().hashCode());
        result = prime * result + ((getEnterMode() == null) ? 0 : getEnterMode().hashCode());
        result = prime * result + ((getNeedPay() == null) ? 0 : getNeedPay().hashCode());
        result = prime * result + ((getPayedMoney() == null) ? 0 : getPayedMoney().hashCode());
        result = prime * result + ((getCarType() == null) ? 0 : getCarType().hashCode());
        result = prime * result + ((getCarMode() == null) ? 0 : getCarMode().hashCode());
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
        sb.append(", carNum=").append(carNum);
        sb.append(", ownerId=").append(ownerId);
        sb.append(", parkCode=").append(parkCode);
        sb.append(", cardNumber=").append(cardNumber);
        sb.append(", carportType=").append(carportType);
        sb.append(", parkPackageId=").append(parkPackageId);
        sb.append(", inCameraCode=").append(inCameraCode);
        sb.append(", inChannelId=").append(inChannelId);
        sb.append(", inImgUrl=").append(inImgUrl);
        sb.append(", inNumUrl=").append(inNumUrl);
        sb.append(", inMemo=").append(inMemo);
        sb.append(", enterMode=").append(enterMode);
        sb.append(", needPay=").append(needPay);
        sb.append(", payedMoney=").append(payedMoney);
        sb.append(", carType=").append(carType);
        sb.append(", carMode=").append(carMode);
        sb.append(", courtUuid=").append(courtUuid);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateUser=").append(updateUser);
        sb.append("]");
        return sb.toString();
    }
}