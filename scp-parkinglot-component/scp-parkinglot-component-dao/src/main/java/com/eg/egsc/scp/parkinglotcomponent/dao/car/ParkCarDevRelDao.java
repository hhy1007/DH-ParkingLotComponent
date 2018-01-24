/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.dao.car;

import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.eg.egsc.scp.parkinglotcomponent.basic.dao.EnhancedBaseDao;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.car.CarDevRelMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkCarDevRelMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarDevRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarDevRelCriteria;

/**
 * 设备下发管理持久层接口
 * 
 * @author huangyuhong
 * @since 2018年1月12日
 */
@Repository
public class ParkCarDevRelDao extends EnhancedBaseDao<ParkCarDevRelMapper, CarDevRelMapper, ParkCarDevRel> {

    @Override
    protected void setEntityClass() {
        this.setMapperClass(ParkCarDevRelMapper.class);
        this.setExtMapperClass(CarDevRelMapper.class);
        this.setCustomMapper(CarDevRelMapper.class);
    }

    @Override
    protected void setMapperClass() {
        this.setEntityClass(ParkCarDevRel.class);
    }
    
    /**
     * 批量新增
     * 
     * @param parkCarDevRels
     * @return int
     */
    public int insertPackageCarRelBatch(List<ParkCarDevRel> parkCarDevRels) {
        return this.getExtMapper().insertPackageCarRelBatch(parkCarDevRels);
    }
    
    /**
     * 根据车牌号批量更新车辆下发
     * 
     * @param carDevRel
     * @param carNums
     * @return int
     */
    public int updateByCarNums(ParkCarDevRel carDevRel, List<String> carNums) {
        if (CollectionUtils.isEmpty(carNums)) {
            return 0;
        }
        ParkCarDevRelCriteria duc = new ParkCarDevRelCriteria();
        ParkCarDevRelCriteria.Criteria ducc = duc.createCriteria();
        ducc.andCarNumIn(carNums);
        return this.getMapper().updateByExampleSelective(carDevRel, duc);
    }
    
    /**
     * 根据设备号删除车辆下发
     * 
     * @param carDevRel
     * @param carNums
     * @return int
     */
    public int deleteByDevCode(String devCode) {
        if (StringUtils.isEmpty(devCode)) {
            return 0;
        }
        ParkCarDevRelCriteria duc = new ParkCarDevRelCriteria();
        ParkCarDevRelCriteria.Criteria ducc = duc.createCriteria();
        ducc.andDevCodeEqualTo(devCode);
        return this.getMapper().deleteByExample(duc);
    }
    
    /**
     * 根据设备号查询下发表
     * 
     * @param devCode
     * @return List<ParkCarDevRel>
     */
    public List<ParkCarDevRel> selectBydevCode(String devCode) {
        if(StringUtils.isBlank(devCode)) {
            return Collections.emptyList();
        }
        ParkCarDevRelCriteria duc = new ParkCarDevRelCriteria();
        ParkCarDevRelCriteria.Criteria ducc = duc.createCriteria();
        ducc.andDevCodeEqualTo(devCode);
        return this.getMapper().selectByExample(duc);
    }

}
