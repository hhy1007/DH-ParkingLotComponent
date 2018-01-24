/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.mq.constant;

/**
 * @Class Name ProtocolConstants
 * @Author zhangli
 * @Create In 2017年12月27日
 */
public class ProtocolConstants {

    private ProtocolConstants() {}

    /** 停车场 访问控制指令 */
    public static final String MSG_COMMAND_PARKING = "MSG/COMMAND/PARKING";

    /** 停车场 事件上报 */
    public static final String MSG_EVENT_PARKING = "MSG/EVENT/PARKING";

    /** 消息是否回复：不需要回执, 为缺省设置 */
    public static final String REPLY_FLAG_NO = "No";

    /** 消息是否回复：需要回执 */
    public static final String REPLY_FLAG_YES = "Yes";

    /** 消息是否回复：失败时需要回执 */
    public static final String REPLY_FLAG_FAILURE = "Failure";

    /** 标识该消息是否是回复消息：默认上下行消息 */
    public static final int IS_REPLY_DEFAULT = 0;

    /** 消息是否回复：失败时需要回执 */
    public static final int IS_REPLY_REPLY = 1;


}
