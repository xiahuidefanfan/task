package com.team.tool.task.dao.task;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.team.tool.task.bean.condition.task.TaskDemandQueryCondition;
import com.team.tool.task.bean.model.task.TaskDemand;

/**
 * @ClassName: TaskDemandMapper.java
 * @Description: 需求mapper层
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月3日 下午7:02:34 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年12月3日     xiahui           v1.0.0        	需求mapper层
 */
public interface TaskDemandMapper extends BaseMapper<TaskDemand>{

	/**
	 * @Description: 根据条件查询需求
	 * @author: xiahui
	 * @date: 2018年12月3日 下午7:14:52
	 */
    List<Map<String, Object>> queryList(@Param("page")Page<TaskDemand> page, @Param("condition") TaskDemandQueryCondition condition);
}
