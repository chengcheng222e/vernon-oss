/**
 * 
 */
package com.vernon.oss.common.db;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 初始化连接池为proxool模式的listener
 * 
 * @author Vernon.Chen
 *
 */
public class ProxoolInitListener implements ServletContextListener {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent contextEvent) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent contextEvent) {
		System.out.println("ProxoolInitListener initialized");
		ConnectionProvider.setProxoolConfig("proxool.xml");
	}

}
