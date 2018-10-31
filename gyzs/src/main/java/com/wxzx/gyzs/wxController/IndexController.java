package com.wxzx.gyzs.wxController;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * ---------------------------------------------------------------
 *
 * @copyright Copyright 2014-2016  JR.JD.COM  All Rights Reserved
 * -----------------------------------------------------------------
 * 项目名称:  gyzs
 * <p/>
 * 类名称:    com.wxzx.gyzs.wxController.IndexController
 * 功    能:
 * -----------------------------------------------------------------
 * 创建人：   zhaosiming
 * <p/>
 * 创建时间： 2018/10/31 9:56
 * 版本号：   1.0
 * <p/>
 * 修改人：   zhaosiming
 * 修改时间： 2018/10/31 9:56
 * 版本号：   1.0
 * 修改原因：
 * <p/>
 * 复审人：
 * 复审时间：
 * -------------------------------------------------------------
 */
@Controller
@RequestMapping("index")
public class IndexController {

	private Log logger = LogFactory.getLog(IndexController.class);

	@RequestMapping("welcome")
	public String welcome(HttpServletRequest request) throws Exception{
		logger.info("welcome");
		return "welcome";
	}

	@RequestMapping("welcome2")
	public String welcome2(HttpServletRequest request) throws Exception{
		logger.info("welcome2");
		return "gyzs/index/welcome";
	}

	@RequestMapping("welcomeWord")
	@ResponseBody
	public String welcomeWord(HttpServletRequest request) throws Exception{
		logger.info("welcomeWord");
		return "hello world";
	}
}
