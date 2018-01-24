/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.dao.hand;

import org.springframework.stereotype.Repository;
import com.eg.egsc.scp.parkinglotcomponent.basic.dao.EnhancedBaseDao;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.hand.HandRecordMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkHandRecordMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkHandRecord;

/**
 * 异常操作持久层
 * @Class Name ParkHandRecordDao
 * @Author wangziqiang
 * @Create In 2018年1月5日
 */
@Repository
public class ParkHandRecordDao  extends EnhancedBaseDao<ParkHandRecordMapper, HandRecordMapper, ParkHandRecord>{

  @Override
  protected void setMapperClass() {
    this.setExtMapperClass(HandRecordMapper.class);
    this.setMapperClass(ParkHandRecordMapper.class);
  }

  @Override
  protected void setEntityClass() {
    this.setEntityClass(ParkHandRecord.class); 
  }
    
  /**
   * 插入一条异常操作记录
   * @Methods Name insertOneParkHandRecord
   * @Create In 2018年1月5日 By wangziqiang
   * @param parkHandRecord
   * @return int
   */
  public int insertOneParkHandRecord(ParkHandRecord parkHandRecord) {
    return  this.getMapper().insert(parkHandRecord);   
  }
  
  
}
