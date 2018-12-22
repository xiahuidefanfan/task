package com.team.tool.task.dao.workflow;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.team.tool.task.bean.condition.workflow.WorkflowProcdefQueryCondition;
import com.team.tool.task.bean.model.workflow.WorkflowProcdef;

/**
 * @ClassName: WorkflowProcdefMapper.java
 * @Description: 流程mapper层
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月19日 下午2:04:54 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年12月19日     xiahui           v1.0.0          流程mapper层
 */
public interface WorkflowProcdefMapper extends BaseMapper<WorkflowProcdef>{

	/**
	 * @Description: 根据条件查询流程
	 * @author: xiahui
	 * @date: 2018年12月19日 下午2:27:30
	 */
    List<Map<String, Object>> queryList(@Param("page")Page<WorkflowProcdef> page, @Param("condition")WorkflowProcdefQueryCondition condition);
}
