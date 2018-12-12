package com.team.tool.task;

import org.flowable.spring.boot.DataSourceProcessEngineAutoConfiguration;
import org.flowable.spring.boot.EndpointAutoConfiguration;
import org.flowable.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: TaskApplication.java
 * @Description: 工程启动类
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月23日 上午10:09:00 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月23日     xiahui           v1.0.0           工程启动类
 */
@SpringBootApplication(exclude= {DataSourceProcessEngineAutoConfiguration.class,SecurityAutoConfiguration.class,EndpointAutoConfiguration.class})
public class TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}
}
