/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.dao.rule;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.eg.egsc.scp.parkinglotcomponent.basic.dao.EnhancedBaseDao;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageRequest;
import com.eg.egsc.scp.parkinglotcomponent.basic.util.SqlUtil;
import com.eg.egsc.scp.parkinglotcomponent.condition.rule.RuleCondition;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.rule.RuleMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkRuleMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkRule;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkRuleCriteria;

/**
 * 进出规则管理持久层接口
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
@Repository
public class ParkRuleDao extends EnhancedBaseDao<ParkRuleMapper, RuleMapper, ParkRule> {

    @Override
    protected void setMapperClass() {
        this.setMapperClass(ParkRuleMapper.class);
        this.setExtMapperClass(RuleMapper.class);
    }

    @Override
    protected void setEntityClass() {
        this.setEntityClass(ParkRule.class);
    }

    /**
     * 根据id查询收费规则信息
     * 
     * @param uuid
     * @return ParkCarport
     */
    public ParkRule selectByPrimaryKey(String uuid) {
        ParkRuleCriteria duc = new ParkRuleCriteria();
        ParkRuleCriteria.Criteria ducc = duc.createCriteria();
        ducc.andUuidEqualTo(uuid);
        ducc.andDeleteFlagEqualTo(SqlUtil.FLAG_NORMAL);
        List<ParkRule> parkRuleList =  this.getMapper().selectByExample(duc);
        if(CollectionUtils.isNotEmpty(parkRuleList)) {
            return parkRuleList.get(SqlUtil.INDEX);
        }
        return null;
    }
    
    /**
     * 根据多个id规则编号查询规则信息
     * 
     * @param ids
     * @return List<ParkRule>
     */
    public List<ParkRule> selectByRuleIds(List<String> ids) {
        return this.getExtMapper().selectByRuleIds(ids);
    }

    /**
     * 添加进出规则
     * 
     * @param parkRule
     * @return int
     */
    public int insert(ParkRule parkRule) {
        return this.getMapper().insert(parkRule);
    }

    /**
     * 修改进出规则
     * 
     * @param parkRule
     * @return int
     */
    public int updateByPrimaryKey(ParkRule parkRule) {
        return this.getMapper().updateByPrimaryKey(parkRule);
    }

    /**
     * 根据进出规则的名称查询进出规则的信息
     * 
     * @param ruleName
     * @return List<ParkRule>
     */
    public List<ParkRule> selectParkRuleByRuleName(String ruleName) {
        ParkRuleCriteria duc = new ParkRuleCriteria();
        ParkRuleCriteria.Criteria ducc = duc.createCriteria();
        ducc.andRuleNameEqualTo(ruleName);
        ducc.andDeleteFlagEqualTo(SqlUtil.FLAG_NORMAL);
        return this.getMapper().selectByExample(duc);
    }

    /**
     * 根据进出规则的名称和id查询不相同id进出规则的信息
     * 
     * @param parkRule
     * @return List<ParkRule>
     */
    public List<ParkRule> selectParkRuleByRuleNameIsNotId(ParkRule parkRule) {
        ParkRuleCriteria duc = new ParkRuleCriteria();
        ParkRuleCriteria.Criteria ducc = duc.createCriteria();
        ducc.andRuleNameEqualTo(parkRule.getRuleName());
        ducc.andUuidNotEqualTo(parkRule.getUuid());
        ducc.andDeleteFlagEqualTo(SqlUtil.FLAG_NORMAL);
        return this.getMapper().selectByExample(duc);
    }

    /**
     * 根据id批量删除
     * 
     * @param ids
     * @return int
     */
    public int deleteByIds(List<String> ids) {
        ParkRuleCriteria duc = new ParkRuleCriteria();
        ParkRuleCriteria.Criteria ducc = duc.createCriteria();
        ducc.andUuidIn(ids);
        ParkRule parkRule = new ParkRule();
        parkRule.setDeleteFlag(SqlUtil.FLAG_DELETE);
        return this.getMapper().updateByExampleSelective(parkRule, duc);
    }

    /**
     * 根据条件查询
     * 
     * @param condition
     * @return List<ParkRule>
     */
    public List<ParkRule> selectList(RuleCondition condition) {
        ParkRuleCriteria duc = this.getBaseCriteria(condition);
        return this.getMapper().selectByExample(duc);
    }


    /**
     * 分页查询
     * 
     * @param pageRequest
     * @return Page<ParkRule>
     */
    public Page<ParkRule> selectPageList(PageRequest<RuleCondition> pageRequest) {
        // 分页方式1：selectPageList， 通过自动生成代码实现分页，多表关联查询时不适用
        ParkRuleCriteria duc = this.getLikeBaseCriteria(pageRequest.getFilters());
        return super.selectPageList(duc, pageRequest);
    }

    /**
     * 自定义过滤条件
     * 
     * @param condition
     * @return ParkRuleCriteria
     */
    private ParkRuleCriteria getBaseCriteria(RuleCondition condition) {
        ParkRuleCriteria duc = new ParkRuleCriteria();
        ParkRuleCriteria.Criteria ducc = duc.createCriteria();
        if (StringUtils.isNotBlank(condition.getId())) {
            ducc.andUuidEqualTo(condition.getId());
        }
        if (StringUtils.isNotBlank(condition.getRuleName())) {
            ducc.andRuleNameEqualTo(condition.getRuleName());
        }
        ducc.andDeleteFlagEqualTo(SqlUtil.FLAG_NORMAL);
        return duc;
    }

    /**
     * 自定义过滤条件
     * 
     * @param condition
     * @return ParkRuleCriteria
     */
    private ParkRuleCriteria getLikeBaseCriteria(RuleCondition condition) {
        ParkRuleCriteria duc = new ParkRuleCriteria();
        ParkRuleCriteria.Criteria ducc = duc.createCriteria();
        if (StringUtils.isNotBlank(condition.getId())) {
            ducc.andUuidEqualTo(condition.getId());
        }
        if (StringUtils.isNotBlank(condition.getRuleName())) {
            ducc.andRuleNameLike("%" + condition.getRuleName() + "%");
        }
        ducc.andDeleteFlagEqualTo(SqlUtil.FLAG_NORMAL);
        duc.setOrderByClause(SqlUtil.orderDesc("create_time"));// 倒序
        return duc;
    }
}
