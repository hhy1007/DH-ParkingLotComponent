/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.vo.car;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseConvert;
import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseVo;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCar;

/**
 *  车辆基本信息VO类
 *  
 * @Class Name CarVo
 * @Author zhangli
 * @Create In 2017年12月14日
 */
public class CarVo implements BaseVo<ParkCar>{

    private String uuid;
    
    @NotBlank(message = "parkinglotcomponent.car.carNumIsblank")
    private String carNum;//车牌号码

    private String carNumColor;//车牌颜色

    private String carCode;//车辆编号

    private Short carType;//汽车类型（0-普通车，1-特殊车）

    private Date validEndTime;//特殊车结束时间

    private Date validStartTime;//特殊车开始时间

    private String carMode;//车型（0-小车，1-大车，2-超大车，3-摩托车）

    private String carColor;//汽车颜色

    private String carBrand;//汽车品牌

    private String ownerId;//业主ID

    private String carPic;//车辆图片

    private String houseNo;//房号

    private Short carNumType;//车牌类型（0-普通车牌， 1-电子车牌）

    private Short listType;//黑白名单（0-普通车，1-白名单，2-黑名单）

    private Date createTime;//创建时间

    private String memo;//备注

    private Date updateTime;//更新时间

    private String updateUser;//更新人ID

    private String createUser;//创建人ID

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }
    
    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getCarNumColor() {
        return carNumColor;
    }

    public void setCarNumColor(String carNumColor) {
        this.carNumColor = carNumColor;
    }

    public Date getValidStartTime() {
        return validStartTime;
    }

    public void setValidStartTime(Date validStartTime) {
        this.validStartTime = validStartTime;
    }
    
    public Short getCarType() {
        return carType;
    }

    public void setCarType(Short carType) {
        this.carType = carType;
    }

    public Date getValidEndTime() {
        return validEndTime;
    }

    public void setValidEndTime(Date validEndTime) {
        this.validEndTime = validEndTime;
    }


    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }
    
    public String getCarMode() {
        return carMode;
    }


    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setCarMode(String carMode) {
        this.carMode = carMode;
    }

    public String getOwnerId() {
        return ownerId;
    }
    
    public void setListType(Short listType) {
        this.listType = listType;
    }
    
    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public Short getListType() {
        return listType;
    }
    
    public String getCarPic() {
        return carPic;
    }

    public void setCarPic(String carPic) {
        this.carPic = carPic;
    }

    public Short getCarNumType() {
        return carNumType;
    }

    public void setCarNumType(Short carNumType) {
        this.carNumType = carNumType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
    
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uuid=").append(uuid);
        sb.append(", carNum=").append(carNum);
        sb.append(", carCode=").append(carCode);
        sb.append(", carNumColor=").append(carNumColor);
        sb.append(", carType=").append(carType);
        sb.append(", validStartTime=").append(validStartTime);
        sb.append(", validEndTime=").append(validEndTime);
        sb.append(", carMode=").append(carMode);
        sb.append(", carBrand=").append(carBrand);
        sb.append(", carColor=").append(carColor);
        sb.append(", carPic=").append(carPic);
        sb.append(", ownerId=").append(ownerId);
        sb.append(", houseNo=").append(houseNo);
        sb.append(", listType=").append(listType);
        sb.append(", carNumType=").append(carNumType);
        sb.append(", memo=").append(memo);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateUser=").append(updateUser);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public void convertPOToVO(ParkCar poObj) {
        if(poObj != null){
            BaseConvert.convertPOToVO(poObj, this);
        }
    }

    @Override
    public ParkCar convertVOToPO() {
        ParkCar car = new ParkCar();
        BaseConvert.convertVOToPO(this, car);
        return car;
    }
}
