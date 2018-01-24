package com.eg.egsc.scp.parkinglotcomponent.mapper;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarDevRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarDevRelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ParkCarDevRelMapper {
    int countByExample(ParkCarDevRelCriteria example);

    int deleteByExample(ParkCarDevRelCriteria example);

    int deleteByPrimaryKey(String uuid);

    int insert(ParkCarDevRel record);

    int insertSelective(ParkCarDevRel record);

    List<ParkCarDevRel> selectByExampleWithRowbounds(ParkCarDevRelCriteria example, RowBounds rowBounds);

    List<ParkCarDevRel> selectByExample(ParkCarDevRelCriteria example);

    ParkCarDevRel selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") ParkCarDevRel record, @Param("example") ParkCarDevRelCriteria example);

    int updateByExample(@Param("record") ParkCarDevRel record, @Param("example") ParkCarDevRelCriteria example);

    int updateByPrimaryKeySelective(ParkCarDevRel record);

    int updateByPrimaryKey(ParkCarDevRel record);
}