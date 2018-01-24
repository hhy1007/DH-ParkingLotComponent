/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.extmapper.park.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkFeeRule;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkPackageParkRel;

/**
 * 停车场基本信息(自定义)
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public class ParkingLot {

    private String parkName;// 停车场名称

    private String id;

    private Integer total;// 总车位

    private String parkCode;// 停车场编号

    private Integer idle;// 余位数

    private String feeRuleId;// 默认临停车收费规则

    private String parentCode;// 父场区编号

    private String configInfo;// 其它配置信息

    private String parkRuleId;// 默认进出放行规则规则

    private BigDecimal longitude;// 位置坐标：经度

    private String address;// 停车场地址信息

    private String picPath;// 停车场图片

    private String phoneNumber;// 联系电话

    private BigDecimal latitude;// 位置坐标：纬度

    private String createUser;// 创建人ID

    private String memo;// 备注

    private Date createTime;// 创建时间

    private String updateUser;// 更新人ID

    private ParkFeeRule parkFeeRule;// 收费规则信息

    private Short deleteFlag;// 删除标记：0-正常,1-删除

    private Date updateTime;// 更新时间

    private String courtUuid;// 小区id

    public String getCourtUuid() {
        return courtUuid;
    }

    public Short getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Short deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public void setParkFeeRule(ParkFeeRule parkFeeRule) {
        this.parkFeeRule = parkFeeRule;
    }

    public void setCourtUuid(String courtUuid) {
        this.courtUuid = courtUuid;
    }

    public ParkFeeRule getParkFeeRule() {
        return parkFeeRule;
    }

    private List<ParkPackageParkRel> parkPackageParkRel = new ArrayList<>();

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getParkCode() {
        return parkCode;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkCode(String parkCode) {
        this.parkCode = parkCode;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotal() {
        return total;
    }

    public void setIdle(Integer idle) {
        this.idle = idle;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public Integer getIdle() {
        return idle;
    }

    public void setFeeRuleId(String feeRuleId) {
        this.feeRuleId = feeRuleId;
    }

    public void setParkRuleId(String parkRuleId) {
        this.parkRuleId = parkRuleId;
    }

    public String getParentCode() {
        return parentCode;
    }

    public String getFeeRuleId() {
        return feeRuleId;
    }

    public String getParkRuleId() {
        return parkRuleId;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getConfigInfo() {
        return configInfo;
    }

    public void setConfigInfo(String configInfo) {
        this.configInfo = configInfo;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMemo() {
        return memo;
    }

    public String getCreateUser() {
        return createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public List<ParkPackageParkRel> getParkPackageParkRel() {
        return parkPackageParkRel;
    }

    public void setParkPackageParkRel(List<ParkPackageParkRel> parkPackageParkRel) {
        this.parkPackageParkRel = parkPackageParkRel;
    }


}
