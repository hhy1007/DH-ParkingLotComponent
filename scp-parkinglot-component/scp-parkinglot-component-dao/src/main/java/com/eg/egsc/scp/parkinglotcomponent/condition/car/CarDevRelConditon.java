/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.condition.car;

import java.util.ArrayList;
import java.util.List;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageCondition;


/**
 * 车辆下发过滤条件
 * 
 * @author huangyuhong
 * @since 2018年1月12日
 */
public class CarDevRelConditon extends PageCondition{

    private List<String> carNumList;
    
    private List<String> parkCodeList;
    
    public CarDevRelConditon() {
        super();
        carNumList = new ArrayList<>();
        parkCodeList = new ArrayList<>();
    }

    public List<String> getCarNumList() {
        return carNumList;
    }

    public void setCarNumList(List<String> carNumList) {
        this.carNumList = carNumList;
    }

    public List<String> getParkCodeList() {
        return parkCodeList;
    }

    public void setParkCodeList(List<String> parkCodeList) {
        this.parkCodeList = parkCodeList;
    }

}
