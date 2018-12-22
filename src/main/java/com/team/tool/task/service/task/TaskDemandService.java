package com.team.tool.task.service.task;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.team.tool.task.bean.condition.task.TaskDemandQueryCondition;
import com.team.tool.task.bean.model.task.TaskDemand;

/**
 * @ClassName: TaskDemandService.java
 * @Description: TaskDemand-service层
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月3日 下午7:16:32 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年12月3日     xiahui           v1.0.0         TaskDemand-service层
 */
public interface TaskDemandService extends IService<TaskDemand>{
	
	/**
	 * @Description: 根据条件查询需求
	 * @author: xiahui
	 * @date: 2018年12月3日 下午7:14:52	
	 */
    List<Map<String, Object>> queryList(Page<TaskDemand> page, TaskDemandQueryCondition condition);
    
   /**
    * @Description: 启动报销流程
    * @author: xiahui
	* @date: 2018年12月22日 下午4:33:52	
    */
   void execute(TaskDemand taskDemand);
    
}
