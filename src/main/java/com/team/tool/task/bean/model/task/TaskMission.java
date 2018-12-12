package com.team.tool.task.bean.model.task;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName: Taskmission.java
 * @Description: 任务模型
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月6日 上午10:25:42 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年12月6日     xiahui           v1.0.0         任务模型
 */
@TableName("task_mission")
public class TaskMission extends Model<TaskMission>{
	
	private static final long serialVersionUID = 1L;
	
	@TableId(value="mission_id", type= IdType.AUTO)
	@ApiModelProperty(value = "主键id")
	private Integer missionId;
	
	@TableField(value="mission_name")
	@ApiModelProperty(value = "任务名称")
	@NotBlank(message = "任务名称不可为空")
	private String missionName;
	
	@TableField(value="mission_group")
	@ApiModelProperty(value = "任务所属模块")
	@NotBlank(message = "任务所属模块不可为空")
	private String missionGroup;
	
	@TableField(value="mission_demand_id")
	@ApiModelProperty(value = "任务所属需求")
	@NotNull(message = "任务所属需求不可为空")
	private Integer missionDemandId;
	
	@TableField(value="mission_developer")
	@ApiModelProperty(value = "任务开发者")
	@NotNull(message = "任务开发者不可为空")
	private Integer missionDeveloper;
	
	@TableField(value="mission_tester")
	@ApiModelProperty(value = "任务测试者")
	@NotNull(message = "任务测试者不可为空")
	private Integer missionTester;
	
	@TableField(value="mission_workdays")
	@ApiModelProperty(value = "任务工作量")
	@NotNull(message = "任务工作量不可为空")
	private Float missionWorkdays;
	
	@TableField(value="mission_stage")
	@ApiModelProperty(value = "任务阶段")
	private String missionStage;
	
	@TableField(value="mission_start_date")
	@ApiModelProperty(value = "任务开始时间")
	private Date missionStartDate;
	
	@TableField(value="mission_end_date")
	@ApiModelProperty(value = "任务结束时间")
	private Date missionEndDate;
	
	@TableField(value="mission_desc")
	@ApiModelProperty(value = "任务描述")
	private String missionDesc;
	
	@TableField(value="creator")
	@ApiModelProperty(value = "创建人")
	private Integer creator;
	
	@TableField(value="updator")
	@ApiModelProperty(value = "修改人")
	private Integer updator;
   
	@TableField(value="create_time")
	@ApiModelProperty(value = "创建时间")
	private Timestamp createTime;
	
	@TableField(value="update_time")
	@ApiModelProperty(value = "修改时间")
	private Timestamp updateTime;
	
	public Integer getMissionId() {
		return missionId;
	}

	public void setMissionId(Integer missionId) {
		this.missionId = missionId;
	}

	public String getMissionName() {
		return missionName;
	}

	public void setMissionName(String missionName) {
		this.missionName = missionName;
	}
	
	public Integer getMissionDemandId() {
		return missionDemandId;
	}

	public void setMissionDemandId(Integer missionDemandId) {
		this.missionDemandId = missionDemandId;
	}

	public String getMissionGroup() {
		return missionGroup;
	}

	public void setMissionGroup(String missionGroup) {
		this.missionGroup = missionGroup;
	}

	public Integer getMissionDeveloper() {
		return missionDeveloper;
	}

	public void setMissionDeveloper(Integer missionDeveloper) {
		this.missionDeveloper = missionDeveloper;
	}

	public Integer getMissionTester() {
		return missionTester;
	}

	public void setMissionTester(Integer missionTester) {
		this.missionTester = missionTester;
	}

	public Float getMissionWorkdays() {
		return missionWorkdays;
	}

	public void setMissionWorkdays(Float missionWorkdays) {
		this.missionWorkdays = missionWorkdays;
	}

	public String getMissionStage() {
		return missionStage;
	}

	public void setMissionStage(String missionStage) {
		this.missionStage = missionStage;
	}

	public Date getMissionStartDate() {
		return missionStartDate;
	}

	public void setMissionStartDate(Date missionStartDate) {
		this.missionStartDate = missionStartDate;
	}

	public Date getMissionEndDate() {
		return missionEndDate;
	}

	public void setMissionEndDate(Date missionEndDate) {
		this.missionEndDate = missionEndDate;
	}

	public String getMissionDesc() {
		return missionDesc;
	}

	public void setMissionDesc(String missionDesc) {
		this.missionDesc = missionDesc;
	}

	public Integer getCreator() {
		return creator;
	}

	public void setCreator(Integer creator) {
		this.creator = creator;
	}

	public Integer getUpdator() {
		return updator;
	}

	public void setUpdator(Integer updator) {
		this.updator = updator;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	@Override
	protected Serializable pkVal() {
		return missionId;
	}

}
