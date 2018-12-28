package com.wxzx.gyzs.dto.message;

import com.wxzx.gyzs.dto.WxImage;
import com.wxzx.gyzs.dto.WxVoice;

/**
 * ---------------------------------------------------------------
 * <p/>
 * 项目名称:  gyzs
 * <p/>
 * 类名称:    com.wxzx.gyzs.dto.message.VoiceMessage
 * 功    能:  语音消息
 * -----------------------------------------------------------------
 * 创建人：   zhaosiming
 * <p/>
 * 创建时间： 2018/12/27 15:55
 * 版本号：   1.0
 * <p/>
 * 修改人：   zhaosiming
 * 修改时间： 2018/12/27 15:55
 * 版本号：   1.0
 * 修改原因：
 * <p/>
 * 复审人：
 * 复审时间：
 * -------------------------------------------------------------
 */

public class VoiceMessage extends BaseMessage{

	private WxVoice wxVoice;

	public VoiceMessage(){

	}

	public VoiceMessage(String toUserName, String fromUserName,
						long createTime, String msgType, WxVoice wxVoice){
		super();
		ToUserName = toUserName;
		FromUserName = fromUserName;
		CreateTime = createTime;
		MsgType = msgType;
		this.wxVoice = wxVoice;
	}

	public WxVoice getWxVoice() {
		return wxVoice;
	}

	public void setWxVoice(WxVoice wxVoice) {
		this.wxVoice = wxVoice;
	}
}
