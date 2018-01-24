package com.eg.egsc.scp.parkinglotcomponent.mapper;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarport;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarportCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ParkCarportMapper {
    int countByExample(ParkCarportCriteria example);

    int deleteByExample(ParkCarportCriteria example);

    int deleteByPrimaryKey(String uuid);

    int insert(ParkCarport record);

    int insertSelective(ParkCarport record);

    List<ParkCarport> selectByExampleWithRowbounds(ParkCarportCriteria example, RowBounds rowBounds);

    List<ParkCarport> selectByExample(ParkCarportCriteria example);

    ParkCarport selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") ParkCarport record, @Param("example") ParkCarportCriteria example);

    int updateByExample(@Param("record") ParkCarport record, @Param("example") ParkCarportCriteria example);

    int updateByPrimaryKeySelective(ParkCarport record);

    int updateByPrimaryKey(ParkCarport record);
}