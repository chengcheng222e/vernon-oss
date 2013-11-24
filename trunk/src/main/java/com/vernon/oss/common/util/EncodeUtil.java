package com.vernon.oss.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * 各种格式的编码加码工具类
 * 
 * @author Vernon.Chen
 *
 */
public class EncodeUtil {
	// ------------------------------ FIELDS ------------------------------

	public static final char[] N36_CHARS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
			'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	public static final char[] N62_CHARS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
			'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
			'V', 'W', 'X', 'Y', 'Z' };

	private static final String DEFAULT_URL_ENCODING = "UTF-8";

	// -------------------------- STATIC METHODS --------------------------

	/**
	 * URL编码,Encode默认为UTF-8
	 * 
	 * @param input 输入字符串
	 * @return String
	 */
	public static String urlEncode(String input) {
		if (null == input || "".equals(input)) {
			return "";
		}
		return urlEncode(input, DEFAULT_URL_ENCODING);
	}

	/**
	 * URL 编码
	 * 
	 * @param input 输入字符串
	 * @param encoding 编码格式
	 * @return String
	 */
	public static String urlEncode(String input, String encoding) {
		if (null == input || "".equals(input)) {
			return "";
		}
		try {
			return URLEncoder.encode(input, encoding);
		} catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException("Unsupported Encoding Exception", e);
		}
	}

	/**
	 * URL解码,Decode默认为UTF-8
	 * 
	 * @param input 输入字符串
	 * @return String
	 */
	public static String urlDecode(String input) {
		if (null == input || "".equals(input)) {
			return "";
		}
		return urlDecode(input, DEFAULT_URL_ENCODING);
	}

	/**
	 * URL 解码
	 * 
	 * @param input 输入字符串
	 * @param encoding 解码格式
	 * @return String
	 */
	public static String urlDecode(String input, String encoding) {
		if (null == input || "".equals(input)) {
			return "";
		}
		try {
			return URLDecoder.decode(input, encoding);
		} catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException("Unsupported Encoding Exception", e);
		}
	}

	/**
	 * 默认由ISO-8859-1编码转换成UTF-8编码字符串
	 * 
	 * @param input 输入字符串
	 * @return String
	 */
	public static String convert(String input) {
		return convert(input, "ISO-8859-1", DEFAULT_URL_ENCODING);
	}

	/**
	 * 转换成指定的字符串格式
	 * 
	 * @param input 输入字符串
	 * @param fromEncoding 原编码
	 * @param toEncoding 转换编码
	 * @return String
	 */
	public static String convert(String input, String fromEncoding, String toEncoding) {
		if (null == input || "".equals(input)) {
			return "";
		}
		try {
			return new String(input.getBytes(fromEncoding), toEncoding);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 获得字符。符合中文习惯。
	 * 
	 * @param input 输入字符串
	 * @param len 获取长度
	 * @return String
	 */
	public static String getCn(String input, int len) {
		if (input == null) {
			return input;
		}
		int sl = input.length();
		if (sl <= len) {
			return input;
		}
		// 留出一个位置用于…
		len -= 1;
		int maxCount = len * 2;
		int count = 0;
		int i = 0;
		while (count < maxCount && i < sl) {
			if (input.codePointAt(i) < 256) {
				count++;
			} else {
				count += 2;
			}
			i++;
		}
		if (count > maxCount) {
			i--;
		}
		return input.substring(0, i) + "…";
	}

	/**
	 * 长整数转换成N62
	 * 
	 * @param l 长整数
	 * @return String
	 */
	public static String longToN62(long l) {
		return longToNBuf(l, N62_CHARS).reverse().toString();
	}

	/**
	 * 长整数转换成N62
	 * 
	 * @param l 长整数
	 * @param length 如N62不足length长度,则补足0.
	 * @return String
	 */
	public static String longToN62(long l, int length) {
		StringBuilder sb = longToNBuf(l, N62_CHARS);
		for (int i = sb.length(); i < length; i++) {
			sb.append('0');
		}
		return sb.reverse().toString();
	}

	/**
	 * 长整数转换成N36
	 * 
	 * @param l 长整数
	 * @return String
	 */
	public static String longToN36(long l) {
		return longToNBuf(l, N36_CHARS).reverse().toString();
	}

	/**
	 * 长整数转换成N36
	 * 
	 * @param l 长整数
	 * @param length 如N36不足length长度,则补足0.
	 * @return String
	 */
	public static String longToN36(long l, int length) {
		StringBuilder sb = longToNBuf(l, N36_CHARS);
		for (int i = sb.length(); i < length; i++) {
			sb.append('0');
		}
		return sb.reverse().toString();
	}

	/**
	 * 是否有中文字符
	 * 
	 * @param input 输入字符串
	 * @return boolean
	 */
	public static boolean hasCn(String input) {
		return input != null && countCn(input) > input.length();
	}

	/**
	 * 计算GBK编码的字符串的字节数
	 * 
	 * @param input 输入字符串
	 * @return int
	 */
	public static int countCn(String input) {
		if (input == null) {
			return 0;
		}
		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.codePointAt(i) < 256) {
				count++;
			} else {
				count += 2;
			}
		}
		return count;
	}

	/**
	 * N62转换成长整数
	 * 
	 * @param n62 n62字符串
	 * @return long
	 */
	public static long n62ToLong(String n62) {
		return nToLong(n62, N62_CHARS);
	}

	/**
	 * N36转换成长整数
	 * 
	 * @param n36 n36字符串
	 * @return long
	 */
	public static long n36ToLong(String n36) {
		return nToLong(n36, N36_CHARS);
	}

	private static StringBuilder longToNBuf(long l, char[] chars) {
		int upgrade = chars.length;
		StringBuilder result = new StringBuilder();
		int last;
		while (l > 0) {
			last = (int) (l % upgrade);
			result.append(chars[last]);
			l /= upgrade;
		}
		return result;
	}

	private static long nToLong(String s, char[] chars) {
		char[] nc = s.toCharArray();
		long result = 0;
		long pow = 1;
		for (int i = nc.length - 1; i >= 0; i--, pow *= chars.length) {
			int n = findNIndex(nc[i], chars);
			result += n * pow;
		}
		return result;
	}

	private static int findNIndex(char c, char[] chars) {
		for (int i = 0, n = chars.length; i < n; i++) {
			if (c == chars[i]) {
				return i;
			}
		}
		throw new RuntimeException("N62(N36) illegal character:" + c);
	}

	/**
	 * 检查字符串是否需要urlEncode
	 * 
	 * @param str
	 * @return
	 */
	public static boolean needURLEncode(String str) {
		if (str == null || StringUtils.isBlank(str)) {
			return false;
		}
		return Pattern.compile("[\u4E00-\u9FA5\\?\\&]+").matcher(str).find();
	}
}
