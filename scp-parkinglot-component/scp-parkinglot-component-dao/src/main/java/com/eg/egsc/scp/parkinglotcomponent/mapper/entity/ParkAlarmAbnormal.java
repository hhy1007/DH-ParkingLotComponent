package com.eg.egsc.scp.parkinglotcomponent.mapper.entity;

import java.util.Date;

public class ParkAlarmAbnormal {
    private String uuid;

    private String carportcode;

    private String carNum;

    private Date inTime;

    private Integer feeAmount;

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

    public String getCarportcode() {
        return carportcode;
    }

    public void setCarportcode(String carportcode) {
        this.carportcode = carportcode;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Integer getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(Integer feeAmount) {
        this.feeAmount = feeAmount;
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
        ParkAlarmAbnormal other = (ParkAlarmAbnormal) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getCarportcode() == null ? other.getCarportcode() == null : this.getCarportcode().equals(other.getCarportcode()))
            && (this.getCarNum() == null ? other.getCarNum() == null : this.getCarNum().equals(other.getCarNum()))
            && (this.getInTime() == null ? other.getInTime() == null : this.getInTime().equals(other.getInTime()))
            && (this.getFeeAmount() == null ? other.getFeeAmount() == null : this.getFeeAmount().equals(other.getFeeAmount()))
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
        result = prime * result + ((getCarportcode() == null) ? 0 : getCarportcode().hashCode());
        result = prime * result + ((getCarNum() == null) ? 0 : getCarNum().hashCode());
        result = prime * result + ((getInTime() == null) ? 0 : getInTime().hashCode());
        result = prime * result + ((getFeeAmount() == null) ? 0 : getFeeAmount().hashCode());
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
        sb.append(", carportcode=").append(carportcode);
        sb.append(", carNum=").append(carNum);
        sb.append(", inTime=").append(inTime);
        sb.append(", feeAmount=").append(feeAmount);
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