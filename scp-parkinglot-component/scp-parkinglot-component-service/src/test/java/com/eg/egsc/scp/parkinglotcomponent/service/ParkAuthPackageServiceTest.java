/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service;

import java.util.ArrayList;
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
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.condition.authpackage.ParkAuthPackageCondition;
import com.eg.egsc.scp.parkinglotcomponent.condition.car.CarDevRelConditon;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.CarDevRelOptType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.CarDevRelStatus;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.authpackage.AuthPackageMapper;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.authpackage.entity.AuthPackage;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.car.CarDevRelMapper;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.channel.ChannelMapper;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.channel.entity.ChannelRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarDevRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkPackageCarRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkPackageParkRel;
import com.eg.egsc.scp.parkinglotcomponent.service.authpackage.ParkAuthPackageService;
import com.eg.egsc.scp.parkinglotcomponent.service.authpackage.dto.AuthPackageDto;


/**
 * @Class Name TestParkPackageService
 * @Author huangyuhong
 * @Create In 2017年12月20日
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClientConfig.class})
public class ParkAuthPackageServiceTest {
    
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParkAuthPackageService parkAuthPackageServiceImpl;
    
    @Autowired
    private AuthPackageMapper authPackageMapper;
    
    @Test
    @Transactional
    @Rollback(true)
    public void insertParkPackage() {
        
        AuthPackage pPackage = new AuthPackage();
        pPackage.setOwnerId("1233a");
        pPackage.setCarportCode("a88942363231b");
        pPackage.setParkRuleId("3232323c");
        pPackage.setCarportType((short)2);
        pPackage.setMemo("a32323d");
        ParkPackageParkRel p1 = new ParkPackageParkRel();
        ParkPackageParkRel p2 = new ParkPackageParkRel();
        p1.setParkCode("HD001");
        p2.setParkCode("234f");
        pPackage.getParkPackageParkRel().add(p1);
        pPackage.getParkPackageParkRel().add(p2);
        ParkPackageCarRel c1 = new ParkPackageCarRel();
        ParkPackageCarRel c2 = new ParkPackageCarRel();
        c1.setCarNum("s22323g");
        c2.setCarNum("t33223h");
        pPackage.getParkPackageCarRel().add(c1);
        pPackage.getParkPackageCarRel().add(c2);
        int result = parkAuthPackageServiceImpl.insert(pPackage);
        
        logger.info("=== " + result);
        logger.info("##id: " + pPackage.getId());
        
    }
    
    
    @Test
    @Transactional
    @Rollback(true)
    public void updateParkPackage() {

        AuthPackage pPackage = new AuthPackage();
        pPackage.setId("a27f88fee4794af79f3e4c9a6c352a93");
        pPackage.setOwnerId("1233q");
        pPackage.setCarportCode("CW004w");
        pPackage.setParkRuleId("3232323e");
        pPackage.setCarportType((short)2);
        pPackage.setMemo("a32323r");
        ParkPackageParkRel p1 = new ParkPackageParkRel();
        p1.setParkCode("123t");
        ParkPackageParkRel p2 = new ParkPackageParkRel();
        p2.setParkCode("234y");
        pPackage.getParkPackageParkRel().add(p1);
        pPackage.getParkPackageParkRel().add(p2);
        ParkPackageCarRel c1 = new ParkPackageCarRel();
        ParkPackageCarRel c2 = new ParkPackageCarRel();
        c1.setCarNum("s22323u");
        c2.setCarNum("s22323g");
        pPackage.getParkPackageCarRel().add(c1);
        pPackage.getParkPackageCarRel().add(c2);
        int result = parkAuthPackageServiceImpl.update(pPackage);
        
        logger.info("=== " + result);
        logger.info("##id: " + pPackage.getId());
        
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void batchDeleteParkPackages() {
        List<String> ids = new ArrayList<>();
        ids.add("a27f88fee4794af79f3e4c9a6c352a93");
        ids.add("03ee60f6b40f4f3596b36adbafce6905");
        int result = parkAuthPackageServiceImpl.deleteByIds(ids);
        logger.info("=== " + result);
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void selectPageList() {
        ParkAuthPackageCondition condition = new ParkAuthPackageCondition();
        condition.setPageSize(10);
        condition.setCurrentPage(1);
        condition.setCarportCode("CW0042");
        Page<AuthPackage> page = parkAuthPackageServiceImpl.selectPageList(condition);
        logger.info("=== " + JSON.toJSONString(page));
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void getMonthCarByOwnerName() {
        
        List<AuthPackageDto> result = null;
        try {
            result = parkAuthPackageServiceImpl.getMonthCarByOwnerName("大2大师傅");
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.info("=== " + JSON.toJSONString(result));
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void getMonthCarByCarNum() {
        
        List<AuthPackageDto> result = null;
        try {
            result = parkAuthPackageServiceImpl.getMonthCarByCarNum("粤B-456");
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.info("=== " + JSON.toJSONString(result));
    }
    
    @Autowired
    private ChannelMapper channelMapper;
    
    @Test
    @Transactional
    @Rollback(true)
    public void channelDevCode() {
        List<String> list = new ArrayList<>();
        list.add("12y3");
        list.add("234i");
        List<ChannelRel> result = channelMapper.selectChannelByParkCodesAndDevType((short)1 ,list);
        logger.info("=== " + JSON.toJSONString(result));
    }
    
    @Autowired
    private CarDevRelMapper carDevRelMapper;
    
    @Test
    @Transactional
    @Rollback(false)
    public void updateStatusByCarNumsAndParkCodes(){
        ParkCarDevRel parkCarDevRel = new ParkCarDevRel();
        parkCarDevRel.setOptType(CarDevRelOptType.ADD.getType());
        parkCarDevRel.setStatus(CarDevRelStatus.SUCCESS.getType());
        
        CarDevRelConditon carDevRelDto = new CarDevRelConditon();
        List<String> carNums = new ArrayList<>();
        carNums.add("s22323m");
        carDevRelDto.setCarNumList(carNums);
        List<String> parkCodes = new ArrayList<>();
        parkCodes.add("123b");
        carDevRelDto.setParkCodeList(parkCodes);
        
        CarDevRelConditon carDevRelDto2 = new CarDevRelConditon();
        List<String> carNums2 = new ArrayList<>();
        carNums2.add("t33223f");
        carDevRelDto2.setCarNumList(carNums2);
        List<String> parkCodes2 = new ArrayList<>();
        parkCodes2.add("234h");
        carDevRelDto2.setParkCodeList(parkCodes2);
        List<CarDevRelConditon> list = new ArrayList<>();
        list.add(carDevRelDto);
        list.add(carDevRelDto2);
        int result = carDevRelMapper.updateStatusByCarNumsAndParkCodes(parkCarDevRel, list);
        logger.info("=== " + JSON.toJSONString(result));
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void selectBycarportCodes() {
        List<String> list = new ArrayList<>();
        list.add("CW003k");
        list.add("CW004d");
        List<AuthPackage> result = authPackageMapper.selectBycarportCodes(list);
        logger.info("=== " + JSON.toJSONString(result));
    }
    
}
