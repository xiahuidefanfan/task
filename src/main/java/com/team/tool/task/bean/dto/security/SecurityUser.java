package com.team.tool.task.bean.dto.security;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.team.tool.task.common.factory.ConstantFactory;

/**
 * @ClassName: SecurityUser.java
 * @Description: security用户信息，用户给前端
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月15日 上午11:30:13 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月15日     xiahui           v1.0.0     security用户信息，用户给前端
 */
public class SecurityUser implements UserDetails{

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    public Integer userId;     
    /**
     * 账号
     */
    public String userName;
    /**
     * 密码
     */
    public String userPassword;
    /**
     * 真实姓名
     */
    public String userRealName;
    /**
     * 部门
     */
    public Integer userDeptId;
    /**
     * 角色
     */
    public Integer userRoleId;
    /**
     * 权限集合
     */
    public Set<String> permissions;
	/**
	 * 账号是否过期
	 */
	private boolean accountNonExpired;
	/**
	 * 账号是否锁定
	 */
	private boolean accountNonLocked;
	/**
	 * 凭证是否过期
	 */
	private boolean credentialsNonExpired;
	/**
	 * 是否可用
	 */
	private boolean enabled;
	
	public String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	@Override
	public String getUsername() {
		return this.userName;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getUserDeptId() {
		return userDeptId;
	}

	public void setUserDeptId(Integer userDeptId) {
		this.userDeptId = userDeptId;
	}

	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}
	
	public Set<String> getPermissions() {
		return permissions;
	}
	public void setPermissions(Set<String> permissions) {
		this.permissions = permissions;
	}	
	
	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Integer> authorityIds = ConstantFactory.me().queryAuthoritiesByRoleId(this.userRoleId);
		return ConstantFactory.me().queryAuthoritiesModelByMenuId(authorityIds);
	}
	
	@Override
	public String getPassword() {
		return this.getUserPassword();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
