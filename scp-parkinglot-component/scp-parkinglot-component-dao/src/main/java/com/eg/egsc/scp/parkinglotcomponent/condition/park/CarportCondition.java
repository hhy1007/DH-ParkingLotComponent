/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.condition.park;

import java.util.ArrayList;
import java.util.List;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageCondition;

/**
 * 车位信息查询过滤条件
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public class CarportCondition extends PageCondition {
    private String id;

    private String carportCode;// 车位编号

    List<String> parkIds = new ArrayList<>();

    public List<String> getParkIds() {
        return parkIds;
    }

    public String getId() {
        return id;
    }
    
    public void setParkIds(List<String> parkIds) {
        this.parkIds = parkIds;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCarportCode(String carportCode) {
        this.carportCode = carportCode;
    }
    
    public String getCarportCode() {
        return carportCode;
    }

}
