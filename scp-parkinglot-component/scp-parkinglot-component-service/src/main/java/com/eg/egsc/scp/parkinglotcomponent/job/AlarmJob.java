/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eg.egsc.common.component.job.JobRunner;
import com.eg.egsc.scp.parkinglotcomponent.service.alarm.AlarmAbnormalService;
import com.eg.egsc.scp.parkinglotcomponent.service.alarm.AlarmArrearService;

/**
 * 告警定时调度类
 * 
 * @author gongqian
 * @since 2018年1月23日
 */
@Component("alarmJob")
public class AlarmJob implements JobRunner {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private AlarmAbnormalService alarmAbnormalServiceImpl;
    
    @Autowired
    private AlarmArrearService alarmArrearServiceImpl;

    @Override
    public void run() {
        logger.info("my alarmJob is running....");
        alarmAbnormalServiceImpl.insert();
        alarmArrearServiceImpl.insert();
        logger.info("my alarmJob end....");
    }
}
