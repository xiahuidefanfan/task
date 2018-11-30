package com.team.tool.task.bean.condition;

/**
 * @ClassName: BaseCondition.java
 * @Description: 基础查询条件封装
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月30日 下午8:29:41 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月30日     xiahui           v1.0.0               修改原因
 */
public class BaseCondition {
	
	/**
	 * 每页多少条数据
	 */
	private Integer pageSize;
	
	/**
	 * 页码
	 */
    private Integer pageNumber;

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

}
