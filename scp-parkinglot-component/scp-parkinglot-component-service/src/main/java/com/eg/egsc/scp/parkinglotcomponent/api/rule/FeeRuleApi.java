/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.api.rule;

import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eg.egsc.framework.client.dto.RequestDto;
import com.eg.egsc.framework.client.dto.ResponseDto;
import com.eg.egsc.scp.parkinglotcomponent.common.result.ResultCode;
import com.eg.egsc.scp.parkinglotcomponent.dto.rule.RequestFeeRuleDto;
import com.eg.egsc.scp.parkinglotcomponent.service.rule.ParkFeeRuleService;

import io.swagger.annotations.ApiOperation;

/**
 * 按收费规则计费api
 * 
 * @author fengrongjun
 * @since 2018年1月15日
 */
@RestController
@RequestMapping("/api/rule")
public class FeeRuleApi {

    @Autowired
    private ParkFeeRuleService parkFeeRuleServiceImpl;

    @PostMapping("/feeRule")
    @ApiOperation(value = "按收费规则计费api")
    public ResponseDto computationsFeeRule(@Valid @RequestBody RequestDto<RequestFeeRuleDto> req)
            throws ParseException {
        RequestFeeRuleDto requestFeeRuleDto = req.getData();
        String sumMoney = parkFeeRuleServiceImpl.computationsFeeRule(
                requestFeeRuleDto.getStartTime(), requestFeeRuleDto.getEndTime(),
                requestFeeRuleDto.getCarType(), requestFeeRuleDto.getFeeRuleDto());
        requestFeeRuleDto.setSumMoney(sumMoney);
        return this.getDefaultResponseDto(requestFeeRuleDto);
    }
    
    protected ResponseDto getDefaultResponseDto(Object obj) {
        return new ResponseDto(ResultCode.SUCCESS, obj, ResultCode.SUCCESS_MESSAGE);
    }
}
