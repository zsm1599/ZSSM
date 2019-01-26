package com.wxzx.gyzs.domain;

/**
 * ---------------------------------------------------------------
 * <p/>
 * 项目名称:  gyzs
 * <p/>
 * 类名称:    com.wxzx.gyzs.domain.HouseOtherInfo
 * 功    能:
 * -----------------------------------------------------------------
 * 创建人：   zhaosiming
 * <p/>
 * 创建时间： 2019/1/26 14:42
 * 版本号：   1.0
 * <p/>
 * 修改人：   zhaosiming
 * 修改时间： 2019/1/26 14:42
 * 版本号：   1.0
 * 修改原因：
 * <p/>
 * 复审人：
 * 复审时间：
 * -------------------------------------------------------------
 */

public class HouseOtherInfo extends BaseDomain {

	private String houseThumbnailPre;

	private String houseThumbnail;

	private String houseActualPre;

	private String houseActual;

	private String decorateStyle;

	private String decorateLevel;

	private String decorateCost;

	private Long baseInfoId;

	public String getHouseThumbnailPre() {
		return houseThumbnailPre;
	}

	public void setHouseThumbnailPre(String houseThumbnailPre) {
		this.houseThumbnailPre = houseThumbnailPre;
	}

	public String getHouseThumbnail() {
		return houseThumbnail;
	}

	public void setHouseThumbnail(String houseThumbnail) {
		this.houseThumbnail = houseThumbnail;
	}

	public String getHouseActualPre() {
		return houseActualPre;
	}

	public void setHouseActualPre(String houseActualPre) {
		this.houseActualPre = houseActualPre;
	}

	public String getHouseActual() {
		return houseActual;
	}

	public void setHouseActual(String houseActual) {
		this.houseActual = houseActual;
	}

	public String getDecorateStyle() {
		return decorateStyle;
	}

	public void setDecorateStyle(String decorateStyle) {
		this.decorateStyle = decorateStyle;
	}

	public String getDecorateLevel() {
		return decorateLevel;
	}

	public void setDecorateLevel(String decorateLevel) {
		this.decorateLevel = decorateLevel;
	}

	public String getDecorateCost() {
		return decorateCost;
	}

	public void setDecorateCost(String decorateCost) {
		this.decorateCost = decorateCost;
	}

	public Long getBaseInfoId() {
		return baseInfoId;
	}

	public void setBaseInfoId(Long baseInfoId) {
		this.baseInfoId = baseInfoId;
	}
}
