package com.wxzx.gyzs.util;

import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * ---------------------------------------------------------------
 * <p/>
 * 项目名称:  gyzs
 * <p/>
 * 类名称:    com.wxzx.gyzs.util.WeiXinUtil
 * 功    能:
 * -----------------------------------------------------------------
 * 创建人：   zhaosiming
 * <p/>
 * 创建时间： 2018/12/28 11:31
 * 版本号：   1.0
 * <p/>
 * 修改人：   zhaosiming
 * 修改时间： 2018/12/28 11:31
 * 版本号：   1.0
 * 修改原因：
 * <p/>
 * 复审人：
 * 复审时间：
 * -------------------------------------------------------------
 */

public class WeiXinUtil {
	/**
	 * 处理doget请求
	 * @param url
	 * @return
	 */
	public static JSONObject doGetstr(String url){
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		JSONObject jsonObject = null;
		try {
			CloseableHttpResponse response = httpclient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			if(entity!=null){
				String result = EntityUtils.toString(entity);
				jsonObject = JSONObject.fromObject(result);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonObject;

	}
	/**
	 * 处理post请求
	 * @param url
	 * @return
	 */
	public static JSONObject doPoststr(String url,String outStr){
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		JSONObject jsonObject = null;
		try {
			httpPost.setEntity(new StringEntity(outStr, "utf-8"));
			CloseableHttpResponse response = httpclient.execute(httpPost);
			String result = EntityUtils.toString(response.getEntity(),"utf-8");
			jsonObject =JSONObject.fromObject(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}
}
