package com.team.tool.task.bean.model.system;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName: SystemRole.java
 * @Description: 系统角色
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月12日 下午9:41:09 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月12日     xiahui           v1.0.0               修改原因
 */
@TableName("sys_role")
public class SystemRole extends Model<SystemRole> {
	
	private static final long serialVersionUID = 1L;

	@TableId(value="role_id", type= IdType.AUTO)
	@ApiModelProperty(value = "角色主键")
	private Integer roleId;
	
	@TableField(value="role_pid")
	@ApiModelProperty(value = "角色父级id")
	private Integer rolePid;
	
	@TableField(value="role_name")
	@ApiModelProperty(value = "角色名称")
	private String roleName;
	
	@TableField(value="role_order")
	@ApiModelProperty(value = "角色排序")
	private Integer roleOrder;
	
	@TableField(value="role_desc")
	@ApiModelProperty(value = "角色描述")
	private String roleDesc;
	
	@TableField(value="creator")
	@ApiModelProperty(value = "创建人")
	private String creator;
	
	@TableField(value="updator")
	@ApiModelProperty(value = "修改人")
	private Integer updator;
   
	@TableField(value="create_time")
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
	
	@TableField(value="update_time")
	@ApiModelProperty(value = "修改时间")
	private Date updateTime;
	
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getRolePid() {
		return rolePid;
	}

	public void setRolePid(Integer rolePid) {
		this.rolePid = rolePid;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getRoleOrder() {
		return roleOrder;
	}

	public void setRoleOrder(Integer roleOrder) {
		this.roleOrder = roleOrder;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Integer getUpdator() {
		return updator;
	}

	public void setUpdator(Integer updator) {
		this.updator = updator;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}


	@Override
	protected Serializable pkVal() {
		return null;
	}

}
