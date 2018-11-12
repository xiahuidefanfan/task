/**
 * 
 */
package com.team.tool.task.bean.condition;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName: UserQueryCondition.java
 * @Description: 传输层dto-查询条件
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月11日 上午10:46:57 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月11日     xiahui           v1.0.0              创建项目
 */
public class SystemUserQueryCondition {
	
	private String username;
	
	@ApiModelProperty(value = "用户年龄起始值")
	private int age;
	@ApiModelProperty(value = "用户年龄终止值")
	private int ageTo;
	
	private String xxx;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAgeTo() {
		return ageTo;
	}

	public void setAgeTo(int ageTo) {
		this.ageTo = ageTo;
	}

	public String getXxx() {
		return xxx;
	}

	public void setXxx(String xxx) {
		this.xxx = xxx;
	}
	
}
