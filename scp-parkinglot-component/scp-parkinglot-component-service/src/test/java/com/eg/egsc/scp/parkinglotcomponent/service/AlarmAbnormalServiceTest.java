/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.eg.egsc.framework.client.core.ClientConfig;
import com.eg.egsc.scp.parkinglotcomponent.service.alarm.AlarmAbnormalService;

/**
 * 临停车长时间未出场告警Juit测试类
 * 
 * @author gongqian
 * @since 2018年1月22日
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClientConfig.class})
public class AlarmAbnormalServiceTest {
  
  protected final Logger logger = LoggerFactory.getLogger(AlarmAbnormalServiceTest.class);
  
  @Autowired
  private AlarmAbnormalService alarmAbnormalServiceImpl;
  
  @Test
  @Transactional
  @Rollback(false)
  public void insertAlarmAbnormal() {
    alarmAbnormalServiceImpl.insert();
  }
}
