/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.condition.park;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageCondition;

/**
 * 停车场信息查询过滤条件
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public class ParkingLotCondition extends PageCondition {
    
    private String parkCode;// 停车场编号

    private String parentCode;//父场区编号
    
    private String id;

    private String parkName;// 停车场名称
    
    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParkName() {
        return parkName;
    }

    public String getParkCode() {
        return parkCode;
    }

    public void setParkCode(String parkCode) {
        this.parkCode = parkCode;
    }

    public String getId() {
        return id;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }
}
