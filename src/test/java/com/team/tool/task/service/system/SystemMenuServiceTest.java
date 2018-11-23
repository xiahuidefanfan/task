package com.team.tool.task.service.system;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName: SystemMenuServiceTest.java
 * @Description: SystemMenuService测试
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月19日 下午1:13:03 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月19日     xiahui           v1.0.0           测试添加
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SystemMenuServiceTest {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(SystemMenuServiceTest.class);

	@Autowired
	private SystemMenuService systemMenuService;
	
	@Test
	public void parentList() {
		LOGGER.info("查询父级菜单集合为：" + systemMenuService.parentMenuList().toString());
	}

}
