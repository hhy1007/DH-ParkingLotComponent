package com.eg.egsc.scp.parkinglotcomponent.mapper;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkPackageParkRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkPackageParkRelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ParkPackageParkRelMapper {
    int countByExample(ParkPackageParkRelCriteria example);

    int deleteByExample(ParkPackageParkRelCriteria example);

    int insert(ParkPackageParkRel record);

    int insertSelective(ParkPackageParkRel record);

    List<ParkPackageParkRel> selectByExampleWithRowbounds(ParkPackageParkRelCriteria example, RowBounds rowBounds);

    List<ParkPackageParkRel> selectByExample(ParkPackageParkRelCriteria example);

    int updateByExampleSelective(@Param("record") ParkPackageParkRel record, @Param("example") ParkPackageParkRelCriteria example);

    int updateByExample(@Param("record") ParkPackageParkRel record, @Param("example") ParkPackageParkRelCriteria example);
}