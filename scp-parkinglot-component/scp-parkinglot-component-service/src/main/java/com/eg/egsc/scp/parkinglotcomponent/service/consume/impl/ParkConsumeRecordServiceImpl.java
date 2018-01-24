/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.consume.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageRequest;
import com.eg.egsc.scp.parkinglotcomponent.condition.consume.ConsumeRecordCondition;
import com.eg.egsc.scp.parkinglotcomponent.dao.consume.ParkConsumeRecordDao;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkConsumeRecordMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkConsumeRecord;
import com.eg.egsc.scp.parkinglotcomponent.service.consume.ParkConsumeRecordService;

/**
 * 收费记录服务层接口实现
 * @Class Name ParkConsumeRecordService
 * @Author xiaoxiaojie
 * @Create In 2017年12月18日
 */
@Service
public class ParkConsumeRecordServiceImpl implements ParkConsumeRecordService {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    ParkConsumeRecordMapper parkConsumeRecordMapper;
    
    @Autowired
    ParkConsumeRecordDao parkConsumeRecordDao;
    
    @Override
    public Page<ParkConsumeRecord> selectPageConsumeRecordList(
            ConsumeRecordCondition consumeRecordCondition) {
       PageRequest<ConsumeRecordCondition> pageRequest = new PageRequest<>();
       pageRequest.setCurrentPage(consumeRecordCondition.getCurrentPage());
       pageRequest.setPageSize(consumeRecordCondition.getPageSize());
       pageRequest.setFilters(consumeRecordCondition);
        return parkConsumeRecordDao.selectPageList(pageRequest);
    }
    
    
}
