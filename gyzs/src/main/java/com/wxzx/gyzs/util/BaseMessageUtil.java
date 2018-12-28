package com.wxzx.gyzs.util;

/**
 * ---------------------------------------------------------------
 * <p/>
 * 项目名称:  gyzs
 * <p/>
 * 类名称:    com.wxzx.gyzs.util.BaseMessageUtil
 * 功    能:  消息封装工具类的基类,这里采用泛型,方便后期功能扩展
 * -----------------------------------------------------------------
 * 创建人：   zhaosiming
 * <p/>
 * 创建时间： 2018/12/27 14:01
 * 版本号：   1.0
 * <p/>
 * 修改人：   zhaosiming
 * 修改时间： 2018/12/27 14:01
 * 版本号：   1.0
 * 修改原因：
 * <p/>
 * 复审人：
 * 复审时间：
 * -------------------------------------------------------------
 */

public interface BaseMessageUtil <T>{
	/**
	 * 将回复的信息对象转xml格式给微信
	 * @return
	 */
	public abstract String messageToxml(T t);

	/**
	 * 回复的信息封装
	 * @return
	 */
	public abstract String initMessage(String fromUserName,String toUserName, String content);
}
