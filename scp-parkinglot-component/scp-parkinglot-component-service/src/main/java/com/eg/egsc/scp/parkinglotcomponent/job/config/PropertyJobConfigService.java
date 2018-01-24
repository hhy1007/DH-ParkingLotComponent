/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.job.config;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.eg.egsc.common.component.job.model.BusinessJobConfig;
import com.eg.egsc.common.component.job.support.JobConfigService;

/**
 * @Class Name DemoJobInfoService
 * @Author gaoyanlong
 * @Create In 2017年12月21日
 */
@Component("jobConfig")
public class PropertyJobConfigService implements JobConfigService {

  @Resource
  ParkJobProp parkJobProp;

  @Override
  public List<BusinessJobConfig> getAllJobConfigs() {
    return parkJobProp.getJobs();
  }

}
