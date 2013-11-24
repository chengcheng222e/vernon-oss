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
import com.vernon.oss.domain.OSSUser;

/**
 * 运营支持系统用户的数据库访问接口
 * 
 * @author Vernon.Chen
 *
 */
public class OSSUserDao
		extends JdbcDaoSupport {

	private final static String COLUMNNAME = "user_id,email,password,real_name,locked,read_only,remark";

	private RowMapper<OSSUser> rowMapper = new RowMapper<OSSUser>() {

		@Override
		public OSSUser mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			OSSUser user = new OSSUser();
			user.setUserId(resultSet.getInt("user_id"));
			user.setEmail(resultSet.getString("email"));
			user.setRealName(resultSet.getString("real_name"));
			user.setPassword(resultSet.getString("password"));
			user.setLocked(resultSet.getBoolean("locked"));
			user.setReadOnly(resultSet.getBoolean("read_only"));
			user.setRemark(resultSet.getString("remark"));
			return user;
		}
	};

	/**
	 * 
	 */
	public OSSUserDao() {
		this.masterDSArray = new String[] { "oss" };
		this.slaveDSArray = new String[] { "oss" };
		this.sequenceBuilder = new SequenceBuilder(this.getMasterDS(), 1);
	}

	/**
	 * 获取用户
	 * 
	 * @param userId
	 * @return
	 */
	public OSSUser get(int userId) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" select ");
		sqlSB.append(COLUMNNAME);
		sqlSB.append(" from oss_user ");
		sqlSB.append(" where user_id=? ");
		try {
			return this.getJdbcTemplate().queryForObject(this.getSlaveDS(), sqlSB.toString(), new Object[] { userId },
					rowMapper);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取用户
	 * 
	 * @param email
	 * @return
	 */
	public OSSUser get(String email) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" select ");
		sqlSB.append(COLUMNNAME);
		sqlSB.append(" from oss_user ");
		sqlSB.append(" where email=? ");
		try {
			return this.getJdbcTemplate().queryForObject(this.getSlaveDS(), sqlSB.toString(), new Object[] { email },
					rowMapper);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取用户列表
	 * 
	 * @param beginIndex
	 * @param maxLength
	 * @return
	 */
	public List<OSSUser> get(int beginIndex, int maxLength) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" select ");
		sqlSB.append(COLUMNNAME);
		sqlSB.append(" from oss_user ");
		sqlSB.append(" order by user_id  ");
		sqlSB.append(" limit ?, ? ");
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
	 * 获取用户列表
	 * 
	 * @param beginIndex
	 * @param maxLength
	 * @return
	 */
	public List<OSSUser> getList() {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" select ");
		sqlSB.append(COLUMNNAME);
		sqlSB.append(" from oss_user ");
		sqlSB.append(" order by user_id  ");
		try {
			return this.getJdbcTemplate().queryForList(this.getSlaveDS(), sqlSB.toString(), null, rowMapper);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取用户总数
	 * 
	 * @return
	 */
	public int getTotal() {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" select count(0) ");
		sqlSB.append(" from oss_user ");
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
	 * 删除用户
	 * 
	 * @param userId
	 * @return
	 */
	public boolean delete(int userId) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" delete ");
		sqlSB.append(" from oss_user ");
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
	 * 新增
	 * 
	 * @param email
	 * @param password
	 * @param realName
	 * @param locked
	 * @param readOnly
	 * @param remark
	 * @return
	 */
	public boolean persist(String email, String password, String realName, boolean locked, boolean readOnly,
			String remark) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" insert into oss_user( ");
		sqlSB.append(COLUMNNAME);
		sqlSB.append(") values(?,?,?,?,?,?,?) ");
		try {
			int userId = sequenceBuilder.nextValue("oss_user");
			if (userId <= 0) {
				return false;
			}
			this.getJdbcTemplate().executeUpdate(this.getMasterDS(), sqlSB.toString(),
					new Object[] { userId, email, password, realName, locked, readOnly, remark });
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
	 * @param userId
	 * @param email
	 * @param password
	 * @param realName
	 * @param locked
	 * @param readOnly
	 * @param remark
	 * @return
	 */
	public boolean merger(int userId, String email, String password, String realName, boolean locked, boolean readOnly,
			String remark) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" update oss_user ");
		sqlSB.append(" set email=?,password=?,real_name=?, ");
		sqlSB.append(" locked=?,read_only=?,remark=? ");
		sqlSB.append(" where user_id=? ");
		try {
			this.getJdbcTemplate().executeUpdate(this.getMasterDS(), sqlSB.toString(),
					new Object[] { email, password, realName, locked, readOnly, remark, userId });
			return true;
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 修改密码
	 * 
	 * @param userId
	 * @param password
	 * @return
	 */
	public boolean mergerPassword(int userId, String password) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" update oss_user ");
		sqlSB.append(" set password=? ");
		sqlSB.append(" where user_id=? ");
		try {
			this.getJdbcTemplate().executeUpdate(this.getMasterDS(), sqlSB.toString(),
					new Object[] { password, userId });
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
	 * @param userId
	 * @param locked
	 * @return
	 */
	public boolean mergerLocked(int userId, boolean locked) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" update oss_user ");
		sqlSB.append(" set locked=? ");
		sqlSB.append(" where user_id=? ");
		try {
			this.getJdbcTemplate().executeUpdate(this.getMasterDS(), sqlSB.toString(), new Object[] { locked, userId });
			return true;
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return false;
	}

}
