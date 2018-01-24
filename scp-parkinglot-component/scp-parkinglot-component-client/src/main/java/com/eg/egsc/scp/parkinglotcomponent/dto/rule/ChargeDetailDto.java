/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.dto.rule;

import java.io.Serializable;

/**
 * 价格明细
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public class ChargeDetailDto implements Serializable {
    
    /**
     * @Field long serialVersionUID 
     */
    private static final long serialVersionUID = 357861394479651485L;

    private NonPeakPeriodDto nonPeakPeriodDto;//非高峰期
    
    private PeakPeriodDto peakPeriodDto;//高峰期
    
    
    public NonPeakPeriodDto getNonPeakPeriodDto() {
        return nonPeakPeriodDto;
    }
    
    public PeakPeriodDto getPeakPeriodDto() {
        return peakPeriodDto;
    }
    
    public void setNonPeakPeriodDto(NonPeakPeriodDto nonPeakPeriodDto) {
        this.nonPeakPeriodDto = nonPeakPeriodDto;
    }

    public void setPeakPeriodDto(PeakPeriodDto peakPeriodDto) {
        this.peakPeriodDto = peakPeriodDto;
    }

    
}
