package com.vernon.oss;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vernon.Chen
 * @version 1.0 2013-6-20
 */
public class WelcomeAction
		extends OSSBaseAction {

	private static final Logger logger = LoggerFactory.getLogger(WelcomeAction.class);

	@Override
	public String execute() throws Exception {

        logger.info("------- 欢迎进去 WelcomeAction -------");
		return SUCCESS;
	}

}
