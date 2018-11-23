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

/**
 * @ClassName: SystemMenu.java
 * @Description: 系统菜单
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月19日 下午2:09:57 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月19日     xiahui           v1.0.0             系统菜单
 */
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result + ((menuCode == null) ? 0 : menuCode.hashCode());
		result = prime * result + ((menuIcon == null) ? 0 : menuIcon.hashCode());
		result = prime * result + ((menuId == null) ? 0 : menuId.hashCode());
		result = prime * result + ((menuIsMenu == null) ? 0 : menuIsMenu.hashCode());
		result = prime * result + ((menuName == null) ? 0 : menuName.hashCode());
		result = prime * result + ((menuOrder == null) ? 0 : menuOrder.hashCode());
		result = prime * result + ((menuPath == null) ? 0 : menuPath.hashCode());
		result = prime * result + ((menuPcode == null) ? 0 : menuPcode.hashCode());
		result = prime * result + ((menuPcodes == null) ? 0 : menuPcodes.hashCode());
		result = prime * result + ((menuStatus == null) ? 0 : menuStatus.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((updator == null) ? 0 : updator.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		SystemMenu other = (SystemMenu) obj;
		if (createTime == null) {
			if (other.createTime != null) {
				return false;
			}
		} else if (!createTime.equals(other.createTime)) {
			return false;
		}
		if (creator == null) {
			if (other.creator != null) {
				return false;
			}
		} else if (!creator.equals(other.creator)) {
			return false;
		}
		if (menuCode == null) {
			if (other.menuCode != null) {
				return false;
			}
		} else if (!menuCode.equals(other.menuCode)) {
			return false;
		}
		if (menuIcon == null) {
			if (other.menuIcon != null) {
				return false;
			}
		} else if (!menuIcon.equals(other.menuIcon)) {
			return false;
		}
		if (menuId == null) {
			if (other.menuId != null) {
				return false;
			}
		} else if (!menuId.equals(other.menuId)) {
			return false;
		}
		if (menuIsMenu == null) {
			if (other.menuIsMenu != null) {
				return false;
			}
		} else if (!menuIsMenu.equals(other.menuIsMenu)) {
			return false;
		}
		if (menuName == null) {
			if (other.menuName != null) {
				return false;
			}
		} else if (!menuName.equals(other.menuName)) {
			return false;
		}
		if (menuOrder == null) {
			if (other.menuOrder != null) {
				return false;
			}
		} else if (!menuOrder.equals(other.menuOrder)) {
			return false;
		}
		if (menuPath == null) {
			if (other.menuPath != null) {
				return false;
			}
		} else if (!menuPath.equals(other.menuPath)) {
			return false;
		}
		if (menuPcode == null) {
			if (other.menuPcode != null) {
				return false;
			}
		} else if (!menuPcode.equals(other.menuPcode)) {
			return false;
		}
		if (menuPcodes == null) {
			if (other.menuPcodes != null) {
				return false;
			}
		} else if (!menuPcodes.equals(other.menuPcodes)) {
			return false;
		}
		if (menuStatus == null) {
			if (other.menuStatus != null) {
				return false;
			}
		} else if (!menuStatus.equals(other.menuStatus)) {
			return false;
		}
		if (updateTime == null) {
			if (other.updateTime != null) {
				return false;
			}
		} else if (!updateTime.equals(other.updateTime)) {
			return false;
		}
		if (updator == null) {
			if (other.updator != null) {
				return false;
			}
		} else if (!updator.equals(other.updator)) {
			return false;
		}
		return true;
	}

	
}
