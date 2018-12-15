package com.team.tool.task.controller.workflow;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.plugins.Page;
import com.team.tool.task.bean.condition.workflow.WorkflowNodeQueryCondition;
import com.team.tool.task.bean.dto.security.SecurityUser;
import com.team.tool.task.bean.model.workflow.WorkflowNode;
import com.team.tool.task.common.support.RespData;
import com.team.tool.task.common.support.SecuritySupport;
import com.team.tool.task.service.workflow.WorkflowNodeService;
import com.team.tool.task.warpper.workflow.WorkflowNodeWarpper;

import io.swagger.annotations.ApiOperation;

/**
 * @ClassName: WorkflowNodeController.java
 * @Description: 工作流节点控制器
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月14日 下午7:47:59 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年12月14日     xiahui           v1.0.0         工作流节点控制器
 */
@RestController
@RequestMapping("/workflowNode")
public class WorkflowNodeController {
	
	@Autowired
	private WorkflowNodeService workflowNodeService;
	
	/**
	 * @Description: 查询节点列表
	 * @author: xiahui
	 * @date: 2018年12月14日 下午7:54:47
	 */
	@SuppressWarnings("unchecked")
	@PostMapping(value = "/list.action")
    @ApiOperation(value = "需求列表查询")
	public RespData list(WorkflowNodeQueryCondition condition) {
		Page<WorkflowNode> page = new Page<WorkflowNode>(condition.getPageNumber(), condition.getPageSize());
        List<Map<String, Object>> list = this.workflowNodeService.queryList(page, condition);
        page.setRecords((List<WorkflowNode>) new WorkflowNodeWarpper(list).warp());
        return RespData.getRespData(true, page.getRecords(), "", page.getTotal());
	}
	
	   /**
     * @Description: 添加节点
     * @author: xiahui
     * @date: 2018年12月15日 上午10:29:00
     */
    @PostMapping(value = "/add.action")
    @ApiOperation(value = "添加节点")
    public RespData add(@Valid WorkflowNode node, BindingResult bindingResult) {
    	/**
    	 * 设置节点基础信息
    	 */
    	SecurityUser securityUser = SecuritySupport.getSecurityUser();
    	node.setCreator(securityUser.getUserId());
    	node.setUpdator(securityUser.getUserId());
    	node.setCreateTime(new Timestamp(System.currentTimeMillis()));
    	node.setUpdateTime(new Timestamp(System.currentTimeMillis()));
    	
    	/**
    	 * 保存节点信息
    	 */
    	node.insert();
        return RespData.getRespData(true, null, "添加节点成功！");
    }
    
    /**
     * @Description: 修改节点
     * @author: xiahui
     * @date: 2018年12月15日 上午10:33:00
     */
    @PutMapping(value = "/update.action")
    @ApiOperation(value = "修改节点")
    public RespData update(@Valid WorkflowNode node, BindingResult bindingResult) {
    	/**
    	 * 设置节点基础信息
    	 */
    	SecurityUser securityUser = SecuritySupport.getSecurityUser();
    	node.setUpdator(securityUser.getUserId());
    	
    	/**
    	 * 保存节点信息
    	 */
    	node.updateById();
        return RespData.getRespData(true, null, "修改节点成功！");
    }
}
