/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 初始化redis缓存
 * 
 * @Class Name InitBaseData
 * @Author zhangli
 * @Create In 2018年1月6日
 */
@Component
@Order(value=1)
public class InitRedisData implements CommandLineRunner{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    /* (non-Javadoc)
     * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
     */
    @Override
    public void run(String... args) throws Exception {
        logger.info("## Init redis data ##");
        
    }

}
