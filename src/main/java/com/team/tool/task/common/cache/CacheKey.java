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
     * 角色名称(多个)
     */
    String ROLES_NAME = "roles_name_";

    /**
     * 角色名称(单个)
     */
    String SINGLE_ROLE_NAME = "single_role_name_";

    /**
     * 角色英文名称
     */
    String SINGLE_ROLE_TIP = "single_role_tip_";

    /**
     * 部门名称
     */
    String DEPT_NAME = "dept_name_";

}
