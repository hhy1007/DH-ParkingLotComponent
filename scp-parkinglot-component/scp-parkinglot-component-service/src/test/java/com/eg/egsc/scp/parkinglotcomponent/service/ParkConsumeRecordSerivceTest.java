/**
 * @Probject Name: scp-parkinglot-component-service
 * @Path: com.eg.egsc.scp.parkinglotcomponent.serviceParkConsumeRecordSerivceTest.java
 * @Create By wangziqiang
 * @Create In 2018年1月15日 下午9:06:21
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
import com.eg.egsc.scp.parkinglotcomponent.condition.consume.ConsumeRecordCondition;
import com.eg.egsc.scp.parkinglotcomponent.service.consume.ParkConsumeRecordService;

/**
 * 消费记录测试
 * 
 * @Class Name ParkConsumeRecordSerivceTest
 * @Author wangziqiang
 * @Create In 2018年1月15日
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClientConfig.class})
public class ParkConsumeRecordSerivceTest {

    protected final Logger logger = LoggerFactory.getLogger(ParkConsumeRecordSerivceTest.class);
    @Autowired
    private ParkConsumeRecordService parkConsumeRecordServiceImpl;// 消费记录service

    @Test
    @Transactional
    @Rollback(false)
    /**
     * 
     * @Methods Name parkConsumeRecordSerivceTest1
     * @Create In 2018年1月15日 By wangziqiang void
     */
    public void parkConsumeRecordSerivceTest1() {
        ConsumeRecordCondition consumeRecordCondition = new ConsumeRecordCondition();
        consumeRecordCondition.setCarNum("粤B-11111");
        try {
            parkConsumeRecordServiceImpl.selectPageConsumeRecordList(consumeRecordCondition);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }


}
