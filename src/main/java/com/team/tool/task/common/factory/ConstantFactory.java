package com.team.tool.task.common.factory;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import com.team.tool.task.bean.model.system.SystemMenu;
import com.team.tool.task.common.cache.Cache;
import com.team.tool.task.common.cache.CacheKey;
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
   @Cacheable(value = Cache.SYSTEM_ROLE, key = "'" + CacheKey.ROLE_ID + "'+#roleId")
   public List<Integer> getAuthoritiesByRoleId(Integer roleId){
	   return systemMenuMapper.getAuthoritiesByRoleId(roleId);
   }
   
   /**
    * @Description: 根据权限获取权限实体
    * @author xiahui
    * @date 2018年11月12日 下午10:58:53
    */
   public Set<SystemMenu> getAuthoritiesModelByMenuId(List<Integer> menuIds){
	   return systemMenuMapper.getAuthoritiesModelByMenuId(menuIds);
   }
   
   /**
    * @Description: 根据父级菜单查询子菜单列表
    * @author xiahui
    * @date 2018年11月19日 下午1:46:53
    */
   @Cacheable(value = Cache.SYSTEM_MENU, key = "'" + CacheKey.MENU_CODE + "'+#pcode")
   public List<Map<String, Object>> queryMenuListByParent(String pcode){
	   return systemMenuMapper.queryMenuListByParent(pcode);
   }
}