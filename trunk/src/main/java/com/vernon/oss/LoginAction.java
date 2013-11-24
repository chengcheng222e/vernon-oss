package com.vernon.oss;

import com.vernon.oss.common.util.StringUtil;
import com.vernon.oss.common.web.util.WebUtil;
import com.vernon.oss.service.OSSSvc;

/**
 *
 * @author Vernon.Chen
 * @version 1.0 2013-6-20
 */
public class LoginAction
		extends OSSBaseAction {

	// ------------------------------ field names ------------------------------

	private String email;
	private String password;

	// ------------------------------ main methods ------------------------------

	@Override
	public String execute() throws Exception {
		// 第一次访问不拦截
		if (StringUtil.isEmpty(email) && StringUtil.isEmpty(password)) {
			email = WebUtil.getCookie(request, "email");
			password = WebUtil.getCookie(request, "password");
			return "oss_login";
		}
		if (email == null || email.trim().length() == 0) {
			WebUtil.setErrorMessage(this.session, "邮件地址不可为空!");
			return "oss_login";
		}
		if (password == null || password.trim().length() == 0) {
			WebUtil.setErrorMessage(this.session, "密码不可为空!");
			return "oss_login";
		}
		this.ossContext = OSSSvc.login(email, password);
		if (ossContext == null) {
			WebUtil.setErrorMessage(this.session, "登录失败,用户名密码错误,或者您已经被锁定!");
			return "oss_login";
		}
		WebUtil.setContext(this.session, ossContext);
		// 写cookie
		WebUtil.setCookie(response, "email", email);
		WebUtil.setCookie(response, "password", password);
		return "oss_index";
	}

	// ------------------------------- setter / getter methods --------------------

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	
}
