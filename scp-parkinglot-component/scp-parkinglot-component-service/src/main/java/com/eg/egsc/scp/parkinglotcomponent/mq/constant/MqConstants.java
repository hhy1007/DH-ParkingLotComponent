/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.mq.constant;


/**
 * mq相关常量
 * 
 * @Class Name DestinationName
 * @Author zhangli
 * @Create In 2017年12月27日
 */
public class MqConstants {
    
    private MqConstants () {}
    
    /**
     * 物联网总线mq工厂名称
     * @Field String CONTAINER_FACTORY_NAME_IOT 
     */
    public static final String CONTAINER_FACTORY_NAME_IOT = "iotbusFactory";
    
    /**
     * 业务层mq工厂名称
     * @Field String CONTAINER_FACTORY_NAME_RLC 
     */
    public static final String CONTAINER_FACTORY_NAME_RLC = "rlcFactory";
    
    /**
     * 发送到物联网总线默认队列名
     * @Field String MSG_INBOUND_QUEUE 
     */
    public static final String MSG_INBOUND_QUEUE = "MSG_INBOUND_QUEUE";
    
    /**
     * 物联网总线上报到停车场组件消息默认的队列
     * @Field String QUEUE_IOT_DEFAULT 
     */
    public static final String QUEUE_IOT_DEFAULT = "MSG_OUTBOUND_APP8676"; //MSG_OUTBOUND_APP8676
    
    /**
     * APPID
     * 
     * @Field String IOT_APPID 
     */
    public static final String IOT_APPID = "APP8676"; //MSG_OUTBOUND_APP8676  
    
    /**
     * token
     * @Field String IOT_TOKEN 
     */
    public static final String IOT_TOKEN = "4a0764cdd8a5a967"; 

    
    /**
     * topic测试
     */
    public static final String TOPIC_PRODUCER_TEST = "EGSC_SCP_PARK_TEST_TOPIC";
    
    /**
     * 业主信息删除、修改消息通知
     * @Field String TOPIC_CONSUMER_MDM 
     */
    public static final String TOPIC_CONSUMER_MDM = "EGSC_SCP_MDM_TOPARK_TOPIC";
    
    /**
     * 设备信息删除、修改消息通知
     * @Field String TOPIC_CONSUMER_DEVICETOPARK 
     */
    public static final String TOPIC_CONSUMER_DEVICETOPARK = "EGSC_SCP_DEVICEMGMT_DEVICETOPARK_TOPIC";
    
    /**
     * 设备状态变更通知
     * @Field String TOPIC_CONSUMER_STATUSTOPARK 
     */
    public static final String TOPIC_CONSUMER_STATUSTOPARK = "EGSC_SCP_DEVICEMGMT_STATUSTOPARK_TOPIC";
    
}
