package com.eg.egsc.scp.parkinglotcomponent.mapper.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ParkCarport {
    private String uuid;

    private String carportCode;

    private String carportShape;

    private Short carportAllocation;

    private String detectorCode;

    private String monitorCode;

    private Short monitorMode;

    private String monitorText;

    private String lockCode;

    private String mapId;

    private Short suitCarModel;

    private Short propertyRight;

    private BigDecimal carportCenterX;

    private BigDecimal carportCenterY;

    private BigDecimal carportCenterZ;

    private Short carportType;

    private Short enableFlag;

    private Short areaTotal;

    private Short areaIdle;

    private String parkId;

    private String memo;

    private Short deleteFlag;

    private String courtUuid;

    private Date createTime;

    private Date updateTime;

    private String createUser;

    private String updateUser;

    private String orgId;

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

    public String getCarportShape() {
        return carportShape;
    }

    public void setCarportShape(String carportShape) {
        this.carportShape = carportShape;
    }

    public Short getCarportAllocation() {
        return carportAllocation;
    }

    public void setCarportAllocation(Short carportAllocation) {
        this.carportAllocation = carportAllocation;
    }

    public String getDetectorCode() {
        return detectorCode;
    }

    public void setDetectorCode(String detectorCode) {
        this.detectorCode = detectorCode;
    }

    public String getMonitorCode() {
        return monitorCode;
    }

    public void setMonitorCode(String monitorCode) {
        this.monitorCode = monitorCode;
    }

    public Short getMonitorMode() {
        return monitorMode;
    }

    public void setMonitorMode(Short monitorMode) {
        this.monitorMode = monitorMode;
    }

    public String getMonitorText() {
        return monitorText;
    }

    public void setMonitorText(String monitorText) {
        this.monitorText = monitorText;
    }

    public String getLockCode() {
        return lockCode;
    }

    public void setLockCode(String lockCode) {
        this.lockCode = lockCode;
    }

    public String getMapId() {
        return mapId;
    }

    public void setMapId(String mapId) {
        this.mapId = mapId;
    }

    public Short getSuitCarModel() {
        return suitCarModel;
    }

    public void setSuitCarModel(Short suitCarModel) {
        this.suitCarModel = suitCarModel;
    }

    public Short getPropertyRight() {
        return propertyRight;
    }

    public void setPropertyRight(Short propertyRight) {
        this.propertyRight = propertyRight;
    }

    public BigDecimal getCarportCenterX() {
        return carportCenterX;
    }

    public void setCarportCenterX(BigDecimal carportCenterX) {
        this.carportCenterX = carportCenterX;
    }

    public BigDecimal getCarportCenterY() {
        return carportCenterY;
    }

    public void setCarportCenterY(BigDecimal carportCenterY) {
        this.carportCenterY = carportCenterY;
    }

    public BigDecimal getCarportCenterZ() {
        return carportCenterZ;
    }

    public void setCarportCenterZ(BigDecimal carportCenterZ) {
        this.carportCenterZ = carportCenterZ;
    }

    public Short getCarportType() {
        return carportType;
    }

    public void setCarportType(Short carportType) {
        this.carportType = carportType;
    }

    public Short getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(Short enableFlag) {
        this.enableFlag = enableFlag;
    }

    public Short getAreaTotal() {
        return areaTotal;
    }

    public void setAreaTotal(Short areaTotal) {
        this.areaTotal = areaTotal;
    }

    public Short getAreaIdle() {
        return areaIdle;
    }

    public void setAreaIdle(Short areaIdle) {
        this.areaIdle = areaIdle;
    }

    public String getParkId() {
        return parkId;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Short getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Short deleteFlag) {
        this.deleteFlag = deleteFlag;
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

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
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
        ParkCarport other = (ParkCarport) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getCarportCode() == null ? other.getCarportCode() == null : this.getCarportCode().equals(other.getCarportCode()))
            && (this.getCarportShape() == null ? other.getCarportShape() == null : this.getCarportShape().equals(other.getCarportShape()))
            && (this.getCarportAllocation() == null ? other.getCarportAllocation() == null : this.getCarportAllocation().equals(other.getCarportAllocation()))
            && (this.getDetectorCode() == null ? other.getDetectorCode() == null : this.getDetectorCode().equals(other.getDetectorCode()))
            && (this.getMonitorCode() == null ? other.getMonitorCode() == null : this.getMonitorCode().equals(other.getMonitorCode()))
            && (this.getMonitorMode() == null ? other.getMonitorMode() == null : this.getMonitorMode().equals(other.getMonitorMode()))
            && (this.getMonitorText() == null ? other.getMonitorText() == null : this.getMonitorText().equals(other.getMonitorText()))
            && (this.getLockCode() == null ? other.getLockCode() == null : this.getLockCode().equals(other.getLockCode()))
            && (this.getMapId() == null ? other.getMapId() == null : this.getMapId().equals(other.getMapId()))
            && (this.getSuitCarModel() == null ? other.getSuitCarModel() == null : this.getSuitCarModel().equals(other.getSuitCarModel()))
            && (this.getPropertyRight() == null ? other.getPropertyRight() == null : this.getPropertyRight().equals(other.getPropertyRight()))
            && (this.getCarportCenterX() == null ? other.getCarportCenterX() == null : this.getCarportCenterX().equals(other.getCarportCenterX()))
            && (this.getCarportCenterY() == null ? other.getCarportCenterY() == null : this.getCarportCenterY().equals(other.getCarportCenterY()))
            && (this.getCarportCenterZ() == null ? other.getCarportCenterZ() == null : this.getCarportCenterZ().equals(other.getCarportCenterZ()))
            && (this.getCarportType() == null ? other.getCarportType() == null : this.getCarportType().equals(other.getCarportType()))
            && (this.getEnableFlag() == null ? other.getEnableFlag() == null : this.getEnableFlag().equals(other.getEnableFlag()))
            && (this.getAreaTotal() == null ? other.getAreaTotal() == null : this.getAreaTotal().equals(other.getAreaTotal()))
            && (this.getAreaIdle() == null ? other.getAreaIdle() == null : this.getAreaIdle().equals(other.getAreaIdle()))
            && (this.getParkId() == null ? other.getParkId() == null : this.getParkId().equals(other.getParkId()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getDeleteFlag() == null ? other.getDeleteFlag() == null : this.getDeleteFlag().equals(other.getDeleteFlag()))
            && (this.getCourtUuid() == null ? other.getCourtUuid() == null : this.getCourtUuid().equals(other.getCourtUuid()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getCarportCode() == null) ? 0 : getCarportCode().hashCode());
        result = prime * result + ((getCarportShape() == null) ? 0 : getCarportShape().hashCode());
        result = prime * result + ((getCarportAllocation() == null) ? 0 : getCarportAllocation().hashCode());
        result = prime * result + ((getDetectorCode() == null) ? 0 : getDetectorCode().hashCode());
        result = prime * result + ((getMonitorCode() == null) ? 0 : getMonitorCode().hashCode());
        result = prime * result + ((getMonitorMode() == null) ? 0 : getMonitorMode().hashCode());
        result = prime * result + ((getMonitorText() == null) ? 0 : getMonitorText().hashCode());
        result = prime * result + ((getLockCode() == null) ? 0 : getLockCode().hashCode());
        result = prime * result + ((getMapId() == null) ? 0 : getMapId().hashCode());
        result = prime * result + ((getSuitCarModel() == null) ? 0 : getSuitCarModel().hashCode());
        result = prime * result + ((getPropertyRight() == null) ? 0 : getPropertyRight().hashCode());
        result = prime * result + ((getCarportCenterX() == null) ? 0 : getCarportCenterX().hashCode());
        result = prime * result + ((getCarportCenterY() == null) ? 0 : getCarportCenterY().hashCode());
        result = prime * result + ((getCarportCenterZ() == null) ? 0 : getCarportCenterZ().hashCode());
        result = prime * result + ((getCarportType() == null) ? 0 : getCarportType().hashCode());
        result = prime * result + ((getEnableFlag() == null) ? 0 : getEnableFlag().hashCode());
        result = prime * result + ((getAreaTotal() == null) ? 0 : getAreaTotal().hashCode());
        result = prime * result + ((getAreaIdle() == null) ? 0 : getAreaIdle().hashCode());
        result = prime * result + ((getParkId() == null) ? 0 : getParkId().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getDeleteFlag() == null) ? 0 : getDeleteFlag().hashCode());
        result = prime * result + ((getCourtUuid() == null) ? 0 : getCourtUuid().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
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
        sb.append(", carportShape=").append(carportShape);
        sb.append(", carportAllocation=").append(carportAllocation);
        sb.append(", detectorCode=").append(detectorCode);
        sb.append(", monitorCode=").append(monitorCode);
        sb.append(", monitorMode=").append(monitorMode);
        sb.append(", monitorText=").append(monitorText);
        sb.append(", lockCode=").append(lockCode);
        sb.append(", mapId=").append(mapId);
        sb.append(", suitCarModel=").append(suitCarModel);
        sb.append(", propertyRight=").append(propertyRight);
        sb.append(", carportCenterX=").append(carportCenterX);
        sb.append(", carportCenterY=").append(carportCenterY);
        sb.append(", carportCenterZ=").append(carportCenterZ);
        sb.append(", carportType=").append(carportType);
        sb.append(", enableFlag=").append(enableFlag);
        sb.append(", areaTotal=").append(areaTotal);
        sb.append(", areaIdle=").append(areaIdle);
        sb.append(", parkId=").append(parkId);
        sb.append(", memo=").append(memo);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", courtUuid=").append(courtUuid);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", orgId=").append(orgId);
        sb.append("]");
        return sb.toString();
    }
}