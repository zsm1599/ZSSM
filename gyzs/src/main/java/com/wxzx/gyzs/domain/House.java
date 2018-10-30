package com.wxzx.gyzs.domain;

import com.wxzx.gyzs.enums.EmDecorationType;
import com.wxzx.gyzs.enums.EmHouseType;

import java.math.BigDecimal;

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

public class House extends BaseDomain{

	//房屋位置
	private String address;
	//房屋户型  如两室一厅
	private EmHouseType houseType;
	//房屋长
	private String houseLong;
	//房屋宽
	private String houseWidth;
	//房屋面积
	private String houseArea;
	//房屋图片存放路径(一张，所以最好放户型图)
	private String picturePath;
	//房屋装修价格
	private BigDecimal price;
	//房屋类型(简单、中等、高级、豪华)
	private EmDecorationType decorationType;
	//房屋唯一标识，用于关联卧室客厅等
	private String houseId;
	//是否展示
	private Boolean isShow;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public EmHouseType getHouseType() {
		return houseType;
	}

	public void setHouseType(EmHouseType houseType) {
		this.houseType = houseType;
	}

	public String getHouseLong() {
		return houseLong;
	}

	public void setHouseLong(String houseLong) {
		this.houseLong = houseLong;
	}

	public String getHouseWidth() {
		return houseWidth;
	}

	public void setHouseWidth(String houseWidth) {
		this.houseWidth = houseWidth;
	}

	public String getHouseArea() {
		return houseArea;
	}

	public void setHouseArea(String houseArea) {
		this.houseArea = houseArea;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public EmDecorationType getDecorationType() {
		return decorationType;
	}

	public void setDecorationType(EmDecorationType decorationType) {
		this.decorationType = decorationType;
	}

	public String getHouseId() {
		return houseId;
	}

	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}

	public Boolean getIsShow() {
		return isShow;
	}

	public void setIsShow(Boolean isShow) {
		this.isShow = isShow;
	}
}
