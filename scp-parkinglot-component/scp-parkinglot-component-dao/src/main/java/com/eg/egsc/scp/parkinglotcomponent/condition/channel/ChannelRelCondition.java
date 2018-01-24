/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.condition.channel;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageCondition;

/**
 * 车场通道邦定信息查询过滤条件
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public class ChannelRelCondition extends PageCondition {

    private String id;

    private String channelId;
    
    private String devCode;// 设备编号
    
    private Short devType;//设备类型0 -道闸1-相机  2-led

    public String getId() {
        return id;
    }

    public Short getDevType() {
        return devType;
    }

    public String getChannelId() {
        return channelId;
    }

    public String getDevCode() {
        return devCode;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
    public void setDevCode(String devCode) {
        this.devCode = devCode;
    }

    
    public void setDevType(Short devType) {
        this.devType = devType;
    }
}
