package com.wxzx.gyzs.util;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * ---------------------------------------------------------------
 *
 * @copyright Copyright 2014-2016  JR.JD.COM  All Rights Reserved
 * -----------------------------------------------------------------
 * 项目名称:  gyzs
 * <p/>
 * 类名称:    com.wxzx.gyzs.util.DateUtil
 * 功    能:
 * -----------------------------------------------------------------
 * 创建人：   zhaosiming
 * <p/>
 * 创建时间： 2018/10/29 20:29
 * 版本号：   1.0
 * <p/>
 * 修改人：   zhaosiming
 * 修改时间： 2018/10/29 20:29
 * 版本号：   1.0
 * 修改原因：
 * <p/>
 * 复审人：
 * 复审时间：
 * -------------------------------------------------------------
 */

public class DateUtil {

	public static final String  PARSE_PATTERNS_YYYYMMDD = "yyyyMMdd";
	public static final String  PARSE_PATTERNS_HHMMSS = "HHmmss";
	public static final String  PARSE_PATTERNS_YYYY_MM_DD = "yyyy-MM-dd";
	public static final String  PARSE_PATTERNS_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	public static final String  PARSE_PATTERNS_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	public static final String  PARSE_PATTERNS_YYYYMMDDHHMMSSMILLISECOND = "yyyyMMddHHmmssSSS";

	public static final String[] PARSE_PATTERNS = { PARSE_PATTERNS_YYYYMMDD, PARSE_PATTERNS_YYYY_MM_DD,
			PARSE_PATTERNS_YYYYMMDDHHMMSS, PARSE_PATTERNS_YYYY_MM_DD_HH_MM_SS };

	public static Date parse0(String str) throws ParseException {
		return DateUtils.parseDateStrictly(str, PARSE_PATTERNS);
	}

	public static Date parse0(String str, String... patterns) throws ParseException {
		return DateUtils.parseDateStrictly(str, patterns);
	}

	/**
	 * @param str
	 * @return 转换异常返回 null
	 */
	public static Date parse(String str) {
		try {
			return parse0(str, PARSE_PATTERNS);
		} catch (ParseException e) {
		}
		return null;
	}

	public static String format(Date date, String pattern) {
		return DateFormatUtils.format(date, pattern);
	}

	/**
	 * 将日期格式化为指定的字符串.<br>
	 * <br>
	 * @param d 日期.
	 * @param format 输出字符串格式.
	 * @return 日期字符串
	 */
	public static String getStringFromDate(Date d, String format) {
		if(d == null) return "";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(d);
	}


	/**
	 * 得到与指定日期相差指定天数的日期字符串.<br>
	 * <br>
	 * @param dateString 指定的日期.
	 * @param days 前后的天数，正值为后， 负值为前.
	 * @return 日期字符串
	 */
	public static String getCertainDate(String dateString, int days) {
		Calendar calendar = getCalendar(dateString);
		calendar.add(Calendar.DATE, days);
		return getStringFromDate(calendar.getTime(), FORMAT_DATE);
	}

	private static final String FORMAT_DATE = "yyyy-MM-dd";

	/**
	 * 得到与当前日期相差指定天数的日期字符串.<br>
	 * <br>
	 * @param days 前后的天数，正值为后， 负值为前.
	 * @return 日期字符串
	 */
	public static String getCertainDate(int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, days);
		return getStringFromDate(calendar.getTime(), FORMAT_DATE);
	}


	/**
	 * 获取给定日期的00:00时间戳
	 * @param date 日期
	 */
	public static Date getBeginDate(Date date) {
		if (null == date) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}


	/**
	 * 获取给定日期的00:00时间戳
	 * @param date 日期
	 */
	public static Date get15Clock(Date date) {
		if (null == date) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 15);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}


	public static Date getPreviousZeroDate(Date date) {
		if (null == date) {
			return null;
		}
		Date previousDay = DateUtils.addDays(date, -1);
		return getBeginDate(previousDay);
	}


	/**
	 * 获取给定日期的23:59:59时间戳
	 * @param date 日期
	 */
	public static Date getEndDate(Date date) {
		if (null == date) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.MILLISECOND, 999);
		return cal.getTime();
	}

	/**
	 * 获取给定日期的整点
	 * @param date 日期
	 */
	public static Date getFixDate(Date date,int hour) {
		if (null == date) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 根据规定格式的字符串得到Calendar.<br>
	 * <br>
	 * @param dateString 日期串.
	 * @return 对应Calendar
	 */
	public static Calendar getCalendar(String dateString) {
		Calendar calendar = Calendar.getInstance();
		String[] items = dateString.split("-");
		calendar
				.set(Integer.parseInt(items[0]), Integer.parseInt(items[1]) - 1, Integer.parseInt(items[2]));
		return calendar;
	}


	public static Date getDateyyyyMMddHHmmss(String strDate){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date;
		try {
			date= sdf.parse(strDate);
		} catch (Exception e) {
			return null;
		}
		return date;
	}


	public static boolean isSameDate(Date d1, Date d2) {
		return isSameTime(d1, d2, Calendar.DATE);
	}

	private static boolean isSameTime(Date d1, Date d2, int type) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		c1.setTime(d1);
		c2.setTime(d2);

		if (c1.get(type) == c2.get(type)) {
			return true;
		} else {
			return false;
		}
	}


	/**
	 *
	 * @param date
	 * @param n
	 * @return
	 */
	public static Date addDay(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(5, n);
		return cal.getTime();
	}
	/**
	 * 将时间对象转换成Unix时间戳
	 *
	 * @param date 日期对象
	 * @return
	 */
	public static String date2UnixTimeStamp(Date date) {
		return String.valueOf(date.getTime() / 1000);
	}

	public static void main(String[] args) throws ParseException {

//    	System.out.println(DateUtil.parse(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())));

		System.out.println(format(parse0("2016-05-17 09:30:43", PARSE_PATTERNS),PARSE_PATTERNS[0]));
		System.out.println(format(parse0("2016-05-17 09:30:43", PARSE_PATTERNS),PARSE_PATTERNS_YYYY_MM_DD_HH_MM_SS));


		System.out.println(format(getEndDate(new Date()),"yyyy-MM-dd HH:mm:ss.SSS"));
	}
}
