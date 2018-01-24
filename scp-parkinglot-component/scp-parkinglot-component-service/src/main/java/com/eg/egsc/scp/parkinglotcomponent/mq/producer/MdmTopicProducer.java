/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.mq.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.eg.egsc.framework.client.mq.BaseDefaultMqSender;
import com.eg.egsc.scp.parkinglotcomponent.mq.constant.MqConstants;
import com.eg.egsc.scp.parkinglotcomponent.mq.message.DeviceStatusDto;

/**
 * 发送topic 消息测试
 * 
 * @Class Name SenderIotbus
 * @Author zhangli
 * @Create In 2017年12月26日
 */
@Component
public class MdmTopicProducer extends BaseDefaultMqSender{
    
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
	/**
	 * 发送topic 消息测试
	 * @param deviceStatusDto
	 * @param messageId
	 * @param deviceId void
	 */
	public void sendMsgDemo(DeviceStatusDto deviceStatusDto, String messageId, String deviceId) {
	    logger.info("【SEND TOPIC】: {}", JSON.toJSONString(deviceStatusDto));
	    sendTopic(MqConstants.TOPIC_PRODUCER_TEST, deviceStatusDto);
	}
}
