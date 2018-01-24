/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.condition.cur;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageCondition;

/**
 * 实时车位查询条件
 * 
 * @author liudongteng
 * @since 2018年1月12日
 */
public class ParkedCarportCondition extends PageCondition {
  private String uuid;
  private String carportCode; // 车位编号
  private String carportName; // 车位名称

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getCarportCode() {
    return carportCode;
  }

  public void setCarportCode(String carportCode) {
    this.carportCode = carportCode;
  }

  public String getCarportName() {
    return carportName;
  }

  public void setCarportName(String carportName) {
    this.carportName = carportName;
  }


}
