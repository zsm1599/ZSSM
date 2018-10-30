package com.wxzx.gyzs.enums;

/**
 * ---------------------------------------------------------------
 *
 * @copyright Copyright 2014-2016  JR.JD.COM  All Rights Reserved
 * -----------------------------------------------------------------
 * 项目名称:  gyzs
 * <p/>
 * 类名称:    com.wxzx.gyzs.enums.EmDistrict
 * 功    能:
 * -----------------------------------------------------------------
 * 创建人：   zhaosiming
 * <p/>
 * 创建时间： 2018/10/29 20:15
 * 版本号：   1.0
 * <p/>
 * 修改人：   zhaosiming
 * 修改时间： 2018/10/29 20:15
 * 版本号：   1.0
 * 修改原因：
 * <p/>
 * 复审人：
 * 复审时间：
 * -------------------------------------------------------------
 */

public enum EmDistrict {

	ALL("","所有区"),
	SHQ("SHQ","沈河区"),
	HPQ("HPQ","和平区"),
	DDQ("DDQ","大东区"),
	HGQ("HGQ","皇姑区"),
	TXQ("TXQ","铁西区"),
	SJTQ("SJTQ","苏家屯区"),
	DLQ("DLQ","东陵区"),
	SBXQ("SBXQ","沈北新区"),
	YHQ("YHQ","于洪区"),
	HNXQ("HNXQ","浑南新区"),
	XMS("XMS","新民市"),
	LZX("LZX","辽中县"),
	KPX("KPX","康平县"),
	FKX("FKX","法库县"),
	;

	private String district;

	private String districtDesc;

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getDistrictDesc() {
		return districtDesc;
	}

	public void setDistrictDesc(String districtDesc) {
		this.districtDesc = districtDesc;
	}

	private EmDistrict(String district, String districtDesc){
		this.setDistrict(district);
		this.setDistrictDesc(districtDesc);
	}
}
