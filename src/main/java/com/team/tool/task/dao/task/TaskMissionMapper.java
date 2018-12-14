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
 * @Description:  任务mapper层
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月6日 下午12:22:58 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年12月6日     xiahui           v1.0.0           任务mapper层
 */
public interface TaskMissionMapper extends BaseMapper<TaskMission>{
	/**
	 * @Description: 根据条件查询任务	
	 * @author: xiahui
	 * @date: 2018年12月6日 下午12:25:30
	 */
    List<Map<String, Object>> queryList(@Param("page")Page<TaskMission> page, @Param("condition")TaskMissionQueryCondition condition);
    
    /**
     * @Description: 根据需求查询任务 
     * @author: xiahui
     * @date: 2018年12月13日 上午10:10:09
     */
    List<Map<String, Object>> queryListByDemand(@Param("demandId")Integer demandId);
}
