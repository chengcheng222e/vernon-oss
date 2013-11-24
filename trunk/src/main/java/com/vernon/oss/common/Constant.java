package com.vernon.oss.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.Properties;

/**
 * 全局常量定义
 * 
 * @author Vernon.Chen
 * @date 2012-11-22
 */
@SuppressWarnings("serial")
public class Constant
	implements Serializable {

	// ************************* 网站路径配置 *************************

	public static String DOMAIN = "http://localhost:8080/vernon-oss";

	public static String USER_URL = DOMAIN + "/user";

	public static String PARTY_URL = DOMAIN + "/party";

	public static String SHARE_URL = DOMAIN + "/share";

	public static String WENDA_URL = DOMAIN + "/wenda";

	public static String SETTINGS_URL = DOMAIN + "/settings";

	public static String JS_BASE_URL = DOMAIN + "/js";

	public static String CSS_BASE_URL = DOMAIN + "/css";

	public static String IMG_BASE_URL = DOMAIN + "/img";

	public static String PLUGIN_BASE_URL = DOMAIN + "/plugin";

	public static String ICON_BASE_DIR = DOMAIN + "/icon";

	public static String ICON_BASE_URL = DOMAIN + "/icon";

	// ************************* 邮件配置 *************************

	public static String EMAIL_SMTPHOSTNAME = "smtp.sina.com";

	public static String EMAIL_FROMADDRESS = "chengcheng222e@sina.com";

	public static String EMAIL_FROMNAME = "chengcheng222e";

	public static String EMAIL_SMTPUSERNAME = "chengcheng222e@sina.com";

	public static String EMAIL_SMTPPASSWORD = "jizhuni632375";

	public static String EMAIL_CHARSET = "UTF-8";

	public static String EMAIL_TITLE = "邮件提醒";

	private static Properties properties = new Properties();

	static {
		try {
			Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources("constant.properties");
			if (urls == null || !urls.hasMoreElements()) {
				System.out.println("no constant config find! please put constant.properties  in your classpath");
			}
			if (urls.hasMoreElements()) {
				String filepath = urls.nextElement().getFile();
				filepath = URLDecoder.decode(filepath, "utf-8");
				System.out.println("constant filepath:" + filepath);

				properties.load(new FileInputStream(new File(filepath)));

				if (properties.getProperty("DOMAIN") != null) {
					DOMAIN = properties.getProperty("DOMAIN");
					System.out.println("init constant.DOMAIN=" + DOMAIN);
				}

				if (properties.getProperty("USER_URL") != null) {
					USER_URL = properties.getProperty("USER_URL");
					System.out.println("init constant.USER_URL=" + USER_URL);
				}

				if (properties.getProperty("PARTY_URL") != null) {
					PARTY_URL = properties.getProperty("PARTY_URL");
					System.out.println("init constant.PARTY_URL=" + PARTY_URL);
				}

				if (properties.getProperty("SHARE_URL") != null) {
					SHARE_URL = properties.getProperty("SHARE_URL");
					System.out.println("init constant.SHARE_URL=" + SHARE_URL);
				}

				if (properties.getProperty("WENDA_URL") != null) {
					WENDA_URL = properties.getProperty("WENDA_URL");
					System.out.println("init constant.WENDA_URL=" + WENDA_URL);
				}

				if (properties.getProperty("SETTINGS_URL") != null) {
					SETTINGS_URL = properties.getProperty("SETTINGS_URL");
					System.out.println("init constant.SETTINGS_URL=" + SETTINGS_URL);
				}

				if (properties.getProperty("JS_BASE_URL") != null) {
					JS_BASE_URL = properties.getProperty("JS_BASE_URL");
					System.out.println("init constant.JS_BASE_URL=" + JS_BASE_URL);
				}

				if (properties.getProperty("CSS_BASE_URL") != null) {
					CSS_BASE_URL = properties.getProperty("CSS_BASE_URL");
					System.out.println("init constant.CSS_BASE_URL=" + CSS_BASE_URL);
				}

				if (properties.getProperty("IMG_BASE_URL") != null) {
					IMG_BASE_URL = properties.getProperty("IMG_BASE_URL");
					System.out.println("init constant.IMG_BASE_URL=" + IMG_BASE_URL);
				}

				if (properties.getProperty("PLUGIN_BASE_URL") != null) {
					PLUGIN_BASE_URL = properties.getProperty("PLUGIN_BASE_URL");
					System.out.println("init constant.PLUGIN_BASE_URL=" + PLUGIN_BASE_URL);
				}

				if (properties.getProperty("ICON_BASE_DIR") != null) {
					ICON_BASE_DIR = properties.getProperty("ICON_BASE_DIR");
					System.out.println("init constant.ICON_BASE_DIR=" + ICON_BASE_DIR);
				}

				if (properties.getProperty("ICON_BASE_URL") != null) {
					ICON_BASE_URL = properties.getProperty("ICON_BASE_URL");
					System.out.println("init constant.ICON_BASE_URL=" + ICON_BASE_URL);
				}

				if (properties.getProperty("EMAIL_SMTPHOSTNAME") != null) {
					EMAIL_SMTPHOSTNAME = properties.getProperty("EMAIL_SMTPHOSTNAME");
					System.out.println("init constant.EMAIL_SMTPHOSTNAME=" + EMAIL_SMTPHOSTNAME);
				}

				if (properties.getProperty("EMAIL_FROMADDRESS") != null) {
					EMAIL_FROMADDRESS = properties.getProperty("EMAIL_FROMADDRESS");
					System.out.println("init constant.EMAIL_FROMADDRESS=" + EMAIL_FROMADDRESS);
				}

				if (properties.getProperty("EMAIL_FROMNAME") != null) {
					EMAIL_FROMNAME = properties.getProperty("EMAIL_FROMNAME");
					System.out.println("init constant.EMAIL_FROMNAME=" + EMAIL_FROMNAME);
				}

				if (properties.getProperty("EMAIL_SMTPUSERNAME") != null) {
					EMAIL_SMTPUSERNAME = properties.getProperty("EMAIL_SMTPUSERNAME");
					System.out.println("init constant.EMAIL_SMTPUSERNAME=" + EMAIL_SMTPUSERNAME);
				}

				if (properties.getProperty("EMAIL_SMTPPASSWORD") != null) {
					EMAIL_SMTPPASSWORD = properties.getProperty("EMAIL_SMTPPASSWORD");
					System.out.println("init constant.EMAIL_SMTPPASSWORD=" + EMAIL_SMTPPASSWORD);
				}

				if (properties.getProperty("EMAIL_CHARSET") != null) {
					EMAIL_CHARSET = properties.getProperty("EMAIL_CHARSET");
					System.out.println("init constant.EMAIL_CHARSET=" + EMAIL_CHARSET);
				}

				if (properties.getProperty("EMAIL_TITLE") != null) {
					EMAIL_TITLE = properties.getProperty("EMAIL_TITLE");
					System.out.println("init constantEMAIL_TITLE=" + EMAIL_TITLE);
				}

				System.out.println("constant init success!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 更具Key获取Value
	 * 
	 * @param key
	 * @return
	 */
	public static String getProperty(String key) {
		return getProperty(key, "");
	}

	/**
	 * 更具Key获取Value, 没有取到给默认值
	 * 
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static String getProperty(String key, String defaultValue) {
		return properties.getProperty(key, defaultValue);
	}

	public static void main(String[] args) {
		// Constant constant = new Constant();
	}
}
