package com.eg.egsc.scp.parkinglotcomponent.mapper;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkFeeRule;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkFeeRuleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ParkFeeRuleMapper {
    int countByExample(ParkFeeRuleCriteria example);

    int deleteByExample(ParkFeeRuleCriteria example);

    int deleteByPrimaryKey(String uuid);

    int insert(ParkFeeRule record);

    int insertSelective(ParkFeeRule record);

    List<ParkFeeRule> selectByExampleWithRowbounds(ParkFeeRuleCriteria example, RowBounds rowBounds);

    List<ParkFeeRule> selectByExample(ParkFeeRuleCriteria example);

    ParkFeeRule selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") ParkFeeRule record, @Param("example") ParkFeeRuleCriteria example);

    int updateByExample(@Param("record") ParkFeeRule record, @Param("example") ParkFeeRuleCriteria example);

    int updateByPrimaryKeySelective(ParkFeeRule record);

    int updateByPrimaryKey(ParkFeeRule record);
}