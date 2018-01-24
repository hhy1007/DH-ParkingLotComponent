/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.api.charge;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eg.egsc.framework.client.dto.RequestDto;
import com.eg.egsc.framework.client.dto.ResponseDto;
import com.eg.egsc.scp.parkinglotcomponent.common.result.ResultCode;
import com.eg.egsc.scp.parkinglotcomponent.dto.charge.ChargeOnlineDto;
import com.eg.egsc.scp.parkinglotcomponent.service.charge.ParkChargeService;

import io.swagger.annotations.ApiOperation;

/**
 * 线上缴费Api
 * 
 * @author huangyuhong
 * @since 2018年1月15日
 */
@RestController
@RequestMapping(value = "/api/charge")
public class ChargeApi {
    
    @Autowired
    private ParkChargeService parkChargeServiceImpl;
    
    @PostMapping("/chargeOnline")
    @ApiOperation(value = "线上缴费api")
    public ResponseDto computationsFeeRule(@Valid @RequestBody RequestDto<ChargeOnlineDto> req)
            {
        int result = parkChargeServiceImpl.chargeOnline(req.getData());
        return new ResponseDto(ResultCode.SUCCESS, result, ResultCode.SUCCESS_MESSAGE);
    }
    
}
