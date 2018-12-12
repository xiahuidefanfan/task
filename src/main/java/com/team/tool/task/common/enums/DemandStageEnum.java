package com.team.tool.task.common.enums;

/**
 * @ClassName: DemandStageEnum.java
 * @Description: 需求阶段枚举
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月12日 下午8:38:29 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年12月8日     xiahui           v1.0.0            需求阶段枚举
 */
public enum DemandStageEnum {
	
	DEMAND_CREATE("demand_create", "需求创建");
	
	private String code;
	private String name;
	
	DemandStageEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
}
