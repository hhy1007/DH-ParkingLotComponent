/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.condition.reservation;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageCondition;

/**
 * 预约查询过滤条件
 * 
 * @author huangyuhong
 * @since 2018年1月12日
 */
public class ParkReservationCondition extends PageCondition {
    
    private String id;

    private String carNum;// 车牌号码

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }
    
}
