package com.wxzx.gyzs.opController.adapter;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * ---------------------------------------------------------------
 * <p/>
 * 项目名称:  gyzs
 * <p/>
 * 类名称:    com.wxzx.gyzs.opController.adapter.LoginInterceptor
 * 功    能:  登录拦截
 * -----------------------------------------------------------------
 * 创建人：   zhaosiming
 * <p/>
 * 创建时间： 2019/1/26 16:52
 * 版本号：   1.0
 * <p/>
 * 修改人：   zhaosiming
 * 修改时间： 2019/1/26 16:52
 * 版本号：   1.0
 * 修改原因：
 * <p/>
 * 复审人：
 * 复审时间：
 * -------------------------------------------------------------
 */
@Service
public class LoginInterceptor extends HandlerInterceptorAdapter {
	private static final Log logger = LogFactory.getLog(LoginInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		logger.info("------运营后台页面预处理------");
		//获取session
		HttpSession session = request.getSession(true);
		//判断用户Name是否存在，不存在就跳转到登录界面
		if(null == session.getAttribute("opUserName") || StringUtils.isBlank((String)session.getAttribute("opUserName"))){
			//System.out.println("这是路径地址："+request.getRequestURI());
			response.sendRedirect("/gyzs/login/toLogin");
			return false;
		}else if("admin".equals(session.getAttribute("opUserName"))){//管理员只能进行用户管理
			response.sendRedirect("/gyzs/op/userManage/index");
			return false;
		}else{
			session.setAttribute("opUserName", session.getAttribute("opUserName"));
			return true;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
						   ModelAndView modelAndView) throws Exception {
		//请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作
	}
}
