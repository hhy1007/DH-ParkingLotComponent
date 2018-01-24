package com.eg.egsc.scp.parkinglotcomponent.mapper.entity;

import java.util.Date;

public class ParkParkedCur {
    private String uuid;

    private String deviceCode;

    private String deviceName;

    private String mapId;

    private String carportCode;

    private String carNum;

    private String carNumColor;

    private String carColor;

    private String carMark;

    private String ownerId;

    private Date parkStart;

    private Date parkDate;

    private Short parkType;

    private Short alarmStatus;

    private Short alarmArrear;

    private Short alarmAbnormal;

    private String imgUrl;

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

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getMapId() {
        return mapId;
    }

    public void setMapId(String mapId) {
        this.mapId = mapId;
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

    public String getCarNumColor() {
        return carNumColor;
    }

    public void setCarNumColor(String carNumColor) {
        this.carNumColor = carNumColor;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarMark() {
        return carMark;
    }

    public void setCarMark(String carMark) {
        this.carMark = carMark;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Date getParkStart() {
        return parkStart;
    }

    public void setParkStart(Date parkStart) {
        this.parkStart = parkStart;
    }

    public Date getParkDate() {
        return parkDate;
    }

    public void setParkDate(Date parkDate) {
        this.parkDate = parkDate;
    }

    public Short getParkType() {
        return parkType;
    }

    public void setParkType(Short parkType) {
        this.parkType = parkType;
    }

    public Short getAlarmStatus() {
        return alarmStatus;
    }

    public void setAlarmStatus(Short alarmStatus) {
        this.alarmStatus = alarmStatus;
    }

    public Short getAlarmArrear() {
        return alarmArrear;
    }

    public void setAlarmArrear(Short alarmArrear) {
        this.alarmArrear = alarmArrear;
    }

    public Short getAlarmAbnormal() {
        return alarmAbnormal;
    }

    public void setAlarmAbnormal(Short alarmAbnormal) {
        this.alarmAbnormal = alarmAbnormal;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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
        ParkParkedCur other = (ParkParkedCur) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getDeviceCode() == null ? other.getDeviceCode() == null : this.getDeviceCode().equals(other.getDeviceCode()))
            && (this.getDeviceName() == null ? other.getDeviceName() == null : this.getDeviceName().equals(other.getDeviceName()))
            && (this.getMapId() == null ? other.getMapId() == null : this.getMapId().equals(other.getMapId()))
            && (this.getCarportCode() == null ? other.getCarportCode() == null : this.getCarportCode().equals(other.getCarportCode()))
            && (this.getCarNum() == null ? other.getCarNum() == null : this.getCarNum().equals(other.getCarNum()))
            && (this.getCarNumColor() == null ? other.getCarNumColor() == null : this.getCarNumColor().equals(other.getCarNumColor()))
            && (this.getCarColor() == null ? other.getCarColor() == null : this.getCarColor().equals(other.getCarColor()))
            && (this.getCarMark() == null ? other.getCarMark() == null : this.getCarMark().equals(other.getCarMark()))
            && (this.getOwnerId() == null ? other.getOwnerId() == null : this.getOwnerId().equals(other.getOwnerId()))
            && (this.getParkStart() == null ? other.getParkStart() == null : this.getParkStart().equals(other.getParkStart()))
            && (this.getParkDate() == null ? other.getParkDate() == null : this.getParkDate().equals(other.getParkDate()))
            && (this.getParkType() == null ? other.getParkType() == null : this.getParkType().equals(other.getParkType()))
            && (this.getAlarmStatus() == null ? other.getAlarmStatus() == null : this.getAlarmStatus().equals(other.getAlarmStatus()))
            && (this.getAlarmArrear() == null ? other.getAlarmArrear() == null : this.getAlarmArrear().equals(other.getAlarmArrear()))
            && (this.getAlarmAbnormal() == null ? other.getAlarmAbnormal() == null : this.getAlarmAbnormal().equals(other.getAlarmAbnormal()))
            && (this.getImgUrl() == null ? other.getImgUrl() == null : this.getImgUrl().equals(other.getImgUrl()))
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
        result = prime * result + ((getDeviceCode() == null) ? 0 : getDeviceCode().hashCode());
        result = prime * result + ((getDeviceName() == null) ? 0 : getDeviceName().hashCode());
        result = prime * result + ((getMapId() == null) ? 0 : getMapId().hashCode());
        result = prime * result + ((getCarportCode() == null) ? 0 : getCarportCode().hashCode());
        result = prime * result + ((getCarNum() == null) ? 0 : getCarNum().hashCode());
        result = prime * result + ((getCarNumColor() == null) ? 0 : getCarNumColor().hashCode());
        result = prime * result + ((getCarColor() == null) ? 0 : getCarColor().hashCode());
        result = prime * result + ((getCarMark() == null) ? 0 : getCarMark().hashCode());
        result = prime * result + ((getOwnerId() == null) ? 0 : getOwnerId().hashCode());
        result = prime * result + ((getParkStart() == null) ? 0 : getParkStart().hashCode());
        result = prime * result + ((getParkDate() == null) ? 0 : getParkDate().hashCode());
        result = prime * result + ((getParkType() == null) ? 0 : getParkType().hashCode());
        result = prime * result + ((getAlarmStatus() == null) ? 0 : getAlarmStatus().hashCode());
        result = prime * result + ((getAlarmArrear() == null) ? 0 : getAlarmArrear().hashCode());
        result = prime * result + ((getAlarmAbnormal() == null) ? 0 : getAlarmAbnormal().hashCode());
        result = prime * result + ((getImgUrl() == null) ? 0 : getImgUrl().hashCode());
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
        sb.append(", deviceCode=").append(deviceCode);
        sb.append(", deviceName=").append(deviceName);
        sb.append(", mapId=").append(mapId);
        sb.append(", carportCode=").append(carportCode);
        sb.append(", carNum=").append(carNum);
        sb.append(", carNumColor=").append(carNumColor);
        sb.append(", carColor=").append(carColor);
        sb.append(", carMark=").append(carMark);
        sb.append(", ownerId=").append(ownerId);
        sb.append(", parkStart=").append(parkStart);
        sb.append(", parkDate=").append(parkDate);
        sb.append(", parkType=").append(parkType);
        sb.append(", alarmStatus=").append(alarmStatus);
        sb.append(", alarmArrear=").append(alarmArrear);
        sb.append(", alarmAbnormal=").append(alarmAbnormal);
        sb.append(", imgUrl=").append(imgUrl);
        sb.append(", courtUuid=").append(courtUuid);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateUser=").append(updateUser);
        sb.append("]");
        return sb.toString();
    }
}