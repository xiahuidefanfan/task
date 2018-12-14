package com.team.tool.task.warpper.workflow;

import java.util.List;
import java.util.Map;

import com.team.tool.task.common.warpper.BaseControllerWarpper;

/**
 * @ClassName: WorkflowNodeWarpper.java
 * @Description: 工作流节点包装
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月14日 下午7:56:32 
 *
 * Modification History:
 * Date         Author          Version             Description
 *-------------------------------------------------------------*
 * 2018年12月14日     xiahui           v1.0.0          工作流节点包装
 */
public class WorkflowNodeWarpper extends BaseControllerWarpper{

	public WorkflowNodeWarpper(List<Map<String, Object>> list) {
        super(list);
	}
	
	@Override
	protected void warpTheMap(Map<String, Object> map) {
		
	}
	
}
