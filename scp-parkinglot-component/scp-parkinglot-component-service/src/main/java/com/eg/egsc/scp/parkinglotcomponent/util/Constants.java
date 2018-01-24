/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.util;

import java.text.DecimalFormat;

/**
 * @Class Name Constants
 * @Author zhangli
 * @Create In 2017年12月26日
 */
public class Constants {

    private Constants () {}
    
    /**
     * 返回值
     * @Field int RESULT
     */
    public static final int RESULT = 0;
    
    /**
     * 操作类型
     * @Field String UPDATETYPE
     */
    public static final String UPDATETYPE = "updateType";
    
    /**
     * 删除操作
     * @Field String UPDATETYPE
     */
    public static final String DELETE = "DELETE";
    
    /**
     * 设备编号
     * @Field String UPDATETYPE
     */
    public static final String DEVCODE = "deviceID";
    
    /**
     * UTF-8
     * @Field String DEFAULT_CHARSET 
     */
    public static final String DEFAULT_CHARSET = "UTF-8";
    
    /**
     * success
     * @Field String SUCCESS 
     */
    public static final String SUCCESS = "success";
    
    /**
     * 停车检测类型：有车
     * @Field short PARK_TYPE_ONE 
     */
    public static final short PARK_TYPE_YES = 1;
    
    /**
     * 停车检测类型：无车
     * @Field short PARK_TYPE_ZERO 
     */
    public static final short PARK_TYPE_NO = 0;
    
    /**
     * 计算的价格保留两位数
     * @Field DecimalFormat DF 
     */
    public  static final DecimalFormat DF = new DecimalFormat("######0.00");
    
    /**
     * 记录批量新增车位每次返回影响的行数
     * @Field Integer COUNCT 
     */
    public  static final Integer COUNCT = 0;
    
    /**
     * 记录批量新增车位返回影响的总行数
     * @Field Integer SUM_COUNCT 
     */
    public  static final Integer SUM_COUNCT = 0;
    
    /**
     * 保安派遣状态:1-已派遣
     */
    public static final short DISPATCH_STATE_YES = 1;
    
    /**
     * 保安派遣状态:0-未派遣
     */
    public static final short DISPATCH_STATE_NO = 0;
    
    /**
     * 预警状态:1-有报警
     */
    public static final short ALARM_STATUS_YES = 1;
    
    /**
     * 预警状态:0-无报警
     */
    public static final short ALARM_STATUS_NO = 0;
    
    /**
     * 收费规则收费时段
     */
    public static final String STARTTIME = "7:00";
    
    /**
     * 收费规则收费时段
     */
    public static final String ENDTIME = "20:00";
    
    /**
     * 收费规则字段
     */
    public static final String TRUE = "true";
    
    /**
     * 收费规则字段
     */
    public static final String FALSE = "false";
    
    /**
     * 收费金额由分转成元
     */
    public static final Integer MONEYPOINTS = 100;
    
    /**
     * (date - date) / (1000*60) 得到分钟数
     */
    public static final Integer TIMEPOINTS = 60000;
    
    /**
     * 一天的分钟数
     */
    public static final Integer DAYPOINTS = 1440;
    
    /**
     * 用户id的长度
     */
    public static final Integer OWNER_ID_LENGTH = 32;
    
    /**
     * int默认值0
     */
    public static final Integer DEFAULT_INT_VALUE = 0;
    
    /**
     * short默认值0
     */
    public static final Short DEFAULT_SHORT_VALUE = 0;
    
    /**
     * 插入的条数
     */
    public static final Integer PAGESIZE = 500;
    
    /**
     * 截取的批量插入集合的当前减去1
     */
    public static final Integer PAGEINDEX = 1;
    
    /**
     * 缴费状态：0即将到期
     */
    public static final Short CHARGE_STATE_ARREAR = 0;
    
    /**
     * 缴费状态：1欠费
     */
    public static final Short CHARGE_STATE_ARREARAGE = 1;
    
    /**
     * 缴费状态：2已缴费
     */
    public static final Short CHARGE_STATE_PAY = 2;
}
