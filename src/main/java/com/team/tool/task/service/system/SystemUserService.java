package com.team.tool.task.service.system;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.team.tool.task.bean.condition.system.SystemUserQueryCondition;
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
 * 2018年11月12日     xiahui           v1.0.0       SystemUser-service层
 */
public interface SystemUserService extends IService<SystemUser>{
	
	/**
     * @Description: 根据条件查询用户
     * @author xiahui
     * @date 2018年11月12日 上午10:27:15
     */
    List<Map<String, Object>> queryList(SystemUserQueryCondition condition);
    
    /**
     * @Description: 根据用户名查询用户
     * @author xiahui
     * @date 2018年11月12日 下午11:16:45
     */
    SystemUser queryUserByUserName(String userName);
    
    
	/**
     * @Description: 根据角色编码获取用户
     * @author xiahui
     * @date 2018年12月6日 下午10:26:15
     */
    List<Map<String, Object>> queryByRole(String roleCode);
    
}
