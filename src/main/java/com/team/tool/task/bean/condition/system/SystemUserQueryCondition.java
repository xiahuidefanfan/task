/**
 * 
 */
package com.team.tool.task.bean.condition.system;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.team.tool.task.bean.model.system.SystemUser;

/**
 * @ClassName: UserQueryCondition.java
 * @Description: 系统角色查询条件封装
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月11日 上午10:46:57 
 *
 * Modification History:
 * Date               Author          Version       Description
 *-------------------------------------------------------------*
 * 2018年11月11日     xiahui          v1.0.0     系统角色查询条件封装
 */
public class SystemUserQueryCondition extends SystemUser{

	private static final long serialVersionUID = 1L;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
}
