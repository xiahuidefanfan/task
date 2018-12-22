package com.team.tool.task.bean.model.workflow;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName: WorkFlowNode.java
 * @Description: 工作流部署流程模型
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月19日 下午2:03:46 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年12月19日     xiahui           v1.0.0          工作流节点管理
 */
@TableName("act_re_procdef")
public class WorkflowProcdef extends Model<WorkflowProcdef>{
	private static final long serialVersionUID = 1L;

	@TableId(value="ID_", type= IdType.AUTO)
	@ApiModelProperty(value = "流程id")
	private Integer procdefId;
	
	@TableField(value="NAME_")
	@ApiModelProperty(value = "名称")
	private String procdefName;
	
	@TableField(value="KEY_")
	@ApiModelProperty(value = "流程主键")
	private String procdefKey;
	
	@TableField(value="VERSION_")
	@ApiModelProperty(value = "版本号")
	private String procdefVersion;
	
	@TableField(value="DEPLOYMENT_ID_")
	@ApiModelProperty(value = "部署主键")
	private String procdefDeploymentId;
	
	@TableField(value="RESOURCE_NAME_")
	@ApiModelProperty(value = "资源名称")
	private String procdefResourceName;
	
	public Integer getProcdefId() {
		return procdefId;
	}

	public void setProcdefId(Integer procdefId) {
		this.procdefId = procdefId;
	}

	public String getProcdefName() {
		return procdefName;
	}

	public void setProcdefName(String procdefName) {
		this.procdefName = procdefName;
	}

	public String getProcdefKey() {
		return procdefKey;
	}

	public void setProcdefKey(String procdefKey) {
		this.procdefKey = procdefKey;
	}

	public String getProcdefVersion() {
		return procdefVersion;
	}

	public void setProcdefVersion(String procdefVersion) {
		this.procdefVersion = procdefVersion;
	}

	public String getProcdefDeploymentId() {
		return procdefDeploymentId;
	}

	public void setProcdefDeploymentId(String procdefDeploymentId) {
		this.procdefDeploymentId = procdefDeploymentId;
	}

	public String getProcdefResourceName() {
		return procdefResourceName;
	}

	public void setProcdefResourceName(String procdefResourceName) {
		this.procdefResourceName = procdefResourceName;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
	@Override
	protected Serializable pkVal() {
		return procdefId;
	}

}
