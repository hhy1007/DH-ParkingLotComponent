package com.eg.egsc.scp.parkinglotcomponent.mapper;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkConsumeRecord;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkConsumeRecordCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ParkConsumeRecordMapper {
    int countByExample(ParkConsumeRecordCriteria example);

    int deleteByExample(ParkConsumeRecordCriteria example);

    int deleteByPrimaryKey(String uuid);

    int insert(ParkConsumeRecord record);

    int insertSelective(ParkConsumeRecord record);

    List<ParkConsumeRecord> selectByExampleWithRowbounds(ParkConsumeRecordCriteria example, RowBounds rowBounds);

    List<ParkConsumeRecord> selectByExample(ParkConsumeRecordCriteria example);

    ParkConsumeRecord selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") ParkConsumeRecord record, @Param("example") ParkConsumeRecordCriteria example);

    int updateByExample(@Param("record") ParkConsumeRecord record, @Param("example") ParkConsumeRecordCriteria example);

    int updateByPrimaryKeySelective(ParkConsumeRecord record);

    int updateByPrimaryKey(ParkConsumeRecord record);
}