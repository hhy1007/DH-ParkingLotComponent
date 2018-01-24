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

import com.eg.egsc.scp.parkinglotcomponent.extmapper.alarm.AlarmAbnormalMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkAlarmAbnormalMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAlarmAbnormal;
import com.eg.egsc.scp.parkinglotcomponent.service.alarm.AlarmAbnormalService;
import com.eg.egsc.scp.parkinglotcomponent.util.Constants;
import com.eg.egsc.scp.parkinglotcomponent.util.DateUtil;
import com.eg.egsc.scp.parkinglotcomponent.util.UuidUtil;

/**
 * 临停车长时间未出场告警逻辑处理层
 * 
 * @author gongqian
 * @since 2018年1月22日
 */
@Service
public class AlarmAbnormalServiceImpl implements AlarmAbnormalService{

  protected final Logger logger = LoggerFactory.getLogger(this.getClass());
  
  @Autowired
  private ParkAlarmAbnormalMapper parkAlarmAbnormalMapper;
  
  @Autowired
  private AlarmAbnormalMapper alarmAbnormalMapper;

  @Override
  public void insert() {
    List<Map<String, Object>> alarmAbnormalList = alarmAbnormalMapper.selectAlarmAbnormal(null);
    for (Map<String, Object> alarmAbnormalMap : alarmAbnormalList) {
      // 车牌号
      String carNum = (String) alarmAbnormalMap.get("car_num");
      // 停车开始时间
      Date parkStart = (Date) alarmAbnormalMap.get("park_start");
      // 停车检查时间
      Date parkDate = (Date) alarmAbnormalMap.get("park_date");
      // 停车小时数
      String configPar1 = (String) alarmAbnormalMap.get("config_par1");
      // 单位:小时
      String configPar2 = (String) alarmAbnormalMap.get("config_par2");
      // 车位编号
      String carportcode = (String) alarmAbnormalMap.get("carport_code");
      
      if(StringUtils.isNotBlank(configPar1) && "小时".equals(configPar2)) {
        // 计算已经停车的间隔小时数
        Long intervalHours = DateUtil.getIntervalHours(parkStart, parkDate);
        // 配置表的间隔小时数
        Long configHours = Long.parseLong(configPar1);
        // 停车时长超过标准数
        if(intervalHours >= configHours) {
          // 如果临停车超过了时长再进行告警记录
          ParkAlarmAbnormal alarmAbnormal = new ParkAlarmAbnormal();
          alarmAbnormal.setUuid(UuidUtil.generate());
          alarmAbnormal.setCarportcode(carportcode);
          alarmAbnormal.setCarNum(carNum);
          alarmAbnormal.setInTime(parkStart);
          alarmAbnormal.setDispatchState(Constants.DISPATCH_STATE_NO);
          alarmAbnormal.setAlarmState(Constants.ALARM_STATUS_YES);
          alarmAbnormal.setCreateTime(new Date());
          alarmAbnormal.setUpdateTime(new Date());
          parkAlarmAbnormalMapper.insert(alarmAbnormal);
        }
      }
    }
  }
}