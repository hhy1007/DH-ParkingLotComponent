/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.condition.car;

import java.util.Date;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageCondition;


/**
 * 车辆信息查询过滤条件
 * 
 * @author huangyuhong
 * @since 2018年1月12日
 */
public class CarCondition extends PageCondition{
    
    private String id;

    private String carNum;//车牌号码
    
    private String carNumFuzzy;//车辆编号模糊查询

    private String carCode;//车辆编号

    private Short carType;//汽车类型（0-普通车，1-特殊车）

    private Date validStartTime;//有效期开始时间

    private Date validEndTime;//有效期结束时间

    private String carMode;//车型（0-小车，1-大车，2-超大车，3-摩托车）

    private String carBrand;//汽车品牌

    private String carColor;//汽车颜色

    private String ownerId;//业主ID

    private String houseNo;//房号

    private Short listType;//黑白名单（0-普通车，1-白名单，2-黑名单）
    
    private Short deleteFlag;// '删除标记：0-正常,1-删除'

    public String getId() {
        return id;
    }

    /**
     * 车辆ID
     * @Methods Name setId
     * @Create In 2017年12月14日 By zhangli
     * @param id void
     */
    public void setId(String id) {
        this.id = id;
    }

    public String getCarNum() {
        return carNum;
    }

    /**
     * 车牌号码
     * @Methods Name setId
     * @Create In 2017年12月14日 By zhangli
     * @param id void
     */
    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getCarCode() {
        return carCode;
    }

    /**
     * 车辆编号
     * @Methods Name setId
     * @Create In 2017年12月14日 By zhangli
     * @param id void
     */
    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }

    public Short getCarType() {
        return carType;
    }

    /**
     * 汽车类型（0-普通车，1-特殊车）
     * @Methods Name setId
     * @Create In 2017年12月14日 By zhangli
     * @param id void
     */
    public void setCarType(Short carType) {
        this.carType = carType;
    }

    public Date getValidStartTime() {
        return validStartTime;
    }

    /**
     * 有效期开始时间
     * @Methods Name setId
     * @Create In 2017年12月14日 By zhangli
     * @param id void
     */
    public void setValidStartTime(Date validStartTime) {
        this.validStartTime = validStartTime;
    }

    public Date getValidEndTime() {
        return validEndTime;
    }

    /**
     * 有效期结束时间
     * @Methods Name setId
     * @Create In 2017年12月14日 By zhangli
     * @param id void
     */
    public void setValidEndTime(Date validEndTime) {
        this.validEndTime = validEndTime;
    }

    public String getCarMode() {
        return carMode;
    }

    /**
     * 车型（0-小车，1-大车，2-超大车，3-摩托车）
     * @Methods Name setId
     * @Create In 2017年12月14日 By zhangli
     * @param id void
     */
    public void setCarMode(String carMode) {
        this.carMode = carMode;
    }

    public String getCarBrand() {
        return carBrand;
    }

    /**
     * 汽车品牌
     * @Methods Name setId
     * @Create In 2017年12月14日 By zhangli
     * @param id void
     */
    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarColor() {
        return carColor;
    }

    /**
     * 汽车颜色
     * @Methods Name setId
     * @Create In 2017年12月14日 By zhangli
     * @param id void
     */
    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getOwnerId() {
        return ownerId;
    }

    

    public String getHouseNo() {
        return houseNo;
    }

    /**
     * 房号
     * @Methods Name setId
     * @Create In 2017年12月14日 By zhangli
     * @param id void
     */
    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }
    
    /**
     * 业主ID
     * @Methods Name setId
     * @Create In 2017年12月14日 By zhangli
     * @param id void
     */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Short getListType() {
        return listType;
    }

    /**
     * 黑白名单（0-普通车，1-白名单，2-黑名单）
     * @Methods Name setId
     * @Create In 2017年12月14日 By zhangli
     * @param id void
     */
    public void setListType(Short listType) {
        this.listType = listType;
    }

    public String getCarNumFuzzy() {
        return carNumFuzzy;
    }

    /**
     * 车辆编号模糊查询
     * @Methods Name setId
     * @Create In 2017年12月14日 By zhangli
     * @param id void
     */
    public void setCarNumFuzzy(String carNumFuzzy) {
        this.carNumFuzzy = carNumFuzzy;
    }

    public Short getDeleteFlag() {
        return deleteFlag;
    }
    
    /**
     *  '删除标记：0-正常,1-删除'
     * @Methods Name setDeleteFlag
     * @Create In 2018年1月8日 By huangyuhong
     * @param deleteFlag void
     */
    public void setDeleteFlag(Short deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

}
