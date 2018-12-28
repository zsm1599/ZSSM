package com.wxzx.gyzs.dto.message;

import com.wxzx.gyzs.dto.WxImage;

/**
 * ---------------------------------------------------------------
 * <p/>
 * 项目名称:  gyzs
 * <p/>
 * 类名称:    com.wxzx.gyzs.dto.message.ImageMessage
 * 功    能:
 * -----------------------------------------------------------------
 * 创建人：   zhaosiming
 * <p/>
 * 创建时间： 2018/12/27 15:42
 * 版本号：   1.0
 * <p/>
 * 修改人：   zhaosiming
 * 修改时间： 2018/12/27 15:42
 * 版本号：   1.0
 * 修改原因：
 * <p/>
 * 复审人：
 * 复审时间：
 * -------------------------------------------------------------
 */

public class ImageMessage extends BaseMessage{

	private WxImage wxImage;

	public ImageMessage(){

	}

	public ImageMessage(String toUserName, String fromUserName,
						long createTime, String msgType, WxImage wxImage){
		super();
		ToUserName = toUserName;
		FromUserName = fromUserName;
		CreateTime = createTime;
		MsgType = msgType;
		this.wxImage = wxImage;
	}

	public WxImage getWxImage() {
		return wxImage;
	}

	public void setWxImage(WxImage wxImage) {
		this.wxImage = wxImage;
	}
}
