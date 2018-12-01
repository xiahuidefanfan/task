package com.team.tool.task.service.system.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.team.tool.task.bean.condition.system.SystemRoleQueryCondition;
import com.team.tool.task.bean.model.system.SystemRelation;
import com.team.tool.task.bean.model.system.SystemRole;
import com.team.tool.task.bean.node.RoleNode;
import com.team.tool.task.dao.system.SystemRelationMapper;
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
	
	@Autowired
    private SystemRelationMapper syatemRelationMapper;
	
	@Override
    public List<Map<String, Object>> queryList(Page<SystemRole> page, SystemRoleQueryCondition condition){
    	return this.baseMapper.queryList(page, condition);
    }
    
    @Override
    public List<RoleNode> queryRoleTree(){
    	return this.baseMapper.queryRoleTree();
    }
    
    @Override
    @Transactional(readOnly = false)
    public void setAuthority(String roleId, String ids) {
        // 删除该角色所有的权限
        this.baseMapper.deleteRolesById(roleId);

        // 添加新的权限
        String[] idArr = ids.split(",");
        for (String id : idArr) {
        	SystemRelation relation = new SystemRelation();
            relation.setRoleId(Integer.valueOf(roleId));
            relation.setMenuId(Integer.valueOf(id));
            this.syatemRelationMapper.insert(relation);
        }
    }
}
