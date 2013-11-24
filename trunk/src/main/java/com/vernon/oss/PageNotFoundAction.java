package com.vernon.oss;

@SuppressWarnings("serial")
public class PageNotFoundAction
		extends OSSBaseAction {

	@Override
	public String execute() throws Exception {
		
		return "oss_page_not_found";
	}
	
	
	

}
