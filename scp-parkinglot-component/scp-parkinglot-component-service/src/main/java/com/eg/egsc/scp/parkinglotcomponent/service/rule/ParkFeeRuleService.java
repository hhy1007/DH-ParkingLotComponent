/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.rule;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.condition.rule.FeeRuleCondition;
import com.eg.egsc.scp.parkinglotcomponent.dto.rule.FeeRuleDto;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAccessCur;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkFeeRule;
import com.eg.egsc.scp.parkinglotcomponent.service.rule.dto.ResponseBillingDto;

/**
 * 收费规则管理业务层接口实现
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public interface ParkFeeRuleService {

    /**
     * 根据id查询收费规则信息
     * 
     * @param uuid
     * @return ParkFeeRule
     */
    ParkFeeRule selectByPrimaryKey(String uuid);
    
    /**
     * 通用计费接口
     * 
     * @param parkAccessCur
     * @param carType
     * @param endTime
     * @return
     * @throws ParseException ResponseBillingDto
     */
    ResponseBillingDto universalBillingInterface(ParkAccessCur parkAccessCur, Integer carType,
            Date endTime) throws ParseException;

    /**
     * 计算收费规则
     * 
     * @param startTime
     * @param endTime
     * @param carType
     * @param feeRuleDto
     * @return
     * @throws ParseException String
     */
    String computationsFeeRule(Date startTime, Date endTime, Integer carType, FeeRuleDto feeRuleDto)
            throws ParseException;

    /**
     * 添加收费规则
     * 
     * @param feeRuleDto
     * @return int
     */
    int insert(FeeRuleDto feeRuleDto);

    /**
     * 更新收费规则
     * 
     * @param feeRuleDto
     * @return int
     */
    int update(FeeRuleDto feeRuleDto);

    /**
     * 删除收费规则
     * 
     * @param ids
     * @return int
     */
    int deleteByIds(List<String> ids);

    /**
     * 收费规则信息分页查询
     * 
     * @param condition
     * @return Page<ParkFeeRule>
     */
    Page<ParkFeeRule> selectPageList(FeeRuleCondition condition);

    /**
     * 收费规则信息查询
     * 
     * @param condition
     * @return List<ParkFeeRule>
     */
    List<ParkFeeRule> selectList(FeeRuleCondition condition);

}
