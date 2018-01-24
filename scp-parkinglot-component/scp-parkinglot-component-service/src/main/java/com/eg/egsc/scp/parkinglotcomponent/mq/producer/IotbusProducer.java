/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.mq.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.eg.egsc.common.component.rabbitmq.IotbusSender;
import com.eg.egsc.scp.parkinglotcomponent.enmus.iot.ControlEventType;
import com.eg.egsc.scp.parkinglotcomponent.mq.constant.MqConstants;
import com.eg.egsc.scp.parkinglotcomponent.mq.constant.ProtocolConstants;
import com.eg.egsc.scp.parkinglotcomponent.mq.message.IotMessage;
import com.eg.egsc.scp.parkinglotcomponent.util.Constants;
import com.eg.egsc.scp.parkinglotcomponent.util.DateUtil;

/**
 * 物联网总线消息队列生成者
 * 
 * @Class Name SenderIotbus
 * @Author zhangli
 * @Create In 2017年12月26日
 */
@Component
public class IotbusProducer extends IotbusSender{
    
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private Message createMessage(Object msgObject) {
	    MessageProperties messageProperties = new MessageProperties();
        messageProperties.setContentType(MessageProperties.CONTENT_TYPE_JSON);
        messageProperties.setContentEncoding(Constants.DEFAULT_CHARSET);
        byte[] bytes = JSON.toJSONString(msgObject).getBytes();
        messageProperties.setContentLength(bytes.length);
        return new Message(bytes, messageProperties);
    }
	
    private IotMessage createIotMessageDemo(Object msgObject, String messageId, String deviceId) {
        IotMessage iotMessage = new IotMessage();
        iotMessage.setAppID(MqConstants.IOT_APPID);
        iotMessage.setToken(MqConstants.IOT_TOKEN);
        iotMessage.setDeviceID(deviceId);//设备编号
        iotMessage.setTopic("");//事件组消息简称（参考事件组映射表）
        iotMessage.setEventTypeID(ControlEventType.GATE_CONTROL.getType());//事件类型编号
        iotMessage.setMessageID(messageId);//消息编号:要求网关生成一个uuid
        iotMessage.setReplyFlag(ProtocolConstants.REPLY_FLAG_NO);//No：不需要回执, 为缺省设置； Yes：需要回执；Failure：失败时需要回执
        iotMessage.setReplyToQueue(null);//指定回复消息的目标队列
        iotMessage.setCorrelationID(null);//同步调用模式下需要的关联ID
        iotMessage.setGatewayID(ProtocolConstants.MSG_COMMAND_PARKING);//网关标识，网关往总线上报时是可选字段；组件往总线下发指令时是必填字段
        iotMessage.setTimestamp(DateUtil.getCurrentTimeStr());//消息报告时间：这个需要在网关上报总线的时候要添加这些信息
        iotMessage.setIsReplyMsg(ProtocolConstants.IS_REPLY_DEFAULT);//标识该消息是否是回复消息：（0-默认上下行消息，1-上行回复消息）
        iotMessage.setPayload(msgObject);
        return iotMessage;
    }
       
	/**
	 * 向物联网总线发送消息
	 * 
	 * @Methods Name sendMsg
	 * @Create In 2017年12月27日 By zhangli
	 * @param msgObject
	 * @param messageId
	 * @param deviceId void
	 */
	public void sendMsgDemo(Object msgObject, String messageId, String deviceId) {
	    IotMessage iotMessage = this.createIotMessageDemo(msgObject, messageId, deviceId);
	    logger.info("【SEND IOT】: {}", JSON.toJSONString(iotMessage));
	    Message message = this.createMessage(iotMessage);
	    convertAndSend(MqConstants.QUEUE_IOT_DEFAULT, message);
	}
	
	public void sendBarrierCommandToIot(Object msgObject, String messageId, String deviceId) {
	    IotMessage iotMessage = this.createIotMessageDemo(msgObject, messageId, deviceId);
	    iotMessage.setReplyFlag(ProtocolConstants.REPLY_FLAG_YES);
	    Message message = this.createMessage(iotMessage);
	    logger.info("【SEND ROADGATE TO IOT】: {}", JSON.toJSONString(iotMessage));
	    convertAndSend(MqConstants.QUEUE_IOT_DEFAULT, message);
	}
}
