/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.vo.rule;

import java.util.Date;

import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseConvert;
import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseVo;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkFeeRule;

/**
 * 收费规则管理管理基本信息VO类
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public class FeeRuleVo implements BaseVo<ParkFeeRule> {

    private String memo;// 备注

    private String uuid;

    private String ruleName;// 进出规则的名称

    private String updateUser;// 更新人ID

    private String detail;// 规则内

    private String ruleType;// 类型:time-按次,interval-时段

    private Date updateTime;// 更新时间

    private Date createTime;// 创建时间

    private String createUser;// 创建人ID

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public String getRuleType() {
        return ruleType;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }

    public String getMemo() {
        return memo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }


    @Override
    public void convertPOToVO(ParkFeeRule poObj) {
        if (poObj != null) {
            BaseConvert.convertPOToVO(poObj, this);
        }
    }

    @Override
    public ParkFeeRule convertVOToPO() {
        ParkFeeRule parkFeeRule = new ParkFeeRule();
        BaseConvert.convertVOToPO(this, parkFeeRule);
        return parkFeeRule;
    }

}
