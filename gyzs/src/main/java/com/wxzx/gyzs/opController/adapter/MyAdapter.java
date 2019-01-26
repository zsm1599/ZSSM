package com.wxzx.gyzs.opController.adapter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * ---------------------------------------------------------------
 * <p/>
 * 项目名称:  gyzs
 * <p/>
 * 类名称:    com.wxzx.gyzs.opController.adapter.MyAdapter
 * 功    能:
 * -----------------------------------------------------------------
 * 创建人：   zhaosiming
 * <p/>
 * 创建时间： 2019/1/26 17:03
 * 版本号：   1.0
 * <p/>
 * 修改人：   zhaosiming
 * 修改时间： 2019/1/26 17:03
 * 版本号：   1.0
 * 修改原因：WebMvcConfigurerAdapter使用时提示已过时，看网上建议使用WebMvcConfigurationSupport，
 * 			但使用这个会是springboot的自动配置有问题：@ConditionalOnMissingBean(WebMvcConfigurationSupport.class)。所以建议实现 implements WebMvcConfigurer。
 * <p/>
 * 复审人：
 * 复审时间：
 * -------------------------------------------------------------
 */
@Configuration
public class MyAdapter implements WebMvcConfigurer {
	private static final Log logger = LogFactory.getLog(MyAdapter.class);

	@Bean
	public LoginInterceptor webIntercrptor(){
		return new LoginInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		logger.info("-------------addInterceptors--------------");
		registry.addInterceptor(webIntercrptor()).addPathPatterns("/op/**");
	}
	//注入视图处理器bean
	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver resourceViewResolver=new InternalResourceViewResolver();
		resourceViewResolver.setPrefix("/view/");
		resourceViewResolver.setSuffix(".html");
		resourceViewResolver.setViewClass(JstlView.class);
		return resourceViewResolver;
	}

	//添加文件是暴露路径和文件的实际访问路径
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/view").addResourceLocations("/");
//	}
}
