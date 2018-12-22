package com.team.tool.task.service.workflow.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.team.tool.task.bean.condition.workflow.WorkflowNodeQueryCondition;
import com.team.tool.task.bean.model.workflow.WorkflowNode;
import com.team.tool.task.dao.workflow.WorkflowNodeMapper;
import com.team.tool.task.service.workflow.WorkflowNodeService;

/**
 * @ClassName: WorkflowNodeServiceImpl.java
 * @Description: 工作流节点service实现
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月14日 下午7:38:54 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年12月14日     xiahui           v1.0.0        工作流节点service实现
 */
@Service
public class WorkflowNodeServiceImpl extends ServiceImpl<WorkflowNodeMapper, WorkflowNode> implements WorkflowNodeService{

	@Override
	public List<Map<String, Object>> queryList(Page<WorkflowNode> page, WorkflowNodeQueryCondition condition) {
		return this.baseMapper.queryList(page, condition);
	}
	
	@Override
	public List<Map<String, Object>> queryListByProcdefId(String procdefId) {
		return this.baseMapper.queryListByProcdefId(procdefId);
	}
}
