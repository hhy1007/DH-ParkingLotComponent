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
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.support.GenericWebApplicationContext;

import com.eg.egsc.framework.client.core.ClientConfig;
import com.eg.egsc.scp.parkinglotcomponent.condition.carcapture.CarCaptureCondition;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.CarColorType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.CarModeType;
import com.eg.egsc.scp.parkinglotcomponent.util.UuidUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Class Name CarCaptureControllerTest
 * @Author xiaoxiaojie
 * @Create In 2018年1月18日
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClientConfig.class})
public class CarCaptureControllerTest {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private MockMvc mockMvc;

    @Autowired
    private GenericWebApplicationContext gweb;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(gweb).build();
        SpringBootMockServletContext servletContext =
                (SpringBootMockServletContext) gweb.getServletContext();
        servletContext.setContextPath("/scp-parkinglot-component");
    }

    public CarCaptureCondition mockCarCaptureCondition() {
        CarCaptureCondition carCaptureCondition = new CarCaptureCondition();
        carCaptureCondition.setChannelId(UuidUtil.generate());
        carCaptureCondition.setCarNum("湘B-zwxw");
        carCaptureCondition.setCarNumColor(CarColorType.YELLOW.getDesc());
        carCaptureCondition.setCarMode(CarModeType.SMALLCAR.getDesc());
        carCaptureCondition.setCapTime(new Date());
        carCaptureCondition.setCameraName("相机121");
        carCaptureCondition.setCameraCode("xewodfhaiuewq");
        return carCaptureCondition;
    }

    @Test
    @Transactional 
    @Rollback(true)
    public void testSelectPageList(){
        CarCaptureCondition captureCondition = this.mockCarCaptureCondition();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String dto = objectMapper.writeValueAsString(captureCondition);
            mockMvc.perform(MockMvcRequestBuilders.get("/carcapture/listCarCaptures")
                    .contentType(MediaType.APPLICATION_JSON).content(dto.getBytes()))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print()).andReturn();
        }catch (Exception e) {
            logger.info(e.getMessage());
        }
    }
    
    @Test
    @Transactional 
    @Rollback(true)
    public void testSelectList(){
        CarCaptureCondition captureCondition = this.mockCarCaptureCondition();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String dto = objectMapper.writeValueAsString(captureCondition);
            mockMvc.perform(MockMvcRequestBuilders.get("/carcapture/export")
                    .contentType(MediaType.APPLICATION_JSON).content(dto.getBytes()))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print()).andReturn();
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }
}
