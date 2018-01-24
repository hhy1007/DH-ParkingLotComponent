/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.dao.car;

import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.eg.egsc.scp.parkinglotcomponent.basic.dao.EnhancedBaseDao;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageRequest;
import com.eg.egsc.scp.parkinglotcomponent.basic.util.SqlUtil;
import com.eg.egsc.scp.parkinglotcomponent.condition.car.CarCondition;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.car.CarMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkCarMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCar;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarCriteria;

/**
 * 车辆管理持久层接口
 * 
 * @author huangyuhong
 * @since 2018年1月12日
 */
@Repository
public class CarDao extends EnhancedBaseDao<ParkCarMapper, CarMapper, ParkCar> {
    
    @Override
    protected void setMapperClass() {
        this.setMapperClass(ParkCarMapper.class);
        //自定mapper
        this.setExtMapperClass(CarMapper.class);
        //自定义sql语句时需设置
        this.setCustomMapper(CarMapper.class);
    }

    @Override
    protected void setEntityClass() {
        this.setEntityClass(ParkCar.class);
    }
    
    /**
     * 根据id查询
     * 
     * @param id
     * @return ParkCar
     */
    public ParkCar selectByPrimaryKey(String id) {
        if(StringUtils.isBlank(id)) {
            return null;
        }
        ParkCarCriteria duc = new ParkCarCriteria();
        ParkCarCriteria.Criteria ducc = duc.createCriteria();
        ducc.andUuidEqualTo(id);
        ducc.andDeleteFlagEqualTo(SqlUtil.FLAG_NORMAL);
        List<ParkCar> carList = this.getMapper().selectByExample(duc);
        if(CollectionUtils.isNotEmpty(carList)) {
            return carList.get(0);
        }
        return null;
    }
    
    /**
     * 根据用户id批量查询车辆
     * 
     * @param ownerIds
     * @return List<ParkCar>
     */
    public List<ParkCar> selectByOwnerIds(List<String> ownerIds){
        if (CollectionUtils.isEmpty(ownerIds)) {
            return Collections.emptyList();
        }
        ParkCarCriteria duc = new ParkCarCriteria();
        ParkCarCriteria.Criteria ducc = duc.createCriteria();
        ducc.andOwnerIdIn(ownerIds);
        ducc.andDeleteFlagEqualTo(SqlUtil.FLAG_NORMAL);
        return this.getMapper().selectByExample(duc);
    }
    
    /**
     * 根据用户id批量删除车辆
     * 
     * @param ownerIds
     * @return int
     */
    public int deleteByOwnerIds(List<String> ownerIds) {
        if (CollectionUtils.isEmpty(ownerIds)) {
            return 0;
        }
        ParkCarCriteria duc = new ParkCarCriteria();
        ParkCarCriteria.Criteria ducc = duc.createCriteria();
        ducc.andOwnerIdIn(ownerIds);
        ducc.andDeleteFlagEqualTo(SqlUtil.FLAG_NORMAL);
        ParkCar parkCar = new ParkCar();
        parkCar.setDeleteFlag(SqlUtil.FLAG_DELETE);
        return this.getMapper().updateByExampleSelective(parkCar, duc);
    }
    
    /**
     * 根据id修改车辆信息(修改特定的字段)
     * 
     * @param car
     * @return int
     */
    public int updateCar(ParkCar car) {
        return this.getExtMapper().updateCar(car);
    }
    
    /**
     * 根据车牌查询车辆信息
     * 
     * @param carNum
     * @return ParkCar
     */
    public ParkCar selectCarByCarNum(String carNum) {
        if (StringUtils.isBlank(carNum)) {
            return null;
        }
        ParkCarCriteria duc = new ParkCarCriteria();
        ParkCarCriteria.Criteria ducc = duc.createCriteria();
        ducc.andCarNumEqualTo(carNum);
        ducc.andDeleteFlagEqualTo(SqlUtil.FLAG_NORMAL);
        List<ParkCar> list = this.getMapper().selectByExample(duc);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 根据id批量删除
     * 
     * @param ids
     * @return int
     */
    public int deleteByIds(List<String> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        ParkCarCriteria duc = new ParkCarCriteria();
        ParkCarCriteria.Criteria ducc = duc.createCriteria();
        ducc.andUuidIn(ids);
        ParkCar parkCar = new ParkCar();
        parkCar.setDeleteFlag(SqlUtil.FLAG_DELETE);
        return this.getMapper().updateByExampleSelective(parkCar, duc);
    }

    /**
     * 查询数量
     * 
     * @param condition
     * @return int
     */
    public int countNumber(CarCondition condition) {
        ParkCarCriteria duc = this.getBaseCriteria(condition);
        return this.getMapper().countByExample(duc);
    }

    /**
     * 根据条件查询
     * 
     * @param condition
     * @return List<ParkCar>
     */
    public List<ParkCar> selectList(CarCondition condition) {
        ParkCarCriteria duc = this.getBaseCriteria(condition);
        return this.getMapper().selectByExample(duc);
    }

    /**
     * 分页查询
     * 
     * @param pageRequest
     * @return Page<ParkCar>
     */
    public Page<ParkCar> selectPageList(PageRequest<CarCondition> pageRequest) {
         //分页方式1：selectPageList，  通过自动生成代码实现分页，多表关联查询时不适用
        /** ParkCarCriteria duc = this.getBaseCriteria(pageRequest.getFilters());
        return super.selectPageList(duc, pageRequest);*/
        //分页方式二：selectCustomSqlPageList，  通过自定义sql语句实现分页，适用于所有场景
        return super.selectCustomSqlPageList(pageRequest);
    }
    
    /**
     * 根据id批量修改车辆黑白名单状态
     * 
     * @param car
     * @param ids
     * @return int
     */
    public int updateStatusByids(ParkCar car, List<String> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        ParkCarCriteria duc = new ParkCarCriteria();
        ParkCarCriteria.Criteria ducc = duc.createCriteria();
        ducc.andUuidIn(ids);
        return this.getMapper().updateByExampleSelective(car, duc);
    }
    
    /**
     * 自定义过滤条件
     * 
     * @param condition
     * @return ParkCarCriteria
     */
    private ParkCarCriteria getBaseCriteria(CarCondition condition) {
        ParkCarCriteria duc = new ParkCarCriteria();
        ParkCarCriteria.Criteria ducc = duc.createCriteria();
        if (StringUtils.isNotBlank(condition.getId())) {
            ducc.andUuidEqualTo(condition.getId());
        }
        if (StringUtils.isNotBlank(condition.getCarNum())) {
            ducc.andCarNumEqualTo(condition.getCarNum());
        }
        if (StringUtils.isNotBlank(condition.getCarNumFuzzy())) {
            ducc.andCarNumLike(SqlUtil.likeAround(condition.getCarNumFuzzy()));
        }
        if (StringUtils.isNotBlank(condition.getCarBrand())) {
            ducc.andCarBrandEqualTo(condition.getCarBrand());
        }
        if (StringUtils.isNotBlank(condition.getCarCode())) {
            ducc.andCarCodeEqualTo(condition.getCarCode());
        }
        if (StringUtils.isNotBlank(condition.getCarColor())) {
            ducc.andCarColorEqualTo(condition.getCarColor());
        }
        if (StringUtils.isNotBlank(condition.getCarMode())) {
            ducc.andCarModeEqualTo(condition.getCarMode());
        }
        if (condition.getCarType() != null) {
            ducc.andCarTypeEqualTo(condition.getCarType());
        }
        if (StringUtils.isNotBlank(condition.getHouseNo())) {
            ducc.andHouseNoEqualTo(condition.getHouseNo());
        }
        if (condition.getListType() != null) {
            ducc.andListTypeEqualTo(condition.getListType());
        }
        if (StringUtils.isNotBlank(condition.getOwnerId())) {
            ducc.andOwnerIdEqualTo(condition.getOwnerId());
        }
        if (condition.getValidStartTime() != null) {
            ducc.andValidStartTimeLessThanOrEqualTo(condition.getValidStartTime());
        }
        if (condition.getValidEndTime() != null) {
            ducc.andValidEndTimeGreaterThanOrEqualTo(condition.getValidEndTime());
        }
        if(condition.getDeleteFlag() != null) {
            ducc.andDeleteFlagEqualTo(condition.getDeleteFlag());
        }else {
            ducc.andDeleteFlagEqualTo(SqlUtil.FLAG_NORMAL);
        }
        duc.setOrderByClause(SqlUtil.orderDesc("create_time"));//倒序
        return duc;
    }

}
