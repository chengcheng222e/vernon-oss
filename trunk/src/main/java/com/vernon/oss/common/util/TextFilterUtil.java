/**
 * 
 */
package com.vernon.oss.common.util;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

/**
 * 字符过滤工具
 * 
 * @author Vernon.Chen
 * @date 2012-12-3
 */
public class TextFilterUtil {

	/**
	 * 转义HTML
	 * 
	 * @param source
	 * @return
	 */
	public static String escapeHtml(String source) {
		if (source == null || source.length() == 0) {
			return source;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < source.length(); i++) {
			char c = source.charAt(i);
			if (c == '\'') {
				sb.append("&#39;");
			} else if (c == '\"') {
				sb.append("&#34;");
			} else if (c == '<') {
				sb.append("&lt;");
			} else if (c == '>') {
				sb.append("&gt;");
			} else if (c == '%') {
				sb.append("&#37;");
			} else if (c == '&') {
				sb.append("&amp;");
			} else if (c >= 0 && c < 32 || c == 65535) {
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 * 过滤HTML标记
	 * 
	 * @param source
	 * @return
	 */
	public static String filterHTML(String source) {
		if (source == null || source.length() == 0) {
			return source;
		}
		// 利用 jsoup-1.6.1.jar 第三方. 它是去解析DOM结构,这样比正则表达式彻底一些
		return Jsoup.clean(source, Whitelist.none());
	}

	public static void main(String[] args) {
		String source = "&lt;&gt;'\"“”";
		source = escapeHtml(source);
		System.out.println("source:" + source);
	}

}
