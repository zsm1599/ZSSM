package com.wxzx.gyzs.domain;

/**
 * ---------------------------------------------------------------
 *
 * @copyright Copyright 2014-2016  JR.JD.COM  All Rights Reserved
 * -----------------------------------------------------------------
 * 项目名称:  gyzs
 * <p/>
 * 类名称:    com.wxzx.gyzs.domain.Room
 * 功    能:
 * -----------------------------------------------------------------
 * 创建人：   zhaosiming
 * <p/>
 * 创建时间： 2018/10/30 13:47
 * 版本号：   1.0
 * <p/>
 * 修改人：   zhaosiming
 * 修改时间： 2018/10/30 13:47
 * 版本号：   1.0
 * 修改原因：
 * <p/>
 * 复审人：
 * 复审时间：
 * -------------------------------------------------------------
 */

public class Room extends BaseDomain {

	//屋名字
	private String roomName;
	//房屋唯一标识，用于标识该屋属于哪套房子
	private String houseId;
	//屋长
	private String roomLong;
	//屋宽
	private String roomWidth;
	//屋面积
	private String roomArea;
	//屋图片存放路径(可多张)
	private String picturePath;

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getHouseId() {
		return houseId;
	}

	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}

	public String getRoomLong() {
		return roomLong;
	}

	public void setRoomLong(String roomLong) {
		this.roomLong = roomLong;
	}

	public String getRoomWidth() {
		return roomWidth;
	}

	public void setRoomWidth(String roomWidth) {
		this.roomWidth = roomWidth;
	}

	public String getRoomArea() {
		return roomArea;
	}

	public void setRoomArea(String roomArea) {
		this.roomArea = roomArea;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
}
