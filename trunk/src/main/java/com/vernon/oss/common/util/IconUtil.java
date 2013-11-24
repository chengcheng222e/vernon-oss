/**
 * 
 */
package com.vernon.oss.common.util;

import java.io.File;

import com.vernon.oss.common.Constant;

/**
 * icon工具类
 * 
 * @author Vernon.Chen
 *
 */
public class IconUtil {

	/**
	 * 获取资源文件的URI地址
	 * 
	 * @param file
	 */
	public static final String getURL(File file) {
		return file.toString().replace("\\", "/").replace(Constant.ICON_BASE_DIR, Constant.ICON_BASE_URL);
	}

	/**
	 * 获取资源文件的URI地址
	 * 
	 * @param file
	 */
	public static final String getURL(String file) {
		return file.replace("\\", "/").replace(Constant.ICON_BASE_DIR, Constant.ICON_BASE_URL);
	}

}
