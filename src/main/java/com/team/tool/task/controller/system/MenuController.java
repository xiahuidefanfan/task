package com.team.tool.task.controller.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.tool.task.bean.dto.security.SecurityUser;
import com.team.tool.task.bean.node.MenuNode;
import com.team.tool.task.common.support.RespData;
import com.team.tool.task.common.support.SecuritySupport;
import com.team.tool.task.service.system.SystemMenuService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private SystemMenuService systemMenuService;
	
    /**
     * 获取菜单列表(首页用)
     */
	@SuppressWarnings("unchecked")
	@GetMapping(value = "/menuNode.action")
	@ApiOperation(value = "首页菜单树")
    public RespData menuNode() {
    	SecurityUser securityUser = SecuritySupport.getSecurityUser();
        List<MenuNode> menuNodeList = systemMenuService.getMenuTreeByRoleId(securityUser.getUserRoleId());
        List<MenuNode> menuTree = (List<MenuNode>) MenuNode.buildTree(menuNodeList);
        return RespData.getRespData(true, menuTree, "");
    }

}
