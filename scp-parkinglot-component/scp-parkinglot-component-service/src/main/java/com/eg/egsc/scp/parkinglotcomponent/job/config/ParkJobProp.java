/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.job.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.eg.egsc.common.component.job.model.BusinessJobConfig;

/**
 * @Class Name ParkJobProp
 * @Author zhangli
 * @Create In 2018年1月6日
 */
@Component
@ConfigurationProperties(prefix = "egsc.schedule")
public class ParkJobProp {

    private List<BusinessJobConfig> jobs = new ArrayList<>();

    public List<BusinessJobConfig> getJobs() {
      return jobs;
    }

    public void setJobs(List<BusinessJobConfig> jobs) {
      this.jobs = jobs;
    }
}
