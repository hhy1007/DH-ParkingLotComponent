/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.dto.car;

import java.util.Date;

import com.eg.egsc.framework.client.dto.BaseBusinessDto;

/**
 * @Class Name CarDto
 * @Author zhangli
 * @Create In 2017年12月15日
 */
public class CarDto extends BaseBusinessDto{

    /**
     * @Field long serialVersionUID 
     */
    private static final long serialVersionUID = -6155981401447991288L;

    private String id;

    private String carNumFuzzy;//车辆编号模糊查询
    
    private String carNum;//车牌号码

    private Short carType;//汽车类型（0-普通车，1-特殊车）

    private String carCode;//车辆编号

    private Date validEndTime;//有效期结束时间

    private Date validStartTime;//有效期开始时间

    private String carMode;//车型（0-小车，1-大车，2-超大车，3-摩托车）

    private String carColor;//汽车颜色

    private String carBrand;//汽车品牌

    private Short listType;//黑白名单（0-普通车，1-白名单，2-黑名单）

    private String houseNo;//房号

    private String ownerId;//业主ID

    public String getId() {
        return id;
    }

    /**
     * 车辆ID
     * @param id void
     */
    public void setId(String id) {
        this.id = id;
    }

    public String getCarNum() {
        return carNum;
    }

    /**
     * 车辆编号
     * @param carCode void
     */
    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }

    public Short getCarType() {
        return carType;
    }

    /**
     * 车牌号码
     * @param carNum void
     */
    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getCarCode() {
        return carCode;
    }

    /**
     * 汽车类型（0-普通车，1-特殊车）
     * @param carType void
     */
    public void setCarType(Short carType) {
        this.carType = carType;
    }
    
    public String getCarMode() {
        return carMode;
    }

    /**
     * 车型（0-小车，1-大车，2-超大车，3-摩托车）
     * @param carMode void
     */
    public void setCarMode(String carMode) {
        this.carMode = carMode;
    }

    public Date getValidStartTime() {
        return validStartTime;
    }

    /**
     * 有效期结束时间
     * @param validEndTime void
     */
    public void setValidEndTime(Date validEndTime) {
        this.validEndTime = validEndTime;
    }

    public String getCarBrand() {
        return carBrand;
    }

    /**
     * 汽车品牌
     * @param carBrand void
     */
    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarColor() {
        return carColor;
    }

    /**
     * 有效期开始时间
     * @param validStartTime void
     */
    public void setValidStartTime(Date validStartTime) {
        this.validStartTime = validStartTime;
    }

    public Date getValidEndTime() {
        return validEndTime;
    }

    /**
     * 汽车颜色
     * @param carColor void
     */
    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getOwnerId() {
        return ownerId;
    }

    /**
     * 房号
     * @param houseNo void
     */
    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public Short getListType() {
        return listType;
    }
    
    /**
     * 业主ID
     * @param ownerId void
     */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getHouseNo() {
        return houseNo;
    }

    /**
     * 车辆编号模糊查询
     * @param carNumFuzzy void
     */
    public void setCarNumFuzzy(String carNumFuzzy) {
        this.carNumFuzzy = carNumFuzzy;
    }

    /**
     * 黑白名单（0-普通车，1-白名单，2-黑名单）
     * @param listType void
     */
    public void setListType(Short listType) {
        this.listType = listType;
    }

    public String getCarNumFuzzy() {
        return carNumFuzzy;
    }
}
