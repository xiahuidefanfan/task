package com.team.tool.task.common.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.team.tool.task.common.support.WebDateSupport;
import com.team.tool.task.service.security.SystemUserDetailServiceImpl;

/**
 * 
 * @ClassName: SecurityBeanConfig.java
 * @Description: 认证相关的扩展点配置
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月13日 上午9:57:28 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月13日     xiahui           v1.0.0     认证相关的扩展点配置
 */
@Configuration
public class SecurityBeanConfig {

	/**
	 * @Description: 默认密码处理器
	 * @author xiahui
	 * @date 2018年11月13日 上午9:58:41
	 */
	@Bean
	@ConditionalOnMissingBean(PasswordEncoder.class)
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/**
	 * @Description: 默认认证器
	 * @author xiahui
	 * @date 2018年11月13日 上午9:58:53
	 */
	@Bean
	@ConditionalOnMissingBean(UserDetailsService.class)
	public UserDetailsService userDetailsService() {
		return new SystemUserDetailServiceImpl();
	}
	
	@Bean
	@ConditionalOnMissingBean(WebDateSupport.class)
	public WebDateSupport webDateSupport(){
		return new WebDateSupport();
	}

}
