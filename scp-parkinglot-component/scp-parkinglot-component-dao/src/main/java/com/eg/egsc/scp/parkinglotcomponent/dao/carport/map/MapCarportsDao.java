/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.dao.carport.map;

import org.springframework.stereotype.Repository;

import com.eg.egsc.scp.parkinglotcomponent.basic.dao.EnhancedBaseDao;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageRequest;
import com.eg.egsc.scp.parkinglotcomponent.condition.park.map.MapCarportsCondition;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.carport.map.MapCarportsMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkCarportMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarport;

/**
 * 地图使用的车位管理持久化接口
 * 
 * @author huangzhiqiang
 * @since 2018年1月12日
 */
@Repository
public class MapCarportsDao
        extends EnhancedBaseDao<ParkCarportMapper, MapCarportsMapper, ParkCarport> {

    @Override
    protected void setEntityClass() {
        this.setMapperClass(ParkCarportMapper.class);
        this.setExtMapperClass(MapCarportsMapper.class);
        // 自定义sql语句时需设置
        this.setCustomMapper(MapCarportsMapper.class);
    }

    @Override
    protected void setMapperClass() {
        this.setEntityClass(ParkCarport.class);

    }

    /**
     * 分页查询
     * 
     * @param pageRequest
     * @return Page<ParkCarport>
     */
    public Page<ParkCarport> selectPageList(PageRequest<MapCarportsCondition> pageRequest) {
        // 分页方式二：selectCustomSqlPageList， 通过自定义sql语句实现分页，适用于所有场景
        return super.selectCustomSqlPageList(pageRequest);
    }

}
