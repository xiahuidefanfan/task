/**
 * 
 */
package com.team.tool.task.controller.system;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.plugins.Page;
import com.team.tool.task.bean.condition.system.SystemRoleQueryCondition;
import com.team.tool.task.bean.model.system.SystemRole;
import com.team.tool.task.bean.node.RoleNode;
import com.team.tool.task.common.support.RespData;
import com.team.tool.task.common.support.SecuritySupport;
import com.team.tool.task.service.system.SystemRoleService;
import com.team.tool.task.warpper.system.SystemRoleWarpper;

import io.swagger.annotations.ApiOperation;

/**
 * @ClassName: RoleController.java
 * @Description: 角色控制器
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月12日 下午10:10:45 
 *
 * Modification History:
 * Date         Author          Version            Description
 *------------------------------------------------------------*
 * 2018年11月12日     xiahui           v1.0.0       角色控制器
 */
@RestController
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private SystemRoleService systemRoleService;
	
	/**
	 * @Description: 查询角色列表
	 * @author xiahui
	 * @date 2018年11月16日 下午4:30:31
	 */
    @SuppressWarnings("unchecked")
	@PostMapping(value = "/list.action")
    @ApiOperation(value = "角色列表查询")
    public RespData list(SystemRoleQueryCondition condition) {
        Page<SystemRole> page = new Page<SystemRole>(condition.getPageNumber(), condition.getPageSize());
        List<Map<String, Object>> roleList = this.systemRoleService.queryList(page, condition);
        page.setRecords((List<SystemRole>) new SystemRoleWarpper(roleList).warp());
        return RespData.getRespData(true, page.getRecords(), "", page.getTotal());
    }
    
    /**
	 * @Description: 查询角色树
	 * @author xiahui
	 * @date 2018年11月16日 下午4:30:31
	 */
    @SuppressWarnings("unchecked")
	@GetMapping(value = "/queryRoleTree.action")
    @ApiOperation(value = " 查询角色树")
    public RespData queryRoleTree() {
    	List<RoleNode> nodeList = this.systemRoleService.queryRoleTree();
    	List<RoleNode> roleTree = (List<RoleNode>) RoleNode.buildTree(nodeList);
        return RespData.getRespData(true, roleTree, "");
    }
    
    /**
  	 * @Description: 修改角色
  	 * @author xiahui
  	 * @date 2018年11月30日 下午15:55:31
  	 */
  	@PutMapping(value = "/update.action")
  	@ApiOperation(value = "修改角色")
  	public RespData update(@Valid SystemRole role, BindingResult bindingResult) {
  		role.setUpdator(SecuritySupport.getSecurityUser().getUserId());
  		role.updateById();
  		return RespData.getRespData(true, null, "修改角色成功！");
      }
}
