/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.integration.dto;

/**
 * @Class Name IdleChangeDto
 * @Author zhangli
 * @Create In 2017年12月17日
 */
public class IdleChangeDto {

    private String parkCode;
    
    private int total;

    private int idle;
    
    private int curChange;

    public String getParkCode() {
        return parkCode;
    }

    public void setParkCode(String parkCode) {
        this.parkCode = parkCode;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getIdle() {
        return idle;
    }

    public void setIdle(int idle) {
        this.idle = idle;
    }

    public int getCurChange() {
        return curChange;
    }

    public void setCurChange(int curChange) {
        this.curChange = curChange;
    }
    
    
}
