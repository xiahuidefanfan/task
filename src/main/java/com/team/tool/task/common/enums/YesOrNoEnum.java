package com.team.tool.task.common.enums;

/**
 * @ClassName: YesOrNoEnum.java
 * @Description: 是否枚举
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月15日 下午3:40:08 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年12月15日     xiahui           v1.0.0          是否枚举
 */
public enum YesOrNoEnum {
	
	YES(1, "是"),
	NO(0, "否");
	
	/**
	 * @Description: 根据code获取枚举
	 * @author: xiahui
	 * @date: 2018年12月15日 下午3:54:38
	 */
	public static YesOrNoEnum getByCode(Integer code) {
		YesOrNoEnum[] all = YesOrNoEnum.values();
		for (YesOrNoEnum item : all){
			if (item.getCode() == code){
				return item;
			}
		}
		return null;
	}
	
	private Integer code;
	private String msg;
	
	YesOrNoEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
	
}
