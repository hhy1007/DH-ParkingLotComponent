package com.eg.egsc.scp.parkinglotcomponent.mapper;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAccessHis;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAccessHisCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ParkAccessHisMapper {
    int countByExample(ParkAccessHisCriteria example);

    int deleteByExample(ParkAccessHisCriteria example);

    int deleteByPrimaryKey(String uuid);

    int insert(ParkAccessHis record);

    int insertSelective(ParkAccessHis record);

    List<ParkAccessHis> selectByExampleWithRowbounds(ParkAccessHisCriteria example, RowBounds rowBounds);

    List<ParkAccessHis> selectByExample(ParkAccessHisCriteria example);

    ParkAccessHis selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") ParkAccessHis record, @Param("example") ParkAccessHisCriteria example);

    int updateByExample(@Param("record") ParkAccessHis record, @Param("example") ParkAccessHisCriteria example);

    int updateByPrimaryKeySelective(ParkAccessHis record);

    int updateByPrimaryKey(ParkAccessHis record);
}