/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.mq.message;

import com.alibaba.fastjson.JSON;
import com.eg.egsc.framework.client.dto.BaseBusinessDto;

/**
 * 设备状态变更消息
 * 
 * @author zhangli
 * @since 2018年1月15日
 */
public class DeviceStatusDto extends BaseBusinessDto {

    private static final long serialVersionUID = 6935626917336826743L;

    //设备编号 34020000001320000001
    private String deviceID;
    
    //父设备编号，如果没有为空
    private String parentID;
    
    //时间 2018-01-15 03:36:18.802
    private String dateTimeStr;
    
    //是否在线
    private Boolean online;
    
    //设备类型
    private String deviceType;

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getParentID() {
        return parentID;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }

    public String getDateTimeStr() {
        return dateTimeStr;
    }

    public void setDateTimeStr(String dateTimeStr) {
        this.dateTimeStr = dateTimeStr;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }
    
    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    /* (non-Javadoc)
     * @see com.eg.egsc.framework.client.dto.BaseBusinessDto#toString()
     */
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
