package com.wxzx.gyzs.domain;

/**
 * ---------------------------------------------------------------
 * <p/>
 * 项目名称:  gyzs
 * <p/>
 * 类名称:    com.wxzx.gyzs.domain.HouseRelation
 * 功    能:
 * -----------------------------------------------------------------
 * 创建人：   zhaosiming
 * <p/>
 * 创建时间： 2019/1/26 14:58
 * 版本号：   1.0
 * <p/>
 * 修改人：   zhaosiming
 * 修改时间： 2019/1/26 14:58
 * 版本号：   1.0
 * 修改原因：
 * <p/>
 * 复审人：
 * 复审时间：
 * -------------------------------------------------------------
 */

public class HouseRelation extends BaseDomain {

	private Long baseInfoId;

	private Long otherInfoId;

	public Long getBaseInfoId() {
		return baseInfoId;
	}

	public void setBaseInfoId(Long baseInfoId) {
		this.baseInfoId = baseInfoId;
	}

	public Long getOtherInfoId() {
		return otherInfoId;
	}

	public void setOtherInfoId(Long otherInfoId) {
		this.otherInfoId = otherInfoId;
	}
}
