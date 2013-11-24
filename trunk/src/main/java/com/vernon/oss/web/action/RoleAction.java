package com.vernon.oss.web.action;

import java.util.List;

import com.vernon.oss.common.logger.LogUtil;
import com.vernon.oss.common.web.util.WebUtil;
import com.vernon.oss.domain.OSSRole;
import com.vernon.oss.service.OSSSvc;
import com.vernon.oss.OSSBaseAction;

/**
 *
 * @author Vernon.Chen
 * @version 1.0 2013-6-21
 */
public class RoleAction
		extends OSSBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1568201539175912221L;

	// -------------------------- field names --------------------------
	private String token;
	private int roleId;
	private String remark;
	private String roleName;
	private int locked;
	private List<OSSRole> roles;
	private OSSRole role;

	/*
	 * (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		roles = OSSSvc.getRole();
		return "oss_role";
	}

	/**
	 * 角色编辑
	 * 
	 * @return
	 * @author Vernon.Chen
	 * @date 2013-6-21
	 */
	public String editor() {
		// 设置用户
		role = OSSSvc.getRole(roleId);
		if (token == null || !WebUtil.verifyToken(session, token)) {
			token = WebUtil.addToken(session);
			return "oss_role_editor";
		}

		if (roleName == null || roleName.trim().length() == 0) {
			WebUtil.setErrorMessage(session, "角色名为必填项!");
			return "oss_role_editor";
		}
		boolean result = OSSSvc.mergerRole(roleId, roleName, locked != 0, remark);
		if (!result) {
			WebUtil.setErrorMessage(session, "修改失败,请再试一次!");
			return "oss_role_editor";
		}

		//增加操作日志
		LogUtil.info(getIPAddr(request), this.ossContext.getUser().getUserId(), this.ossContext.getUser().getEmail(),
				"OSS-编辑角色", "roleId:" + roleId + ",remark:" + remark, "", RoleAction.class);

		WebUtil.dropToken(session);
		if (role != null) {
			request.setAttribute(OPERATOR_MESSAGE, "角色 [ " + role.getRoleName() + " ] 修改成功!");
		} else {
			request.setAttribute(OPERATOR_MESSAGE, "角色 [ " + roleName + " ] 创建成功!");
		}
		request.setAttribute(RETURN_URL, "role.do");
		return "oss_operator_success";
	}

	/**
	 * 删除
	 * 
	 * @return
	 * @author Vernon.Chen
	 * @date 2013-6-21
	 */
	public String remove() {
		role = OSSSvc.getRole(roleId);
		if (role == null) {
			roles = OSSSvc.getRole();
			WebUtil.setErrorMessage(session, "删除的角色不存在");
			return "oss_role";
		}
		if (role.isReadOnly()) {
			roles = OSSSvc.getRole();
			WebUtil.setErrorMessage(session, "删除的角色 [ " + role.getRoleName() + " ] 权限为只读");
			return "oss_role";
		}
		if (!OSSSvc.deleteRole(roleId)) {
			roles = OSSSvc.getRole();
			WebUtil.setErrorMessage(session, "删除的角色失败");
			return "oss_role";
		}
		//增加操作日志
		LogUtil.info(getIPAddr(request), this.ossContext.getUser().getUserId(), this.ossContext.getUser().getEmail(),
				"OSS-删除角色", "roleId:" + roleId, "", RoleAction.class);
		request.setAttribute(OPERATOR_MESSAGE, "删除角色 [ " + role.getRoleName() + " ] 成功!");
		request.setAttribute(RETURN_URL, "role.do");
		return "oss_operator_success";
	}

	/**
	 * 解锁
	 * 
	 * @return
	 * @author Vernon.Chen
	 * @date 2013-6-21
	 */
	public String unlock() {
		role = OSSSvc.getRole(roleId);
		if (role == null) {
			roles = OSSSvc.getRole();
			WebUtil.setErrorMessage(session, "解锁的角色不存在");
			return "oss_role";
		}
		if (role.isReadOnly() || !role.isLocked()) {
			roles = OSSSvc.getRole();
			WebUtil.setErrorMessage(session, "解锁的角色 [ " + role.getRoleName() + " ] 权限为只读 ,或者已经是解锁状态");
			return "oss_role";
		}
		if (!OSSSvc.unlockRole(roleId)) {
			return "oss_operator_failed";
		}
		//增加操作日志
		LogUtil.info(getIPAddr(request), this.ossContext.getUser().getUserId(), this.ossContext.getUser().getEmail(),
				"OSS-解锁角色", "roleId:" + roleId, "", RoleAction.class);
		request.setAttribute(OPERATOR_MESSAGE, "解锁角色 [ " + role.getRoleName() + " ] 成功!");
		request.setAttribute(RETURN_URL, "role.do");
		return "oss_operator_success";
	}

	/**
	 * 锁定
	 * 
	 * @return
	 * @author Vernon.Chen
	 * @date 2013-6-21
	 */
	public String lock() {
		role = OSSSvc.getRole(roleId);
		if (role == null) {
			roles = OSSSvc.getRole();
			WebUtil.setErrorMessage(session, "锁定的角色不存在");
			return "oss_role";
		}
		if (role.isReadOnly() || role.isLocked()) {
			roles = OSSSvc.getRole();
			WebUtil.setErrorMessage(session, "锁定的角色 [ " + role.getRoleName() + " ] 权限为只读 ,或者已经是锁定状态");
			return "oss_role";
		}
		if (!OSSSvc.lockRole(roleId)) {
			return "oss_operator_failed";
		}
		//增加操作日志
		LogUtil.info(getIPAddr(request), this.ossContext.getUser().getUserId(), this.ossContext.getUser().getEmail(),
				"OSS-锁定角色", "roleId:" + roleId, "", RoleAction.class);
		request.setAttribute(OPERATOR_MESSAGE, "锁定角色 [ " + role.getRoleName() + " ] 成功!");
		request.setAttribute(RETURN_URL, "role.do");
		return "oss_operator_success";
	}

	// -------------------------- setter / getter methods -----------------

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getLocked() {
		return locked;
	}

	public void setLocked(int locked) {
		this.locked = locked;
	}

	public List<OSSRole> getRoles() {
		return roles;
	}

	public OSSRole getRole() {
		return role;
	}
}
