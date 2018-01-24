/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.dao.access;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.eg.egsc.scp.parkinglotcomponent.basic.dao.EnhancedBaseDao;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageRequest;
import com.eg.egsc.scp.parkinglotcomponent.basic.util.SqlUtil;
import com.eg.egsc.scp.parkinglotcomponent.condition.access.AccessCurCondition;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.access.AccessCurMapper;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.access.entity.AccessCur;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkAccessCurMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAccessCur;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAccessCurCriteria;

/**
 * 车辆入场记录持久层接口
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
@Repository
public class AccessCurDao
        extends EnhancedBaseDao<ParkAccessCurMapper, AccessCurMapper, ParkAccessCur> {

    @Override
    protected void setEntityClass() {
        this.setMapperClass(ParkAccessCurMapper.class);
        this.setExtMapperClass(AccessCurMapper.class);
    }

    @Override
    protected void setMapperClass() {
        this.setEntityClass(ParkAccessCur.class);
    }

    /**
     * 根据入场id查询停车场信息和收费规则信息
     * 
     * @param id
     * @return AccessCur
     */
    public AccessCur selectAccessCurAndParkingLotAndParkFeeRuleByPrimaryKey(String id) {
        return this.getExtMapper().selectAccessCurAndParkingLotAndParkFeeRuleByPrimaryKey(id);
    }

    /**
     * 分页查询
     * 
     * @param id
     * @return AccessCur
     */
    public Page<ParkAccessCur> selectPageList(PageRequest<AccessCurCondition> pageRequest) {
        ParkAccessCurCriteria duc = this.getBaseCriteria(pageRequest.getFilters());
        return super.selectPageList(duc, pageRequest);
    }

    /**
     * 根据id批量删除
     * 
     * @param id
     * @return AccessCur
     */
    public int deleteByIds(List<String> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        ParkAccessCurCriteria duc = new ParkAccessCurCriteria();
        ParkAccessCurCriteria.Criteria ducc = duc.createCriteria();
        ducc.andUuidIn(ids);
        return this.getMapper().deleteByExample(duc);
    }
    
    public int countByPackageIds(List<String> packageIds) {
        if(CollectionUtils.isEmpty(packageIds)) {
            return 0;
        }
        return this.getExtMapper().countByPackageId(packageIds);
    }
    /**
     * 查询在场车辆信息
     * 
     * @param id
     * @return AccessCur
     */
    public List<ParkAccessCur> selectList(AccessCurCondition condition) {
        ParkAccessCurCriteria duc = this.getBaseCriteria(condition);
        return this.getMapper().selectByExample(duc);
    }

    /**
     * 计算符合条件并且有效期内的车辆
     * 
     * @Methods Name countNumber
     * @Create In 2018年1月19日 By wangziqiang
     * @param condition
     * @return int
     */
    public int countNumber(AccessCurCondition condition) {
        ParkAccessCurCriteria duc = this.getBaseCriteria(condition);
        return this.getMapper().countByExample(duc);
    }

    /**
     * 自定义过滤条件
     * 
     * @param id
     * @return AccessCur
     */
    public ParkAccessCurCriteria getBaseCriteria(AccessCurCondition condition) {
        ParkAccessCurCriteria duc = new ParkAccessCurCriteria();
        ParkAccessCurCriteria.Criteria ducc = duc.createCriteria();
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
            ducc.andCardNumberEqualTo(condition.getCardNumber());
        }
        if (condition.getInTime() != null) {
            ducc.andCreateTimeEqualTo(condition.getInTime());
        }
        if (StringUtils.isNotBlank(condition.getInCameraCode())) {
            ducc.andInCameraCodeEqualTo(condition.getInCameraCode());
        }
        if (condition.getEnterMode() != null) {
            ducc.andEnterModeEqualTo(condition.getEnterMode());
        }
        if (condition.getCarType() != null) {
            ducc.andCarTypeEqualTo(condition.getCarType());
        }
        if (condition.getCarNumFzzz() != null) {
            ducc.andCarNumLike(condition.getCarNumFzzz());
        }
        if(StringUtils.isNotBlank(condition.getOwnerId()) ) {
            ducc.andOwnerIdEqualTo(condition.getOwnerId());
        }
        duc.setOrderByClause(SqlUtil.orderDesc("create_time"));// 倒序
        return duc;
    }

}
