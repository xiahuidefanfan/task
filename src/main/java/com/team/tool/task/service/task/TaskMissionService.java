package com.team.tool.task.service.task;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.team.tool.task.bean.condition.task.TaskMissionQueryCondition;
import com.team.tool.task.bean.model.task.TaskMission;

/**
 * @ClassName: TaskMessionService.java
 * @Description: TaskMession-service层
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月6日 上午11:28:32
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年12月3日     xiahui           v1.0.0     TaskMession-service层
 */
public interface TaskMissionService extends IService<TaskMission>{
	
	/**
	 * @Description: 根据条件查询任务	
	 * @author: xiahui
	 * @date: 2018年12月6日 上午11:25:30
	 */
    List<Map<String, Object>> queryList(Page<TaskMission> page, TaskMissionQueryCondition condition);

    /**
     * @Description: 根据需求查询任务 
     * @author: xiahui
     * @date: 2018年12月13日 上午10:10:09
     */
    List<Map<String, Object>> queryListByDemand(Integer demandId);
    
    /**
     * @Description: 启动任务流程 
     * @author: xiahui
     * @date: 2018年12月13日 下午9:01:09
     */
    void start();
}
