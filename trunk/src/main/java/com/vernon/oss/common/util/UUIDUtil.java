package com.vernon.oss.common.util;

import java.util.UUID;

/**
 * UUID 生成工具
 * 
 * @date 2013-1-27
 * @author Vernon.Chen
 */
public class UUIDUtil {

	/**
	 * 获取UUID
	 * 
	 * @return
	 */
	public static String getUUID() {
		String source = UUID.randomUUID().toString();
		String[] splits = source.split("[-]");
		StringBuffer result = new StringBuffer();
		for (String split : splits) {
			result.append(split);
		}
		return result.toString();
	}

	/**
	 * 获取多个UUID
	 * 
	 * @param length 个数
	 * @return
	 */
	public static String[] getUUID(int length) {
		if (length < 1) {
			return null;
		}
		String[] result = new String[length];
		for (int i = 0; i < length; i++) {
			result[i] = getUUID();
		}
		return result;
	}

	public static void main(String[] args) {
		String sd = getUUID();
		System.out.println(sd);
	}
}
