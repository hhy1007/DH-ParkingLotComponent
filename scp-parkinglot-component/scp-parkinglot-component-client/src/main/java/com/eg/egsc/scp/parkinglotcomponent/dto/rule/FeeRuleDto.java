/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.dto.rule;

import java.util.Date;
import java.util.List;

/**
 * 收费规则管理管理基本信息dto类
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public class FeeRuleDto {
    
    private String ruleType;//类型:time-按次,interval-时段

    private String uuid;
    
    private String detail;
    
    private Date createTime;// 创建时间

    private String ruleName;// 进出规则的名称

    private List<ChargeInfoDto> chargeInfoDtoList;//收费信息

    private String memo;// 备注

    private String createUser;// 创建人ID
    
    private Date updateTime;// 更新时间
    
    private String courtUuid;

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

    public List<ChargeInfoDto> getChargeInfoDtoList() {
        return chargeInfoDtoList;
    }
    
    public void setCourtUuid(String courtUuid) {
        this.courtUuid = courtUuid;
    }
    
    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public void setChargeInfoDtoList(List<ChargeInfoDto> chargeInfoDtoList) {
        this.chargeInfoDtoList = chargeInfoDtoList;
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

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getRuleName() {
        return ruleName;
    }
    
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getDetail() {
        return detail;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
    public void setDetail(String detail) {
        this.detail = detail;
    }
    
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getMemo() {
        return memo;
    }

    public Date getCreateTime() {
        return createTime;
    }


    public Date getUpdateTime() {
        return updateTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }


    
}
