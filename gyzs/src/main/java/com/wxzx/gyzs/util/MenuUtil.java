package com.wxzx.gyzs.util;

import com.wxzx.gyzs.dto.WxButton;
import com.wxzx.gyzs.dto.WxClickButton;
import com.wxzx.gyzs.dto.WxMenu;
import com.wxzx.gyzs.dto.WxViewButton;
import net.sf.json.JSONObject;

/**
 * ---------------------------------------------------------------
 * <p/>
 * 项目名称:  gyzs
 * <p/>
 * 类名称:    com.wxzx.gyzs.util.MenuUtil
 * 功    能:  菜单工具
 * -----------------------------------------------------------------
 * 创建人：   zhaosiming
 * <p/>
 * 创建时间： 2018/12/28 11:26
 * 版本号：   1.0
 * <p/>
 * 修改人：   zhaosiming
 * 修改时间： 2018/12/28 11:26
 * 版本号：   1.0
 * 修改原因：
 * <p/>
 * 复审人：
 * 复审时间：
 * -------------------------------------------------------------
 */

public class MenuUtil {
	private static final String CTRATE_MENU_URL  = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	/**
	 * 创建菜单
	 * @param accessToken token
	 * @param Menu 菜单json格式字符串
	 * @return
	 */
	public static int createMenu(String accessToken,String Menu){
		int result = Integer.MIN_VALUE;
		String url = CTRATE_MENU_URL.replaceAll("ACCESS_TOKEN", accessToken);
		JSONObject json = WeiXinUtil.doPoststr(url, Menu);
		if(json!=null){
			//从返回的数据包中取数据{"errcode":0,"errmsg":"ok"}
			result = json.getInt("errcode");
		}
		return result;
	}

	public static String initMenu(){
		String result = "";
		//创建点击一级菜单
		WxClickButton button11 = new WxClickButton();
		button11.setName("往期活动");
		button11.setKey("11");
		button11.setType("click");

		//创建跳转型一级菜单
		WxViewButton button21 = new WxViewButton();
		button21.setName("百度一下");
		button21.setType("view");
		button21.setUrl("https://www.baidu.com");

		//创建其他类型的菜单与click型用法一致
		WxClickButton button31 = new WxClickButton();
		button31.setName("拍照发图");
		button31.setType("pic_photo_or_album");
		button31.setKey("31");

		WxClickButton button32 = new WxClickButton();
		button32.setName("发送位置");
		button32.setKey("32");
		button32.setType("location_select");

		//封装到一级菜单
		WxButton button = new WxButton();
		button.setName("菜单");
		button.setType("click");
		button.setSub_button(new WxButton[]{button31,button32});

		//封装菜单
		WxMenu menu = new WxMenu();
		menu.setButton(new WxButton[]{button11, button21, button});
//		menu.setButton(new WxButton[]{button11, button21});
		return JSONObject.fromObject(menu).toString();
	}
}
