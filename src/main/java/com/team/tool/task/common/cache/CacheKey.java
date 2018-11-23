package com.team.tool.task.common.cache;

/**
 * @ClassName: CacheKey.java
 * @Description: 缓存标识前缀集合,常用在ConstantFactory类中
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月19日 下午2:06:05 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月19日     xiahui           v1.0.0         缓存标识前缀集合
 */
public interface CacheKey {

	/**
     * 菜单名称
     */
    String MENU_CODE = "menu_code_";
    
    /**
     * 角色id
     */
    String ROLE_ID = "role_id_";
     
}
