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
import com.eg.egsc.scp.parkinglotcomponent.condition.carcapture.CarCaptureCondition;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.CarModeType;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarCapture;
import com.eg.egsc.scp.parkinglotcomponent.service.carcapture.CarCaptureService;
import com.eg.egsc.scp.parkinglotcomponent.util.UuidUtil;

/**
 * @Class Name CarCarp
 * @Author xiaoxiaojie
 * @Create In 2018年1月15日
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClientConfig.class})
public class CarCaptureServiceTest {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private CarCaptureService carCaptureServiceImpl;

    @Test
    @Transactional
    @Rollback(true)
    public void testInsertCarCapture() {
        ParkCarCapture parkCarCapture = new ParkCarCapture();
        parkCarCapture.setChannelId(UuidUtil.generate());
        parkCarCapture.setCreateTime(new Date());
        parkCarCapture.setImgUrl("http://wwwaa.hdsc/parkinglotcompoment/imgeqer");
        parkCarCapture.setCarMode(CarModeType.SMALLCAR.getType());
        parkCarCapture.setDirect(Short.valueOf("1"));
        parkCarCapture.setCarNum("asdfasd");
        try {
            carCaptureServiceImpl.insert(parkCarCapture);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testUpdateCarCapture() {
        ParkCarCapture parkCarCapture = new ParkCarCapture();
        parkCarCapture.setChannelId(UuidUtil.generate());
        parkCarCapture.setDirect(Short.valueOf("1"));
        parkCarCapture.setCarMode(CarModeType.SMALLCAR.getType());
        parkCarCapture.setCreateTime(new Date());
        parkCarCapture.setImgUrl("http://wwwaa.hdsc/parkinglotcompoment/imgww");
        parkCarCapture.setCarNum("");
        try {
            carCaptureServiceImpl.update(parkCarCapture);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testUpdateCarCapture1() {
        ParkCarCapture parkCarCapture = new ParkCarCapture();
        parkCarCapture.setChannelId(UuidUtil.generate());
        parkCarCapture.setDirect(Short.valueOf("1"));
        parkCarCapture.setCreateTime(new Date());
        parkCarCapture.setImgUrl("http://wwwaa.hdsc/parkinglotcompoment/img2");
        parkCarCapture.setCarMode(CarModeType.SMALLCAR.getType());
        parkCarCapture.setCarNum("粤B-11D11");
        try {
            carCaptureServiceImpl.update(parkCarCapture);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testUpdateCarCapture2() {
        ParkCarCapture parkCarCapture = new ParkCarCapture();
        parkCarCapture.setCarMode(CarModeType.SMALLCAR.getType());
        parkCarCapture.setDirect(Short.valueOf("1"));
        parkCarCapture.setCreateTime(new Date());
        parkCarCapture.setImgUrl("http://wwwaa.hdsc/parkinglotcompoment/imgtwewfs");
        parkCarCapture.setCarNum("粤B-11D11");
        parkCarCapture.setChannelId(UuidUtil.generate());
        parkCarCapture.setUuid(UuidUtil.generate());
        try {
            carCaptureServiceImpl.update(parkCarCapture);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }

    @Test
    @Transactional
    @Rollback(true)
    public void testUpdateCarCapture3() {
        ParkCarCapture parkCarCapture = new ParkCarCapture();
        parkCarCapture.setDirect(Short.valueOf("1"));
        parkCarCapture.setChannelId(UuidUtil.generate());
        parkCarCapture.setCreateTime(new Date());
        parkCarCapture.setImgUrl("http://wwwaa.hdsc/parkinglotcompoment/img1");
        parkCarCapture.setCarNum("XXXXXaaaaqqq");
        parkCarCapture.setCarMode(CarModeType.SMALLCAR.getType());
        parkCarCapture.setUuid(UuidUtil.generate());
        try {
            carCaptureServiceImpl.update(parkCarCapture);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }

    @Test
    @Transactional
    @Rollback(true)
    public void testSelectByPrimaryKey() {
        try {
            carCaptureServiceImpl.selectByPrimaryKey("");
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        carCaptureServiceImpl.selectByPrimaryKey(UuidUtil.generate());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testSelectList() {
        CarCaptureCondition condition = new CarCaptureCondition();
        condition.setId(UuidUtil.generate());
        condition.setCarNum("湘A-aaw12");
        condition.setCapTime(new Date());
        condition.setCameraCode("buwafaswwssaaweer");
        condition.setCameraName("设备A");
        condition.setChannelId(UuidUtil.generate());
        condition.setCarBrand("aweezz");
        condition.setCarMode(CarModeType.BIGCART.getType());
        carCaptureServiceImpl.selectPageList(condition);
        carCaptureServiceImpl.selectList(condition);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testDeleteById() {
        carCaptureServiceImpl.deleteById(UuidUtil.generate());
    }
}
