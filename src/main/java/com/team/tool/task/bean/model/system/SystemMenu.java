package com.team.tool.task.bean.model.system;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.security.core.GrantedAuthority;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import io.swagger.annotations.ApiModelProperty;

@TableName("sys_menu")
public class SystemMenu extends Model<SystemRole> implements GrantedAuthority {

	private static final long serialVersionUID = 1L;
	
	@TableId(value="menu_id", type= IdType.AUTO)
	@ApiModelProperty(value = "角色主键")
	private Integer menuId;
	
	@TableField(value="menu_code")
	@ApiModelProperty(value = "菜单编号")
	private String menuCode;
	
	@TableField(value="menu_pcode")
	@ApiModelProperty(value = "菜单父编号")
	private String menuPcode;
	
	@TableField(value="menu_pcodes")
	@ApiModelProperty(value = "当前菜单的所有父菜单编号")
	private String menuPcodes;
	
	@TableField(value="menu_name")
	@ApiModelProperty(value = "菜单名称")
	private String menuName;
	
	@TableField(value="menu_icon")
	@ApiModelProperty(value = "菜单图标")
	private String menuIcon;
	
	@TableField(value="menu_path")
	@ApiModelProperty(value = "路由地址")
	private String menuPath;
	
	@TableField(value="menu_order")
	@ApiModelProperty(value = "菜单排序号")
	private String menuOrder;
	
	@TableField(value="menu_is_menu")
	@ApiModelProperty(value = "是否是菜单（1：是  0：不是）")
	private String menuIsMenu;
	
	@TableField(value="menu_status")
	@ApiModelProperty(value = "菜单状态 :  1:启用   0:不启用")
	private String menuStatus;
	
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
	
	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getMenuPcode() {
		return menuPcode;
	}

	public void setMenuPcode(String menuPcode) {
		this.menuPcode = menuPcode;
	}

	public String getMenuPcodes() {
		return menuPcodes;
	}

	public void setMenuPcodes(String menuPcodes) {
		this.menuPcodes = menuPcodes;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	public String getMenuPath() {
		return menuPath;
	}

	public void setMenuPath(String menuPath) {
		this.menuPath = menuPath;
	}

	public String getMenuOrder() {
		return menuOrder;
	}

	public void setMenuOrder(String menuOrder) {
		this.menuOrder = menuOrder;
	}

	public String getMenuIsMenu() {
		return menuIsMenu;
	}

	public void setMenuIsMenu(String menuIsMenu) {
		this.menuIsMenu = menuIsMenu;
	}

	public String getMenuStatus() {
		return menuStatus;
	}

	public void setMenuStatus(String menuStatus) {
		this.menuStatus = menuStatus;
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
		return this.menuId;
	}

	@Override
	public String getAuthority() {
		return this.menuCode;
	}

}
