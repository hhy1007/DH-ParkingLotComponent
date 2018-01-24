/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.extmapper.channel.entity;

import java.util.Date;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkingLot;

/**
 * 车场通道基本信息(自定义实体类)
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public class Channel {

    private String parkCode;// 停车场编号

    private String id;

    private Short type;// 通道类型

    private String name;// 车道名称

    private String ip;//

    private Short direct;// 车道方向

    private Date updateTime;// 更新时间

    private String createUser;// 创建人ID
    
    private String courtUuid;// 小区id

    private Date createTime;// 创建时间

    private ParkParkingLot parkParkingLot;

    private String updateUser;// 更新人ID

    private Short deleteFlag;// 删除标记：0-正常,1-删除

    public String getCourtUuid() {
        return courtUuid;
    }

    public Short getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Short deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public void setParkParkingLot(ParkParkingLot parkParkingLot) {
        this.parkParkingLot = parkParkingLot;
    }

    public void setCourtUuid(String courtUuid) {
        this.courtUuid = courtUuid;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public ParkParkingLot getParkParkingLot() {
        return parkParkingLot;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setParkCode(String parkCode) {
        this.parkCode = parkCode;
    }

    public String getParkCode() {
        return parkCode;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Short getType() {
        return type;
    }

    public void setDirect(Short direct) {
        this.direct = direct;
    }

    public Short getDirect() {
        return direct;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }


    public String getCreateUser() {
        return createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }


}
