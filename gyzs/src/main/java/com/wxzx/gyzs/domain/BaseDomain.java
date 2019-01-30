package com.wxzx.gyzs.domain;

import java.util.Date;

/**
 * ---------------------------------------------------------------
 *
 * @copyright Copyright 2014-2016  JR.JD.COM  All Rights Reserved
 * -----------------------------------------------------------------
 * 项目名称:  gyzs
 * <p/>
 * 类名称:    com.wxzx.gyzs.domain.BaseDomain
 * 功    能:
 * -----------------------------------------------------------------
 * 创建人：   zhaosiming
 * <p/>
 * 创建时间： 2018/10/30 13:35
 * 版本号：   1.0
 * <p/>
 * 修改人：   zhaosiming
 * 修改时间： 2018/10/30 13:35
 * 版本号：   1.0
 * 修改原因：
 * <p/>
 * 复审人：
 * 复审时间：
 * -------------------------------------------------------------
 */

public class BaseDomain {

	private Long id;

	private Date createdTime;

	private Date modifiedTime;

	private String createOperator;

	private String updateOperator;

	private Boolean yn;

	private Integer version;

	private String remark;

	private String extendParams;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getCreateOperator() {
		return createOperator;
	}

	public void setCreateOperator(String createOperator) {
		this.createOperator = createOperator;
	}

	public String getUpdateOperator() {
		return updateOperator;
	}

	public void setUpdateOperator(String updateOperator) {
		this.updateOperator = updateOperator;
	}

	public Boolean getYn() {
		return yn;
	}

	public void setYn(Boolean yn) {
		this.yn = yn;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getExtendParams() {
		return extendParams;
	}

	public void setExtendParams(String extendParams) {
		this.extendParams = extendParams;
	}
}
