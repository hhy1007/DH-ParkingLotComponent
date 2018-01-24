/**
 * @Probject Name: scp-parkinglot-component-service
 * @Path:com.eg.egsc.scp.parkinglotcomponent.dao.channel.ParkChannelDao.java
 * @Create By fengrongjun
 * @Create In 2017年12月14日 下午4:29:15 
 */
package com.eg.egsc.scp.parkinglotcomponent.dao.channel;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.eg.egsc.scp.parkinglotcomponent.basic.dao.EnhancedBaseDao;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageRequest;
import com.eg.egsc.scp.parkinglotcomponent.basic.util.SqlUtil;
import com.eg.egsc.scp.parkinglotcomponent.condition.channel.ChannelCondition;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.channel.ChannelMapper;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.channel.entity.Channel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkChannelMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannelCriteria;

/**
 * 车场通道管理持久层接口
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
@Repository
public class ParkChannelDao
        extends EnhancedBaseDao<ParkChannelMapper, ChannelMapper, ParkChannel> {

    @Override
    protected void setMapperClass() {
        this.setMapperClass(ParkChannelMapper.class);
        this.setExtMapperClass(ChannelMapper.class);
    }

    @Override
    protected void setEntityClass() {
        this.setEntityClass(ParkChannel.class);
    }
    
    /**
     * 根据id查询通道信息
     * 
     * @param uuid
     * @return ParkCarport
     */
    public ParkChannel selectByPrimaryKey(String uuid) {
        ParkChannelCriteria duc = new ParkChannelCriteria();
        ParkChannelCriteria.Criteria ducc = duc.createCriteria();
        ducc.andUuidEqualTo(uuid);
        ducc.andDeleteFlagEqualTo(SqlUtil.FLAG_NORMAL);
        List<ParkChannel> parkChannelList =  this.getMapper().selectByExample(duc);
        if(CollectionUtils.isNotEmpty(parkChannelList)) {
            return parkChannelList.get(SqlUtil.INDEX);
        }
        return null;
    }

    /**
     * 根据parkingLotId查询停车场和车场通道信息
     * 
     * @param ids
     * @return List<Channel>
     */
    public List<Channel> selectParkingLotAndChannel(List<String> ids){
        return this.getExtMapper().selectParkingLotAndChannel(ids);
    }
    
    /**
     * 根据车场通道的名称查询车场通道的信息
     * 
     * @param name
     * @return List<ParkChannel>
     */
    public List<ParkChannel> selectParkChannelByName(String name) {
        ParkChannelCriteria duc = new ParkChannelCriteria();
        ParkChannelCriteria.Criteria ducc = duc.createCriteria();
        ducc.andNameEqualTo(name);
        ducc.andDeleteFlagEqualTo(SqlUtil.FLAG_NORMAL);
        return this.getMapper().selectByExample(duc);
    }

    /**
     * 根据车场通道的名称查询和id查询不相同id车场通道的信息
     * 
     * @param parkChannel
     * @return List<ParkChannel>
     */
    public List<ParkChannel> selectParkChannelByNameIsNotId(ParkChannel parkChannel) {
        ParkChannelCriteria duc = new ParkChannelCriteria();
        ParkChannelCriteria.Criteria ducc = duc.createCriteria();
        ducc.andUuidNotEqualTo(parkChannel.getUuid());
        ducc.andNameEqualTo(parkChannel.getName());
        ducc.andDeleteFlagEqualTo(SqlUtil.FLAG_NORMAL);
        return this.getMapper().selectByExample(duc);
    }
    
    /**
     * 根据id批量删除
     * 
     * @param ids
     * @return int
     */
    public int deleteByIds(List<String> ids) {
        ParkChannelCriteria duc = new ParkChannelCriteria();
        ParkChannelCriteria.Criteria ducc = duc.createCriteria();
        ducc.andUuidIn(ids);
        ParkChannel parkChannel = new ParkChannel();
        parkChannel.setDeleteFlag(SqlUtil.FLAG_DELETE);
        return this.getMapper().updateByExampleSelective(parkChannel, duc);
    }

    /**
     * 根据条件查询
     * 
     * @param condition
     * @return List<ParkChannel>
     */
    public List<ParkChannel> selectList(ChannelCondition condition) {
        ParkChannelCriteria duc = this.getBaseCriteria(condition);
        return this.getMapper().selectByExample(duc);
    }

    /**
     * 分页查询
     * 
     * @param pageRequest
     * @return Page<ParkChannel>
     */
    public Page<ParkChannel> selectPageList(PageRequest<ChannelCondition> pageRequest) {
        // 分页方式1：selectPageList， 通过自动生成代码实现分页，多表关联查询时不适用
        ParkChannelCriteria duc = this.getLikeBaseCriteria(pageRequest.getFilters());
        return super.selectPageList(duc, pageRequest);
    }

    /**
     * 自定义过滤条件
     * 
     * @param condition
     * @return ParkChannelCriteria
     */
    private ParkChannelCriteria getBaseCriteria(ChannelCondition condition) {
        ParkChannelCriteria duc = new ParkChannelCriteria();
        ParkChannelCriteria.Criteria ducc = duc.createCriteria();
        if (StringUtils.isNotBlank(condition.getId())) {
            ducc.andUuidEqualTo(condition.getId());
        }
        if (StringUtils.isNotBlank(condition.getName())) {
            ducc.andNameEqualTo(condition.getName());
        }
        ducc.andDeleteFlagEqualTo(SqlUtil.FLAG_NORMAL);
        return duc;
    }
    
    /**
     * 自定义过滤模糊条件
     * 
     * @param condition
     * @return ParkChannelCriteria
     */
    private ParkChannelCriteria getLikeBaseCriteria(ChannelCondition condition) {
        ParkChannelCriteria duc = new ParkChannelCriteria();
        ParkChannelCriteria.Criteria ducc = duc.createCriteria();
        if (StringUtils.isNotBlank(condition.getId())) {
            ducc.andUuidEqualTo(condition.getId());
        }
        if (StringUtils.isNotBlank(condition.getName())) {
            ducc.andNameLike("%"+condition.getName()+"%");
        }
        ducc.andDeleteFlagEqualTo(SqlUtil.FLAG_NORMAL);
        duc.setOrderByClause(SqlUtil.orderDesc("create_time"));//倒序
        return duc;
    }
}
