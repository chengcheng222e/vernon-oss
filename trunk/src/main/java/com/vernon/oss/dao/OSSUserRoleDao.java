/**
 * 
 */
package com.vernon.oss.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.vernon.oss.common.db.JdbcDaoSupport;
import com.vernon.oss.common.db.RowMapper;
import com.vernon.oss.domain.OSSUserRole;

/**
 * 运营支持系统用户角色对应的数据库访问接口
 * 
 * @author Vernon.Chen
 *
 */
public class OSSUserRoleDao
		extends JdbcDaoSupport {

	private final String columnName = "user_id,role_id,read_only";

	private RowMapper<OSSUserRole> rowMapper = new RowMapper<OSSUserRole>() {

		@Override
		public OSSUserRole mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			OSSUserRole userRole = new OSSUserRole();
			userRole.setUserId(resultSet.getInt("user_id"));
			userRole.setRoleId(resultSet.getInt("role_id"));
			return userRole;
		}
	};

	/**
	 * 
	 */
	public OSSUserRoleDao() {
		this.masterDSArray = new String[] { "oss" };
		this.slaveDSArray = new String[] { "oss" };

	}

	/**
	 * 获取对应关系
	 * 
	 * @param userId
	 * @param roleId
	 * @return
	 */
	public OSSUserRole get(int userId, int roleId) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" select ");
		sqlSB.append(columnName);
		sqlSB.append(" from oss_user_role ");
		sqlSB.append(" where role_id = ? and role_id=? ");
		try {
			return this.getJdbcTemplate().queryForObject(this.getSlaveDS(), sqlSB.toString(),
					new Object[] { userId, roleId }, rowMapper);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取对应关系列表
	 * 
	 * @param roleId
	 * @return
	 */
	public List<OSSUserRole> getByRoleId(int roleId) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" select ");
		sqlSB.append(columnName);
		sqlSB.append(" from oss_user_role ");
		sqlSB.append(" where role_id = ?");
		try {
			return this.getJdbcTemplate().queryForList(this.getSlaveDS(), sqlSB.toString(), new Object[] { roleId },
					rowMapper);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取对应关系列表
	 * 
	 * @param userId
	 * @return
	 */
	public List<OSSUserRole> getByUserId(int userId) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" select ");
		sqlSB.append(columnName);
		sqlSB.append(" from oss_user_role ");
		sqlSB.append(" where user_id = ?");
		try {
			return this.getJdbcTemplate().queryForList(this.getSlaveDS(), sqlSB.toString(), new Object[] { userId },
					rowMapper);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 删除
	 * 
	 * @param userId
	 * @param roleId
	 * @return
	 */
	public boolean delete(int userId, int roleId) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" delete ");
		sqlSB.append(" from oss_user_role ");
		sqlSB.append(" where user_id=? and role_id=? ");
		try {
			this.getJdbcTemplate().executeUpdate(this.getMasterDS(), sqlSB.toString(), new Object[] { userId, roleId });
			return true;
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 删除
	 * 
	 * @param userId
	 * @return
	 */
	public boolean deleteByUserId(int userId) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" delete ");
		sqlSB.append(" from oss_user_role ");
		sqlSB.append(" where user_id=? ");
		try {
			this.getJdbcTemplate().executeUpdate(this.getMasterDS(), sqlSB.toString(), new Object[] { userId });
			return true;
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 删除
	 * 
	 * @param roleId
	 * @return
	 */
	public boolean deleteByRoleId(int roleId) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" delete ");
		sqlSB.append(" from oss_user_role ");
		sqlSB.append(" where role_id=? ");
		try {
			this.getJdbcTemplate().executeUpdate(this.getMasterDS(), sqlSB.toString(), new Object[] { roleId });
			return true;
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 新增
	 * 
	 * @param roleId
	 * @param popedomId
	 * @param readOnly
	 * 
	 * @return
	 */
	public boolean persist(int userId, int roleId, boolean readOnly) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" insert into oss_user_role( ");
		sqlSB.append(columnName);
		sqlSB.append(") values(?,?,?)");
		try {
			this.getJdbcTemplate().executeUpdate(this.getMasterDS(), sqlSB.toString(),
					new Object[] { userId, roleId, readOnly });
			return true;
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return false;
	}
}
