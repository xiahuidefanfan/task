package com.team.tool.task.bean.node;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @ClassName: MenuNode.java
 * @Description: 菜单树形模型
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月15日 下午5:06:26 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月15日     xiahui           v1.0.0           菜单树形模型
 */
public class MenuNode extends TreeNode{
	
	  /**
     * 菜单code
     */
    private String code;
    
    /**
     * 父级菜单code
     */
    private String pcode;

    /**
     * 是否是按钮
     */
    private String isMenu;

    /**
     * 按钮的排序
     */
    private Integer order;

    /**
     * 节点的url
     */
    private String path;

    /**
     * 节点图标
     */
    private String icon;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getIsMenu() {
		return isMenu;
	}

	public void setIsMenu(String isMenu) {
		this.isMenu = isMenu;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
