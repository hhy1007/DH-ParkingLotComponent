/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.alarm.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eg.egsc.scp.parkinglotcomponent.extmapper.alarm.AlarmArrearMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkAlarmArrearMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAlarmArrear;
import com.eg.egsc.scp.parkinglotcomponent.service.alarm.AlarmArrearService;
import com.eg.egsc.scp.parkinglotcomponent.util.Constants;
import com.eg.egsc.scp.parkinglotcomponent.util.DateUtil;
import com.eg.egsc.scp.parkinglotcomponent.util.UuidUtil;

/**
 * 车位即将到期预警逻辑处理层
 * 
 * @author gongqian
 * @since 2018年1月22日
 */
@Service
public class AlarmArrearServiceImpl implements AlarmArrearService{

  protected final Logger logger = LoggerFactory.getLogger(this.getClass());
  
  @Autowired
  private ParkAlarmArrearMapper parkAlarmArrearMapper;
  
  @Autowired
  private AlarmArrearMapper alarmArrearMapper;

  @Override
  public void insert() {
    List<Map<String, Object>> alarmArrearList = alarmArrearMapper.selectAlarmArrear(null);
    for (Map<String, Object> alarmArrearMap : alarmArrearList) {
      // 车位编号
      String carportCode = (String) alarmArrearMap.get("carport_code");
      // 车位类型：1-月租，2-产权/固定，0-临停
      Integer carportType = (Integer) alarmArrearMap.get("carport_type");
      // 有效期结束时间
      Date validEndTime = (Date) alarmArrearMap.get("valid_end_time");
      // 提前提醒的天数
      String configPar1 = (String) alarmArrearMap.get("config_par1");
      // 单位:天
      String configPar2 = (String) alarmArrearMap.get("config_par2");
      // 判断配置的参数是否为空
      if(StringUtils.isNotBlank(configPar1) && "天".equals(configPar2)) {
        Short config = Short.parseShort(configPar1);
        // 判断当前日期+7天之后的日期 与 有效结束时间比较,如果大于等于后者，则提醒
        Date laterDate = DateUtil.getAddDayDate(new Date(), config);
        if(null != validEndTime) {
          this.judge(laterDate, validEndTime, carportType, carportCode);
        }
      }
    }
  }
  
  private void judge(Date laterDate, Date validEndTime,Integer carportType,String carportCode) {
    int result = DateUtil.compareDateByYMD(laterDate, validEndTime);
    // >= 正好还有7天到期
    if(result >= 0) {
      ParkAlarmArrear alarmArrear = new ParkAlarmArrear();
      alarmArrear.setUuid(UuidUtil.generate());
      alarmArrear.setCarportCode(carportCode);
      if(null != carportType) {
        alarmArrear.setCarportType(Short.parseShort(String.valueOf(carportType)));
      }
      alarmArrear.setChargeState(Constants.CHARGE_STATE_ARREAR);
      alarmArrear.setAlarmState(Constants.ALARM_STATUS_YES);
      alarmArrear.setCreateTime(new Date());
      alarmArrear.setUpdateTime(new Date());
      parkAlarmArrearMapper.insert(alarmArrear);
    }
  }
}
