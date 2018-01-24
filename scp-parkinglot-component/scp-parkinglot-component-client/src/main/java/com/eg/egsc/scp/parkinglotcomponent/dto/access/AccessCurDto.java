/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.dto.access;

import com.eg.egsc.framework.client.dto.BaseBusinessDto;

/**
 * 应缴费用类
 * 
 * @Class Name AccessDto
 * @Author wangziqiang
 * @Create In 2018年1月10日
 */
public class AccessCurDto extends BaseBusinessDto {
    /**
     * @Field long serialVersionUID
     */
    private static final long serialVersionUID = -9006334012910014406L;
    /**
     * @Field 车牌
     */
    private String carNum;
    /**
     * @Field 卡号
     */
    private String cardNumber;
    /**
     * @Field 应缴费用
     */
    private String money;
    /**
     * @Field 当前时间
     */
    private String nowTime;
    /**
     * @Filed车主名字
     */
    private String ownerName;
    /**
     * @Feild 停车时长
     */
    private Integer theStopTime;

    /**
     * @Feild 更新成功次数
     */
    private int count;

    public String getCarNum() {
        return carNum;
    }

    /**
     * 车牌
     * 
     * @Methods Name setCarNum
     * @Create In 2018年1月10日 By wangziqiang
     * @param carNum void
     */
    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * 卡号
     * 
     * @Methods Name setCardNumber
     * @Create In 2018年1月10日 By wangziqiang
     * @param cardNumber void
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getMoney() {
        return money;
    }

    /**
     * 应缴费用
     * 
     * @Methods Name setMoney
     * @Create In 2018年1月10日 By wangziqiang
     * @param money void
     */
    public void setMoney(String money) {
        this.money = money;
    }

    public String getNowTime() {
        return nowTime;
    }

    /**
     * 当前时间
     * 
     * @Methods Name setNowTime
     * @Create In 2018年1月10日 By wangziqiang
     * @param nowTime void
     */
    public void setNowTime(String nowTime) {
        this.nowTime = nowTime;
    }

    public String getOwnerName() {
        return ownerName;
    }

    /**
     * 车主名字
     * 
     * @Methods Name setOwnerName
     * @Create In 2018年1月10日 By wangziqiang
     * @param ownerName void
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Integer getTheStopTime() {
        return theStopTime;
    }

    /**
     * 停车时长
     * 
     * @Methods Name setTheStopTime
     * @Create In 2018年1月10日 By wangziqiang
     * @param theStopTime void
     */
    public void setTheStopTime(Integer theStopTime) {
        this.theStopTime = theStopTime;
    }


    /**
     * 更新成功条数
     * 
     * @Methods Name getCount
     * @Create In 2018年1月10日 By wangziqiang
     * @return Integer
     */
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
