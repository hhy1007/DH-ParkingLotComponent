/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.consume;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.condition.consume.ConsumeRecordCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkConsumeRecord;

/**
 * 收费记录服务层接口
 * @Class Name IParkComsumeRecordService
 * @Author xiaoxiaojie
 * @Create In 2017年12月18日
 */
public interface ParkConsumeRecordService {
    
    /**
     * 查询收费记录 分页查询
     * @Methods Name selectPageConsumeRecordList
     * @Create In 2017年12月18日 By xiaoxiaojie
     * @param consumeRecordCondition
     * @return Page<ParkConsumeRecord>
     */
    Page<ParkConsumeRecord> selectPageConsumeRecordList(ConsumeRecordCondition consumeRecordCondition);
}
