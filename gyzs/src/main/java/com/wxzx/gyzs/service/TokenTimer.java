package com.wxzx.gyzs.service;

import com.wxzx.gyzs.properties.SystemProperties;
import com.wxzx.gyzs.util.GsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * ---------------------------------------------------------------
 *
 * @copyright Copyright 2014-2016  JR.JD.COM  All Rights Reserved
 * -----------------------------------------------------------------
 * 项目名称:  gyzs
 * <p/>
 * 类名称:    com.wxzx.gyzs.service.TokenTimer
 * 功    能:
 * -----------------------------------------------------------------
 * 创建人：   zhaosiming
 * <p/>
 * 创建时间： 2018/10/30 16:48
 * 版本号：   1.0
 * <p/>
 * 修改人：   zhaosiming
 * 修改时间： 2018/10/30 16:48
 * 版本号：   1.0
 * 修改原因：
 * <p/>
 * 复审人：
 * 复审时间：
 * -------------------------------------------------------------
 */
@Component
@EnableScheduling
public class TokenTimer {
	private static Log logger = LogFactory.getLog(TokenTimer.class);

	private static String accessToken="";

	@Resource
	private SystemProperties systemProperties;

	//@Scheduled(fixedDelay = 5000) 以一个固定延迟时间5秒钟调用一次执行  这个周期是以上一个调用任务的##完成时间##为基准，在上一个任务完成之后，5s后再次执行
	//@Scheduled(fixedRate  = 5000) 以一个固定延迟时间5秒钟调用一次执行  这个周期是以上一个任务##开始时间##为基准，从上一任务开始执行后5s再次调用
	//@Scheduled(cron = "0 34 13 * * ?")  这里是在每天的13点30分执行一次。详细使用上网搜吧
	@Scheduled(fixedDelay=7180000)
	public void setAccessTokenBySchedule() {
		logger.info("==============开始获取access_token===============");
		String grant_type = "client_credential";
		String AppId= systemProperties.getAppId();
		String secret= systemProperties.getAppSecret();
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type="+grant_type+"&appid="+AppId+"&secret="+secret;

		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		Map<String, String> tokenResultMap = new HashMap<>();
		try {
			CloseableHttpResponse response = httpclient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			if(entity!=null){
				String result = EntityUtils.toString(entity);
				logger.info("通过微信获取token结果为:" + result);
				tokenResultMap = GsonUtil.fromJson2StrMap(result);
			}
			if(tokenResultMap != null){
				logger.info("==============开始写入access_token===============");
				accessToken = tokenResultMap.get("access_token");
				logger.info("==============写入access_token成功===============");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getAccessToken() {
		if(StringUtils.isBlank(accessToken)){
			setAccessTokenBySchedule();
		}
		return accessToken;
	}
}
