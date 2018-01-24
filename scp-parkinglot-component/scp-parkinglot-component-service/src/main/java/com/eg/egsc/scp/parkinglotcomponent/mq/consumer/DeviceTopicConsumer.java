/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.mq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.eg.egsc.scp.parkinglotcomponent.mq.constant.MqConstants;
import com.eg.egsc.scp.parkinglotcomponent.service.dev.DevService;
import com.eg.egsc.scp.parkinglotcomponent.util.Constants;

/**
 * 业务层MQ消息监听,设备信息删除、修改，设备状态变更
 * 
 * @Class Name DeviceConsumer
 * @Author zhangli
 * @Create In 2018年1月2日
 */
@Component
public class DeviceTopicConsumer {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private DevService devServiceImpl;
    
    @RabbitListener(queues = MqConstants.TOPIC_CONSUMER_DEVICETOPARK, 
            containerFactory = MqConstants.CONTAINER_FACTORY_NAME_RLC)
    public void processMessage(JSONObject jsonObject) {
        try {
            logger.info("【Device】: {}", jsonObject.toJSONString());
            String updateType = jsonObject.getString(Constants.UPDATETYPE);
            int result = 0;//返回删除影响的行数
            if(updateType.equals(Constants.DELETE)) {
                String devCode = jsonObject.getString(Constants.DEVCODE);
                result = devServiceImpl.deleteByDevCode(devCode);
            }
            logger.info("【Device】: reuslt ===", result);           
        } catch (Exception e) {
            logger.error("Device receiver error.", e);
        }
    }
    
}
