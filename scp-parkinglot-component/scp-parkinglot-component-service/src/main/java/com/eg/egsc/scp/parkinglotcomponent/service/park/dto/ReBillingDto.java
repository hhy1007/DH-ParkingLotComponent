/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.park.dto;

import java.io.Serializable;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAccessCur;

/**
 * <p>
 * 重新计费返回消息bean
 * 
 * @Class Name ReBillingDto
 * @Author wangziqiang
 * @Create In 2017年12月26日
 */
public class ReBillingDto implements Serializable {
    /**
     * @Field long serialVersionUID
     */
    private static final long serialVersionUID = 2556211914245496972L;

    private String carNum;// 车辆车牌

    private String devCode;// 抓拍车辆的设备编号

    private String outTime;// String类型的车辆离场时间

    private String parkingLotId;// 车场信息

    private int direct;// 车道

    private String money;// 计费金额

    private String channelId;// 车道

    private ParkAccessCur parkAccessCur;// 在场车辆

    private String carPic;// 车图片

    private String outSluiceCode;// 出场道闸

    private int carMode;// 车型

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }


    public String getDevCode() {
        return devCode;
    }

    public void setDevCode(String devCode) {
        this.devCode = devCode;
    }

    public ParkAccessCur getParkAccessCur() {
        return parkAccessCur;
    }

    public void setParkAccessCur(ParkAccessCur parkAccessCur) {
        this.parkAccessCur = parkAccessCur;
    }

    public String getOutSluiceCode() {
        return outSluiceCode;
    }

    public void setOutSluiceCode(String outSluiceCode) {
        this.outSluiceCode = outSluiceCode;
    }

    public String getCarPic() {
        return carPic;
    }

    public void setCarPic(String carPic) {
        this.carPic = carPic;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public int getCarMode() {
        return carMode;
    }

    public void setCarMode(int carMode) {
        this.carMode = carMode;
    }

}
