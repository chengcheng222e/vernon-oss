package com.vernon.oss.common.logger;

import org.apache.log4j.Logger;

import com.vernon.oss.service.OSSOPSvc;

/**
 * 日志管理
 * 
 * @author Vernon.Chen
 *
 */
public class LogUtil {

	private static final Logger logger = Logger.getLogger("oss_op");

	/**
	 * 后台操作日志
	 * 
	 * @param IP 		IP
	 * @param userId	用户ID
	 * @param userName 	登录用户名
	 * @param title		操作名
	 * @param content	操作内容
	 * @param remark	备注
	 * @param cls 		类名
	 */
	public static void info(Object IP, Object userId, Object userName, Object title, Object content, Object remark,
			Class<?> cls) {
		StringBuilder sb = new StringBuilder();
		sb.append(" ");
		sb.append(IP);
		sb.append(" ");
		sb.append(userId);
		sb.append(" ");
		sb.append(userName);
		sb.append(" ");
		sb.append(title);
		sb.append(" ");
		sb.append(content);
		sb.append(" ");
		sb.append(remark);
		sb.append(" ");
		sb.append(cls.getName());
		OSSOPSvc.addOSSOP(Integer.parseInt(userId.toString()), "" + title, "" + content, "" + IP, cls.getName(), ""
				+ remark);
		logger.info(sb.toString());
	}
}
