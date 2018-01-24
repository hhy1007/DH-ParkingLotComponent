/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.dao.charge;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.eg.egsc.scp.parkinglotcomponent.basic.dao.EnhancedBaseDao;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageRequest;
import com.eg.egsc.scp.parkinglotcomponent.condition.charge.ChargeCondition;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.charge.ChargeMapper;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.charge.entity.Charge;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkChargeMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCharge;

/**
 * 充值管理持久层接口
 * 
 * @author huangyuhong
 * @since 2018年1月12日
 */
@Repository
public class ParkChargeDao extends EnhancedBaseDao<ParkChargeMapper, ChargeMapper, ParkCharge> {

    @Override
    protected void setEntityClass() {
        this.setMapperClass(ParkChargeMapper.class);
        this.setExtMapperClass(ChargeMapper.class);
        this.setCustomMapper(ChargeMapper.class);
    }

    @Override
    protected void setMapperClass() {
        this.setEntityClass(ParkCharge.class);
    }
    
    /**
     * 根据条件查询数量
     * 
     * @param condition
     * @return int
     */
    public int countNumber(ChargeCondition condition) {
        return this.getExtMapper().countByExample(condition);
    }
    
    /**
     * 条件查询
     * 
     * @param condition
     * @return List<Charge>
     */
    public List<Charge> selectList(ChargeCondition condition) {
        return this.getExtMapper().selectByExample(condition);
    }
    
    /**
     * 分页条件查询
     * 
     * @param pageRequest
     * @return Page<Charge>
     */
    public Page<Charge> selectPageList(PageRequest<ChargeCondition> pageRequest) {
        return super.selectCustomSqlPageList(pageRequest);
    }

}
