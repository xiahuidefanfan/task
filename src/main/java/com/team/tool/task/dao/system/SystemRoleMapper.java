package com.team.tool.task.dao.system;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.team.tool.task.bean.condition.system.SystemRoleQueryCondition;
import com.team.tool.task.bean.model.system.SystemRole;
import com.team.tool.task.bean.node.RoleNode;

/**
 * @ClassName: SystemRoleMapper.java
 * @Description: 系统角色dao层
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月12日 下午10:33:29 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月12日     xiahui           v1.0.0               修改原因
 */
public interface SystemRoleMapper extends BaseMapper<SystemRole>{

    /**
     * @Description: 获取分页角色
     * @author xiahui
     * @date 2018年11月28日 下午05:04:37
     */
    List<Map<String, Object>> queryList(@Param("page")Page<SystemRole> page, @Param("condition") SystemRoleQueryCondition condition);
    
    /**
     * @Description: 角色树形模型
     * @author xiahui
     * @date 2018年11月29日 下午4:54:58
     */
    List<RoleNode> queryRoleTree();
    
}
