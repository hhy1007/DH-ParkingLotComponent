package com.eg.egsc.scp.parkinglotcomponent.mapper;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkLedCarportRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkLedCarportRelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ParkLedCarportRelMapper {
    int countByExample(ParkLedCarportRelCriteria example);

    int deleteByExample(ParkLedCarportRelCriteria example);

    int deleteByPrimaryKey(String uuid);

    int insert(ParkLedCarportRel record);

    int insertSelective(ParkLedCarportRel record);

    List<ParkLedCarportRel> selectByExampleWithRowbounds(ParkLedCarportRelCriteria example, RowBounds rowBounds);

    List<ParkLedCarportRel> selectByExample(ParkLedCarportRelCriteria example);

    ParkLedCarportRel selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") ParkLedCarportRel record, @Param("example") ParkLedCarportRelCriteria example);

    int updateByExample(@Param("record") ParkLedCarportRel record, @Param("example") ParkLedCarportRelCriteria example);

    int updateByPrimaryKeySelective(ParkLedCarportRel record);

    int updateByPrimaryKey(ParkLedCarportRel record);
}