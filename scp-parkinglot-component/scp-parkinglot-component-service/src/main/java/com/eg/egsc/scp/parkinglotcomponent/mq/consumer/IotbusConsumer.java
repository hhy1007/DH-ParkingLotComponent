/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.mq.consumer;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.eg.egsc.scp.parkinglotcomponent.enmus.iot.EventType;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkedCur;
import com.eg.egsc.scp.parkinglotcomponent.mq.constant.MqConstants;
import com.eg.egsc.scp.parkinglotcomponent.mq.message.IotMessage;
import com.eg.egsc.scp.parkinglotcomponent.service.parked.ParkedCurService;

/**
 * 物联网总线消息监听
 * 
 * @Class Name ReceiverListenerIotbus
 * @Author zhangli
 * @Create In 2017年12月26日
 */
@Component
public class IotbusConsumer{
    
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    ParkedCurService parkedCurServiceImpl;
    
    @RabbitListener(queues=MqConstants.QUEUE_IOT_DEFAULT, containerFactory=MqConstants.CONTAINER_FACTORY_NAME_IOT)
    public void processMessage(Message message) {
        try {
            String msg = new String(message.getBody(), "UTF-8");
            logger.info("【IOT】: {}", msg);
            if (StringUtils.isBlank(msg)) {
                return ;
            }
            IotMessage iotMessagePayload = JSON.parseObject(msg, IotMessage.class);
            if (iotMessagePayload.getEventTypeID() == null) {
                logger.error("eventTypeID is null");
                return ;
            }
            EventType eventType = EventType.getEnum(iotMessagePayload.getEventTypeID());
            if (eventType == null) {
                logger.error("eventTypeID mismatch");
                return ;
            }
            //根据事件ID判断事件类型，调用用相应服务处理，异步处理
            switch (eventType) {
                case DELETE_CERTIFICATE:
                    logger.debug("DELETE_CERTIFICATE");
                    break;
                case GATE_CONTROL:
                    logger.debug("GATE_CONTROL");
                    break;
                case LOAD_CERTIFICATE:
                    logger.debug("LOAD_CERTIFICATE");
                    break;
                case UPLOAD_CARPORT_RECORD:
                    logger.debug("UPLOAD_CARPORT_RECORD");
                    ParkParkedCur parkParkedCur = JSON.parseObject(msg, ParkParkedCur.class);
                    parkedCurServiceImpl.updateParkingStatus(parkParkedCur);
                    break;
                case UPLOAD_RECORD:
                    logger.debug("UPLOAD_RECORD");
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            logger.error("Iot receiver error.", e);
        }
    }
    
}
