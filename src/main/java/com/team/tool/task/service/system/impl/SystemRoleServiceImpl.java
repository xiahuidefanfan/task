package com.team.tool.task.service.system.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.team.tool.task.bean.condition.system.SystemRoleQueryCondition;
import com.team.tool.task.bean.model.system.SystemRole;
import com.team.tool.task.bean.node.RoleNode;
import com.team.tool.task.dao.system.SystemRoleMapper;
import com.team.tool.task.service.system.SystemRoleService;

/**
 * @ClassName: SystemRoleServiceImpl.java
 * @Description: SystemRole-service实现层
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月28日 下午6:01:58 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月28日     xiahui           v1.0.0      SystemRole-service实现层
 */
@Service
public class SystemRoleServiceImpl extends ServiceImpl<SystemRoleMapper, SystemRole> implements SystemRoleService{
	
	/**
     * @Description: 获取分页角色
     * @author xiahui
     * @date 2018年11月29日 上午09:51:37
     */
    public List<Map<String, Object>> queryList(Page<SystemRole> page, SystemRoleQueryCondition condition){
    	return this.baseMapper.queryList(page, condition);
    }
    
    /**
     * @Description: 角色树形模型
     * @author xiahui
     * @date 2018年11月29日 下午4:54:58
     */
    public List<RoleNode> queryRoleTree(){
    	return this.baseMapper.queryRoleTree();
    }
}
