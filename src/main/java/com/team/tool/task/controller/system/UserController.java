/**
 * 
 */
package com.team.tool.task.controller.system;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.tool.task.common.support.RespData;

import io.swagger.annotations.ApiOperation;

/**
 * @ClassName: UserController.java
 * @Description: user操作controller
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月11日 上午10:47:45 
 *
 * Modification History:
 * Date         Author          Version            Description
 *------------------------------------------------------------*
 * 2018年11月11日     xiahui           v1.0.0              创建项目
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/userInfo.action")
	@ApiOperation(value = "查询用户信息")
	public RespData queryUserInfo(){
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return RespData.getRespData(true, userDetails, "");
	}

}
