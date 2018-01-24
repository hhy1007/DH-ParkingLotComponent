/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.rule;

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
import com.eg.egsc.scp.parkinglotcomponent.condition.rule.RuleCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkRule;
import com.eg.egsc.scp.parkinglotcomponent.service.rule.ParkRuleService;
import com.eg.egsc.scp.parkinglotcomponent.service.rule.dto.RuleDto;
import com.eg.egsc.scp.parkinglotcomponent.web.vo.rule.RuleVo;

/**
 * 进出规则管理 控制层接口
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
@RestController
@RequestMapping(value = "/rule")
public class ParkRuleController extends BaseWebController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParkRuleService parkRuleServiceImpl;

    /**
     * 添加进出规则
     * 
     * @param ruleDto
     * @return ResultMessage
     */
    @RequestMapping(value = "/insertParkRule", method = RequestMethod.POST)
    public ResultMessage insertParkRule(@Valid @RequestBody RuleDto ruleDto) {
        logger.info("insertParkRule param: " + JSON.toJSONString(ruleDto));
        parkRuleServiceImpl.insert(ruleDto);
        return ResultMessage.createSuccessResult(null);
    }

    /**
     * 此方法用于分页查询
     * 
     * @param ruleCondition
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException ResultMessage
     */
    @RequestMapping(value = "/queryPageData", method = RequestMethod.GET)
    public ResultMessage queryPageData(RuleCondition ruleCondition)
            throws InstantiationException, IllegalAccessException {
        logger.info("selectPageList param: " + JSON.toJSONString(ruleCondition));
        Page<ParkRule> page = parkRuleServiceImpl.selectPageList(ruleCondition);
        PageVo<RuleVo> pageVO = new PageVo<>(page, RuleVo.class);
        return ResultMessage.createSuccessResult(pageVO);
    }

    /**
     * 删除进出规则
     * 
     * @param ids
     * @return ResultMessage
     */
    @RequestMapping(value = "/batchDeleteParkRules", method = RequestMethod.GET)
    public ResultMessage deleteParkRules(@RequestParam(value = "ids") List<String> ids) {
        logger.info("batchDeleteParkRules param: " + JSON.toJSONString(ids));
        parkRuleServiceImpl.deleteByIds(ids);
        return ResultMessage.createSuccessResult(null);
    }

    /**
     * 更新进出规则
     * 
     * @param ruleDto
     * @return ResultMessage
     */
    @RequestMapping(value = "/updateRule", method = RequestMethod.POST)
    public ResultMessage updateParkRule(@Valid @RequestBody RuleDto ruleDto) {
        logger.info("updateParkRule param: " + JSON.toJSONString(ruleDto));
        parkRuleServiceImpl.update(ruleDto);
        return ResultMessage.createSuccessResult(null);
    }
}
