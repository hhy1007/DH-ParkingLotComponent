/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.condition.config;

import java.util.Date;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageCondition;

/**
 * 系统设置表查询条件
 * 
 * @author liudongteng
 * @since 2018年1月22日
 */
public class ParkSysConfigCondition extends PageCondition {

  private String configType; // 配置类型

  private String configName; // 配置名称
 
  private String configPar2; // 参数2

  private String configPar1; // 参数1

  private String configPar3; // 参数3
  
  private Short configSeq; // 配置序列

  private Short enableFlag; // 状态:0-不启用，1启用
  
  private String createUser; // 创建人id

  private Date updateTime; // 更新时间

  private Date createTime; // 添加时间

  private String updateUser; // 更新人id

  public String getConfigType() {
    return configType;
  }

  public void setConfigType(String configType) {
    this.configType = configType;
  }

  public void setConfigName(String configName) {
    this.configName = configName;
  }
  public String getConfigName() {
    return configName;
  }

  public Short getConfigSeq() {
    return configSeq;
  }
  public String getConfigPar1() {
    return configPar1;
  }

  public void setConfigSeq(Short configSeq) {
    this.configSeq = configSeq;
  }

  public String getConfigPar2() {
    return configPar2;
  }
  
  public void setConfigPar1(String configPar1) {
    this.configPar1 = configPar1;
  }

  public void setConfigPar3(String configPar3) {
    this.configPar3 = configPar3;
  }

  public Date getCreateTime() {
    return createTime;
  }
  
  public void setConfigPar2(String configPar2) {
    this.configPar2 = configPar2;
  }

  public String getConfigPar3() {
    return configPar3;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }
  
  public Short getEnableFlag() {
    return enableFlag;
  }

  public void setEnableFlag(Short enableFlag) {
    this.enableFlag = enableFlag;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }
 
  public String getUpdateUser() {
    return updateUser;
  }

  public String getCreateUser() {
    return createUser;
  }
}
