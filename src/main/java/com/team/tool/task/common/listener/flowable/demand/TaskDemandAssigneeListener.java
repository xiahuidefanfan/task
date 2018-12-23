package com.team.tool.task.common.listener.flowable.demand;

import org.flowable.engine.delegate.TaskListener;
import org.flowable.task.service.delegate.DelegateTask;

import com.team.tool.task.common.support.SecuritySupport;
import com.team.tool.task.common.util.ToolUtil;

/**
 * @ClassName: TaskDemandAssigneeListener.java
 * @Description: 需求处理人监听器
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月23日 下午2:00:10 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年12月23日     xiahui           v1.0.0            需求处理人监听器
 */
public class TaskDemandAssigneeListener implements TaskListener{

	private static final long serialVersionUID = 1L;

	@Override
	public void notify(DelegateTask delegateTask) {
		if(ToolUtil.isEmpty(delegateTask.getAssignee())){
			String owner = delegateTask.getOwner();
			// 如果任务处理人不存在，则取当前登录用户作为任务处理人
			String assignee = ToolUtil.isEmpty(owner) ? String.valueOf(
					SecuritySupport.getSecurityUser().getUserId()) : owner;
			delegateTask.setAssignee(assignee);
 		}
	}

}
