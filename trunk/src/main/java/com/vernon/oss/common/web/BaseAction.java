package com.vernon.oss.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author Vernon.Chen
 * @version 1.0 2013-6-20
 */
public class BaseAction
		extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1089790314743040168L;

	protected HttpServletRequest request;

	protected HttpServletResponse response;

	protected HttpSession session;
	
	public BaseAction() {
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		session = request.getSession();
	}

}
