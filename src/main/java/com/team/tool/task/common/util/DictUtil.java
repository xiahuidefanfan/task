package com.team.tool.task.common.util;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: DictUtil.java
 * @Description: 字典操作帮助类
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月23日 下午2:23:04 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月23日     xiahui           v1.0.0         字典操作帮助类
 */
public class DictUtil {
    
    /**
     * 在给定字典集合中，找出字典的名称
     * @param dicts :字典集合
     * @param code： 父字典code，主要确定字典类型
     * @param childCode：子项code，确定具体类型下的字典名称
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String getChildDictName(List<Map<String, Object>> dicts , String code, String childCode) {
        if(ToolUtil.isEmpty(dicts) || ToolUtil.isEmpty(code) || ToolUtil.isEmpty(childCode)) {
            return "";
        }
        Map<String, Object>  pDict = null;
        // 先获取到父字典项
        for(Map<String, Object> dict : dicts) {
            if(dict.get("dictCode").equals(code)){
                pDict = dict;
                break;
            }
        }
        
        // 通过父字典id和子项childCode获取到子Dict
        for(Map<String, Object> dict : dicts) {
            if(String.valueOf(dict.get("dictPid")).equals(String.valueOf(pDict.get("dictId"))) && dict.get("dictCode").equals(childCode)) {
                return String.valueOf(dict.get("dictName"));
            }
        }
        return "";
    }
}
