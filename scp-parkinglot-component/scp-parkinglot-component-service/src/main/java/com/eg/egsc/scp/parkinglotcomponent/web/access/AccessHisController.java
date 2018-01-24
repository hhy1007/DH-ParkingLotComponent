/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.access;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.eg.egsc.framework.service.base.web.BaseWebController;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.common.page.PageVo;
import com.eg.egsc.scp.parkinglotcomponent.common.result.ResultMessage;
import com.eg.egsc.scp.parkinglotcomponent.condition.access.AccessHisCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAccessHis;
import com.eg.egsc.scp.parkinglotcomponent.service.park.ParkAccessHisService;
import com.eg.egsc.scp.parkinglotcomponent.web.vo.access.AccesshisVo;


/**
 * 车辆进出 控制层接口
 * 
 * @Class Name AccessHisController
 * @Author xiangdaoping
 * @Create In 2017年12月15日
 */
@RestController
@RequestMapping(value = "/accessHis")
public class AccessHisController extends BaseWebController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ParkAccessHisService parkAccessHisServiceImpl;

    /**
     * 车辆进出 分页查询
     * 
     * @Methods Name selectPageList
     * @Create In 2018年1月18日 By xiangdaoping
     * @param accessHisCondition
     * @return ResultMessage
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResultMessage selectPageList(AccessHisCondition accessHisCondition) {
        logger.info("selectPageList param: " + JSON.toJSONString(accessHisCondition));
        Page<ParkAccessHis> page = parkAccessHisServiceImpl.selectPageList(accessHisCondition);
        try {
            PageVo<AccesshisVo> pageVO = new PageVo<>(page, AccesshisVo.class);
            return ResultMessage.createSuccessResult(pageVO);
        } catch (InstantiationException e) {
            logger.error(e.getMessage());
        } catch (IllegalAccessException e1) {
            logger.error(e1.getMessage());
        }
        return ResultMessage.createErrorResult("00001", "内部错误", "");
    }

    /**
     * 导出在场车辆查询
     * 
     * @Methods Name exportAccessList
     * @Create In 2017年12月15日 By xiangdaoping
     * @param AccessHisCondition
     * @return ResultMessage
     */
    @RequestMapping(value = "/export/list", method = RequestMethod.GET)
    public ResultMessage exportAccessList(AccessHisCondition accessHisCondition) {
        logger.info("selectPageList param: " + JSON.toJSONString(accessHisCondition));
        // 从数据库获取适合筛选条件的车辆信息
        List<ParkAccessHis> duc = parkAccessHisServiceImpl.selectList(accessHisCondition);

        return ResultMessage.createSuccessResult(duc);
    }

}
