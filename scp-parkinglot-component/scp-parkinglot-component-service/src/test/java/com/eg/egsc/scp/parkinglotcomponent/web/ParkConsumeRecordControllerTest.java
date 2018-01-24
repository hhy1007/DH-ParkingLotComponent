/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.web.SpringBootMockServletContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.support.GenericWebApplicationContext;

import com.eg.egsc.common.component.utils.DateUtil;
import com.eg.egsc.framework.client.core.ClientConfig;
import com.eg.egsc.scp.parkinglotcomponent.condition.consume.ConsumeRecordCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkConsumeRecord;
import com.eg.egsc.scp.parkinglotcomponent.util.UuidUtil;
import com.eg.egsc.scp.parkinglotcomponent.web.vo.consume.ConsumeRecordVo;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Class Name ParkConsumeRecordControllerTest
 * @Author xiaoxiaojie
 * @Create In 2018年1月18日
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClientConfig.class})
public class ParkConsumeRecordControllerTest {
    
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private MockMvc mockMVC;

    @Autowired
    private GenericWebApplicationContext recordWac;
    
    @Before
    public void setup() {
        mockMVC = MockMvcBuilders.webAppContextSetup(recordWac).build();
        SpringBootMockServletContext servletContext =
                (SpringBootMockServletContext) recordWac.getServletContext();
        servletContext.setContextPath("/scp-parkinglot-component");
    }
    
    public ConsumeRecordCondition mockConsumeRecordCondition() {
        ConsumeRecordVo consumeRecordVo = new ConsumeRecordVo();
        consumeRecordVo.convertPOToVO(new ParkConsumeRecord());
        consumeRecordVo.setSerialNumber(UuidUtil.generate());
        consumeRecordVo.setCardNumber("xsdfewqeqw");
        consumeRecordVo.getSerialNumber();
        consumeRecordVo.setFavorableAmount(21);
        consumeRecordVo.getCardNumber();
        consumeRecordVo.setConsumeAmount(1);
        consumeRecordVo.getFavorableAmount();
        consumeRecordVo.setFeeType((short)2);
        consumeRecordVo.getConsumeAmount();
        consumeRecordVo.setAccessId(UuidUtil.generate());
        consumeRecordVo.setCarNum("sadfweqcvnvbc");
        consumeRecordVo.getFeeType();
        consumeRecordVo.setConsumeTime(DateUtil.addDays(new Date(), 5));
        consumeRecordVo.getAccessId();
        consumeRecordVo.getCarNum();
        consumeRecordVo.setMemo("aswqwr9192");
        consumeRecordVo.getConsumeTime();
        consumeRecordVo.setFavorableTicketNumber("0089873fsdaa");
        consumeRecordVo.getMemo();
        consumeRecordVo.setUuid(UuidUtil.generate());
        consumeRecordVo.getFavorableTicketNumber();
        consumeRecordVo.setFeeAmount(234);
        consumeRecordVo.getUuid();
        consumeRecordVo.setOwnerId("sadqrqweqr211234");
        consumeRecordVo.getFeeAmount();
        consumeRecordVo.setOperatorName("xxjjwer");
        consumeRecordVo.getOwnerId();
        consumeRecordVo.setOperatorId("asdfweqryrtye35234");
        consumeRecordVo.getOperatorName();
        consumeRecordVo.setTimeLength("34123");
        consumeRecordVo.getOperatorId();
        consumeRecordVo.setCreateTime(DateUtil.addHours(new Date(), 2));
        consumeRecordVo.setUpdateTime(DateUtil.addHours(new Date(), 1));
        consumeRecordVo.getTimeLength();
        consumeRecordVo.setCreateUser("asdfw56785");
        consumeRecordVo.getCreateTime();
        consumeRecordVo.getUpdateTime();
        consumeRecordVo.setUpdateUser("qwe5678535652");
        consumeRecordVo.getCreateUser();
        consumeRecordVo.setCourtUuid("098517398157298aehfsdaqe");
        consumeRecordVo.getUpdateUser();
        consumeRecordVo.getCourtUuid();
        consumeRecordVo.convertVOToPO();
        ConsumeRecordCondition consumeRecordCondition = new ConsumeRecordCondition();
        consumeRecordCondition.setFeeType((short)1);
        consumeRecordCondition.setCarNum("");
        consumeRecordCondition.setConsumeStartTime(DateUtil.dateBefore(new Date(), 1));
        consumeRecordCondition.setConsumeEndTime(new Date());
        return consumeRecordCondition;
    }
    
    @Test
    public void testSelectPageList() {
        ObjectMapper objectMapper = new ObjectMapper();
        ConsumeRecordCondition consumeRecordCondition = mockConsumeRecordCondition();
        try {
            String consumeRecordConditionString = objectMapper.writeValueAsString(consumeRecordCondition);
            mockMVC.perform(MockMvcRequestBuilders.get("/consume/listRecords")
                    .contentType(MediaType.APPLICATION_JSON).content(consumeRecordConditionString.getBytes()))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print()).andReturn();
        } catch (Exception e) {
           logger.info(e.getMessage());
        }
    }
}
