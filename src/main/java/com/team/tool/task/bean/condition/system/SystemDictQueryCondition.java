package com.team.tool.task.bean.condition.system;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.team.tool.task.bean.condition.BaseCondition;

/**
 * @ClassName: SystemDictQueryCondition.java
 * @Description: 系统字典查询条件封装
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月19日 下午2:22:19 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月19日     xiahui           v1.0.0         系统字典查询条件封装
 */
public class SystemDictQueryCondition extends BaseCondition{
	
	/**
	 * 字典名称
	 */
	private String dictName;
	
	/**
	 * 字典编码
	 */
	private String dictCode;
	
	public String getDictName() {
		return dictName;
	}

	public void setDictName(String dictName) {
		this.dictName = dictName;
	}

	public String getDictCode() {
		return dictCode;
	}

	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}	
}
