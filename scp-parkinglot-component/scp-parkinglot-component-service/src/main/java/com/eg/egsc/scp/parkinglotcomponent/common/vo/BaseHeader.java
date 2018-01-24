/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.common.vo;

/**
 * @Class Name BaseHeader
 * @Author zhangli
 * @Create In 2017年12月14日
 */
public class BaseHeader {

    private String businessId;

    private String sourceSysId;

    private String targetSysId;

    private String createTimestamp;

    private String contentType;

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getSourceSysId() {
        return sourceSysId;
    }

    public void setSourceSysId(String sourceSysId) {
        this.sourceSysId = sourceSysId;
    }

    public String getTargetSysId() {
        return targetSysId;
    }

    public void setTargetSysId(String targetSysId) {
        this.targetSysId = targetSysId;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }


}
