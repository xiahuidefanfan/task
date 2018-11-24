package com.team.tool.task.dao.system;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.team.tool.task.bean.condition.SystemDictQueryCondition;
import com.team.tool.task.bean.model.system.SystemDict;

/**
 * @ClassName: SystemDictMapper.java
 * @Description: 系统字典dao层
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月19日 下午2:22:44 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月19日     xiahui           v1.0.0               修改原因
 */
public interface SystemDictMapper extends BaseMapper<SystemDict> {

	 /**
	  * @Description: 根据条件查询字典
	  * @author: xiahui
	  * @date: 2018年11月23日 下午2:49:06
	  */
    List<Map<String, Object>> queryList(@Param("condition") SystemDictQueryCondition condition);
}
