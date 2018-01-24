/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.vo.authpackage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseConvert;
import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseVo;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.authpackage.entity.AuthPackage;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkPackageCarRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkPackageParkRel;

/**
 * @Class Name ParkPackageVo
 * @Author huangyuhong
 * @Create In 2017年12月20日
 */
public class ParkAuthPackageVo implements BaseVo<AuthPackage> {

    private String id;

    private String ownerId;

    private String carportCode;

    private Date validStartTime;

    private String parkRuleId;

    private Date validEndTime;

    private String memo;

    private Date createTime;

    private Short carportType;

    private String updateUser;

    private Date updateTime;

    private List<ParkPackageCarRel> parkPackageCarRel;

    private List<ParkPackageParkRel> parkPackageParkRel;

    private String createUser;


    public ParkAuthPackageVo() {
        super();
        parkPackageCarRel = new ArrayList<>();
        parkPackageParkRel = new ArrayList<>();
    }

    @Override
    public void convertPOToVO(AuthPackage poObj) {
        if (poObj != null) {
            BaseConvert.convertPOToVO(poObj, this);
        }
    }

    @Override
    public AuthPackage convertVOToPO() {
        AuthPackage pPackage = new AuthPackage();
        BaseConvert.convertVOToPO(this, pPackage);
        return pPackage;
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

    public Date getValidStartTime() {
        return validStartTime;
    }

    public void setValidStartTime(Date validStartTime) {
        this.validStartTime = validStartTime;
    }

    public String getCarportCode() {
        return carportCode;
    }

    public void setCarportCode(String carportCode) {
        this.carportCode = carportCode;
    }

    public String getParkRuleId() {
        return parkRuleId;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Short getCarportType() {
        return carportType;
    }

    public void setCarportType(Short carportType) {
        this.carportType = carportType;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public void setParkRuleId(String parkRuleId) {
        this.parkRuleId = parkRuleId;
    }

    public Date getValidEndTime() {
        return validEndTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setParkPackageCarRel(List<ParkPackageCarRel> parkPackageCarRel) {
        this.parkPackageCarRel = parkPackageCarRel;
    }

    public List<ParkPackageParkRel> getParkPackageParkRel() {
        return parkPackageParkRel;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<ParkPackageCarRel> getParkPackageCarRel() {
        return parkPackageCarRel;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public void setParkPackageParkRel(List<ParkPackageParkRel> parkPackageParkRel) {
        this.parkPackageParkRel = parkPackageParkRel;
    }

}
