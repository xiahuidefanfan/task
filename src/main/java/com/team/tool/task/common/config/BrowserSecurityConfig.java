package com.team.tool.task.common.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

/**
 * @ClassName: BrowserSecurityConfig.java
 * @Description: 浏览器安全配置
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月11日 下午10:04:02 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月11日     xiahui           v1.0.0             创建项目
 */
@Component
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin()
			.and()
			.authorizeRequests()
			.anyRequest()
			.authenticated();
	}
}
