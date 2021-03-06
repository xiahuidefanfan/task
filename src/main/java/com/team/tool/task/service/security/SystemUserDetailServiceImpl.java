package com.team.tool.task.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.team.tool.task.bean.model.system.SystemUser;
import com.team.tool.task.common.support.SecuritySupport;
import com.team.tool.task.service.system.SystemUserService;

/**
 * @ClassName: SystemUserDetailServiceImpl.java
 * @Description: 系统登录service
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月12日 下午11:04:17 
 *
 * Modification History:
 * Date           Author          Version             Description
 *-----------------------------------------------------------------*
 * 2018年11月12日     xiahui           v1.0.0            系统登录service
 */
@Component
public class SystemUserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	private SystemUserService systemUserService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SystemUser systemUser = systemUserService.queryUserByUserName(username);
		return SecuritySupport.bulidSecurityUser(systemUser);
	}

}
