/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.park.dto;

import java.util.Date;

import com.eg.egsc.scp.parkinglotcomponent.dto.rule.FeeRuleDto;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAccessCur;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAuthPackage;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkingLot;
import com.eg.egsc.scp.parkinglotcomponent.service.rule.dto.RuleDto;
/***
 * IC出去的信息dto
 * @Class Name OutParkParkingByIcDto
 * @Author wangziqiang
 * @Create In 2018年1月19日
 */
public class OutParkParkingByIcDto {

    private String devCode;// 刷卡设备id

    private ParkChannel parkChannel;// 通道类

    private ParkAccessCur parkAccessCur;// 在场记录

    private ParkParkingLot parkParkingLot;// 停车场

    private ParkAuthPackage parkAuthPackage;// 授权套餐

    private RuleDto ruleDto;// 出入规则

    private FeeRuleDto feeRuleDto;// 服务规则Dto

    private String outSluiceCode;// 出场的杆子CODE

    private Date endTime;// 结束时间

    private String outImgurl;// 出场图片

    private int operateType;// 放杆方式

    public RuleDto getRuleDto() {
        return ruleDto;
    }

    public void setRuleDto(RuleDto ruleDto) {
        this.ruleDto = ruleDto;
    }

    public ParkParkingLot getParkParkingLot() {
        return parkParkingLot;
    }

    public void setParkParkingLot(ParkParkingLot parkParkingLot) {
        this.parkParkingLot = parkParkingLot;
    }

    public ParkAccessCur getParkAccessCur() {
        return parkAccessCur;
    }

    public void setParkAccessCur(ParkAccessCur parkAccessCur) {
        this.parkAccessCur = parkAccessCur;
    }

    public String getDevCode() {
        return devCode;
    }

    public void setDevCode(String devCode) {
        this.devCode = devCode;
    }

    public ParkChannel getParkChannel() {
        return parkChannel;
    }

    public void setParkChannel(ParkChannel parkChannel) {
        this.parkChannel = parkChannel;
    }

    public ParkAuthPackage getParkAuthPackage() {
        return parkAuthPackage;
    }

    public void setParkAuthPackage(ParkAuthPackage parkAuthPackage) {
        this.parkAuthPackage = parkAuthPackage;
    }

    public FeeRuleDto getFeeRuleDto() {
        return feeRuleDto;
    }

    public void setFeeRuleDto(FeeRuleDto feeRuleDto) {
        this.feeRuleDto = feeRuleDto;
    }

    public String getOutSluiceCode() {
        return outSluiceCode;
    }

    public void setOutSluiceCode(String outSluiceCode) {
        this.outSluiceCode = outSluiceCode;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getOutImgurl() {
        return outImgurl;
    }

    public void setOutImgurl(String outImgurl) {
        this.outImgurl = outImgurl;
    }

    public int getOperateType() {
        return operateType;
    }

    public void setOperateType(int operateType) {
        this.operateType = operateType;
    }

}
