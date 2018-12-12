/**
 * 
 */
package com.team.tool.task.controller.system;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.plugins.Page;
import com.team.tool.task.bean.condition.system.SystemRoleQueryCondition;
import com.team.tool.task.bean.dto.security.SecurityUser;
import com.team.tool.task.bean.model.system.SystemRole;
import com.team.tool.task.bean.node.RoleNode;
import com.team.tool.task.common.enums.ErrorCodeEnum;
import com.team.tool.task.common.support.RespData;
import com.team.tool.task.common.support.SecuritySupport;
import com.team.tool.task.common.util.StringUtil;
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
 * 2018年11月12日     xiahui           v1.0.0           角色控制器
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
	 * @Description: 添加角色
	 * @author xiahui
	 * @date 2018年12月01日 上午11:05:31
	 */
    @PostMapping(value = "/add.action")
    @ApiOperation(value = "添加角色")
    public RespData add(@Valid SystemRole role, BindingResult bindingResult) {
    	/**
    	 * 设置角色基础信息
    	 */
    	SecurityUser securityUser = SecuritySupport.getSecurityUser();
    	role.setCreator(securityUser.getUserId());
    	role.setUpdator(securityUser.getUserId());
    	role.setCreateTime(new Timestamp(System.currentTimeMillis()));
    	role.setUpdateTime(new Timestamp(System.currentTimeMillis()));
    	
    	/**
    	 * 保存角色信息
    	 */
    	role.insert();
        return RespData.getRespData(true, null, "添加角色成功！");
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
    
    /**
  	 * @Description: 删除角色
  	 * @author xiahui
  	 * @date 2018年12月01日 上午11:12:31
  	 */
  	@DeleteMapping(value = "/del.action")
  	@ApiOperation(value = "删除角色")
  	public RespData del(@RequestParam Integer roleId) {
  		systemRoleService.deleteById(roleId);
  		return RespData.getRespData(true, null, "删除角色成功！");
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
     * @Description: 配置权限
     * @author: xiahui
     * @date: 2018年12月1日 下午2:06:00
     */
    @PostMapping("/setAuthority.action")
    @ApiOperation(value = "配置权限")
    public RespData setAuthority(AuthorityBody body) {
    	Assert.isTrue(null != body, StringUtil.parseString(ErrorCodeEnum.CHECK_ERROR.msg(), "配置权限", "授权信息不可为空！"));
        this.systemRoleService.setAuthority(String.valueOf(body.getRoleId()), body.getIds());
        return RespData.getRespData(true, null, "配置权限成功！");
    }
    
    /**
     * @ClassName: RoleController.java
     * @Description: 权限配置入参封装
     *
     * @version: v1.0.0
     * @author: xiahui
     * @date: 2018年12月1日 下午2:10:36 
     *
     * Modification History:
     * Date         Author          Version            Description
     *-------------------------------------------------------------*
     * 2018年12月1日     xiahui           v1.0.0       权限配置入参封装
     */
     static class AuthorityBody{
        private String roleId;
        private String ids;
        
        public String getRoleId() {
            return roleId;
        }
        public String getIds() {
            return ids;
        }
        public void setRoleId(String roleId) {
            this.roleId = roleId;
        }
        public void setIds(String ids) {
            this.ids = ids;
        }
    }
    
}
