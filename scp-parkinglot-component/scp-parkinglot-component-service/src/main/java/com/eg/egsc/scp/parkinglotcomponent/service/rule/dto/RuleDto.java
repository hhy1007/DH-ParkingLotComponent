/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.rule.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 进出规则基本信息dto类
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public class RuleDto implements Serializable{

    /**
     * @Field long serialVersionUID 
     */
    private static final long serialVersionUID = -693509515233676118L;

    private String ruleName;// 进出规则的名称

    private Short carportType;// 是否是月保、产权车（0-否，1-是）

    private String uuid;

    private String memo;// 备注

    private String detail;// 规则内容

    private Date updateTime;// 更新时间

    private String createUser;// 创建人ID

    private Date createTime;// 创建时间

    private String courtUuid;
    
    private RuleDetailDto ruleDetailDto;

    private String updateUser;// 更新人ID

    private Short deleteFlag;
    
    public String getCourtUuid() {
        return courtUuid;
    }

    public Short getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Short deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public void setRuleDetailDto(RuleDetailDto ruleDetailDto) {
        this.ruleDetailDto = ruleDetailDto;
    }

    public Short getCarportType() {
        return carportType;
    }

    public void setCourtUuid(String courtUuid) {
        this.courtUuid = courtUuid;
    }
    
    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }


    public RuleDetailDto getRuleDetailDto() {
        return ruleDetailDto;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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

    public String getRuleName() {
        return ruleName;
    }

    public String getDetail() {
        return detail;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMemo() {
        return memo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public String getCreateUser() {
        return createUser;
    }
}
