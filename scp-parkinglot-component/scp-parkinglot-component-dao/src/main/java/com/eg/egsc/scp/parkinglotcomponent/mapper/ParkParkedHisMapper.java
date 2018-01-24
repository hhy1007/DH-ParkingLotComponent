package com.eg.egsc.scp.parkinglotcomponent.mapper;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkedHis;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkedHisCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ParkParkedHisMapper {
    int countByExample(ParkParkedHisCriteria example);

    int deleteByExample(ParkParkedHisCriteria example);

    int deleteByPrimaryKey(String uuid);

    int insert(ParkParkedHis record);

    int insertSelective(ParkParkedHis record);

    List<ParkParkedHis> selectByExampleWithRowbounds(ParkParkedHisCriteria example, RowBounds rowBounds);

    List<ParkParkedHis> selectByExample(ParkParkedHisCriteria example);

    ParkParkedHis selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") ParkParkedHis record, @Param("example") ParkParkedHisCriteria example);

    int updateByExample(@Param("record") ParkParkedHis record, @Param("example") ParkParkedHisCriteria example);

    int updateByPrimaryKeySelective(ParkParkedHis record);

    int updateByPrimaryKey(ParkParkedHis record);
}