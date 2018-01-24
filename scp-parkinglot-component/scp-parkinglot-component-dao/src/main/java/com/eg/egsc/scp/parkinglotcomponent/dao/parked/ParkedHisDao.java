package com.eg.egsc.scp.parkinglotcomponent.dao.parked;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.eg.egsc.scp.parkinglotcomponent.basic.dao.EnhancedBaseDao;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageRequest;
import com.eg.egsc.scp.parkinglotcomponent.condition.cur.ParkedCarportCondition;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.parked.ParkedHisMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkParkedHisMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkedHis;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkedHisCriteria;

/**
 * 停车历史表持久层接口
 * 
 * @author liudongteng
 * @since 2018年1月15日
 */
@Repository
public class ParkedHisDao
    extends EnhancedBaseDao<ParkParkedHisMapper, ParkedHisMapper, ParkParkedHis> {

  /**
   * 历史车位表分页查询
   * 
   * @param pageRequest
   * @return Page<ParkParkedHis>
   */
  public Page<ParkParkedHis> selectPageList(PageRequest<ParkedCarportCondition> pageRequest) {
    ParkParkedHisCriteria duc = this.getBaseCriteria(pageRequest.getFilters());
    return super.selectPageList(duc, pageRequest);
  }

  private ParkParkedHisCriteria getBaseCriteria(ParkedCarportCondition condition) {
    ParkParkedHisCriteria duc = new ParkParkedHisCriteria();
    ParkParkedHisCriteria.Criteria ducc = duc.createCriteria();
    if (StringUtils.isNotBlank(condition.getUuid())) {
      ducc.andUuidEqualTo(condition.getUuid());
    }
    if (StringUtils.isNotBlank(condition.getCarportCode())) {
      ducc.andCarportCodeEqualTo(condition.getCarportCode());
    }
    return duc;
  }

  @Override
  protected void setMapperClass() {
    this.setMapperClass(ParkParkedHisMapper.class);
    this.setExtMapperClass(ParkedHisMapper.class);
  }

  /**
   * 根据车位编号查询
   * 
   * @param carportCode
   * @return ParkParkedCur
   */
  public List<ParkParkedHis> selectByCarportCode(String carportCode) {
    ParkParkedHisCriteria example = new ParkParkedHisCriteria();
    ParkParkedHisCriteria.Criteria ducc = example.createCriteria();
    ducc.andCarportCodeEqualTo(carportCode);
    return this.getMapper().selectByExample(example);
  }

  @Override
  protected void setEntityClass() {
    this.setEntityClass(ParkParkedHis.class);
  }

  /**
   * 根据车牌号码查询
   * 
   * @param carNum
   * @return ParkParkedCur
   */
  public List<ParkParkedHis> selectByCarNum(String carNum) {
    ParkParkedHisCriteria example = new ParkParkedHisCriteria();
    ParkParkedHisCriteria.Criteria ducc = example.createCriteria();
    ducc.andCarNumEqualTo(carNum);
    return this.getMapper().selectByExample(example);

  }
}
