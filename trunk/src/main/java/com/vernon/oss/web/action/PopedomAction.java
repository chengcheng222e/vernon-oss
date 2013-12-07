package com.vernon.oss.web.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vernon.oss.common.logger.LogUtil;
import com.vernon.oss.common.web.util.WebUtil;
import com.vernon.oss.domain.OSSGroup;
import com.vernon.oss.domain.OSSPopedom;
import com.vernon.oss.service.OSSService;
import com.vernon.oss.OSSBaseAction;

/**
 *
 * @author Vernon.Chen
 * @version 1.0 2013-6-21
 */
public class PopedomAction
		extends OSSBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4855117761466869189L;

	// -------------------------- field names --------------------------

	private List<OSSGroup> ossGroups;
	private Map<String, List<OSSPopedom>> popedomMap;
	private int popedomId;
	private int groupId;
	private String remark;
	private String popedomName;
	private String URI;
	private int locked;
	private int hide;
	private String token;
	private OSSPopedom popedom;
	private List<OSSGroup> groups ;

	@Override
	public String execute() throws Exception {
		ossGroups = OSSService.getGroup();
		popedomMap = new HashMap<String, List<OSSPopedom>>();
		for (OSSGroup ossg : ossGroups) {
			List<OSSPopedom> pops = OSSService.getPopedomList(ossg.getGroupId());
			popedomMap.put(ossg.getGroupId() + "", pops);
		}
		return "oss_popedom";
	}

	/**
	 * 编辑
	 * 
	 * @return
	 * @author Vernon.Chen
	 * @date 2013-6-21
	 */
	public String editor() {
		groups = OSSService.getGroup();
		popedom = OSSService.getPopedom(popedomId);
		if (token == null || !WebUtil.verifyToken(session, token)) {
			token = WebUtil.addToken(session);
			return "oss_popedom_editor";
		}
		if (URI == null || URI.trim().length() == 0) {
			WebUtil.setErrorMessage(session, "授权地址为必填项!");
			return "oss_popedom_editor";
		}

		if (popedomName == null || popedomName.trim().length() == 0) {
			WebUtil.setErrorMessage(session, "权限名为必填项!");
			return "oss_popedom_editor";
		}

		OSSGroup group = OSSService.getGroup(groupId);
		if (group == null) {
			WebUtil.setErrorMessage(session, "所属分组为必填项!");
			return "oss_popedom_editor";
		}

		boolean result = OSSService.mergerPopedom(popedomId, groupId, popedomName, locked != 0, hide != 0, URI, remark);
		if (!result) {
			WebUtil.setErrorMessage(session, "修改失败,请再试一次!");
			return "oss_popedom_editor";
		}
		//增加操作日志
		LogUtil.info(getIPAddr(request), ossContext.getUser().getUserId(), ossContext.getUser().getEmail(),
				"OSS-修改/增加权限", "popedomId:" + popedomId + ",popedomName:" + popedomName, "", PopedomAction.class);

		WebUtil.dropToken(request.getSession());
		if (popedom != null) {
			request.setAttribute(OPERATOR_MESSAGE, "权限[ " + popedom.getPopedomName() + " ] 修改成功!");
		} else {
			request.setAttribute(OPERATOR_MESSAGE, "权限 [ " + this.popedomName + " ] 创建成功!");
		}
		request.setAttribute(RETURN_URL, "popedom.do");
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
		popedom = OSSService.getPopedom(popedomId);
		if (popedom == null) {
			execute();
			WebUtil.setErrorMessage(session, "删除的权限不存在");
			return "oss_role";
		}
		if (popedom.isReadOnly()) {
			execute();
			WebUtil.setErrorMessage(session, "删除的 [ " + popedom.getPopedomName() + " ] 权限为只读");
			return "oss_role";
		}
		if (!OSSService.deletePopedom(popedomId)) {
			execute();
			WebUtil.setErrorMessage(session, "删除权限失败");
			return "oss_role";
		}
		//增加操作日志
		LogUtil.info(getIPAddr(request), ossContext.getUser().getUserId(), ossContext.getUser().getEmail(),
				"OSS-删除权限", "popedomId:" + popedomId + ",popedomName:" + popedomName, "", PopedomAction.class);

		request.setAttribute(OPERATOR_MESSAGE, "删除权限 [ " + popedom.getPopedomName() + " ] 成功!");
		request.setAttribute(RETURN_URL, "popedom.do");
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
		popedom = OSSService.getPopedom(popedomId);
		if (popedom == null) {
			execute();
			WebUtil.setErrorMessage(session, "解锁权限不存在");
			return "oss_popedom";
		}
		if (popedom.isReadOnly() || !popedom.isLocked()) {
			execute();
			WebUtil.setErrorMessage(session, "解锁的权限 [ " + popedom.getPopedomName() + " ] 为只读 ,或者已经是解锁状态");
			return "oss_popedom";
		}
		if (!OSSService.unlockPopedom(popedomId)) {
			return "oss_operator_failed";
		}
		//增加操作日志
		LogUtil.info(getIPAddr(request), this.ossContext.getUser().getUserId(), this.ossContext.getUser().getEmail(),
				"OSS-解锁权限", "popedomId:" + popedomId, "", PopedomAction.class);
		request.setAttribute(OPERATOR_MESSAGE, "解锁权限 [ " + popedom.getPopedomName() + " ] 成功!");
		request.setAttribute(RETURN_URL, "popedom.do");
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
		popedom = OSSService.getPopedom(popedomId);
		if (popedom == null) {
			execute();
			WebUtil.setErrorMessage(session, "锁定权限不存在");
			return "oss_popedom";
		}
		if (popedom.isReadOnly() || popedom.isLocked()) {
			execute();
			WebUtil.setErrorMessage(session, "锁定的角色 [ " + popedom.getPopedomName() + " ] 权限为只读 ,或者已经是锁定状态");
			return "oss_role";
		}
		if (!OSSService.lockPopedom(popedomId)) {
			return "oss_operator_failed";
		}
		//增加操作日志
		LogUtil.info(getIPAddr(request), this.ossContext.getUser().getUserId(), this.ossContext.getUser().getEmail(),
				"OSS-锁定角色", "popedomId:" + popedomId, "", RoleAction.class);
		request.setAttribute(OPERATOR_MESSAGE, "锁定权限 [ " + popedom.getPopedomName() + " ] 成功!");
		request.setAttribute(RETURN_URL, "popedom.do");
		return "oss_operator_success";
	}
	// ---------------------------- setter / getter methods ----------------------------

	public List<OSSGroup> getOssGroups() {
		return ossGroups;
	}

	public Map<String, List<OSSPopedom>> getPopedomMap() {
		return popedomMap;
	}

	public int getPopedomId() {
		return popedomId;
	}

	public void setPopedomId(int popedomId) {
		this.popedomId = popedomId;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPopedomName() {
		return popedomName;
	}

	public void setPopedomName(String popedomName) {
		this.popedomName = popedomName;
	}

	public String getURI() {
		return URI;
	}

	public void setURI(String uRI) {
		URI = uRI;
	}

	public int getLocked() {
		return locked;
	}

	public void setLocked(int locked) {
		this.locked = locked;
	}

	public int getHide() {
		return hide;
	}

	public void setHide(int hide) {
		this.hide = hide;
	}

	public void setPopedomMap(Map<String, List<OSSPopedom>> popedomMap) {
		this.popedomMap = popedomMap;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public OSSPopedom getPopedom() {
		return popedom;
	}

	public List<OSSGroup> getGroups() {
		return groups;
	}
	
}
