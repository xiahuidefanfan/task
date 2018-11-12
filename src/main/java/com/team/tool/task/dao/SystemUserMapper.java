package com.team.tool.task.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.team.tool.task.bean.condition.SystemUserQueryCondition;
import com.team.tool.task.bean.model.SystemUser;

/**
 * @ClassName: SystemUserMapper.java
 * @Description: SystemUser-dao层
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月12日 上午10:21:45 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月12日     xiahui           v1.0.0             项目新建
 */
public interface SystemUserMapper extends BaseMapper<SystemUser>{

    /**
     * @Description: 获取所有用户
     * @author xiahui
     * @date 2018年11月12日 上午10:27:15
     */
    List<Map<String, Object>> list(@Param("condition") SystemUserQueryCondition condition);
}
