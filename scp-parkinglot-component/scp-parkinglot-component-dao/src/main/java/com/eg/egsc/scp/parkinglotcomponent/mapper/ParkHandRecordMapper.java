package com.eg.egsc.scp.parkinglotcomponent.mapper;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkHandRecord;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkHandRecordCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ParkHandRecordMapper {
    int countByExample(ParkHandRecordCriteria example);

    int deleteByExample(ParkHandRecordCriteria example);

    int deleteByPrimaryKey(String uuid);

    int insert(ParkHandRecord record);

    int insertSelective(ParkHandRecord record);

    List<ParkHandRecord> selectByExampleWithRowbounds(ParkHandRecordCriteria example, RowBounds rowBounds);

    List<ParkHandRecord> selectByExample(ParkHandRecordCriteria example);

    ParkHandRecord selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") ParkHandRecord record, @Param("example") ParkHandRecordCriteria example);

    int updateByExample(@Param("record") ParkHandRecord record, @Param("example") ParkHandRecordCriteria example);

    int updateByPrimaryKeySelective(ParkHandRecord record);

    int updateByPrimaryKey(ParkHandRecord record);
}