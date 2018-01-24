/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eg.egsc.scp.parkinglotcomponent.mq.message.DeviceStatusDto;
import com.eg.egsc.scp.parkinglotcomponent.mq.producer.MdmTopicProducer;

/**
 * 
 * 生产消息demo 继承Sender类，通过调用Sender中的convertAndSend往queue里发消息
 * @author songjie
 * 
 */
@Component
public class RabbitmqTest{
    
	@Autowired
	private MdmTopicProducer mdmTopicProducer;
	
//	@Scheduled(cron = "0/10 * * * * ?")
	public void test() {
	    DeviceStatusDto deviceStatusDto = new DeviceStatusDto();
	    deviceStatusDto.setDeviceID("1000001");
	    mdmTopicProducer.sendMsgDemo(deviceStatusDto, null, null);
	}
}
