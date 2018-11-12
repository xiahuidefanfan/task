package com.team.tool.task.controller.system;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.tool.task.common.support.RespData;

import io.swagger.annotations.ApiOperation;

/**
 * @ClassName: LoginController.java
 * @Description: 登录
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月12日 下午5:42:13 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月12日     xiahui           v1.0.0            登录controller
 */
@RestController
@RequestMapping("/login")
public class LoginController {
	
	@GetMapping
	@ApiOperation(value = "跳转到登录页面")
	public RespData login() {
		return RespData.getRespData(true, null, "");
	}
}
