/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.dao.authpackage;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.eg.egsc.scp.parkinglotcomponent.basic.dao.EnhancedBaseDao;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.authpackage.PackageCarRelMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkPackageCarRelMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkPackageCarRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkPackageCarRelCriteria;

/**
 * 授权套餐车辆持久层接口
 * 
 * @author huangyuhong
 * @since 2018年1月12日
 */
@Repository
public class ParkPackageCarRelDao extends EnhancedBaseDao<ParkPackageCarRelMapper, PackageCarRelMapper, ParkPackageCarRel> {

    
    @Override
    protected void setMapperClass() {
        this.setMapperClass(ParkPackageCarRelMapper.class);
        this.setExtMapperClass(PackageCarRelMapper.class);
        this.setCustomMapper(ParkPackageCarRel.class);
    }

    @Override
    protected void setEntityClass() {
        this.setEntityClass(ParkPackageCarRel.class);
    }
    
    /**
     * 条件删除车牌绑定
     * 
     * @param parkPackageCarRel
     * @return int
     */
    public int delete(ParkPackageCarRel parkPackageCarRel) {
        ParkPackageCarRelCriteria duc = this.getBaseCriteria(parkPackageCarRel);
        return this.getMapper().deleteByExample(duc);
    }

    /**
     * 根据授权套餐id批量删除
     * 
     * @param ids
     * @return int
     */
    public int deleteByPackageIds(List<String> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        ParkPackageCarRelCriteria duc = new ParkPackageCarRelCriteria();
        ParkPackageCarRelCriteria.Criteria ducc = duc.createCriteria();
        ducc.andPackageIdIn(ids);
        return this.getMapper().deleteByExample(duc);
    }
    
    /**
     * 添加车牌绑定
     * 
     * @param parkPackageCarRel
     * @return int
     */
    public int insert(ParkPackageCarRel parkPackageCarRel) {
        return this.getMapper().insert(parkPackageCarRel);
    }
    
    /**
     * 批量插入
     * 
     * @param packageCarRels
     * @return int
     */
    public int insertPackageCarRelBatch(List<ParkPackageCarRel> packageCarRels) {
        return this.getExtMapper().insertPackageCarRelBatch(packageCarRels);
    }
    
    /**
     * 条件查询车牌绑定
     * 
     * @param parkPackageCarRel
     * @return List<ParkPackageCarRel>
     */
    public List<ParkPackageCarRel> selectList(ParkPackageCarRel parkPackageCarRel){
        ParkPackageCarRelCriteria duc = this.getBaseCriteria(parkPackageCarRel);
        return this.getMapper().selectByExample(duc);
        
    }
    
    /**
     * 根据套餐ID删除车牌绑定
     * 
     * @param packageId
     * @return int
     */
    public int deleteByParkPackageId(String packageId) {
        ParkPackageCarRel carRel = new ParkPackageCarRel();
        carRel.setPackageId(packageId);
        return this.delete(carRel);
    }
    
    /**
     * 自定义条件过滤
     * 
     * @param condition
     * @return ParkPackageCarRelCriteria
     */
    private ParkPackageCarRelCriteria getBaseCriteria(ParkPackageCarRel condition) {
        ParkPackageCarRelCriteria duc = new ParkPackageCarRelCriteria();
        ParkPackageCarRelCriteria.Criteria ducc = duc.createCriteria();
        if (StringUtils.isNotBlank(condition.getPackageId())) {
            ducc.andPackageIdEqualTo(condition.getPackageId());
        }
        if (StringUtils.isNotBlank(condition.getCarNum())) {
            ducc.andCarNumEqualTo(condition.getCarNum());
        }
        return duc;
    }
    
}
