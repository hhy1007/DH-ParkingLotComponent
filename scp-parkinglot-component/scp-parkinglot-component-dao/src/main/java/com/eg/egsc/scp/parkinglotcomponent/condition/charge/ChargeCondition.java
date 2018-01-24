/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.condition.charge;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageCondition;

/**
 * 充值记录查询过滤条件
 * 
 * @author huangyuhong
 * @since 2018年1月12日
 */
public class ChargeCondition extends PageCondition {
    
    private String parkCode;
    
    private String carNum;
    
    private String packageId;

    public String getParkCode() {
        return parkCode;
    }

    public void setParkCode(String parkCode) {
        this.parkCode = parkCode;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }
    
    
}
