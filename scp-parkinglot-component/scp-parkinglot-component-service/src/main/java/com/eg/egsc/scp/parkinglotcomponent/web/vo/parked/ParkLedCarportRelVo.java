/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.vo.parked;

import java.util.Date;

import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseConvert;
import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseVo;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkLedCarportRel;

/**
 * 诱导屏&车位绑定VO类
 * 
 * @author gongqian
 * @since 2018年1月15日
 */
public class ParkLedCarportRelVo implements BaseVo<ParkLedCarportRel> {
  private String uuid;

  private String ledCode;

  private String carportId;

  private Date createTime;

  private String createUser;

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getLedCode() {
    return ledCode;
  }

  public void setLedCode(String ledCode) {
    this.ledCode = ledCode;
  }

  public String getCarportId() {
    return carportId;
  }

  public void setCarportId(String carportId) {
    this.carportId = carportId;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public String getCreateUser() {
    return createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }

  @Override
  public void convertPOToVO(ParkLedCarportRel poObj) {
    if (poObj != null) {
      BaseConvert.convertPOToVO(poObj, this);
    }
  }

  @Override
  public ParkLedCarportRel convertVOToPO() {
    ParkLedCarportRel voObj = new ParkLedCarportRel();
    BaseConvert.convertPOToVO(this, voObj);
    return voObj;
  }
}
