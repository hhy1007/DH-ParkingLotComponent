/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.dao.authpackage;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.eg.egsc.scp.parkinglotcomponent.basic.dao.EnhancedBaseDao;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.authpackage.PackageParkRelMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkPackageParkRelMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkPackageParkRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkPackageParkRelCriteria;

/**
 * 授权套餐车场持久层接口
 * 
 * @author huangyuhong
 * @since 2018年1月12日
 */
@Repository
public class ParkPackageParkRelDao extends EnhancedBaseDao<ParkPackageParkRelMapper, PackageParkRelMapper, ParkPackageParkRel> {

    @Override
    protected void setEntityClass() {
        this.setMapperClass(ParkPackageParkRelMapper.class);
        this.setExtMapperClass(PackageParkRelMapper.class);
        this.setCustomMapper(ParkPackageParkRel.class);
    }

    @Override
    protected void setMapperClass() {
        this.setEntityClass(ParkPackageParkRel.class);
    }

    /**
     * 条件删除
     * 
     * @param parkPackageParkRel
     * @return int
     */
    public int delete(ParkPackageParkRel parkPackageParkRel) {
        ParkPackageParkRelCriteria duc = this.getBaseCriteria(parkPackageParkRel);
        return this.getMapper().deleteByExample(duc);
    }
    
    /**
     * 通过套餐ID删除车牌绑定
     * 
     * @param packageId
     * @return int
     */
    public int deleteByParkPackageId(String packageId) {
        ParkPackageParkRel parkRel = new ParkPackageParkRel();
        parkRel.setPackageId(packageId);
        return this.delete(parkRel);
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
        ParkPackageParkRelCriteria duc = new ParkPackageParkRelCriteria();
        ParkPackageParkRelCriteria.Criteria ducc = duc.createCriteria();
        ducc.andPackageIdIn(ids);
        return this.getMapper().deleteByExample(duc);
    }
    
    /**
     * 添加
     * 
     * @param parkPackageParkRel
     * @return int
     */
    public int insert(ParkPackageParkRel parkPackageParkRel) {
        return this.getMapper().insert(parkPackageParkRel);
    }
    
    /**
     * 批量插入
     * 
     * @param packageParkRels
     * @return int
     */
    public int insertPackageParkRelBatch(List<ParkPackageParkRel> packageParkRels) {
        return this.getExtMapper().insertPackageParkRelBatch(packageParkRels);
    }
    
    /**
     * 条件查询
     * 
     * @param arkPackageParkRel
     * @return List<ParkPackageParkRel>
     */
    public List<ParkPackageParkRel> selectList(ParkPackageParkRel arkPackageParkRel){
        ParkPackageParkRelCriteria duc = this.getBaseCriteria(arkPackageParkRel);
        return this.getMapper().selectByExample(duc);
    }
    
    /**
     * 自定义条件过滤
     * 
     * @param condition
     * @return ParkPackageParkRelCriteria
     */
    private ParkPackageParkRelCriteria getBaseCriteria(ParkPackageParkRel condition) {
        ParkPackageParkRelCriteria duc = new ParkPackageParkRelCriteria();
        ParkPackageParkRelCriteria.Criteria ducc = duc.createCriteria();
        if (StringUtils.isNotBlank(condition.getPackageId())) {
            ducc.andPackageIdEqualTo(condition.getPackageId());
        }
        if (StringUtils.isNotBlank(condition.getParkCode())) {
            ducc.andParkCodeEqualTo(condition.getParkCode());
        }
        return duc;
    }
    
}
