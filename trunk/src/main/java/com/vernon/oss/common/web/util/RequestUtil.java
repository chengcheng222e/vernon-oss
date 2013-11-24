package com.vernon.oss.common.web.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
/**
 * RequestUtil工具类
 * 
 * @author Vernon.Chen
 * @date 2012-11-22
 */
public class RequestUtil {

	/**
	 * 获取发送请求的IP地址
	 * 
	 * @param request
	 * @return
	 */
	public static String getIPAddr(HttpServletRequest request) {
		String IP = request.getHeader("X-Real-IP");
		if (IP != null) {
			return IP;
		}
		return request.getRemoteAddr();
	}

	/**
	 * get HttpServletRequest
	 * 
	 * @return
	 * @author Vernon.Chen
	 * @date 2012-6-28
	 */
	public static HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	/**
	 * 判断是否是内网的访问
	 * 
	 * @param request
	 * @return
	 * @author Vernon.Chen
	 * @date 2012-6-1
	 */
	public static boolean isIntranet(HttpServletRequest request) {
		// 获取请求IP是不是属于我们的内网
		String reqIP = RequestUtil.getIPAddr(request);
		return reqIP.startsWith("10.") || reqIP.startsWith("127.0.0") || reqIP.startsWith("192.168.");
	}
}
