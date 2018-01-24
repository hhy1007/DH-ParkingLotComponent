package com.eg.egsc.scp.parkinglotcomponent.mapper.entity;

import java.util.Date;

public class ParkAlarmOccupy {
    private String uuid;

    private String carportCode;

    private String carNumFixed;

    private String carNumCur;

    private String ownerId;

    private String ownerName;

    private String ownerPhone;

    private Short dispatchState;

    private String dispatchUser;

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

    public String getCarNumFixed() {
        return carNumFixed;
    }

    public void setCarNumFixed(String carNumFixed) {
        this.carNumFixed = carNumFixed;
    }

    public String getCarNumCur() {
        return carNumCur;
    }

    public void setCarNumCur(String carNumCur) {
        this.carNumCur = carNumCur;
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

    public Short getDispatchState() {
        return dispatchState;
    }

    public void setDispatchState(Short dispatchState) {
        this.dispatchState = dispatchState;
    }

    public String getDispatchUser() {
        return dispatchUser;
    }

    public void setDispatchUser(String dispatchUser) {
        this.dispatchUser = dispatchUser;
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
        ParkAlarmOccupy other = (ParkAlarmOccupy) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getCarportCode() == null ? other.getCarportCode() == null : this.getCarportCode().equals(other.getCarportCode()))
            && (this.getCarNumFixed() == null ? other.getCarNumFixed() == null : this.getCarNumFixed().equals(other.getCarNumFixed()))
            && (this.getCarNumCur() == null ? other.getCarNumCur() == null : this.getCarNumCur().equals(other.getCarNumCur()))
            && (this.getOwnerId() == null ? other.getOwnerId() == null : this.getOwnerId().equals(other.getOwnerId()))
            && (this.getOwnerName() == null ? other.getOwnerName() == null : this.getOwnerName().equals(other.getOwnerName()))
            && (this.getOwnerPhone() == null ? other.getOwnerPhone() == null : this.getOwnerPhone().equals(other.getOwnerPhone()))
            && (this.getDispatchState() == null ? other.getDispatchState() == null : this.getDispatchState().equals(other.getDispatchState()))
            && (this.getDispatchUser() == null ? other.getDispatchUser() == null : this.getDispatchUser().equals(other.getDispatchUser()))
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
        result = prime * result + ((getCarNumFixed() == null) ? 0 : getCarNumFixed().hashCode());
        result = prime * result + ((getCarNumCur() == null) ? 0 : getCarNumCur().hashCode());
        result = prime * result + ((getOwnerId() == null) ? 0 : getOwnerId().hashCode());
        result = prime * result + ((getOwnerName() == null) ? 0 : getOwnerName().hashCode());
        result = prime * result + ((getOwnerPhone() == null) ? 0 : getOwnerPhone().hashCode());
        result = prime * result + ((getDispatchState() == null) ? 0 : getDispatchState().hashCode());
        result = prime * result + ((getDispatchUser() == null) ? 0 : getDispatchUser().hashCode());
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
        sb.append(", carNumFixed=").append(carNumFixed);
        sb.append(", carNumCur=").append(carNumCur);
        sb.append(", ownerId=").append(ownerId);
        sb.append(", ownerName=").append(ownerName);
        sb.append(", ownerPhone=").append(ownerPhone);
        sb.append(", dispatchState=").append(dispatchState);
        sb.append(", dispatchUser=").append(dispatchUser);
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