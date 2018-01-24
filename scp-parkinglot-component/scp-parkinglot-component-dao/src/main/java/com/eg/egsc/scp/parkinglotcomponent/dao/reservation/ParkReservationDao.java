/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.dao.reservation;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.eg.egsc.scp.parkinglotcomponent.basic.dao.EnhancedBaseDao;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageRequest;
import com.eg.egsc.scp.parkinglotcomponent.basic.util.SqlUtil;
import com.eg.egsc.scp.parkinglotcomponent.condition.reservation.ParkReservationCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkReservationMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkReservation;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkReservationCriteria;

/**
 * 预约管理持久层接口
 * 
 * @author huangyuhong
 * @since 2018年1月12日
 */
@Repository
public class ParkReservationDao extends EnhancedBaseDao<ParkReservationMapper, ParkReservationMapper, ParkReservation> {

    @Override
    protected void setEntityClass() {
        this.setMapperClass(ParkReservationMapper.class);
        this.setExtMapperClass(ParkReservationMapper.class);
    }

    @Override
    protected void setMapperClass() {
        this.setEntityClass(ParkReservation.class);
    }
    
    /**
     * 根据id查询车辆预约
     * 
     * @param id
     * @return ParkReservation
     */
    public ParkReservation selectById(String id) {
        ParkReservationCriteria duc = new ParkReservationCriteria();
        ParkReservationCriteria.Criteria ducc = duc.createCriteria();
        ducc.andUuidEqualTo(id);
        ducc.andDeleteFlagEqualTo(SqlUtil.FLAG_NORMAL);
        List<ParkReservation> reservationList = this.getMapper().selectByExample(duc);
        if(CollectionUtils.isNotEmpty(reservationList)) {
            return reservationList.get(0);
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
        ParkReservationCriteria duc = new ParkReservationCriteria();
        ParkReservationCriteria.Criteria ducc = duc.createCriteria();
        ducc.andUuidIn(ids);
        ParkReservation parkReservation = new ParkReservation();
        parkReservation.setDeleteFlag(SqlUtil.FLAG_DELETE);
        return this.getMapper().updateByExampleSelective(parkReservation, duc);
    }
    
    /**
     * 查询数量
     * 
     * @param condition
     * @return int
     */
    public int countNumber(ParkReservationCondition condition) {
        ParkReservationCriteria duc = this.getBaseCriteria(condition);
        return this.getMapper().countByExample(duc);
    }
    
    
    
    /**
     * 条件查询
     * 
     * @param condition
     * @return List<ParkReservation>
     */
    public List<ParkReservation> selectList(ParkReservationCondition condition) {
        ParkReservationCriteria duc = this.getBaseCriteria(condition);
        return this.getMapper().selectByExample(duc);
    }
    
    /**
     * 分页查询
     * 
     * @param pageRequest
     * @return Page<ParkReservation>
     */
    public Page<ParkReservation> selectPageList(PageRequest<ParkReservationCondition> pageRequest) {
        ParkReservationCriteria duc = this.getBaseCriteria(pageRequest.getFilters());
        return super.selectPageList(duc, pageRequest);
    }
    
    /**
     * 自定义条件过滤
     * 
     * @param condition
     * @return ParkReservationCriteria
     */
    private ParkReservationCriteria getBaseCriteria(ParkReservationCondition condition) {
        ParkReservationCriteria duc = new ParkReservationCriteria();
        ParkReservationCriteria.Criteria ducc = duc.createCriteria();
        if (StringUtils.isNotBlank(condition.getId())) {
            ducc.andUuidEqualTo(condition.getId());
        }
        if (StringUtils.isNotBlank(condition.getCarNum())) {
            ducc.andCarNumEqualTo(condition.getCarNum());
        }
        ducc.andDeleteFlagEqualTo(SqlUtil.FLAG_NORMAL);
        return duc;
    }
}
