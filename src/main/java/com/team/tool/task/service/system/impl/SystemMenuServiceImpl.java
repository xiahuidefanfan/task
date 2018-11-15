package com.team.tool.task.service.system.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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
	public List<MenuNode> getMenuTree() {
		return this.baseMapper.getMenuTree();
	}
	
	@Override
	public List<MenuNode> getMenuTreeByRoleId(@Param("roleId") Integer roleId){
		return this.baseMapper.getMenuTreeByRoleId(roleId);
	}

}
