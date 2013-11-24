package com.vernon.oss.common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.vernon.oss.common.Constant;

/**
 * 
 * 
 * @author Vernon.Chen
 *
 */
public class ContextInitListener
	implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent contServletContextEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		servletContextEvent.getServletContext().setAttribute("DOMAIN", Constant.DOMAIN);
		servletContextEvent.getServletContext().setAttribute("USER_URL", Constant.USER_URL);
		servletContextEvent.getServletContext().setAttribute("PARTY_URL", Constant.PARTY_URL);
		servletContextEvent.getServletContext().setAttribute("PARTY_URL", Constant.PARTY_URL);
		servletContextEvent.getServletContext().setAttribute("SHARE_URL", Constant.SHARE_URL);
		servletContextEvent.getServletContext().setAttribute("WENDA_URL", Constant.WENDA_URL);
		servletContextEvent.getServletContext().setAttribute("SETTINGS_URL", Constant.SETTINGS_URL);
		servletContextEvent.getServletContext().setAttribute("JS_BASE_URL", Constant.JS_BASE_URL);
		servletContextEvent.getServletContext().setAttribute("CSS_BASE_URL", Constant.CSS_BASE_URL);
		servletContextEvent.getServletContext().setAttribute("IMG_BASE_URL", Constant.IMG_BASE_URL);
		servletContextEvent.getServletContext().setAttribute("PLUGIN_BASE_URL", Constant.PLUGIN_BASE_URL);
		servletContextEvent.getServletContext().setAttribute("ICON_BASE_DIR", Constant.ICON_BASE_DIR);
		servletContextEvent.getServletContext().setAttribute("ICON_BASE_URL", Constant.ICON_BASE_URL);
	}

}
