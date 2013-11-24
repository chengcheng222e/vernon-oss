/**
 *
 */
package com.vernon.oss.common.web.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vernon.oss.common.util.UUIDUtil;
import com.vernon.oss.domain.OSSContext;

/**
 * Web工具类
 * 
 * @author Vernon.Chen
 *
 */
public class WebUtil {

	// OSS_Context在Session中的Key值
	public static final String OSS_CONTEXT = "OSS_CONTEXT";

	// verifyCode在Session中的Key值
	public static final String VERIFY_CODE = "VERIFY_CODE";

	// token在Session中的Key值
	public static final String TOKEN = "TOKEN";

	// 错误提示消息在Session中的Key
	private static final String ERROR_MESSAGE = "ERROR_MESSAGE";
	
	/**
	 * 从Session中获取当前用户的OSSContext
	 *
	 * @param session
	 * @return
	 */
	public static OSSContext getContext(HttpSession session) {
		Object obj = SessionUtil.getAttributeForObject(session, OSS_CONTEXT, null);
		if (obj != null) {
			return (OSSContext) obj;
		}
		return null;
	}

	/**
	 * 设置OSSContext
	 *
	 * @param session
	 * @param context
	 * @return
	 */
	public static OSSContext setContext(HttpSession session, OSSContext context) {
		Object obj = SessionUtil.setAttribute(session, OSS_CONTEXT, context);
		if (obj != null) {
			return (OSSContext) obj;
		}
		return null;
	}

	/**
	 * 获取错误消息
	 *
	 * @param session
	 * @return
	 */
	public static String getErrorMessage(HttpSession session) {
		return SessionUtil.getAttributeForString(session, ERROR_MESSAGE, null);
	}

	/**
	 * 设置错误消息
	 *
	 * @param session
	 * @param message
	 * @return
	 */
	public static void setErrorMessage(HttpSession session, String message) {
		SessionUtil.setAttribute(session, ERROR_MESSAGE, message);
	}

	/**
	 * 清理错误消息
	 *
	 * @param session
	 */
	public static void clearErrorMessage(HttpSession session) {
		SessionUtil.removeAttribute(session, ERROR_MESSAGE);
	}

	/**
	 * 获取验证码
	 *
	 * @param session
	 * @return
	 */
	public static String getVerifyCode(HttpSession session) {
		return SessionUtil.getAttributeForString(session, VERIFY_CODE, null);
	}

	/**
	 * 设置验证码
	 *
	 * @param session
	 * @param verifyCode
	 * @return
	 */
	public static void setVerifyCode(HttpSession session, String verifyCode) {
		SessionUtil.setAttribute(session, VERIFY_CODE, verifyCode);
	}

	/**
	 * 添加一个令牌
	 *
	 * @param session
	 * @return
	 */
	public static String addToken(HttpSession session) {
		String token = UUIDUtil.getUUID();
		SessionUtil.setAttribute(session, TOKEN, token);
		return token;
	}

	/**
	 * 校验令牌
	 *
	 * @param session
	 * @param token
	 * @return
	 */
	public static boolean verifyToken(HttpSession session, String token) {
		if (token == null) {
			return false;
		}
		String secretToken = SessionUtil.getAttributeForString(session, TOKEN, null);
		return secretToken != null && token.equals(secretToken);
	}

	/**
	 * 删除令牌
	 *
	 * @param session
	 */
	public static void dropToken(HttpSession session) {
		SessionUtil.removeAttribute(session, TOKEN);
	}

	/**
	 * 清空cookie里的数据
	 * 
	 * @param request
	 * @param response
	 */
	public static void clearCookie(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				cookie.setValue("");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
	}

	/**
	 * 获取Cookie里的值
	 * 
	 * @param request
	 * @param key
	 * @return
	 */
	public static String getCookie(HttpServletRequest request, String key) {
		Cookie[] cookies = request.getCookies();
		String value = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(key)) {
					value = cookie.getValue();
					break;
				}
			}
		}
		return value;
	}

	/**
	 * 写入cookie值,默认有效时间30天
	 * 
	 * @param response
	 * @param key
	 * @param value
	 */
	public static void setCookie(HttpServletResponse response, String key, String value) {
		Cookie cookie = new Cookie(key, value);
		cookie.setMaxAge(60 * 60 * 24 * 30);
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	/**
	 * 写入cookie,有效时间由maxAge规约
	 * 
	 * @param response
	 * @param key
	 * @param value
	 * @param maxAge
	 */
	public static void setCookie(HttpServletResponse response, String key, String value, int maxAge) {
		Cookie cookie = new Cookie(key, value);
		cookie.setMaxAge(maxAge);
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	/**
	 * 获取真实IP地址
	 * 
	 * @param request
	 * @return
	 */
	public static String getIPAddr(HttpServletRequest request) {
		String IP = request.getHeader("x-forwarded-for");
		if (IP == null || IP.length() == 0 || "unknown".equalsIgnoreCase(IP)) {
			IP = request.getHeader("Proxy-Client-IP");
		}
		if (IP == null || IP.length() == 0 || "unknown".equalsIgnoreCase(IP)) {
			IP = request.getHeader("WL-Proxy-Client-IP");
		}
		if (IP == null || IP.length() == 0 || "unknown".equalsIgnoreCase(IP)) {
			IP = request.getRemoteAddr();
		}
		return IP;
	}

	/**
	 * 清除用户信息session
	 * @param session
	 */
	public static void clearContext(HttpSession session) {
		SessionUtil.removeAttribute(session, OSS_CONTEXT);
	}
}
