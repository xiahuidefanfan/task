/**
 * 
 */
package com.team.tool.task.controller.system;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.tool.task.common.enums.system.RoleCodeEnum;
import com.team.tool.task.common.support.RespData;
import com.team.tool.task.service.system.SystemUserService;

import io.swagger.annotations.ApiOperation;

/**
 * @ClassName: UserController.java
 * @Description: 用户控制器
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月11日 上午10:47:45 
 *
 * Modification History:
 * Date         Author          Version            Description
 *------------------------------------------------------------*
 * 2018年11月11日     xiahui           v1.0.0       用户控制器
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private SystemUserService systemUserService;
	
	@GetMapping("/userInfo.action")
	@ApiOperation(value = "查询用户信息")
	public RespData queryUserInfo(){
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return RespData.getRespData(true, userDetails, "");
	}
	
	@GetMapping("/queryTesters.action")
	@ApiOperation(value = "查询测试用户")
	public RespData queryTesters(){
		List<Map<String, Object>> testers = systemUserService.queryByRole(RoleCodeEnum.TEST_ENGINEER.getCode());
		return RespData.getRespData(true, testers, "");
	}

	@GetMapping("/queryDevelopers.action")
	@ApiOperation(value = "查询测试用户")
	public RespData queryDevelopers(){
		List<Map<String, Object>> developers = systemUserService.queryByRole(RoleCodeEnum.DEVELOPER_ENGINEER.getCode());
		return RespData.getRespData(true, developers, "");
	}
}
