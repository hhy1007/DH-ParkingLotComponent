/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.condition.syscode;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageCondition;

/**
 * 字典表查询过滤条件
 * 
 * @author huangyuhong
 * @since 2018年1月12日
 */
public class ParkSysCodeCondition extends PageCondition {
    
    private String itemCode;// 项目编码

    private String itemName;// 项目名称

    private String parentCode;// 父编码

    private String typeCode;// 类型编码，关联数据字典主表

    private Short enableFlag;// 是否启用:0-禁用，1-启用,默认启用

    private String memo;// 描述

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public Short getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(Short enableFlag) {
        this.enableFlag = enableFlag;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

}
