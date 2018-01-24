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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.eg.egsc.framework.client.core.ClientConfig;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.condition.park.CarportRelCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkLedCarportRel;
import com.eg.egsc.scp.parkinglotcomponent.service.carport.ParkCarportRelService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClientConfig.class})
public class ParkCarportRelServiceTest {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource // 自动注入,默认按名称
    private ParkCarportRelService parkCarportRelServiceImpl;

    @Test
    @Transactional
    @Rollback(true)
    public void insertCarportRel() {
        ParkLedCarportRel parkCarportRel = new ParkLedCarportRel();
        parkCarportRel.setCarportId("1");
        parkCarportRel.setCreateTime(new Date());
        parkCarportRel.setCreateUser("and");
        parkCarportRel.setLedCode("b");
        int result = 0;
        try {
            result = parkCarportRelServiceImpl.insert(parkCarportRel);
        } catch (Exception e) {
            logger.info("=== " + e.getMessage());
        }
        logger.info("=== " + result);
    }


    @Test
    @Transactional
    @Rollback(true)
    public void insertCarportRel1() {
        ParkLedCarportRel parkCarportRel1 = new ParkLedCarportRel();
        parkCarportRel1.setCarportId("2");
        parkCarportRel1.setCreateTime(new Date());
        parkCarportRel1.setCreateUser("qer");
        int result = 0;
        try {
            result = parkCarportRelServiceImpl.insert(parkCarportRel1);
        } catch (Exception e) {
            logger.info("=== " + e.getMessage());
        }
        logger.info("=== " + result);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void updateCarportRel() {
        ParkLedCarportRel parkCarportRel = new ParkLedCarportRel();
        parkCarportRel.setUuid("735f3d5979f14a7fa5c5a88d656d3012");
        parkCarportRel.setCarportId("1");
        parkCarportRel.setCreateTime(new Date());
        parkCarportRel.setCreateUser("qer2");
        parkCarportRel.setLedCode("b2");
        int result = 0;
        try {
            result = parkCarportRelServiceImpl.update(parkCarportRel);
        } catch (Exception e) {
            logger.info("=== " + e.getMessage());
        }
        logger.info("=== " + result);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void updateCarportRel2() {
        ParkLedCarportRel parkCarportRel2 = new ParkLedCarportRel();
        parkCarportRel2.setUuid("22");
        parkCarportRel2.setCarportId("2");
        parkCarportRel2.setCreateTime(new Date());
        parkCarportRel2.setCreateUser("dqer2");
        parkCarportRel2.setLedCode("cb2");
        int result = 0;
        try {
            result = parkCarportRelServiceImpl.update(parkCarportRel2);
        } catch (Exception e) {
            logger.info("=== " + e.getMessage());
        }
        logger.info("=== " + result);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void batchDeleteCars() {
        List<String> ids = new ArrayList<>();
        ids.add("11");
        int result = parkCarportRelServiceImpl.deleteByIds(ids);
        logger.info("insertCarport param: " + result);
    }


    @Test
    @Transactional
    @Rollback(true)
    public void selectPageList() {
        CarportRelCondition condition = new CarportRelCondition();
        condition.setPageSize(30);
        condition.setCurrentPage(1);
        Page<ParkLedCarportRel> page = parkCarportRelServiceImpl.selectPageList(condition);
        logger.info("=== " + JSON.toJSONString(page));
    }

    @Test
    @Transactional
    @Rollback(true)
    public void selectList() {
        CarportRelCondition condition = new CarportRelCondition();
        condition.setCarportId("d971210a11f2469299495eae822c3dc5");
        List<ParkLedCarportRel> list = parkCarportRelServiceImpl.selectList(condition);
        logger.info("=== " + JSON.toJSONString(list));
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void selectLedCarportRelByLedCode(){
        String ledCode = "4cbe84d80d5146d392da9e054a6e2144";
        List<ParkLedCarportRel> ledCarportRelList = parkCarportRelServiceImpl.selectLedCarportRelByLedCode(ledCode);
        logger.info("=== " + JSON.toJSONString(ledCarportRelList));
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void deleteByLedCode() {
        String ledCode = "a09563ba181145e19dd6c7365171e4ac";
        int reuslt = parkCarportRelServiceImpl.deleteByLedCode(ledCode);
        logger.info("=== " + JSON.toJSONString(reuslt));
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void selectByPrimaryKey() {
        ParkLedCarportRel parkCarportRel = parkCarportRelServiceImpl.selectByPrimaryKey("233");
        logger.info("=== " + JSON.toJSONString(parkCarportRel));
    }

}
