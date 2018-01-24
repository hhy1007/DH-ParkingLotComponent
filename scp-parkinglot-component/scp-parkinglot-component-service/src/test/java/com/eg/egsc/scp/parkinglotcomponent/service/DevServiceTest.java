/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.eg.egsc.framework.client.core.ClientConfig;
import com.eg.egsc.scp.parkinglotcomponent.service.dev.DevService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClientConfig.class})
public class DevServiceTest {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Resource
    private DevService devServiceImpl;
    
    @Test
    @Transactional
    @Rollback(true)
    public void deleteByDevCode() {
        String devCode = "555";
        int reuslt = devServiceImpl.deleteByDevCode(devCode);
        logger.info("reuslt ==="+reuslt);
    }
}
