/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.vo.access;

import java.io.Serializable;
import java.util.Date;

import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseConvert;
import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseVo;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAccessCur;

/**
 * 在场车辆基本信息VO类
 * 
 * @Class Name AccessVo
 * @Author xiangdaoping
 * @Create In 2017年12月15日
 */
public class AccesscurVo implements Serializable, BaseVo<ParkAccessCur> {

    /**
     * @Field long serialVersionUID
     */
    private static final long serialVersionUID = 3710378031815609446L;

    private String carNum;

    private String uuid;

    private String ownerId;

    private String cardNumber;

    private String parkCode;

    private String parkPackageId;

    private Short carportType;

    private String inCameraCode;

    private Date createTime;

    private String inImgUrl;

    private String inChannelId;

    private Short enterMode;

    private String courtUuid;

    private Short needPay;

    private String inNumUrl;

    private Date updateTime;

    private String inMemo;

    private Short carType;

    private String carMode;

    private Integer payedMoney;

    /**
     * @Param Short carType to set
     */
    public void setCarType(Short carType) {
        this.carType = carType;
    }

    /**
     * @Return the Short carType
     */
    public Short getCarType() {
        return carType;
    }

    /**
     * @Param String id to set
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * @Return the String id
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @Param String carNum to set
     */
    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    /**
     * @Return the String carNum
     */
    public String getCarNum() {
        return carNum;
    }



    public String getCourtUuid() {
        return courtUuid;
    }

    public void setCourtUuid(String courtUuid) {
        this.courtUuid = courtUuid;
    }

    public String getCarMode() {
        return carMode;
    }

    public void setCarMode(String carMode) {
        this.carMode = carMode;
    }

    /**
     * @Param String ownerId to set
     */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * @Return the String ownerId
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * @Param String parkCode to set
     */
    public void setParkCode(String parkCode) {
        this.parkCode = parkCode;
    }

    /**
     * @Return the String parkCode
     */
    public String getParkCode() {
        return parkCode;
    }

    /**
     * @Param String cardNumber to set
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * @Return the String cardNumber
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * @Param Short carportType to set
     */
    public void setCarportType(Short carportType) {
        this.carportType = carportType;
    }

    /**
     * @Return the Short carportType
     */
    public Short getCarportType() {
        return carportType;
    }

    /**
     * @Param String parkPackageId to set
     */
    public void setParkPackageId(String parkPackageId) {
        this.parkPackageId = parkPackageId;
    }

    /**
     * @Return the String parkPackageId
     */
    public String getParkPackageId() {
        return parkPackageId;
    }

    /**
     * @Param Date inTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @Return the Date inTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @Param String inCameraCode to set
     */
    public void setInCameraCode(String inCameraCode) {
        this.inCameraCode = inCameraCode;
    }

    /**
     * @Return the String inCameraCode
     */
    public String getInCameraCode() {
        return inCameraCode;
    }

    /**
     * @Param String inChannelId to set
     */
    public void setInChannelId(String inChannelId) {
        this.inChannelId = inChannelId;
    }

    /**
     * @Return the String inChannelId
     */
    public String getInChannelId() {
        return inChannelId;
    }

    /**
     * @Param String inImgUrl to set
     */
    public void setInImgUrl(String inImgUrl) {
        this.inImgUrl = inImgUrl;
    }

    /**
     * @Return the String inImgUrl
     */
    public String getInImgUrl() {
        return inImgUrl;
    }

    public String getInMemo() {
        return inMemo;
    }

    public void setInMemo(String inMemo) {
        this.inMemo = inMemo;
    }

    /**
     * @Param String inNumUrl to set
     */
    public void setInNumUrl(String inNumUrl) {
        this.inNumUrl = inNumUrl;
    }

    /**
     * @Return the String inNumUrl
     */
    public String getInNumUrl() {
        return inNumUrl;
    }

    /**
     * @Param Short enterMode to set
     */
    public void setEnterMode(Short enterMode) {
        this.enterMode = enterMode;
    }

    /**
     * @Return the Short enterMode
     */
    public Short getEnterMode() {
        return enterMode;
    }

    /**
     * @Param Short needPay to set
     */
    public void setNeedPay(Short needPay) {
        this.needPay = needPay;
    }


    /**
     * @Return the Short needPay
     */
    public Short getNeedPay() {
        return needPay;
    }

    /**
     * @Param Integer payedMoney to set
     */
    public void setPayedMoney(Integer payedMoney) {
        this.payedMoney = payedMoney;
    }

    /**
     * @Return the Integer payedMoney
     */
    public Integer getPayedMoney() {
        return payedMoney;
    }

    /**
     * @Param Date lastPayedTime to set
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @Return the Date lastPayedTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public ParkAccessCur convertVOToPO() {
        ParkAccessCur accesscur = new ParkAccessCur();
        BaseConvert.convertVOToPO(this, accesscur);
        return accesscur;
    }

    @Override
    public void convertPOToVO(ParkAccessCur poObj) {
        if (poObj != null) {
            BaseConvert.convertPOToVO(poObj, this);
        }

    }



    /**
     * 
     */
    public AccesscurVo() {
        super();
    }

}
