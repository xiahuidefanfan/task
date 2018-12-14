package com.team.tool.task.service.task.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.team.tool.task.bean.condition.task.TaskMissionQueryCondition;
import com.team.tool.task.bean.model.task.TaskMission;
import com.team.tool.task.dao.task.TaskMissionMapper;
import com.team.tool.task.service.task.TaskMissionService;

/**
 * @ClassName: TaskMessionServiceImpl.java
 * @Description: TaskDemand-service实现层
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月6日 下午12:21:37 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年12月6日     xiahui           v1.0.0     TaskDemand-service实现层
 */
@Service
public class TaskMissionServiceImpl extends ServiceImpl<TaskMissionMapper, TaskMission> implements TaskMissionService{
	
	@Override
	public List<Map<String, Object>> queryList(Page<TaskMission> page, TaskMissionQueryCondition condition) {
		return this.baseMapper.queryList(page, condition);
	}
	
	@Override
	public List<Map<String, Object>> queryListByDemand(Integer demandId) {
		return this.baseMapper.queryListByDemand(demandId);
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

}
