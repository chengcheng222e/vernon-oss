package com.vernon.oss.common.util;

import java.util.List;

/**
 * 字符串工具类
 * 
 * @author Vernon.Chen
 * @date 2012-11-5
 */
public class StringUtil {

	public static final String EMPTY = "";

	/**
	 * 判断string is "" or null
	 * 
	 * @param str 待查字符串
	 * @return boolean
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}

	/**
	 * 判断string is not "" or null
	 * 
	 * @param str 待查字符串
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

	/**
	 * 判断string is "" or null or whitespace
	 * 
	 * @param str 待查字符串
	 * @return boolean
	 */
	public static boolean isBlank(String str) {
		int strLen;
		if (null == str || (strLen = str.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 判断string is not "" or null or whitespace
	 * 
	 * @param str 待查字符串
	 * @return boolean
	 */
	public static boolean isNotBlank(String str) {
		return !isBlank(str);
	}

	/**
	 * 判断两个字符串是否相等
	 * 
	 * @param str1 字符串1
	 * @param str2 字符串2
	 * @return
	 */
	public static boolean equals(String str1, String str2) {
		return str1 == null ? str2 == null : str1.equals(str2);
	}

	/**
	 * 判断两个字符串不分大小字母是否相等
	 * 
	 * @param str1 字符串1
	 * @param str2 字符串2
	 * @return
	 */
	public static boolean equalsIgnoreCase(String str1, String str2) {
		return str1 == null ? str2 == null : str1.equalsIgnoreCase(str2);
	}

	/**
	 * 获取字符串左边指定长度的字符
	 * 
	 * @param str 待处理字符串
	 * @param len 长度
	 * @return String
	 */
	public static String left(String str, int len) {
		if (null == str) {
			return null;
		}
		if (len < 0) {
			return EMPTY;
		}
		if (str.length() <= len) {
			return str;
		}
		return str.substring(0, len);
	}

	/**
	 * 截取字符串
	 * 
	 * @param str 字符串
	 * @param beginIndex 开始值
	 * @param length 长度
	 * @return
	 */
	public static String subString(String str, int beginIndex, int length) {
		if (str == null || str.length() <= beginIndex) {
			return null;
		}
		beginIndex = beginIndex < 0 ? 0 : beginIndex;
		if (str.length() < beginIndex + length) {
			return str.substring(beginIndex);
		}
		return str.substring(beginIndex, beginIndex + length);
	}

	/**
	 * 获取右边指定长度字符串
	 * 
	 * @param str 待处理字符串
	 * @param len 长度
	 * @return String
	 */
	public static String right(String str, int len) {
		if (null == str) {
			return null;
		}
		if (len < 0) {
			return EMPTY;
		}
		if (str.length() <= len) {
			return str;
		}
		return str.substring(str.length() - len);
	}

	/**
	 * 中间每个元素都加上指定字符
	 * 
	 * @param array 数组
	 * @param separator 字符
	 * @return
	 */
	public static String join(Object[] array, char separator) {
		if (array == null) {
			return null;
		}
		return join(array, separator, 0, array.length);
	}

	/**
	 * 中间每个元素都加上指定字符
	 * 
	 * @param array
	 * @param separator
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	public static String join(Object[] array, char separator, int startIndex, int endIndex) {
		if (array == null) {
			return null;
		}
		int bufSize = endIndex - startIndex;
		if (bufSize <= 0) {
			return EMPTY;
		}
		bufSize *= ((array[startIndex] == null ? 16 : array[startIndex].toString().length()) + 1);
		StringBuilder buf = new StringBuilder(bufSize);
		for (int i = startIndex; i < endIndex; i++) {
			if (i > startIndex) {
				buf.append(separator);
			}
			if (array[i] != null) {
				buf.append(array[i]);
			}
		}
		return buf.toString();
	}

	/**
	 * List<Integer> 转换成数组  String[]
	 * 
	 * @param ints
	 * @return
	 */
	public static String[] intList2StrArray(List<Integer> ints) {
		if (ints == null || ints.size() == 0) {
			return null;
		}
		String[] array = new String[ints.size()];
		for (int i = 0; i < ints.size(); i++) {
			array[i] = String.valueOf(ints.get(i));
		}
		return array;
	}

	/**
	 * List<String> 转换成 int[]
	 * 
	 * @param strs
	 * @return
	 */
	public static int[] strList2IntArray(List<String> strs) {
		if (strs == null || strs.size() == 0) {
			return null;
		}
		int[] array = new int[strs.size()];
		for (int i = 0; i < strs.size(); i++) {
			array[i] = Integer.parseInt(strs.get(i));
		}
		return array;
	}

}
