/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.redis;

/**
 * redis key
 * 
 * @Class Name RedisKey
 * @Author zhangli
 * @Create In 2018年1月3日
 */
public class RedisKey {

    private RedisKey() {}

    /**
     * test key
     * 
     * @Field String KEY_STR_TEST
     */
    public static final String KEY_STR_TEST = "TEST.TESTKEY";

    /**
     * test key
     * 
     * @Field String KEY_MAP_TEST
     */
    public static final String KEY_MAP_TEST = "TEST.HASHKEY";

    /**
     * 停车场通道
     * 
     * @Field String KEY_CHANNEL_ID
     */
    public static final String KEY_CHANNEL_ID = "PLC:INOUTPARKINGLOT.CHANNELID";
}
