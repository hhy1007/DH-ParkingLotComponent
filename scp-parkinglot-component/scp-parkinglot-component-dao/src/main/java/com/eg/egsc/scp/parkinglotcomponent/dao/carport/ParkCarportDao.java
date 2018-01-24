/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.dao.carport;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.eg.egsc.scp.parkinglotcomponent.basic.dao.EnhancedBaseDao;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageRequest;
import com.eg.egsc.scp.parkinglotcomponent.basic.util.SqlUtil;
import com.eg.egsc.scp.parkinglotcomponent.condition.park.CarportCondition;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.carport.CarportMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkCarportMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarport;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarportCriteria;

/**
 * 车位管理持久层接口
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
@Repository
public class ParkCarportDao extends EnhancedBaseDao<ParkCarportMapper, CarportMapper, ParkCarport> {

    @Override
    protected void setMapperClass() {
        this.setMapperClass(ParkCarportMapper.class);
        this.setExtMapperClass(CarportMapper.class);
    }

    @Override
    protected void setEntityClass() {
        this.setEntityClass(ParkCarport.class);
    }

    /**
     * 批量新增车位
     * 
     * @param id
     * @return int
     */
    public int insertBatchCarport(List<ParkCarport> parkCarports) {
        return this.getExtMapper().insertBatchCarport(parkCarports);
    }

    /**
     * 根据id查询车位信息
     * 
     * @param uuid
     * @return ParkCarport
     */
    public ParkCarport selectByPrimaryKey(String uuid) {
        ParkCarportCriteria duc = new ParkCarportCriteria();
        ParkCarportCriteria.Criteria ducc = duc.createCriteria();
        ducc.andUuidEqualTo(uuid);
        ducc.andDeleteFlagEqualTo(SqlUtil.FLAG_NORMAL);
        List<ParkCarport> parkCarportList = this.getMapper().selectByExample(duc);
        if (CollectionUtils.isNotEmpty(parkCarportList)) {
            return parkCarportList.get(SqlUtil.INDEX);
        }
        return null;
    }

    /**
     * 根据多个停车场编号和车位和车位编号模糊分页查询没有授权的车位信息
     * 
     * @param id
     * @return Page<ParkCarport>
     */
    public Page<ParkCarport> selectByParkId(PageRequest<CarportCondition> pageRequest) {
        List<ParkCarport> parkCarportList = this.getExtMapper().selectByParkId(pageRequest);
        int count = this.getExtMapper().selectCountByParkId(pageRequest);
        return new Page<>(pageRequest, count, parkCarportList);
    }

    /**
     * 是否可用：1-正常，0-不可用
     * 
     * @param uuid
     * @param enableFlag
     * @return int
     */
    public int updateEnableFlagByUuid(String uuid, Short enableFlag) {
        ParkCarportCriteria duc = new ParkCarportCriteria();
        ParkCarportCriteria.Criteria ducc = duc.createCriteria();
        ducc.andUuidEqualTo(uuid);
        ParkCarport parkCarport = new ParkCarport();
        parkCarport.setEnableFlag(enableFlag);
        return this.getMapper().updateByExampleSelective(parkCarport, duc);
    }

    /**
     * 根据车位编号查询车位的信息
     * 
     * @param id
     * @return List<ParkCarport>
     */
    public List<ParkCarport> selectParkCarportByCarportCode(String carportCode) {
        ParkCarportCriteria duc = new ParkCarportCriteria();
        ParkCarportCriteria.Criteria ducc = duc.createCriteria();
        ducc.andCarportCodeEqualTo(carportCode);
        ducc.andDeleteFlagEqualTo(SqlUtil.FLAG_NORMAL);
        return this.getMapper().selectByExample(duc);
    }

    /**
     * 根据id批量删除
     * 
     * @param id
     * @return int
     */
    public int deleteByIds(List<String> ids) {
        ParkCarportCriteria duc = new ParkCarportCriteria();
        ParkCarportCriteria.Criteria ducc = duc.createCriteria();
        ducc.andUuidIn(ids);
        ParkCarport parkCarport = new ParkCarport();
        parkCarport.setDeleteFlag(SqlUtil.FLAG_DELETE);
        return this.getMapper().updateByExampleSelective(parkCarport, duc);

    }

    /**
     * 根据条件查询 * @Methods Name selectList
     * 
     * @param condition
     * @return List<ParkCarport>
     */
    /**
     * 根据多个停车场编号和车位和车位编号模糊分页查询没有授权的车位信息
     * 
     * @param id
     * @return List<ParkCarport>
     */
    public List<ParkCarport> selectList(CarportCondition condition) {
        ParkCarportCriteria duc = this.getBaseCriteria(condition);
        return this.getMapper().selectByExample(duc);
    }


    /**
     * 分页查询
     * 
     * @param id
     * @return Page<ParkCarport>
     */
    public Page<ParkCarport> selectPageList(PageRequest<CarportCondition> pageRequest) {
        // 分页方式1：selectPageList， 通过自动生成代码实现分页，多表关联查询时不适用
        ParkCarportCriteria duc = this.getBaseCriteria(pageRequest.getFilters());
        return super.selectPageList(duc, pageRequest);
    }


    /**
     * 自定义过滤条件
     * 
     * @param id
     * @return ParkCarportCriteria
     */
    private ParkCarportCriteria getBaseCriteria(CarportCondition condition) {
        ParkCarportCriteria duc = new ParkCarportCriteria();
        ParkCarportCriteria.Criteria ducc = duc.createCriteria();
        if (StringUtils.isNotBlank(condition.getId())) {
            ducc.andUuidEqualTo(condition.getId());
        }
        if (StringUtils.isNotBlank(condition.getCarportCode())) {
            ducc.andCarportCodeEqualTo(condition.getCarportCode());
        }
        ducc.andDeleteFlagEqualTo(SqlUtil.FLAG_NORMAL);
        duc.setOrderByClause(SqlUtil.orderDesc("create_time"));// 倒序
        return duc;
    }

}
