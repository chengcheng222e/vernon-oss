package com.vernon.oss.web.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.vernon.oss.common.logger.LogUtil;
import com.vernon.oss.common.web.util.ParameterUtil;
import com.vernon.oss.common.web.util.WebUtil;
import com.vernon.oss.domain.OSSRole;
import com.vernon.oss.domain.OSSUser;
import com.vernon.oss.service.OSSService;
import com.vernon.oss.OSSBaseAction;

public class UserRoleAction
		extends OSSBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3768637094939772210L;

	// ---------------------- field names ----------------------

	private String token;
	private int userId;
	private OSSUser user;
	List<OSSRole> roles;
	Map<String, OSSRole> userRoleMap;

	@Override
	public String execute() throws Exception {
		int[] roleIds = ParameterUtil.getParameterForIntegerArray(request, "roleId");

		user = OSSService.getUser(userId);
		if (user == null) {
			WebUtil.setErrorMessage(session, "用户不存在");
			return "oss_user";
		}

		roles = OSSService.getRole();
		userRoleMap = new HashMap<String, OSSRole>();
		Set<OSSRole> userRoles = OSSService.getRoleByUserId(userId);
		for (OSSRole role : userRoles) {
			userRoleMap.put("" + role.getRoleId(), role);
		}

		if (token == null || !WebUtil.verifyToken(session, token)) {
			token = WebUtil.addToken(request.getSession());
			return "oss_user_role_editor";
		}
		boolean result = OSSService.addUserRole(userId, roleIds);
		if (!result) {
			WebUtil.setErrorMessage(session, "修改失败,请再试一次!");
			return "oss_user";
		}

		//增加操作日志
		LogUtil.info(getIPAddr(request), ossContext.getUser().getUserId(), ossContext.getUser().getEmail(),
				"OSS-用户角色编辑", "userId:" + userId, "", UserRoleAction.class);

		WebUtil.dropToken(request.getSession());
		request.setAttribute(OPERATOR_MESSAGE, "用户 [ " + user.getRealName() +" ] 角色设置成功");
		request.setAttribute(RETURN_URL, "user.do");
		return OSS_OPERATOR_SUCCESS;
	}

	// -------------------- setter / getter methods -------------------- 
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

	public OSSUser getUser() {
		return user;
	}

	public void setUser(OSSUser user) {
		this.user = user;
	}

	public List<OSSRole> getRoles() {
		return roles;
	}

	public Map<String, OSSRole> getUserRoleMap() {
		return userRoleMap;
	}
	
	

}
