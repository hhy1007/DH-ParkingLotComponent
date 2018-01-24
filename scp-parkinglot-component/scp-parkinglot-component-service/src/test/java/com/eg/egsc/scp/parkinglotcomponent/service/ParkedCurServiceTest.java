/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service;

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
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkLedCarportRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkedCur;
import com.eg.egsc.scp.parkinglotcomponent.service.parked.ParkedCurService;
import com.eg.egsc.scp.parkinglotcomponent.web.vo.parked.ParkedCurVo;

/**
 * 车位功能的Junit测试类
 *
 * @author gongqian
 * @since 2018年1月12日
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClientConfig.class})
public class ParkedCurServiceTest {

  private final Logger log = LoggerFactory.getLogger(ParkedCurServiceTest.class);

  @Resource
  ParkedCurService parkedCurServiceImpl;

  @Test
  @Transactional
  @Rollback(true)
  public void testUpdateParkingStatus() {
    ParkParkedCur parkParkedCur = new ParkParkedCur();
    parkParkedCur.setUuid("8bf1aa531ac9492eb50bf02f75d880e9");
    getParkParkedCur(parkParkedCur);
    try {
      parkedCurServiceImpl.updateParkingStatus(parkParkedCur);
    } catch (Exception e) {
      log.info("testUpdateParkingStatus Exception=：" + e);
    }
  }

  @Test
  @Transactional
  @Rollback(true)
  public void testUpdateParkingStatus2() {
    ParkParkedCur parkParkedCur = new ParkParkedCur();
    parkParkedCur.setUuid("");
    getParkParkedCur(parkParkedCur);
    try {
      parkedCurServiceImpl.updateParkingStatus(parkParkedCur);
    } catch (Exception e) {
      log.info("testUpdateParkingStatus2 Exception：" + e);
    }
  }

  public void getParkParkedCur(ParkParkedCur parkParkedCur) {
    parkParkedCur.setDeviceCode("001");
    parkParkedCur.setDeviceName("test");
    parkParkedCur.setMapId("100");
    parkParkedCur.setCarportCode("CW002");
    parkParkedCur.setCarNum("粤B-8S5WE");
    parkParkedCur.setCarNumColor("2");
    parkParkedCur.setCarColor("1");
    parkParkedCur.setCarMark("6");
    parkParkedCur.setOwnerId("1002");
    parkParkedCur.setParkStart(new Date());
    parkParkedCur.setParkDate(new Date());
    parkParkedCur.setAlarmStatus((short) 0);
    parkParkedCur.setParkType((short) 1);
    parkParkedCur
        .setImgUrl("http://img1.imgtn.bdimg.com/it/u=2780410695,3219964040&fm=27&gp=0.jpg");
  }

  @Test
  @Transactional
  @Rollback(true)
  public void testUpdateParkingStatus3() {
    try {
      parkedCurServiceImpl.updateParkingStatus(null);
    } catch (Exception e) {
      log.info("testUpdateParkingStatus3 Exception：" + e);
    }
  }

  @Test
  @Transactional
  @Rollback(true)
  public void updateLedCarport() {
    ParkLedCarportRel parkLedCarportRel = new ParkLedCarportRel();
    parkLedCarportRel.setCarportId("6033bb56e30b4790aa640ebd066fd979");
    Integer result = null;
    try {
      result = parkedCurServiceImpl.updateLedCarport(parkLedCarportRel);
    } catch (Exception e) {
      log.info("updateLedCarport Exception：" + e);
    }
    log.info("## result= " + result);
  }


  @Test
  @Transactional
  @Rollback(true)
  public void testSelectByCarportCode() {
    try {
      String carportCode = "001";
      List<ParkParkedCur> parkParkedCur = parkedCurServiceImpl.selectByCarportCode(carportCode);
      log.info("=== " + JSON.toJSONString(parkParkedCur));
    } catch (Exception e) {
      log.error(e.getMessage());
    }
  }

  @Test
  @Transactional
  @Rollback(true)
  public void testSelectByCarNum() {
    try {
      String carNum = "B666";
      List<ParkParkedCur> parkParkedCur = parkedCurServiceImpl.selectByCarportCode(carNum);
      log.info("=== " + JSON.toJSONString(parkParkedCur));
    } catch (Exception e) {
      log.error(e.getMessage());
    }
  }

  @Test
  public void testparkedCurVoGet() {
    ParkedCurVo parkedCurVo = new ParkedCurVo();
    try {
      parkedCurVo.getCarNum();
      parkedCurVo.getCarportCode();
      parkedCurVo.getImgUrl();
      parkedCurVo.getOwnerId();
      parkedCurVo.getParkStart();
      parkedCurVo.getParkType();
      parkedCurVo.getUuid();
      log.info("parkedCurVoGet=" + parkedCurVo.toString());
    } catch (Exception e) {
      log.error(e.getMessage());
    }
  }

  @Test
  public void testparkedCurVoSet() {
    ParkedCurVo parkedCurVo = new ParkedCurVo();
    try {
      parkedCurVo.setCarNum("123");
      parkedCurVo.setCarportCode("456");
      parkedCurVo.setImgUrl("1");
      parkedCurVo.setOwnerId("20");
      parkedCurVo.setParkStart(new Date());
      parkedCurVo.setParkType((short) 2);
      parkedCurVo.getUuid();
      log.info("parkedCurVoSet=" + parkedCurVo.convertVOToPO());
    } catch (Exception e) {
      log.error(e.getMessage());
    }
  }
}
