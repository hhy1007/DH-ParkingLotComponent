/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.park.dto;

/**
 * @Class Name ReFeesDto
 * @Author wangziqiang
 * @Create In 2018年1月9日
 */
public class ReFeesDto {

    private Integer theStopTime;// 时长

    private String money;// 所需费用

    private String ownerName;// 车主名字


    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Integer getTheStopTime() {
        return theStopTime;
    }

    public void setTheStopTime(Integer theStopTime) {
        this.theStopTime = theStopTime;
    }

}
