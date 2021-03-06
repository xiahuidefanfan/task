package com.team.tool.task.bean.model.system;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

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
 * @ClassName: SystemDict.java
 * @Description: 系统字典
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月19日 下午2:10:15 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月19日     xiahui           v1.0.0           系统字典
 */
@TableName("sys_dict")
public class SystemDict extends Model<SystemDict>{
	
	private static final long serialVersionUID = 1L;

	@TableId(value="dict_id", type= IdType.AUTO)
	@ApiModelProperty(value = "主键id")
	private Integer dictId;
	
	@TableField(value="dict_pid")
	@ApiModelProperty(value = "父级主键")
	private Integer dictPid;
	
	@TableField(value="dict_name")
	@ApiModelProperty(value = "字典名称")
	@NotBlank(message = "字典编号不可为空")
	private String dictName;
	
	@TableField(value="dict_code")
	@ApiModelProperty(value = "字典编码")
	@NotBlank(message = "字典编号不可为空")
	private String dictCode;
	
	@TableField(value="dict_order")
	@ApiModelProperty(value = "字典排序")
	private Integer dictOrder;
	
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
	
	public Integer getDictId() {
		return dictId;
	}

	public void setDictId(Integer dictId) {
		this.dictId = dictId;
	}

	public Integer getDictPid() {
		return dictPid;
	}

	public void setDictPid(Integer dictPid) {
		this.dictPid = dictPid;
	}

	public String getDictName() {
		return dictName;
	}

	public void setDictName(String dictName) {
		this.dictName = dictName;
	}

	public String getDictCode() {
		return dictCode;
	}

	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}

	public Integer getDictOrder() {
		return dictOrder;
	}

	public void setDictOrder(Integer dictOrder) {
		this.dictOrder = dictOrder;
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

	@Override
	protected Serializable pkVal() {
		return dictId;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
