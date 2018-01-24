package com.eg.egsc.scp.parkinglotcomponent.mapper;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarCapture;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarCaptureCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ParkCarCaptureMapper {
    int countByExample(ParkCarCaptureCriteria example);

    int deleteByExample(ParkCarCaptureCriteria example);

    int deleteByPrimaryKey(String uuid);

    int insert(ParkCarCapture record);

    int insertSelective(ParkCarCapture record);

    List<ParkCarCapture> selectByExampleWithRowbounds(ParkCarCaptureCriteria example, RowBounds rowBounds);

    List<ParkCarCapture> selectByExample(ParkCarCaptureCriteria example);

    ParkCarCapture selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") ParkCarCapture record, @Param("example") ParkCarCaptureCriteria example);

    int updateByExample(@Param("record") ParkCarCapture record, @Param("example") ParkCarCaptureCriteria example);

    int updateByPrimaryKeySelective(ParkCarCapture record);

    int updateByPrimaryKey(ParkCarCapture record);
}