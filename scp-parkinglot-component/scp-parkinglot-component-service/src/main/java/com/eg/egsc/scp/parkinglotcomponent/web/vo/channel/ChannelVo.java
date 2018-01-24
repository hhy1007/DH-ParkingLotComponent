/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.vo.channel;

import java.util.Date;

import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseConvert;
import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseVo;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannel;

/**
 * 车场通道基本信息VO类
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public class ChannelVo implements BaseVo<ParkChannel> {

    private String uuid;

    private String name;// 车道名称

    private String updateUser;// 更新人ID

    private String parkCode;// 停车场编号

    private Date createTime;// 创建时间

    private Short type;// 通道类型

    private Short direct;// 车道方向

    private String ip;//

    private Date updateTime;// 更新时间

    private String createUser;// 创建人ID

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getParkCode() {
        return parkCode;
    }

    public String getIp() {
        return ip;
    }


    public void setParkCode(String parkCode) {
        this.parkCode = parkCode;
    }

    public Short getType() {
        return type;
    }

    public Short getDirect() {
        return direct;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setDirect(Short direct) {
        this.direct = direct;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateUser() {
        return createUser;
    }
    
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Override
    public void convertPOToVO(ParkChannel poObj) {
        if (poObj != null) {
            BaseConvert.convertPOToVO(poObj, this);
        }
    }

    @Override
    public ParkChannel convertVOToPO() {
        ParkChannel parkChannel = new ParkChannel();
        BaseConvert.convertVOToPO(this, parkChannel);
        return parkChannel;
    }


}
