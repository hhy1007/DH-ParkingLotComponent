/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.carport.map.dto;

/**
 * 地图展示车位信息Dto
 * 
 * @author huangzhiqiang
 * @since 2018年1月15日
 */
public class CarportsInfoDto {

    private String parkCode;// 停车场编号

    private String total;// 总车位数

    private String idle;// 空余车位

    private String nomalCar;// 正常车辆

    private String illegalCar;// 违停车辆

    private String fixedCarport;// 固定车位

    private String monthInsuranceCarport;// 月保车位

    private String temParkCarport;// 临停车位

    private String unavailableCarport;// 不可用车位

    private String expireCarport;// 将到期车位

    private String arrearCarport;// 欠费车位


    public String getParkCode() {
        return parkCode;
    }

    public void setParkCode(String parkCode) {
        this.parkCode = parkCode;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getIdle() {
        return idle;
    }

    public void setIdle(String idle) {
        this.idle = idle;
    }

    public String getNomalCar() {
        return nomalCar;
    }

    public void setNomalCar(String nomalCar) {
        this.nomalCar = nomalCar;
    }

    public String getIllegalCar() {
        return illegalCar;
    }

    public void setIllegalCar(String illegalCar) {
        this.illegalCar = illegalCar;
    }

    public String getFixedCarport() {
        return fixedCarport;
    }

    public void setFixedCarport(String fixedCarport) {
        this.fixedCarport = fixedCarport;
    }

    public String getMonthInsuranceCarport() {
        return monthInsuranceCarport;
    }

    public void setMonthInsuranceCarport(String monthInsuranceCarport) {
        this.monthInsuranceCarport = monthInsuranceCarport;
    }

    public String getTemParkCarport() {
        return temParkCarport;
    }

    public void setTemParkCarport(String temParkCarport) {
        this.temParkCarport = temParkCarport;
    }

    public String getUnavailableCarport() {
        return unavailableCarport;
    }

    public void setUnavailableCarport(String unavailableCarport) {
        this.unavailableCarport = unavailableCarport;
    }

    public String getExpireCarport() {
        return expireCarport;
    }

    public void setExpireCarport(String expireCarport) {
        this.expireCarport = expireCarport;
    }

    public String getArrearCarport() {
        return arrearCarport;
    }

    public void setArrearCarport(String arrearCarport) {
        this.arrearCarport = arrearCarport;
    }

    @Override
    public String toString() {
        return "CarportsInfoDto [parkCode=" + parkCode + ", total=" + total + ", idle=" + idle
                + ", nomalCar=" + nomalCar + ", illegalCar=" + illegalCar + ", fixedCarport="
                + fixedCarport + ", monthInsuranceCarport=" + monthInsuranceCarport
                + ", temParkCarport=" + temParkCarport + ", unavailableCarport="
                + unavailableCarport + ", expireCarport=" + expireCarport + ", arrearCarport="
                + arrearCarport + "]";
    }

}
