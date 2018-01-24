/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.basic.util;

/**
 * @Class Name SqlUtil
 * @Author zhangli
 * @Create In 2017年12月14日
 */
public class SqlUtil {

    private SqlUtil() {
    }
    
    /*
     * 删除：0存在
     */
    public static final short FLAG_NORMAL = 0;
    
    /*
     * 删除：1删除
     */
    public static final short FLAG_DELETE = 1;
    
    
    /*
     * 下标
     */
    public static final Integer INDEX = 0;
    
    /*
     * null值
     */
    public static final Object NULL = null;
    
    /**
     * 模糊查询：前后加通配符
     * @Methods Name likeAround
     * @Create In 2017年12月14日 By zhangli
     * @param field
     * @return String
     */
    public static String likeAround(String field) {
        return "%" + field + "%";
    }
    
    /**
     * 模糊查询：结尾加通配符
     * @Methods Name likeLast
     * @Create In 2017年12月14日 By zhangli
     * @param field
     * @return String
     */
    public static String likeLast(String field) {
        return field + "%";
    }
    
    /**
     * 升序
     * @Methods Name orderAsc
     * @Create In 2017年12月14日 By zhangli
     * @param field
     * @return String
     */
    public static String orderAsc(String field) {
        return field + " asc";
    }
    
    /**
     * 降序
     * @Methods Name orderDesc
     * @Create In 2017年12月14日 By zhangli
     * @param field
     * @return String
     */
    public static String orderDesc(String field) {
        return field + " desc";
    }
}
