package com.team.tool.task.bean.condition.workflow;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.team.tool.task.bean.condition.BaseCondition;

/**
 * @ClassName: WorkflowProcdefQueryCondition.java
 * @Description: 流程查询条件
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月19日 下午2:13:50 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年12月19日     xiahui           v1.0.0           流程查询条件
 */
public class WorkflowProcdefQueryCondition extends BaseCondition{
	
	/**
	 * 流程ID
	 */
	private String procdefId;
	
	/**
	 * 流程名称
	 */
	private String procdefName;
	
	/**
	 * 流程主键
	 */
	private String procdefKey;

	public String getProcdefId() {
		return procdefId;
	}

	public void setProcdefId(String procdefId) {
		this.procdefId = procdefId;
	}

	public String getProcdefName() {
		return procdefName;
	}

	public void setProcdefName(String procdefName) {
		this.procdefName = procdefName;
	}

	public String getProcdefKey() {
		return procdefKey;
	}

	public void setProcdefKey(String procdefKey) {
		this.procdefKey = procdefKey;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
