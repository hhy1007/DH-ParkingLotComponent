/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.dao.park;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.eg.egsc.scp.parkinglotcomponent.basic.dao.EnhancedBaseDao;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageRequest;
import com.eg.egsc.scp.parkinglotcomponent.basic.util.SqlUtil;
import com.eg.egsc.scp.parkinglotcomponent.condition.park.ParkingLotCondition;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.park.ParkingLotMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkParkingLotMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkingLot;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkingLotCriteria;

/**
 * 停车场管理持久层接口
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
@Repository
public class ParkParkingLotDao
        extends EnhancedBaseDao<ParkParkingLotMapper, ParkingLotMapper, ParkParkingLot> {
    @Override
    protected void setMapperClass() {
        this.setMapperClass(ParkParkingLotMapper.class);
        this.setExtMapperClass(ParkingLotMapper.class);
    }

    @Override
    protected void setEntityClass() {
        this.setEntityClass(ParkParkingLot.class);
    }
    
    /**
     * 根据id查询停车场信息
     * 
     * @param uuid
     * @return ParkCarport
     */
    public ParkParkingLot selectByPrimaryKey(String uuid) {
        ParkParkingLotCriteria duc = new ParkParkingLotCriteria();
        ParkParkingLotCriteria.Criteria ducc = duc.createCriteria();
        ducc.andUuidEqualTo(uuid);
        ducc.andDeleteFlagEqualTo(SqlUtil.FLAG_NORMAL);
        List<ParkParkingLot> parkParkingLotList =  this.getMapper().selectByExample(duc);
        if(CollectionUtils.isNotEmpty(parkParkingLotList)) {
            return parkParkingLotList.get(SqlUtil.INDEX);
        }
        return null;
    }

    /**
     * 根据多个规则id查询停车场授权服务套餐
     * 
     * @param ruleIds
     * @return List<ParkParkingLot>
     */
    List<ParkParkingLot> selectParkParkingLotAndParkPackageParkRelByRuleIds(List<String> ruleIds) {
        return this.getExtMapper().selectParkParkingLotAndParkPackageParkRelByRuleIds(ruleIds);
    }

    /**
     * 根据停车场名称和编号查询名称相同编号不同停车场信息
     * 
     * @param parkParkingLot
     * @return ParkParkingLot
     */
    public ParkParkingLot selectParkParkingLotByName(ParkParkingLot parkParkingLot) {
        return this.getExtMapper().selectParkParkingLotByName(parkParkingLot);
    }

    /**
     * 根据收费规则id查询服务套餐信息
     * 
     * @param feeRuleIds
     * @return List<ParkParkingLot>
     */
    public List<ParkParkingLot> selectParkParkingLotAndParkPackageParkRel(List<String> feeRuleIds) {
        return this.getExtMapper().selectParkParkingLotAndParkPackageParkRel(feeRuleIds);
    }

    /**
     * 根据车牌查询车辆信息
     * 
     * @param parkParkingLot
     * @return ParkParkingLot
     */
    public ParkParkingLot selectParkParkingLot(ParkParkingLot parkParkingLot) {
        return this.getExtMapper().selectParkParkingLot(parkParkingLot);
    }

    /**
     * 根据id批量删除
     * 
     * @param ids
     * @return int
     */
    public int deleteByIds(List<String> ids) {
        ParkParkingLotCriteria duc = new ParkParkingLotCriteria();
        ParkParkingLotCriteria.Criteria ducc = duc.createCriteria();
        ducc.andUuidIn(ids);
        ParkParkingLot parkParkingLot = new ParkParkingLot();
        parkParkingLot.setDeleteFlag(SqlUtil.FLAG_DELETE);
        return this.getMapper().updateByExampleSelective(parkParkingLot, duc);
    }

    /**
     * 根据车场id更新余位（余位自减或者自增）
     * 
     * @param id
     * @param isSelfAdd
     * @return int
     */
    public int updateParkingLotSelfReductionOrSelfAdd(String id, boolean isSelfAdd) {
        if (isSelfAdd) {
            return this.getExtMapper().updateParkingLotSelfAdd(id);
        } else {
            return this.getExtMapper().updateParkingLotSelfReduction(id);
        }
    }


    /**
     * 根据条件查询
     * 
     * @param condition
     * @return List<ParkParkingLot>
     */
    public List<ParkParkingLot> selectList(ParkingLotCondition condition) {
        ParkParkingLotCriteria duc = this.getBaseCriteria(condition);
        return this.getMapper().selectByExample(duc);
    }

    /**
     * 分页查询
     * 
     * @param pageRequest
     * @return Page<ParkParkingLot>
     */
    public Page<ParkParkingLot> selectPageList(PageRequest<ParkingLotCondition> pageRequest) {
        // 分页方式1：selectPageList， 通过自动生成代码实现分页，多表关联查询时不适用
        ParkParkingLotCriteria duc = this.getLikeBaseCriteria(pageRequest.getFilters());
        return super.selectPageList(duc, pageRequest);
    }

    /**
     * 自定义过滤条件
     * 
     * @param condition
     * @return ParkParkingLotCriteria
     */
    private ParkParkingLotCriteria getBaseCriteria(ParkingLotCondition condition) {
        ParkParkingLotCriteria duc = new ParkParkingLotCriteria();
        ParkParkingLotCriteria.Criteria ducc = duc.createCriteria();
        if (StringUtils.isNotBlank(condition.getId())) {
            ducc.andUuidEqualTo(condition.getId());
        }
        if (StringUtils.isNotBlank(condition.getParkCode())) {
            ducc.andParkCodeEqualTo(condition.getParkCode());
        }
        if (StringUtils.isNotBlank(condition.getParkName())) {
            ducc.andParkNameEqualTo(condition.getParkName());
        }
        if (StringUtils.isNotBlank(condition.getParentCode())) {
            ducc.andParentCodeEqualTo(condition.getParentCode());
        }
        ducc.andDeleteFlagEqualTo(SqlUtil.FLAG_NORMAL);
        return duc;
    }

    /**
     * 自定义过滤条件
     * 
     * @param condition
     * @return ParkParkingLotCriteria
     */
    private ParkParkingLotCriteria getLikeBaseCriteria(ParkingLotCondition condition) {
        ParkParkingLotCriteria duc = new ParkParkingLotCriteria();
        ParkParkingLotCriteria.Criteria ducc = duc.createCriteria();
        if (StringUtils.isNotBlank(condition.getId())) {
            ducc.andUuidEqualTo(condition.getId());
        }
        if (StringUtils.isNotBlank(condition.getParkCode())) {
            ducc.andParkCodeEqualTo(condition.getParkCode());
        }
        if (StringUtils.isNotBlank(condition.getParkName())) {
            ducc.andParkNameLike("%" + condition.getParkName() + "%");
        }
        if (StringUtils.isNotBlank(condition.getParentCode())) {
            ducc.andParentCodeEqualTo(condition.getParentCode());
        }
        ducc.andDeleteFlagEqualTo(SqlUtil.FLAG_NORMAL);
        duc.setOrderByClause(SqlUtil.orderDesc("create_time"));// 倒序
        return duc;
    }
}
