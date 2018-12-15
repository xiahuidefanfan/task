package com.team.tool.task.warpper.workflow;

import java.util.List;
import java.util.Map;

import com.team.tool.task.common.enums.YesOrNoEnum;
import com.team.tool.task.common.enums.system.DictTypeEnum;
import com.team.tool.task.common.factory.ConstantFactory;
import com.team.tool.task.common.util.DictUtil;
import com.team.tool.task.common.warpper.BaseControllerWarpper;

/**
 * @ClassName: WorkflowNodeWarpper.java
 * @Description: 工作流节点包装
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月14日 下午7:56:32 
 *
 * Modification History:
 * Date         Author          Version             Description
 *-------------------------------------------------------------*
 * 2018年12月14日     xiahui           v1.0.0          工作流节点包装
 */
public class WorkflowNodeWarpper extends BaseControllerWarpper{

	public WorkflowNodeWarpper(List<Map<String, Object>> list) {
        super(list);
	}
	
	@Override
	protected void warpTheMap(Map<String, Object> map) {
		/**
		 * 设置枚举名称
		 */
		String nodeCanBackTo = String.valueOf(map.get("nodeCanBackTo"));
		map.put("nodeCanBackToName", YesOrNoEnum.getByCode(Integer.valueOf(nodeCanBackTo)).getMsg());
		String nodeCanRollBack = String.valueOf(map.get("nodeCanRollBack"));
		map.put("nodeCanRollBackName", YesOrNoEnum.getByCode(Integer.valueOf(nodeCanRollBack)).getMsg());
		
		/**
		 * 节点类型
		 */
		String nodeTypeName = DictUtil.getChildDictName(ConstantFactory.me().queryAllDicts(), DictTypeEnum.WORKFLOW_NODE_TYPE.getCode(), 
				String.valueOf(map.get("nodeType")));
		map.put("nodeTypeName", nodeTypeName);

		/**
		 * 创建、修改时间设置
		 */
		map.put("createTimeFormat", map.get("createTime"));
		map.put("updateTimeFormat", map.get("updateTime"));
		map.remove("createTime");
		map.remove("updateTime");
	} 
	
}
