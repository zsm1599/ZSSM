package com.wxzx.gyzs.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * ---------------------------------------------------------------
 *
 * @copyright Copyright 2014-2016  JR.JD.COM  All Rights Reserved
 * -----------------------------------------------------------------
 * 项目名称:  gyzs
 * <p/>
 * 类名称:    com.wxzx.gyzs.util.PropertiesUtil
 * 功    能:
 * -----------------------------------------------------------------
 * 创建人：   zhaosiming
 * <p/>
 * 创建时间： 2018/10/29 20:59
 * 版本号：   1.0
 * <p/>
 * 修改人：   zhaosiming
 * 修改时间： 2018/10/29 20:59
 * 版本号：   1.0
 * 修改原因：
 * <p/>
 * 复审人：
 * 复审时间：
 * -------------------------------------------------------------
 */

public class PropertiesUtil {
	private static final Log logger = LogFactory.getLog(PropertiesUtil.class);

	private static Map<String,PropertiesUtil> map = new HashMap<String,PropertiesUtil>();
	private Properties pros ;

	private PropertiesUtil(Properties pros){
		this.pros = pros;
	}

	/**
	 *<p>Description:静态加载属性文件</p>
	 * @Title: load
	 * @param filePath	文件路径
	 * @return	 config 返回Config 对象
	 * @author wangkang
	 */
	public static PropertiesUtil load(String filePath){
		if(map.containsKey(filePath)){
			logger.debug("配置文件:"+filePath+"已加载");
		}else{
			logger.debug("加载"+filePath+"配置文件");
			InputStream input = null;
			InputStreamReader reader = null;
			try {
//				String path = PropertiesUtil.class.getResource("/").getPath() + filePath;
//				System.out.println("配置文件path:"+path);
//				InputStream input =new FileInputStream(path);
				input = Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
				reader = new InputStreamReader(input, "UTF-8");
				Properties _pros = new Properties();
				_pros.load(reader);
				//_pros.load(input);
				map.put(filePath, new PropertiesUtil(_pros));
			} catch (IOException e) {
				//为书写方便, 不抛出异常,结果返回null
				logger.error("加载"+filePath+"配置文件异常",e);
			}finally{
				try {
					if(input != null){
						input.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					if(reader != null){
						reader.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return map.get(filePath);
	}

	/**
	 *<p>Description:取得Config中的属性值</p>
	 * @Title: getProValue
	 * @param key
	 * @return
	 * @author wangkang
	 */
	public String getProValue(String key){
		return pros.getProperty(key);
	}

	public String getProValueFormat(String key,Object... obj){
		String str = pros.getProperty(key);
		return MessageFormat.format(str, obj);
	}

	public static void main(String[] args) {

	}
}
