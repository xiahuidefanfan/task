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
	
	DEMAND_CREATE("demand_create", "需求创建", 1),
	DEMAND_START("demand_start", "需求启动", 2),
	DEMAND_AUDIT("demand_audit", "需求评审", 3),
	DEMAND_DESIGN("demand_design", "需求设计", 4),
	DEMAND_DEVELOPMENT("demand_development", "需求开发", 5),
	DEMAND_TEST("demand_test", "需求测试", 6),
	DEMAND_CHECK_ACCEPT("demand_check_accept", "需求验收", 7),
	DEMAND_ONLINE("demand_online", "需求上线", 8);
	
	/**
	 * @Description: 更据code获取枚举
	 * @author: xiahui
	 * @date: 2018年12月13日 上午10:54:38
	 */
	public static DemandStageEnum getOrderByCode(String code) {
		DemandStageEnum[] all = DemandStageEnum.values();
		for (DemandStageEnum item : all)
		{
			if (item.getCode().equals(code))
			{
				return item;
			}
		}
		return null;
	}
	
	
	private String code;
	private String name;
	private Integer order;
	
	DemandStageEnum(String code, String name, Integer order) {
		this.code = code;
		this.name = name;
		this.order = order;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
	
	public Integer getOrder() {
		return order;
	}
}
