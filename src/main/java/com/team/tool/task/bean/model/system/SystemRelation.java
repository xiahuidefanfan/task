package com.team.tool.task.bean.model.system;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @ClassName: SystemRelation.java
 * @Description: 角色和菜单关联表
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月1日 下午2:24:37 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年12月1日     xiahui           v1.0.0       角色和菜单关联表
 */
@TableName("sys_relation")
public class SystemRelation extends Model<SystemRelation> {

    private static final long serialVersionUID = 1L;
    
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    private Integer id;
    
    
    @TableField(value="menu_id")
	@ApiModelProperty(value = "菜单主键")
    private Integer menuId;
   
    @TableField(value="role_id")
	@ApiModelProperty(value = "角色主键")
    private Integer roleId;

    public Integer getId() {
        return id;
    }

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	@Override
	protected Serializable pkVal() {
		return id;
	}
}
