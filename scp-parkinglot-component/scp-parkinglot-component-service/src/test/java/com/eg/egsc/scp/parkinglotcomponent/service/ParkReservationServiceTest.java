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
import com.eg.egsc.scp.parkinglotcomponent.common.result.ResultMessage;
import com.eg.egsc.scp.parkinglotcomponent.condition.reservation.ParkReservationCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkReservation;
import com.eg.egsc.scp.parkinglotcomponent.service.reservation.ParkReservationService;
import com.eg.egsc.scp.parkinglotcomponent.web.reservation.ParkReservationController;
import com.eg.egsc.scp.parkinglotcomponent.web.vo.reservation.ParkReservationVo;

/**
 * @Class Name TestParkReservationService
 * @Author huangyuhong
 * @Create In 2017年12月18日
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClientConfig.class})
public class ParkReservationServiceTest {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource // 自动注入,默认按名称
    private ParkReservationService parkReservationServiceImpl;
    
    @Autowired
    private ParkReservationController parkReservationController;
    
    @Test
    public void testSelectPageList() throws InstantiationException, IllegalAccessException {
      ParkReservationCondition condition = new ParkReservationCondition();
      condition.setCarNum("23");
      ResultMessage resultMessage = parkReservationController.selectPageList(condition);
      logger.info("=== " + resultMessage);
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void testDeleteParkCarport() {
      List<String> ids = new ArrayList<>();
      ids.add("13");
      ResultMessage resultMessage = parkReservationController.deleteParkCarport(ids);
      logger.info("=== " + resultMessage);
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void testUpdateParkReservation() {
      ParkReservationVo parkReservationVo = new ParkReservationVo();
      parkReservationVo.setUuid("d37efd0b1d564d16bd38e32f0a474f00");
      parkReservationVo.setCarNum("浙A22221");
      parkReservationVo.setParkCode("1112");
      parkReservationVo.setSerialNumber("2223");
      parkReservationVo.setAccessId("3332");
      parkReservationVo.setConsumerName("55551");
      parkReservationVo.setPhoneNumber("130293527733");
      parkReservationVo.setExitModel((short) 1);
      parkReservationVo.setEnterModel((short) 1);
      parkReservationVo.setCreateTime(new Date());
      parkReservationVo.setCreateUser("666665");
      ResultMessage resultMessage = parkReservationController.updateParkReservation(parkReservationVo);
      logger.info("=== " + resultMessage);
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void testCreateParkReservation() {
      ParkReservationVo parkReservationVo = new ParkReservationVo();
      parkReservationVo.setCarNum("浙A2222");
      parkReservationVo.setParkCode("111");
      parkReservationVo.setSerialNumber("222");
      parkReservationVo.setAccessId("333");
      parkReservationVo.setConsumerName("5555");
      parkReservationVo.setPhoneNumber("1302932773");
      parkReservationVo.setExitModel((short) 1);
      parkReservationVo.setEnterModel((short) 1);
      parkReservationVo.setCreateUser("66666");
      ResultMessage resultMessage = parkReservationController.createParkReservation(parkReservationVo);
      logger.info("=== " + resultMessage);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void insertParkReservation() {

        ParkReservation parkReservation = new ParkReservation();
        parkReservation.setCarNum("浙A22222");
        parkReservation.setParkCode("1111");
        parkReservation.setSerialNumber("2222");
        parkReservation.setAccessId("3333");
        parkReservation.setConsumerName("55555");
        parkReservation.setPhoneNumber("13029382773");
        parkReservation.setExitModel((short) 1);
        parkReservation.setEnterModel((short) 1);
        parkReservation.setCreateUser("666666");
        int result = parkReservationServiceImpl.insert(parkReservation);
        logger.info("=== " + result);
        logger.info("##id: " + parkReservation.getUuid());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void updateParkReservation() {

        ParkReservation parkReservation = new ParkReservation();
        parkReservation.setUuid("d37efd0b1d564d16bd38e32f0a474f00");
        parkReservation.setCarNum("浙A2222");
        parkReservation.setParkCode("111");
        parkReservation.setSerialNumber("222");
        parkReservation.setAccessId("333");
        parkReservation.setConsumerName("5555");
        parkReservation.setPhoneNumber("13029352773");
        parkReservation.setExitModel((short) 1);
        parkReservation.setEnterModel((short) 1);
        parkReservation.setCreateTime(new Date());
        parkReservation.setCreateUser("66666");
        int result = parkReservationServiceImpl.update(parkReservation);
        logger.info("=== " + result);
        logger.info("##id: " + parkReservation.getUuid());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void batchParkReservations() {

        List<String> ids = new ArrayList<>();
        ids.add("123");
        int result = parkReservationServiceImpl.deleteByIds(ids);
        logger.info("=== " + result);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void selectPageList() {
        ParkReservationCondition parkReservationCondition = new ParkReservationCondition();
        parkReservationCondition.setPageSize(10);
        parkReservationCondition.setCurrentPage(1);
        Page<ParkReservation> page =
                parkReservationServiceImpl.selectPageList(parkReservationCondition);
        logger.info("=== " + JSON.toJSONString(page));
    }

    @Test
    @Transactional
    @Rollback(true)
    public void selectList() {
        ParkReservationCondition condition = new ParkReservationCondition();
        condition.setCarNum("231");
        List<ParkReservation> result = parkReservationServiceImpl.selectList(condition);
        logger.info("=== " + result);
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void selectByPrimaryKey() {
        ParkReservation result = parkReservationServiceImpl.selectByPrimaryKey("12334");
        logger.info("=== " + result);
    }

}
