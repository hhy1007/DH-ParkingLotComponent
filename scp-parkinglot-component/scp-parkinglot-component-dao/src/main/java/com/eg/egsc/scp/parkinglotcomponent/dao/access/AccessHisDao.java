/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.dao.access;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;
/**
 * 车辆进出历史记录更新
 * @Class Name AccessHisDao
 * @Author wangziqiang
 * @Create In 2017年12月25日
 */

import com.eg.egsc.scp.parkinglotcomponent.basic.dao.EnhancedBaseDao;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageRequest;
import com.eg.egsc.scp.parkinglotcomponent.condition.access.AccessHisCondition;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.access.AccessHisMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkAccessHisMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAccessHis;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAccessHisCriteria;
@Repository
public class AccessHisDao extends EnhancedBaseDao<ParkAccessHisMapper, AccessHisMapper, ParkAccessHis> {

  @Override
  protected void setMapperClass() {
    this.setMapperClass(ParkAccessHisMapper.class);
    this.setExtMapperClass(AccessHisMapper.class);
  }

  @Override
  protected void setEntityClass() {
    this.setEntityClass(ParkAccessHis.class);
  }
  /**
   * 更新有需要字段的车辆进出记录
   * @Methods Name updateParkAccessHis
   * @Create In 2017年12月25日 By wangziqiang
   * @param record
   * @return int
   */
  public int updateParkAccessHis(ParkAccessHis record) {   
    return this.getMapper().updateByPrimaryKeySelective(record);
  }
  /**
   * 分页查询
   * @Methods Name selectPageList
   * @Create In 2017年12月15日 By xiangdaoping
   * @param pageRequest
   * @return Page<ParkAccessHis>
   */
  public Page<ParkAccessHis> selectPageList(PageRequest<AccessHisCondition> pageRequest) {
    ParkAccessHisCriteria duc = this.getBaseCriteria(pageRequest.getFilters());
      return super.selectPageList(duc, pageRequest);
  }
  
  
  /**
   * 查询车辆进出信息
   * @Methods Name countNumber
   * @Create In 2017年12月14日 By xiangdaoping
   * @param condition
   * @return int
   */
  public List<ParkAccessHis> selectList(AccessHisCondition condition) {
    ParkAccessHisCriteria duc = this.getBaseCriteria(condition);
      return this.getMapper().selectByExample(duc);
  }
  
  /**
   * 自定义过滤条件
   * @Methods Name ParkAccessHisCriteria
   * @Create In 2017年12月15日 By xiangdaoping
   * @param condition
   * @return ParkCarCriteria
   */
  public ParkAccessHisCriteria getBaseCriteria(AccessHisCondition condition) {
    ParkAccessHisCriteria duc = new ParkAccessHisCriteria();
    ParkAccessHisCriteria.Criteria ducc = duc.createCriteria();
    if (StringUtils.isNotBlank(condition.getId())) {
          ducc.andUuidEqualTo(condition.getId());
      }
    if (StringUtils.isNotBlank(condition.getCarNum())) {
          ducc.andCarNumEqualTo(condition.getCarNum());
      }
    if (StringUtils.isNotBlank(condition.getParkCode())) {
          ducc.andParkCodeEqualTo(condition.getParkCode());
      }
    if (StringUtils.isNotBlank(condition.getCardNumber())) {
          ducc.andCardNumberEqualTo(condition.getParkCode());
      }
    if (condition.getInTime()!=null) {
          ducc.andCreateTimeEqualTo(condition.getInTime());
      }
    if (StringUtils.isNotBlank(condition.getInCameraCode())) {
          ducc.andInCameraCodeEqualTo(condition.getInCameraCode());
      }
    if (StringUtils.isNotBlank(condition.getInSluiceCode())) {
          ducc.andInSluiceCodeEqualTo(condition.getInSluiceCode());
      }
    if (StringUtils.isNotBlank(condition.getOutCarNum())) {
          ducc.andOutCarNumEqualTo(condition.getOutCarNum());
      }
    if (condition.getOutTime()!=null) {
          ducc.andUpdateTimeEqualTo(condition.getOutTime());
      }
    if (condition.getCarType()!=null) {
          ducc.andCarTypeEqualTo(condition.getCarType());
      }
    if (condition.getCarStatus()!=null) {
          ducc.andCarStatusEqualTo(condition.getCarStatus());
      }
    if (StringUtils.isNotBlank(condition.getForceOperator())) {
          ducc.andForceOperatorEqualTo(condition.getForceOperator());
      }
     return duc;
  }
  
  
}
