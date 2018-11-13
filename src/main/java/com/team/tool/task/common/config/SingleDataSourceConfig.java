package com.team.tool.task.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.team.tool.task.common.config.properties.DruidProperties;

/**
 * @ClassName: SingleDataSourceConfig.java
 * @Description: 数据源配置
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月11日 下午11:04:08 
 *
 * Modification History:
 * Date               Author          Version            Description
 *-----------------------------------------------------------------*
 * 2018年11月11日     xiahui           v1.0.0              项目新建 
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {"com.team.tool.task.dao"})
public class SingleDataSourceConfig {
	
	@Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidProperties druidProperties() {
        return new DruidProperties();
    }

    @Bean
    public DruidDataSource dataSource(DruidProperties druidProperties) {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        return dataSource;
    }

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

}

