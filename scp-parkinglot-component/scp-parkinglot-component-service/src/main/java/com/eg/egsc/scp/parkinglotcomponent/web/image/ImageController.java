/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.image;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.eg.egsc.framework.service.base.web.BaseWebController;
import com.eg.egsc.scp.parkinglotcomponent.common.result.ResultMessage;
import com.eg.egsc.scp.parkinglotcomponent.service.image.ImageService;
import com.eg.egsc.scp.parkinglotcomponent.web.vo.image.ImageVo;

import io.swagger.annotations.ApiOperation;

/**
 * @Class Name ImageController
 * @Author zhangli
 * @Create In 2017年12月20日
 */
@RestController
@RequestMapping(value = "/image")
public class ImageController extends BaseWebController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private ImageService imageServiceImpl;
    
    @ApiOperation(value = "获取图像数据", notes = "base64编码")
    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public ResultMessage getImageData(@RequestParam(name = "id") String id) throws Exception{
        logger.info("getImageData id: {}", id);
        byte[] imageData = imageServiceImpl.getImageData(id);
        return ResultMessage.createSuccessResult(new String(imageData));
    }
    
    @ApiOperation(value = "删除图像数据", notes = "base64编码")
    @RequestMapping(value = "/data", method = RequestMethod.POST)
    public ResultMessage deleteFile(@RequestBody ImageVo imageVo) throws Exception{
        logger.info("uploadImage id: {}", JSON.toJSONString(imageVo));
        int result = imageServiceImpl.deleteFile(imageVo.getId());
        return ResultMessage.createSuccessResult(result);
    }
}
