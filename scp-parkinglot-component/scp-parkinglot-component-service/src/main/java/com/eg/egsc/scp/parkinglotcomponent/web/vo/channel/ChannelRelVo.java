/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.vo.channel;

import java.util.Date;

import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseConvert;
import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseVo;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannelRel;

/**
 * 车场通道邦定基本信息VO类
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public class ChannelRelVo implements BaseVo<ParkChannelRel> {

    private String createUser;// 创建人ID

    private String uuid;

    private Short controlType;// 主辅类型：0-主，1-辅.屏幕类型：0-余位屏，1-通用屏幕主辅类型：0-主，1-辅.屏幕类型：0-余位屏，1-通用屏幕

    private String devCode;// 设备编号

    private Short devType;// 设备类型：0-道闸，1-出入口相机，2-led

    private String updateUser;// 更新人ID

    private Date createTime;// 创建时间

    private String channelId;// 通道ID

    private Date updateTime;// 更新时间

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelId() {
        return channelId;
    }

    public String getDevCode() {
        return devCode;
    }

    public Short getDevType() {
        return devType;
    }

    public void setDevCode(String devCode) {
        this.devCode = devCode;
    }

    public void setControlType(Short controlType) {
        this.controlType = controlType;
    }

    public void setDevType(Short devType) {
        this.devType = devType;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public Short getControlType() {
        return controlType;
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

    public String getCreateUser() {
        return createUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public void convertPOToVO(ParkChannelRel poObj) {
        if (poObj != null) {
            BaseConvert.convertPOToVO(poObj, this);
        }
    }

    @Override
    public ParkChannelRel convertVOToPO() {
        ParkChannelRel parkChannelRel = new ParkChannelRel();
        BaseConvert.convertVOToPO(this, parkChannelRel);
        return parkChannelRel;
    }
}
