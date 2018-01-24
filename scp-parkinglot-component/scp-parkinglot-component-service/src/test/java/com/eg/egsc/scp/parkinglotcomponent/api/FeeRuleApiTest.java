/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.eg.egsc.framework.client.core.ClientConfig;
import com.eg.egsc.framework.client.dto.Header;
import com.eg.egsc.framework.client.dto.RequestDto;
import com.eg.egsc.scp.parkinglotcomponent.dto.rule.FeeRuleDto;
import com.eg.egsc.scp.parkinglotcomponent.dto.rule.RequestFeeRuleDto;
import com.eg.egsc.scp.parkinglotcomponent.enmus.rule.RuleType;
import com.eg.egsc.scp.parkinglotcomponent.util.DateUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author fengrongjun
 * @since 2018年1月17日
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClientConfig.class})
public class FeeRuleApiTest {
    
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private MockMvc mockMvc;
    
    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
    
    private static String detail1 =
            "[{\"available\":\"false\",\"carType\":0,\"chargeDetailDto\":{\"nonPeakPeriodDto\":"
                    + "{\"cash\":300,\"each\":50,\"endTime\":\"7:00\",\"startTime\":\"21:00\"},\"peakPeriodDto\":{\"cash\":400,\"each\":50,"
                    + "\"endTime\":\"21:00\",\"startTime\":\"7:00\"}},\"freeTime\":{\"isContain\":\"false\",\"time\":60},"
                    + "\"highestFee\":5000},{\"available\":"
                    + "\"true\",\"carType\":1,\"chargeDetailDto\":{\"nonPeakPeriodDto\":{\"cash\":400,\"each\":50,"
                    + "\"endTime\":\"7:00\",\"startTime\":\"21:00\"},"
                    + "\"peakPeriodDto\":{\"cash\":300,\"each\":50,\"endTime\":\"21:00\",\"startTime\":\"7:00\"}},"
                    + "\"freeTime\":{\"isContain\":\"false\","
                    + "\"time\":50},\"highestFee\":5000},{\"available\":\"false\",\"carType\":2,\"chargeDetailDto\":"
                    + "{\"nonPeakPeriodDto\":{\"cash\":400,\"each\":50,\"endTime\""
                    + ":\"7:00\",\"startTime\":\"21:00\"},\"peakPeriodDto\":{\"cash\":300,\"each\":50,\"endTime\":\"21:00\","
                    + "\"startTime\":\"7:00\"}},\"freeTime\":{\"isContain\":"
                    + "\"false\",\"time\":40},\"highestFee\":4000},{\"available\":\"true\",\"carType\":3,\"chargeDetailDto\":"
                    + "{\"nonPeakPeriodDto\":{\"cash\":400,\"each\":50,\"endTime\""
                    + ":\"7:00\",\"startTime\":\"21:00\"},\"peakPeriodDto\":{\"cash\":300,\"each\":50,\"endTime\":\"21:00\","
                    + "\"startTime\":\"7:00\"}},\"freeTime\":"
                    + "{\"isContain\":\"true\",\"time\":30},\"highestFee\":4000}]";

    @Test
    @Transactional
    @Rollback(true)
    public void feeRuleApi() {
        RequestFeeRuleDto requestFeeRuleDto = new RequestFeeRuleDto();
        requestFeeRuleDto.setCarType(0);
        requestFeeRuleDto.setStartTime(DateUtil.stringToDate("2108-01-15 16:23:00", DateUtil.YYYY_MM_DD_HH_MM_SS));
        requestFeeRuleDto.setEndTime(DateUtil.stringToDate("2108-01-15 18:23:00", DateUtil.YYYY_MM_DD_HH_MM_SS));
        FeeRuleDto feeRuleDto = new FeeRuleDto();
        feeRuleDto.setRuleType(RuleType.INTERVAL.getType());
        feeRuleDto.setDetail(detail1);
        requestFeeRuleDto.setFeeRuleDto(feeRuleDto);
        RequestDto<RequestFeeRuleDto> requestDto = new RequestDto<>();
        Header header = new Header();
        header.setBusinessId("testid");
        header.setSourceSysId("test");
        header.setTargetSysId("13214");
        header.setContentType("json");
        header.setCharset("utf-8");
        header.setCreateTimestamp(Long.parseLong("1512109614834"));
        requestDto.setHeader(header);
        requestDto.setData(requestFeeRuleDto);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String dto = objectMapper.writeValueAsString(requestDto);
            RequestBuilder request = MockMvcRequestBuilders.post("/api/rule/feeRule")
                    .contentType(MediaType.APPLICATION_JSON).content(dto.getBytes());

            mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print()).andReturn();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
