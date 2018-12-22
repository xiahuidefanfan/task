package com.team.tool.task.controller.workflow;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.plugins.Page;
import com.team.tool.task.bean.condition.workflow.WorkflowProcdefQueryCondition;
import com.team.tool.task.bean.model.workflow.WorkflowProcdef;
import com.team.tool.task.common.support.RespData;
import com.team.tool.task.service.workflow.WorkflowProcdefService;
import com.team.tool.task.warpper.workflow.WorkflowProcdefWarpper;

import io.swagger.annotations.ApiOperation;

/**
 * @ClassName: WorkflowProcdefController.java
 * @Description: 流程控制器
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月19日 下午2:47:59 
 *
 * Modification History:
 * Date         Author          Version            Description
 *------------------------------------------------------------*
 * 2018年12月19日     xiahui           v1.0.0         	  流程控制器
 */
@RestController
@RequestMapping("/workflowProcdef")
public class WorkflowProcdefController {

	@Autowired
	private WorkflowProcdefService workflowProcdefService;
	
	/**
	 * @Description: 查询流程列表
	 * @author: xiahui
	 * @date: 2018年12月19日 下午2:45:47
	 */
	@PostMapping(value = "/list.action")
    @ApiOperation(value = "流程列表查询")
	public RespData list(WorkflowProcdefQueryCondition condition) {
		Page<WorkflowProcdef> page = new Page<WorkflowProcdef>(condition.getPageNumber(), condition.getPageSize());
        List<Map<String, Object>> list = this.workflowProcdefService.queryList(page, condition);
        return RespData.getRespData(true, new WorkflowProcdefWarpper(list).warp(), "", page.getTotal());
	}
	
}
