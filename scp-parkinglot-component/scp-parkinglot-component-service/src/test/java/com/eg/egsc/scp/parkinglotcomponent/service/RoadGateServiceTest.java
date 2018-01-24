/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service;


import java.util.Date;

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
import com.eg.egsc.scp.parkinglotcomponent.enmus.alarm.ChannelDirectType;
import com.eg.egsc.scp.parkinglotcomponent.service.access.RoadGateService;
import com.eg.egsc.scp.parkinglotcomponent.service.integration.dto.CarInOutDto;
import com.eg.egsc.scp.parkinglotcomponent.util.UuidUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClientConfig.class})
public class RoadGateServiceTest {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource // 自动注入,默认按名称
    RoadGateService roadGateServiceImpl;

    @Test
    @Transactional
    @Rollback(true)
    public void testCutOffRoadGateCommand() {
        String devCode = UuidUtil.generate();
        int controlType = 1;
        String result =
                roadGateServiceImpl.cutOffRoadGateCommand(devCode, controlType, new CarInOutDto());
        logger.info("TestCutOffRoadGateCommand is result= {}" + result);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testManualCutOff() {
        try {
            roadGateServiceImpl.manualCutOffRoadGateCommand("xaewqfasdf", 1, new CarInOutDto(),
                    "adsaw", "admiada");
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testConfirmCutOff() {
        CarInOutDto carInOutDto = new CarInOutDto();
        carInOutDto.setDirect(ChannelDirectType.ENTRANCE.getType());
        carInOutDto.setCarNum("xsewef");
        carInOutDto.setChannelId(UuidUtil.generate());
        carInOutDto.setInTime(new Date());
        try {
            roadGateServiceImpl.confirmCutOffRoadGateCommand("asdfwee", 2, carInOutDto);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testConfirmCutOff1() {
        CarInOutDto carInOutDto = new CarInOutDto();
        carInOutDto.setDirect(ChannelDirectType.ENTRANCE.getType());
        carInOutDto.setCarNum("xseaswwwef");
        carInOutDto.setChannelId(UuidUtil.generate());
        carInOutDto.setInTime(new Date());
        carInOutDto.setParkCode("HD00001");
        try {
            roadGateServiceImpl.confirmCutOffRoadGateCommand("444", 2, carInOutDto);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }
}
