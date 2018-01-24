/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.dao.syscode;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.eg.egsc.scp.parkinglotcomponent.basic.dao.EnhancedBaseDao;
import com.eg.egsc.scp.parkinglotcomponent.condition.syscode.ParkSysCodeCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkSysCodeMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkSysCode;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkSysCodeCriteria;

/**
 * 字典表持久层接口
 * 
 * @author huangyuhong
 * @since 2018年1月12日
 */
@Repository
public class ParkSysCodeDao extends EnhancedBaseDao<ParkSysCodeMapper, ParkSysCodeMapper, ParkSysCode> {

    @Override
    protected void setEntityClass() {
        this.setMapperClass(ParkSysCodeMapper.class);
        this.setExtMapperClass(ParkSysCodeMapper.class);
    }

    @Override
    protected void setMapperClass() {
        this.setEntityClass(ParkSysCode.class);
    }
    
    /**
     * 条件查询
     * 
     * @param condition
     * @return List<ParkSysCode>
     */
    public List<ParkSysCode> selectList(ParkSysCodeCondition condition) {
        ParkSysCodeCriteria duc = this.getBaseCriteria(condition);
        return this.getMapper().selectByExample(duc);
    }
    
    /**
     * 自定义过滤条件
     * 
     * @param condition
     * @return ParkSysCodeCriteria
     */
    private ParkSysCodeCriteria getBaseCriteria(ParkSysCodeCondition condition) {
        ParkSysCodeCriteria duc = new ParkSysCodeCriteria();
        ParkSysCodeCriteria.Criteria ducc = duc.createCriteria();
        if (StringUtils.isNotBlank(condition.getItemCode())) {
            ducc.andItemCodeEqualTo(condition.getItemCode());
        }
        if (StringUtils.isNotBlank(condition.getItemName())) {
            ducc.andItemNameEqualTo(condition.getItemName());
        }
        if (StringUtils.isNotBlank(condition.getParentCode())) {
            ducc.andParentCodeEqualTo(condition.getParentCode());
        }
        if(StringUtils.isNotBlank(condition.getTypeCode())) {
            ducc.andTypeCodeEqualTo(condition.getTypeCode());
        }
        if(StringUtils.isNotBlank(condition.getMemo())) {
            ducc.andMemoEqualTo(condition.getMemo());
        }
        if(condition.getEnableFlag() != null) {
            ducc.andEnableFlagEqualTo(condition.getEnableFlag());
        }
        if(StringUtils.isNotBlank(condition.getOrderByClause())) {
            duc.setOrderByClause(condition.getOrderByClause());
        }else {
            duc.setOrderByClause("sort");
        }
        return duc;
    }

}
