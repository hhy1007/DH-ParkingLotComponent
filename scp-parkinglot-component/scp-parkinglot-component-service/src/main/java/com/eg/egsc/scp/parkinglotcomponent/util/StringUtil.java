/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.util;

/**
 * 字符串工具类
 * 
 * @Class Name StringUtil
 * @Author zhangli
 * @Create In 2017年12月23日
 */
public class StringUtil {
    
    private StringUtil () {}

    /**
     * 字节数组转换成十六进制字符串
     * 
     * @Methods Name byteArrayToHexString
     * @Create In 2017年12月23日 By zhangli
     * @param array
     * @return String
     */
    public static String byteArrayToHexString(byte[] array) {
        if(array == null){
            return null;
        }
        StringBuilder hexString = new StringBuilder(); 
        // 字节数组转换为 十六进制 数
        for (int i = 0; i < array.length; i++) {
            String shaHex = Integer.toHexString(array[i] & 0xFF);
            if (shaHex.length() < 2) {
                hexString.append(0);
            }
            hexString.append(shaHex);
        }
        return hexString.toString();
    }
    
    /**
     * 十六进制字符串转换成字节数组
     * 
     * @Methods Name hexStringToByteArray
     * @Create In 2017年12月23日 By zhangli
     * @param hexStr
     * @return byte[]
     */
    public static byte[] hexStringToByteArray(String hexStr) {
        int length = hexStr.length()/2;
        byte[] result = new byte[length];
        for(int i=0; i<length; i++){
            int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
            int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
            result[i] = (byte)(high*16 + low);
        }
        return result;
    }
}
