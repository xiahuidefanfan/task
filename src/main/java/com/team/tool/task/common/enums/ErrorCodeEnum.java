package com.team.tool.task.common.enums;

/**
 * @ClassName: ErrorCodeEnum.java
 * @Description: 错误枚举
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月15日 下午1:58:29 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月15日     xiahui           v1.0.0            错误枚举
 */
public enum ErrorCodeEnum {
	
	/******************************************系统错误*****************************************/
	SYSTEM1001(1001, "【系统错误】-【{}】，错误信息为：{}"),
	
	/***************************************web入参校验错误*************************************/
	CHECK_ERROR(2001, "【入参错误】-【{}】，错误信息为：{}"),
	
	/******************************************资源错误****************************************/
	RESOURCE_ERROR(3001, "【资源错误】-【{}】，错误信息为：{}");
	
	private int code;
	private String msg;
	
	ErrorCodeEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	/**
	 * @Description: 查看错误信息
	 * @author xiahui
	 * @date 2018年11月15日 下午2:46:09
	 */
	public String msg() {
		return String.format("错误码:%d,%s", code, msg);
	}
	
	public int getCode() {
		return code;
	}
	
	public String getMsg() {
		return msg;
	}
}
