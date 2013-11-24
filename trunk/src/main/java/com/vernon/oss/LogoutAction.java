package com.vernon.oss;

import javax.servlet.http.Cookie;

import com.vernon.oss.common.web.util.WebUtil;

/**
 *
 * @author Vernon.Chen
 * @version 1.0 2013-6-20
 */
public class LogoutAction
		extends OSSBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6794332513536066019L;

	@Override
	public String execute() throws Exception {
		// 清空所有session
		session.removeAttribute(WebUtil.OSS_CONTEXT);
		// 清空所有cookie
		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {
			Cookie cookie = new Cookie(c.getName(), null) ;
			cookie.setMaxAge(0) ;
			cookie.setPath("/") ;
			response.addCookie(cookie) ;
		}
		return "oss_logout" ;
	}
	
	
	

}
