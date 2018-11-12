package com.team.tool.task.bean.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Past;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
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
public class SystemUser extends Model<SystemUser>{
	private static final long serialVersionUID = 1L;
	
	public interface SystemUserSimpleView {};
	public interface SystemUserDetailView extends SystemUserSimpleView {};
	/**
     * 主键id
     */
	@TableId(value="user_id", type= IdType.AUTO)
	private Integer userId;
    /**
     * 头像
     */
	@TableField(value="user_avatar")
	private String userAvatar;
    /**
     * 账号
     */
	@TableField(value="user_realName")
	@ApiModelProperty(value = "用户")
	private String userRealName;
    /**
     * 密码
     */
	@TableField(value="user_password")
	@JsonView(SystemUserDetailView.class)
	private String userPassword;
    /**
     * md5密码盐
     */
	@TableField(value="user_salt")
	private String userSalt;
    /**
     * 名字
     */
	@TableField(value="user_name")
	@JsonView(SystemUserSimpleView.class)
	private String userName;
    /**
     * 生日
     */
	@TableField(value="user_birthday")
	@Past(message = "生日必须是过去的时间")
	private Date userBirthday;
    /**
     * 性别（1：男 2：女）
     */
	@TableField(value="user_sex")
	private Integer userSex;
    /**
     * 电子邮件
     */
	@TableField(value="user_email")
	private String userEmail;
    /**
     * 电话
     */
	@TableField(value="user_phone")
	private String userPhone;
    /**
     * 角色id
     */
	@TableField(value="user_role_id")
	private String userRoleId;
    /**
     * 部门id
     */
	@TableField(value="user_dept_id")
	private Integer userDeptId;
    /**
     * 状态(1：启用  2：冻结  3：删除）
     */
	@TableField(value="user_status")
	private Integer userStatus;
	/**
	 *  创建人
	 */
	@TableField(value="creator")
	private String creator;
	
	/**
	 * 修改人
	 */
	@TableField(value="updator")
	private String updator;
    /**
     * 创建时间
     */
	@TableField(value="create_time")
	private Date createTime;
	
	 /**
     * 修改时间
     */
	@TableField(value="update_time")
	private Date updateTime;
	
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

	public String getUserSalt() {
		return userSalt;
	}

	public void setUserSalt(String userSalt) {
		this.userSalt = userSalt;
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

	public String getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(String userRoleId) {
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

	public String getUpdator() {
		return updator;
	}

	public void setUpdator(String updator) {
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
	protected Serializable pkVal() {
		return this.userId;
	}
	
	
}
