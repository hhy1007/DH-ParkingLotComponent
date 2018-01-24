/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.config;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.eg.egsc.framework.service.util.SpringEnvUtil;

/**
 * 线程池配置
 * 
 * @Class Name ExecuteConfig
 * @Author zhangli
 * @Create In 2018年1月6日
 */
@Configuration
public class ExecuteConfig {

    @Autowired
    private SpringEnvUtil springEnvUtil;

    private static final String PARK_COREPOOLSIZE = "park.corePoolSize";

    private static final String PARK_MAXPOOLSIZE = "park.maxPoolSize";

    private static final String PARK_QUEUECAPACITY = "park.queueCapacity";

    private static final String PARK_KEEPALIVESECONDS = "park.keepAliveSeconds";

    private static final String PARK_ALLOWCORETHREADTIMEOUT = "park.allowCoreThreadTimeOut";

    private static final String PARK_THREADNAMEPREFIX = "park.threadNamePrefix";

    private static final String PORT_COREPOOLSIZE = "port.corePoolSize";

    private static final String PORT_MAXPOOLSIZE = "port.maxPoolSize";

    private static final String PORT_QUEUECAPACITY = "port.queueCapacity";

    private static final String PORT_KEEPALIVESECONDS = "port.keepAliveSeconds";

    private static final String PORT_ALLOWCORETHREADTIMEOUT = "port.allowCoreThreadTimeOut";

    private static final String PORT_THREADNAMEPREFIX = "port.threadNamePrefix";

    @Bean(name = "parkExecutor")
    public Executor parkExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(Integer.parseInt(springEnvUtil.getProperty(PARK_COREPOOLSIZE)));
        executor.setMaxPoolSize(Integer.parseInt(springEnvUtil.getProperty(PARK_MAXPOOLSIZE)));
        executor.setQueueCapacity(Integer.parseInt(springEnvUtil.getProperty(PARK_QUEUECAPACITY)));
        executor.setKeepAliveSeconds(
                Integer.parseInt(springEnvUtil.getProperty(PARK_KEEPALIVESECONDS)));
        executor.setAllowCoreThreadTimeOut(
                Boolean.parseBoolean(springEnvUtil.getProperty(PARK_ALLOWCORETHREADTIMEOUT)));
        executor.setThreadNamePrefix(springEnvUtil.getProperty(PARK_THREADNAMEPREFIX));
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }

    @Bean(name = "portExecutor")
    public Executor portExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(Integer.parseInt(springEnvUtil.getProperty(PORT_COREPOOLSIZE)));
        executor.setMaxPoolSize(Integer.parseInt(springEnvUtil.getProperty(PORT_MAXPOOLSIZE)));
        executor.setQueueCapacity(Integer.parseInt(springEnvUtil.getProperty(PORT_QUEUECAPACITY)));
        executor.setKeepAliveSeconds(
                Integer.parseInt(springEnvUtil.getProperty(PORT_KEEPALIVESECONDS)));
        executor.setAllowCoreThreadTimeOut(
                Boolean.parseBoolean(springEnvUtil.getProperty(PORT_ALLOWCORETHREADTIMEOUT)));
        executor.setThreadNamePrefix(springEnvUtil.getProperty(PORT_THREADNAMEPREFIX));
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}
