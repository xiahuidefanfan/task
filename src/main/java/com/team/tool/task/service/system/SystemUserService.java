package com.team.tool.task.service.system;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.service.IService;
import com.team.tool.task.bean.condition.SystemUserQueryCondition;
import com.team.tool.task.bean.model.system.SystemUser;

/**
 * @ClassName: SystemUserService.java
 * @Description: SystemUser-service层
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月12日 上午10:22:24 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月12日     xiahui           v1.0.0               修改原因
 */
public interface SystemUserService extends IService<SystemUser>{
	
	 /**
     * @Description: 获取所有用户
     * @author xiahui
     * @date 2018年11月12日 上午10:27:15
     */
    List<Map<String, Object>> list(@Param("condition") SystemUserQueryCondition condition);
    
    /**
     * @Description: 根据用户名查询用户
     * @author xiahui
     * @date 2018年11月12日 下午11:16:45
     */
    SystemUser queryUserByUserName(@Param("condition") String userName);
}
