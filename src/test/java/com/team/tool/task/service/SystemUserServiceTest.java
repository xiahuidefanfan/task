package com.team.tool.task.service;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
		List<Map<String, Object>> userList = systemUserService.list(null);
		System.out.println(userList);
	}
	
}
