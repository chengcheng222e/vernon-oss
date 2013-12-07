package com.vernon.oss.web.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.vernon.oss.common.logger.LogUtil;
import com.vernon.oss.common.web.util.ParameterUtil;
import com.vernon.oss.common.web.util.WebUtil;
import com.vernon.oss.domain.OSSGroup;
import com.vernon.oss.domain.OSSPopedom;
import com.vernon.oss.domain.OSSRole;
import com.vernon.oss.service.OSSService;
import com.vernon.oss.OSSBaseAction;

/**
 *
 * @author Vernon.Chen
 * @version 1.0 2013-6-21
 */
public class RolePopedomAction
		extends OSSBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4868719844667434097L;

	// -------------------------- field names --------------------------
	private int roleId;
	private String token ;
	private Map<String, List<OSSPopedom>> popedomMap;
	private OSSRole role;
	private int[] popedomIds;
	private List<OSSGroup> groupList;
	private Map<String, OSSPopedom> rolePopedomMap;
	private List<OSSRole> roles;

	@Override
	public String execute() throws Exception {
		List<Integer> popsArr = new ArrayList<Integer>();
		
		role = OSSService.getRole(roleId);
		if (role == null) {
			roles = OSSService.getRole();
			WebUtil.setErrorMessage(session, "编辑的角色不存在");
			return "oss_role";
		}
		
		groupList = OSSService.getGroup();
		popedomMap = new HashMap<String, List<OSSPopedom>>();
		for (OSSGroup ossg : groupList) {
			popedomMap.put(ossg.getGroupId() + "", OSSService.getPopedomList(ossg.getGroupId()));
			popedomIds = ParameterUtil.getParameterForIntegerArray(request, "popedomId" + ossg.getGroupId());
			if (popedomIds != null) {
				for (int i = 0; i < popedomIds.length; i++) {
					popsArr.add(popedomIds[i]);
				}
			}
		}
		
		if (popsArr != null && popsArr.size() > 0) {
			popedomIds = new int[popsArr.size()];
			for (int i = 0; i < popsArr.size(); i++) {
				popedomIds[i] = popsArr.get(i).intValue();
			}
		}
		
		rolePopedomMap = new HashMap<String, OSSPopedom>();
		Set<OSSPopedom> rolePopedoms = OSSService.getPopedomByRoleId(roleId);
		for (OSSPopedom popedom : rolePopedoms) {
			rolePopedomMap.put("" + popedom.getPopedomId(), popedom);
		}
		
		if (token == null || !WebUtil.verifyToken(session, token)) {
			token = WebUtil.addToken(request.getSession());
			return "oss_role_popedom_editor";
		}
		
		boolean result = OSSService.addRolePopedom(roleId, popedomIds);
		if (!result) {
			WebUtil.setErrorMessage(session, "修改失败,请再试一次!");
			return "oss_role_popedom_editor";
		}

		WebUtil.dropToken(session);
		
		//增加操作日志
		LogUtil.info(getIPAddr(request), this.ossContext.getUser().getUserId(), this.ossContext.getUser().getEmail(),
				"OSS-修改角色对应的权限", "roleId:" + roleId, "", RolePopedomAction.class);
		
		request.setAttribute(OPERATOR_MESSAGE, "角色 [ " + role.getRoleName() + " ] 权限对应关系编辑成功!");
		request.setAttribute(RETURN_URL, "rolePopedom.do?roleId=" + role.getRoleId());
		return "oss_operator_success";
	}

	// -------------------------- setter / getter methods -----------------

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public Map<String, List<OSSPopedom>> getPopedomMap() {
		return popedomMap;
	}

	public OSSRole getRole() {
		return role;
	}

	public List<OSSGroup> getGroupList() {
		return groupList;
	}

	public Map<String, OSSPopedom> getRolePopedomMap() {
		return rolePopedomMap;
	}

	public void setPopedomIds(int[] popedomIds) {
		this.popedomIds = popedomIds;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<OSSRole> getRoles() {
		return roles;
	}

}
