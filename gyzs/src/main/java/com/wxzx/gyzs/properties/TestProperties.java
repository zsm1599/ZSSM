package com.wxzx.gyzs.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------------
 * <p/>
 * 项目名称:  gyzs
 * <p/>
 * 类名称:    com.wxzx.gyzs.properties.TestProperties
 * 功    能:
 * -----------------------------------------------------------------
 * 创建人：   zhaosiming
 * <p/>
 * 创建时间： 2018/10/31 15:50
 * 版本号：   1.0
 * <p/>
 * 修改人：   zhaosiming
 * 修改时间： 2018/10/31 15:50
 * 版本号：   1.0
 * 修改原因：
 * <p/>
 * 复审人：
 * 复审时间：
 * -------------------------------------------------------------
 */
@Component
@ConfigurationProperties(prefix="wx")
@PropertySource("classpath:system.properties")
public class TestProperties {

	private String appId;
	private String appSecret;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
}
