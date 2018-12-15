package com.team.tool.task.warpper.task;

import java.util.List;
import java.util.Map;

import com.team.tool.task.common.enums.system.DemandStageEnum;
import com.team.tool.task.common.enums.system.DictTypeEnum;
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
		String demandStage = String.valueOf(map.get("demandStage"));
		String demandStageName = DictUtil.getChildDictName(ConstantFactory.me().queryAllDicts(), DictTypeEnum.DEMAND_STAGE.getCode(), 
				demandStage);
		map.put("demandStageName", demandStageName);
		
		/**
		 * 设置该需求的任务集合
		 */
		Integer demandId = Integer.valueOf(String.valueOf(map.get("demandId")));
		List<Map<String, Object>> childrens = ConstantFactory.me().queryListByDemand(demandId);
		map.put("childrens", new TaskMissionWarpper(childrens).warp());
		
		/**
		 * 按钮控制
		 */
		// 启动按钮
		if(DemandStageEnum.DEMAND_CREATE.getCode().equals(demandStage)) {
			map.put("showStart", true);
		}else {
			map.put("showStart", false);
		}
		
		// 拆分按钮
		if(DemandStageEnum.DEMAND_AUDIT.getOrder() < DemandStageEnum.getByCode(demandStage).getOrder()) {
			map.put("showAddMission", true);
		}else {
			map.put("showAddMission", false);
		}
		
		/**
		 * 创建、修改时间设置
		 */
		map.put("createTimeFormat", map.get("createTime"));
		map.put("updateTimeFormat", map.get("updateTime"));
		map.remove("createTime");
		map.remove("updateTime");
	}
}
