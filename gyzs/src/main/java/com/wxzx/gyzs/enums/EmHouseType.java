package com.wxzx.gyzs.enums;

/**
 * ---------------------------------------------------------------
 *
 * @copyright Copyright 2014-2016  JR.JD.COM  All Rights Reserved
 * -----------------------------------------------------------------
 * 项目名称:  gyzs
 * <p/>
 * 类名称:    com.wxzx.gyzs.enums.EmHouseType
 * 功    能:
 * -----------------------------------------------------------------
 * 创建人：   zhaosiming
 * <p/>
 * 创建时间： 2018/10/29 21:04
 * 版本号：   1.0
 * <p/>
 * 修改人：   zhaosiming
 * 修改时间： 2018/10/29 21:04
 * 版本号：   1.0
 * 修改原因：
 * <p/>
 * 复审人：
 * 复审时间：
 * -------------------------------------------------------------
 */

public enum EmHouseType {

	ALL("","所有户型"),
	YSYT("YSYT","一室一厅"),
	LSYT("LSYT","两室一厅"),
	SSYT("SSYT","三室一厅"),
	SSLT("SSLT","三室两厅"),
	SISYT("SISYT","四室一厅"),
	SISLT("SISLT","四室两厅"),
	MORE("MORE","多居室"),
	;

	private String type;

	private String desc;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	private EmHouseType(String type, String desc){
		this.setType(type);
		this.setDesc(desc);
	}
}
