package com.team.tool.task.controller.workflow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.tool.task.common.support.RespData;
import com.team.tool.task.service.workflow.WorkflowService;

import io.swagger.annotations.ApiOperation;

/**
 * @ClassName: WorkFlowController.java
 * @Description: 工作流控制器
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月13日 下午3:35:44 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年12月6日     xiahui           v1.0.0             工作流控制器
 */
@RestController
@RequestMapping("/workflow")
public class WorkflowController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WorkflowController.class);

	@Autowired
	private WorkflowService workflowService;
	
	/**
	 * @Description: 部署任务流程
	 * @author: xiahui
	 * @date: 2018年12月13日 下午3:37:47
	 */
	@GetMapping(value = "/deployMission.action")
	@ApiOperation(value = "部署任务流程")
	public RespData deployMission() {
		workflowService.deploy("processes/mission.bpmn20.xml", "任务流程");
		LOGGER.info("部署任务流程成功！");
		return RespData.getRespData(true, null, "部署任务流程成功！");
	}
	
}
