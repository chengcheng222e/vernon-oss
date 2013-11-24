package com.vernon.oss.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间处理的工具类
 * 
 * @date 2013-1-27
 * @author Vernon.Chen
 */
public class DateUtil {

	public static final String FORMAT_DATE = "yyyy-MM-dd";

	public static final String FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 当日时间
	 * 
	 * @return
	 */
	public static Date getCurrentDate() {
		return new Date(System.currentTimeMillis());
	}

	/**
	 * 设置时间
	 * 
	 * @param date Date
	 * @param field 时间段
	 * @param amount 数量
	 * @return
	 */
	public static Date set(Date date, int field, int amount) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(field, amount);
		return calendar.getTime();
	}

	/**
	 * 时间增加
	 * 
	 * @param date Date
	 * @param field 时间段
	 * @param amount 数量
	 * @return
	 */
	public static Date add(Date date, int field, int amount) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(field, amount);
		return calendar.getTime();
	}

	/**
	 * 时间增加
	 * 
	 * @param field 时间段
	 * @param amount 数量
	 * @return
	 */
	public static Date add(int field, int amount) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(field, amount);
		return calendar.getTime();
	}

	/**
	 * 按照时间格式,将字符串转化成时间, 格式化失败返回null
	 * 
	 * @param str 时间字符串
	 * @param format 格式
	 * @return
	 */
	public static Date string2Date(String str, String format) {
		try {
			if (str != null) {
				return new SimpleDateFormat(format).parse(str);
			}
		} catch (ParseException ignored) {
		}
		return null;
	}

	/**
	 * 按照时间格式,将字符串转化成时间, 格式化失败返回默认值
	 * 
	 * @param str 时间字符串
	 * @param format 格式
	 * @param defaultValue 默认时间
	 * @return
	 */
	public static Date string2Date(String str, String format, Date defaultValue) {
		try {
			if (str != null) {
				return new SimpleDateFormat(format).parse(str);
			}
		} catch (ParseException ignored) {
		}
		return defaultValue;
	}

	/**
	 * 按照format格式,将时间转化成String,如果格式化失败返回null
	 * 
	 * @param date 时间
	 * @param format 格式
	 * @return
	 */
	public static String date2String(Date date, String format) {
		if (date != null) {
			return new SimpleDateFormat(format).format(date);
		}
		return null;
	}

	/**
	 * 默认时间格式
	 * 
	 * @param date 时间
	 * @return
	 */
	public static String date2StringDefault(Date date) {
		return date2String(date, FORMAT_DATE);
	}

	/**
	 * 日期格式化
	 * 
	 * @param date 时间
	 * @param format 格式
	 * @return
	 */
	public static Date formatDate(Date date, String format) {
		return string2Date(date2String(date, format), format);
	}

	/**
	 * 日期串格式化
	 * 
	 * @param str 日期串
	 * @param format 格式
	 * @return
	 */
	public static String formatDateString(String str, String format) {
		return date2String(string2Date(str, format), format);
	}

	/**
	 * 标准输出日期格式, 当日的不显示日期, 本年不显示年份
	 * 
	 * @param date 时间
	 * @return
	 */
	public static String date2String(Date date) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		Calendar dateCalendar = Calendar.getInstance();
		dateCalendar.setTime(date);
		StringBuffer format = new StringBuffer();
		if (dateCalendar.get(Calendar.YEAR) != calendar.get(Calendar.YEAR)) {
			format.append("yy-MM-dd ");
		} else if (dateCalendar.get(Calendar.DAY_OF_MONTH) != calendar.get(Calendar.DAY_OF_MONTH)) {
			format.append("MM-dd ");
		}
		format.append("HH:mm:ss");
		return date2String(date, format.toString());
	}

	/**
	 * 获取时间差
	 * 
	 * @param date 时间
	 * @param postfix 修饰词(eg: xxx之前)
	 * @return
	 */
	public static String dateDiff2String(Date date, String postfix) {
		long longTime = date.getTime();
		long result = System.currentTimeMillis() - longTime;
		if (postfix == null) {
			postfix = "";
		}
		if (result <= 1000) {
			return "1秒" + postfix;
		}

		long second = result / 1000; // second
		if (second < 60) {
			return second + "秒" + postfix;
		}

		long minute = second / 60; // minute
		if (minute < 60) {
			return minute + "分钟" + postfix;
		}

		long hour = minute / 60; // hour
		if (hour < 24) {
			return hour + "小时" + postfix;
		}

		long day = hour / 24; // day
		if (day < 7) {
			return day + "天" + postfix;
		}

		long week = day / 7; // week
		if (week <= 4) {
			return week + "周" + postfix;
		}

		return date2String(date);
	}

	/**
	 * 获取时间差
	 * 
	 * @param date 时间 
	 * @param postfix 修饰词(eg: xxx之前)
	 * @param format 格式
	 * @return
	 */
	public static String dateDiff2String(Date date, String postfix, String format) {
		long longTime = date.getTime();
		long result = System.currentTimeMillis() - longTime;
		if (postfix == null) {
			postfix = "";
		}
		if (result <= 1000) {
			return "1秒" + postfix;
		}

		long second = result / 1000; // second
		if (second < 60) {
			return second + "秒" + postfix;
		}

		long minute = second / 60; // minute
		if (minute < 60) {
			return minute + "分钟" + postfix;
		}

		long hour = minute / 60; // hour
		if (hour < 24) {
			return hour + "小时" + postfix;
		}

		long day = hour / 24; // day
		if (day < 7) {
			return day + "天" + postfix;
		}

		long week = day / 7; // week
		if (week <= 4) {
			return week + "周" + postfix;
		}

		return date2String(date, format);
	}

}
