package com.vernon.oss.common.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * 文件操作工具类
 * 
 * @author Vernon.Chen
 * @date 2012-4-23
 */
public class ResourceUtil {
	private static Logger logger = Logger.getLogger(ResourceUtil.class);

	/**
	 * 读取模板内容
	 * 
	 * @param filePathName 文件名
	 * @return
	 * @author Vernon.Chen
	 * @date 2012-6-5
	 */
	public static String loadTemplate(String filePathName) {
		StringBuilder content = new StringBuilder();
		InputStreamReader read = null;
		try {
			read = new InputStreamReader(ResourceUtil.class.getResourceAsStream("/template/" + filePathName), "UTF-8");
			BufferedReader in = new BufferedReader(read);
			String line;
			while ((line = in.readLine()) != null) {
				content.append(line);
			}
		} catch (Exception e) {
			logger.error("read the template error !", e);
		} finally {
			try {
				if (read != null) {
					read.close();
				}
			} catch (IOException e) {
				logger.error("", e);
			}
		}
		return content.toString();
	}

	/**  
	 * 递归遍历，查找满足后缀的文件  
	 * 
	 * @param dirFile 必须为一个存在的目录.不能为null  
	 * @param suffix  
	 * @param list 递归遍历目录记录满足后缀的文件的绝对路径。  
	 * */
	public static void find(File dirFile, String suffix, List<String> list) {
		if (dirFile.exists() && dirFile.isDirectory()) {
			File[] subFiles = dirFile.listFiles();
			for (File subFile : subFiles) {
				if (subFile.isDirectory()) {
					find(subFile, suffix, list);
				} else {
					String path = subFile.getAbsolutePath();
					if (path.endsWith(suffix)) {
						list.add(path);
					}
				}
			}
		} else {
			throw new IllegalArgumentException("param \"dir\" must be an existing directory .dir = "
					+ dirFile.getAbsolutePath());
		}
	}

	/**
	 * 获取扩展名
	 *
	 * @param fileName 文件名
	 * @return String
	 */
	public static String getExt(String fileName) {
		if (fileName == null) {
			return null;
		}
		if (fileName.lastIndexOf(".") < 0) {
			return null;
		}
		fileName = fileName.substring(fileName.lastIndexOf(".") + 1);
		if (fileName.indexOf("?") > 0) {
			fileName = fileName.substring(0, fileName.indexOf("?"));
		}
		return fileName.toLowerCase();
	}
}
