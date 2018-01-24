/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.dao.authpackage;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.eg.egsc.scp.parkinglotcomponent.basic.dao.EnhancedBaseDao;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageRequest;
import com.eg.egsc.scp.parkinglotcomponent.basic.util.SqlUtil;
import com.eg.egsc.scp.parkinglotcomponent.condition.authpackage.ParkAuthPackageCondition;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.authpackage.AuthPackageMapper;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.authpackage.entity.AuthPackage;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkAuthPackageMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAuthPackage;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAuthPackageCriteria;


/**
 * 授权套餐持久层接口
 * 
 * @author huangyuhong
 * @since 2018年1月12日
 */
@Repository
public class ParkAuthPackageDao
        extends EnhancedBaseDao<ParkAuthPackageMapper, AuthPackageMapper, ParkAuthPackage> {

    @Override
    protected void setMapperClass() {
        this.setMapperClass(ParkAuthPackageMapper.class);
        this.setExtMapperClass(AuthPackageMapper.class);
        this.setCustomMapper(AuthPackageMapper.class);
    }

    @Override
    protected void setEntityClass() {
        this.setEntityClass(ParkAuthPackage.class);
    }

    /**
     * 根据用户id批量删除授权套餐
     * 
     * @param ownerIds
     * @return int
     */
    public int deleteByOwnerIds(List<String> ownerIds) {
        if (CollectionUtils.isEmpty(ownerIds)) {
            return 0;
        }
        ParkAuthPackageCriteria duc = new ParkAuthPackageCriteria();
        ParkAuthPackageCriteria.Criteria ducc = duc.createCriteria();
        ducc.andOwnerIdIn(ownerIds);
        ducc.andDeleteFlagEqualTo(SqlUtil.FLAG_NORMAL);
        ParkAuthPackage authPackage = new ParkAuthPackage();
        authPackage.setDeleteFlag(SqlUtil.FLAG_DELETE);
        return this.getMapper().updateByExampleSelective(authPackage, duc);
    }

    /**
     * 根据车位号批量查询套餐
     * 
     * @param carportCodes
     * @return List<ParkAuthPackage>
     */
    public List<ParkAuthPackage> selectParkAuthPackageByCarportCodes(List<String> carportCodes) {
        ParkAuthPackageCriteria duc = new ParkAuthPackageCriteria();
        ParkAuthPackageCriteria.Criteria ducc = duc.createCriteria();
        ducc.andDeleteFlagEqualTo(SqlUtil.FLAG_NORMAL);
        ducc.andCarportCodeIn(carportCodes);
        return this.getMapper().selectByExample(duc);
    }

    /**
     * 根据车场编号查询授权套餐
     * 
     * @param carportCode
     * @return List<ParkAuthPackage>
     */
    public List<ParkAuthPackage> selectParkAuthPackageByCarportCode(String carportCode) {
        ParkAuthPackageCriteria duc = new ParkAuthPackageCriteria();
        ParkAuthPackageCriteria.Criteria ducc = duc.createCriteria();
        ducc.andCarportCodeEqualTo(carportCode);
        ducc.andDeleteFlagEqualTo(SqlUtil.FLAG_NORMAL);
        return this.getMapper().selectByExample(duc);
    }

    /**
     * 根据id批量删除授权套餐
     * 
     * @param ids
     * @return int
     */
    public int deleteByIds(List<String> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        ParkAuthPackageCriteria duc = new ParkAuthPackageCriteria();
        ParkAuthPackageCriteria.Criteria ducc = duc.createCriteria();
        ducc.andUuidIn(ids);
        ParkAuthPackage authPackage = new ParkAuthPackage();
        authPackage.setDeleteFlag(SqlUtil.FLAG_DELETE);
        return this.getMapper().updateByExampleSelective(authPackage, duc);
    }

    /**
     * 自定义条件查询授权套餐
     * 
     * @param condition
     * @return List<AuthPackage>
     */
    public List<AuthPackage> selectList(ParkAuthPackageCondition condition) {
        this.addDefaultCondition(condition);
        return this.getExtMapper().selectByExample(condition);
    }

    /**
     * 条件查询授权套餐
     * 
     * @param condition
     * @return List<AuthPackage>
     */
    public List<ParkAuthPackage> selectExampleList(ParkAuthPackageCondition condition) {
        ParkAuthPackageCriteria example = this.getBaseCriteria(condition);
        return this.getMapper().selectByExample(example);
    }

    /**
     * 条件数量查询授权套餐
     * 
     * @param condition
     * @return int
     */
    public int countNumber(ParkAuthPackageCondition condition) {
        this.addDefaultCondition(condition);
        return this.getExtMapper().countByExample(condition);
    }

    /**
     * 分页条件查询授权套餐
     * 
     * @param pageRequest
     * @return Page<AuthPackage>
     */
    public Page<AuthPackage> selectPageList(PageRequest<ParkAuthPackageCondition> pageRequest) {
        this.addDefaultCondition(pageRequest.getFilters());
        return super.selectCustomSqlPageList(pageRequest);
    }

    /**
     * 根据用户id批量查询(除去临时停车用户)
     * 
     * @param ownerIds
     * @return List<AuthPackage>
     */
    public List<AuthPackage> selectByOwnerIdsWithoutTemp(List<String> ownerIds) {
        return this.getExtMapper().selectByOwnerIdsWithoutTemp(ownerIds);
    }

    /**
     * 根据id查询
     * 
     * @param id
     * @return AuthPackage
     */
    public AuthPackage selectByPrimaryKey(String id) {
        ParkAuthPackageCondition condition = new ParkAuthPackageCondition();
        condition.setId(id);
        condition.setDeleteFlag(SqlUtil.FLAG_NORMAL);
        List<AuthPackage> result = this.getExtMapper().selectByExample(condition);
        if (CollectionUtils.isNotEmpty(result)) {
            return result.get(0);
        }
        return null;
    }

    /**
     * 添加默认条件
     * 
     * @param condition
     * @return ParkAuthPackageCondition
     */
    private ParkAuthPackageCondition addDefaultCondition(ParkAuthPackageCondition condition) {
        if (StringUtils.isEmpty(condition.getOrderByClause())) {
            condition.setOrderByClause(SqlUtil.orderDesc("update_time"));
        }
        if (condition.getDeleteFlag() == null) {
            condition.setDeleteFlag(SqlUtil.FLAG_NORMAL);
        }
        return condition;
    }

    /**
     * 自定义条件
     * 
     * @Methods Name getBaseCriteria
     * @Create In 2018年1月23日 By wangziqiang
     * @param condition
     * @return ParkAuthPackageCriteria
     */
    private ParkAuthPackageCriteria getBaseCriteria(ParkAuthPackageCondition condition) {
        ParkAuthPackageCriteria example = new ParkAuthPackageCriteria();
        ParkAuthPackageCriteria.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(condition.getCardNumber())) {
            criteria.andCardNumberEqualTo(condition.getCardNumber());
        }
        if (StringUtils.isNotBlank(condition.getOwnerId())) {
            criteria.andOwnerIdEqualTo(condition.getOwnerId());
        }
        return example;
    }

}
