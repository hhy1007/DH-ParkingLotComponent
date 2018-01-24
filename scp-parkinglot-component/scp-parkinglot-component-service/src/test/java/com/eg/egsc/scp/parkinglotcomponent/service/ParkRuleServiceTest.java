/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.eg.egsc.framework.client.core.ClientConfig;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.condition.rule.RuleCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkRule;
import com.eg.egsc.scp.parkinglotcomponent.service.rule.ParkRuleService;
import com.eg.egsc.scp.parkinglotcomponent.service.rule.dto.RuleDetailDto;
import com.eg.egsc.scp.parkinglotcomponent.service.rule.dto.RuleDto;
import com.eg.egsc.scp.parkinglotcomponent.util.Constants;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClientConfig.class})
public class ParkRuleServiceTest {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource // 自动注入,默认按名称
    private ParkRuleService parkRuleServiceImpl;

    @Test
    @Transactional
    @Rollback(true)
    public void selectByPrimaryKey() {
        ParkRule parkRule = parkRuleServiceImpl.selectByPrimaryKey("23315656");
        logger.info("=== " + JSON.toJSONString(parkRule));
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void insertParkRule() {
        RuleDetailDto ruleDetailDto = new RuleDetailDto();
        RuleDto ruleDto = new RuleDto();
        ruleDto.setCreateTime(new Date());
        ruleDto.setCreateUser("d");
        ruleDto.setMemo("2哈哈");
        ruleDto.setRuleName("月保小车4");
        ruleDto.setCarportType(Constants.PARK_TYPE_NO);
        ruleDetailDto.setFullCarportAllowCarIn(Constants.COUNCT);
        ruleDetailDto.setMonthCarEndTurnTemp(Constants.COUNCT);
        ruleDetailDto.setMonthWarrantyCar(Constants.COUNCT);
        ruleDetailDto.setOpenWay(Constants.COUNCT);
        ruleDetailDto.setPrivateParkSeatFullTurnTemp(Constants.COUNCT);
        ruleDetailDto.setPayMoney(200);
        ruleDto.setRuleDetailDto(ruleDetailDto);
        int result = 0;
        try {
            result = parkRuleServiceImpl.insert(ruleDto);
        } catch (Exception e) {
            logger.info("=== " + e.getMessage());
        }
        logger.info("=== " + result);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void updateParkRule() {
        RuleDetailDto ruleDetailDto1 = new RuleDetailDto();
        RuleDto ruleDto1 = new RuleDto();
        ruleDto1.setUuid("f69eb34946434c4eac347e00d60a24a5");
        ruleDto1.setCreateTime(new Date());
        ruleDto1.setCreateUser("ad");
        ruleDto1.setMemo("e哈哈");
        ruleDto1.setRuleName("月保小车3");
        ruleDto1.setCarportType(Constants.PARK_TYPE_NO);
        ruleDetailDto1.setFullCarportAllowCarIn(Constants.COUNCT);
        ruleDetailDto1.setMonthCarEndTurnTemp(Constants.COUNCT);
        ruleDetailDto1.setMonthWarrantyCar(Constants.COUNCT);
        ruleDetailDto1.setOpenWay(Constants.COUNCT);
        ruleDetailDto1.setPrivateParkSeatFullTurnTemp(Constants.COUNCT);
        ruleDetailDto1.setPayMoney(500);
        ruleDto1.setRuleDetailDto(ruleDetailDto1);
        int result = 0;
        try {
            result = parkRuleServiceImpl.update(ruleDto1);
        } catch (Exception e) {
            logger.info("=== " + e.getMessage());
        }
        logger.info("=== " + result);
    }


    @Test
    @Transactional
    @Rollback(true)
    public void batchParkRules() {
        List<String> ids = new ArrayList<>();
        ids.add("11");
        int result = parkRuleServiceImpl.deleteByIds(ids);
        logger.info("=== " + result);
    }


    @Test
    @Transactional
    @Rollback(true)
    public void selectPageList() {
        RuleCondition condition = new RuleCondition();
        condition.setPageSize(20);
        condition.setCurrentPage(1);
        condition.setRuleName("22");
        Page<ParkRule> page = parkRuleServiceImpl.selectPageList(condition);
        logger.info("=== " + JSON.toJSONString(page));
    }

    @Test
    @Transactional
    @Rollback(true)
    public void selectList() {
        RuleCondition condition = new RuleCondition();
        condition.setRuleName("2222");
        List<ParkRule> list = parkRuleServiceImpl.selectList(condition);
        logger.info("=== " + JSON.toJSONString(list));
    }

    @Test
    @Transactional
    @Rollback(true)
    public void selectByRuleIds() {
        List<String> ids = new ArrayList<>();
        List<ParkRule> rule = parkRuleServiceImpl.selectByRuleIds(ids);
        logger.info("=== " + JSON.toJSONString(rule));
    }
}


