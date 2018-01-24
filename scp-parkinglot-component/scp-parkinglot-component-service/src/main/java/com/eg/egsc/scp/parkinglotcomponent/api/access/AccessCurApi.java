/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.api.access;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eg.egsc.framework.client.dto.RequestDto;
import com.eg.egsc.framework.client.dto.ResponseDto;
import com.eg.egsc.scp.parkinglotcomponent.common.result.ResultCode;
import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseConvert;
import com.eg.egsc.scp.parkinglotcomponent.dto.access.AccessCurDto;
import com.eg.egsc.scp.parkinglotcomponent.service.park.ParkSelfFeesService;
import com.eg.egsc.scp.parkinglotcomponent.service.park.dto.ReFeesDto;

import io.swagger.annotations.ApiOperation;

/**
 * @Class Name AccessCurApi
 * @Author wangziqiang
 * @Create In 2018年1月10日
 */
@RestController
@RequestMapping("/api/access")
public class AccessCurApi {

    @Autowired
    private ParkSelfFeesService parkSelfFeesServiceImpl;// 自助缴费

    @PostMapping("/getAccessCur")
    @ApiOperation(value = "自助缴费api")
    public ResponseDto selectAccessCurByExample(@Valid @RequestBody RequestDto<AccessCurDto> req) {
        AccessCurDto data = req.getData();
        String nowTime = data.getNowTime();
        String carNum = data.getCarNum();
        String cardNumber = data.getCardNumber();
        ReFeesDto reFeesDto = parkSelfFeesServiceImpl.demandFees(carNum, cardNumber, nowTime);
        AccessCurDto accessCurDto = new AccessCurDto();
        ResponseDto responseDto = getDefaultResponseDto();
        if (reFeesDto != null) {
            BaseConvert.convertPOToVO(reFeesDto, accessCurDto);
            responseDto.setData(accessCurDto);
        } else {
            responseDto.setData(accessCurDto);
        }
        return responseDto;
    }

    @PostMapping("/updateAccessCur")
    @ApiOperation(value = "更新缴费记录api")
    public ResponseDto updateAccessCurByExample(@Valid @RequestBody RequestDto<AccessCurDto> req) {
        AccessCurDto data = req.getData();
        String carNum = data.getCarNum();
        String cardNumber = data.getCardNumber();
        String money = data.getMoney();
        int i = parkSelfFeesServiceImpl.updateParkAccessCur(carNum, cardNumber, money);
        AccessCurDto accessCurDto = new AccessCurDto();
        accessCurDto.setCount(i);
        ResponseDto responseDto = getDefaultResponseDto();
        responseDto.setData(accessCurDto);
        return responseDto;
    }

    protected ResponseDto getDefaultResponseDto() {
        return new ResponseDto(ResultCode.SUCCESS, null, ResultCode.SUCCESS_MESSAGE);
    }
}
