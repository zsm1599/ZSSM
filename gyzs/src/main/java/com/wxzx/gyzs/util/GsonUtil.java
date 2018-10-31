package com.wxzx.gyzs.util;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * ---------------------------------------------------------------
 *
 * @copyright Copyright 2014-2016  JR.JD.COM  All Rights Reserved
 * -----------------------------------------------------------------
 * 项目名称:  gyzs
 * <p/>
 * 类名称:    com.wxzx.gyzs.util.GsonUtil
 * 功    能:
 * -----------------------------------------------------------------
 * 创建人：   zhaosiming
 * <p/>
 * 创建时间： 2018/10/30 17:19
 * 版本号：   1.0
 * <p/>
 * 修改人：   zhaosiming
 * 修改时间： 2018/10/30 17:19
 * 版本号：   1.0
 * 修改原因：
 * <p/>
 * 复审人：
 * 复审时间：
 * -------------------------------------------------------------
 */

public class GsonUtil {
	private static Log logger = LogFactory.getLog(GsonUtil.class);
	private static Gson gson = new GsonBuilder()
			.registerTypeAdapter(Date.class, new UtilDateSerializer())
			.registerTypeAdapter(Date.class, new UtilDateDeserializer())
					// .registerTypeAdapter(DateFormat.class, new UtilDateFormatSerializer())
					// .registerTypeAdapter(DateFormat.class, new UtilDateFormatDeserializer())
			.setDateFormat(DateFormat.LONG).create();

	private static final Type STRING_MAP_TYPE = new com.google.gson.reflect.TypeToken<Map<String, String>>() {
	}.getType();

	private static final Type STRING_LIST_TYPE = new com.google.gson.reflect.TypeToken<List<String>>() {
	}.getType();

	private static ThreadLocal<DateFormat> dateFormat = new ThreadLocal<DateFormat>() {
		protected DateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
	};

	/**
	 * @param json  String
	 * @param token example, to get the type for {@code Collection<Foo>}, you
	 *              should use new TypeToken<List<String>>(){}
	 * @return T
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getDomain(String json, TypeToken<T> token) {

		return (T) gson.fromJson(json, token.getType());
	}

	public static JsonElement parseString(String json) {
		if (json != null && json.trim().length() > 0) {
			JsonParser parser = new JsonParser();
			return parser.parse(json);
		}
		return JsonNull.INSTANCE;
	}

	public static Map<String, String> fromJson2StrMap(String json) {
		try {
			return gson.fromJson(json, STRING_MAP_TYPE);
		} catch (Exception e) {
			logger.info("json串转换map异常,json:" + json, e);
			return new HashMap<String, String>(0);
		}
	}


	public static List<String> fromJson2StrList(String json) {
		try {
			return gson.fromJson(json, STRING_LIST_TYPE);
		} catch (Exception e) {
			logger.info("json串转换list异常,json:" + json, e);
			return new ArrayList<String>(0);
		}
	}

	//
	public static String getKeyValue(String key, String jsonStr) {
//
//        HashMap<String,String> map = fromJson(jsonStr, HashMap.class);

//        return map.get(key);

		return getKeyValue(key, parseString(jsonStr));
	}

	public static String getKeyValue(String key, JsonElement element) {

		if (key != null && key.trim().length() > 0 && element != null) {

			JsonObject object = null;
			try {
				if (element.isJsonObject()) {
					object = element.getAsJsonObject();
					element = object.get(key);
					if (element.isJsonPrimitive()) {
						return element.getAsString();
					} else {
						return element.toString();
					}
				}
				return element.toString();
			} catch (Exception e) {
			} finally {
				object = null;
			}
		}
		return null;
	}

	public static String removeKey(String key, JsonElement element) {

		if (key != null && key.trim().length() > 0 && element != null) {

			JsonObject object = null;
			try {
				if (element.isJsonObject()) {
					object = element.getAsJsonObject();
					object.remove(key);
					return object.toString();
				}
				return element.toString();
			} catch (Exception e) {
			} finally {
				object = null;
			}
		}
		return null;
	}

	public static String toJson(Object o) {

		return gson.toJson(o);
	}

	public static String toJsonString(Object o) {

		return gson.toJson(o);
	}

	public static <T> T fromJson(String json, TypeToken<T> token) {

		return (T) gson.fromJson(json, token.getType());
	}

	public static <T> T fromJson(String json, Class<T> classOfT) {

		return (T) gson.fromJson(json, classOfT);
	}

	public static <T> T fromJson(Class<T> classOfT, String json) {

		return (T) gson.fromJson(json, classOfT);
	}

	private static class UtilDateDeserializer implements JsonDeserializer<Date> {

		public Date deserialize(JsonElement json, Type typeOfT,
								JsonDeserializationContext context) throws JsonParseException {

			if (null == json) {
				return null;
			}
			String value = json.getAsString();

			Date date = null;
			if ((null != value) && (!value.trim().equals(""))
					&& (!value.trim().equals("null"))) {
				value = value.trim();
				String format = "yyyy-MM-dd HH:mm:ss";
				try {
					if (value.contains("-")) {
						if (value.length() == 19) {
							format = "yyyy-MM-dd HH:mm:ss";
						} else if (value.length() == 16) {
							format = "yyyy-MM-dd HH:mm";
						} else if (value.length() == 13) {
							format = "yyyy-MM-dd HH";
						} else if (value.length() == 10) {
							format = "yyyy-MM-dd";
						}
					} else if (value.contains(":")) {
						if (value.length() == 8) {
							format = "HH:mm:ss";
						} else if (value.length() == 5) {
							format = "HH:mm";
						}
					} else if (value.length() == 2) {
						format = "HH";
					} else if (value.length() == 4) {
						format = "HHmm";
					} else if (value.length() == 6) {
						format = "HHmmss";
					} else if (value.length() == 8) {
						format = "yyyyMMdd";
					} else if (value.length() == 10) {
						format = "yyyyMMddHH";
					} else if (value.length() == 12) {
						format = "yyyyMMddHHmm";
					} else if (value.length() == 14) {
						format = "yyyyMMddHHmmss";
					} else if (value.length() >= 13 && !value.startsWith("20")) {
						date = new Date(Long.parseLong(value));
						format = null;
					}
					if (null != format) {
						date = new SimpleDateFormat(format).parse(value);
					}
				} catch (ParseException e) {
					e.printStackTrace();
				} finally {
					value = null;
					format = null;
				}
			}
			return date;
		}
	}

	private static class UtilDateSerializer implements JsonSerializer<Date> {

		public JsonElement serialize(Date src, Type typeOfSrc,
									 JsonSerializationContext context) {

			DateFormat format = dateFormat.get();

			return new JsonPrimitive(format.format(src));
		}
	}

	private static class UtilDateFormatSerializer implements
			JsonSerializer<DateFormat> {

		public JsonElement serialize(DateFormat src, Type typeOfSrc,
									 JsonSerializationContext context) {

			return null;
		}
	}

	private static class UtilDateFormatDeserializer implements
			JsonDeserializer<DateFormat> {

		public DateFormat deserialize(JsonElement json, Type typeOfT,
									  JsonDeserializationContext context) throws JsonParseException {

			return null;
		}
	}

	public static void main(String[] args) {
		String bxOrderId = "dddd";
		String a = "{\n" +
				"\"orderId\":\"" + bxOrderId + "\",\n" +
				"\"payId\": \"3490616012214020000802163\",\n" +
				"\"payTime\":\"2016-01-22 14:05:12\",\n" +
				"\"payEnum\": 349,\n" +
				"\"currency\":1,\n" +
				"\"orderConfirmPrice\":33,\n" +
				"\"confirmType\":\"createPay\",\n" +
				"\"confirmResultType\":\"full\",\n" +
				"\"pin\":\"jd_5a3d99fe0f6e0\",\n" +
				"\"orderConfirmTime\":\"2016-01-22 14:05:12\",\n" +
				"\"orderConfirmId\":\"0016012225747593698925563327002766562\",\n" +
				"\"orderType\":82,\n" +
				"\"ver\":0,\n" +
				"\"priceProtect\":0,\n" +
				"\"realDuePrice\":33,\n" +
				"\"realPayPrice\":33,\n" +
				"\"paidIn\": 33,\n" +
				"\"auditStatus\":0,\n" +
				"\"lastOrderBankStatus\": 1,\n" +
				"\"refundType\":0,\n" +
				"\"payMode\":4,\n" +
				"\"price\":33,\n" +
				"\"orderbankCreateSource\": \"createOrder\",\n" +
				"\"payMoney\":33,\n" +
				"\"merchantId\":\"82\",\n" +
				"\"merchantOrderNo\":\"82160122257475936989\"\n" +
				"}";


		System.out.println(a.trim().replaceAll("\n", ""));
		System.out.println(a.trim().replaceAll("\n", "").charAt(93));
		System.out.println(getKeyValue("realDuePrice", a).trim());
	}
}
