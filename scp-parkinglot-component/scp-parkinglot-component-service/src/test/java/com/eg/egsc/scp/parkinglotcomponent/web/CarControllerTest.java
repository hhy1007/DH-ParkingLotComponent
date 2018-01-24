/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.eg.egsc.scp.parkinglotcomponent.condition.car.CarCondition;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.CarColorType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.CarListType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.CarModeType;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCar;
import com.eg.egsc.scp.parkinglotcomponent.util.UuidUtil;
import com.eg.egsc.scp.parkinglotcomponent.web.vo.car.CarVo;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Class Name CarControllerTest
 * @Author xiaoxiaojie
 * @Create In 2018年1月18日
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClientConfig.class})
public class CarControllerTest {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private MockMvc mockMvc;

    @Autowired
    private GenericWebApplicationContext wac;
    
    
    public CarVo getMockCarVo() {
            CarVo carVo = new CarVo();
            ParkCar parkCar = carVo.convertVOToPO();
            carVo.convertPOToVO(parkCar);
            carVo.setValidStartTime(new Date());
            carVo.setCarBrand("asdfweljj");
            carVo.setUpdateUser("xxj1221");
            carVo.setCarCode("xwe23423;uio");
            carVo.setValidEndTime(new Date());
            carVo.setCarMode(CarModeType.BIGCART.getDesc());
            carVo.setCarNum("湘-A2221asd");
            carVo.setUpdateTime(new Date());
            carVo.setCarColor(CarColorType.BLUE.getDesc());
            carVo.setCarNumType((short)2);
            carVo.setCarPic("qq.jpg");
            carVo.setCreateTime(new Date());
            carVo.setUuid(UuidUtil.generate());
            carVo.setCreateUser("xwangzidee");
            carVo.setListType(CarListType.getEnum((short)0).getType());
            carVo.setHouseNo("NO112123");
            carVo.setCarType((short) 2);
            carVo.setMemo("xweweq");
            carVo.setCarNumColor("asfwe");
            logger.info("carVo = "+carVo.toString());
            carVo.getCarColor();
            carVo.getCarNumType();
            carVo.getCarPic();
            carVo.getCreateTime();
            carVo.getUuid();
            carVo.getCreateUser();
            carVo.getListType();
            carVo.getHouseNo();
            carVo.getCarType();
            carVo.getMemo();
            carVo.getCarNumColor();
            carVo.getValidStartTime();
            carVo.getCarBrand();
            carVo.getUpdateUser();
            carVo.getCarCode();
            carVo.getValidEndTime();
            carVo.getCarMode();
            carVo.getCarNum();
            carVo.getUpdateTime();
            return carVo;
    }
    
    public CarCondition mockCarCondition() {
        CarCondition carCondition = new CarCondition();
        carCondition.setCarNum("湘A-212asd");
        carCondition.setValidStartTime(new Date());
        carCondition.setCarColor(CarColorType.BLUE.getDesc());
        carCondition.setId(UuidUtil.generate());
        return carCondition;
    }
    
    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        SpringBootMockServletContext servletContext =
                (SpringBootMockServletContext) wac.getServletContext();
        servletContext.setContextPath("/scp-parkinglot-component");
    }
    
    @Test
    @Transactional 
    @Rollback(true)
    public void testInsertCar() {
        CarVo carVo = getMockCarVo();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String carString = objectMapper.writeValueAsString(carVo);
            mockMvc.perform(MockMvcRequestBuilders.post("/car/insert")
                    .contentType(MediaType.APPLICATION_JSON).content(carString.getBytes()))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print()).andReturn();
        } catch (Exception e) {
           logger.info(e.getMessage());
        }
    }
    
    @Test
    @Transactional 
    @Rollback(true)
    public void testUpdateCar() {
        ObjectMapper objectMapper = new ObjectMapper();
        CarVo carVo = getMockCarVo();
        try {
            String carDto = objectMapper.writeValueAsString(carVo);
            mockMvc.perform(MockMvcRequestBuilders.post("/car/update")
                    .contentType(MediaType.APPLICATION_JSON).content(carDto.getBytes()))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print()).andReturn();
        } catch (Exception e) {
           logger.info(e.getMessage());
        }
    }
    
    
    @Test
    @Transactional 
    @Rollback(true)
    public void testBatchDeleteCar() {
        ObjectMapper objectMapper = new ObjectMapper();
       List<String> ids = new ArrayList<>();
       ids.add(UuidUtil.generate());
       ids.add("A2221asd12dg3323aa");
        try {
            String idString = objectMapper.writeValueAsString(ids);
            mockMvc.perform(MockMvcRequestBuilders.post("/car/batchDelete")
                    .contentType(MediaType.APPLICATION_JSON).content(idString.getBytes()))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print()).andReturn();
        } catch (Exception e) {
           logger.info(e.getMessage());
        }
    }
    
    @Test
    public void testSelectPageList() {
        ObjectMapper objectMapper = new ObjectMapper();
        CarCondition carCondition = mockCarCondition();
        try {
            String carConditionString = objectMapper.writeValueAsString(carCondition);
            mockMvc.perform(MockMvcRequestBuilders.get("/car/pageList")
                    .contentType(MediaType.APPLICATION_JSON).content(carConditionString.getBytes()))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print()).andReturn();
        } catch (Exception e) {
           logger.info(e.getMessage());
        }
    }
    
    @Test
    public void testServicesInfo() {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/car/services")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print()).andReturn();
        } catch (Exception e) {
           logger.info(e.getMessage());
        }
    }
}
