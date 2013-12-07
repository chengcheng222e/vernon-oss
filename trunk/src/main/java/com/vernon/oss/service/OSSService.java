/**
 * 
 */
package com.vernon.oss.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.vernon.oss.common.collection.PageSplit;
import com.vernon.oss.common.db.ConnectionProvider;
import com.vernon.oss.dao.OSSGroupDao;
import com.vernon.oss.dao.OSSPopedomDao;
import com.vernon.oss.dao.OSSRoleDao;
import com.vernon.oss.dao.OSSRolePopedomDao;
import com.vernon.oss.dao.OSSUserDao;
import com.vernon.oss.dao.OSSUserRoleDao;
import com.vernon.oss.domain.OSSContext;
import com.vernon.oss.domain.OSSGroup;
import com.vernon.oss.domain.OSSPopedom;
import com.vernon.oss.domain.OSSRole;
import com.vernon.oss.domain.OSSRolePopedom;
import com.vernon.oss.domain.OSSUser;
import com.vernon.oss.domain.OSSUserRole;

/**
 * 管理后台的应用层接口(用户/角色/资源/登录相关)
 * 
 * @author Vernon.Chen
 *
 */
public class OSSService {

	private static final Logger logger = Logger.getLogger(OSSService.class);

	private static final OSSUserDao userDao = new OSSUserDao();

	private static final OSSUserRoleDao userRoleDao = new OSSUserRoleDao();

	private static final OSSRoleDao roleDao = new OSSRoleDao();

	private static final OSSPopedomDao popedomDao = new OSSPopedomDao();

	private static final OSSRolePopedomDao rolePopedomDao = new OSSRolePopedomDao();

	private static final OSSGroupDao groupDao = new OSSGroupDao();

	/**
	 * 用户登录的接口
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	public static OSSContext login(String email, String password) {
		try {
			OSSUser user = getUser(email);
			if (user == null) {
				return null;
			}
			if (user.isLocked()) {
				return null;
			}
			if (!user.getPassword().equals(password)) {
				return null;
			}
			Set<OSSRole> roles = getRoleByUserId(user.getUserId());
			Set<OSSPopedom> popedoms = new HashSet<OSSPopedom>();
			if (roles != null) {
				for (OSSRole role : roles) {
					if (role == null) {
						continue;
					}
					if (role.isLocked()) {
						continue;
					}
					Set<OSSPopedom> ps = getPopedomByRoleId(role.getRoleId());
					if (ps == null || ps.size() == 0) {
						continue;
					}
					for (OSSPopedom p : ps) {
						if (p.isLocked()) {
							continue;
						}
						popedoms.add(p);
					}
				}
			}
			OSSContext context = new OSSContext();
			context.setUser(user);
			context.setRoles(roles);
			context.setPopedoms(popedoms);
			return context;
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}

	/**
	 * 获取用户
	 * 
	 * @param userId
	 * @return
	 */
	public static OSSUser getUser(int userId) {
		try {
			return userDao.get(userId);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return null;
	}

	/**
	 * 获取用户
	 * 
	 * @param email
	 * @return
	 */
	public static OSSUser getUser(String email) {
		try {
			return userDao.get(email);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return null;
	}

	/**
	 * 修改用户锁定状态
	 * 
	 * @param userId
	 * @return
	 */
	public static boolean lockUser(Integer userId) {
		try {
			OSSUser user = getUser(userId);
			return !(user == null || user.isReadOnly() || user.isLocked()) && userDao.mergerLocked(userId, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return false;
	}

	/**
	 * 删除用户
	 * 
	 * @param userId
	 * @return
	 */
	public static boolean deleteUser(Integer userId) {
		try {
			OSSUser user = getUser(userId);
			return !(user == null || user.isReadOnly()) && userDao.delete(userId);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return false;
	}

	/**
	 * 修改用户锁定状态
	 * 
	 * @param userId
	 * @return
	 */
	public static boolean unlockUser(Integer userId) {
		try {
			OSSUser user = getUser(userId);
			return !(user == null || user.isReadOnly() || !user.isLocked()) && userDao.mergerLocked(userId, false);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return false;
	}

	/**
	 * 获取用户列表
	 * 
	 * @param pageId
	 * @param maxLength
	 * @return
	 */
	public static PageSplit<OSSUser> getUser(int pageId, int maxLength) {
		try {
			PageSplit<OSSUser> pagination = new PageSplit<OSSUser>(userDao.getTotal(), pageId, maxLength);
			pagination.setList(userDao.get(pagination.getFromIndex(), pagination.getMaxLength()));
			return pagination;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return null;
	}

	public static List<OSSUser> getList() {
		return userDao.getList();
	}

	/**
	 * 修改用户密码
	 * 
	 * @param userId
	 * @param password
	 * @return
	 */
	public static final boolean mergerPassword(int userId, String password) {
		try {
			OSSUser user = getUser(userId);
			if (user == null) {
				return false;
			}
			return userDao.mergerPassword(userId, password);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return false;
	}

	/**
	 * 修改用户信息
	 * 
	 * @param userId
	 * @param email
	 * @param password
	 * @param realName
	 * @param locked
	 * @param remark
	 * @return
	 */
	public static boolean mergerUser(int userId, String email, String password, String realName, boolean locked,
			String remark) {
		try {
			OSSUser user = getUser(userId);
			if (user == null) {
				return userDao.persist(email, password, realName, locked, false, remark);
			}
			return !user.isReadOnly()
					&& userDao.merger(userId, email, password, realName, locked, user.isReadOnly(), remark);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return false;
	}

	/**
	 * 增加用户角色
	 * 
	 * @param userId
	 * @param roleIds
	 * @return
	 */
	public static boolean addUserRole(int userId, int[] roleIds) {
		try {
			if (roleIds == null) {
				return false;
			}
			OSSUser user = getUser(userId);
			if (user == null) {
				return false;
			}
			// 清理数据
			List<OSSUserRole> userRoles = userRoleDao.getByUserId(userId);
			for (OSSUserRole userRole : userRoles) {
				if (userRole.isReadOnly()) {
					continue;
				}
				userRoleDao.delete(userId, userRole.getRoleId());
			}
			for (int roleId : roleIds) {
				OSSRole role = getRole(roleId);
				if (role == null) {
					continue;
				}
				OSSUserRole userRole = userRoleDao.get(userId, roleId);
				if (userRole == null) {
					userRoleDao.persist(userId, roleId, false);
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return false;
	}

	/**
	 * 删除用户角色
	 * 
	 * @param userId
	 * @param roleIds
	 * @return
	 */
	public static boolean deleteUserRole(int userId, int[] roleIds) {
		try {
			if (roleIds == null) {
				return false;
			}
			OSSUser user = getUser(userId);
			if (user == null) {
				return false;
			}
			for (int roleId : roleIds) {
				OSSUserRole userRole = userRoleDao.get(userId, roleId);
				if (userRole == null || userRole.isReadOnly()) {
					continue;
				}
				userRoleDao.delete(userId, roleId);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return false;

	}

	/**
	 * 获取某个用户的角色列表
	 * 
	 * @param userId
	 * @return
	 */
	public static Set<OSSRole> getRoleByUserId(int userId) {
		Set<OSSRole> roles = new HashSet<OSSRole>();
		try {

			List<OSSUserRole> userRoles = userRoleDao.getByUserId(userId);
			if (userRoles != null) {
				for (OSSUserRole userRole : userRoles) {
					if (userRole == null) {
						continue;
					}
					OSSRole role = getRole(userRole.getRoleId());
					if (role != null) {
						roles.add(role);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return roles;
	}

	/**
	 * 获取角色
	 * 
	 * @param roleId
	 * @return
	 */
	public static OSSRole getRole(int roleId) {
		try {
			return roleDao.get(roleId);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return null;
	}

	/**
	 * 返回角色列表
	 * 
	 * @return
	 */
	public static List<OSSRole> getRole() {
		try {
			return roleDao.get();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return null;
	}

	/**
	 * 修改/新增角色
	 * 
	 * @param roleId
	 * @param roleName
	 * @param lock
	 * @param remark
	 * @return
	 */
	public static boolean mergerRole(int roleId, String roleName, boolean lock, String remark) {
		try {
			OSSRole role = getRole(roleId);
			if (role == null) {
				return roleDao.persist(roleName, lock, false, remark);
			}
			return !role.isReadOnly() && roleDao.merger(roleId, roleName, lock, role.isReadOnly(), remark);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return false;
	}

	/**
	 * 修改锁定状态
	 * 
	 * @param roleId
	 * @return
	 */
	public static boolean lockRole(int roleId) {
		try {
			OSSRole role = getRole(roleId);
			return !(role == null || role.isReadOnly() || role.isLocked()) && roleDao.mergerLocked(roleId, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return false;
	}

	/**
	 * 修改锁定状态
	 * 
	 * @param roleId
	 * @return
	 */
	public static boolean unlockRole(int roleId) {
		try {
			OSSRole role = getRole(roleId);
			return !(role == null || role.isReadOnly() || !role.isLocked()) && roleDao.mergerLocked(roleId, false);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return false;
	}

	/**
	 * 删除角色
	 * 
	 * @param roleId
	 * @return
	 */
	public static boolean deleteRole(int roleId) {
		try {
			OSSRole role = getRole(roleId);
			if (role == null || role.isReadOnly()) {
				return false;
			}
			roleDao.delete(roleId);
			userRoleDao.deleteByRoleId(roleId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return false;
	}

	/**
	 * 获取资源列表
	 * 
	 * @param roleId
	 * @return
	 */
	public static Set<OSSPopedom> getPopedomByRoleId(int roleId) {
		Set<OSSPopedom> popedoms = new HashSet<OSSPopedom>();
		try {
			List<OSSRolePopedom> rolePopedoms = rolePopedomDao.getByRoleId(roleId);
			if (rolePopedoms != null) {
				for (OSSRolePopedom rolePopedom : rolePopedoms) {
					if (rolePopedom == null) {
						continue;
					}
					OSSPopedom popedom = getPopedom(rolePopedom.getPopedomId());
					if (popedom == null) {
						continue;
					}
					popedoms.add(popedom);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return popedoms;
	}

	/**
	 * 添加角色/资源对应关系
	 * 
	 * @param roleId
	 * @param popedomIds
	 * @return
	 */
	public static boolean addRolePopedom(int roleId, int[] popedomIds) {
		try {
			if (popedomIds == null) {
				return false;
			}
			OSSRole role = getRole(roleId);
			if (role == null) {
				return false;
			}

			// 清理数据
			List<OSSRolePopedom> rolePopedoms = rolePopedomDao.getByRoleId(roleId);
			for (OSSRolePopedom rolePopedom : rolePopedoms) {
				if (rolePopedom.isReadOnly()) {
					continue;
				}
				rolePopedomDao.delete(roleId, rolePopedom.getPopedomId());
			}

			for (int popedomId : popedomIds) {
				OSSPopedom popedom = getPopedom(popedomId);
				if (popedom == null) {
					continue;
				}
				OSSRolePopedom rolePopedom = rolePopedomDao.get(roleId, popedomId);
				if (rolePopedom == null) {
					rolePopedomDao.persist(roleId, popedomId, false);
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return false;
	}

	/**
	 * 删除角色/资源对应关系
	 * 
	 * @param roleId
	 * @param popedomIds
	 * @return
	 */
	public static boolean deleteRolePopedom(int roleId, int[] popedomIds) {
		try {
			if (popedomIds == null) {
				return false;
			}
			OSSRole role = getRole(roleId);
			if (role == null) {
				return false;
			}
			for (int popedomId : popedomIds) {
				rolePopedomDao.delete(roleId, popedomId);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return false;
	}

	/**
	 * 获取资源
	 * 
	 * @param popedomId
	 * @return
	 */
	public static OSSPopedom getPopedom(int popedomId) {
		try {
			return popedomDao.getByPopedomId(popedomId);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return null;
	}

	/**
	 * 获取资源列表
	 * 
	 * @return
	 */
	public static List<OSSPopedom> getPopedom() {
		try {
			return popedomDao.get();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return null;
	}

	/**
	 * 获取资源列表
	 * 
	 * @return
	 */
	public static List<OSSPopedom> getPopedomList(int groupId) {
		try {
			return popedomDao.get(groupId);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return null;
	}

	/**
	 * 删除资源
	 * 
	 * @param popedomId
	 * @return
	 */
	public static boolean deletePopedom(int popedomId) {
		try {
			OSSPopedom popedom = getPopedom(popedomId);
			if (popedom == null || popedom.isReadOnly()) {
				return false;
			}
			popedomDao.deleteByPopedomId(popedomId);
			rolePopedomDao.deleteByPopedomId(popedomId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return false;
	}

	/**
	 * 修改资源
	 * 
	 * @param popedomId
	 * @param groupId
	 * @param popedomName
	 * @param lock
	 * @param hide
	 * @param URI
	 * @param remark
	 * @return
	 */
	public static boolean mergerPopedom(int popedomId, int groupId, String popedomName, boolean lock, boolean hide,
			String URI, String remark) {
		try {
			OSSPopedom popedom = getPopedom(popedomId);
			if (popedom == null) {
				return popedomDao.persist(groupId, popedomName, lock, hide, false, URI, remark);
			}
			return !popedom.isReadOnly()
					&& popedomDao.merger(popedomId, groupId, popedomName, lock, hide, false, URI, remark);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return false;
	}

	/**
	 * 修改锁定状态
	 * 
	 * @param popedomId
	 * @return
	 */
	public static boolean lockPopedom(int popedomId) {
		try {
			OSSPopedom popedom = getPopedom(popedomId);
			return !(popedom == null || popedom.isReadOnly() || popedom.isLocked())
					&& popedomDao.mergerLocked(popedomId, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return false;
	}

	/**
	 * 修改锁定状态
	 * 
	 * @param popedomId
	 * @return
	 */
	public static boolean unlockPopedom(int popedomId) {
		try {
			OSSPopedom popedom = getPopedom(popedomId);
			return !(popedom == null || popedom.isReadOnly() || !popedom.isLocked())
					&& popedomDao.mergerLocked(popedomId, false);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return false;
	}

	/**
	 * 获取分组
	 * 
	 * @param groupId
	 * @return
	 */
	public static OSSGroup getGroup(int groupId) {
		try {
			return groupDao.get(groupId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取分组列表
	 * 
	 * @return
	 */
	public static List<OSSGroup> getGroup() {
		try {
			return groupDao.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 修改分组
	 * 
	 * @param groupId
	 * @param groupName
	 * @param hide
	 * @param remark
	 * @return
	 */
	public static boolean mergerGroup(int groupId, String groupName, boolean hide, String remark) {
		try {
			OSSGroup group = getGroup(groupId);
			if (group == null) {
				return groupDao.persist(groupName, hide, false, remark);
			}
			return !group.isReadOnly() && groupDao.merger(groupId, groupName, hide, false, remark);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return false;
	}

	/**
	 * @param groupId
	 * @return
	 */
	public static boolean deleteGroup(int groupId) {
		try {
			OSSGroup group = getGroup(groupId);
			return !(group == null || group.isReadOnly()) && groupDao.delete(groupId);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return false;
	}

	public static void main(String[] args) {
		ConnectionProvider.setProxoolConfig("proxool.xml");
		OSSContext context = OSSService.login("sunny.liu@a8.com", "000000");
		List<OSSGroup> groups = OSSService.getGroup();
		Map<String, List<OSSPopedom>> popedomsMap = new HashMap<String, List<OSSPopedom>>();
		List<OSSPopedom> popedoms = OSSService.getPopedom();
		for (OSSGroup group : groups) {
			List<OSSPopedom> p = new ArrayList<OSSPopedom>();
			for (OSSPopedom popedom : popedoms) {
				if (popedom.isHide()) {
					continue;
				}
				for (OSSPopedom up : context.getPopedoms()) {
					if (up.getURI().equals("*") || popedom.getURI().startsWith(up.getURI())) {
						System.out.println("add popedom to list, " + popedom.getURI());
						p.add(popedom);
						break;
					}
				}
			}
			System.out.println(group.getGroupId() + " p.size:" + p.size());
			popedomsMap.put("" + group.getGroupId(), p);
		}
	}

}
