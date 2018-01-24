/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.vo.rule;

import java.util.Date;

import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseConvert;
import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseVo;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkRule;

/**
 * 进出规则基本信息VO类
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public class RuleVo implements BaseVo<ParkRule> {

    private String uuid;

    private String ruleName;// 进出规则名称

    private Short carportType;// 是否是月保、产权车（0-否，1-是）

    private String detail;// 规则内容

    private String createUser;// 创建人ID

    private String memo;// 备注

    private Date createTime;// 创建时间

    private Date updateTime;// 更新时间

    private String updateUser;// 更新人ID

    public String getRuleName() {
        return ruleName;
    }

    public Short getCarportType() {
        return carportType;
    }

    public void setCarportType(Short carportType) {
        this.carportType = carportType;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getDetail() {
        return detail;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getMemo() {
        return memo;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
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

    public String getUpdateUser() {
        return updateUser;
    }

    @Override
    public void convertPOToVO(ParkRule poObj) {
        if (poObj != null) {
            BaseConvert.convertPOToVO(poObj, this);
        }
    }

    @Override
    public ParkRule convertVOToPO() {
        ParkRule parkRule = new ParkRule();
        BaseConvert.convertVOToPO(this, parkRule);
        return parkRule;
    }
}
