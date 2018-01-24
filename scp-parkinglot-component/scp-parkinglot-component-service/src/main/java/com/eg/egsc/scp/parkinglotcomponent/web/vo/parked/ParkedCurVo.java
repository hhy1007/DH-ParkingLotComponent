/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.vo.parked;

import java.util.Date;

import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseConvert;
import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseVo;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkedCur;

/**
 * 
 * @author gongqian
 * @since 2018年1月12日
 */
public class ParkedCurVo implements BaseVo<ParkParkedCur> {

  private String uuid;

  private String deviceCode;

  private String carportCode;

  private String deviceName;

  private String mapId;

  private String carNum;

  private String carNumColor;

  private String carMark;

  private String carColor;

  private String ownerId;

  private Date parkStart;

  private Short alarmStatus;

  private Short parkType;

  private String imgUrl;

  private Date parkDate;

  /**
   * @Return the String id
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * @Return the String deviceCode
   */
  public String getDeviceCode() {
    return deviceCode;
  }

  /**
   * @Param String id to set
   */
  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  /**
   * @Param String deviceCode to set
   */
  public void setDeviceCode(String deviceCode) {
    this.deviceCode = deviceCode;
  }

  /**
   * @Return the String mapId
   */
  public String getMapId() {
    return mapId;
  }

  /**
   * @Return the String deviceName
   */
  public String getDeviceName() {
    return deviceName;
  }

  /**
   * @Param String deviceName to set
   */
  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }

  /**
   * @Param String carportCode to set
   */
  public void setCarportCode(String carportCode) {
    this.carportCode = carportCode;
  }

  /**
   * @Param String mapId to set
   */
  public void setMapId(String mapId) {
    this.mapId = mapId;
  }

  /**
   * @Return the String carportCode
   */
  public String getCarportCode() {
    return carportCode;
  }



  /**
   * @Return the String carNumColor
   */
  public String getCarNumColor() {
    return carNumColor;
  }



  /**
   * @Return the String carColor
   */
  public String getCarColor() {
    return carColor;
  }

  /**
   * @Param String carColor to set
   */
  public void setCarColor(String carColor) {
    this.carColor = carColor;
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


  /**
   * @Return the String ownerId
   */
  public String getOwnerId() {
    return ownerId;
  }

  /**
   * @Return the String carMark
   */
  public String getCarMark() {
    return carMark;
  }

  /**
   * @Param String carNumColor to set
   */
  public void setCarNumColor(String carNumColor) {
    this.carNumColor = carNumColor;
  }

  /**
   * @Param String carMark to set
   */
  public void setCarMark(String carMark) {
    this.carMark = carMark;
  }



  /**
   * @Param String ownerId to set
   */
  public void setOwnerId(String ownerId) {
    this.ownerId = ownerId;
  }

  /**
   * @Return the Date parkStart
   */
  public Date getParkStart() {
    return parkStart;
  }

  /**
   * @Param Date parkStart to set
   */
  public void setParkStart(Date parkStart) {
    this.parkStart = parkStart;
  }

  /**
   * @Param Date parkDate to set
   */
  public void setParkDate(Date parkDate) {
    this.parkDate = parkDate;
  }

  /**
   * @Return the Short alarmStatus
   */
  public Short getAlarmStatus() {
    return alarmStatus;
  }


  /**
   * @Return the String imgUrl
   */
  public String getImgUrl() {
    return imgUrl;
  }

  /**
   * @Param Short alarmStatus to set
   */
  public void setAlarmStatus(Short alarmStatus) {
    this.alarmStatus = alarmStatus;
  }

  /**
   * @Param Short parkType to set
   */
  public void setParkType(Short parkType) {
    this.parkType = parkType;
  }

  /**
   * @Return the Short parkType
   */
  public Short getParkType() {
    return parkType;
  }

  /**
   * @Param String imgUrl to set
   */
  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }


  /**
   * @Return the Date parkDate
   */
  public Date getParkDate() {
    return parkDate;
  }

  @Override
  public void convertPOToVO(ParkParkedCur poObj) {
    if (poObj != null) {
      BaseConvert.convertPOToVO(poObj, this);
    }
  }

  @Override
  public ParkParkedCur convertVOToPO() {
    ParkParkedCur voObj = new ParkParkedCur();
    BaseConvert.convertPOToVO(this, voObj);
    return voObj;
  }

}
