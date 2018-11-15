package com.team.tool.task.service.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.service.IService;
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
     * @Description: 主页面菜单树形模型
     * @author xiahui
     * @date 2018年11月15日 下午5:36:58
     */
    List<MenuNode> getMenuTree();
    
    /**
     * @Description: 主页面菜单树形模型，需更据用户角色过滤
     * @author xiahui
     * @date 2018年11月15日 下午8:09:20
     */
    List<MenuNode> getMenuTreeByRoleId(@Param("roleId") Integer roleId);
}
