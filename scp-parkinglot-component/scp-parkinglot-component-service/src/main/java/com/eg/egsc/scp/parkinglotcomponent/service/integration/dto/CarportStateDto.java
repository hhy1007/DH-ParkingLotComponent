/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.integration.dto;

/**
 * 车位状态变更参数
 * 
 * @Class Name CarportStatusDto
 * @Author zhangli
 * @Create In 2017年12月19日
 */
public class CarportStateDto {

    /** 车位编号*/
    private String carportCode;

    /** 停车检测类型 0-无车；1-有车*/
    private Short parkType;
    
    /** 车牌号码*/
    private String carNum;

    /** 车位编号*/
    public String getCarportCode() {
        return carportCode;
    }

    public void setCarportCode(String carportCode) {
        this.carportCode = carportCode;
    }

    /** 停车检测类型 0-无车；1-有车'*/
    public Short getParkType() {
        return parkType;
    }

    public void setParkType(Short parkType) {
        this.parkType = parkType;
    }

    /**
     * @Return the String carNum
     */
    public String getCarNum() {
      return carNum;
    }

    /**
     * @Param String carNum to set
     */
    public void setCarNum(String carNum) {
      this.carNum = carNum;
    }
}
