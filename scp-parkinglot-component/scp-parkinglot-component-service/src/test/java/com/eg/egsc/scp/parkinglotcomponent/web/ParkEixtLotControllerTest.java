/**
 * @Probject Name: scp-parkinglot-component-service
 * @Path: com.eg.egsc.scp.parkinglotcomponent.webParkEixtLotControllerTest.java
 * @Create By wangziqiang
 * @Create In 2018年1月18日 上午11:50:27
 */
package com.eg.egsc.scp.parkinglotcomponent.web;

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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.support.GenericWebApplicationContext;

import com.eg.egsc.framework.client.core.ClientConfig;
import com.eg.egsc.scp.parkinglotcomponent.service.ParkEixtLotServiceTest;
import com.eg.egsc.scp.parkinglotcomponent.service.integration.dto.CarInOutDto;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 出场controllerTest
 * 
 * @Class Name ParkEixtLotControllerTest
 * @Author wangziqiang
 * @Create In 2018年1月18日
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes= {ClientConfig.class})
public class ParkEixtLotControllerTest extends ParkEixtLotServiceTest {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private MockMvc mockMvc;

    @Autowired
    private GenericWebApplicationContext wac;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        SpringBootMockServletContext servletContext =
                (SpringBootMockServletContext) wac.getServletContext();
        servletContext.setContextPath("/scp-parkinglot-component");
    }

    @Test
    /**
     * 结构存储化Test
     * 
     * @Methods Name exitControlTest
     * @Create In 2018年1月18日 By wangziqiang void
     */
    public void exitControlTest() {
        CarInOutDto carInOut = super.getCarInOut();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String dto = objectMapper.writeValueAsString(carInOut);

            RequestBuilder request = MockMvcRequestBuilders.post("/park/exitControl/insert")
                    .contentType(MediaType.APPLICATION_JSON).content(dto.getBytes());
            
            mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e1) {
            logger.error(e1.getMessage());
        }
    }

    @Test
    /**
     * 出场初始化Test
     * 
     * @Methods Name exitControlTest
     * @Create In 2018年1月18日 By wangziqiang void
     */
    public void initCarDtoControlTest() {
        try {
            MvcResult result = mockMvc
                    .perform(MockMvcRequestBuilders.get("/park/initCarDtoControl/get?devCode=222&carNum=粤B-457&imgUrl=http://www.hdsc/parkinglotcompoment/imgUrl&numUrl=http://www.hdsc/parkinglotcompoment/numberUrl")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn();
            logger.info("result :  {}"+result.getResponse().getContentAsString());
            
        } catch (Exception e1) {
            logger.error(e1.getMessage());
        }
    }
     
    
}
