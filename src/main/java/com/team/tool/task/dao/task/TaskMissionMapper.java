package com.team.tool.task.dao.task;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.team.tool.task.bean.condition.task.TaskMissionQueryCondition;
import com.team.tool.task.bean.model.task.TaskMission;

/**
 * @ClassName: TaskMessionMapper.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月6日 下午12:22:58 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年12月6日     xiahui           v1.0.0               修改原因
 */
public interface TaskMissionMapper extends BaseMapper<TaskMission>{
	/**
	 * @Description: 根据条件查询任务	
	 * @author: xiahui
	 * @date: 2018年12月6日 下午12:25:30
	 */
    List<Map<String, Object>> queryList(@Param("page")Page<TaskMission> page, @Param("condition")TaskMissionQueryCondition condition);
}
