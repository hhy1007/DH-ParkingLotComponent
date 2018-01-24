/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.eg.egsc.common.component.job.JobRunner;

/**
 * @Class Name DemoJob
 * @Author gaoyanlong
 * @Create In 2017年12月21日
 */
@Component("demoJob")
public class DemoJob implements JobRunner {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run() {
        logger.info("my job is running....");
    }
}
