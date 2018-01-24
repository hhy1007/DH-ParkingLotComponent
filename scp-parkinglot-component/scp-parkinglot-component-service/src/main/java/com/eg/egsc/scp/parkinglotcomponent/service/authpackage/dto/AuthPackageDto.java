/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.authpackage.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkPackageCarRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkPackageParkRel;

/**
 * 套餐报表Dto类
 * 
 * @author huangyuhong
 * @since 2018年1月12日
 */
public class AuthPackageDto {

    private String id;

    private String ownerId;

    private String carportCode;

    private Date validStartTime;

    private String parkRuleId;

    private Short carportType;
    
    private String cardNumber;

    private Date validEndTime;

    private Date createTime;

    private String memo;

    private String createUser;

    private Date updateTime;

    private Integer money;

    private String updateUser;

    private String ownerName;

    private List<ParkPackageParkRel> parkPackageParkRel;

    private List<ParkPackageCarRel> parkPackageCarRel;

    public AuthPackageDto() {
        super();
        parkPackageCarRel = new ArrayList<>();
        parkPackageParkRel = new ArrayList<>();
    }


    public void setId(String id) {
        this.id = id;
    }



    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getId() {
        return id;
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

    public String getParkRuleId() {
        return parkRuleId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setValidStartTime(Date validStartTime) {
        this.validStartTime = validStartTime;
    }

    public Date getValidEndTime() {
        return validEndTime;
    }

    public void setParkRuleId(String parkRuleId) {
        this.parkRuleId = parkRuleId;
    }

    public Date getValidStartTime() {
        return validStartTime;
    }



    public void setCarportType(Short carportType) {
        this.carportType = carportType;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public void setValidEndTime(Date validEndTime) {
        this.validEndTime = validEndTime;
    }

    public Short getCarportType() {
        return carportType;
    }

    public Date getCreateTime() {
        return createTime;
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

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }


    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
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

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }


}
