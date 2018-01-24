/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.dao.consume;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.eg.egsc.scp.parkinglotcomponent.basic.dao.EnhancedBaseDao;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageRequest;
import com.eg.egsc.scp.parkinglotcomponent.condition.consume.ConsumeRecordCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkConsumeRecordMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkConsumeRecord;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkConsumeRecordCriteria;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkConsumeRecordCriteria.Criteria;

/**
 * 消费记录持久层接口
 * 
 * @Class Name ParkConsumeRecordDao
 * @Author xiaoxiaojie
 * @Create In 2017年12月18日
 */
@Repository
public class ParkConsumeRecordDao extends
        EnhancedBaseDao<ParkConsumeRecordMapper, ParkConsumeRecordMapper, ParkConsumeRecord> {

    @Override
    protected void setEntityClass() {
        this.setMapperClass(ParkConsumeRecordMapper.class);
        this.setExtMapperClass(ParkConsumeRecordMapper.class);

    }

    @Override
    protected void setMapperClass() {
        this.setEntityClass(ParkConsumeRecord.class);
    }

    /**
     * 分页查询
     * 
     * @Methods Name selectPageList
     * @Create In 2017年12月18日 By xiaoxiaojie
     * @param pageRequest
     * @return Page<ParkConsumeRecord>
     */
    public Page<ParkConsumeRecord> selectPageList(PageRequest<ConsumeRecordCondition> pageRequest) {

        // 分页方式1：selectPageList， 通过自动生成代码实现分页，多表关联查询时不适用
        ParkConsumeRecordCriteria duc = this.getBaseCriteria(pageRequest.getFilters());
        return super.selectPageList(duc, pageRequest);
        // 分页方式二：selectCustomSqlPageList， 通过自定义sql语句实现分页，适用于所有场景
    }

    /**
     * 自定义过滤条件
     * 
     * @Methods Name getBaseCriteria
     * @Create In 2017年12月18日 By xiaoxiaojie
     * @param consumeRecordCondition
     * @return ParkConsumeRecordCriteria
     */
    private ParkConsumeRecordCriteria getBaseCriteria(
            ConsumeRecordCondition consumeRecordCondition) {
        ParkConsumeRecordCriteria duc = new ParkConsumeRecordCriteria();
        Criteria ducc = duc.createCriteria();
        if (StringUtils.isNotBlank(consumeRecordCondition.getCarNum())) {
            ducc.andCardNumberEqualTo(consumeRecordCondition.getCarNum());
        }

        if (consumeRecordCondition.getFeeType() != null) {
            ducc.andFeeTypeEqualTo(consumeRecordCondition.getFeeType());
        }

        if (consumeRecordCondition.getConsumeStartTime() != null
                && consumeRecordCondition.getConsumeEndTime() != null) {
            ducc.andCreateTimeBetween(consumeRecordCondition.getConsumeStartTime(),
                    consumeRecordCondition.getConsumeEndTime());
        }
        return duc;
    }

    /**
     * 插入消费记录
     * 
     * @Methods Name insertConsumeRecord
     * @Create In 2017年12月25日 By wangziqiang
     * @param parkConsumeRecord void
     * @return
     */
    public int insertConsumeRecord(ParkConsumeRecord parkConsumeRecord) {
        return this.getMapper().insertSelective(parkConsumeRecord);
    }
}
