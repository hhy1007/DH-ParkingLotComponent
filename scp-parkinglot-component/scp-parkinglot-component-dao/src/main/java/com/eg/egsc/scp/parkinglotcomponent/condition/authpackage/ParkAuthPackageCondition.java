/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.condition.authpackage;

import java.util.Date;
import java.util.List;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageCondition;

/**
 *套餐查询过滤条件 
 * 
 * @author huangyuhong
 * @since 2018年1月12日
 */
public class ParkAuthPackageCondition extends PageCondition {
        
    private String id;
    
    private String carNum;// 车牌号码
    
    private String ownerId;// 业主ID
    
    private String carportCode; // 车位编号
    
    private String parkCode;// 车场号
    
    private String state;// 授权状态:enable-正常状态;frozen-冻结;disable-不可用
    
    private Short deleteFlag;// 删除标记
    
    private Date nowDate;//现在时间
    
    private List<Short> carportTypes;// 车位类型：1-月租，2-产权，0-临停
    
    private String cardNumber;//卡号

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getCarportCode() {
        return carportCode;
    }

    public void setCarportCode(String carportCode) {
        this.carportCode = carportCode;
    }

    public String getParkCode() {
        return parkCode;
    }

    public void setParkCode(String parkCode) {
        this.parkCode = parkCode;
    }

    public String getState() {
        return state;
    }

    public Date getNowDate() {
        return nowDate;
    }

    public void setNowDate(Date nowDate) {
        this.nowDate = nowDate;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Short getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Short deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public List<Short> getCarportTypes() {
        return carportTypes;
    }

    public void setCarportTypes(List<Short> carportTypes) {
        this.carportTypes = carportTypes;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    
}
