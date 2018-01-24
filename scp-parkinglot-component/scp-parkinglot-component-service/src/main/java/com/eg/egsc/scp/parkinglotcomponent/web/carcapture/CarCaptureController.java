/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.carcapture;

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
import com.eg.egsc.scp.parkinglotcomponent.condition.carcapture.CarCaptureCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarCapture;
import com.eg.egsc.scp.parkinglotcomponent.service.carcapture.CarCaptureService;
import com.eg.egsc.scp.parkinglotcomponent.web.vo.carcapture.CarcaptureVo;

/**
 * 在场车辆 控制层接口
 * 
 * @Class Name AccesscurController
 * @Author xiangdaoping
 * @Create In 2017年12月15日
 */
@RestController
@RequestMapping(value = "/carcapture")
public class CarCaptureController extends BaseWebController {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	 @Autowired
	 private CarCaptureService carCaptureServiceImpl;
	 
	 
	 /**
	     * 在场车辆 分页查询
	     * @Methods Name selectPageList
	     * @Create In 2017年12月15日 By xiangdaoping
	     * @param AccessCurCondition
	     * @return
	     * @throws InstantiationException
	     * @throws IllegalAccessException ResultMessage
	     */
	    @RequestMapping(value = "/listCarCaptures", method = RequestMethod.GET)
	    public ResultMessage selectPageList(CarCaptureCondition carCaptureCondition)
	            throws InstantiationException, IllegalAccessException { 
	        logger.info("selectPageList param: " + JSON.toJSONString(carCaptureCondition));
	        Page<ParkCarCapture> page = carCaptureServiceImpl.selectPageList(carCaptureCondition);
	        PageVo<CarcaptureVo> pageVO = new PageVo<>(page, CarcaptureVo.class);
	        return ResultMessage.createSuccessResult(pageVO);
	    }
	    /**
	     * 导出在场车辆查询
	     * @Methods Name exportAccessList
	     * @Create In 2017年12月15日 By xiangdaoping
	     * @param AccessHisCondition
	     * @return
	     * @throws InstantiationException
	     * @throws IllegalAccessException ResultMessage
	     */
	    @RequestMapping(value = "/export", method = RequestMethod.GET)
	    public ResultMessage exportAccessList(CarCaptureCondition carCaptureCondition)
	            throws InstantiationException, IllegalAccessException {
	        logger.info("selectPageList param: " + JSON.toJSONString(carCaptureCondition));
	        //从数据库获取适合筛选条件的车辆信息
	        List<ParkCarCapture>  duc=   carCaptureServiceImpl.selectList(carCaptureCondition);
	             	        
	        return ResultMessage.createSuccessResult(duc);
	    }  
}
