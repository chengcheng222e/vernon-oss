package com.vernon.oss.common.util;

import org.apache.commons.mail.SimpleEmail;
import org.apache.log4j.Logger;

import com.vernon.oss.common.Constant;

/**
 * 发送电子邮件的工具类
 * 
 * @author Vernon.Chen
 * 
 */
public class MailUtil {
	private final static Logger logger = Logger.getLogger(MailUtil.class);

	/**
	 * 发送邮件
	 * 
	 * @param smtpHostName
	 * @param fromAddress
	 * @param fromName
	 * @param smtpUsername
	 * @param smtpPassword
	 * @param toAddress
	 * @param subject
	 * @param msg
	 * @param charset
	 * @return
	 * @author Vernon.Chen
	 * @date 2012-9-5
	 */
	private static boolean sendMail(String smtpHostName, String fromAddress, String fromName, String smtpUsername,
			String smtpPassword, String toAddress, String subject, String msg, String charset) {
		try {
			SimpleEmail email = new SimpleEmail();
			email.setCharset(charset);
			email.setHostName(smtpHostName);
			email.setFrom(fromAddress, fromName, "UTF-8");
			email.setAuthentication(smtpUsername, smtpPassword);
			email.addTo(toAddress);
			email.setSubject(subject);
			email.setMsg(msg);
			email.setContent(msg, "text/html;charset=utf-8"); // 这里就支持HTML代码的
			email.send();
			logger.info(" send to email " + toAddress + " successfully !");
			return true;
		} catch (Exception e) {
			logger.error(" send to email " + toAddress + "  failed !", e);
		}
		return false;
	}

	/**
	 * 发送邮件
	 * 
	 * @param toUserEmail 邮件地址
	 * @param message 邮件内容
	 * @param subject 邮件主题
	 * @return
	 * @author Vernon.Chen
	 * @date 2012-9-5
	 */
	public static boolean sendMail(String toUserEmail, String message, String subject) {
		return sendMail(//
				Constant.EMAIL_SMTPHOSTNAME, //
				Constant.EMAIL_FROMADDRESS, //
				Constant.EMAIL_FROMNAME,//
				Constant.EMAIL_SMTPUSERNAME, //
				Constant.EMAIL_SMTPPASSWORD, //
				toUserEmail, //
				subject, //
				message,//
				Constant.EMAIL_CHARSET);
	}

	public static void main(String[] args) {
		sendMail("742939937@qq.com", "陈袁测试", "赶快修改密码");
	}
}
