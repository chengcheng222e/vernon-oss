/**
 * 
 */
package com.vernon.oss.common.web.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.ArrayUtils;

import com.vernon.oss.common.util.EncodeUtil;

/**
 * parameter参数操作的工具类
 * 
 * @author Vernon.Chen
 *
 */
public class ParameterUtil {
	/**
	 * 获取参数数组
	 * 
	 * @param request
	 * @param parameterName
	 * @return
	 */
	public static String[] getParameterForStringArray(HttpServletRequest request, String parameterName) {
		return request.getParameterValues(parameterName);
	}

	/**
	 * 获取参数数组
	 * 
	 * @param request
	 * @param parameterName
	 * @param pattern
	 * @return
	 */
	public static Date[] getParameterForDateArray(HttpServletRequest request, String parameterName, String pattern) {
		String[] strArray = getParameterForStringArray(request, parameterName);
		if (strArray == null) {
			return null;
		}
		Date[] array = new Date[strArray.length];
		int cursor = 0;
		for (String str : strArray) {
			try {
				array[cursor] = new SimpleDateFormat(pattern).parse(str);
				cursor++;
			} catch (ParseException ignored) {
			}
		}
		if (cursor == 0) {
			return null;
		}
		if (cursor < array.length) {
			return (Date[]) ArrayUtils.subarray(array, 0, cursor);
		}
		return array;
	}

	/**
	 * 获取参数数组
	 * 
	 * @param request
	 * @param parameterName
	 * @return
	 */
	public static int[] getParameterForIntegerArray(HttpServletRequest request, String parameterName) {
		String[] strArray = getParameterForStringArray(request, parameterName);
		if (strArray == null) {
			return null;
		}
		int[] array = new int[strArray.length];
		int cursor = 0;
		for (String str : strArray) {
			try {
				array[cursor] = Integer.parseInt(str);
				cursor++;
			} catch (NumberFormatException ignored) {
			}
		}
		if (cursor == 0) {
			return null;
		}
		if (cursor < array.length) {
			return ArrayUtils.subarray(array, 0, cursor);
		}
		return array;
	}

	/**
	 * 获取参数数组
	 * 
	 * @param request
	 * @param parameterName
	 * @return
	 */
	public static byte[] getParameterForByteArray(HttpServletRequest request, String parameterName) {
		String[] strArray = getParameterForStringArray(request, parameterName);
		if (strArray == null) {
			return null;
		}
		byte[] array = new byte[strArray.length];
		int cursor = 0;
		for (String str : strArray) {
			try {
				array[cursor] = Byte.parseByte(str);
				cursor++;
			} catch (NumberFormatException ignored) {
			}
		}
		if (cursor == 0) {
			return null;
		}
		if (cursor < array.length) {
			return ArrayUtils.subarray(array, 0, cursor);
		}
		return array;
	}

	/**
	 * 获取参数数组
	 * 
	 * @param request
	 * @param parameterName
	 * @return
	 */
	public static float[] getParameterForFloatArray(HttpServletRequest request, String parameterName) {
		String[] strArray = getParameterForStringArray(request, parameterName);
		if (strArray == null) {
			return null;
		}
		float[] array = new float[strArray.length];
		int cursor = 0;
		for (String str : strArray) {
			try {
				array[cursor] = Float.parseFloat(str);
				cursor++;
			} catch (NumberFormatException ignored) {
			}
		}
		if (cursor == 0) {
			return null;
		}
		if (cursor < array.length) {
			return ArrayUtils.subarray(array, 0, cursor);
		}
		return array;
	}

	/**
	 * 获取参数数组
	 * 
	 * @param request
	 * @param parameterName
	 * @return
	 */
	public static short[] getParameterForShortArray(HttpServletRequest request, String parameterName) {
		String[] strArray = getParameterForStringArray(request, parameterName);
		if (strArray == null) {
			return null;
		}
		short[] array = new short[strArray.length];
		int cursor = 0;
		for (String str : strArray) {
			try {
				array[cursor] = Short.parseShort(str);
				cursor++;
			} catch (NumberFormatException ignored) {
			}
		}
		if (cursor == 0) {
			return null;
		}
		if (cursor < array.length) {
			return ArrayUtils.subarray(array, 0, cursor);
		}
		return array;
	}

	/**
	 * 获取参数数组
	 * 
	 * @param request
	 * @param parameterName
	 * @return
	 */
	public static double[] getParameterForDoubleArray(HttpServletRequest request, String parameterName) {
		String[] strArray = getParameterForStringArray(request, parameterName);
		if (strArray == null) {
			return null;
		}
		double[] array = new double[strArray.length];
		int cursor = 0;
		for (String str : strArray) {
			try {
				array[cursor] = Double.parseDouble(str);
				cursor++;
			} catch (NumberFormatException ignored) {
			}
		}
		if (cursor == 0) {
			return null;
		}
		if (cursor < array.length) {
			return ArrayUtils.subarray(array, 0, cursor);
		}
		return array;
	}

	/**
	 * 获取参数数组
	 * 
	 * @param request
	 * @param parameterName
	 * @return
	 */
	public static long[] getParameterForLongArray(HttpServletRequest request, String parameterName) {
		String[] strArray = getParameterForStringArray(request, parameterName);
		if (strArray == null) {
			return null;
		}
		long[] array = new long[strArray.length];
		int cursor = 0;
		for (String str : strArray) {
			try {
				array[cursor] = Long.parseLong(str);
				cursor++;
			} catch (NumberFormatException ignored) {
			}
		}
		if (cursor == 0) {
			return null;
		}
		if (cursor < array.length) {
			return ArrayUtils.subarray(array, 0, cursor);
		}
		return array;
	}

	/**
	 * 获取参数值
	 * 
	 * @param request
	 * @param parameterName
	 * @param defaultValue
	 * @return
	 * @throws NullPointerException
	 */
	public static String getParameterForString(HttpServletRequest request, String parameterName, String defaultValue)
			throws NullPointerException {
		return getParameterForString(request, parameterName, defaultValue, false);
	}

	/**
	 * 获取参数值
	 * 
	 * @param request
	 * @param parameterName
	 * @param defaultValue
	 * @param encode
	 *            转码,用于处理get过来的中文字符
	 * @return
	 * @throws NullPointerException
	 */
	public static String getParameterForString(HttpServletRequest request, String parameterName, String defaultValue,
			boolean encode) throws NullPointerException {
		Object parameterValue = ParameterUtil.getParameterForObject(request, parameterName);
		if (parameterValue == null) {
			return defaultValue;
		}
		String value = parameterValue.toString();
		if (encode && request.getMethod().equalsIgnoreCase("get") && !EncodeUtil.hasCn(value)) {
			return EncodeUtil.convert(value);
		}
		return value;
	}

	/**
	 * 获取参数值
	 * 
	 * @param request
	 * @param parameterName
	 * @return
	 */
	public static Object getParameterForObject(HttpServletRequest request, String parameterName) {
		if (request == null) {
			throw new NullPointerException("HttpServletRequest NULL!");
		}
		return request.getParameter(parameterName);
	}

	/**
	 * 获取参数值
	 * 
	 * @param request
	 * @param parameterName
	 * @param defaultValue
	 * @return
	 * @throws NullPointerException
	 */
	public static Integer getParameterForInteger(HttpServletRequest request, String parameterName, Integer defaultValue)
			throws NullPointerException {
		String defValue = "" + defaultValue;
		if (defaultValue == null) {
			defValue = null;
		}
		String parameterValue = ParameterUtil.getParameterForString(request, parameterName, defValue);
		try {
			return Integer.parseInt(parameterValue);
		} catch (NumberFormatException ignored) {
		}
		return defaultValue;
	}

	/**
	 * 获取参数值
	 * 
	 * @param request
	 * @param parameterName
	 * @param defaultValue
	 * @return
	 * @throws NullPointerException
	 */
	public static Long getParameterForLong(HttpServletRequest request, String parameterName, Long defaultValue)
			throws NullPointerException {
		String defValue = "" + defaultValue;
		if (defaultValue == null) {
			defValue = null;
		}
		String parameterValue = ParameterUtil.getParameterForString(request, parameterName, defValue);
		try {
			return Long.parseLong(parameterValue);
		} catch (NumberFormatException ignored) {
		}
		return defaultValue;
	}

	/**
	 * 获取参数值
	 * 
	 * @param request
	 * @param parameterName
	 * @param defaultValue
	 * @return
	 * @throws NullPointerException
	 */
	public static Double getParameterForDouble(HttpServletRequest request, String parameterName, Double defaultValue)
			throws NullPointerException {
		String defValue = "" + defaultValue;
		if (defaultValue == null) {
			defValue = null;
		}
		String parameterValue = ParameterUtil.getParameterForString(request, parameterName, defValue);
		try {
			return Double.parseDouble(parameterValue);
		} catch (NumberFormatException ignored) {
		}
		return defaultValue;
	}

	/**
	 * 获取参数值
	 * 
	 * @param request
	 * @param parameterName
	 * @param defaultValue
	 * @return
	 * @throws NullPointerException
	 */
	public static Float getParameterForFloat(HttpServletRequest request, String parameterName, Float defaultValue)
			throws NullPointerException {
		String defValue = "" + defaultValue;
		if (defaultValue == null) {
			defValue = null;
		}
		String parameterValue = ParameterUtil.getParameterForString(request, parameterName, defValue);
		try {
			return Float.parseFloat(parameterValue);
		} catch (NumberFormatException ignored) {
		}
		return defaultValue;
	}

	/**
	 * 获取参数值
	 * 
	 * @param request
	 * @param parameterName
	 * @param defaultValue
	 * @return
	 * @throws NullPointerException
	 */
	public static Short getParameterForShort(HttpServletRequest request, String parameterName, Short defaultValue)
			throws NullPointerException {
		String defValue = "" + defaultValue;
		if (defaultValue == null) {
			defValue = null;
		}
		String parameterValue = ParameterUtil.getParameterForString(request, parameterName, defValue);
		try {
			return Short.parseShort(parameterValue);
		} catch (NumberFormatException ignored) {
		}
		return defaultValue;
	}

	/**
	 * 获取参数值
	 * 
	 * @param request
	 * @param parameterName
	 * @param defaultValue
	 * @return
	 * @throws NullPointerException
	 */
	public static Byte getParameterForByte(HttpServletRequest request, String parameterName, Byte defaultValue)
			throws NullPointerException {
		String defValue = "" + defaultValue;
		if (defaultValue == null) {
			defValue = null;
		}
		String parameterValue = ParameterUtil.getParameterForString(request, parameterName, defValue);
		try {
			return Byte.parseByte(parameterValue);
		} catch (NumberFormatException ignored) {
		}
		return defaultValue;
	}

	/**
	 * 获取参数值
	 * 
	 * @param request
	 * @param parameterName
	 * @param pattern
	 * @param defaultValue
	 * @return
	 * @throws NullPointerException
	 */
	public static Date getParameterForDate(HttpServletRequest request, String parameterName, String pattern,
			Date defaultValue) throws NullPointerException {
		if (pattern == null) {
			throw new NullPointerException("pattern NULL!");
		}
		String parameterValue = ParameterUtil.getParameterForString(request, parameterName, null);
		if (parameterValue == null || parameterValue.trim().length() == 0) {
			return defaultValue;
		}
		try {

			return new SimpleDateFormat(pattern).parse(parameterValue);
		} catch (ParseException ignored) {
		}
		return defaultValue;
	}

	/**
	 * 获取参数名称列表
	 * 
	 * @param request
	 * @return
	 */
	public static String[] getParameterNames(HttpServletRequest request) {
		Enumeration<String> enumeration = request.getParameterNames();
		if (enumeration != null) {
			String[] parameterNames = new String[16];
			int cursor = 0;
			while (enumeration.hasMoreElements()) {
				if (cursor >= parameterNames.length) {
					String[] swap = new String[parameterNames.length + (parameterNames.length / 2)];
					System.arraycopy(parameterNames, 0, swap, 0, parameterNames.length);
					parameterNames = swap;
				}
				parameterNames[cursor] = enumeration.nextElement();
				cursor++;
			}
			if (parameterNames.length > cursor) {
				String[] swap = new String[cursor];
				System.arraycopy(parameterNames, 0, swap, 0, cursor);
				parameterNames = swap;
			}
			return parameterNames;
		}
		return null;
	}
}
