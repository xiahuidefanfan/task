package com.team.tool.task.service.system;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.team.tool.task.bean.condition.system.SystemMenuQueryCondition;
import com.team.tool.task.bean.model.system.SystemMenu;
import com.team.tool.task.bean.node.MenuNode;

/**
 * @ClassName: SystemMenuService.java
 * @Description: SystemMenu-service层
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月15日 下午5:38:43 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月15日     xiahui           v1.0.0        SystemMenu-service层
 */
public interface SystemMenuService extends IService<SystemMenu>{
	
	/**
     * @Description: 根据条件查询菜单
     * @author xiahui
     * @date 2018年11月16日 下午16:37:15
     */
    List<Map<String, Object>> queryList(SystemMenuQueryCondition condition);
    
    /**
     * @Description: 根据菜单编号获取菜单实体
     * @author: xiahui
     * @date: 2018年11月27日 下午3:46:34
     */
    SystemMenu queryMenuByCode(String menuCode);
    
    /**
     * @Description: 查询父级菜单列表 
     * @author xiahui
     * @date 2018年11月19日 下午1:11:10
     */
    List<Map<String, Object>> queryParentMenuList();
    
    /**
     * @Description: 根据父级菜单查询子菜单列表
     * @author xiahui
     * @date 2018年11月19日 下午1:46:53
     */
    List<Map<String, Object>> queryMenuListByParent(String pcode);

	/**
     * @Description: 主页面菜单树形模型
     * @author xiahui
     * @date 2018年11月15日 下午5:36:58
     */
    List<MenuNode> queryMenuTree();
    
    /**
     * @Description: 主页面菜单树形模型，需更据用户角色过滤
     * @author xiahui
     * @date 2018年11月15日 下午8:09:20
     */
    List<MenuNode> queryMenuTreeByRoleId(Integer roleId);
}
