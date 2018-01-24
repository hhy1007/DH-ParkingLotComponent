/**
 * @Probject Name: scp-parkinglot-component-service
 * @Path: com.eg.egsc.scp.parkinglotcomponent.webParkAccessHisControllerTest.java
 * @Create By wangziqiang
 * @Create In 2018年1月18日 下午3:37:57
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.support.GenericWebApplicationContext;

import com.eg.egsc.framework.client.core.ClientConfig;
import com.eg.egsc.scp.parkinglotcomponent.condition.access.AccessHisCondition;

/**
 * 车辆历史controller 测试
 * 
 * @Class Name ParkAccessHisControllerTest
 * @Author wangziqiang
 * @Create In 2018年1月18日
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClientConfig.class})
public class ParkAccessHisControllerTest {

    private MockMvc mockMvc;

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        SpringBootMockServletContext servletContext =
                (SpringBootMockServletContext) wac.getServletContext();
        servletContext.setContextPath("/scp-parkinglot-component");
    }

    @Autowired
    private GenericWebApplicationContext wac;


    @Test
    /**
     * 分页 查询
     * 
     * @Methods Name selectPageListTest
     * @Create In 2018年1月18日 By wangziqiang void
     */
    public void selectPageListTest() {

        AccessHisCondition accessHisCondition = new AccessHisCondition();
        accessHisCondition.setCardNumber("123456");
        try {
            MvcResult result = mockMvc
                    .perform(MockMvcRequestBuilders
                            .get("/accessHis/list?accessHisCondition=" + accessHisCondition)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print()).andReturn();
            logger.info("result :  {}" + result.getResponse().getContentAsString());

        } catch (Exception e1) {
            logger.error(e1.getMessage());
        }
    }

    @Test
    /**
     * 导出在场车辆查询 Test
     * 
     * @Methods Name selectPageListTest
     * @Create In 2018年1月18日 By wangziqiang void
     */
    public void exportAccessList() {

        AccessHisCondition accessHisCondition = new AccessHisCondition();
        accessHisCondition.setCardNumber("123456");
        try {
            MvcResult result = mockMvc
                    .perform(MockMvcRequestBuilders
                            .get("/accessHis/export/list?accessHisCondition=" + accessHisCondition)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print()).andReturn();
            logger.info("result :  {}" + result.getResponse().getContentAsString());

        } catch (Exception e1) {
            logger.error(e1.getMessage());
        }
    }

}
