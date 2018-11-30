package com.team.tool.task.bean.condition.system;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.team.tool.task.bean.condition.BaseCondition;

/**
 * @ClassName: SystemMenuQueryCondition.java
 * @Description: 系统菜单查询条件封装
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月12日 下午10:32:20 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月12日     xiahui    v1.0.0           系统菜单查询条件封装 
 */
public class SystemMenuQueryCondition extends BaseCondition{
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
