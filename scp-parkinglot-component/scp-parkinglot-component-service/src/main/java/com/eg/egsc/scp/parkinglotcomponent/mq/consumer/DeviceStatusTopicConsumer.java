/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.mq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.eg.egsc.scp.parkinglotcomponent.mq.constant.MqConstants;
import com.eg.egsc.scp.parkinglotcomponent.mq.message.DeviceStatusDto;

/**
 * 业务层MQ消息监听,设备设备状态变更
 * @author zhangli
 * @since 2018年1月15日
 */
@Component
public class DeviceStatusTopicConsumer {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @RabbitListener(queues = MqConstants.TOPIC_CONSUMER_STATUSTOPARK, 
            containerFactory = MqConstants.CONTAINER_FACTORY_NAME_RLC)
    public void processMessage(DeviceStatusDto deviceStatusDto) {
        try {
            logger.info("【Device status】: {}", deviceStatusDto);
                       
        } catch (Exception e) {
            logger.error("Device receiver error.", e);
        }
    }
    
}
