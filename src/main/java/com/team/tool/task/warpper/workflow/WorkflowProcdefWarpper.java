package com.team.tool.task.warpper.workflow;

import java.util.List;
import java.util.Map;

import com.team.tool.task.common.factory.ConstantFactory;
import com.team.tool.task.common.warpper.BaseControllerWarpper;

/**
 * @ClassName: WorkflowNodeWarpper.java
 * @Description: 流程定义包装
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月21日 下午3:51:32 
 *
 * Modification History:
 * Date         Author          Version             Description
 *-------------------------------------------------------------*
 * 2018年12月21日     xiahui           v1.0.0            流程定义包装
 */
public class WorkflowProcdefWarpper extends BaseControllerWarpper{

	public WorkflowProcdefWarpper(List<Map<String, Object>> list) {
        super(list);
	}
	
	@Override
	protected void warpTheMap(Map<String, Object> map) {
		/**
		 * 设置该流程下的节点信息
		 */
		String procdefId = String.valueOf(map.get("procdefId"));
		List<Map<String, Object>> childrens = ConstantFactory.me().queryListByProcdefId(procdefId);
		map.put("childrens", new WorkflowNodeWarpper(childrens).warp());
	} 
	
}
