/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.charge.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 充值报表dto类
 * 
 * @author huangyuhong
 * @since 2018年1月12日
 */
public class ChargeDto {

    private String id;

    private String ownerId;// 车主id

    private String ownerName;// 车主名称

    private String carportCode;// 车位编号

    private List<String> carNumList;// 车牌号码

    private Integer chargeMoney;// 缴费金额

    private Date chargeTime;// 缴费时间

    private Short carportType;// 车位类型：月保、产权

    private String memo;// 备注
    
    

    public ChargeDto() {
        super();
        carNumList = new ArrayList<>();
    }



    public String getId() {
        return id;
    }



    public void setId(String id) {
        this.id = id;
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



    public String getCarportCode() {
        return carportCode;
    }



    public void setCarportCode(String carportCode) {
        this.carportCode = carportCode;
    }



    public List<String> getCarNumList() {
        return carNumList;
    }



    public void setCarNumList(List<String> carNumList) {
        this.carNumList = carNumList;
    }



    public Integer getChargeMoney() {
        return chargeMoney;
    }



    public void setChargeMoney(Integer chargeMoney) {
        this.chargeMoney = chargeMoney;
    }



    public Date getChargeTime() {
        return chargeTime;
    }



    public void setChargeTime(Date chargeTime) {
        this.chargeTime = chargeTime;
    }



    public Short getCarportType() {
        return carportType;
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



}
