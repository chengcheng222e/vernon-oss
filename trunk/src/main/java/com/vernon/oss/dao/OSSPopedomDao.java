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
import com.vernon.oss.domain.OSSPopedom;

/**
 * 运营支持系统权限的数据库访问接口
 * 
 * @author Vernon.Chen
 *
 */
public class OSSPopedomDao
		extends JdbcDaoSupport {

	private final String columnName = "popedom_id,group_id,popedom_name,locked,hide,read_only,URI,remark";

	private RowMapper<OSSPopedom> rowMapper = new RowMapper<OSSPopedom>() {

		@Override
		public OSSPopedom mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			OSSPopedom popedom = new OSSPopedom();
			popedom.setPopedomId(resultSet.getInt("popedom_id"));
			popedom.setGroupId(resultSet.getInt("group_id"));
			popedom.setPopedomName(resultSet.getString("popedom_name"));
			popedom.setHide(resultSet.getBoolean("hide"));
			popedom.setLocked(resultSet.getBoolean("locked"));
			popedom.setReadOnly(resultSet.getBoolean("read_only"));
			popedom.setURI(resultSet.getString("URI").trim());
			popedom.setRemark(resultSet.getString("remark"));
			return popedom;
		}

	};

	/**
	 * 
	 */
	public OSSPopedomDao() {
		this.masterDSArray = new String[] { "oss" };
		this.slaveDSArray = new String[] { "oss" };
		this.sequenceBuilder = new SequenceBuilder(this.getMasterDS(), 1);
	}

	/**
	 * 获取权限
	 * 
	 * @param popedomId
	 * @return
	 */
	public OSSPopedom getByPopedomId(int popedomId) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" select ");
		sqlSB.append(columnName);
		sqlSB.append(" from oss_popedom");
		sqlSB.append(" where popedom_id = ?");
		try {
			return this.getJdbcTemplate().queryForObject(this.getSlaveDS(), sqlSB.toString(),
					new Object[] { popedomId, }, rowMapper);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取权限列表
	 * 
	 * @param groupId
	 * @return
	 */
	public List<OSSPopedom> getByGroupId(int groupId) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" select ");
		sqlSB.append(columnName);
		sqlSB.append(" from oss_popedom");
		sqlSB.append(" where group_id = ?");
		try {
			return this.getJdbcTemplate().queryForList(this.getSlaveDS(), sqlSB.toString(), new Object[] { groupId, },
					rowMapper);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取总数
	 * 
	 * @param groupId
	 * @return
	 */
	public int getTotal(int groupId) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" select count(0) ");
		sqlSB.append(" from oss_popedom");
		sqlSB.append(" where group_id = ? ");
		try {
			Long result = getJdbcTemplate().queryForObject(this.getSlaveDS(), sqlSB.toString(),
					new Object[] { groupId }, Long.class);
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
	 * 获取权限列表
	 * 
	 * @return
	 */
	public List<OSSPopedom> get() {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" select ");
		sqlSB.append(columnName);
		sqlSB.append(" from oss_popedom");
		try {
			return this.getJdbcTemplate().queryForList(this.getSlaveDS(), sqlSB.toString(), new Object[] {}, rowMapper);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取权限列表
	 * 
	 * @return
	 */
	public List<OSSPopedom> get(int groupId) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" select ");
		sqlSB.append(columnName);
		sqlSB.append(" from oss_popedom");
		if (groupId > 0) {
			sqlSB.append(" where group_id= ").append(groupId);
		}
		try {
			return this.getJdbcTemplate().queryForList(this.getSlaveDS(), sqlSB.toString(), new Object[] {}, rowMapper);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取权限列表
	 * 
	 * @param beginIndex
	 * @param maxLength
	 * @return
	 */
	public List<OSSPopedom> get(int beginIndex, int maxLength) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" select ");
		sqlSB.append(columnName);
		sqlSB.append(" from oss_popedom ");
		sqlSB.append(" order by popedom_id ");
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
	 * 获取总数
	 * 
	 * @return
	 */
	public int getTotal() {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" select count(0) ");
		sqlSB.append(" from oss_popedom");
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
	 * @param popedomId
	 * @return
	 */
	public boolean deleteByPopedomId(int popedomId) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" delete ");
		sqlSB.append(" from oss_popedom ");
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
	 * 删除
	 * 
	 * @param groupId
	 * @return
	 */
	public boolean deleteByGroupId(int groupId) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" delete ");
		sqlSB.append(" from oss_popedom ");
		sqlSB.append(" where group_id=? ");
		try {
			this.getJdbcTemplate().executeUpdate(this.getMasterDS(), sqlSB.toString(), new Object[] { groupId });
			return true;
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 储存
	 * 
	 * @param groupId
	 * @param popedomName
	 * @param locked
	 * @param hide
	 * @param readOnly
	 * @param URI
	 * @param remark
	 * @return
	 */
	public boolean persist(int groupId, String popedomName, boolean locked, boolean hide, boolean readOnly, String URI,
			String remark) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" insert into oss_popedom( ");
		sqlSB.append(columnName);
		sqlSB.append(") values(?,?,?,?,?,?,?,?) ");
		try {
			int popedomId = sequenceBuilder.nextValue("oss_popedom");
			if (popedomId <= 0) {
				return false;
			}
			this.getJdbcTemplate().executeUpdate(this.getMasterDS(), sqlSB.toString(),
					new Object[] { popedomId, groupId, popedomName, locked, hide, readOnly, URI, remark });
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
	 * @param popedomId
	 * @param groupId
	 * @param popedomName
	 * @param locked
	 * @param hide
	 * @param readOnly
	 * @param URI
	 * @param remark
	 * @return
	 */
	public boolean merger(int popedomId, int groupId, String popedomName, boolean locked, boolean hide,
			boolean readOnly, String URI, String remark) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" update oss_popedom ");
		sqlSB.append(" set group_id=?,popedom_name=?,locked=?, ");
		sqlSB.append(" hide=?,read_only=?,URI=?,remark=? ");
		sqlSB.append(" where popedom_id=?  ");
		try {
			this.getJdbcTemplate().executeUpdate(this.getMasterDS(), sqlSB.toString(),
					new Object[] { groupId, popedomName, locked, hide, readOnly, URI, remark, popedomId });
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
	 * @param popedomId
	 * @param locked
	 * @return
	 */
	public boolean mergerLocked(int popedomId, boolean locked) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" update oss_popedom ");
		sqlSB.append(" set locked=? ");
		sqlSB.append(" where popedom_id=?  ");
		try {
			this.getJdbcTemplate().executeUpdate(this.getMasterDS(), sqlSB.toString(),
					new Object[] { locked, popedomId });
			return true;
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 修改分组
	 * 
	 * @param groupId
	 * @param newGroupId
	 * @return
	 */
	public boolean mergerGroupIdByGroupId(int groupId, int newGroupId) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" update oss_popedom ");
		sqlSB.append(" set group_id=? ");
		sqlSB.append(" where group_id=?  ");
		try {
			this.getJdbcTemplate().executeUpdate(this.getMasterDS(), sqlSB.toString(),
					new Object[] { newGroupId, groupId });
			return true;
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 修改分组
	 * 
	 * @param popedomId
	 * @param groupId
	 * @return
	 */
	public boolean mergerGroupIdByPopedomId(int popedomId, int groupId) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" update oss_popedom ");
		sqlSB.append(" set group_id=? ");
		sqlSB.append(" where popedom_id=?  ");
		try {
			this.getJdbcTemplate().executeUpdate(this.getMasterDS(), sqlSB.toString(),
					new Object[] { groupId, popedomId });
			return true;
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 修改隐藏状态
	 * 
	 * @param popedomId
	 * @param hide
	 * @return
	 */
	public boolean mergerLHide(int popedomId, boolean hide) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" update oss_popedom ");
		sqlSB.append(" set hide=? ");
		sqlSB.append(" where popedom_id=?  ");
		try {
			this.getJdbcTemplate()
					.executeUpdate(this.getMasterDS(), sqlSB.toString(), new Object[] { hide, popedomId });
			return true;
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return false;
	}

}
