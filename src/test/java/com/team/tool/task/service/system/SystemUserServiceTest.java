package com.team.tool.task.service.system;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.team.tool.task.bean.model.system.SystemUser;
import com.team.tool.task.service.system.SystemUserService;

/**
 * @ClassName: SystemUserServiceTest.java
 * @Description: SystemUserService测试
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月12日 上午10:23:57 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月12日     xiahui           v1.0.0            项目新建
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SystemUserServiceTest {

	@Autowired
	private SystemUserService systemUserService;
	
	@Test
	public void list() {
		List<Map<String, Object>> userList = systemUserService.queryList(null);
		System.out.println(userList);
	}
	
	@Test
	public void queryUserByUserName() {
		SystemUser systemUser = systemUserService.queryUserByUserName("admin");
		System.out.println(systemUser);
	}
	
	@Test
	public void insert() {
		SystemUser systemUser = new SystemUser();
		systemUser.setUserName("xiaoli");
		systemUser.setUserPassword(new BCryptPasswordEncoder().encode("123456"));
		systemUser.setUserBirthday(new Date());
		systemUser.insert();
	}
	
	
}
