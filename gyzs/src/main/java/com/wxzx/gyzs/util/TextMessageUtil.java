package com.wxzx.gyzs.util;

import com.thoughtworks.xstream.XStream;
import com.wxzx.gyzs.dto.message.TextMessage;

import java.util.Date;

/**
 * ---------------------------------------------------------------
 * <p/>
 * 项目名称:  gyzs
 * <p/>
 * 类名称:    com.wxzx.gyzs.util.TextMessageUtil
 * 功    能:
 * -----------------------------------------------------------------
 * 创建人：   zhaosiming
 * <p/>
 * 创建时间： 2018/12/27 14:53
 * 版本号：   1.0
 * <p/>
 * 修改人：   zhaosiming
 * 修改时间： 2018/12/27 14:53
 * 版本号：   1.0
 * 修改原因：
 * <p/>
 * 复审人：
 * 复审时间：
 * -------------------------------------------------------------
 */

public class TextMessageUtil implements BaseMessageUtil<TextMessage>{

	/**
	 * 将发送消息封装成对应的xml格式
	 */
	public  String messageToxml(TextMessage message) {
		XStream xstream  = new XStream();
		xstream.alias("xml", message.getClass());
		return xstream.toXML(message);
	}
	/**
	 * 封装发送消息对象,封装时，需要将调换发送者和接收者的关系
	 */
	public  String initMessage(String fromUserName, String toUserName, String content) {
		TextMessage text = new TextMessage();
		text.setToUserName(fromUserName);
		text.setFromUserName(toUserName);
		text.setContent("您输入的内容是：" + content);
		text.setCreateTime(new Date().getTime());
		text.setMsgType("text");
		return  messageToxml(text);
	}
}
