/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.eg.egsc.framework.client.core.ClientConfig;
import com.eg.egsc.scp.mdm.component.dto.BaseUserDto;
import com.eg.egsc.scp.parkinglotcomponent.service.mdm.MdmOperateService;

import junit.framework.TestCase;

/**
 * 主数据下发服务测试类
 * 
 * @author huangyuhong
 * @since 2018年1月18日
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClientConfig.class})
public class MdmOperateServiceTest extends TestCase{
    
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private MdmOperateService mdmOperateServiceImpl;
    
    @Test
    @Transactional
    @Rollback(true)
    public void deleteOwnerRel() {
        BaseUserDto baseUserDto = new BaseUserDto();
        baseUserDto.setUuid("1001");
        int result = mdmOperateServiceImpl.deleteOwnerRel(baseUserDto);
        logger.info("=== " + result);
    }

}
