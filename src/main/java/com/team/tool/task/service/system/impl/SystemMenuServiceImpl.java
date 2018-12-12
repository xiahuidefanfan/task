package com.team.tool.task.service.system.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.team.tool.task.bean.condition.system.SystemMenuQueryCondition;
import com.team.tool.task.bean.model.system.SystemMenu;
import com.team.tool.task.bean.node.MenuNode;
import com.team.tool.task.dao.system.SystemMenuMapper;
import com.team.tool.task.service.system.SystemMenuService;

/**
 * @ClassName: SystemMenuServiceImpl.java
 * @Description: SystemMenu-service实现层
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月15日 下午5:40:11 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月15日     xiahui           v1.0.0      SystemMenu-service实现层
 */
@Service
public class SystemMenuServiceImpl extends ServiceImpl<SystemMenuMapper, SystemMenu> implements SystemMenuService{
	
	@Override
	public List<Map<String, Object>> queryList(SystemMenuQueryCondition condition) {
		return this.baseMapper.queryList(condition);
	}
	
	@Override
	public SystemMenu queryMenuByCode(String menuCode) {
		return this.baseMapper.queryMenuByCode(menuCode);
	}
	
	@Override
	public List<Map<String, Object>> queryParentMenuList(){
		return this.baseMapper.queryParentMenuList();
	}
	
	@Override
	public List<Map<String, Object>> queryMenuListByParent(String pcode){
		return this.baseMapper.queryMenuListByParent(pcode);
	}

	@Override
	public List<MenuNode> queryMenuTree() {
		return this.baseMapper.queryMenuTree();
	}
	
	@Override
	public List<MenuNode> queryMenuTreeByRoleId(Integer roleId){
		return this.baseMapper.queryMenuTreeByRoleId(roleId);
	}

}
