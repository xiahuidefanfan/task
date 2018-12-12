package com.team.tool.task.bean.condition.task;

import com.team.tool.task.bean.condition.BaseCondition;

/**
 * @ClassName: TaskMessionQueryCondition.java
 * @Description:  需求查询条件任务
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月6日 上午11:26:28 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年12月6日     xiahui           v1.0.0       需求查询条件任务
 */
public class TaskMissionQueryCondition extends BaseCondition{
	
	/**
	 * 任务名称
	 */
	private String missionName;
	
	/**
	 * 所属模块
	 */
	private String missionGroup;
	
	/**
	 * 任务测试
	 */
	private String missionTesterName;
	
	/**
	 * 任务开发
	 */
	private String missionDeveloperName;
	
	/**
	 * 所属需求
	 */
	private String missionDemandName;
	
	public String getMissionName() {
		return missionName;
	}
	public void setMissionName(String missionName) {
		this.missionName = missionName;
	}
	public String getMissionGroup() {
		return missionGroup;
	}
	public void setMissionGroup(String missionGroup) {
		this.missionGroup = missionGroup;
	}
	public String getMissionTesterName() {
		return missionTesterName;
	}
	public void setMissionTesterName(String missionTesterName) {
		this.missionTesterName = missionTesterName;
	}
	public String getMissionDeveloperName() {
		return missionDeveloperName;
	}
	public void setMissionDeveloperName(String missionDeveloperName) {
		this.missionDeveloperName = missionDeveloperName;
	}
	public String getMissionDemandName() {
		return missionDemandName;
	}
	public void setMissionDemandName(String missionDemandName) {
		this.missionDemandName = missionDemandName;
	}
	
}
