/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.rule.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageRequest;
import com.eg.egsc.scp.parkinglotcomponent.basic.util.SqlUtil;
import com.eg.egsc.scp.parkinglotcomponent.common.exception.ExceptionFactory;
import com.eg.egsc.scp.parkinglotcomponent.condition.rule.RuleCondition;
import com.eg.egsc.scp.parkinglotcomponent.dao.rule.ParkRuleDao;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkAuthPackageMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAuthPackage;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAuthPackageCriteria;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkRule;
import com.eg.egsc.scp.parkinglotcomponent.service.rule.ParkRuleService;
import com.eg.egsc.scp.parkinglotcomponent.service.rule.dto.RuleDto;
import com.eg.egsc.scp.parkinglotcomponent.util.ErrorCodeConstant;
import com.eg.egsc.scp.parkinglotcomponent.util.UuidUtil;

/**
 * 进出规则管理业务层接口实现
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
@Service
public class ParkRuleServiceImpl implements ParkRuleService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParkRuleDao parkRuleDao;// 数据库自定义操作接口

    @Autowired
    private ParkAuthPackageMapper parkAuthpackageMapper;

    @Override
    @Transactional
    public int insert(RuleDto ruleDto) {
        ParkRule parkRule = new ParkRule();
        BeanUtils.copyProperties(ruleDto, parkRule);
        this.insertValid(parkRule);
        parkRule.setDetail(JSON.toJSONString(ruleDto.getRuleDetailDto()));
        parkRule.setUuid(UuidUtil.generate());
        if (null == parkRule.getCreateTime()) {
            parkRule.setCreateTime(new Date());
        }
        if (null == parkRule.getDeleteFlag()) {
            parkRule.setDeleteFlag(SqlUtil.FLAG_NORMAL);
        }
        return parkRuleDao.insert(parkRule);
    }

    @Override
    @Transactional
    public int update(RuleDto ruleDto) {
        ParkRule parkRule = new ParkRule();
        BeanUtils.copyProperties(ruleDto, parkRule);
        this.updateValid(parkRule);
        parkRule.setDetail(JSON.toJSONString(ruleDto.getRuleDetailDto()));
        if (null == parkRule.getUpdateTime()) {
            parkRule.setUpdateTime(new Date());
        }
        return parkRuleDao.updateByPrimaryKey(parkRule);
    }

    private void insertValid(ParkRule parkRule) {
        if (StringUtils.isBlank(parkRule.getRuleName())) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        List<ParkRule> list = parkRuleDao.selectParkRuleByRuleName(parkRule.getRuleName());
        if (CollectionUtils.isNotEmpty(list)) {
            throw ExceptionFactory.createSysException(
                    ErrorCodeConstant.PARKINGLOT_RULE_NAME_PLATE_NUMBER_REPEATE);
        }
    }

    private void updateValid(ParkRule parkRule) {
        if (StringUtils.isBlank(parkRule.getRuleName())) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        List<ParkRule> list = parkRuleDao.selectParkRuleByRuleNameIsNotId(parkRule);
        if (CollectionUtils.isNotEmpty(list)) {
            throw ExceptionFactory.createSysException(
                    ErrorCodeConstant.PARKINGLOT_RULE_NAME_PLATE_NUMBER_REPEATE);
        }
    }

    @Override
    @Transactional
    public int deleteByIds(List<String> ids) {
        ParkAuthPackageCriteria duc = new ParkAuthPackageCriteria();
        ParkAuthPackageCriteria.Criteria ducc = duc.createCriteria();
        ducc.andParkRuleIdIn(ids);
        List<ParkAuthPackage> parkAuthPackagList = parkAuthpackageMapper.selectByExample(duc);
        if (CollectionUtils.isNotEmpty(parkAuthPackagList)) {// 进出规则是否已使用
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_RULE_PLATE_NUMBER_REPEATE);
        }
        return parkRuleDao.deleteByIds(ids);
    }

    @Override
    public Page<ParkRule> selectPageList(RuleCondition condition) {
        PageRequest<RuleCondition> pageRequest = new PageRequest<>();
        pageRequest.setCurrentPage(condition.getCurrentPage());
        pageRequest.setPageSize(condition.getPageSize());
        pageRequest.setFilters(condition);
        return parkRuleDao.selectPageList(pageRequest);
    }

    @Override
    public List<ParkRule> selectList(RuleCondition condition) {
        return parkRuleDao.selectList(condition);
    }

    @Override
    public List<ParkRule> selectByRuleIds(List<String> ids) {
        return parkRuleDao.selectByRuleIds(ids);
    }

    @Override
    public ParkRule selectByPrimaryKey(String uuid) {
        return parkRuleDao.selectByPrimaryKey(uuid);
    }

}
