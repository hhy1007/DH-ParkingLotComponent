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
import com.eg.egsc.scp.parkinglotcomponent.condition.cur.ParkedCarportCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkedHis;
import com.eg.egsc.scp.parkinglotcomponent.service.parked.ParkedHisService;
import com.eg.egsc.scp.parkinglotcomponent.web.vo.parked.ParkedHisVo;

/**
 * 历史车位表测试
 * 
 * @author liudongteng
 * @since 2018年1月16日
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClientConfig.class})
public class ParkedHisServiceTest {
  private final Logger logger = LoggerFactory.getLogger(ParkedHisServiceTest.class);
  @Resource
  private ParkedHisService parkedHisServiceImpl;

  @Test
  @Transactional
  @Rollback(true)
  public void testSelectByCarportCode() {
    try {
      String carportCode = "01";
      List<ParkParkedHis> parkParkedHis = parkedHisServiceImpl.selectByCarportCode(carportCode);
      logger.info("=== " + JSON.toJSONString(parkParkedHis));
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
  }

  @Test
  @Transactional
  @Rollback(true)
  public void testSelectByCarNum() {
    try {
      String carNum = "0111";
      List<ParkParkedHis> parkParkedHis = parkedHisServiceImpl.selectByCarportCode(carNum);
      logger.info("=== " + JSON.toJSONString(parkParkedHis));
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
  }

  @Test
  public void testparkedHisVoGet() {
    ParkedHisVo parkedHisVo = new ParkedHisVo();
    try {
      parkedHisVo.getCarNum();
      parkedHisVo.getCarportCode();
      parkedHisVo.getImgUrl();
      parkedHisVo.getOwnerId();
      parkedHisVo.getParkDate();
      parkedHisVo.getParkType();
      parkedHisVo.getUuid();
      parkedHisVo.getParkStart();
      logger.info("parkedHisVo=" + parkedHisVo.toString());
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
  }

  @Test
  public void testparkedHisVoSet() {
    ParkedHisVo parkedHisVo = new ParkedHisVo();
    try {
      parkedHisVo.setCarNum("122");
      parkedHisVo.setCarportCode("粤B-122");
      parkedHisVo.setImgUrl("2");
      parkedHisVo.setOwnerId("12");
      parkedHisVo.setParkDate(new Date());
      parkedHisVo.setParkStart(new Date());
      parkedHisVo.getUuid();
      logger.info("parkedHisVoSet=" + parkedHisVo.convertVOToPO());
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
  }

  @Test
  public void testParkedCarportConditionGet() {
    try {
      ParkedCarportCondition parkedCarportCondition = new ParkedCarportCondition();
      parkedCarportCondition.getUuid();
      parkedCarportCondition.getCarportCode();
      parkedCarportCondition.getCarportName();
      logger.info("parkedCarportCondition=" + parkedCarportCondition);
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
  }
}
