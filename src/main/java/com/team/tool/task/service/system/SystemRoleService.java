package com.team.tool.task.service.system;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.team.tool.task.bean.condition.system.SystemRoleQueryCondition;
import com.team.tool.task.bean.model.system.SystemRole;
import com.team.tool.task.bean.node.RoleNode;

/**
 * @ClassName: SystemRoleService.java
 * @Description: SystemRole-service层
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月28日 下午6:00:05 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月28日     xiahui           v1.0.0       SystemRole-service层
 */
public interface SystemRoleService extends IService<SystemRole>{
    /**
     * @Description: 获取分页角色
     * @author xiahui
     * @date 2018年11月12日 下午10:04:37
     */
    List<Map<String, Object>> queryList(Page<SystemRole> page, SystemRoleQueryCondition condition);
    
    /**
     * @Description: 角色树形模型
     * @author xiahui
     * @date 2018年11月29日 下午4:54:58
     */
    List<RoleNode> queryRoleTree();
    
    /**
     * @Description: 设置某个角色的权限
     * @author: xiahui
     * @date: 2018年12月1日 下午2:11:29
     */
    void setAuthority(String roleId, String ids);
}
