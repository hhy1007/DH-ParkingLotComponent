package com.eg.egsc.scp.parkinglotcomponent.mapper.entity;

import java.util.Date;

public class ParkAccessHis {
    private String uuid;

    private String carNum;

    private String ownerId;

    private String parkCode;

    private String cardNumber;

    private Short carportType;

    private String packageId;

    private String carMode;

    private String inChannelId;

    private String inCameraCode;

    private String inSluiceCode;

    private String inImgUrl;

    private String inMemo;

    private String outCarNum;

    private String outChannelId;

    private String outCameraCode;

    private String outSluiceCode;

    private String outImgUrl;

    private String outMemo;

    private Short enterMode;

    private Integer payedMoney;

    private Date lastPayedTime;

    private Short carType;

    private Short carStatus;

    private String forceOperator;

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

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getCarMode() {
        return carMode;
    }

    public void setCarMode(String carMode) {
        this.carMode = carMode;
    }

    public String getInChannelId() {
        return inChannelId;
    }

    public void setInChannelId(String inChannelId) {
        this.inChannelId = inChannelId;
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

    public String getInMemo() {
        return inMemo;
    }

    public void setInMemo(String inMemo) {
        this.inMemo = inMemo;
    }

    public String getOutCarNum() {
        return outCarNum;
    }

    public void setOutCarNum(String outCarNum) {
        this.outCarNum = outCarNum;
    }

    public String getOutChannelId() {
        return outChannelId;
    }

    public void setOutChannelId(String outChannelId) {
        this.outChannelId = outChannelId;
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

    public String getOutMemo() {
        return outMemo;
    }

    public void setOutMemo(String outMemo) {
        this.outMemo = outMemo;
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
        ParkAccessHis other = (ParkAccessHis) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getCarNum() == null ? other.getCarNum() == null : this.getCarNum().equals(other.getCarNum()))
            && (this.getOwnerId() == null ? other.getOwnerId() == null : this.getOwnerId().equals(other.getOwnerId()))
            && (this.getParkCode() == null ? other.getParkCode() == null : this.getParkCode().equals(other.getParkCode()))
            && (this.getCardNumber() == null ? other.getCardNumber() == null : this.getCardNumber().equals(other.getCardNumber()))
            && (this.getCarportType() == null ? other.getCarportType() == null : this.getCarportType().equals(other.getCarportType()))
            && (this.getPackageId() == null ? other.getPackageId() == null : this.getPackageId().equals(other.getPackageId()))
            && (this.getCarMode() == null ? other.getCarMode() == null : this.getCarMode().equals(other.getCarMode()))
            && (this.getInChannelId() == null ? other.getInChannelId() == null : this.getInChannelId().equals(other.getInChannelId()))
            && (this.getInCameraCode() == null ? other.getInCameraCode() == null : this.getInCameraCode().equals(other.getInCameraCode()))
            && (this.getInSluiceCode() == null ? other.getInSluiceCode() == null : this.getInSluiceCode().equals(other.getInSluiceCode()))
            && (this.getInImgUrl() == null ? other.getInImgUrl() == null : this.getInImgUrl().equals(other.getInImgUrl()))
            && (this.getInMemo() == null ? other.getInMemo() == null : this.getInMemo().equals(other.getInMemo()))
            && (this.getOutCarNum() == null ? other.getOutCarNum() == null : this.getOutCarNum().equals(other.getOutCarNum()))
            && (this.getOutChannelId() == null ? other.getOutChannelId() == null : this.getOutChannelId().equals(other.getOutChannelId()))
            && (this.getOutCameraCode() == null ? other.getOutCameraCode() == null : this.getOutCameraCode().equals(other.getOutCameraCode()))
            && (this.getOutSluiceCode() == null ? other.getOutSluiceCode() == null : this.getOutSluiceCode().equals(other.getOutSluiceCode()))
            && (this.getOutImgUrl() == null ? other.getOutImgUrl() == null : this.getOutImgUrl().equals(other.getOutImgUrl()))
            && (this.getOutMemo() == null ? other.getOutMemo() == null : this.getOutMemo().equals(other.getOutMemo()))
            && (this.getEnterMode() == null ? other.getEnterMode() == null : this.getEnterMode().equals(other.getEnterMode()))
            && (this.getPayedMoney() == null ? other.getPayedMoney() == null : this.getPayedMoney().equals(other.getPayedMoney()))
            && (this.getLastPayedTime() == null ? other.getLastPayedTime() == null : this.getLastPayedTime().equals(other.getLastPayedTime()))
            && (this.getCarType() == null ? other.getCarType() == null : this.getCarType().equals(other.getCarType()))
            && (this.getCarStatus() == null ? other.getCarStatus() == null : this.getCarStatus().equals(other.getCarStatus()))
            && (this.getForceOperator() == null ? other.getForceOperator() == null : this.getForceOperator().equals(other.getForceOperator()))
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
        result = prime * result + ((getPackageId() == null) ? 0 : getPackageId().hashCode());
        result = prime * result + ((getCarMode() == null) ? 0 : getCarMode().hashCode());
        result = prime * result + ((getInChannelId() == null) ? 0 : getInChannelId().hashCode());
        result = prime * result + ((getInCameraCode() == null) ? 0 : getInCameraCode().hashCode());
        result = prime * result + ((getInSluiceCode() == null) ? 0 : getInSluiceCode().hashCode());
        result = prime * result + ((getInImgUrl() == null) ? 0 : getInImgUrl().hashCode());
        result = prime * result + ((getInMemo() == null) ? 0 : getInMemo().hashCode());
        result = prime * result + ((getOutCarNum() == null) ? 0 : getOutCarNum().hashCode());
        result = prime * result + ((getOutChannelId() == null) ? 0 : getOutChannelId().hashCode());
        result = prime * result + ((getOutCameraCode() == null) ? 0 : getOutCameraCode().hashCode());
        result = prime * result + ((getOutSluiceCode() == null) ? 0 : getOutSluiceCode().hashCode());
        result = prime * result + ((getOutImgUrl() == null) ? 0 : getOutImgUrl().hashCode());
        result = prime * result + ((getOutMemo() == null) ? 0 : getOutMemo().hashCode());
        result = prime * result + ((getEnterMode() == null) ? 0 : getEnterMode().hashCode());
        result = prime * result + ((getPayedMoney() == null) ? 0 : getPayedMoney().hashCode());
        result = prime * result + ((getLastPayedTime() == null) ? 0 : getLastPayedTime().hashCode());
        result = prime * result + ((getCarType() == null) ? 0 : getCarType().hashCode());
        result = prime * result + ((getCarStatus() == null) ? 0 : getCarStatus().hashCode());
        result = prime * result + ((getForceOperator() == null) ? 0 : getForceOperator().hashCode());
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
        sb.append(", packageId=").append(packageId);
        sb.append(", carMode=").append(carMode);
        sb.append(", inChannelId=").append(inChannelId);
        sb.append(", inCameraCode=").append(inCameraCode);
        sb.append(", inSluiceCode=").append(inSluiceCode);
        sb.append(", inImgUrl=").append(inImgUrl);
        sb.append(", inMemo=").append(inMemo);
        sb.append(", outCarNum=").append(outCarNum);
        sb.append(", outChannelId=").append(outChannelId);
        sb.append(", outCameraCode=").append(outCameraCode);
        sb.append(", outSluiceCode=").append(outSluiceCode);
        sb.append(", outImgUrl=").append(outImgUrl);
        sb.append(", outMemo=").append(outMemo);
        sb.append(", enterMode=").append(enterMode);
        sb.append(", payedMoney=").append(payedMoney);
        sb.append(", lastPayedTime=").append(lastPayedTime);
        sb.append(", carType=").append(carType);
        sb.append(", carStatus=").append(carStatus);
        sb.append(", forceOperator=").append(forceOperator);
        sb.append(", courtUuid=").append(courtUuid);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateUser=").append(updateUser);
        sb.append("]");
        return sb.toString();
    }
}