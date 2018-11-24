package com.team.tool.task.service.system;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.service.IService;
import com.team.tool.task.bean.condition.SystemDictQueryCondition;
import com.team.tool.task.bean.model.system.SystemDict;

/**
 * @ClassName: SystemDictService.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月23日 下午2:51:43 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月23日     xiahui           v1.0.0               修改原因
 */
public interface SystemDictService extends IService<SystemDict>{
	
	 /**
	  * @Description: 根据条件查询字典
	  * @author: xiahui
	  * @date: 2018年11月23日 下午2:49:06
	  */
   List<Map<String, Object>> queryList(@Param("condition") SystemDictQueryCondition condition);

}
