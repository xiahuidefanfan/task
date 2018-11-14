package com.team.tool.task.dao.system;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.team.tool.task.bean.condition.SystemMenuQueryCondition;
import com.team.tool.task.bean.model.SystemMenu;

/**
 * @ClassName: SystemMenuMapper.java
 * @Description: 系统菜单dao层
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月12日 上午10:21:45 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月12日     xiahui           v1.0.0             系统菜单dao层
 */
public interface SystemMenuMapper extends BaseMapper<SystemMenu>{

    /**
     * @Description: 获取分页菜单
     * @author xiahui
     * @date 2018年11月12日 上午10:27:15
     */
    List<Map<String, Object>> list(@Param("condition") SystemMenuQueryCondition condition);
    
    /**
     * @Description: 根据角色查询权限
     * @author xiahui
     * @date 2018年11月12日 下午10:40:56
     */
    List<Integer> getAuthoritiesByRoleId(@Param("roleId") String roleId);
    
    /**
     * @Description: 根据权限获取权限实体
     * @author xiahui
     * @date 2018年11月12日 下午10:58:53
     */
    List<SystemMenu> getAuthoritiesModelByMenuId(@Param("menuIds") List<Integer> menuIds);
}
