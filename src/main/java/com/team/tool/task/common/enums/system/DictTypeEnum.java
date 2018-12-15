package com.team.tool.task.common.enums.system;

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
public enum DictTypeEnum {
	
	SYS_SEX("sys_sex", "性别"),
	SYS_STATE("sys_state", "状态"),
	SERVICE_MODULE("service_group", "服务组件"),
	DEMAND_STAGE("demand_stage", "需求阶段"),
	MISSION_STAGE("mission_stage", "任务阶段"),
	IS_MENU("is_menu", "是否菜单"),
	WORKFLOW_NODE_TYPE("workflow_node_type", "工作流节点名称");
	
	private String code;
	private String name;
	
	DictTypeEnum(String code, String name) {
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
