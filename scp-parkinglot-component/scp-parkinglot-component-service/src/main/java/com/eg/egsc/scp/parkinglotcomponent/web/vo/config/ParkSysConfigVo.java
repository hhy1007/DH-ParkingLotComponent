/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.vo.config;

import java.util.Date;

import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseConvert;
import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseVo;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkSysConfig;

/**
 * 系统设置表Vo
 * 
 * @author liudongteng
 * @since 2018年1月22日
 */
public class ParkSysConfigVo implements BaseVo<ParkSysConfig> {

  private String configType;

  private String configPar1;
  
  private String configName;

  private Short configSeq;

  private String configPar3;

  private Date createTime;

  private String configPar2;

  private String createUser;

  private Short enableFlag;

  private String updateUser;

  private Date updateTime;

  public String getConfigName() {
    return configName;
  }

  public String getConfigType() {
    return configType;
  }

  public void setConfigType(String configType) {
    this.configType = configType;
  }

  public String getConfigPar1() {
    return configPar1;
  }

  public void setConfigName(String configName) {
    this.configName = configName;
  }

  public Short getConfigSeq() {
    return configSeq;
  }

  public void setConfigSeq(Short configSeq) {
    this.configSeq = configSeq;
  }

  public void setConfigPar2(String configPar2) {
    this.configPar2 = configPar2;
  }

  public void setConfigPar1(String configPar1) {
    this.configPar1 = configPar1;
  }

  public String getConfigPar2() {
    return configPar2;
  }

  public Short getEnableFlag() {
    return enableFlag;
  }

  public String getConfigPar3() {
    return configPar3;
  }

  public void setConfigPar3(String configPar3) {
    this.configPar3 = configPar3;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setEnableFlag(Short enableFlag) {
    this.enableFlag = enableFlag;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  @Override
  public void convertPOToVO(ParkSysConfig poObj) {
    if (poObj != null) {
      BaseConvert.convertPOToVO(poObj, this);
    }
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }

  public String getCreateUser() {
    return createUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  

  @Override
  public ParkSysConfig convertVOToPO() {
    ParkSysConfig voObj = new ParkSysConfig();
    BaseConvert.convertPOToVO(this, voObj);
    return voObj;
  }
}
