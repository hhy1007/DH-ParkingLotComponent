/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.vo.carcapture;

import java.util.Date;

import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseConvert;
import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseVo;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarCapture;

public class CarcaptureVo implements BaseVo<ParkCarCapture>{
	 private String uuid;

    private String carNum;

    private Date capTime;

    private String channelId;

    private String cameraCode;

    private String cameraName;

    private String carNumColor;

    private String carMode;

    private String carBrand;

    private String imgUrl;

    private String numUrl;
    
    
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public Date getCapTime() {
		return capTime;
	}

	public void setCapTime(Date capTime) {
		this.capTime = capTime;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getCameraCode() {
		return cameraCode;
	}

	public void setCameraCode(String cameraCode) {
		this.cameraCode = cameraCode;
	}

	public String getCameraName() {
		return cameraName;
	}

	public void setCameraName(String cameraName) {
		this.cameraName = cameraName;
	}

	public String getCarNumColor() {
		return carNumColor;
	}

	public void setCarNumColor(String carNumColor) {
		this.carNumColor = carNumColor;
	}

	public String getCarMode() {
		return carMode;
	}

	public void setCarMode(String carMode) {
		this.carMode = carMode;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getNumUrl() {
		return numUrl;
	}

	public void setNumUrl(String numUrl) {
		this.numUrl = numUrl;
	}

	@Override
	public void convertPOToVO(ParkCarCapture poObj) {
		if(poObj != null){
            BaseConvert.convertPOToVO(poObj, this);
        }
		
	}

	@Override
	public ParkCarCapture convertVOToPO() {
		ParkCarCapture  carcapture=new ParkCarCapture();
		BaseConvert.convertVOToPO(this, carcapture);
        return carcapture;
	}

}
