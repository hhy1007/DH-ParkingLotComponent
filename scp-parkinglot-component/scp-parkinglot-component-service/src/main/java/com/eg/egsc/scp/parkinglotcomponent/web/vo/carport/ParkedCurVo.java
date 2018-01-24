/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.vo.carport;

import java.io.Serializable;
import java.util.Date;
import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseConvert;
import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseVo;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkedCur;

/**
 * 停车场查询VO
 * 
 * @author huangzhiqiang
 * @since 2018年1月12日
 */
public class ParkedCurVo implements Serializable, BaseVo<ParkParkedCur> {

  /**
   * @Field long serialVersionUID
   */
  private static final long serialVersionUID = 1882129501270426086L;

  private String id;

  private String deviceCode;

  private String deviceName;

  private String mapId;

  private String carportCode;

  private String carNum;

  private Short carNumColor;

  private Short carColor;

  private Short carMark;

  private String ownerId;

  private Date parkStart;

  private Date parkDate;

  private Short alarmStatus;

  private Short parkType;

  private String imgUrl;

  /**
   * @Return the String id
   */
  public String getId() {
    return id;
  }

  /**
   * @Param String id to set
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * @Return the String deviceCode
   */
  public String getDeviceCode() {
    return deviceCode;
  }

  /**
   * @Param String deviceCode to set
   */
  public void setDeviceCode(String deviceCode) {
    this.deviceCode = deviceCode;
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
   * @Return the String mapId
   */
  public String getMapId() {
    return mapId;
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
   * @Param String carportCode to set
   */
  public void setCarportCode(String carportCode) {
    this.carportCode = carportCode;
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
   * @Return the Short carNumColor
   */
  public Short getCarNumColor() {
    return carNumColor;
  }

  /**
   * @Param Short carNumColor to set
   */
  public void setCarNumColor(Short carNumColor) {
    this.carNumColor = carNumColor;
  }

  /**
   * @Return the Short carColor
   */
  public Short getCarColor() {
    return carColor;
  }

  /**
   * @Param Short carColor to set
   */
  public void setCarColor(Short carColor) {
    this.carColor = carColor;
  }

  /**
   * @Return the Short carMark
   */
  public Short getCarMark() {
    return carMark;
  }

  /**
   * @Param Short carMark to set
   */
  public void setCarMark(Short carMark) {
    this.carMark = carMark;
  }

  /**
   * @Return the Date parkDate
   */
  public Date getParkDate() {
    return parkDate;
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
   * @Param Date parkDate to set
   */
  public void setParkDate(Date parkDate) {
    this.parkDate = parkDate;
  }

  /**
   * @Return the String ownerId
   */
  public String getOwnerId() {
    return ownerId;
  }

  /**
   * @Return the Short alarmStatus
   */
  public Short getAlarmStatus() {
    return alarmStatus;
  }

  /**
   * @Param Short alarmStatus to set
   */
  public void setAlarmStatus(Short alarmStatus) {
    this.alarmStatus = alarmStatus;
  }

  /**
   * @Return the Short parkType
   */
  public Short getParkType() {
    return parkType;
  }

  /**
   * @Param Short parkType to set
   */
  public void setParkType(Short parkType) {
    this.parkType = parkType;
  }

  /**
   * @Return the String imgUrl
   */
  public String getImgUrl() {
    return imgUrl;
  }


  /**
   * @Param Date parkStart to set
   */
  public void setParkStart(Date parkStart) {
    this.parkStart = parkStart;
  }
  /**
   * @Param String imgUrl to set
   */
  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }

  @Override
  public void convertPOToVO(ParkParkedCur poObj) {
    if (poObj != null) {
      BaseConvert.convertPOToVO(poObj, this);
    }
  }

  @Override
  public ParkParkedCur convertVOToPO() {
    ParkParkedCur parkParkedCur = new ParkParkedCur();
    BaseConvert.convertVOToPO(this, parkParkedCur);
    return parkParkedCur;
  }



}
