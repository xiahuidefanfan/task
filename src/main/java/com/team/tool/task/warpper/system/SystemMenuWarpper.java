package com.team.tool.task.warpper.system;

import java.util.List;
import java.util.Map;

import com.team.tool.task.common.warpper.BaseControllerWarpper;

/**
 * @ClassName: MenuWarpper.java
 * @Description: 菜单数据包装
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月19日 下午1:23:55 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月19日     xiahui           v1.0.0          菜单数据包装
 */
public class SystemMenuWarpper extends BaseControllerWarpper{

    public SystemMenuWarpper(List<Map<String, Object>> list) {
	        super(list);
	}
	
	@Override
	protected void warpTheMap(Map<String, Object> map) {
		
	}
	
	
}
