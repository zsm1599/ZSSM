package com.wxzx.gyzs.util;

import com.thoughtworks.xstream.XStream;
import com.wxzx.gyzs.dto.WxImage;
import com.wxzx.gyzs.dto.message.ImageMessage;

import java.util.Date;

/**
 * ---------------------------------------------------------------
 * <p/>
 * 项目名称:  gyzs
 * <p/>
 * 类名称:    com.wxzx.gyzs.util.ImageMessageUtil
 * 功    能:
 * -----------------------------------------------------------------
 * 创建人：   zhaosiming
 * <p/>
 * 创建时间： 2018/12/27 16:40
 * 版本号：   1.0
 * <p/>
 * 修改人：   zhaosiming
 * 修改时间： 2018/12/27 16:40
 * 版本号：   1.0
 * 修改原因：
 * <p/>
 * 复审人：
 * 复审时间：
 * -------------------------------------------------------------
 */

public class ImageMessageUtil implements BaseMessageUtil<ImageMessage>{

	/**
	 * 将信息转为xml格式
	 */
	public String messageToxml(ImageMessage imageMessage) {
		XStream xtream = new XStream();
		xtream.alias("xml", imageMessage.getClass());
		xtream.alias("Image", new WxImage().getClass());
		return xtream.toString();
	}
	/**
	 * 封装信息
	 */
	public String initMessage(String FromUserName, String ToUserName, String mediaId) {
		WxImage image = new WxImage();
		image.setMediaId(mediaId);
		ImageMessage message = new ImageMessage();
		message.setFromUserName(ToUserName);
		message.setToUserName(FromUserName);
		message.setCreateTime(new Date().getTime());
		message.setWxImage(image);
		return messageToxml(message);
	}
}
