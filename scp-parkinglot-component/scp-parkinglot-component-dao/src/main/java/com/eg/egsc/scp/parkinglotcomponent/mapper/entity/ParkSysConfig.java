package com.eg.egsc.scp.parkinglotcomponent.mapper.entity;

import java.util.Date;

public class ParkSysConfig {
    private String configType;

    private String configName;

    private Short configSeq;

    private String configPar1;

    private String configPar2;

    private String configPar3;

    private Short enableFlag;

    private Date createTime;

    private Date updateTime;

    private String createUser;

    private String updateUser;

    public String getConfigType() {
        return configType;
    }

    public void setConfigType(String configType) {
        this.configType = configType;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public Short getConfigSeq() {
        return configSeq;
    }

    public void setConfigSeq(Short configSeq) {
        this.configSeq = configSeq;
    }

    public String getConfigPar1() {
        return configPar1;
    }

    public void setConfigPar1(String configPar1) {
        this.configPar1 = configPar1;
    }

    public String getConfigPar2() {
        return configPar2;
    }

    public void setConfigPar2(String configPar2) {
        this.configPar2 = configPar2;
    }

    public String getConfigPar3() {
        return configPar3;
    }

    public void setConfigPar3(String configPar3) {
        this.configPar3 = configPar3;
    }

    public Short getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(Short enableFlag) {
        this.enableFlag = enableFlag;
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
        ParkSysConfig other = (ParkSysConfig) that;
        return (this.getConfigType() == null ? other.getConfigType() == null : this.getConfigType().equals(other.getConfigType()))
            && (this.getConfigName() == null ? other.getConfigName() == null : this.getConfigName().equals(other.getConfigName()))
            && (this.getConfigSeq() == null ? other.getConfigSeq() == null : this.getConfigSeq().equals(other.getConfigSeq()))
            && (this.getConfigPar1() == null ? other.getConfigPar1() == null : this.getConfigPar1().equals(other.getConfigPar1()))
            && (this.getConfigPar2() == null ? other.getConfigPar2() == null : this.getConfigPar2().equals(other.getConfigPar2()))
            && (this.getConfigPar3() == null ? other.getConfigPar3() == null : this.getConfigPar3().equals(other.getConfigPar3()))
            && (this.getEnableFlag() == null ? other.getEnableFlag() == null : this.getEnableFlag().equals(other.getEnableFlag()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getConfigType() == null) ? 0 : getConfigType().hashCode());
        result = prime * result + ((getConfigName() == null) ? 0 : getConfigName().hashCode());
        result = prime * result + ((getConfigSeq() == null) ? 0 : getConfigSeq().hashCode());
        result = prime * result + ((getConfigPar1() == null) ? 0 : getConfigPar1().hashCode());
        result = prime * result + ((getConfigPar2() == null) ? 0 : getConfigPar2().hashCode());
        result = prime * result + ((getConfigPar3() == null) ? 0 : getConfigPar3().hashCode());
        result = prime * result + ((getEnableFlag() == null) ? 0 : getEnableFlag().hashCode());
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
        sb.append(", configType=").append(configType);
        sb.append(", configName=").append(configName);
        sb.append(", configSeq=").append(configSeq);
        sb.append(", configPar1=").append(configPar1);
        sb.append(", configPar2=").append(configPar2);
        sb.append(", configPar3=").append(configPar3);
        sb.append(", enableFlag=").append(enableFlag);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateUser=").append(updateUser);
        sb.append("]");
        return sb.toString();
    }
}