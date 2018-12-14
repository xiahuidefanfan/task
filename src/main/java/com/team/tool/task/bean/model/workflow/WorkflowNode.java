package com.team.tool.task.bean.model.workflow;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName: WorkFlowNode.java
 * @Description: 工作流节点管理
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月14日 下午7:15:46 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年12月14日     xiahui           v1.0.0          工作流节点管理
 */
public class WorkflowNode extends Model<WorkflowNode>{
	
	private static final long serialVersionUID = 1L;
	
	@TableId(value="node_id", type= IdType.AUTO)
	@ApiModelProperty(value = "主键id")
	private Integer nodeId;
	
	@TableField(value="node_name")
	@ApiModelProperty(value = "节点名称")
	@NotBlank(message = "节点名称不可为空")
	private String nodeName;
	
	@TableField(value="node_code")
	@ApiModelProperty(value = "节点编码")
	@NotBlank(message = "节点编码不可为空")
	private String nodeCode;
	
	@TableField(value="node_proc_def_id")
	@ApiModelProperty(value = "流程定义id")
	@NotBlank(message = "流程定义id不可为空")
	private String nodeProcDefId;
	
	@TableField(value="node_version")
	@ApiModelProperty(value = "节点版本")
	@NotBlank(message = "节点版本")
	private String nodeVersion;
	
	@TableField(value="node_order")
	@ApiModelProperty(value = "节点顺序，越小越靠前")
	@NotBlank(message = "节点顺序不可为空")
	private String nodeOrder;
	
	@TableField(value="node_can_back_to")
	@ApiModelProperty(value = "后续节点是否可以回退到该节点")
	@NotBlank(message = "后续节点是否可以回退到该节点不可为空")
	private String nodeCanBackTo;
	
	@TableField(value="node_can_roll_back")
	@ApiModelProperty(value = "当前节点是否可以做回退操作")
	@NotBlank(message = "当前节点是否可以做回退操作不可为空")
	private String nodeCanRollBack;
	
	@TableField(value="node_type")
	@ApiModelProperty(value = "节点类型")
	@NotBlank(message = "节点类型不可为空")
	private String nodeType;
	
	@TableField(value="node_desc")
	@ApiModelProperty(value = "节点描述")
	private String nodeDesc;
	
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
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	@Override
	protected Serializable pkVal() {
		return nodeId;
	}
	
}
