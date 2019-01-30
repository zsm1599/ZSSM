package com.wxzx.gyzs.opController;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * ---------------------------------------------------------------
 *
 * @copyright Copyright 2014-2016  JR.JD.COM  All Rights Reserved
 * -----------------------------------------------------------------
 * 项目名称:  gyzs
 * <p/>
 * 类名称:    com.wxzx.gyzs.opController.HouseManageController
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
@RequestMapping("/op/house")
public class HouseManageController {
	private Log logger = LogFactory.getLog(HouseManageController.class);

	@RequestMapping("welcome2")
	public String welcome2(HttpServletRequest request) throws Exception{
		logger.info("welcome2");
		return "gyzs/index/welcome";
	}

	@RequestMapping("list")
	public String list(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
					   @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
					   @RequestParam(value = "houseType", required = false) String houseType,
					   @RequestParam(value = "houseAreaStart", required = false) String houseAreaStart,
					   @RequestParam(value = "houseAreaEnd", required = false) String houseAreaEnd,
					   @RequestParam(value = "houseAddress", required = false) String houseAddress,
					   Model model) {



		return "gyzs/op/house/list";
	}
}
