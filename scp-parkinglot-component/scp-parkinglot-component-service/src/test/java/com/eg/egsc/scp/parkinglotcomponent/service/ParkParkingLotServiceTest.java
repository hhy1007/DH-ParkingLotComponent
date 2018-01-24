/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

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
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.condition.park.ParkingLotCondition;
import com.eg.egsc.scp.parkinglotcomponent.dao.park.ParkParkingLotDao;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkingLot;
import com.eg.egsc.scp.parkinglotcomponent.service.park.ParkParkingLotService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClientConfig.class})
public class ParkParkingLotServiceTest {


    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource // 自动注入,默认按名称
    private ParkParkingLotService parkParkingLotServiceImpl;

    @Autowired
    private ParkParkingLotDao parkParkingLotDao;

    @Test
    @Transactional
    @Rollback(true)
    public void selectByPrimaryKey() {
        ParkParkingLot parkParkingLot = parkParkingLotServiceImpl.selectByPrimaryKey("23315656");
        logger.info("=== " + JSON.toJSONString(parkParkingLot));
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void insertParkingLot() {

        ParkParkingLot parkParkingLot = new ParkParkingLot();
        parkParkingLot.setAddress("22");
        parkParkingLot.setConfigInfo("22q");
        parkParkingLot.setFeeRuleId("12g");
        parkParkingLot.setIdle(15);
        parkParkingLot.setMemo("12d");
        parkParkingLot.setParentCode("22j");
        parkParkingLot.setParkName("恒大停车场4");
        parkParkingLot.setParentCode("15644545455656");
        parkParkingLot.setParkCode("HD004");
        parkParkingLot.setParkRuleId("2l");
        parkParkingLot.setPicPath("1542");
        parkParkingLot.setTotal(6);
        int result = 0;
        try {
            result = parkParkingLotServiceImpl.insert(parkParkingLot);
        } catch (Exception e) {
            logger.info("=== " + e.getMessage());
        }
        logger.info("=== " + result);
    }



    @Test
    @Transactional
    @Rollback(true)
    public void updateParkingLot() {
        ParkParkingLot parkParkingLot1 = new ParkParkingLot();
        parkParkingLot1.setUuid("9fc6b0874aca46da85dd6edb37c70a7b1");
        parkParkingLot1.setAddress("q1a");
        parkParkingLot1.setConfigInfo("w1a");
        parkParkingLot1.setFeeRuleId("e1q");
        parkParkingLot1.setIdle(1);
        parkParkingLot1.setMemo("t1a");
        parkParkingLot1.setParentCode("y2a");
        parkParkingLot1.setParkName("u1a");
        parkParkingLot1.setParentCode("k2a");
        parkParkingLot1.setParkCode("z2a");
        parkParkingLot1.setParkRuleId("2a");
        parkParkingLot1.setPicPath("e154");
        parkParkingLot1.setTotal(4);
        parkParkingLot1.setUpdateTime(new Date());
        parkParkingLot1.setUpdateUser("z2a");
        int result = 0;
        try {
            result = parkParkingLotServiceImpl.update(parkParkingLot1);
        } catch (Exception e) {
            logger.info("=== " + e.getMessage());
        }
        logger.info("=== " + JSON.toJSONString(result));
    }

    @Test
    @Transactional
    @Rollback(true)
    public void batchDeleteParkingLots() {
        List<String> ids = new ArrayList<>();
        ids.add("9fc6b0874aca46da85dd6edb37c70a7b");
        ids.add("45d28bb0e1f946f9b78b60c66021815c");
        int result = parkParkingLotServiceImpl.deleteByIds(ids);
        logger.info("=== " + JSON.toJSONString(result));
    }

    @Test
    @Transactional
    @Rollback(true)
    public void batchDeleteParkingLots1() {
        List<String> ids1 = new ArrayList<>();
        ids1.add("9fc6b0874aca46da85dd6edb37c70a7b1");
        int result = parkParkingLotServiceImpl.deleteByIds(ids1);
        logger.info("=== " + JSON.toJSONString(result));
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void selectPageList() {
        ParkingLotCondition condition = new ParkingLotCondition();
        condition.setPageSize(25);
        condition.setCurrentPage(1);
        condition.setParkCode(null);
        condition.setParkName(null);
        Page<ParkParkingLot> page = parkParkingLotServiceImpl.selectPageList(condition);
        logger.info("=== " + JSON.toJSONString(page));
    }

    @Test
    @Transactional
    @Rollback(true)
    public void selectList() {
        ParkingLotCondition condition = new ParkingLotCondition();
        condition.setParentCode("HD001");
        List<ParkParkingLot> list = parkParkingLotServiceImpl.selectList(condition);
        logger.info("=== " + JSON.toJSONString(list));
    }

    @Test
    @Transactional
    @Rollback(true)
    public void updateParkingLotSelfReductionOrSelfAdd() {
        logger.info("=== "
                + parkParkingLotDao.updateParkingLotSelfReductionOrSelfAdd("fjla234312affd", true));
    }
}
