package com.team.tool.task.warpper.task;

import java.util.List;
import java.util.Map;

import com.team.tool.task.common.enums.DictMenuEnum;
import com.team.tool.task.common.factory.ConstantFactory;
import com.team.tool.task.common.util.DictUtil;
import com.team.tool.task.common.warpper.BaseControllerWarpper;

/**
 * @ClassName: TaskMissionWarpper.java
 * @Description: 任务数据包装
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月6日 下午1:19:42 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年12月6日     xiahui           v1.0.0           任务数据包装
 */
public class TaskMissionWarpper extends BaseControllerWarpper{
	
	public TaskMissionWarpper(List<Map<String, Object>> list) {
        super(list);
	}
		
	@Override
	protected void warpTheMap(Map<String, Object> map) {
		/**
		 * 设置字典名称
		 */
		String missionGroup = String.valueOf(map.get("missionGroup"));
		String missionGroupName = DictUtil.getChildDictName(ConstantFactory.me().queryAllDicts(), DictMenuEnum.SERVICE_MODULE.getCode(), 
				missionGroup);
		map.put("missionGroupName", missionGroupName);
		String missionStage = String.valueOf(map.get("missionStage"));
		String missionStageName = DictUtil.getChildDictName(ConstantFactory.me().queryAllDicts(), DictMenuEnum.MISSION_STAGE.getCode(), 
				missionStage);
		map.put("missionStageName", missionStageName);
		/**
		 * 创建、修改时间设置
		 */
		map.put("createTimeFormat", map.get("createTime"));
		map.put("updateTimeFormat", map.get("updateTime"));
		map.remove("createTime");
		map.remove("updateTime");
	}

}
