package com.team.tool.task.service.workflow.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.team.tool.task.bean.condition.workflow.WorkflowProcdefQueryCondition;
import com.team.tool.task.bean.model.workflow.WorkflowProcdef;
import com.team.tool.task.dao.workflow.WorkflowProcdefMapper;
import com.team.tool.task.service.workflow.WorkflowProcdefService;

/**
 * @ClassName: WorkflowProcdefServiceImpl.java
 * @Description: 流程管理service实现
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月21日 下午3:46:54 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年12月21日     xiahui           v1.0.0        流程管理service实现
 */
@Service
public class WorkflowProcdefServiceImpl extends ServiceImpl<WorkflowProcdefMapper, WorkflowProcdef> implements WorkflowProcdefService {

	@Override
	public List<Map<String, Object>> queryList(Page<WorkflowProcdef> page, WorkflowProcdefQueryCondition condition) {
		return this.baseMapper.queryList(page, condition);
	}

}
