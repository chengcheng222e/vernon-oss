package com.vernon.oss;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vernon.oss.domain.OSSGroup;
import com.vernon.oss.domain.OSSPopedom;
import com.vernon.oss.service.OSSSvc;

/**
 *
 * @author Vernon.Chen
 * @version 1.0 2013-6-20
 */
public class DashboardAction
		extends OSSBaseAction {

	// ---------------------------- field names ----------------------------

	private List<OSSGroup> groups;
	private Map<String, List<OSSPopedom>> popedomsMap;

	@Override
	public String execute() throws Exception {
		if (this.ossContext == null) {
			return "oss_dashboard";
		}
		//用户分组列表
		groups = OSSSvc.getGroup();
		popedomsMap = new HashMap<String, List<OSSPopedom>>();
		//权限列表
		List<OSSPopedom> popedoms = OSSSvc.getPopedom();
		for (OSSGroup group : groups) {
			List<OSSPopedom> p = new ArrayList<OSSPopedom>();
			for (OSSPopedom popedom : popedoms) {
				if (popedom.isHide() || popedom.getGroupId() != group.getGroupId()) {
					continue;
				}
				for (OSSPopedom up : this.ossContext.getPopedoms()) {
					if (up.getURI().equals("*") || popedom.getURI().startsWith(up.getURI())) {
						p.add(popedom);
						break;
					}
				}
			}
			popedomsMap.put("" + group.getGroupId(), p);
		}
		return "oss_dashboard";
	}

	// ------------------------ setter / getter methods ------------------------

	public List<OSSGroup> getGroups() {
		return groups;
	}

	public Map<String, List<OSSPopedom>> getPopedomsMap() {
		return popedomsMap;
	}
}
