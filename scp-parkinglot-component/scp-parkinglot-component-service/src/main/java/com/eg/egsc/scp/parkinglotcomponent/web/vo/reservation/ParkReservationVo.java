/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.vo.reservation;

import java.util.Date;

import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseConvert;
import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseVo;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkReservation;

/**
 * @Class Name ParkReservationVo
 * @Author huangyuhong
 * @Create In 2017年12月15日
 */
public class ParkReservationVo implements BaseVo<ParkReservation> {
        
    private String uuid;

    private String parkCode;// 车场编号

    private String carNum;// 车牌号码

    private Date endTime;// 入场时间范围

    private Date startTime;// 入场时间范围

    private String consumerName;// 客户姓名

    private String serialNumber;// 预约编号

    private Short enterModel;// 预约车辆入场模式：0-不自动放行，1-自动放行

    private String phoneNumber;// 客户电话

    private String accessId;// 停车记录id

    private Short exitModel;// 预约车辆出场模式：0-不自动放行，收费为0元,1-自动放行，2-按收费规则收费

    private String memo;// 备注

    private String notifyUrl;// 车辆进出时通知接口

    private Date updateTime;// 更新时间

    private Date createTime;// 创建时间
    
    private String updateUser;// 更新时间

    private String createUser;// 创建时间

    

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }
    
    public String getParkCode() {
        return parkCode;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setParkCode(String parkCode) {
        this.parkCode = parkCode;
    }

    public Date getEndTime() {
        return endTime;
    }
    
    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public Short getEnterModel() {
        return enterModel;
    }

    public void setEnterModel(Short enterModel) {
        this.enterModel = enterModel;
    }
    
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Short getExitModel() {
        return exitModel;
    }

    public void setExitModel(Short exitModel) {
        this.exitModel = exitModel;
    }
    
    public String getAccessId() {
        return accessId;
    }

    public void setAccessId(String accessId) {
        this.accessId = accessId;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
    
    
    @Override
    public void convertPOToVO(ParkReservation poObj) {
        if (poObj != null) {
            BaseConvert.convertPOToVO(poObj, this);
        }
    }

    @Override
    public ParkReservation convertVOToPO() {
        ParkReservation parkReservation = new ParkReservation();
        BaseConvert.convertVOToPO(this, parkReservation);
        return parkReservation;
    }

}
