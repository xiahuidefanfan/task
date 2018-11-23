package com.team.tool.task.controller.system;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.tool.task.bean.condition.SystemMenuQueryCondition;
import com.team.tool.task.bean.dto.security.SecurityUser;
import com.team.tool.task.bean.node.MenuNode;
import com.team.tool.task.common.support.RespData;
import com.team.tool.task.common.support.SecuritySupport;
import com.team.tool.task.service.system.SystemMenuService;
import com.team.tool.task.warpper.system.SystemMenuWarpper;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private SystemMenuService systemMenuService;
	
	/**
	 * @Description: 查询菜单列表
	 * @author xiahui
	 * @return RespData    返回类型
	 * @date 2018年11月16日 下午4:30:31
	 */
    @PostMapping(value = "/list.action")
    @ApiOperation(value = "菜单列表查询")
    public RespData list(@RequestBody(required=false) SystemMenuQueryCondition condition) {
        List<Map<String, Object>> parentList = this.systemMenuService.parentMenuList();
        return RespData.getRespData(true, new SystemMenuWarpper(parentList).warp(), "");
    }
	
    /**
     * 获取菜单列表(首页用)
     */
	@SuppressWarnings("unchecked")
	@GetMapping(value = "/curUserMenuNode.action")
	@ApiOperation(value = "首页菜单树")
    public RespData curUserMenuNode() {
    	SecurityUser securityUser = SecuritySupport.getSecurityUser();
        List<MenuNode> menuNodeList = systemMenuService.getMenuTreeByRoleId(securityUser.getUserRoleId());
        List<MenuNode> menuTree = (List<MenuNode>) MenuNode.buildTree(menuNodeList);
        return RespData.getRespData(true, menuTree, "");
    }

}
