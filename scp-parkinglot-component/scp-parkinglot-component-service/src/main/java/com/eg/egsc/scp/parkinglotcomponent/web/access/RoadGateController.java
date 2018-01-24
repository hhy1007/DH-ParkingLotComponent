/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.access;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eg.egsc.framework.service.base.web.BaseWebController;
import com.eg.egsc.scp.parkinglotcomponent.common.result.ResultMessage;
import com.eg.egsc.scp.parkinglotcomponent.service.access.RoadGateService;
import com.eg.egsc.scp.parkinglotcomponent.service.integration.dto.CarInOutDto;

/**
 * 
 * @Class Name RoadGateController
 * @Author xiaoxiaojie
 * @Create In 2017年12月22日
 */
@RestController
@RequestMapping(value = "/access")
public class RoadGateController extends BaseWebController {
    
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    RoadGateService roadGateServiceImpl;
    
    @RequestMapping(value = "/sluice", method = RequestMethod.POST)
    public ResultMessage manualSwitchOffRoadGage(@RequestParam(name = "sluiceCode") String sluiceCode,
            @RequestParam(name = "controlType") int controlType,@RequestBody CarInOutDto carInfo) {

        logger.info("sluiceCode="+sluiceCode+",controlType="+controlType+",carInfo="+carInfo.toString());
        String result = roadGateServiceImpl.cutOffRoadGateCommand(sluiceCode, controlType, carInfo);
        return ResultMessage.createSuccessResult(result);
    }
     
}
