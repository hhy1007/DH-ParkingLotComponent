/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.rule;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.eg.egsc.framework.service.base.web.BaseWebController;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.common.page.PageVo;
import com.eg.egsc.scp.parkinglotcomponent.common.result.ResultMessage;
import com.eg.egsc.scp.parkinglotcomponent.condition.rule.FeeRuleCondition;
import com.eg.egsc.scp.parkinglotcomponent.dto.rule.FeeRuleDto;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAccessCur;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkFeeRule;
import com.eg.egsc.scp.parkinglotcomponent.service.rule.ParkFeeRuleService;
import com.eg.egsc.scp.parkinglotcomponent.service.rule.dto.ResponseBillingDto;
import com.eg.egsc.scp.parkinglotcomponent.web.vo.rule.FeeRuleVo;

/**
 * 收费规则管理管理 控制层接口
 * 
 * @Class Name ParkFeeRule
 * @Author fengrongjun
 * @Create In 2017年12月14日
 */
@RestController
@RequestMapping(value = "/feerule")
public class ParkFeeRuleController extends BaseWebController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParkFeeRuleService parkFeeRuleServiceImpl;
    
    /**
     * 通用计费接口
     * 
     * @param parkAccessCur
     * @param carType
     * @param endTime
     * @return
     * @throws ParseException ResultMessage
     */
    @RequestMapping(value = "/universalBillingInterface", method = RequestMethod.POST)
    public ResultMessage universalBillingInterface(@RequestBody ParkAccessCur parkAccessCur,
            Integer carType, @RequestParam(value = "startTime") Date endTime) throws ParseException{
        ResponseBillingDto responseBillingDto = parkFeeRuleServiceImpl.universalBillingInterface(parkAccessCur, carType, endTime);
        logger.info("ResponseBillingDto result: " + JSON.toJSONString(responseBillingDto));
        return ResultMessage.createSuccessResult(responseBillingDto);
    }
    
    /**
     * 按收费规则计费
     * 
     * @param startTime
     * @param endTime
     * @param carType
     * @param feeRuleDto
     * @return
     * @throws ParseException String
     */
    @RequestMapping(value = "/computationsFeeRule", method = RequestMethod.POST)
    public String computationsFeeRule(@RequestParam(value = "startTime")Date startTime, @RequestParam(value = "endTime")Date endTime, @RequestParam(value = "carType")Integer carType,
          @RequestBody  FeeRuleDto feeRuleDto) throws ParseException {
        String money = parkFeeRuleServiceImpl.computationsFeeRule(startTime, endTime, carType,feeRuleDto);
        logger.info("computationsFeeRule result: " + JSON.toJSONString(money));
        return money;
    }
    
    /**
     * 添加收费规则
     * 
     * @param feeRuleDto
     * @return ResultMessage
     */
    @RequestMapping(value = "/insertParkFeeRule", method = RequestMethod.POST)
    public ResultMessage insertParkFeeRule(@Valid @RequestBody FeeRuleDto feeRuleDto) {
        logger.info("insertParkFeeRule param: " + JSON.toJSONString(feeRuleDto));
        parkFeeRuleServiceImpl.insert(feeRuleDto);
        return ResultMessage.createSuccessResult(null);
    }

    /**
     * 此方法用于分页查询
     * 
     * @param condition
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException ResultMessage
     */
    @RequestMapping(value = "/queryPageData", method = RequestMethod.GET)
    public ResultMessage queryPageData(FeeRuleCondition condition)
            throws InstantiationException, IllegalAccessException {
        logger.info("selectPageList param: " + JSON.toJSONString(condition));
        Page<ParkFeeRule> page = parkFeeRuleServiceImpl.selectPageList(condition);
        PageVo<FeeRuleVo> pageVO = new PageVo<>(page, FeeRuleVo.class);
        return ResultMessage.createSuccessResult(pageVO);
    }

    /**
     * 删除收费规则
     * 
     * @param ids
     * @return ResultMessage
     */
    @RequestMapping(value = "/batchDeleteParkFeeRules", method = RequestMethod.GET)
    public ResultMessage deleteParkFeeRules(@RequestParam(value = "ids") List<String> ids) {
        logger.info("batchDeleteParkFeeRules param: " + JSON.toJSONString(ids));
        parkFeeRuleServiceImpl.deleteByIds(ids);
        return ResultMessage.createSuccessResult(null);
    }

    /**
     * 更新收费规则
     * 
     * @Methods Name updateParkRule
     * @Create In 2017年12月29日 By fengrongjun
     * @param feeRuleDto
     * @return ResultMessage
     */
    /**
     * 更新收费规则
     * 
     * @param feeRuleDto
     * @return ResultMessage
     */
    @RequestMapping(value = "/updateFeeRule", method = RequestMethod.POST)
    public ResultMessage updateParkRule(@Valid @RequestBody FeeRuleDto feeRuleDto) {
        logger.info("updateParkFeeRule param: " + JSON.toJSONString(feeRuleDto));
        parkFeeRuleServiceImpl.update(feeRuleDto);
        return ResultMessage.createSuccessResult(null);
    }
}
