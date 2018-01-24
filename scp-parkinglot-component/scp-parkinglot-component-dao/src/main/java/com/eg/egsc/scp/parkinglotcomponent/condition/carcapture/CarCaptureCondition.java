/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.condition.carcapture;

import java.util.Date;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageCondition;

/**
 * 车辆抓拍查询过滤条件
 * 
 * @Class Name CarCaptureCondition
 * @Author xiangdaoping
 * @Create In 2017年12月15日
 */
public class CarCaptureCondition extends PageCondition {

    private String id;

    private String carNum;

    private Date capTime;

    private String channelId;

    private String cameraCode;

    private String cameraName;

    private String carNumColor;

    private String carMode;

    private String carBrand;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCapTime(Date capTime) {
        this.capTime = capTime;
    }

    public Date getCapTime() {
        return capTime;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setCameraCode(String cameraCode) {
        this.cameraCode = cameraCode;
    }

    public String getCameraCode() {
        return cameraCode;
    }

    public void setCameraName(String cameraName) {
        this.cameraName = cameraName;
    }

    public String getCameraName() {
        return cameraName;
    }

    public void setCarNumColor(String carNumColor) {
        this.carNumColor = carNumColor;
    }

    public String getCarNumColor() {
        return carNumColor;
    }

    public void setCarMode(String carMode) {
        this.carMode = carMode;
    }

    public String getCarMode() {
        return carMode;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarBrand() {
        return carBrand;
    }
}
