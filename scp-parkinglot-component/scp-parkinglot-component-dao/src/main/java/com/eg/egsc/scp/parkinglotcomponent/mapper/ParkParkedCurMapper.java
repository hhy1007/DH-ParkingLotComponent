package com.eg.egsc.scp.parkinglotcomponent.mapper;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkedCur;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkedCurCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ParkParkedCurMapper {
    int countByExample(ParkParkedCurCriteria example);

    int deleteByExample(ParkParkedCurCriteria example);

    int deleteByPrimaryKey(String uuid);

    int insert(ParkParkedCur record);

    int insertSelective(ParkParkedCur record);

    List<ParkParkedCur> selectByExampleWithRowbounds(ParkParkedCurCriteria example, RowBounds rowBounds);

    List<ParkParkedCur> selectByExample(ParkParkedCurCriteria example);

    ParkParkedCur selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") ParkParkedCur record, @Param("example") ParkParkedCurCriteria example);

    int updateByExample(@Param("record") ParkParkedCur record, @Param("example") ParkParkedCurCriteria example);

    int updateByPrimaryKeySelective(ParkParkedCur record);

    int updateByPrimaryKey(ParkParkedCur record);
}