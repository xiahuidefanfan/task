package com.team.tool.task.dao.system;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.team.tool.task.bean.condition.system.SystemMenuQueryCondition;
import com.team.tool.task.bean.model.system.SystemMenu;
import com.team.tool.task.bean.node.MenuNode;

/**
 * @ClassName: SystemMenuMapper.java
 * @Description: 系统菜单mapper层
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月12日 上午10:21:45 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月12日     xiahui           v1.0.0          系统菜单mapper层
 */
public interface SystemMenuMapper extends BaseMapper<SystemMenu>{

    /**
     * @Description: 获取分页菜单
     * @author xiahui
     * @date 2018年11月12日 上午10:27:15
     */
    List<Map<String, Object>> queryList(@Param("condition") SystemMenuQueryCondition condition);
    
    /**
     * @Description: 根据菜单编号获取菜单实体
     * @author: xiahui
     * @date: 2018年11月27日 下午3:46:34
     */
    SystemMenu queryMenuByCode(@Param("menuCode") String menuCode);
    
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
    List<Map<String,Object>> queryMenuListByParent(@Param("pcode") String pcode);
    
    /**
     * @Description: 根据角色查询权限
     * @author xiahui
     * @date 2018年11月12日 下午10:40:56
     */
    List<Integer> queryAuthoritiesByRoleId(@Param("roleId") Integer roleId);
    
    /**
     * @Description: 根据权限获取权限实体
     * @author xiahui
     * @date 2018年11月12日 下午10:58:53
     */
    Set<SystemMenu> queryAuthoritiesModelByMenuId(@Param("menuIds") List<Integer> menuIds);
    
    /**
     * @Description: 主页面菜单树形模型，需更据用户角色过滤
     * @author xiahui
     * @date 2018年11月15日 下午8:09:20
     */
    List<MenuNode> queryMenuTreeByRoleId(@Param("roleId") Integer roleId);
    
    /**
     * @Description: 菜单树形模型
     * @author xiahui
     * @date 2018年11月15日 下午5:36:58
     */
    List<MenuNode> queryMenuTree();
}
