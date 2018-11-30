package com.team.tool.task.bean.condition.system;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.team.tool.task.bean.condition.BaseCondition;

/**
 * @ClassName: SystemRoleQueryCondition.java
 * @Description: 系统角色查询条件封装
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月12日 下午10:05:35 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月12日     xiahui           v1.0.0    系统角色查询条件封装  
 */
public class SystemRoleQueryCondition extends BaseCondition{
	
	/**
	 * 角色名称
	 */
	private String roleName;
	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
