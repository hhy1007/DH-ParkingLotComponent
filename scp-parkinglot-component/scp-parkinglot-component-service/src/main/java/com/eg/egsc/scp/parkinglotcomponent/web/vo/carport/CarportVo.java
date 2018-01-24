/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.vo.carport;

import java.math.BigDecimal;
import java.util.Date;

import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseConvert;
import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseVo;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarport;

/**
 * 车位基本信息VO类
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public class CarportVo implements BaseVo<ParkCarport> {

    private String carportShape;// 车位形状

    private String uuid;

    private String detectorCode;// 车位探测器编号

    private String carportCode;// 车位编号

    private Short carportAllocation;// 是否分配: 0-未分配；1-已分配

    private String lockCode;// 车位锁编号

    private BigDecimal carportCenterZ;// 坐标Z

    private String monitorCode;// 车牌显示器编号
    
    private String monitorText;

    private BigDecimal carportCenterX;// 坐标X

    private Short areaIdle;// 区域空余车位数

    private String mapId;// 车位图层

    private Short suitCarModel;// 适用车型（0-小车位，1-大车位，2-超大车位）

    private Short propertyRight;// 车位产权（0-公共产权，1-个人产权）

    private BigDecimal carportCenterY;// 坐标Y

    private String memo;// 备注

    private Short carportType;// 1:普通车位,2:机械车位，3:停车区域

    private Short areaTotal;// 停车区域总车位数

    private Date updateTime;// 更新时间

    private String updateUser;// 更新人ID

    private String parkId;// 所属的停车场ID

    private Date createTime;// 创建时间

    private String createUser;// 创建人ID
    
    private Short monitorMode;

    public void setCarportCode(String carportCode) {
        this.carportCode = carportCode;
    }

    public String getUuid() {
      return uuid;
    }

    public void setCarportShape(String carportShape) {
        this.carportShape = carportShape;
    }

    public String getCarportCode() {
        return carportCode;
    }

    public String getCarportShape() {
        return carportShape;
    }

    public void setCarportAllocation(Short carportAllocation) {
        this.carportAllocation = carportAllocation;
    }

    public Short getCarportAllocation() {
        return carportAllocation;
    }

    public String getDetectorCode() {
        return detectorCode;
    }

    public void setMonitorCode(String monitorCode) {
        this.monitorCode = monitorCode;
    }
    
    public void setUuid(String uuid) {
      this.uuid = uuid;
    }

    public void setLockCode(String lockCode) {
        this.lockCode = lockCode;
    }

    public void setDetectorCode(String detectorCode) {
        this.detectorCode = detectorCode;
    }

    public String getMonitorCode() {
        return monitorCode;
    }

    public void setSuitCarModel(Short suitCarModel) {
        this.suitCarModel = suitCarModel;
    }

    public String getLockCode() {
        return lockCode;
    }

    public String getMapId() {
        return mapId;
    }

    public void setMapId(String mapId) {
        this.mapId = mapId;
    }

    public void setPropertyRight(Short propertyRight) {
        this.propertyRight = propertyRight;
    }

    public Short getSuitCarModel() {
        return suitCarModel;
    }

    public void setCarportCenterX(BigDecimal carportCenterX) {
        this.carportCenterX = carportCenterX;
    }

    public Short getPropertyRight() {
        return propertyRight;
    }

    public BigDecimal getCarportCenterX() {
        return carportCenterX;
    }

    public void setCarportCenterZ(BigDecimal carportCenterZ) {
        this.carportCenterZ = carportCenterZ;
    }

    public BigDecimal getCarportCenterY() {
        return carportCenterY;
    }

    public void setCarportType(Short carportType) {
        this.carportType = carportType;
    }


    public void setCarportCenterY(BigDecimal carportCenterY) {
        this.carportCenterY = carportCenterY;
    }

    public BigDecimal getCarportCenterZ() {
        return carportCenterZ;
    }

    public void setAreaTotal(Short areaTotal) {
        this.areaTotal = areaTotal;
    }

    public Short getCarportType() {
        return carportType;
    }

    public void setAreaIdle(Short areaIdle) {
        this.areaIdle = areaIdle;
    }

    public Short getAreaTotal() {
        return areaTotal;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId;
    }


    public Short getAreaIdle() {
        return areaIdle;
    }

    public String getParkId() {
        return parkId;
    }

    public String getMemo() {
        return memo;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateUser() {
        return createUser;
    }
    
    public void setMonitorText(String monitorText) {
        this.monitorText = monitorText;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
    
    public String getMonitorText() {
        return monitorText;
    }

    public Short getMonitorMode() {
        return monitorMode;
    }

    public void setMonitorMode(Short monitorMode) {
        this.monitorMode = monitorMode;
    }

    @Override
    public void convertPOToVO(ParkCarport poObj) {
        if (poObj != null) {
            BaseConvert.convertPOToVO(poObj, this);
        }
    }

    @Override
    public ParkCarport convertVOToPO() {
        ParkCarport parkCarport = new ParkCarport();
        BaseConvert.convertVOToPO(this, parkCarport);
        return parkCarport;
    }

}
