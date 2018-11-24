package com.team.tool.task.service.system;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName: SystemDictServiceTest.java
 * @Description: SystemDictService测试
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月23日 下午3:03:10 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月23日     xiahui           v1.0.0      SystemDictService测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SystemDictServiceTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(SystemDictServiceTest.class);

	@Autowired
	private SystemDictService systemDictService;
	
	@Test
	public void list() {
		List<Map<String, Object>> dict = systemDictService.queryList(null);
		LOGGER.info(String.valueOf(dict));
	}
 
}
