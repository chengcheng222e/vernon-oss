
package com.vernon.oss.common.web.util;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Vernon.Chen
 * @version 1.0 2012-11-22
 */
public class ResponseUtil {
	
	/**
	 * 获取HttpServletResponse
	 * 
	 * @return
	 */
	public static HttpServletResponse getResponse(){
		return ServletActionContext.getResponse();
	}

}
