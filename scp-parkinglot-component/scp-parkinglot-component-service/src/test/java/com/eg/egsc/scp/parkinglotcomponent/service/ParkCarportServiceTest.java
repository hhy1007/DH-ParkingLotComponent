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
import com.eg.egsc.scp.parkinglotcomponent.condition.park.CarportCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarport;
import com.eg.egsc.scp.parkinglotcomponent.service.carport.ParkCarportService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClientConfig.class})
public class ParkCarportServiceTest {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource // 自动注入,默认按名称
    private ParkCarportService parkCarportServiceImpl;

    @Test
    @Transactional
    @Rollback(true)
    public void insertCarport() {

        ParkCarport parkCarport = new ParkCarport();
        parkCarport.setAreaIdle((short) 10);
        parkCarport.setAreaTotal((short) 30);
        parkCarport.setCarportAllocation((short) 20);
        parkCarport.setCarportCode("22");
        parkCarport.setCarportShape("23");
        parkCarport.setCarportType((short) 24);
        parkCarport.setCreateTime(new Date());
        parkCarport.setDetectorCode("25");
        parkCarport.setLockCode("454");
        parkCarport.setMapId("26");
        parkCarport.setMemo("27");
        parkCarport.setMonitorCode("28");
        parkCarport.setParkId("29");
        parkCarport.setPropertyRight((short) 32);
        parkCarport.setSuitCarModel((short) 33);
        parkCarport.setDeleteFlag((short) 1);
        int result = 0;
        try {
            result = parkCarportServiceImpl.insert(parkCarport);
        } catch (Exception e) {
            logger.info("=== " + e.getMessage());
        }
        logger.info("=== " + result);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void insertBatchCarport() {
        List<ParkCarport> parkCarports = new ArrayList<>();
        ParkCarport parkCarport1 = new ParkCarport();
        parkCarport1.setAreaIdle((short) 100);
        parkCarport1.setAreaTotal((short) 300);
        parkCarport1.setCarportAllocation((short) 200);
        parkCarport1.setCarportCode("22a");
        parkCarport1.setCarportShape("23a");
        parkCarport1.setCarportType((short) 24);
        parkCarport1.setCreateTime(new Date());
        parkCarport1.setDetectorCode("25a");
        parkCarport1.setLockCode("454a");
        parkCarport1.setMapId("26a");
        parkCarport1.setMemo("27a");
        parkCarport1.setMonitorCode("28a");
        parkCarport1.setParkId("29a");
        parkCarport1.setPropertyRight((short) 323);
        parkCarport1.setSuitCarModel((short) 333);
        parkCarport1.setDeleteFlag((short) 0);

        ParkCarport parkCarport2 = new ParkCarport();
        parkCarport2.setAreaIdle((short) 1000);
        parkCarport2.setAreaTotal((short) 3000);
        parkCarport2.setCarportAllocation((short) 2000);
        parkCarport2.setCarportCode("b22a");
        parkCarport2.setCarportShape("b23a");
        parkCarport2.setCarportType((short) 23);
        parkCarport2.setCreateTime(new Date());
        parkCarport2.setDetectorCode("b25a");
        parkCarport2.setLockCode("b454a");
        parkCarport2.setMapId("2b6a");
        parkCarport2.setMemo("b27a");
        parkCarport2.setMonitorCode("b28a");
        parkCarport2.setParkId("b29a");
        parkCarport2.setPropertyRight((short) 1323);
        parkCarport2.setSuitCarModel((short) 1333);
        parkCarport2.setDeleteFlag((short) 1);

        parkCarports.add(parkCarport1);
        parkCarports.add(parkCarport2);

        int result = 0;
        try {
            result = parkCarportServiceImpl.insertBatchCarport(parkCarports);
        } catch (Exception e) {
            logger.info("=== " + e.getMessage());
        }
        logger.info("=== " + result);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void updateCarport() {
        ParkCarport parkCarport = new ParkCarport();
        parkCarport.setUuid("889d2cfa477f488585c8bc8418a6cb731");
        parkCarport.setAreaIdle((short) 34);
        parkCarport.setAreaTotal((short) 40);
        parkCarport.setCarportAllocation((short) 36);
        parkCarport.setCarportCode("41");
        parkCarport.setCarportShape("z22");
        parkCarport.setCarportType((short) 55);
        parkCarport.setCreateTime(new Date());
        parkCarport.setCreateUser("x22");
        parkCarport.setDetectorCode("c22");
        parkCarport.setLockCode("z4542");
        parkCarport.setMapId("g22");
        parkCarport.setMemo("h22");
        parkCarport.setMonitorCode("j22");
        parkCarport.setParkId("l22");
        parkCarport.setPropertyRight((short) 14);
        parkCarport.setSuitCarModel((short) 15);
        parkCarport.setUpdateTime(new Date());
        parkCarport.setUpdateUser("o22");
        int result = 0;
        try {
            result = parkCarportServiceImpl.update(parkCarport);
        } catch (Exception e) {
            logger.info("=== " + e.getMessage());
        }
        logger.info("=== " + result);
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void updateEnableFlagByUuid() {
        String uuid = "3";
        short enableFlag = 0;
        int result = 0;
        try {
            result = parkCarportServiceImpl.updateEnableFlagByUuid(uuid, enableFlag);
        } catch (Exception e) {
            logger.info("=== " + e.getMessage());
        }
        logger.info("=== " + result);
    }


    @Test
    @Transactional
    @Rollback(true)
    public void batchDeleteCarports() {
        List<String> ids = new ArrayList<>();
        ids.add("889d2cfa477f488585c8bc8418a6cb732");
        int result = parkCarportServiceImpl.deleteByIds(ids);
        logger.info("=== " + result);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void batchDeleteCarports1() {
        List<String> ids = new ArrayList<>();
        ids.add("1");
        int result = parkCarportServiceImpl.deleteByIds(ids);
        logger.info("=== " + result);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void selectPageList() {
        CarportCondition condition = new CarportCondition();
        condition.setPageSize(35);
        condition.setCurrentPage(1);
        condition.setCarportCode(null);
        Page<ParkCarport> page = parkCarportServiceImpl.selectPageList(condition);
        logger.info("=== " + JSON.toJSONString(page));
    }

    @Test
    @Transactional
    @Rollback(true)
    public void selectList() {
        CarportCondition condition = new CarportCondition();
        condition.setCarportCode("hd000001");
        List<ParkCarport> list = parkCarportServiceImpl.selectList(condition);
        logger.info("=== " + JSON.toJSONString(list));
    }

    @Test
    @Transactional
    @Rollback(true)
    public void selectByParkId() {
        CarportCondition condition = new CarportCondition();
        Page<ParkCarport> page = parkCarportServiceImpl.selectByParkId(condition);
        logger.info("=== " + JSON.toJSONString(page));
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void selectByPrimaryKey() {
        ParkCarport parkCarport = parkCarportServiceImpl.selectByPrimaryKey("2331");
        logger.info("=== " + JSON.toJSONString(parkCarport));
    }
}
