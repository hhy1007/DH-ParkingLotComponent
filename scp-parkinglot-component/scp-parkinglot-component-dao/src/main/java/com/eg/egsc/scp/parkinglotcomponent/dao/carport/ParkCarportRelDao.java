/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.dao.carport;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.eg.egsc.scp.parkinglotcomponent.basic.dao.EnhancedBaseDao;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageRequest;
import com.eg.egsc.scp.parkinglotcomponent.basic.util.SqlUtil;
import com.eg.egsc.scp.parkinglotcomponent.condition.park.CarportRelCondition;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.carport.CarportRelMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkLedCarportRelMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkLedCarportRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkLedCarportRelCriteria;

/**
 * 诱导屏绑定车位管理持久层接口
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
@Repository
public class ParkCarportRelDao extends
        EnhancedBaseDao<ParkLedCarportRelMapper, CarportRelMapper, ParkLedCarportRel> {

    @Override
    protected void setMapperClass() {
        this.setMapperClass(ParkLedCarportRelMapper.class);
        this.setExtMapperClass(CarportRelMapper.class);
    }

    @Override
    protected void setEntityClass() {
        this.setEntityClass(ParkLedCarportRel.class);
    }
    
    /**
     * 根据led设备编号(集合)查询车位与设备绑定信息
     * 
     * @param ledCodes
     * @return List<ParkLedCarportRel>
     */
    public List<ParkLedCarportRel> selectLedCarportRelByLedCode(String ledCode){
        ParkLedCarportRelCriteria duc = new ParkLedCarportRelCriteria();
        ParkLedCarportRelCriteria.Criteria ducc = duc.createCriteria();
        ducc.andLedCodeEqualTo(ledCode);
        return this.getMapper().selectByExample(duc);
    }
    
    /**
     * 根据led设备编(集合)号删除车位与设备绑定信息
     * 
     * @param ledCodes
     * @return int
     */
    public int deleteByLedCode(String ledCode) {
        ParkLedCarportRelCriteria duc = new ParkLedCarportRelCriteria();
        ParkLedCarportRelCriteria.Criteria ducc = duc.createCriteria();
        ducc.andLedCodeEqualTo(ledCode);
        return this.getMapper().deleteByExample(duc);
    }

    /**
     * 批量插入通到与设备绑定
     * 
     * @param parkLedCarportRels
     * @return int
     */
    public int insertBatchCarportRel(List<ParkLedCarportRel> parkLedCarportRels) {
        return this.getExtMapper().insertBatchCarportRel(parkLedCarportRels);
    }
    
    /**
     * 根据id批量删除
     * 
     * @param ids
     * @return int
     */
    public int deleteByIds(List<String> ids) {
        ParkLedCarportRelCriteria duc = new ParkLedCarportRelCriteria();
        ParkLedCarportRelCriteria.Criteria ducc = duc.createCriteria();
        ducc.andUuidIn(ids);
        return this.getMapper().deleteByExample(duc);
    }

    /**
     * 根据条件查询
     * 
     * @param condition
     * @return List<ParkLedCarportRel>
     */
    public List<ParkLedCarportRel> selectList(CarportRelCondition condition) {
        ParkLedCarportRelCriteria duc = this.getBaseCriteria(condition);
        return this.getMapper().selectByExample(duc);
    }

    /**
     * 分页查询
     * 
     * @param pageRequest
     * @return Page<ParkLedCarportRel>
     */
    public Page<ParkLedCarportRel> selectPageList(PageRequest<CarportRelCondition> pageRequest) {
        // 分页方式1：selectPageList， 通过自动生成代码实现分页，多表关联查询时不适用
        ParkLedCarportRelCriteria duc = this.getBaseCriteria(pageRequest.getFilters());
        return super.selectPageList(duc, pageRequest);
    }

    /**
     * 自定义过滤条件
     * 
     * @param condition
     * @return ParkLedCarportRelCriteria
     */
    private ParkLedCarportRelCriteria getBaseCriteria(CarportRelCondition condition) {
        ParkLedCarportRelCriteria duc = new ParkLedCarportRelCriteria();
        ParkLedCarportRelCriteria.Criteria ducc = duc.createCriteria();
        if (StringUtils.isNotBlank(condition.getId())) {
            ducc.andUuidEqualTo(condition.getId());
        }
        if (StringUtils.isNotBlank(condition.getCarportId())) {
            ducc.andCarportIdEqualTo(condition.getCarportId());
        }
        if (StringUtils.isNotBlank(condition.getLedCode())) {
            ducc.andLedCodeEqualTo(condition.getLedCode());
        }
        duc.setOrderByClause(SqlUtil.orderDesc("create_time"));//倒序
        return duc;
    }

}
