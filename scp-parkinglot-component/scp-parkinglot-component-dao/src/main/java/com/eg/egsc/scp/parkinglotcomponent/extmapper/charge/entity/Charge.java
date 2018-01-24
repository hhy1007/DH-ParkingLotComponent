/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.extmapper.charge.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkPackageCarRel;

/**
 * 充值实体
 * 
 * @author huangyuhong
 * @since 2018年1月12日
 */
public class Charge {
    
    private String id;
    
    private String carportCode;
    
    private String ownerId;
    
    private List<ParkPackageCarRel> parkPackageCarRel;
    
    private Date createTime;
    
    private int money;
    
    private String memo;
    
    private short carportType;
    
    public Charge() {
        super();
        parkPackageCarRel = new ArrayList<>();
    }
    
    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ParkPackageCarRel> getParkPackageCarRel() {
        return parkPackageCarRel;
    }

    public void setParkPackageCarRel(List<ParkPackageCarRel> parkPackageCarRel) {
        this.parkPackageCarRel = parkPackageCarRel;
    }
    
    public String getCarportCode() {
        return carportCode;
    }

    public void setCarportCode(String carportCode) {
        this.carportCode = carportCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
    

    public short getCarportType() {
        return carportType;
    }

    public void setCarportType(short carportType) {
        this.carportType = carportType;
    }

}
