package com.team.tool.task.dao.system;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.team.tool.task.bean.condition.system.SystemUserQueryCondition;
import com.team.tool.task.bean.model.system.SystemUser;

/**
 * @ClassName: SystemUserMapper.java
 * @Description: 系统用户mapper层
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月12日 上午10:21:45 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月12日     xiahui           v1.0.0          系统用户mapper层
 */
public interface SystemUserMapper extends BaseMapper<SystemUser>{

    /**
     * @Description: 获取分页用户
     * @author xiahui
     * @date 2018年11月12日 上午10:27:15
     */
    List<Map<String, Object>> queryList(@Param("condition") SystemUserQueryCondition condition);
    
    /**
     * @Description: 根据用户名查询用户
     * @author xiahui
     * @date 2018年11月12日 下午11:16:45
     */
    SystemUser queryUserByUserName(@Param("username") String username);
    
    /**
     * @Description: 根据角色编码获取用户
     * @author xiahui
     * @date 2018年12月6日 下午10:26:15
     */
    List<Map<String, Object>> queryByRole(@Param("roleCode") String roleCode);
    
}
