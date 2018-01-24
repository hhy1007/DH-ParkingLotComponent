/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.vo.park;

import java.math.BigDecimal;
import java.util.Date;

import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseConvert;
import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseVo;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkingLot;

/**
 * 停车场基本信息VO类
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public class ParkParkingLotVo implements BaseVo<ParkParkingLot> {
    private String uuid;

    private String parkName;// 停车场名称

    private Integer total;// 总车位

    private BigDecimal longitude;// 位置坐标：经度

    private String parkCode;// 停车场编号

    private String feeRuleId;// 默认临停车收费规则

    private Integer idle;// 余位数

    private String address;// 停车场地址信息

    private String parentCode;// 父场区编号

    private String configInfo;// 其它配置信息

    private String parkRuleId;// 默认进出放行规则规则

    private String phoneNumber;// 联系电话

    private Date updateTime;// 更新时间

    private String memo;// 备注

    private String updateUser;// 更新人ID

    private Date createTime;// 创建时间

    private String picPath;// 停车场图片

    private BigDecimal latitude;// 位置坐标：纬度

    private String createUser;// 创建人ID

    public void setParkCode(String parkCode) {
        this.parkCode = parkCode;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getParkName() {
        return parkName;
    }

    public Integer getIdle() {
        return idle;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getParkCode() {
        return parkCode;
    }

    public Integer getTotal() {
        return total;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public void setFeeRuleId(String feeRuleId) {
        this.feeRuleId = feeRuleId;
    }

    public void setIdle(Integer idle) {
        this.idle = idle;
    }

    public String getParentCode() {
        return parentCode;
    }

    public String getParkRuleId() {
        return parkRuleId;
    }

    public String getFeeRuleId() {
        return feeRuleId;
    }

    public String getPicPath() {
        return picPath;
    }

    public String getConfigInfo() {
        return configInfo;
    }

    public void setParkRuleId(String parkRuleId) {
        this.parkRuleId = parkRuleId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setConfigInfo(String configInfo) {
        this.configInfo = configInfo;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMemo() {
        return memo;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public void convertPOToVO(ParkParkingLot poObj) {
        if (poObj != null) {
            BaseConvert.convertPOToVO(poObj, this);
        }
    }

    @Override
    public ParkParkingLot convertVOToPO() {
        ParkParkingLot parkParkingLot = new ParkParkingLot();
        BaseConvert.convertVOToPO(this, parkParkingLot);
        return parkParkingLot;
    }

}
