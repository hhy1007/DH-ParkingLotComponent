/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import com.alibaba.fastjson.JSONObject;
import com.eg.egsc.framework.client.core.ClientConfig;
import com.eg.egsc.scp.parkinglotcomponent.service.park.ParkSelfFeesService;
import com.eg.egsc.scp.parkinglotcomponent.service.park.dto.ReFeesDto;

/**
 * @Class Name TestParkSelfFeesSerivce
 * @Author wangziqiang
 * @Create In 2018年1月9日
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClientConfig.class})
public class ParkSelfFeesSerivceTest {

    protected final Logger logger = LoggerFactory.getLogger(ParkSelfFeesSerivceTest.class);

    @Autowired
    private ParkSelfFeesService parkSelfFeesServiceImpl;// 云端查询收费serivce

    @Test
    @Transactional
    @Rollback(false)
    public void testParkSelfFeesSerivce() {
        try {
            String carNum = "粤B-457";
            String nowTime = "2018-01-06 17:19:54";
            ReFeesDto demandFees = parkSelfFeesServiceImpl.demandFees(carNum, "", nowTime);
            logger.info("result :" + JSONObject.toJSONString(demandFees));
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }
}
