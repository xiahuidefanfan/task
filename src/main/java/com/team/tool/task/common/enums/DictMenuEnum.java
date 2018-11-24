package com.team.tool.task.common.enums;

/**
 * @ClassName: DictMenuEnum.java
 * @Description: 系统字典常量
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月23日 下午5:11:24 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月23日     xiahui           v1.0.0           系统字典常量
 */
public enum DictMenuEnum {
	
	SYS_SEX("sys_sex", "性别"),
	SYS_STATE("sys_state", "状态"),
	IS_MENU("is_menu", "是否菜单");
	
	private String code;
	private String name;
	
	DictMenuEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public String getName() {
		return this.name;
	}

}
