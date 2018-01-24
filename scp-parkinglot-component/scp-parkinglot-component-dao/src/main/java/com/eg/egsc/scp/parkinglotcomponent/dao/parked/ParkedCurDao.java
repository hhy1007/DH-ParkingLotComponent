/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.dao.parked;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.eg.egsc.scp.parkinglotcomponent.basic.dao.EnhancedBaseDao;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageRequest;
import com.eg.egsc.scp.parkinglotcomponent.condition.cur.ParkedCarportCondition;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.parked.ParkedCurMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkParkedCurMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkLedCarportRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkedCur;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkedCurCriteria;

/**
 * 车位功能 持久层接口
 * 
 * @author gongqian
 * @since 2018年1月12日
 */
@Repository
public class ParkedCurDao
    extends EnhancedBaseDao<ParkParkedCurMapper, ParkedCurMapper, ParkParkedCur> {

  /**
   * 历史车位表分页查询
   * 
   * @param pageRequest
   * @return Page<ParkParkedCur>
   */
  public Page<ParkParkedCur> selectPageList(PageRequest<ParkedCarportCondition> pageRequest) {
    ParkParkedCurCriteria duc = this.getBaseCriteria(pageRequest.getFilters());
    return super.selectPageList(duc, pageRequest);
  }

  private ParkParkedCurCriteria getBaseCriteria(ParkedCarportCondition condition) {
    ParkParkedCurCriteria duc = new ParkParkedCurCriteria();
    ParkParkedCurCriteria.Criteria ducc = duc.createCriteria();
    if (StringUtils.isNotBlank(condition.getUuid())) {
      ducc.andUuidEqualTo(condition.getUuid());
    }
    if (StringUtils.isNotBlank(condition.getCarportCode())) {
      ducc.andCarportCodeEqualTo(condition.getCarportCode());
    }
    return duc;
  }

  /**
   * 根据车位查询车位实时表
   * 
   * @param carportCode
   * @return List<ParkParkedCur>
   */
  public List<ParkParkedCur> selectByCarportCode(String carportCode) {
    ParkParkedCurCriteria example = new ParkParkedCurCriteria();
    ParkParkedCurCriteria.Criteria ducc = example.createCriteria();
    ducc.andCarportCodeEqualTo(carportCode);
    return this.getMapper().selectByExample(example);
  }

  /**
   * 更新车位状态
   * 
   * @param parkParkedCur
   * @return int
   */
  public int updateParkType(ParkParkedCur parkParkedCur) {
    return this.getExtMapper().updateParkType(parkParkedCur);
  }

  /**
   * 根据车位ID查询区域空余车位数
   * 
   * @param carportId
   * @return int
   */
  public Integer selectAreaIdleByCarportId(ParkLedCarportRel parkLedCarportRel) {
    return this.getExtMapper().selectAreaIdleByCarportId(parkLedCarportRel);
  }

  @Override
  protected void setEntityClass() {
    this.setEntityClass(ParkParkedCur.class);

  }

  @Override
  protected void setMapperClass() {
    this.setMapperClass(ParkParkedCurMapper.class);
    this.setExtMapperClass(ParkedCurMapper.class);
  }

  /**
   * 根据车位编号修改预警状态
   * 
   * @param parkParkedCur
   * @param code
   * @return int
   */
  public int updateAlarmByCarportCode(ParkParkedCur parkParkedCur, String code) {
    ParkParkedCurCriteria duc = new ParkParkedCurCriteria();
    ParkParkedCurCriteria.Criteria ducc = duc.createCriteria();
    ducc.andCarportCodeEqualTo(code);
    return this.getMapper().updateByExampleSelective(parkParkedCur, duc);
  }

  /**
   * 根据车牌号码查询
   * 
   * @param carNum
   * @return ParkParkedCur
   */
  public List<ParkParkedCur> selectByCarNum(String carNum) {
    ParkParkedCurCriteria example = new ParkParkedCurCriteria();
    ParkParkedCurCriteria.Criteria ducc = example.createCriteria();
    ducc.andCarNumEqualTo(carNum);
    return this.getMapper().selectByExample(example);

  }
}
