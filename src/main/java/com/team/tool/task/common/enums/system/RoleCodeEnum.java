package com.team.tool.task.common.enums.system;

/**
 * @ClassName: RoleCodeEnum.java
 * @Description: 角色编码枚举
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月8日 下午1:58:29 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年12月8日     xiahui           v1.0.0          角色编码枚举
 */
public enum RoleCodeEnum {
	
	DEVELOPER_ENGINEER("DEVELOPER_ENGINEER", "开发工程师"),
	PRODUCT_MANAGER("PRODUCT_MANAGER", "产品经理"),
	TEST_ENGINEER("TEST_ENGINEER", "测试工程师");
	
	private String code;
	private String name;
	
	RoleCodeEnum(String code, String name) {
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
