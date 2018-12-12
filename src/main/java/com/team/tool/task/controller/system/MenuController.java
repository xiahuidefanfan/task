package com.team.tool.task.controller.system;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team.tool.task.bean.condition.system.SystemMenuQueryCondition;
import com.team.tool.task.bean.dto.security.SecurityUser;
import com.team.tool.task.bean.model.system.SystemMenu;
import com.team.tool.task.bean.node.MenuNode;
import com.team.tool.task.common.cache.Cache;
import com.team.tool.task.common.constants.CommonConstans;
import com.team.tool.task.common.enums.ErrorCodeEnum;
import com.team.tool.task.common.support.RespData;
import com.team.tool.task.common.support.SecuritySupport;
import com.team.tool.task.common.util.StringUtil;
import com.team.tool.task.common.util.ToolUtil;
import com.team.tool.task.service.system.SystemMenuService;
import com.team.tool.task.warpper.system.SystemMenuWarpper;

import io.swagger.annotations.ApiOperation;
/**
 * @ClassName: MenuController.java
 * @Description: 菜单控制器
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月23日 上午10:17:49 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月23日     xiahui           v1.0.0           菜单控制器
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
	
	/**
	 * 菜单状态
	 */
	private static final Map<String, String>  STATU_MAP = new HashMap<String, String>(CommonConstans.DEFAULT_MAP_SIZE);
	static {
		STATU_MAP.put("1", "2");
		STATU_MAP.put("2", "1");
	}
	
	@Autowired
	private SystemMenuService systemMenuService;
	
	/**
	 * @Description: 查询菜单列表
	 * @author xiahui
	 * @date 2018年11月16日 下午4:30:31
	 */
    @PostMapping(value = "/list.action")
    @ApiOperation(value = "菜单列表查询")
    public RespData list(@RequestBody(required=false) SystemMenuQueryCondition condition) {
        List<Map<String, Object>> parentList = this.systemMenuService.queryParentMenuList();
        return RespData.getRespData(true, new SystemMenuWarpper(parentList).warp(), "");
    }
    
	/**
	 * @Description: 添加菜单
	 * @author xiahui
	 * @date 2018年11月26日 下午18:12:31
	 */
    @PostMapping(value = "/add.action")
    @ApiOperation(value = "添加菜单")
    @CacheEvict(value=Cache.SYSTEM_MENU, allEntries=true)
    public RespData add(@Valid SystemMenu menu, BindingResult bindingResult) {
    	/**
    	 * 设置菜单基础信息
    	 */
    	SecurityUser securityUser = SecuritySupport.getSecurityUser();
    	menu.setCreator(securityUser.getUserId());
    	menu.setUpdator(securityUser.getUserId());
    	menu.setCreateTime(new Timestamp(System.currentTimeMillis()));
    	menu.setUpdateTime(new Timestamp(System.currentTimeMillis()));
    	menuSetPcode(menu);
    	
    	/**
    	 * 保存菜单信息
    	 */
    	menu.insert();
        return RespData.getRespData(true, null, "添加菜单成功！");
    }
    
    /**
	 * @Description: 修改菜单
	 * @author xiahui
	 * @date 2018年11月26日 下午18:12:31
	 */
    @PutMapping(value = "/update.action")
    @ApiOperation(value = "修改菜单")
    @CacheEvict(value=Cache.SYSTEM_MENU, allEntries=true)
    public RespData update(@Valid SystemMenu menu, BindingResult bindingResult) {
    	/**
    	 * 设置菜单基础信息
    	 */
    	SecurityUser securityUser = SecuritySupport.getSecurityUser();
    	menu.setUpdator(securityUser.getUserId());
    	
    	/**
    	 * 保存菜单信息
    	 */
    	menu.updateById();
        return RespData.getRespData(true, null, "修改菜单成功！");
    }
    
    /**
	 * @Description: 禁用菜单
	 * @author xiahui
	 * @date 2018年11月28日 上午10:52:31
	 */
    @PutMapping(value = "/changeStatus.action")
    @ApiOperation(value = "修改菜单状态")
    @CacheEvict(value=Cache.SYSTEM_MENU, allEntries=true)
    public RespData changeStatus(@RequestParam Integer menuId ) {
    	/**
    	 * 校验入参
    	 */
    	Assert.isTrue(null != menuId, StringUtil.parseString(ErrorCodeEnum.CHECK_ERROR.msg(), "修改菜单状态", "菜单主键不可为空！"));
    	SystemMenu menu = this.systemMenuService.selectById(menuId);
    	Assert.isTrue(null != menu, StringUtil.parseString(ErrorCodeEnum.RESOURCE_ERROR.msg(), "修改菜单状态", "该菜单不存在！"));
    	
    	/**
    	 * 禁用菜单
    	 */
    	SecurityUser securityUser = SecuritySupport.getSecurityUser();
    	menu.setUpdator(securityUser.getUserId());
    	menu.setMenuStatus(STATU_MAP.get(menu.getMenuStatus()));
    	menuSetPcode(menu);
    	
    	/**
    	 * 保存菜单信息
    	 */
    	menu.updateById();
        return RespData.getRespData(true, null, "修改菜单状态菜单成功！");
    }
	
    /**
     * @Description: 获取菜单列表(首页用)
     * @author: xiahui
     * @date: 2018年11月27日 下午4:42:34
     */
	@SuppressWarnings("unchecked")
	@GetMapping(value = "/queryCurUserMenuNode.action")
	@ApiOperation(value = "首页菜单树")
    public RespData queryCurUserMenuNode() {
    	SecurityUser securityUser = SecuritySupport.getSecurityUser();
        List<MenuNode> menuNodeList = systemMenuService.queryMenuTreeByRoleId(securityUser.getUserRoleId());
        List<MenuNode> menuTree = (List<MenuNode>) MenuNode.buildTree(menuNodeList);
        return RespData.getRespData(true, menuTree, "");
    }
	
	/**
	 * @Description: 获取当前角色权限列表(授权用)
	 * @author: xiahui
	 * @date: 2018年12月1日 下午1:39:36
	 */
	@PostMapping(value = "/queryCurRoleAuthority.action")
	@ApiOperation(value = "获取当前角色权限列表")
    public RespData queryCurRoleAuthority(@RequestParam Integer roleId) {
        List<MenuNode> menuNodeList = systemMenuService.queryMenuTreeByRoleId(roleId);
        return RespData.getRespData(true, menuNodeList, "");
    }
	
	 /**
     * @Description: 获取菜单列表(授权用)
     * @author: xiahui
     * @date: 2018年12月01日 下午1:16:34
     */
	@SuppressWarnings("unchecked")
	@GetMapping(value = "/queryMenuTree.action")
	@ApiOperation(value = "查询菜单树")
    public RespData queryMenuTree() {
        List<MenuNode> menuNodeList = systemMenuService.queryMenuTree();
        List<MenuNode> menuTree = (List<MenuNode>) MenuNode.buildTree(menuNodeList);
        return RespData.getRespData(true, menuTree, "");
    }

    /**
     * 根据请求的父级菜单编号设置pcode和层级
     */
    private void menuSetPcode(SystemMenu menu) {
        if (ToolUtil.isEmpty(menu.getMenuPcode()) || menu.getMenuPcode().equals("0")) {
            menu.setMenuPcode("0");
            menu.setMenuPcodes("[0],");
        } else {
            String code = menu.getMenuPcode();
            SystemMenu pMenu = this.systemMenuService.queryMenuByCode(code);
            menu.setMenuPcode(pMenu.getMenuCode());
            Assert.isTrue(!menu.getMenuCode().equals(menu.getMenuPcode()), StringUtil.parseString(
            		ErrorCodeEnum.CHECK_ERROR.msg(), "添加菜单", "菜单编号和父编号不能一致！"));
            menu.setMenuPcodes(pMenu.getMenuPcodes() + "[" + pMenu.getMenuPcode() + "],");
        }
    }
}
