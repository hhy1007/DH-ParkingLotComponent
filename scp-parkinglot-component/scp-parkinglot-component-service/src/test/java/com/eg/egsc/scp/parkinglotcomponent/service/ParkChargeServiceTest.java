/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.eg.egsc.framework.client.core.ClientConfig;
import com.eg.egsc.scp.mdm.component.client.UserClient;
import com.eg.egsc.scp.mdm.component.dto.BaseUserDto;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.condition.charge.ChargeCondition;
import com.eg.egsc.scp.parkinglotcomponent.dto.charge.ChargeOnlineDto;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCharge;
import com.eg.egsc.scp.parkinglotcomponent.service.charge.ParkChargeService;
import com.eg.egsc.scp.parkinglotcomponent.service.charge.dto.ChargeDto;
import com.eg.egsc.scp.parkinglotcomponent.util.DateUtil;

/**
 * @Class Name TestParkChargeService
 * @Author huangyuhong
 * @Create In 2017年12月26日
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClientConfig.class})
public class ParkChargeServiceTest {
    
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParkChargeService parkChargeServiceImpl;
    
    @Autowired
    private UserClient userClientImpl;

    @Test
    @Transactional
    @Rollback(true)
    public void charge() {
        ParkCharge charge = new ParkCharge();
        charge.setPackageId("a76dd685075e42758d099d748f0a98e3");
        charge.setMoney(6000);
        charge.setChargeNumber((short)2);
        charge.setOriginalStartTime(DateUtil.stringToDate("2018-01-08 14:55:45", DateUtil.YYYY_MM_DD_HH_MM_SS));
        charge.setOriginalEndTime(DateUtil.stringToDate("2018-03-09 14:55:45", DateUtil.YYYY_MM_DD_HH_MM_SS));
        int result = parkChargeServiceImpl.charge(charge);
        logger.info("=== " + result);
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void chargeOnline() {
        ChargeOnlineDto chargeOnlineDto = new ChargeOnlineDto();
        chargeOnlineDto.setCarNum("粤B-777");
        chargeOnlineDto.setCarportCode("CW0000");
        chargeOnlineDto.setCarportType((short)1);
        chargeOnlineDto.setMoney(3000);
        chargeOnlineDto.setMonth(DateUtil.stringToDate("2018-01-09 14:55:45", DateUtil.YYYY_MM_DD_HH_MM_SS));
        int result = parkChargeServiceImpl.chargeOnline(chargeOnlineDto);
        logger.info("=== " + result);
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void selectPageList() {
        ChargeCondition chargeCondition = new ChargeCondition();
        chargeCondition.setPageSize(10);
        chargeCondition.setCurrentPage(1);
        Page<ChargeDto> page = null;
        try {
            page = parkChargeServiceImpl.selectPageChargeList(chargeCondition);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.info("=== " + JSON.toJSONString(page));
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void selectList() {
        ChargeCondition chargeCondition = new ChargeCondition();
        chargeCondition.setPackageId("1ce9ecaed5c54e09a785a75480ec3770");
        List<ChargeDto> list = null;
        try {
            list = parkChargeServiceImpl.selectChargeList(chargeCondition);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.info("=== " + JSON.toJSONString(list));
    }

    @Test
    @Transactional
    @Rollback(true)
    public void userClientTest() {
        BaseUserDto userDto = new BaseUserDto();
        userDto.setUuid("38f88955d4394f9e9754ff5548ab89b6");
        List<BaseUserDto> list = userClientImpl.getUser(userDto);
        logger.info("##siez: " + list.size());
        logger.info("=== " + list);
    }
    
}
