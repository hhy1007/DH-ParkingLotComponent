package com.eg.egsc.scp.parkinglotcomponent.mapper;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkRule;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkRuleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ParkRuleMapper {
    int countByExample(ParkRuleCriteria example);

    int deleteByExample(ParkRuleCriteria example);

    int deleteByPrimaryKey(String uuid);

    int insert(ParkRule record);

    int insertSelective(ParkRule record);

    List<ParkRule> selectByExampleWithRowbounds(ParkRuleCriteria example, RowBounds rowBounds);

    List<ParkRule> selectByExample(ParkRuleCriteria example);

    ParkRule selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") ParkRule record, @Param("example") ParkRuleCriteria example);

    int updateByExample(@Param("record") ParkRule record, @Param("example") ParkRuleCriteria example);

    int updateByPrimaryKeySelective(ParkRule record);

    int updateByPrimaryKey(ParkRule record);
}