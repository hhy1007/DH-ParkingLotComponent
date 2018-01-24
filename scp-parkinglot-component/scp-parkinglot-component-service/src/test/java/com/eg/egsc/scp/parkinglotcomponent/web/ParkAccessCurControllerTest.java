/**
 * @Probject Name: scp-parkinglot-component-service
 * @Path: com.eg.egsc.scp.parkinglotcomponent.webParkAccessCurControllerTest.java
 * @Create By wangziqiang
 * @Create In 2018年1月18日 下午2:38:41
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
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.support.GenericWebApplicationContext;

import com.eg.egsc.framework.client.core.ClientConfig;
import com.eg.egsc.scp.parkinglotcomponent.condition.access.AccessCurCondition;
import com.eg.egsc.scp.parkinglotcomponent.service.ParkEixtLotServiceTest;
import com.eg.egsc.scp.parkinglotcomponent.service.integration.dto.CarInOutDto;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 在场车辆记录Test
 * 
 * @Class Name ParkAccessCurControllerTest
 * @Author wangziqiang
 * @Create In 2018年1月18日
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClientConfig.class})
public class ParkAccessCurControllerTest extends ParkEixtLotServiceTest {

    private MockMvc mockMvc;

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private GenericWebApplicationContext wac;

    @Test
    /**
     * 根据入场id查询停车场信息和收费规则信息
     * 
     * @Methods Name selectAccessByPrimaryKeyTest
     * @Create In 2018年1月18日 By wangziqiang void
     */
    public void selectAccessByPrimaryKeyTest() {
        try {
            MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                    .get("/accessCur/selectAccessCurAndParkingLotAndParkFeeRuleByPrimaryKey?id=2")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print()).andReturn();
            logger.info("result :  {}" + result.getResponse().getContentAsString());

        } catch (Exception e1) {
            logger.error(e1.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    /**
     * 重新计费查询
     * 
     * @Methods Name rechargeTest
     * @Create In 2018年1月18日 By wangziqiang void
     */
    public void rechargeTest() {
        CarInOutDto carInOut = super.getCarInOut();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String dto = objectMapper.writeValueAsString(carInOut);

            RequestBuilder request = MockMvcRequestBuilders.post("/accessCur/recharge/select")
                    .contentType(MediaType.APPLICATION_JSON).content(dto.getBytes());

            mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print()).andReturn();
        } catch (Exception e1) {
            logger.error(e1.getMessage());
        }
    }

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        SpringBootMockServletContext servletContext =
                (SpringBootMockServletContext) wac.getServletContext();
        servletContext.setContextPath("/scp-parkinglot-component");
    }


    @Test
    @Rollback(true)
    /**
     * 在场车辆查询
     * 
     * @Methods Name batchDeleteCarsTest
     * @Create In 2018年1月18日 By wangziqiang void
     */
    public void batchDeleteCarsTest() {
        AccessCurCondition accessCurCondition = new AccessCurCondition();
        accessCurCondition.setCardNumber("123456");
        try {
            MvcResult result = mockMvc
                    .perform(
                            MockMvcRequestBuilders
                                    .get("/accessCur/export/select?accessCurCondition="
                                            + accessCurCondition)
                                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print()).andReturn();
            logger.info("result :  {}" + result.getResponse().getContentAsString());

        } catch (Exception e1) {
            logger.error(e1.getMessage());
        }
    }

}
