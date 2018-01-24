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
import com.eg.egsc.scp.parkinglotcomponent.condition.channel.ChannelCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannel;
import com.eg.egsc.scp.parkinglotcomponent.service.channel.ParkChannelService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClientConfig.class})
public class ParkChannelServiceTest {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource // 自动注入,默认按名称
    private ParkChannelService parkChannelServiceImpl;

    @Test
    @Transactional
    @Rollback(true)
    public void insertChannel() {
        ParkChannel parkChannel = new ParkChannel();
        parkChannel.setDirect((short) 239);
        parkChannel.setIp("12622323");
        parkChannel.setName("测试2123adb");
        parkChannel.setParkCode("HD001");
        parkChannel.setCourtUuid("12456545");
        parkChannel.setType((short) 1);
        int result = 0;
        try {
            result = parkChannelServiceImpl.insert(parkChannel);
        } catch (Exception e) {
            logger.info("=== " + e.getMessage());
        }
        logger.info("=== " + result);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void updateChannel() {
        ParkChannel parkChannel = new ParkChannel();
        parkChannel.setDirect((short) 23);
        parkChannel.setIp("125");
        parkChannel.setName("122441");
        parkChannel.setParkCode("21");
        parkChannel.setType((short) 236);
        parkChannel.setUpdateTime(new Date());
        parkChannel.setUpdateUser("w21");
        parkChannel.setUuid("da47dcf7c2594c45beb34bf1d41a2378");
        int result = 0;
        try {
            result = parkChannelServiceImpl.update(parkChannel);
        } catch (Exception e) {
            logger.info("=== " + e.getMessage());
        }
        logger.info("=== " + result);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void batchDeleteChannels() {
        List<String> ids = new ArrayList<>();
        ids.add("88fd25d40ecb4f109cd98ef17d5c0a7d");
        int result = parkChannelServiceImpl.deleteByIds(ids);
        logger.info("=== " + result);
    }


    @Test
    @Transactional
    @Rollback(true)
    public void selectPageList() {
        ChannelCondition condition = new ChannelCondition();
        condition.setPageSize(15);
        condition.setCurrentPage(1);
        condition.setName("fastring");
        Page<ParkChannel> page = parkChannelServiceImpl.selectPageList(condition);
        logger.info("=== " + JSON.toJSONString(page));
    }

    @Test
    @Transactional
    @Rollback(true)
    public void selectList() {
        ChannelCondition condition = new ChannelCondition();
        condition.setName("测试2123");
        List<ParkChannel> list = parkChannelServiceImpl.selectList(condition);
        logger.info("=== " + JSON.toJSONString(list));
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void selectByPrimaryKey() {
        ParkChannel parkChannel = parkChannelServiceImpl.selectByPrimaryKey("afd2331");
        logger.info("=== " + JSON.toJSONString(parkChannel));
    }

}
