package com.team.tool.task.service.task.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.team.tool.task.bean.condition.task.TaskDemandQueryCondition;
import com.team.tool.task.bean.model.task.TaskDemand;
import com.team.tool.task.dao.task.TaskDemandMapper;
import com.team.tool.task.service.task.TaskDemandService;

/**
 * @ClassName: TaskDemandServiceImpl.java
 * @Description: TaskDemand-service实现层
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月3日 下午7:17:57 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年12月3日     xiahui           v1.0.0        TaskDemand-service实现层
 */
@Service
public class TaskDemandServiceImpl extends ServiceImpl<TaskDemandMapper, TaskDemand> implements TaskDemandService{

	@Override
	public List<Map<String, Object>> queryList(Page<TaskDemand> page, TaskDemandQueryCondition condition) {
		return this.baseMapper.queryList(page, condition);
	}

}
