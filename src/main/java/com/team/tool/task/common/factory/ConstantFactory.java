package com.team.tool.task.common.factory;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import com.team.tool.task.bean.model.system.SystemMenu;
import com.team.tool.task.common.support.SpringContextHolder;
import com.team.tool.task.dao.system.SystemMenuMapper;

@Component
@DependsOn("springContextHolder")
public class ConstantFactory{

   private SystemMenuMapper systemMenuMapper = SpringContextHolder.getBean(SystemMenuMapper.class);
    
   public static ConstantFactory me() {
       return SpringContextHolder.getBean("constantFactory");
   }
   
   /**
    * @Description: 根据角色查询权限
    * @author xiahui
    * @date 2018年11月12日 下午10:43:51
    */
   public List<Integer> getAuthoritiesByRoleId(@Param("roleId") Integer roleId){
	   return systemMenuMapper.getAuthoritiesByRoleId(roleId);
   }
   
   /**
    * @Description: 根据权限获取权限实体
    * @author xiahui
    * @date 2018年11月12日 下午10:58:53
    */
   public Set<SystemMenu> getAuthoritiesModelByMenuId(@Param("menuIds") List<Integer> menuIds){
	   return systemMenuMapper.getAuthoritiesModelByMenuId(menuIds);
   }
}