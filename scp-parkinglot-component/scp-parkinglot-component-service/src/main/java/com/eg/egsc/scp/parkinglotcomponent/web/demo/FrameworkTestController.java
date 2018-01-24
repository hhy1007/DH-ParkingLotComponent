/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.demo;

import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.eg.egsc.common.component.auth.model.User;
import com.eg.egsc.common.component.auth.web.SecurityContext;
import com.eg.egsc.common.component.redis.RedisUtils;
import com.eg.egsc.framework.service.base.web.BaseWebController;
import com.eg.egsc.framework.service.util.SpringEnvUtil;
import com.eg.egsc.scp.parkinglotcomponent.client.access.AccessCurClient;
import com.eg.egsc.scp.parkinglotcomponent.common.result.ResultMessage;
import com.eg.egsc.scp.parkinglotcomponent.dto.access.AccessCurDto;
import com.eg.egsc.scp.parkinglotcomponent.redis.RedisKey;

/**
 * 测试接口
 * 
 * @Class Name CarController
 * @Author zhangli
 * @Create In 2017年12月14日
 */
@RestController
@RequestMapping(value = "/frameworktest")
public class FrameworkTestController extends BaseWebController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedisUtils redisUtils;
    
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;
    
    @Autowired
    private Executor parkExecutor;
    
    @Autowired
    private Executor portExecutor;
    
    @Autowired
    private AccessCurClient accessCurClientImpl;
    
    @Autowired
    private SpringEnvUtil springEnvUtil;
    
    private String mapHashKey = "hkey";
    
    private String mapHashKey2 = "hkey2";
    
    /**
     * redis 测试
     * @return ResultMessage
     */
    @RequestMapping(value = "/setString", method = RequestMethod.GET)
    public ResultMessage setStringValue(String value) {
        logger.info("setStringValue.. ");
        redisUtils.set(RedisKey.KEY_STR_TEST, value);
        return ResultMessage.createSuccessResult(null);
    }
    
    /**
     * redis 测试
     * @return ResultMessage
     */
    @RequestMapping(value = "/getString", method = RequestMethod.GET)
    public ResultMessage getStringValue() {
        logger.info("getStringValue.. ");
        Object obj = redisUtils.get(RedisKey.KEY_STR_TEST);
        String result = null;
        if (obj != null) {
            result = obj.toString();
        }
        return ResultMessage.createSuccessResult(result);
    }
    
    /**
     * redis hash测试
     * @return ResultMessage
     */
    @RequestMapping(value = "/setMapValue", method = RequestMethod.GET)
    public ResultMessage setMapValue() {
        logger.info("setMapValue.. ");
        String value = "DaHua 2018";
        redisTemplate.opsForHash().put(RedisKey.KEY_MAP_TEST, mapHashKey, value);
        logger.info("setMapValue value: " + value);
        UserBean userBean = new UserBean();
        userBean.setName("张三");
        redisTemplate.opsForHash().put(RedisKey.KEY_MAP_TEST, mapHashKey2, userBean);
        logger.info("setMapValue value: " + JSON.toJSONString(userBean));
        return ResultMessage.createSuccessResult(null);
    }
    
    /**
     * redis hash测试
     * @return ResultMessage
     */
    @RequestMapping(value = "/getMapValue", method = RequestMethod.GET)
    public ResultMessage getMapValue() {
        logger.info("getMapValue.. ");
        Object obj = redisTemplate.opsForHash().get(RedisKey.KEY_MAP_TEST, mapHashKey);
        String value = (obj != null) ? obj.toString() : null;
        logger.info("getMapValue value: " + value);
        obj = redisTemplate.opsForHash().get(RedisKey.KEY_MAP_TEST, mapHashKey2);
        UserBean userBean = (UserBean) obj;
        logger.info("getMapValue car: " + JSON.toJSONString(userBean));
        return ResultMessage.createSuccessResult(userBean);
    }

    /**
     * 线程池测试
     * @return ResultMessage
     */
    @RequestMapping(value = "/threadPool", method = RequestMethod.GET)
    public ResultMessage testThreadPool() {
        logger.info("getMapValue.. ");
        parkExecutor.execute(() -> logger.info("parkExecutor thread"));
        portExecutor.execute(() -> logger.info("portExecutor thread"));
        
        return ResultMessage.createSuccessResult(null);
    }
    
    /**
     * client 接口测试
     * @return ResultMessage
     */
    @RequestMapping(value = "/clientTest", method = RequestMethod.GET)
    public ResultMessage clientTest() {
        logger.info("clientTest.. ");
        AccessCurDto dto = new AccessCurDto();
        dto.setCardNumber("123456");
        dto.setNowTime("2018-01-06 10:10:00");
        
        AccessCurDto result = accessCurClientImpl.selectAccessCurByExample(dto);
        logger.info("accessCurDto: {}", JSON.toJSONString(result) );
        return ResultMessage.createSuccessResult(result);
    }
    
    /**
     * client 接口测试
     * @return ResultMessage
     */
    @RequestMapping(value = "/clientUpdateTest", method = RequestMethod.GET)
    public ResultMessage clientUpdateTest() {
        logger.info("clientUpdateTest.. ");
        AccessCurDto dto = new AccessCurDto();
        dto.setCardNumber("123456");
        dto.setMoney("10.00");
        AccessCurDto result = accessCurClientImpl.updateAccessCurByExample(dto);
        logger.info("result: {}", JSON.toJSONString(result) );
        return ResultMessage.createSuccessResult(result);
    }
    
    /**
     * 自定义参数测试
     * @return ResultMessage
     */
    @RequestMapping(value = "/springEnvTest", method = RequestMethod.GET)
    public ResultMessage springEnvTest() {
        logger.info("springEnvTest.. ");
        String result = springEnvUtil.getProperty("test");
        logger.info("test: {}", result );
        return ResultMessage.createSuccessResult(result);
    }
    
    /**
     * 获取当前会话用户
     * @return ResultMessage
     */
    @RequestMapping(value = "/getCurrenctUser", method = RequestMethod.GET)
    public ResultMessage getCurrenctUser() {
        logger.info("getCurrenctUser.. ");
        User user = SecurityContext.getCurrenctUser();
        logger.info("user: {}", JSON.toJSONString(user) );
        return ResultMessage.createSuccessResult(user);
    }
}
