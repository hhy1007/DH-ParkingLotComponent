/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

import com.eg.egsc.framework.service.core.ApplicationStarter;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"com.eg.egsc"})
@MapperScan(basePackages = {"com.eg.egsc.scp.parkinglotcomponent"})
public class ServiceApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ServiceApplication.class);
    }

    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        new ApplicationStarter().run(ServiceApplication.class, args);
    }
}
