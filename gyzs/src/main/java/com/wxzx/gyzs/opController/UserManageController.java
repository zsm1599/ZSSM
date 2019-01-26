package com.wxzx.gyzs.opController;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * ---------------------------------------------------------------
 * <p/>
 * 项目名称:  gyzs
 * <p/>
 * 类名称:    com.wxzx.gyzs.opController.UserManageController
 * 功    能:
 * -----------------------------------------------------------------
 * 创建人：   zhaosiming
 * <p/>
 * 创建时间： 2019/1/26 18:09
 * 版本号：   1.0
 * <p/>
 * 修改人：   zhaosiming
 * 修改时间： 2019/1/26 18:09
 * 版本号：   1.0
 * 修改原因：
 * <p/>
 * 复审人：
 * 复审时间：
 * -------------------------------------------------------------
 */
@Controller
@RequestMapping("/op/userManage")
public class UserManageController {
	private Log logger = LogFactory.getLog(UserManageController.class);

	@RequestMapping("index")
	public String index(HttpServletRequest request) throws Exception{
		logger.info("index");
		return "gyzs/op/userManage/index";
	}
}
