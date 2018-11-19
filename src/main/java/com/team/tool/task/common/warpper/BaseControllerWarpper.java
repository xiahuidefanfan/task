package com.team.tool.task.common.warpper;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: BaseControllerWarpper.java
 * @Description: 控制器查询结果的包装类基类
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月19日 下午1:25:29 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月19日     xiahui           v1.0.0     控制器查询结果的包装类基类
 */
public abstract class BaseControllerWarpper {

    public Object obj = null;
    
    public BaseControllerWarpper(Object obj) {
        this.obj = obj;
    }

    @SuppressWarnings("unchecked")
    public Object warp() {
        if (this.obj instanceof List) {
            List<Map<String, Object>> list = (List<Map<String, Object>>) this.obj;
            for (Map<String, Object> map : list) {
                warpTheMap(map);
            }
            return list;
        } else if (this.obj instanceof Map) {
            Map<String, Object> map = (Map<String, Object>) this.obj;
            warpTheMap(map);
            return map;
        } else {
            return this.obj;
        }
    }

    protected abstract void warpTheMap(Map<String, Object> map);
}
