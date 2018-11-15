package com.team.tool.task.common.support;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.context.SecurityContextHolder;

import com.team.tool.task.bean.dto.security.SecurityUser;
import com.team.tool.task.bean.model.system.SystemMenu;
import com.team.tool.task.bean.model.system.SystemUser;
import com.team.tool.task.common.constants.CommonConstans;
import com.team.tool.task.common.enums.ErrorCodeEnum;
import com.team.tool.task.common.exception.SystemException;
import com.team.tool.task.common.util.ToolUtil;

/**
 * @ClassName: SecuritySupport.java
 * @Description: security支持工具
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月15日 下午1:03:18 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月15日     xiahui           v1.0.0         security支持工具
 */
public class SecuritySupport {
	
	/**
	 * @Description: 获取当前登录用户
	 * @author xiahui
	 * @date 2018年11月15日 下午8:17:33
	 */
	public static SecurityUser getSecurityUser() {
		return (SecurityUser) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
	}
	

	/**
	 * @Description: 获取前端用户信息封装
	 * @author xiahui
	 * @date 2018年11月15日 下午1:04:28
	 */
	public static SecurityUser bulidSecurityUser(SystemUser systemUser) {
		if(ToolUtil.isEmpty(systemUser)) {
			throw new SystemException(ErrorCodeEnum.TASK1001);
		}
		SecurityUser securityUser = new SecurityUser();
		securityUser.setUserId(systemUser.getUserId());
		securityUser.setUserName(systemUser.getUserName());
		securityUser.setUserPassword(systemUser.getUserPassword());
		securityUser.setUserRealName(systemUser.getUserRealName()); 
		securityUser.setUserDeptId(systemUser.getUserDeptId());
		securityUser.setUserRoleId(systemUser.getUserRoleId());
		securityUser.setAccountNonExpired(true);
		securityUser.setAccountNonLocked(true);
		securityUser.setCredentialsNonExpired(true);
		securityUser.setEnabled(true);
		securityUser.setPermissions(getPermissions(securityUser));
		return securityUser;
	}
	
	/**
	 * @Description: 获取权限标识集合
	 * @author xiahui
	 * @date 2018年11月15日 下午3:13:39
	 */
	@SuppressWarnings("unchecked")
	public static Set<String> getPermissions(SecurityUser securityUser){
		Set<SystemMenu> authorities = (Set<SystemMenu>) securityUser.getAuthorities();
		Set<String> permissions = new HashSet<String>(CommonConstans.DEFAULT_MAP_SIZE);
		for(SystemMenu systemMenu : authorities) {
			permissions.add(systemMenu.getAuthority());
		}
		return permissions;
	}
}
