package com.wxzx.gyzs.domain;

/**
 * ---------------------------------------------------------------
 *
 * @copyright Copyright 2014-2016  JR.JD.COM  All Rights Reserved
 * -----------------------------------------------------------------
 * 项目名称:  gyzs
 * <p/>
 * 类名称:    com.wxzx.gyzs.domain.House
 * 功    能:
 * -----------------------------------------------------------------
 * 创建人：   zhaosiming
 * <p/>
 * 创建时间： 2018/10/29 21:03
 * 版本号：   1.0
 * <p/>
 * 修改人：   zhaosiming
 * 修改时间： 2018/10/29 21:03
 * 版本号：   1.0
 * 修改原因：
 * <p/>
 * 复审人：
 * 复审时间：
 * -------------------------------------------------------------
 */

public class House {

	private HouseBaseInfo houseBaseInfo;

	private HouseOtherInfo houseOtherInfo;

	public HouseBaseInfo getHouseBaseInfo() {
		return houseBaseInfo;
	}

	public void setHouseBaseInfo(HouseBaseInfo houseBaseInfo) {
		this.houseBaseInfo = houseBaseInfo;
	}

	public HouseOtherInfo getHouseOtherInfo() {
		return houseOtherInfo;
	}

	public void setHouseOtherInfo(HouseOtherInfo houseOtherInfo) {
		this.houseOtherInfo = houseOtherInfo;
	}
}
