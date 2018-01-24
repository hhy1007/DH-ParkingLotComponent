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
import com.eg.egsc.scp.parkinglotcomponent.condition.channel.ChannelRelCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannelRel;
import com.eg.egsc.scp.parkinglotcomponent.service.channel.ParkChannelRelService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClientConfig.class})
public class ParkChannelRelServiceTest {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource // 自动注入,默认按名称
    private ParkChannelRelService parkChannelRelServiceImpl;

    @Test
    @Transactional
    @Rollback(true)
    public void insertChannelRel() {

        ParkChannelRel parkChannelRel = new ParkChannelRel();
        parkChannelRel.setCreateTime(new Date());
        parkChannelRel.setChannelId("2326dbd1426148fbb40af56fec312316");
        parkChannelRel.setControlType((short) 233);
        parkChannelRel.setCreateUser("234");
        parkChannelRel.setDevCode("235");
        parkChannelRel.setDevType((short) 1);
        int result = 0;
        try {
            result = parkChannelRelServiceImpl.insert(parkChannelRel);
        } catch (Exception e) {
            logger.info("=== " + e.getMessage());
        }
        logger.info("=== " + result);
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void insertChannelRel1() {

        ParkChannelRel parkChannelRel1 = new ParkChannelRel();
        parkChannelRel1.setCreateTime(new Date());
        parkChannelRel1.setChannelId("a5c5813f29c54146807f4eed2b6d4124");
        parkChannelRel1.setControlType((short) 233);
        parkChannelRel1.setCreateUser("234");
        parkChannelRel1.setDevCode("555");
        parkChannelRel1.setDevType((short) 1);
        int result = 0;
        try {
            result = parkChannelRelServiceImpl.insert(parkChannelRel1);
        } catch (Exception e) {
            logger.info("=== " + e.getMessage());
        }
        logger.info("=== " + result);
    }


    @Test
    @Transactional
    @Rollback(true)
    public void updateChannelRel() {
        ParkChannelRel parkChannelRel = new ParkChannelRel();
        parkChannelRel.setChannelId("2326dbd1426148fbb40af56fec312316");
        parkChannelRel.setControlType((short) 222);
        parkChannelRel.setDevCode("222");
        parkChannelRel.setDevType((short) 2);
        parkChannelRel.setUpdateTime(new Date());
        parkChannelRel.setUpdateUser("223");
        parkChannelRel.setUuid("2222");
        int result = 0;
        try {
            result = parkChannelRelServiceImpl.update(parkChannelRel);
        } catch (Exception e) {
            logger.info("=== " + e.getMessage());
        }
        logger.info("=== " + result);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void updateChannelRel1() {
        ParkChannelRel parkChannelRel1 = new ParkChannelRel();
        parkChannelRel1.setChannelId("a5c5813f29c54146807f4eed2b6d4124");
        parkChannelRel1.setControlType((short) 2222);
        parkChannelRel1.setDevCode("999");
        parkChannelRel1.setDevType((short) 1);
        parkChannelRel1.setUpdateTime(new Date());
        parkChannelRel1.setUpdateUser("admin");
        parkChannelRel1.setUuid("312321231kjj12nkda");
        int result = 0;
        try {
            result = parkChannelRelServiceImpl.update(parkChannelRel1);
        } catch (Exception e) {
            logger.info("=== " + e.getMessage());
        }
        logger.info("=== " + result);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void batchDeleteChannelRels() {
        List<String> ids = new ArrayList<>();
        ids.add("22223");
        int result = parkChannelRelServiceImpl.deleteByIds(ids);
        logger.info("=== " + result);
    }


    @Test
    @Transactional
    @Rollback(true)
    public void selectPageList() {
        ChannelRelCondition condition = new ChannelRelCondition();
        condition.setPageSize(40);
        condition.setCurrentPage(1);
        condition.setChannelId("13110f84173946dfa6ac4ef06e140f8b");
        Page<ParkChannelRel> page = parkChannelRelServiceImpl.selectPageList(condition);
        logger.info("=== " + JSON.toJSONString(page));
    }

    @Test
    @Transactional
    @Rollback(true)
    public void selectList() {
        ChannelRelCondition condition = new ChannelRelCondition();
        condition.setChannelId("daf80add93bf4116a7b1caa145887c45");
        List<ParkChannelRel> list = parkChannelRelServiceImpl.selectList(condition);
        logger.info("=== " + JSON.toJSONString(list));
    }

    @Test
    @Transactional
    @Rollback(true)
    public void selectChannelRelByIds() {
        List<String> channeIds = new ArrayList<>();
        List<ParkChannelRel> list = parkChannelRelServiceImpl.selectChannelRelByIds(channeIds);
        logger.info("=== " + JSON.toJSONString(list));
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void selectChannelRelByDevCode(){
        String devCode = "444";
        List<ParkChannelRel> channelRelList = parkChannelRelServiceImpl.selectChannelRelByDevCode(devCode);
        logger.info("=== " + JSON.toJSONString(channelRelList));
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void deleteByDevCode() {
        String devCode = "222";
        int result = parkChannelRelServiceImpl.deleteByDevCode(devCode);
        logger.info("=== " + JSON.toJSONString(result));
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void selectByPrimaryKey() {
        ParkChannelRel parkChannelRel = parkChannelRelServiceImpl.selectByPrimaryKey("2331454df");
        logger.info("=== " + JSON.toJSONString(parkChannelRel));
    }
}
