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
import com.eg.egsc.scp.parkinglotcomponent.dto.charge.ChargeOnlineDto;
import com.eg.egsc.scp.parkinglotcomponent.util.DateUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author huangyuhong
 * @since 2018年1月17日
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClientConfig.class})
public class ChargeApiTest {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void chargeOnline() {
        Header header = new Header();
        header.setBusinessId("testid");
        header.setSourceSysId("test");
        header.setTargetSysId("13214");
        header.setContentType("json");
        header.setCharset("utf-8");
        header.setCreateTimestamp(Long.parseLong("1512109614834"));
        ChargeOnlineDto chargeOnlineDto = new ChargeOnlineDto();
        chargeOnlineDto.setCarNum("粤B-777");
        chargeOnlineDto.setCarportCode("CW0000");
        chargeOnlineDto.setCarportType((short)1);
        chargeOnlineDto.setMoney(3000);
        chargeOnlineDto.setMonth(DateUtil.stringToDate("2018-01-09 14:55:45", DateUtil.YYYY_MM_DD_HH_MM_SS));
        RequestDto<ChargeOnlineDto> requestDto = new RequestDto<>();
        requestDto.setHeader(header);
        requestDto.setData(chargeOnlineDto);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String dto = objectMapper.writeValueAsString(requestDto);
            RequestBuilder request = MockMvcRequestBuilders.post("/api/charge/chargeOnline")
                    .contentType(MediaType.APPLICATION_JSON).content(dto.getBytes());

            mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print()).andReturn();
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
        
    }

}
