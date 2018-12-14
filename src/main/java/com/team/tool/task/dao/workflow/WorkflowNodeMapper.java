package com.team.tool.task.dao.workflow;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.team.tool.task.bean.condition.workflow.WorkflowNodeQueryCondition;
import com.team.tool.task.bean.model.workflow.WorkflowNode;

/**
 * @ClassName: WorkFlowNodeMapper.java
 * @Description: 节点mapper层
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月14日 下午7:24:54 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年12月14日     xiahui           v1.0.0          节点mapper层
 */
public interface WorkflowNodeMapper extends BaseMapper<WorkflowNode>{
	
	/**
	 * @Description: 根据条件查询任务	
	 * @author: xiahui
	 * @date: 2018年12月14日 下午12:25:30
	 */
    List<Map<String, Object>> queryList(@Param("page")Page<WorkflowNode> page, @Param("condition")WorkflowNodeQueryCondition condition);
}
