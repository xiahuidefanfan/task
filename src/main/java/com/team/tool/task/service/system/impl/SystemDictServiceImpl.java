package com.team.tool.task.service.system.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.team.tool.task.bean.condition.SystemDictQueryCondition;
import com.team.tool.task.bean.model.system.SystemDict;
import com.team.tool.task.dao.system.SystemDictMapper;
import com.team.tool.task.service.system.SystemDictService;

/**
 * @ClassName: SystemDictServiceImpl.java
 * @Description: SystemDict-service实现层
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月23日 下午2:57:06 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月23日     xiahui           v1.0.0               修改原因
 */
@Service
public class SystemDictServiceImpl extends ServiceImpl<SystemDictMapper, SystemDict> implements SystemDictService{

	@Override
	public List<Map<String, Object>> queryList(SystemDictQueryCondition condition) {
		return this.baseMapper.queryList(condition);
	}

}
