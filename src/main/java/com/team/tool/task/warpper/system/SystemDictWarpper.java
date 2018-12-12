package com.team.tool.task.warpper.system;

import java.util.List;
import java.util.Map;

import com.team.tool.task.common.factory.ConstantFactory;
import com.team.tool.task.common.warpper.BaseControllerWarpper;

/**
 * @ClassName: SystemDictWarpper.java
 * @Description: 字典数据包装
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月1日 下午2:55:26 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年12月1日     xiahui           v1.0.0       菜单数据包装
 */
public class SystemDictWarpper extends BaseControllerWarpper{

	public SystemDictWarpper(Object obj) {
		super(obj);
	}

	@Override
	protected void warpTheMap(Map<String, Object> map) {
		/**
		 * 设置子菜单
		 */
		String dictCode = String.valueOf(map.get("dictCode"));
		List<Map<String, Object>> childrens = ConstantFactory.me().queryDictByParentCode(dictCode);
		map.put("childrens", childrens);
		for(Map<String, Object> children : childrens){
			dowarp(children);
		}
		dowarp(map);
	}
	
	private void dowarp(Map<String, Object> map){
		/**
		 * 创建、修改时间设置
		 */
		map.put("createTimeFormat", map.get("createTime"));
		map.put("updateTimeFormat", map.get("updateTime"));
		map.remove("createTime");
		map.remove("updateTime");
	}
}
