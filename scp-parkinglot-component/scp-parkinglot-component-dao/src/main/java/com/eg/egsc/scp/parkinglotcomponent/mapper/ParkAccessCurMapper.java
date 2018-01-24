package com.eg.egsc.scp.parkinglotcomponent.mapper;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAccessCur;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAccessCurCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ParkAccessCurMapper {
    int countByExample(ParkAccessCurCriteria example);

    int deleteByExample(ParkAccessCurCriteria example);

    int deleteByPrimaryKey(String uuid);

    int insert(ParkAccessCur record);

    int insertSelective(ParkAccessCur record);

    List<ParkAccessCur> selectByExampleWithRowbounds(ParkAccessCurCriteria example, RowBounds rowBounds);

    List<ParkAccessCur> selectByExample(ParkAccessCurCriteria example);

    ParkAccessCur selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") ParkAccessCur record, @Param("example") ParkAccessCurCriteria example);

    int updateByExample(@Param("record") ParkAccessCur record, @Param("example") ParkAccessCurCriteria example);

    int updateByPrimaryKeySelective(ParkAccessCur record);

    int updateByPrimaryKey(ParkAccessCur record);
}