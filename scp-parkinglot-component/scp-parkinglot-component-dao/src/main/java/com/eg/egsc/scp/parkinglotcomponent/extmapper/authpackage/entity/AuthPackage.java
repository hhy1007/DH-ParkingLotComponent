/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.extmapper.authpackage.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkPackageCarRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkPackageParkRel;

/**
 * 授权套餐实体
 * 
 * @author huangyuhong
 * @since 2018年1月12日
 */
public class AuthPackage {
    
    private String id;

    private String carportCode;

    private String ownerId;

    private Date validStartTime;

    private String parkRuleId;

    private Short carportType;

    private Date validEndTime;

    private Date createTime;

    private String memo;
    
    private String cardNumber;

    private String createUser;

    private Date updateTime;

    private String state;
    
    private String updateUser;
    
    private List<ParkPackageCarRel> parkPackageCarRel;
    
    private Short deleteFlag;
    
    private List<ParkPackageParkRel> parkPackageParkRel;
    
    private String courtUuid;

    public AuthPackage() {
        super();
        parkPackageCarRel = new ArrayList<>();
        parkPackageParkRel = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarportCode() {
        return carportCode;
    }

    public void setCarportCode(String carportCode) {
        this.carportCode = carportCode;
    }
    
    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Date getValidStartTime() {
        return validStartTime;
    }

    public void setValidStartTime(Date validStartTime) {
        this.validStartTime = validStartTime;
    }
    
    public String getParkRuleId() {
        return parkRuleId;
    }

    public void setParkRuleId(String parkRuleId) {
        this.parkRuleId = parkRuleId;
    }

    public Date getValidEndTime() {
        return validEndTime;
    }

    public void setValidEndTime(Date validEndTime) {
        this.validEndTime = validEndTime;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
    
    public Short getCarportType() {
        return carportType;
    }

    public void setCarportType(Short carportType) {
        this.carportType = carportType;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }


    public Short getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Short deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    
    public String getCourtUuid() {
        return courtUuid;
    }

    public void setCourtUuid(String courtUuid) {
        this.courtUuid = courtUuid;
    }

    public List<ParkPackageCarRel> getParkPackageCarRel() {
        return parkPackageCarRel;
    }

    public void setParkPackageCarRel(List<ParkPackageCarRel> parkPackageCarRel) {
        this.parkPackageCarRel = parkPackageCarRel;
    }

    public List<ParkPackageParkRel> getParkPackageParkRel() {
        return parkPackageParkRel;
    }

    public void setParkPackageParkRel(List<ParkPackageParkRel> parkPackageParkRel) {
        this.parkPackageParkRel = parkPackageParkRel;
    }

}
