package com.team.tool.task.bean.model.system;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Past;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName: SystemUser.java
 * @Description: 系统用户
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月10日 下午6:11:56 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月10日     xiahui           v1.0.0            系统用户
 */
@TableName("sys_user")
public class SystemUser extends Model<SystemUser> {
	private static final long serialVersionUID = 1L;
	
	public interface SystemUserSimpleView {};
	public interface SystemUserDetailView extends SystemUserSimpleView {};
	
	@TableId(value="user_id", type= IdType.AUTO)
	@ApiModelProperty(value = "主键id")
	private Integer userId;
   
	@TableField(value="user_avatar")
	@ApiModelProperty(value = "用户头像")
	private String userAvatar;
    
	@TableField(value="user_realName")
	@ApiModelProperty(value = "用户实名")
	private String userRealName;

	@TableField(value="user_password")
	@JsonView(SystemUserDetailView.class)
	@ApiModelProperty(value = "用户密码")
	private String userPassword;
    
	@TableField(value="user_name")
	@JsonView(SystemUserSimpleView.class)
	@ApiModelProperty(value = "用户账号")
	private String userName;
   
	@TableField(value="user_birthday")
	@Past(message = "生日必须是过去的时间")
	@ApiModelProperty(value = "用户生日")
	private Date userBirthday;

	@TableField(value="user_sex")
	@ApiModelProperty(value = "性别（1：男 2：女）")
	private Integer userSex;
    
	@TableField(value="user_email")
	@ApiModelProperty(value = "电子邮件")
	private String userEmail;
	
	@TableField(value="user_phone")
	@ApiModelProperty(value = "电话")
	private String userPhone;
   
	@TableField(value="user_role_id")
	@ApiModelProperty(value = "角色id")	
	private Integer userRoleId;
    
	@TableField(value="user_dept_id")
	@ApiModelProperty(value = "部门id")
	private Integer userDeptId;

	@TableField(value="user_status")
	@ApiModelProperty(value = "状态(1：启用  2：冻结  3：删除）")
	private Integer userStatus;
	
	@TableField(value="creator")
	@ApiModelProperty(value = "创建人")
	private String creator;
	
	@TableField(value="updator")
	@ApiModelProperty(value = "修改人")
	private Integer updator;
   
	@TableField(value="create_time")
	@ApiModelProperty(value = "创建时间")
	private Timestamp createTime;
	
	@TableField(value="update_time")
	@ApiModelProperty(value = "修改时间")
	private Timestamp updateTime;
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserAvatar() {
		return userAvatar;
	}

	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}

	public String getUserRealnName() {
		return userRealName;
	}

	public void setUserAccount(String userRealName) {
		this.userRealName = userRealName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public Integer getUserSex() {
		return userSex;
	}

	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public Integer getUserDeptId() {
		return userDeptId;
	}

	public void setUserDeptId(Integer userDeptId) {
		this.userDeptId = userDeptId;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
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

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	
	public String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
	@Override
	protected Serializable pkVal() {
		return this.userId;
	}
	
}
