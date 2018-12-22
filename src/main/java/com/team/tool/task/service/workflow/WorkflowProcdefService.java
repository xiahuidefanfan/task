package com.team.tool.task.service.workflow;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.plugins.Page;
import com.team.tool.task.bean.condition.workflow.WorkflowProcdefQueryCondition;
import com.team.tool.task.bean.model.workflow.WorkflowProcdef;

/**
 * @ClassName: WorkflowNodeService.java
 * @Description: 流程service
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月19日 下午2:12:19 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年12月19日     xiahui           v1.0.0       流程service
 */
public interface WorkflowProcdefService {
	
	/**
	 * @Description: 根据条件查询流程	
	 * @author: xiahui
	 * @date: 2018年12月19日 下午2:14:30
	 */
    List<Map<String, Object>> queryList(@Param("page")Page<WorkflowProcdef> page, @Param("condition")WorkflowProcdefQueryCondition condition);
}
