package com.wxzx.gyzs.enums;

/**
 * ---------------------------------------------------------------
 *
 * @copyright Copyright 2014-2016  JR.JD.COM  All Rights Reserved
 * -----------------------------------------------------------------
 * 项目名称:  gyzs
 * <p/>
 * 类名称:    com.wxzx.gyzs.enums.EmDecorationType
 * 功    能:
 * -----------------------------------------------------------------
 * 创建人：   zhaosiming
 * <p/>
 * 创建时间： 2018/10/30 11:21
 * 版本号：   1.0
 * <p/>
 * 修改人：   zhaosiming
 * 修改时间： 2018/10/30 11:21
 * 版本号：   1.0
 * 修改原因：
 * <p/>
 * 复审人：
 * 复审时间：
 * -------------------------------------------------------------
 */

public enum EmDecorationType {

	All("","所有装修类型"),
	EASY("EASY","简单装修"),
	MIDDLE("MIDDLE","中等装修"),
	HIGH("HIGH","高等装修"),
	LUXURY("LUXURY","豪华装修"),
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

	private EmDecorationType(String type, String desc){
		this.setType(type);
		this.setDesc(desc);
	}
}
