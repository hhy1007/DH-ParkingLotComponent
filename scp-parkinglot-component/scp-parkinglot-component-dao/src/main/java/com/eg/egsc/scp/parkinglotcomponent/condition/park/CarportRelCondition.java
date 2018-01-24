/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.condition.park;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageCondition;

/**
 * 诱导屏绑定车位信息查询过滤条件
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public class CarportRelCondition extends PageCondition {
    
    private String ledCode;// LED设备编号
    
    private Short deleteFlag;
    
    private String id;

    private String carportId;// 车位编号

    
    public Short getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Short deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }

    public String getCarportId() {
        return carportId;
    }

    public void setLedCode(String ledCode) {
        this.ledCode = ledCode;
    }

    public void setCarportId(String carportId) {
        this.carportId = carportId;
    }

    public String getLedCode() {
        return ledCode;
    }
}
