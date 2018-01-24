/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.mq.consumer;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.eg.egsc.scp.mdm.component.dto.BaseUserDto;
import com.eg.egsc.scp.parkinglotcomponent.mq.constant.MqConstants;
import com.eg.egsc.scp.parkinglotcomponent.service.mdm.MdmOperateService;
import com.eg.egsc.scp.parkinglotcomponent.util.Constants;

/**
 * 业务层MQ消息监听,业主信息删除、修改
 * 
 * @Class Name BusConsumer
 * @Author zhangli
 * @Create In 2018年1月2日
 */
@Component
public class MdmTopicConsumer {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MdmOperateService mdmOperateServiceImpl;

    @RabbitListener(queues = MqConstants.TOPIC_CONSUMER_MDM,
            containerFactory = MqConstants.CONTAINER_FACTORY_NAME_RLC)
    public void processMessage(Message message) {
        try {
            String msg = new String(message.getBody(), Constants.DEFAULT_CHARSET);
            BaseUserDto baseUserDto = JSON.parseObject(msg, BaseUserDto.class);
            mdmOperateServiceImpl.deleteOwnerRel(baseUserDto);
            logger.info("【MDM】: {}", msg);

        } catch (UnsupportedEncodingException e) {
            logger.error("Mdm receiver error.", e);
        } catch (JSONException e) {
            logger.error("Mdm JSONparse error.", e);
        } catch (Exception e) {
            logger.error("Mdm  error.", e);
        }
    }

}
