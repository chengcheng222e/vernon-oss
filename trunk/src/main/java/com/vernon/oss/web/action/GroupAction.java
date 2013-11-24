package com.vernon.oss.web.action;

import java.util.List;

import com.vernon.oss.OSSBaseAction;
import com.vernon.oss.common.logger.LogUtil;
import com.vernon.oss.common.util.StringUtil;
import com.vernon.oss.common.web.util.WebUtil;
import com.vernon.oss.domain.OSSGroup;
import com.vernon.oss.service.OSSSvc;

public class GroupAction
		extends OSSBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6491587952602624387L;

	// ------------------------  filed names ------------------------

	private int groupId;
	private List<OSSGroup> groups;
	private OSSGroup group;
	private String token;
	private String remark;
	private String groupName;
	private int hide;

	@Override
	public String execute() throws Exception {
		groups = OSSSvc.getGroup();
		return "oss_group";
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	public String remove() {
		group = OSSSvc.getGroup(groupId);
		if (group == null) {
			groups = OSSSvc.getGroup();
			WebUtil.setErrorMessage(session, "删除的组不存在");
			return "oss_group";
		}

		if (group.isReadOnly()) {
			groups = OSSSvc.getGroup();
			WebUtil.setErrorMessage(session, "删除的组 [" + group.getGroupName() + "] 不存在");
			return "oss_group";
		}
		if (!OSSSvc.deleteGroup(groupId)) {
			groups = OSSSvc.getGroup();
			WebUtil.setErrorMessage(session, "删除的组失败");
			return "oss_group";
		}
		//增加操作日志
		LogUtil.info(getIPAddr(request), this.ossContext.getUser().getUserId(), this.ossContext.getUser().getEmail(),
				"OSS-删除群组", "groupId:" + groupId, "", GroupAction.class);
		request.setAttribute(OPERATOR_MESSAGE, "删除组 [ " + group.getGroupName() + " ] 成功!");
		request.setAttribute(RETURN_URL, "group.do");
		return OSS_OPERATOR_SUCCESS;
	}

	/**
	 * 添加修改
	 * 
	 * @return
	 */
	public String editor() {
		group = OSSSvc.getGroup(groupId);
		if (token == null || !WebUtil.verifyToken(session, token)) {
			token = WebUtil.addToken(session);
			return "oss_group_editor";
		}
		if (StringUtil.isEmpty(groupName)) {
			WebUtil.setErrorMessage(session, "分组名为必填项!");
			return "oss_group_editor";
		}
		if (!OSSSvc.mergerGroup(groupId, groupName, hide != 0, remark)) {
			WebUtil.setErrorMessage(session, "修改失败,请再试一次!");
			return "oss_group_editor";
		}
		//增加操作日志
		LogUtil.info(getIPAddr(request), this.ossContext.getUser().getUserId(), this.ossContext.getUser().getEmail(),
				"OSS-增加/修改分组", "groupId:" + groupId + ",groupName:" + groupName, "", GroupAction.class);
		WebUtil.dropToken(session);
		WebUtil.clearErrorMessage(session);
		request.setAttribute(OPERATOR_MESSAGE, "添加修改组 [ " + groupName + " ] 成功!");
		request.setAttribute(RETURN_URL, "group.do");
		return OSS_OPERATOR_SUCCESS;
	}

	// --------------------- setter / getter methods ---------------------

	public List<OSSGroup> getGroups() {
		return groups;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public OSSGroup getGroup() {
		return group;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getHide() {
		return hide;
	}

	public void setHide(int hide) {
		this.hide = hide;
	}

}
