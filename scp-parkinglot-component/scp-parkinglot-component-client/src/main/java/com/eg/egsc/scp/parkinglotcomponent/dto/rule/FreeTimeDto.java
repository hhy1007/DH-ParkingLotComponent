/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.dto.rule;

import java.io.Serializable;

/**
 * 免费时间dto类
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public class FreeTimeDto implements Serializable{
    /**
     * @Field long serialVersionUID 
     */
    private static final long serialVersionUID = -7463731725174160641L;

    private Integer time;//免费时间
    
    private String isContain;//0：不包含，1：包含

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getIsContain() {
        return isContain;
    }

    public void setIsContain(String isContain) {
        this.isContain = isContain;
    }

}
