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
import com.team.tool.task.dao.system.SystemDictMapper;
import com.team.tool.task.dao.system.SystemMenuMapper;
import com.team.tool.task.dao.task.TaskMissionMapper;
import com.team.tool.task.dao.workflow.WorkflowNodeMapper;

/**
 * @ClassName: ConstantFactory.java
 * @Description: 常用查询工厂
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月23日 上午10:09:31 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月23日     xiahui           v1.0.0          常用查询工厂
 */
@Component
@DependsOn("springContextHolder")
public class ConstantFactory{

   private SystemMenuMapper systemMenuMapper = SpringContextHolder.getBean(SystemMenuMapper.class);
   private SystemDictMapper systemDictMapper = SpringContextHolder.getBean(SystemDictMapper.class);
   private TaskMissionMapper taskMissionMapper = SpringContextHolder.getBean(TaskMissionMapper.class);
   private WorkflowNodeMapper workflowNodeMapper = SpringContextHolder.getBean(WorkflowNodeMapper.class);
    
   public static ConstantFactory me() {
       return SpringContextHolder.getBean("constantFactory");
   }
   
   /**
    * @Description: 查询全部字典
    * @author: xiahui
    * @date: 2018年11月23日 下午3:47:03
    */
   @Cacheable(value = Cache.SYSTEM_DICT, key = "'" + CacheKey.DICT + "'")
   public List<Map<String, Object>> queryAllDicts() {
	   return this.systemDictMapper.queryList(null);
   }
   
   /**
    * 
    * @Description: 根据父级字典编码查询子级字典
    * @author: xiahui
    * @date: 2018年12月1日 下午3:20:39
    */
   public List<Map<String, Object>> queryDictByParentCode(String dictCode) {
	   return this.systemDictMapper.queryDictByParentCode(dictCode);
   }
   
   /**
    * @Description: 根据角色查询权限
    * @author xiahui
    * @date 2018年11月12日 下午10:43:51
    */
   @Cacheable(value = Cache.SYSTEM_ROLE, key = "'" + CacheKey.ROLE_ID + "'+#roleId")
   public List<Integer> queryAuthoritiesByRoleId(Integer roleId){
	   return systemMenuMapper.queryAuthoritiesByRoleId(roleId);
   }
   
   /**
    * @Description: 根据权限获取权限实体
    * @author xiahui
    * @date 2018年11月12日 下午10:58:53
    */
   public Set<SystemMenu> queryAuthoritiesModelByMenuId(List<Integer> menuIds){
	   return systemMenuMapper.queryAuthoritiesModelByMenuId(menuIds);
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
   
   /**
    * @Description: 根据需求查询任务 
    * @author: xiahui
    * @date: 2018年12月13日 上午10:10:09
    */
   public List<Map<String, Object>> queryListByDemand(Integer demandId) {
	   return taskMissionMapper.queryListByDemand(demandId);
   }
   
   /**
    * @Description: 根据流程查询节点 
    * @author: xiahui
    * @date: 2018年12月21日 下午3:59:09
    */
   public List<Map<String, Object>> queryListByProcdefId(String procdefId) {
	   return workflowNodeMapper.queryListByProcdefId(procdefId);
   }
}