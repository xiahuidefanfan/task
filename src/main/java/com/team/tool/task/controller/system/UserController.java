/**
 * 
 */
package com.team.tool.task.controller.system;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.team.tool.task.bean.condition.SystemUserQueryCondition;
import com.team.tool.task.bean.model.SystemUser;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

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
	
	@GetMapping
	@JsonView(SystemUser.SystemUserSimpleView.class)
	@ApiOperation(value = "用户查询服务")
	public List<SystemUser> query(SystemUserQueryCondition condition,
			@PageableDefault(page = 2, size = 17, sort = "username,asc") Pageable pageable) {
		System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));
		System.out.println(pageable.getPageSize());
		System.out.println(pageable.getPageNumber());
		System.out.println(pageable.getSort());
		List<SystemUser> users = new ArrayList<>();
		users.add(new SystemUser());
		users.add(new SystemUser());
		users.add(new SystemUser());
		return users;
	}
	
	@GetMapping("/{id:\\d+}")
	@JsonView(SystemUser.SystemUserDetailView.class)
	public SystemUser getInfo(@ApiParam("用户id") @PathVariable String id) {
		System.out.println("进入getInfo服务");
		SystemUser user = new SystemUser();
		user.setUserName("tom");
		return user;
	}
	
	@PostMapping
	@ApiOperation(value = "创建用户")
	public SystemUser create(@Valid @RequestBody SystemUser user, BindingResult errors) {
		/*if(errors.hasErrors()) {
			errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
		}*/
		return user;
	}

}
