package com.team.tool.task.controller.task;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.plugins.Page;
import com.mumu.core.exception.MumuException;
import com.mumu.core.util.ToolUtil;
import com.team.tool.task.bean.condition.task.TaskDemandQueryCondition;
import com.team.tool.task.bean.dto.security.SecurityUser;
import com.team.tool.task.bean.model.task.TaskDemand;
import com.team.tool.task.common.enums.system.DemandStageEnum;
import com.team.tool.task.common.support.RespData;
import com.team.tool.task.common.support.SecuritySupport;
import com.team.tool.task.service.task.TaskDemandService;
import com.team.tool.task.service.workflow.WorkflowService;
import com.team.tool.task.warpper.task.TaskDemandWarpper;

import io.swagger.annotations.ApiOperation;

/**
 * @ClassName: DemandController.java
 * @Description: 需求控制器
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月3日 下午7:06:51 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年12月3日     xiahui           v1.0.0            需求控制器
 */
@RestController
@RequestMapping("/demand")
public class DemandController {
	
	@Autowired
	private TaskDemandService taskDemandService;
	
	/**
	 * @Description: 查询需求列表
	 * @author: xiahui
	 * @date: 2018年12月3日 下午7:27:47
	 */
    @SuppressWarnings("unchecked")
	@PostMapping(value = "/list.action")
    @ApiOperation(value = "需求列表查询")
    public RespData list(TaskDemandQueryCondition condition) {
        Page<TaskDemand> page = new Page<TaskDemand>(condition.getPageNumber(), condition.getPageSize());
        List<Map<String, Object>> demandList = this.taskDemandService.queryList(page, condition);
        page.setRecords((List<TaskDemand>) new TaskDemandWarpper(demandList).warp());
        return RespData.getRespData(true, page.getRecords(), "", page.getTotal());
    }

    /**
     * @Description: 添加需求
     * @author: xiahui
     * @date: 2018年12月3日 下午7:29:15
     */
    @PostMapping(value = "/add.action")
    @ApiOperation(value = "添加需求")
    public RespData add(@Valid TaskDemand demand, BindingResult bindingResult) {
    	/**
    	 * 设置需求基础信息
    	 */
    	SecurityUser securityUser = SecuritySupport.getSecurityUser();
    	demand.setCreator(securityUser.getUserId());
    	demand.setUpdator(securityUser.getUserId());
    	demand.setCreateTime(new Timestamp(System.currentTimeMillis()));
    	demand.setUpdateTime(new Timestamp(System.currentTimeMillis()));
    	
    	/**
    	 * 保存需求信息
    	 */
    	demand.setDemandOriginator(securityUser.getUserId());
    	demand.setDemandStage(DemandStageEnum.DEMAND_CREATE.getCode());
    	demand.insert();
        return RespData.getRespData(true, null, "添加需求成功！");
    }
    
    /**
     * @Description: 启动需求
     * @author: xiahui
     * @date: 2018年12月22日 下午4:29:15
     */
    @RequestMapping(value = "/execute")
    @ResponseBody
    public RespData execute(@RequestParam String processId) {
        if (ToolUtil.isEmpty(processId)) {
            throw new MumuException(BizExceptionEnum.REQUEST_NULL);
        }
      expenseService.execute(processId);
        return RespData.getRespData(HttpStatus.OK.value(), "", "提交报销申请成功！");
    }
    
}
