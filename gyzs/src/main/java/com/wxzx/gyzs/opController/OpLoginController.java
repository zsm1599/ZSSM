package com.wxzx.gyzs.opController;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ---------------------------------------------------------------
 * <p/>
 * 项目名称:  gyzs
 * <p/>
 * 类名称:    com.wxzx.gyzs.opController.LoginController
 * 功    能:
 * -----------------------------------------------------------------
 * 创建人：   zhaosiming
 * <p/>
 * 创建时间： 2019/1/26 16:01
 * 版本号：   1.0
 * <p/>
 * 修改人：   zhaosiming
 * 修改时间： 2019/1/26 16:01
 * 版本号：   1.0
 * 修改原因：
 * <p/>
 * 复审人：
 * 复审时间：
 * -------------------------------------------------------------
 */
@Controller
@RequestMapping("/login")
public class OpLoginController {
	private Log logger = LogFactory.getLog(OpLoginController.class);

	@RequestMapping(value = "toLogin",method= RequestMethod.GET)
	public String toLogin(HttpServletRequest request,HttpServletResponse response){

		return "gyzs/op/login/opLogin";
	}

	@RequestMapping(value = "loginOut",method= RequestMethod.GET)
	public String loginOut(HttpServletRequest request,HttpServletResponse response){
		//TODO 登出操作
		return "gyzs/op/login/opLogin";
	}

	@RequestMapping(value = "doLogin",method= RequestMethod.GET)
	public String doLogin(HttpServletRequest request,HttpServletResponse response){
		//TODO 登录操作
		return "";
	}
}
