package com.team.tool.task.common.enums;

/**
 * @ClassName: MissionStageEnum.java
 * @Description: 任务阶段枚举
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月8日 下午3:06:29 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年12月8日     xiahui           v1.0.0            任务阶段枚举
 */
public enum MissionStageEnum {
	
	MISSION_CREATED("mission_created", "任务创建");
	
	private String code;
	private String name;
	
	MissionStageEnum(String code, String name) {
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
