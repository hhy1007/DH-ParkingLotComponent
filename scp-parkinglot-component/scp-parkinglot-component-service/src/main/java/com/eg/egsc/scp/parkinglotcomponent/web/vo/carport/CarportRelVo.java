/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.vo.carport;

import java.util.Date;

import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseConvert;
import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseVo;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkLedCarportRel;

/**
 * 诱导屏绑定车位管理基本信息VO类
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public class CarportRelVo implements BaseVo<ParkLedCarportRel> {

    private String createUser;// 创建人ID

    private String carportId;// 车位ID

    private String uuid;

    private String ledCode;// LED设备编号

    private Date createTime;// 创建时间

    public String getLedCode() {
        return ledCode;
    }
    

    public String getUuid() {
        return uuid;
    }

    public String getCarportId() {
        return carportId;
    }

    public void setLedCode(String ledCode) {
        this.ledCode = ledCode;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setCarportId(String carportId) {
        this.carportId = carportId;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    @Override
    public void convertPOToVO(ParkLedCarportRel poObj) {
        if (poObj != null) {
            BaseConvert.convertPOToVO(poObj, this);
        }
    }

    @Override
    public ParkLedCarportRel convertVOToPO() {
        ParkLedCarportRel parkLedCarportRel = new ParkLedCarportRel();
        BaseConvert.convertVOToPO(this, parkLedCarportRel);
        return parkLedCarportRel;
    }

}
