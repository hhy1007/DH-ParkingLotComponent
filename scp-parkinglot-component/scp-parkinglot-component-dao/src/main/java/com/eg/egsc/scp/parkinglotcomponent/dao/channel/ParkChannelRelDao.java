/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.dao.channel;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.eg.egsc.scp.parkinglotcomponent.basic.dao.EnhancedBaseDao;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageRequest;
import com.eg.egsc.scp.parkinglotcomponent.basic.util.SqlUtil;
import com.eg.egsc.scp.parkinglotcomponent.condition.channel.ChannelRelCondition;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.channel.ChannelRelMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkChannelRelMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannelRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannelRelCriteria;

/**
 * 车场通道邦定管理持久层接口
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
@Repository
public class ParkChannelRelDao
        extends EnhancedBaseDao<ParkChannelRelMapper, ChannelRelMapper, ParkChannelRel> {

    @Override
    protected void setMapperClass() {
        this.setMapperClass(ParkChannelRelMapper.class);
        this.setExtMapperClass(ChannelRelMapper.class);
    }

    @Override
    protected void setEntityClass() {
        this.setEntityClass(ParkChannelRel.class);
    }

    /**
     * 根据多个通道id查询通道绑定信息
     * 
     * @param channeIds
     * @return List<ParkChannelRel>
     */
    public List<ParkChannelRel> selectChannelRelByIds(List<String> channeIds) {
        return this.getExtMapper().selectChannelRelByIds(channeIds);
    }

    /**
     * 根据channelId删除车场通道绑定信息
     * 
     * @param channelIds
     * @return int
     */
    public int deleteByChannelRelIds(List<String> channelIds) {
        ParkChannelRelCriteria duc = new ParkChannelRelCriteria();
        ParkChannelRelCriteria.Criteria ducc = duc.createCriteria();
        ducc.andChannelIdIn(channelIds);
        return this.getMapper().deleteByExample(duc);
    }
    
    /**
     * 
     * 根据设备编号查询通道与设备绑定信息
     * 
     * @param devCode
     * @return List<ParkChannelRel>
     */
    public List<ParkChannelRel> selectChannelRelByDevCode(String devCode){
        ParkChannelRelCriteria duc = new ParkChannelRelCriteria();
        ParkChannelRelCriteria.Criteria ducc = duc.createCriteria();
        ducc.andDevCodeEqualTo(devCode);
        return this.getMapper().selectByExample(duc);
    }
    
    /**
     * 根据设备编号
     * @param devCodes
     * @return int
     */
    public int deleteByDevCode(String devCode) {
        ParkChannelRelCriteria duc = new ParkChannelRelCriteria();
        ParkChannelRelCriteria.Criteria ducc = duc.createCriteria();
        ducc.andDevCodeEqualTo(devCode);
        return this.getMapper().deleteByExample(duc);
    }
    
    
    /**
     * 根据设备编号查询车场通道绑定信息
     * 
     * @param devCode
     * @return List<ParkChannelRel>
     */
    public List<ParkChannelRel> selectParkChannelRelByDevCode(String devCode) {
        ParkChannelRelCriteria duc = new ParkChannelRelCriteria();
        ParkChannelRelCriteria.Criteria ducc = duc.createCriteria();
        ducc.andDevCodeEqualTo(devCode);
        return this.getMapper().selectByExample(duc);
    }

    /**
     * 根据设备编号和车场id查询不相同的id车场通道绑定信息
     * 
     * @param parkChannelRel
     * @return List<ParkChannelRel>
     */
    public List<ParkChannelRel> selectParkChannelRelByDevCodeIsNotId(
            ParkChannelRel parkChannelRel) {
        ParkChannelRelCriteria duc = new ParkChannelRelCriteria();
        ParkChannelRelCriteria.Criteria ducc = duc.createCriteria();
        ducc.andDevCodeEqualTo(parkChannelRel.getDevCode());
        ducc.andUuidNotEqualTo(parkChannelRel.getUuid());
        return this.getMapper().selectByExample(duc);
    }

    /**
     * 根据id批量删除
     * 
     * @param ids
     * @return int
     */
    public int deleteByIds(List<String> ids) {
        ParkChannelRelCriteria duc = new ParkChannelRelCriteria();
        ParkChannelRelCriteria.Criteria ducc = duc.createCriteria();
        ducc.andUuidIn(ids);
        return this.getMapper().deleteByExample(duc);
    }

    /**
     * 根据条件查询 
     * 
     * @param condition
     * @return List<ParkChannelRel>
     */
    public List<ParkChannelRel> selectList(ChannelRelCondition condition) {
        ParkChannelRelCriteria duc = this.getBaseCriteria(condition);
        return this.getMapper().selectByExample(duc);
    }

    /**
     * 根据通道id查询通道与诱导屏绑定信息
     * 
     * @param channelIds
     * @return List<ParkChannelRel>
     */
    public List<ParkChannelRel> selectByChannelIds(List<String> channelIds) {
        ParkChannelRelCriteria duc = new ParkChannelRelCriteria();
        ParkChannelRelCriteria.Criteria ducc = duc.createCriteria();
        ducc.andChannelIdIn(channelIds);
        return this.getMapper().selectByExample(duc);
    }
    

    /**
     * 分页查询 
     * 
     * @param pageRequest
     * @return Page<ParkChannelRel>
     */
    public Page<ParkChannelRel> selectPageList(PageRequest<ChannelRelCondition> pageRequest) {
        // 分页方式1：selectPageList， 通过自动生成代码实现分页，多表关联查询时不适用
        ParkChannelRelCriteria duc = this.getBaseCriteria(pageRequest.getFilters());
        return super.selectPageList(duc, pageRequest);
    }

    /**
     * 自定义过滤条件
     * 
     * @param condition
     * @return ParkChannelRelCriteria
     */
    private ParkChannelRelCriteria getBaseCriteria(ChannelRelCondition condition) {
        ParkChannelRelCriteria duc = new ParkChannelRelCriteria();
        ParkChannelRelCriteria.Criteria ducc = duc.createCriteria();
        if (StringUtils.isNotBlank(condition.getId())) {
            ducc.andUuidEqualTo(condition.getId());
        }
        if (StringUtils.isNotBlank(condition.getChannelId())) {
            ducc.andChannelIdEqualTo(condition.getChannelId());
        }
        if (condition.getDevType() != null) {
          ducc.andDevTypeEqualTo(condition.getDevType().shortValue());
        }
        if(StringUtils.isNotBlank(condition.getDevCode())) {
          ducc.andDevCodeEqualTo(condition.getDevCode());
        }
        duc.setOrderByClause(SqlUtil.orderDesc("create_time"));//倒序
        return duc;
    }
}
