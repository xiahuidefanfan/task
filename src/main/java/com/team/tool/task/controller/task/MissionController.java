package com.team.tool.task.controller.task;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.plugins.Page;
import com.team.tool.task.bean.condition.task.TaskMissionQueryCondition;
import com.team.tool.task.bean.dto.security.SecurityUser;
import com.team.tool.task.bean.model.task.TaskMission;
import com.team.tool.task.common.enums.MissionStageEnum;
import com.team.tool.task.common.support.RespData;
import com.team.tool.task.common.support.SecuritySupport;
import com.team.tool.task.service.task.TaskMissionService;
import com.team.tool.task.service.workflow.WorkflowService;
import com.team.tool.task.warpper.task.TaskMissionWarpper;

import io.swagger.annotations.ApiOperation;

/**
 * @ClassName: MissionController.java
 * @Description: 任务控制器
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月6日 下午12:59:44 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年12月6日     xiahui           v1.0.0           任务控制器
 */
@RestController
@RequestMapping("/mission")
public class MissionController {
	
	@Autowired
	private TaskMissionService taskMissionService;
	
	@Autowired
	private WorkflowService workflowService;
	
	/**
	 * @Description: 查询任务列表
	 * @author: xiahui
	 * @date: 2018年12月6日 下午3:34:47
	 */
    @SuppressWarnings("unchecked")
	@PostMapping(value = "/list.action")
    @ApiOperation(value = "任务列表查询")
    public RespData list(TaskMissionQueryCondition condition) {
        Page<TaskMission> page = new Page<TaskMission>(condition.getPageNumber(), condition.getPageSize());
        List<Map<String, Object>> missionList = this.taskMissionService.queryList(page, condition);
        page.setRecords((List<TaskMission>) new TaskMissionWarpper(missionList).warp());
        return RespData.getRespData(true, page.getRecords(), "", page.getTotal());
    }

    
    /**
     * @Description: 添加任务
     * @author: xiahui
     * @date: 2018年12月6日 下午3:35:47
     */
    @PostMapping(value = "/add.action")
    @ApiOperation(value = "添加任务")
    public RespData add(@Valid TaskMission mission, BindingResult bindingResult) {
    	/**
    	 * 设置任务基础信息
    	 */
    	SecurityUser securityUser = SecuritySupport.getSecurityUser();
    	mission.setCreator(securityUser.getUserId());
    	mission.setUpdator(securityUser.getUserId());
    	mission.setCreateTime(new Timestamp(System.currentTimeMillis()));
    	mission.setUpdateTime(new Timestamp(System.currentTimeMillis()));
    	mission.setMissionStage(MissionStageEnum.MISSION_CREATED.getCode());
    	
    	/**
    	 * 保存任务信息
    	 */
    	mission.insert();
        return RespData.getRespData(true, null, "添加任务成功！");
    }
    
    /**
     * @Description: 修改任务
     * @author: xiahui
     * @date: 2018年12月6日 下午3:37:34
     */
    @PutMapping(value = "/update.action")
    @ApiOperation(value = "修改任务")
    public RespData update(@Valid TaskMission mission, BindingResult bindingResult) {
    	/**
    	 * 设置任务基础信息
    	 */
    	SecurityUser securityUser = SecuritySupport.getSecurityUser();
    	mission.setUpdator(securityUser.getUserId());
    	
    	/**
    	 * 保存任务信息
    	 */
    	mission.updateById();
        return RespData.getRespData(true, null, "修改任务成功！");
    }
    
    /**
  	 * 启动任务流程
  	 */
  	@PostMapping(value = "/start.action")
  	@ApiOperation(value = "启动任务流程")
  	public RespData start() {
  		Map<String, Object> variables = new HashMap<String, Object>();
  		variables.put("userId", "lkp");
  		workflowService.startProcessInstance("material", "0925Test2", variables);
  		return RespData.getRespData(true, null, "启动任务流程成功！");
  	}

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    
}
