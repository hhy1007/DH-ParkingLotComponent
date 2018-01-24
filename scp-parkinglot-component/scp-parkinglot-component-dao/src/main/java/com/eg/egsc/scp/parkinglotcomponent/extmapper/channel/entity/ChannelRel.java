/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.extmapper.channel.entity;

import java.util.ArrayList;
import java.util.List;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannelRel;

/**
 * 查询通道设备绑定信息
 * 
 * @author huangyuhong
 * @since 2018年1月12日
 */
public class ChannelRel {
    
    private List<ParkChannelRel> parkChannelRelList;
    
    private String parkCode;

    public ChannelRel() {
        super();
        parkChannelRelList = new ArrayList<>();
    }

    public void setParkCode(String parkCode) {
        this.parkCode = parkCode;
    }
    
    public String getParkCode() {
        return parkCode;
    }

    public void setParkChannelRelList(List<ParkChannelRel> parkChannelRelList) {
        this.parkChannelRelList = parkChannelRelList;
    }
    
    public List<ParkChannelRel> getParkChannelRelList() {
        return parkChannelRelList;
    }

    
}
