package com.team.tool.task.service.task.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.flowable.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.team.tool.task.bean.condition.task.TaskDemandQueryCondition;
import com.team.tool.task.bean.model.task.TaskDemand;
import com.team.tool.task.common.constants.CommonConstans;
import com.team.tool.task.dao.task.TaskDemandMapper;
import com.team.tool.task.service.task.TaskDemandService;
import com.team.tool.task.service.workflow.WorkflowService;

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

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskDemandServiceImpl.class);
	
	@Autowired
	private WorkflowService workflowService;
	
	@Override
	public List<Map<String, Object>> queryList(Page<TaskDemand> page, TaskDemandQueryCondition condition) {
		return this.baseMapper.queryList(page, condition);
	}

	@Override
	public void execute(TaskDemand taskDemand) {
		LOGGER.info("添加" + taskDemand.getDemandDesc() + "需求流程开始！");
        
        //启动流程
        HashMap<String, Object> map = new HashMap<>(CommonConstans.DEFAULT_MAP_SIZE);
        map.put("taskUser", ShiroKit.getUser().getId());
        map.put("money", expense.getMoney());
        ProcessInstance processInstance = workFlowService.startProcessInstance("Expense",null, map);
        
        //保存业务数据
        expense.setUserId(ShiroKit.getUser().getId());
        expense.setState(FlowableState.SUBMITING.getCode());
        expense.setProcessId(processInstance.getId());
        this.insert(expense);
        LOGGER.info("添加报销流程成功！流程实例id：" + expense.getProcessId());
	}

}
