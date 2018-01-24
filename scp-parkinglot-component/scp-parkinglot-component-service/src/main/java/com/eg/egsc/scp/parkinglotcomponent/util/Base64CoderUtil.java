/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.util;

import org.apache.commons.codec.binary.Base64;

/**
 * 类描述：Base64Util 工具类
 * 
 * @Class Name Base64CoderUtil
 * @Author zhangli
 * @Create In 2017年12月15日
 */
public class Base64CoderUtil {
	
    private Base64CoderUtil () {}
    
    /**
     * base64 编码
     * 
     * @Methods Name encode
     * @Create In 2017年12月15日 By zhangli
     * @param data
     * @return
     * @throws Exception String
     */
    public static String encode(byte[] data) {
        byte[] enBytes = Base64.encodeBase64Chunked(data);
        return new String(enBytes);
    }
    
    /**
     * base64 解码
     * 
     * @Methods Name decode
     * @Create In 2017年12月15日 By zhangli
     * @param data
     * @return
     * @throws Exception byte[]
     */
    public static byte[] decode(String data) {
        return Base64.decodeBase64(data.getBytes());
    }
    
    /**
     * base64 解码
     * 
     * @Methods Name decodeToStr
     * @Create In 2017年12月15日 By zhangli
     * @param data
     * @return
     * @throws Exception String
     */
    public static String decodeToStr(String data) {
        byte[] deBytes = Base64.decodeBase64(data.getBytes());
        return new String(deBytes);
    }
}
