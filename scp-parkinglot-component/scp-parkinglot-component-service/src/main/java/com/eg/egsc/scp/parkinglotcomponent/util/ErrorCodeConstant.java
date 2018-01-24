/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.util;

/**
 * @Class Name ErrorCodeConstant
 * @Author zhangli
 * @Create In 2017年12月14日
 */
public class ErrorCodeConstant {

    private ErrorCodeConstant() {}


    /** 0001:用户名不能为空 */
    public static final String DEMO_USERMGNT_USERISBLANK = "demo.usermgnt.userisblank";

    /** 0002:请求头不能为空 */
    public static final String FRAMEWORK_REQUEST_HEAD_NULL = "framework.request.head.null";

    /** 0003:请求头中businessId不能为空 */
    public static final String FRAMEWORK_REQUEST_HEAD_BUSINESSID_NULL =
            "framework.request.head.businessId.null";

    /** 0004:请求头srcSysId不能为空 */
    public static final String FRAMEWORK_REQUEST_HEAD_SRCSYSID_NULL =
            "framework.request.head.srcSysId.null";

    /** 0005:请求头tgtSysId不能为空 */
    public static final String FRAMEWORK_REQUEST_HEAD_TGTSYSID_NULL =
            "framework.request.head.tgtSysId.null";


    /** 21101:参数不正确 */
    public static final String PARKINGLOT_COMMON_PARAMETER = "parkinglot.common.parameter";

    /** 21109:车牌号码重复 */
    public static final String PARKINGLOT_CAR_PLATE_NUMBER_REPEATE =
            "parkinglot.car.plate.number.repeate";

    /** 21109:停车场编号或名称不能重复 */
    public static final String PARKINGLOT_PARKINGLOT_PLATE_NUMBER_REPEATE =
            "parkinglot.parkinglot.plate.number.repeate";

    /** 21109:车位编号不能重复 */
    public static final String PARKINGLOT_CARPORT_PLATE_NUMBER_REPEATE =
            "parkinglot.carport.plate.number.repeate";

    /** 21109:车位已授权不能删除 */
    public static final String PARKINGLOT_CARPORT_PACKAGE_PLATE_NUMBER_REPEATE =
            "parkinglot.carport.package.plate.number.repeate";

    /** 21109:通道名称不能重复 */
    public static final String PARKINGLOT_CHANNEL_NAME_PLATE_NUMBER_REPEATE =
            "parkinglot.channel.name.plate.number.repeate";

    /** 21109:车场通道已与设备绑定，不能删除 */
    public static final String PARKINGLOT_CHANNEL_PLATE_NUMBER_REPEATE =
            "parkinglot.channel.plate.number.repeate";

    /** 21109:该设备已绑定其它通道 */
    public static final String PARKINGLOT_CHANNEL_REL_PLATE_NUMBER_REPEATE =
            "parkinglot.channel.rel.plate.number.repeate";

    /** 21109:进出规则名称不能重复 */
    public static final String PARKINGLOT_RULE_NAME_PLATE_NUMBER_REPEATE =
            "parkinglot.rule.name.plate.number.repeate";

    /** 21109:进出规则已使用，不能删除 */
    public static final String PARKINGLOT_RULE_PLATE_NUMBER_REPEATE =
            "parkinglot.rule.plate.number.repeate";

    /** 21109:收费规则名称不能重复 */
    public static final String PARKINGLOT_FEE_RULE_NAME_PLATE_NUMBER_REPEATE =
            "parkinglot.fee.rule.name.plate.number.repeate";

    /** 21109:收费规则已使用，不能删除 */
    public static final String PARKINGLOT_FEE_RULE_PLATE_NUMBER_REPEATE =
            "parkinglot.fee.rule.plate.number.repeate";

    /** 21109:计费的开始时间不能大于结束时间 */
    public static final String PARKINGLOT_FEE_RULE_TIME_PLATE_NUMBER_REPEATE =
            "parkinglot.fee.rule.time.plate.number.repeate";

    /** 21109:充值数额错误 */
    public static final String PARKINGLOT_CHARGE_MONEY_UNEQUAL = "parkinglot.charge.money.unequal";

    /** 21109:重复充值 */
    public static final String PARKINGLOT_CHARGE_CHARGE_REPEATE =
            "parkinglot.charge.charge.repeate";

    /** 21109:车位占用 */
    public static final String PARKINGLOT_AUTHPACKAGE_CARPORT_OCCPIED =
            "parkinglot.authpackage.carport.occpied";

    /** 21209:车位位置更新失败 */
    public static final String PARKINGLOT_CARPORT_MAP_FAILURE = "parkinglot.carport.map.failure";

    /** 201109:数字解析失败 */
    public static final String PARKINGLOT_FEE_RULE_NUMBER_PARSE_FAILURE =
            "parkinglot.fee.rule.number.parse.failure";

    /** 201109:实体类为空 */
    public static final String PARKINGLOT_COMMON_CLAZZISBLANK = "parkinglot.common.clazzisblank";

    /** 21109 抓拍的车辆已存在 */
    public static final String PARKINGLOT_PARKCARCAPTURE_PLATE_REPEATE =
            "parkinglot.parkcarcapture.plate.repeate";

    /** 21109 在场车辆已经存在 */
    public static final String PARKINGLOT_PARKACCESSCUR_PLATE_NUMBER_REPEATE =
            "parkinglot.parkaccesscur.plate.number.repeate";

    /** 21109 预警更新失败 */
    public static final String PARKINGLOT_PARKPARKEDCUR_ALARM_FAILURE =
            "parkinglot.parkparkedcur.alarm.failure";

    /** 计费的停车时间时间不能大于超过一天 */
    public static final String PARKINGLOT_FEE_RULE_TIME_NOT_DAY =
            "parkinglot.fee.rule.time.not.day";
}
