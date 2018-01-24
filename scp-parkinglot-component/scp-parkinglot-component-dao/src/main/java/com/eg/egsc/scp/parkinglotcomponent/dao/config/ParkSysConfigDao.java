/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.dao.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.eg.egsc.scp.parkinglotcomponent.basic.dao.EnhancedBaseDao;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageRequest;
import com.eg.egsc.scp.parkinglotcomponent.condition.config.ParkSysConfigCondition;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.config.ConfigMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkSysConfigMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkSysConfig;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkSysConfigCriteria;

/**
 * 系统设置表持久层
 * 
 * @author liudongteng
 * @since 2018年1月22日
 */
@Repository
public class ParkSysConfigDao extends EnhancedBaseDao<ParkSysConfigMapper, ConfigMapper, ParkSysConfig> {
  
  /**
   * 根据条件更新
   * 
   * @param parkSysConfig
   * @param condition
   * @return int
   */
  public int updateByCondition(ParkSysConfig parkSysConfig, ParkSysConfigCondition condition) {
    ParkSysConfigCriteria duc = this.getBaseCriteria(condition);
    return this.getMapper().updateByExampleSelective(parkSysConfig, duc);
  }
  /**
   * 系统设置表查询条件
   * 
   * @param pageRequest
   * @return Page<ParkSysConfig>
   */
  public Page<ParkSysConfig> selectPageList(PageRequest<ParkSysConfigCondition> pageRequest) {
    ParkSysConfigCriteria duc = this.getBaseCriteria(pageRequest.getFilters());
    return super.selectPageList(duc, pageRequest);
  }
  
  private ParkSysConfigCriteria getBaseCriteria(ParkSysConfigCondition condition) {
    ParkSysConfigCriteria duc = new ParkSysConfigCriteria();
    ParkSysConfigCriteria.Criteria ducc = duc.createCriteria();
    if(StringUtils.isNotBlank(condition.getConfigType())) {
      ducc.andConfigTypeEqualTo(condition.getConfigType());
    }
    if (StringUtils.isNotBlank(condition.getConfigName())) {
      ducc.andConfigNameEqualTo(condition.getConfigName());
    }
    if (condition.getConfigSeq() != null) {
      ducc.andConfigSeqEqualTo(condition.getConfigSeq());
    }
    if (StringUtils.isNotBlank(condition.getConfigPar1())) {
      ducc.andConfigPar1EqualTo(condition.getConfigPar1());
    }
    if(StringUtils.isNotBlank(condition.getConfigPar2())) {
      ducc.andConfigPar2EqualTo(condition.getConfigPar2());
    }
    if(StringUtils.isNotBlank(condition.getConfigPar3())) {
      ducc.andConfigPar3EqualTo(condition.getConfigPar3());
    }
    if(condition.getEnableFlag()!= null) {
      ducc.andEnableFlagEqualTo(condition.getEnableFlag());
    }
    if(condition.getCreateTime()!=null) {
      ducc.andCreateTimeEqualTo(condition.getCreateTime());
    }
    if(condition.getUpdateTime()!=null) {
      ducc.andUpdateTimeEqualTo(condition.getUpdateTime());
    }
    if(StringUtils.isNotBlank(condition.getCreateUser())) {
      ducc.andCreateUserEqualTo(condition.getCreateUser());
    }
    if(StringUtils.isNotBlank(condition.getUpdateUser())) {
      ducc.andUpdateUserEqualTo(condition.getUpdateUser());
    }
    return duc;
  }
  
  @Override
  protected void setEntityClass() {
    this.setEntityClass(ParkSysConfig.class);
  }

  @Override
  protected void setMapperClass() {
    this.setMapperClass(ParkSysConfigMapper.class);
  }

}
