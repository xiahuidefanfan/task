package com.team.tool.task.warpper.task;

import java.util.List;
import java.util.Map;

import com.team.tool.task.common.enums.DictMenuEnum;
import com.team.tool.task.common.factory.ConstantFactory;
import com.team.tool.task.common.util.DictUtil;
import com.team.tool.task.common.warpper.BaseControllerWarpper;

/**
 * @ClassName: TaskDemandWarpper.java
 * @Description: 需求数据包装
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月3日 下午7:26:04 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年12月3日     xiahui           v1.0.0        需求数据包装
 */
public class TaskDemandWarpper extends BaseControllerWarpper{
	
	public TaskDemandWarpper(List<Map<String, Object>> list) {
        super(list);
	}
		
	@Override
	protected void warpTheMap(Map<String, Object> map) {
		
		/**
		 * 设置字典类型名称
		 */
		String missionStage = String.valueOf(map.get("demandStage"));
		String missionStageName = DictUtil.getChildDictName(ConstantFactory.me().queryAllDicts(), DictMenuEnum.DEMAND_STAGE.getCode(), 
				missionStage);
		map.put("demandStageName", missionStageName);
		/**
		 * 创建、修改时间设置
		 */
		map.put("createTimeFormat", map.get("createTime"));
		map.put("updateTimeFormat", map.get("updateTime"));
		map.remove("createTime");
		map.remove("updateTime");
	}
}
