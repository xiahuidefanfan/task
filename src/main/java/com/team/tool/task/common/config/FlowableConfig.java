package com.team.tool.task.common.config;

import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.spring.ProcessEngineFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @ClassName: FlowableConfiguration.java
 * @Description: 工作流配置
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月3日 下午4:49:35 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年12月3日     xiahui           v1.0.0            工作流配置
 */
@Configuration
public class FlowableConfig {
	
	@Bean
    public StandaloneProcessEngineConfiguration standaloneProcessEngineConfiguration(DruidDataSource druidDataSource) {
		StandaloneProcessEngineConfiguration config = new StandaloneProcessEngineConfiguration(); 
		config.setDataSource(druidDataSource);
		config.setAsyncExecutorActivate(false);
		config.setDatabaseSchemaUpdate("true");
		return config;
    }
	
	@Bean
	public ProcessEngineFactoryBean processEngineFactoryBean(StandaloneProcessEngineConfiguration processEngineConfiguration){
		ProcessEngineFactoryBean bean = new ProcessEngineFactoryBean();
		bean.setProcessEngineConfiguration(processEngineConfiguration);
		return bean;
	}
	
}
