package com.wxzx.gyzs.domain;

import com.wxzx.gyzs.enums.EmHouseType;

/**
 * ---------------------------------------------------------------
 * <p/>
 * 项目名称:  gyzs
 * <p/>
 * 类名称:    com.wxzx.gyzs.domain.HouseBaseInfo
 * 功    能:
 * -----------------------------------------------------------------
 * 创建人：   zhaosiming
 * <p/>
 * 创建时间： 2019/1/26 14:17
 * 版本号：   1.0
 * <p/>
 * 修改人：   zhaosiming
 * 修改时间： 2019/1/26 14:17
 * 版本号：   1.0
 * 修改原因：
 * <p/>
 * 复审人：
 * 复审时间：
 * -------------------------------------------------------------
 */

public class HouseBaseInfo extends BaseDomain{

	private EmHouseType houseType;

	private String houseArea;

	private String houseAddress;

	private String houseMemo;

	private Long otherInfoId;

	public EmHouseType getHouseType() {
		return houseType;
	}

	public void setHouseType(EmHouseType houseType) {
		this.houseType = houseType;
	}

	public String getHouseArea() {
		return houseArea;
	}

	public void setHouseArea(String houseArea) {
		this.houseArea = houseArea;
	}

	public String getHouseAddress() {
		return houseAddress;
	}

	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}

	public String getHouseMemo() {
		return houseMemo;
	}

	public void setHouseMemo(String houseMemo) {
		this.houseMemo = houseMemo;
	}

	public Long getOtherInfoId() {
		return otherInfoId;
	}

	public void setOtherInfoId(Long otherInfoId) {
		this.otherInfoId = otherInfoId;
	}
}
