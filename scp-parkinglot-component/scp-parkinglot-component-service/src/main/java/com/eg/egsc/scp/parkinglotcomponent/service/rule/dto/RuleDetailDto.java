/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.rule.dto;

import java.io.Serializable;

/**
 * 规则内容dto
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public class RuleDetailDto implements Serializable{

    /**
     * @Field long serialVersionUID 
     */
    private static final long serialVersionUID = 429600133092611504L;

    private Integer openWay;// 放行方式:0：进出人工确认放行，1：进出自动放行，2：进场人工确认放行，3：出场人工确认放行

    private Integer fullCarportAllowCarIn;// 车位已满是否可进场:0-不可进、1-可进、

    private Integer monthWarrantyCar;// 月保车:0，是；1，不是

    private Integer monthCarEndTurnTemp;// 月保车过期转临停车，0，过期还是按月保车进出场；1，过期按临停车进出场  2。不让进

    private Integer privateParkSeatFullTurnTemp;// 个人车位已满转临停车，0，不转临停；1：转临停车

    private Integer payMoney;// 月保车或者产权车，每个月缴费金额

    
    public Integer getFullCarportAllowCarIn() {
        return fullCarportAllowCarIn;
    }

    public void setFullCarportAllowCarIn(Integer fullCarportAllowCarIn) {
        this.fullCarportAllowCarIn = fullCarportAllowCarIn;
    }

    public Integer getOpenWay() {
        return openWay;
    }

    public void setOpenWay(Integer openWay) {
        this.openWay = openWay;
    }

    public Integer getMonthWarrantyCar() {
        return monthWarrantyCar;
    }

    public void setMonthWarrantyCar(Integer monthWarrantyCar) {
        this.monthWarrantyCar = monthWarrantyCar;
    }

    public Integer getMonthCarEndTurnTemp() {
        return monthCarEndTurnTemp;
    }

    public void setMonthCarEndTurnTemp(Integer monthCarEndTurnTemp) {
        this.monthCarEndTurnTemp = monthCarEndTurnTemp;
    }

    public Integer getPrivateParkSeatFullTurnTemp() {
        return privateParkSeatFullTurnTemp;
    }

    public void setPrivateParkSeatFullTurnTemp(Integer privateParkSeatFullTurnTemp) {
        this.privateParkSeatFullTurnTemp = privateParkSeatFullTurnTemp;
    }

    public Integer getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Integer payMoney) {
        this.payMoney = payMoney;
    }
}
