package com.team.tool.task.warpper.system;

import java.util.List;
import java.util.Map;

import com.team.tool.task.common.enums.DictMenuEnum;
import com.team.tool.task.common.factory.ConstantFactory;
import com.team.tool.task.common.util.DictUtil;
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
 * 2018年11月19日     xiahui           v1.0.0        菜单数据包装
 */
public class SystemMenuWarpper extends BaseControllerWarpper{
	
	/**
	 * 菜单启用状态
	 */
	private static final String ENABLE = "1";
	
    public SystemMenuWarpper(List<Map<String, Object>> list) {
        super(list);
	}
	
	@Override
	protected void warpTheMap(Map<String, Object> map) {
		
		dowarp(map);
		/**
		 * 设置子菜单
		 */
		String menuPcode = String.valueOf(map.get("menuCode"));
		List<Map<String, Object>> childrens = ConstantFactory.me().queryMenuListByParent(menuPcode);
		for(Map<String, Object> children : childrens){
			dowarp(children);
		}
		map.put("childrens", childrens);
	}
	
	private void dowarp(Map<String, Object> map){
		/**
		 * 设置字典名称
		 */
		String menuStatus = String.valueOf(map.get("menuStatus"));
		String menuStatusName = DictUtil.getChildDictName(ConstantFactory.me().queryAllDicts(), DictMenuEnum.SYS_STATE.getCode(), 
				menuStatus);
		map.put("menuStatusName", menuStatusName);
		String changeStatusName = ENABLE.equals(menuStatus) ? "禁用" : "启用";
		map.put("changeStatusName", changeStatusName);
		String isMenuName = DictUtil.getChildDictName(ConstantFactory.me().queryAllDicts(), DictMenuEnum.IS_MENU.getCode(), 
				map.get("menuIsMenu").toString());
		map.put("isMenuName", isMenuName);
		
		/**
		 * 创建、修改时间设置
		 */
		map.put("createTimeFormat", map.get("createTime"));
		map.put("updateTimeFormat", map.get("updateTime"));
		map.remove("createTime");
		map.remove("updateTime");
	}
	
}
