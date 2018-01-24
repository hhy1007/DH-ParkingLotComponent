/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.util;

import java.util.UUID;

/** 
 * UUID工具类
 * @Class Name UuidUtil 
 * @Author zhangli 
 * @Create In 2017年12月12日 
 * */
public class UuidUtil {
    
    private UuidUtil () {}

    /**
     * * @Methods Name generate * @Create In 2017年12月12日 By zhangli *
     *  生成UUID
     * @return String
     */
    public static final String generate() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
