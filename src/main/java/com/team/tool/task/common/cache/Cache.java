package com.team.tool.task.common.cache;

/**
 * @ClassName: Cache.java
 * @Description: 所有缓存名称的集合
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月19日 下午2:05:37 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月19日     xiahui           v1.0.0        所有缓存名称的集合
 */
public interface Cache {

    /**
     * 常量缓存
     */
    String CONSTANT = "CONSTANT";
    
    /**
     * 字典缓存
     */
    String SYSTEM_DICT = "SYSTEM_DICT";
    
    /**
     * 菜单缓存
     */
    String SYSTEM_MENU = "SYSTEM_MENU";
}
