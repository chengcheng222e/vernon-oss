/**
 * 
 */
package com.vernon.oss.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.vernon.oss.common.db.JdbcDaoSupport;
import com.vernon.oss.common.db.RowMapper;
import com.vernon.oss.common.db.SequenceBuilder;
import com.vernon.oss.domain.OSSRole;

/**
 * 运营支持系统角色的数据库访问接口
 * 
 * @author Vernon.Chen
 *
 */
public class OSSRoleDao
		extends JdbcDaoSupport {

	private final String columnName = "role_id,role_name,locked,read_only,remark";

	private RowMapper<OSSRole> rowMapper = new RowMapper<OSSRole>() {

		@Override
		public OSSRole mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			OSSRole role = new OSSRole();
			role.setRoleId(resultSet.getInt("role_id"));
			role.setRoleName(resultSet.getString("role_name"));
			role.setLocked(resultSet.getBoolean("locked"));
			role.setReadOnly(resultSet.getBoolean("read_only"));
			role.setRemark(resultSet.getString("remark"));
			return role;
		}
	};

	/**
	 * 
	 */
	public OSSRoleDao() {
		this.masterDSArray = new String[] { "oss" };
		this.slaveDSArray = new String[] { "oss" };
		this.sequenceBuilder = new SequenceBuilder(this.getMasterDS(), 1);
	}

	/**
	 * 获取角色
	 * 
	 * @param roleId
	 * @return
	 */
	public OSSRole get(int roleId) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" select ");
		sqlSB.append(columnName);
		sqlSB.append(" from oss_role ");
		sqlSB.append(" where role_id = ?");
		try {
			return this.getJdbcTemplate().queryForObject(this.getSlaveDS(), sqlSB.toString(), new Object[] { roleId, },
					rowMapper);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取角色列表
	 * 
	 * @return
	 */
	public List<OSSRole> get() {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" select ");
		sqlSB.append(columnName);
		sqlSB.append(" from oss_role ");
		try {
			return this.getJdbcTemplate().queryForList(this.getSlaveDS(), sqlSB.toString(), new Object[] {}, rowMapper);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取角色列表
	 * 
	 * @param beginIndex
	 * @param maxLength
	 * @return
	 */
	public List<OSSRole> get(int beginIndex, int maxLength) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" select ");
		sqlSB.append(columnName);
		sqlSB.append(" from oss_role ");
		sqlSB.append(" order by role_id ");
		sqlSB.append(" limit ?,? ");
		try {
			return this.getJdbcTemplate().queryForList(this.getSlaveDS(), sqlSB.toString(),
					new Object[] { beginIndex, maxLength }, rowMapper);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取角色总数
	 * 
	 * @return
	 */
	public int getTotal() {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" select count(0) ");
		sqlSB.append(" from oss_role ");
		sqlSB.append(" where role_id = ? ");
		try {
			Long result = getJdbcTemplate().queryForObject(this.getSlaveDS(), sqlSB.toString(), new Object[] {},
					Long.class);
			if (result != null) {
				return result.intValue();
			}
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 删除
	 * 
	 * @param roleId
	 * @return
	 */
	public boolean delete(int roleId) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" delete ");
		sqlSB.append(" from oss_role ");
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
	 * 增加
	 * 
	 * @param roleName
	 * @param locked
	 * @param readOnly
	 * @param remark
	 * @return
	 */
	public boolean persist(String roleName, boolean locked, boolean readOnly, String remark) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" insert into oss_role( ");
		sqlSB.append(columnName);
		sqlSB.append(") values(?,?,?,?,?) ");
		try {
			int roleId = sequenceBuilder.nextValue("oss_role");
			if (roleId <= 0) {
				return false;
			}
			this.getJdbcTemplate().executeUpdate(this.getMasterDS(), sqlSB.toString(),
					new Object[] { roleId, roleName, locked, readOnly, remark });
			return true;
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 修改
	 * 
	 * @param roleId
	 * @param roleName
	 * @param locked
	 * @param readOnly
	 * @param remark
	 * 
	 * @return
	 */
	public boolean merger(int roleId, String roleName, boolean locked, boolean readOnly, String remark) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" update oss_role ");
		sqlSB.append(" set role_name=?,locked=?,read_only=?,remark=? ");
		sqlSB.append(" where role_id = ? ");
		try {
			this.getJdbcTemplate().executeUpdate(this.getMasterDS(), sqlSB.toString(),
					new Object[] { roleName, locked, readOnly, remark, roleId });
			return true;
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 修改锁定状态
	 * 
	 * @param roleId
	 * @param locked
	 * @return
	 */
	public boolean mergerLocked(int roleId, boolean locked) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" update oss_role ");
		sqlSB.append(" set locked=? ");
		sqlSB.append(" where role_id = ? ");
		try {
			this.getJdbcTemplate().executeUpdate(this.getMasterDS(), sqlSB.toString(), new Object[] { locked, roleId });
			return true;
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return false;
	}

}
