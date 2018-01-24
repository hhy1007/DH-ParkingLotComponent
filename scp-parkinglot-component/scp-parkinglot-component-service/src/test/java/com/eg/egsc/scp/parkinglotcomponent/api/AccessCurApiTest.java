/**
 * @Probject Name: scp-parkinglot-component-service
 * @Path: com.eg.egsc.scp.parkinglotcomponent.apiAccessCurApiTest.java
 * @Create By wangziqiang
 * @Create In 2018年1月16日 上午9:52:50
 */
package com.eg.egsc.scp.parkinglotcomponent.api;

import org.apache.commons.lang.StringUtils;
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
import com.eg.egsc.scp.parkinglotcomponent.dto.access.AccessCurDto;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * AccessCurApiTest 测试
 * 
 * @Class Name AccessCurApiTest
 * @Author wangziqiang
 * @Create In 2018年1月16日
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClientConfig.class})
public class AccessCurApiTest {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    /**
     * 封装一个公共的测试对象
     * 
     * @return
     * @throws Exception RequestDto<UserDto>
     */
    public RequestDto<AccessCurDto> newMockRequestDto(String parm1 , String parm2,String flag1) {
        RequestDto<AccessCurDto> requestDto = new RequestDto<>();
        AccessCurDto accessCurDto = new AccessCurDto();
        if(StringUtils.isNotBlank(flag1)) {
            accessCurDto.setCardNumber(parm1);
            accessCurDto.setNowTime(parm2);           
        }else {
            accessCurDto.setCardNumber(parm1);
            accessCurDto.setMoney(parm2);           
        }

        Header header = new Header();
        header.setBusinessId("testid");
        header.setSourceSysId("test");
        header.setTargetSysId("13214");
        header.setContentType("json");
        header.setCharset("utf-8");
        header.setCreateTimestamp(Long.parseLong("1512109614834"));
        requestDto.setHeader(header);
        requestDto.setData(accessCurDto);
        return requestDto;
    }


    @Test
    @Transactional
    @Rollback(true)
    /**
     * selectAccessCurByExampleTest api 测试
     * 
     * @Methods Name selectAccessCurByExampleTest
     * @Create In 2018年1月16日 By wangziqiang void
     */
    public void selectAccessCurByExampleTest() {
        try {
            RequestDto<AccessCurDto> requestDto = this.newMockRequestDto("123456","2018-01-17 18:50:02","1");
            ObjectMapper objectMapper = new ObjectMapper();
            String dto = objectMapper.writeValueAsString(requestDto);

            RequestBuilder request = MockMvcRequestBuilders.post("/api/access/getAccessCur")
                    .contentType(MediaType.APPLICATION_JSON).content(dto.getBytes());

            mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print()).andReturn();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    /**
     * selectAccessCurByExampleTest api 测试
     * 
     * @Methods Name selectAccessCurByExampleTest
     * @Create In 2018年1月16日 By wangziqiang void
     */
    public void updateAccessCurByExampleTest() {
        try {
            RequestDto<AccessCurDto> requestDto = this.newMockRequestDto("123456","20.00","");
            ObjectMapper objectMapper = new ObjectMapper();
            String dto = objectMapper.writeValueAsString(requestDto);

            RequestBuilder request = MockMvcRequestBuilders.post("/api/access/updateAccessCur")
                    .contentType(MediaType.APPLICATION_JSON).content(dto.getBytes());

            mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print()).andReturn();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

}
