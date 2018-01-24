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

import com.alibaba.fastjson.JSON;
import com.eg.egsc.framework.client.core.ClientConfig;
import com.eg.egsc.scp.parkinglotcomponent.condition.access.AccessHisCondition;
import com.eg.egsc.scp.parkinglotcomponent.enmus.access.PayedMoney;
import com.eg.egsc.scp.parkinglotcomponent.enmus.alarm.CarType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.CarEnterMode;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.CarModeType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.CarStatus;
import com.eg.egsc.scp.parkinglotcomponent.enmus.carport.CarportType;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAccessHis;
import com.eg.egsc.scp.parkinglotcomponent.service.park.ParkAccessHisService;
import com.eg.egsc.scp.parkinglotcomponent.util.UuidUtil;
import com.eg.egsc.scp.parkinglotcomponent.web.vo.access.AccesshisVo;

/**
 * @Class Name ParkAccessHisServiceTest
 * @Author xiaoxiaojie
 * @Create In 2018年1月16日
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClientConfig.class})
public class ParkAccessHisServiceTest {
    
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Resource
    private ParkAccessHisService parkAccessHisServiceImpl;
    
    @Test
    @Transactional
    @Rollback(true)
    public void testInsertAccessHis() {
        ParkAccessHis parkAccessHis = new ParkAccessHis();
        parkAccessHis.setParkCode("hdswxwq");
        try {
            parkAccessHisServiceImpl.insert(parkAccessHis);
        } catch (Exception e) {
           logger.info(e.getMessage());
        }
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void testInsertAccessHis1() {
        ParkAccessHis parkAccessHis = new ParkAccessHis();
        parkAccessHis.setCarNum("粤A-awed");
        try {
            parkAccessHisServiceImpl.insert(parkAccessHis);
        } catch (Exception e) {
           logger.info(e.getMessage());
        }
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void testInsertAccessHis2() {
        ParkAccessHis parkAccessHis = new ParkAccessHis();
        parkAccessHis.setCarNum("粤A-awed");
        parkAccessHis.setParkCode("hdswxwerqq00q");
        try {
            parkAccessHisServiceImpl.insert(parkAccessHis);
        } catch (Exception e) {
           logger.info(e.getMessage());
        }
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void testUpdateAccessHis() {
        ParkAccessHis parkAccessHis = new ParkAccessHis();
        parkAccessHis.setUuid(UuidUtil.generate());
        parkAccessHis.setParkCode("hdswxawwwq");
        try {
            parkAccessHisServiceImpl.update(parkAccessHis);
        } catch (Exception e) {
           logger.info(e.getMessage());
        }
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void testUpdateAccessHis1() {
        ParkAccessHis parkAccessHis = new ParkAccessHis();
        parkAccessHis.setUuid(UuidUtil.generate());
        parkAccessHis.setCarNum("粤A-a11wed");
        try {
            parkAccessHisServiceImpl.update(parkAccessHis);
        } catch (Exception e) {
           logger.info(e.getMessage());
        }
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void testUpdateAccessHis2() {
        ParkAccessHis parkAccessHis = new ParkAccessHis();
        parkAccessHis.setCarNum("粤A-a1Ae1wed");
        parkAccessHis.setParkCode("liyxx1122");
        try {
            parkAccessHisServiceImpl.update(parkAccessHis);
        } catch (Exception e) {
           logger.info(e.getMessage());
        }
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void testUpdateAccessHis3() {
        ParkAccessHis parkAccessHis = new ParkAccessHis();
        parkAccessHis.setUuid(UuidUtil.generate());
        parkAccessHis.setCarNum("粤A-a12232");
        parkAccessHis.setParkCode("lUdwwdz");
        try {
            parkAccessHisServiceImpl.update(parkAccessHis);
        } catch (Exception e) {
           logger.info(e.getMessage());
        }
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void testSelectByPrimaryKey() {
        ParkAccessHis accessHis = parkAccessHisServiceImpl.selectByPrimaryKey("xwerwllio");
        logger.info("result="+JSON.toJSONString(accessHis));
        parkAccessHisServiceImpl.deleteById("asdfada");
        try {
            parkAccessHisServiceImpl.selectByPrimaryKey("");
        } catch (Exception e) {
           logger.info(e.getMessage());
        }
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void testSelectByCarNumAndParkCode() {
        try {
            parkAccessHisServiceImpl.selectByCarNumAndParkCode("粤D-a12232", "");
        } catch (Exception e) {
           logger.info(e.getMessage());
        }
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void testSelectByCarNumAndParkCode1() {
        try {
            parkAccessHisServiceImpl.selectByCarNumAndParkCode("", "XJUEE");
        } catch (Exception e) {
           logger.info(e.getMessage());
        }
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void testSelectByCarNumAndParkCode2() {
        try {
            parkAccessHisServiceImpl.selectByCarNumAndParkCode("粤D-a1WR32", "XJUEE");
        } catch (Exception e) {
           logger.info(e.getMessage());
        }
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void testSelectPageList() {
        AccessHisCondition condition = new AccessHisCondition();
        condition.setId(UuidUtil.generate());
        condition.setCarNum("琼B-asdfaa");
        condition.setParkCode("lieeaa");
        condition.setCardNumber("xww1122466");
        condition.setInTime(new Date());
        condition.setInCameraCode("eufa73274afx");
        condition.setInSluiceCode("zweqvbnko");
        condition.setOutCarNum("琼B-asdfaaqweq");
        condition.setOutTime(new Date());
        condition.setCarType(CarType.TEMPORARY.getType());
        condition.setCarStatus(CarStatus.ENTER.getStatus());
        condition.setForceOperator("dafwery");
        parkAccessHisServiceImpl.selectList(condition);
        parkAccessHisServiceImpl.selectPageList(condition);
        
    }
    
    @Test
    public void testAccessHisVo() {
        AccesshisVo accesshisVo = new AccesshisVo();
        accesshisVo.setOutCarNum("xewer");
        accesshisVo.setCarMode(CarModeType.getEnum("0").getType());
        accesshisVo.setCarType(CarType.getEnum((short)0).getType());
        accesshisVo.setEnterMode(CarEnterMode.getEnum((short)1).getType());
        accesshisVo.setInImgUrl("xweerweq,uy");
        accesshisVo.setCreateTime(new Date());
        accesshisVo.setInChannelId(UuidUtil.generate());
        accesshisVo.setCarportType(CarportType.getEnum((short)0).getType());
        accesshisVo.setLastPayedTime(new Date());
        
        accesshisVo.setCarNum("x89xewer");
        accesshisVo.setCardNumber("poewr122123");
        accesshisVo.setInCameraCode(UuidUtil.generate());
        accesshisVo.setOwnerId(UuidUtil.generate());
        accesshisVo.setUpdateTime(new Date());
        accesshisVo.setCarStatus(CarStatus.getEnum((short)1).getStatus());
        accesshisVo.setParkCode("dafrqwer");
        accesshisVo.setOutMemo("xe1231566");
        
        accesshisVo.setCreateUser("li03485893");
        accesshisVo.setForceOperator("zweqvbnko678345g");
        accesshisVo.setOutCameraCode("324598fdsg");
        accesshisVo.setInSluiceCode("p*^wefasdf");
        accesshisVo.setCreateUser("wangzhidead");
        accesshisVo.setPackageId(UuidUtil.generate());
        accesshisVo.setInMemo("poxadgfew");
        accesshisVo.setPayedMoney(PayedMoney.getEnum(0).getType());
        accesshisVo.setUpdateUser("xiangdaopppp");
        accesshisVo.setUuid(UuidUtil.generate());
        accesshisVo.setOutImgUrl("xpjsda234");
        accesshisVo.setOutChannelId(UuidUtil.generate());
        accesshisVo.convertVOToPO();
        accesshisVo.setCourtUuid(UuidUtil.generate());
        accesshisVo.setOutSluiceCode("sadfque76");
        accesshisVo.getCreateTime();
        accesshisVo.getInChannelId();
        accesshisVo.getCarportType();
        accesshisVo.getLastPayedTime();
        accesshisVo.getOutImgUrl();
        accesshisVo.getOutChannelId();
        accesshisVo.getCourtUuid();
        accesshisVo.getOutSluiceCode();
        accesshisVo.getOutCarNum();
        accesshisVo.getCarType();
        accesshisVo.getCarMode();
        accesshisVo.getEnterMode();
        accesshisVo.getInImgUrl();
        accesshisVo.convertPOToVO(new ParkAccessHis());
        accesshisVo.getPackageId();
        accesshisVo.getInMemo();
        accesshisVo.getPayedMoney();
        accesshisVo.getUpdateUser();
        accesshisVo.getUuid();
        accesshisVo.getCreateUser();
        accesshisVo.getForceOperator();
        accesshisVo.getOutCameraCode();
        accesshisVo.getInSluiceCode();
        accesshisVo.getCreateUser();
    }
}
