package com.team.tool.task.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
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
 * Date         Author          Version               Description
 *------------------------------------------------------------------*
 * 2018年11月11日     xiahui           v1.0.0            创建项目
 */
@Component
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AuthenticationSuccessHandler systemAuthenticationSuccessHandler;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.GET, "/**/*.css", "/**/*.js", "/**/*.png", "/**/*.gif", "/**/*.jpg");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin()
			.loginProcessingUrl("/login.action").usernameParameter("username").passwordParameter("password")
			.successHandler(systemAuthenticationSuccessHandler)
			.and()
			.authorizeRequests()
			.anyRequest()
			.authenticated();
		http.csrf().disable();
	}
}
