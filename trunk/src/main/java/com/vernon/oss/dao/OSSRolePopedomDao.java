/**
 * 
 */
package com.vernon.oss.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.vernon.oss.common.db.JdbcDaoSupport;
import com.vernon.oss.common.db.RowMapper;
import com.vernon.oss.domain.OSSRolePopedom;

/**
 * 运营支持系统角色权限对应的数据库访问接口
 * 
 * @author Vernon.Chen
 *
 */
public class OSSRolePopedomDao
		extends JdbcDaoSupport {

	private final String columnName = "role_id,popedom_id,read_only";

	private RowMapper<OSSRolePopedom> rowMapper = new RowMapper<OSSRolePopedom>() {

		@Override
		public OSSRolePopedom mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			OSSRolePopedom rolePopedom = new OSSRolePopedom();
			rolePopedom.setRoleId(resultSet.getInt("role_id"));
			rolePopedom.setPopedomId(resultSet.getInt("popedom_id"));
			rolePopedom.setReadOnly(resultSet.getBoolean("read_only"));
			return rolePopedom;
		}

	};

	/**
	 * 
	 */
	public OSSRolePopedomDao() {
		this.masterDSArray = new String[] { "oss" };
		this.slaveDSArray = new String[] { "oss" };
	}

	/**
	 * 获取对应关系
	 * 
	 * @param roleId
	 * @param popedomId
	 * @return
	 */
	public OSSRolePopedom get(int roleId, int popedomId) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" select ");
		sqlSB.append(columnName);
		sqlSB.append(" from oss_role_popedom ");
		sqlSB.append(" where role_id = ? and popedom_id=? ");
		try {
			return this.getJdbcTemplate().queryForObject(this.getSlaveDS(), sqlSB.toString(),
					new Object[] { roleId, popedomId }, rowMapper);
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
	public List<OSSRolePopedom> getByRoleId(int roleId) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" select ");
		sqlSB.append(columnName);
		sqlSB.append(" from oss_role_popedom ");
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
	 * @param popedomId
	 * @return
	 */
	public List<OSSRolePopedom> getByPopedomId(int popedomId) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" select ");
		sqlSB.append(columnName);
		sqlSB.append(" from oss_role_popedom ");
		sqlSB.append(" where popedom_id = ?");
		try {
			return this.getJdbcTemplate().queryForList(this.getSlaveDS(), sqlSB.toString(), new Object[] { popedomId },
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
	 * @param roleId
	 * @param popedomId
	 * @return
	 */
	public boolean delete(int roleId, int popedomId) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" delete ");
		sqlSB.append(" from oss_role_popedom ");
		sqlSB.append(" where role_id=? and popedom_id=? ");
		try {
			this.getJdbcTemplate().executeUpdate(this.getMasterDS(), sqlSB.toString(),
					new Object[] { roleId, popedomId });
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
		sqlSB.append(" from oss_role_popedom ");
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
	 * 删除
	 * 
	 * @param popedomId
	 * @return
	 */
	public boolean deleteByPopedomId(int popedomId) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" delete ");
		sqlSB.append(" from oss_role_popedom ");
		sqlSB.append(" where popedom_id=? ");
		try {
			this.getJdbcTemplate().executeUpdate(this.getMasterDS(), sqlSB.toString(), new Object[] { popedomId });
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
	 * @return
	 */
	public boolean persist(int roleId, int popedomId, boolean readOnly) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" insert into oss_role_popedom( ");
		sqlSB.append(columnName);
		sqlSB.append(") values(?,?,?)");
		try {
			this.getJdbcTemplate().executeUpdate(this.getMasterDS(), sqlSB.toString(),
					new Object[] { roleId, popedomId, readOnly });
			return true;
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return false;
	}

}
