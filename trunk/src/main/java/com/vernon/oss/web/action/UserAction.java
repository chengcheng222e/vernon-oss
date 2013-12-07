package com.vernon.oss.web.action;

import com.vernon.oss.common.collection.PageSplit;
import com.vernon.oss.common.logger.LogUtil;
import com.vernon.oss.common.util.MailUtil;
import com.vernon.oss.common.util.UUIDUtil;
import com.vernon.oss.common.web.util.WebUtil;
import com.vernon.oss.domain.OSSUser;
import com.vernon.oss.service.OSSService;
import com.vernon.oss.OSSBaseAction;

/**
 * 
 * @author Vernon.Chen
 * @version 1.0 2013-6-21
 */
public class UserAction
		extends OSSBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1568201539175912221L;

	// -------------------------- field names --------------------------
	private final int MAX_ITEM = 5;
	private String token;
	private int userId;
	private String email;
	private String remark;
	private String realName;
	private int locked;
	private OSSUser user;
	private int pageIndex;
	private PageSplit<OSSUser> users;

	/*
	 * (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		users = OSSService.getUser(pageIndex, MAX_ITEM);
		return "oss_user";
	}

	/**
	 * 角色编辑
	 * 
	 * @return
	 * @author Vernon.Chen
	 * @throws Exception
	 * @date 2013-6-21
	 */
	public String editor() throws Exception {
		user = OSSService.getUser(userId);
		if (token == null || !WebUtil.verifyToken(session, token)) {
			token = WebUtil.addToken(session);
			return "oss_user_editor";
		}
		if (email == null || email.trim().length() == 0) {
			execute();
			WebUtil.setErrorMessage(session, "电子邮件地址为必填项!");
			return "oss_user";
		}
		if (realName == null || realName.trim().length() == 0) {
			execute();
			WebUtil.setErrorMessage(session, "真实姓名为必填项!");
			return "oss_user";
		}
		OSSUser emailUser = OSSService.getUser(email);
		if (emailUser != null && emailUser.getUserId() != userId) {
			execute();
			WebUtil.setErrorMessage(session, "您所输入的电子邮件地址已经被占用!");
			return "oss_user";
		}
		String password = UUIDUtil.getUUID().substring(0, 10);
		boolean result = OSSService.mergerUser(userId, email, password, realName, locked != 0, remark);
		if (!result) {
			execute();
			WebUtil.setErrorMessage(request.getSession(), "修改失败,请再试一次!");
			return "oss_user";
		}

		// 增加操作日志
		LogUtil.info(getIPAddr(request), ossContext.getUser().getUserId(), ossContext.getUser().getEmail(), "OSS-修改用户",
				"userId:" + userId + ",email:" + email, "", UserAction.class);
		WebUtil.dropToken(session);
		if (user != null) {
			request.setAttribute(OPERATOR_MESSAGE, "修改用户 [ " + user.getRealName() + " ] 信息成功!");
		} else {
			request.setAttribute(OPERATOR_MESSAGE, "创建用户 [ " + realName + " ] 成功!");
		}
		request.setAttribute(RETURN_URL, "user.do");
		return "oss_operator_success";
	}

	/**
	 * 删除
	 * 
	 * @return
	 * @author Vernon.Chen
	 * @throws Exception
	 * @date 2013-6-21
	 */
	public String remove() throws Exception {
		user = OSSService.getUser(userId);
		if (user == null) {
			execute();
			WebUtil.setErrorMessage(session, "删除的用户不存在");
			return "oss_user";
		}
		if (user.isReadOnly()) {
			execute();
			WebUtil.setErrorMessage(session, "删除的用户 [ " + user.getRealName() + " ] 是只读状态");
			return "oss_user";
		}
		if (!OSSService.deleteUser(userId)) {
			execute();
			WebUtil.setErrorMessage(session, "删除的用户 [ " + user.getRealName() + " ] 失败");
			return "oss_user";
		}
		LogUtil.info(getIPAddr(request), ossContext.getUser().getUserId(), ossContext.getUser().getEmail(), "OSS-删除用户",
				"userId:" + userId, "", UserAction.class);
		request.setAttribute(OPERATOR_MESSAGE, "删除的用户 [ " + user.getRealName() + " ] 成功");
		request.setAttribute(RETURN_URL, "user.do");
		return "oss_operator_success";
	}

	/**
	 * 解锁
	 * 
	 * @return
	 * @author Vernon.Chen
	 * @throws Exception 
	 * @date 2013-6-21
	 */
	public String unlock() throws Exception {
		user = OSSService.getUser(userId);
		if (user == null) {
			execute();
			WebUtil.setErrorMessage(session, "解锁的用户不存在");
			return "oss_user";
		}
		if (user.isReadOnly() || !user.isLocked()) {
			execute();
			WebUtil.setErrorMessage(session, "解锁的用户 [ " + user.getRealName() + " ] 是只读状态, 或者用户已经是解锁状态");
			return "oss_user";
		}
		if (!OSSService.unlockUser(userId)) {
			execute();
			WebUtil.setErrorMessage(session, "解锁的用户 [ " + user.getRealName() + " ] 失败");
			return "oss_user";
		}
		request.setAttribute(OPERATOR_MESSAGE, "解锁的用户 [ " + user.getRealName() + " ] 成功") ;
		request.setAttribute(RETURN_URL, "user.do") ;
		return "oss_operator_success";
	}

	/**
	 * 锁定
	 * 
	 * @return
	 * @author Vernon.Chen
	 * @throws Exception 
	 * @date 2013-6-21
	 */
	public String lock() throws Exception {
		user = OSSService.getUser(userId);
		if (user == null) {
			execute();
			WebUtil.setErrorMessage(session, "锁定的用户不存在");
			return "oss_user";
		}
		if (user.isReadOnly() || user.isLocked()) {
			execute();
			WebUtil.setErrorMessage(session, "锁定的用户 [ " + user.getRealName() + " ] 是只读状态, 或者用户已经是锁定状态");
			return "oss_user";
		}
		if (!OSSService.lockUser(userId)) {
			execute();
			WebUtil.setErrorMessage(session, "锁定的用户 [ " + user.getRealName() + " ] 失败");
			return "oss_user";
		}
		request.setAttribute(OPERATOR_MESSAGE, "锁定的用户 [ " + user.getRealName() + " ] 成功") ;
		request.setAttribute(RETURN_URL, "user.do") ;
		return "oss_operator_success";
	}

	/**
	 * 密码重设
	 * 
	 * @return
	 * @throws Exception 
	 */
	public String passwordReset () throws Exception {
		user = OSSService.getUser(userId);
		if (user == null) {
			execute();
			WebUtil.setErrorMessage(session, "用户不存在");
			return "oss_user";
		}
		String password = UUIDUtil.getUUID().substring(0, 10) ;
		if (!OSSService.mergerPassword(userId, password)) {
			execute();
			WebUtil.setErrorMessage(session, "用户 [ " + user.getRealName() + " ] 的密码设置失败.请重新设置");
			return "oss_user";
		}
		// 成功之后,需要发送一封邮件给用户
		MailUtil.sendMail(user.getEmail(), "用户 [ " + user.getRealName()+" ] 您好,您的新密码为: " + password + ", 请妥善保管.", "XXX运营支撑系统用户密码重设");
		LogUtil.info(getIPAddr(request), this.ossContext.getUser().getUserId(), this.ossContext.getUser().getEmail(),
				"OSS-用户重设密码", "userId:" + userId, "", UserAction.class) ;
		request.setAttribute(OPERATOR_MESSAGE, "用户 [ " + user.getRealName() + " ] 的密码设置成功");
		request.setAttribute(RETURN_URL, "user.do");
		return "oss_operator_success";
	}
	// -------------------------- setter / getter methods -----------------

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public int getLocked() {
		return locked;
	}

	public void setLocked(int locked) {
		this.locked = locked;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public OSSUser getUser() {
		return user;
	}

	public PageSplit<OSSUser> getUsers() {
		return users;
	}

}
