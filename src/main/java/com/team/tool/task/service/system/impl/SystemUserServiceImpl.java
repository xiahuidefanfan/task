package com.team.tool.task.service.system.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.team.tool.task.bean.condition.system.SystemUserQueryCondition;
import com.team.tool.task.bean.model.system.SystemUser;
import com.team.tool.task.dao.system.SystemUserMapper;
import com.team.tool.task.service.system.SystemUserService;

/**
 * @ClassName: SystemUserServiceImpl.java
 * @Description: SystemUser-service实现层
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月12日 上午10:22:39 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月12日     xiahui           v1.0.0            项目新建
 */
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser> implements SystemUserService{

	@Override
	public List<Map<String, Object>> queryList(SystemUserQueryCondition condition) {
		return this.baseMapper.queryList(condition);
	}

	@Override
	public SystemUser queryUserByUserName(String username) {
		return this.baseMapper.queryUserByUserName(username);
	}

	@Override
	public List<Map<String, Object>> queryByRole(String roleCode) {
		return this.baseMapper.queryByRole(roleCode);
	}
}
