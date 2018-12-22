package com.team.tool.task.service.workflow;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.team.tool.task.bean.condition.workflow.WorkflowNodeQueryCondition;
import com.team.tool.task.bean.model.workflow.WorkflowNode;

/**
 * @ClassName: WorkflowNodeService.java
 * @Description: 工作流节点service
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月14日 下午7:36:19 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年12月14日     xiahui           v1.0.0       工作流节点service
 */
public interface WorkflowNodeService extends IService<WorkflowNode>{
	
	/**
	 * @Description: 根据条件查询任务	
	 * @author: xiahui
	 * @date: 2018年12月14日 下午12:25:30
	 */
    List<Map<String, Object>> queryList(@Param("page")Page<WorkflowNode> page, @Param("condition")WorkflowNodeQueryCondition condition);
    
    /**
	 * @Description: 根据流程id查询节点
	 * @author: xiahui
	 * @date: 2018年12月21日 下午4:05:30
	 */
    List<Map<String, Object>> queryListByProcdefId(String procdefId);
}
