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
import com.eg.egsc.scp.parkinglotcomponent.condition.rule.FeeRuleCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkFeeRuleMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkFeeRule;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkFeeRuleCriteria;

/**
 * 收费规则管理持久层接口
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
@Repository
public class ParkFeeRuleDao
        extends EnhancedBaseDao<ParkFeeRuleMapper, ParkFeeRuleMapper, ParkFeeRule> {

    @Override
    protected void setMapperClass() {
        this.setMapperClass(ParkFeeRuleMapper.class);
        this.setExtMapperClass(ParkFeeRuleMapper.class);
    }

    @Override
    protected void setEntityClass() {
        this.setEntityClass(ParkFeeRule.class);
    }

    /**
     * 根据id查询收费规则信息
     * 
     * @param uuid
     * @return ParkCarport
     */
    public ParkFeeRule selectByPrimaryKey(String uuid) {
        ParkFeeRuleCriteria duc = new ParkFeeRuleCriteria();
        ParkFeeRuleCriteria.Criteria ducc = duc.createCriteria();
        ducc.andUuidEqualTo(uuid);
        ducc.andDeleteFlagEqualTo(SqlUtil.FLAG_NORMAL);
        List<ParkFeeRule> parkFeeRuleList =  this.getMapper().selectByExample(duc);
        if(CollectionUtils.isNotEmpty(parkFeeRuleList)) {
            return parkFeeRuleList.get(SqlUtil.INDEX);
        }
        return null;
    }
    
    /**
     * 添加收费规则
     * 
     * @param parkFeeRule
     * @return int
     */
    public int insert(ParkFeeRule parkFeeRule) {
        return this.getMapper().insert(parkFeeRule);
    }

    /**
     * 修改收费规则
     * 
     * @param parkFeeRule
     * @return int
     */
    public int updateByPrimaryKey(ParkFeeRule parkFeeRule) {
        return this.getMapper().updateByPrimaryKey(parkFeeRule);
    }

    /**
     * 根据收费规则的名称查询收费规则的信息
     * 
     * @param ruleName
     * @return List<ParkFeeRule>
     */
    public List<ParkFeeRule> selectParkFeeRuleByRuleName(String ruleName) {
        ParkFeeRuleCriteria duc = new ParkFeeRuleCriteria();
        ParkFeeRuleCriteria.Criteria ducc = duc.createCriteria();
        ducc.andRuleNameEqualTo(ruleName);
        ducc.andDeleteFlagEqualTo(SqlUtil.FLAG_NORMAL);
        return this.getMapper().selectByExample(duc);
    }

    /**
     * 根据收费规则的名称和id查询不相同的id收费规则的信息
     * 
     * @param parkFeeRule
     * @return List<ParkFeeRule>
     */
    public List<ParkFeeRule> selectParkFeeRuleByRuleNameIsNotId(ParkFeeRule parkFeeRule) {
        ParkFeeRuleCriteria duc = new ParkFeeRuleCriteria();
        ParkFeeRuleCriteria.Criteria ducc = duc.createCriteria();
        ducc.andRuleNameEqualTo(parkFeeRule.getRuleName());
        ducc.andUuidNotEqualTo(parkFeeRule.getUuid());
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
        ParkFeeRuleCriteria duc = new ParkFeeRuleCriteria();
        ParkFeeRuleCriteria.Criteria ducc = duc.createCriteria();
        ducc.andUuidIn(ids);
        ParkFeeRule parkFeeRule = new ParkFeeRule();
        parkFeeRule.setDeleteFlag(SqlUtil.FLAG_DELETE);
        return this.getMapper().updateByExampleSelective(parkFeeRule, duc);
    }

    /**
     * 根据条件查询
     * 
     * @param condition
     * @return List<ParkFeeRule>
     */
    public List<ParkFeeRule> selectList(FeeRuleCondition condition) {
        ParkFeeRuleCriteria duc = this.getBaseCriteria(condition);
        return this.getMapper().selectByExample(duc);
    }


    /**
     * 分页查询
     * 
     * @param pageRequest
     * @return Page<ParkFeeRule>
     */
    public Page<ParkFeeRule> selectPageList(PageRequest<FeeRuleCondition> pageRequest) {
        // 分页方式1：selectPageList， 通过自动生成代码实现分页，多表关联查询时不适用
        ParkFeeRuleCriteria duc = this.getLikeBaseCriteria(pageRequest.getFilters());
        return super.selectPageList(duc, pageRequest);
    }

    /**
     * 自定义过滤条件
     * 
     * @param condition
     * @return ParkFeeRuleCriteria
     */
    private ParkFeeRuleCriteria getBaseCriteria(FeeRuleCondition condition) {
        ParkFeeRuleCriteria duc = new ParkFeeRuleCriteria();
        ParkFeeRuleCriteria.Criteria ducc = duc.createCriteria();
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
     * 自定义过滤模糊条件
     * 
     * @param condition
     * @return ParkFeeRuleCriteria
     */
    private ParkFeeRuleCriteria getLikeBaseCriteria(FeeRuleCondition condition) {
        ParkFeeRuleCriteria duc = new ParkFeeRuleCriteria();
        ParkFeeRuleCriteria.Criteria ducc = duc.createCriteria();
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
