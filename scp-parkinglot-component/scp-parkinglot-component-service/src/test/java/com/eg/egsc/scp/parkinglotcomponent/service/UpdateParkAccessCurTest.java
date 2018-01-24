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
import com.eg.egsc.framework.client.core.ClientConfig;
import com.eg.egsc.scp.parkinglotcomponent.service.park.ParkSelfFeesService;

/**
 * 更新缴费金额测试类
 * 
 * @Class Name TestUpdateParkAccessCur
 * @Author wangziqiang
 * @Create In 2018年1月10日
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClientConfig.class})
public class UpdateParkAccessCurTest {
    protected final Logger logger = LoggerFactory.getLogger(UpdateParkAccessCurTest.class);
    @Autowired
    private ParkSelfFeesService parkSelfFeesServiceImpl;// 云端查询收费serivce

    @Test
    @Transactional
    @Rollback(true)
    public void testUpdateParkAccessCur() {
        String carNum = "粤B-457";
        String cardNumber = "12";
        String money = "10.00";
        int i;
        try {
            i = parkSelfFeesServiceImpl.updateParkAccessCur(carNum, cardNumber, money);
            logger.info(i + "");
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

}
