package com.team.tool.task.bean.model.task;

import java.io.Serializable;
import java.sql.Timestamp;

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
 * @ClassName: TaskDemand.java
 * @Description: 需求模型
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月3日 下午6:42:23 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年12月3日     xiahui           v1.0.0            需求模型
 */
@TableName("task_demand")
public class TaskDemand extends Model<TaskDemand>{
	
	private static final long serialVersionUID = 1L;

	@TableId(value="demand_id", type= IdType.AUTO)
	@ApiModelProperty(value = "主键id")
	private Integer DemandId;
	
	@TableField(value="demand_name")
	@ApiModelProperty(value = "需求名称")
	@NotBlank(message = "需求名称不可为空")
	private String demandName;
	
	@TableField(value="demand_jira")
	@ApiModelProperty(value = "需求jira单号")
	@NotBlank(message = "需求jira单号")
	private String demandJira;
	
	@TableField(value="demand_originator")
	@ApiModelProperty(value = "需求发起人")
	private Integer demandOriginator;
	
	@TableField(value="demand_start_date")
	@ApiModelProperty(value = "需求开始时间")
	private Timestamp demandStartDate;
	
	@TableField(value="demand_end_date")
	@ApiModelProperty(value = "需求结束时间")
	private Timestamp demandEndDate;
	
	@TableField(value="demand_stage")
	@ApiModelProperty(value = "需求阶段")
	private String demandStage;
	
	@TableField(value="demand_desc")
	@ApiModelProperty(value = "需求描述")
	private String demandDesc;
	
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
	
	public Integer getDemandId() {
		return DemandId;
	}

	public void setDemandId(Integer demandId) {
		DemandId = demandId;
	}

	public String getDemandName() {
		return demandName;
	}

	public void setDemandName(String demandName) {
		this.demandName = demandName;
	}	
	
	public String getDemandJira() {
		return demandJira;
	}

	public void setDemandJira(String demandJira) {
		this.demandJira = demandJira;
	}

	public Integer getDemandOriginator() {
		return demandOriginator;
	}

	public void setDemandOriginator(Integer demandOriginator) {
		this.demandOriginator = demandOriginator;
	}

	public Timestamp getDemandStartDate() {
		return demandStartDate;
	}

	public void setDemandStartDate(Timestamp demandStartDate) {
		this.demandStartDate = demandStartDate;
	}
	
	public Timestamp getDemandEndDate() {
		return demandEndDate;
	}
	
	public void setDemandEndDate(Timestamp demandEndDate) {
		this.demandEndDate = demandEndDate;
	}

	public String getDemandStage() {
		return demandStage;
	}

	public void setDemandStage(String demandStage) {
		this.demandStage = demandStage;
	}

	public String getDemandDesc() {
		return demandDesc;
	}

	public void setDemandDesc(String demandDesc) {
		this.demandDesc = demandDesc;
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
		return DemandId;
	}
	
}
