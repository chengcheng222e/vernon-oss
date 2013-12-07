package com.vernon.oss.domain;

import java.util.Date;

import com.vernon.oss.service.OSSService;

/**
 * 
 * 后台操作日志
 * 
 * @author Vernon.Chen
 *
 */
public class OSSOP {

	//操作时间
	private Date opTime;
	//	用户ID
	private int userId;
	//操作IP
	private String IP;
	//操作名
	private String title;
	//	操作内容
	private String content;
	//操作类名
	private String className;
	//	备注
	private String remark;

	/**
	 * @return the opTime
	 */
	public final Date getOpTime() {
		return opTime;
	}

	/**
	 * @param opTime the opTime to set
	 */
	public final void setOpTime(Date opTime) {
		this.opTime = opTime;
	}

	/**
	 * @return the userId
	 */
	public final int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public final void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the iP
	 */
	public final String getIP() {
		return IP;
	}

	/**
	 * @param iP the iP to set
	 */
	public final void setIP(String iP) {
		IP = iP;
	}

	/**
	 * @return the title
	 */
	public final String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public final void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the content
	 */
	public final String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public final void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the className
	 */
	public final String getClassName() {
		return className;
	}

	/**
	 * @param className the className to set
	 */
	public final void setClassName(String className) {
		this.className = className;
	}

	/**
	 * @return the remark
	 */
	public final String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public final void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 
	 * @return
	 */
	public final String getUserName() {
		OSSUser user = OSSService.getUser(this.getUserId());
		if (user != null) {
			return user.getRealName();
		}
		return "";
	}

}
