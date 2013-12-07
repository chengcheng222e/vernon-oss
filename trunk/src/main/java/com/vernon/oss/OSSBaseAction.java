package com.vernon.oss;

import javax.servlet.http.HttpServletRequest;

import com.vernon.oss.common.web.BaseAction;
import com.vernon.oss.common.web.util.RequestUtil;
import com.vernon.oss.common.web.util.WebUtil;
import com.vernon.oss.domain.OSSContext;
import com.vernon.oss.service.OSSService;

/**
 *
 * @author Vernon.Chen
 * @version 1.0 2013-6-20
 */
public class OSSBaseAction
		extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8130845360466799356L;
	
	// ------------------------------- filed names -----------------------------
	
	protected final String ANONYMOUS = "anonymous";// 未登录
	protected final String FORBID = "forbid";// 无权限
	protected final String OPERATOR_MESSAGE = "OPERATOR_MESSAGE" ;
	protected final String RETURN_URL = "RETURN_URL" ;
	
	protected final String OSS_OPERATOR_SUCCESS = "oss_operator_success" ;
	protected final String OSS_OPERATOR_FAILED = "oss_operator_failed" ;
	protected final String OSS_PAGE_NOT_FOUND = "oss_page_not_found" ;
	
	protected OSSContext ossContext ;
	
	// ------------------------------- construtor method  -----------------------
	
	public OSSBaseAction() {
		HttpServletRequest request = RequestUtil.getRequest() ;
		// 检验是否是游客
		if (!allowAnonymous()) {
			// TODO 
		}
		ossContext =  WebUtil.getContext(request.getSession());
		if (ossContext == null) {
			String email = WebUtil.getCookie(request, "email");
			String password = WebUtil.getCookie(request, "password");
			ossContext = OSSService.login(email, password);
			WebUtil.setContext(request.getSession(), ossContext);
		}
		// 写进访问日志
	}

	// ------------------------------- other methods  -----------------------
	
	/**
	 * 是否支持游客访问
	 * 
	 * @return
	 */
	protected boolean allowAnonymous() {
		return false;
	}

	/**
	 * 获取IP地址
	 * 
	 * @param request
	 * @return
	 */
	protected String getIPAddr(HttpServletRequest request) {
		return RequestUtil.getIPAddr(request);
	}

}
