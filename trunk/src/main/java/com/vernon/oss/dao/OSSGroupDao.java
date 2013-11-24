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
import com.vernon.oss.domain.OSSGroup;

/**
 * 运营支持系统 分组的数据库访问接口
 * 
 * @author Vernon.Chen
 *
 */
public class OSSGroupDao
		extends JdbcDaoSupport {

	private final String COLUMNNAME = "group_id,group_name,hide,read_only,remark";

	private RowMapper<OSSGroup> rowMapper = new RowMapper<OSSGroup>() {

		@Override
		public OSSGroup mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			OSSGroup group = new OSSGroup();
			group.setGroupId(resultSet.getInt("group_id"));
			group.setGroupName(resultSet.getString("group_name"));
			group.setHide(resultSet.getBoolean("hide"));
			group.setReadOnly(resultSet.getBoolean("read_only"));
			group.setRemark(resultSet.getString("remark"));
			return group;
		}
	};

	/**
	 * 
	 */
	public OSSGroupDao() {
		this.masterDSArray = new String[] { "oss" };
		this.slaveDSArray = new String[] { "oss" };
		this.sequenceBuilder = new SequenceBuilder(this.getMasterDS(), 1);

	}

	/**
	 * 获取分组
	 * 
	 * @param groupId
	 * @return
	 */
	public OSSGroup get(int groupId) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" select ");
		sqlSB.append(COLUMNNAME);
		sqlSB.append(" from oss_group");
		sqlSB.append(" where group_id = ?");
		try {
			return this.getJdbcTemplate().queryForObject(this.getSlaveDS(), sqlSB.toString(),
					new Object[] { groupId, }, rowMapper);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取分组列表
	 * 
	 * @return
	 */
	public List<OSSGroup> get() {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" select ");
		sqlSB.append(COLUMNNAME);
		sqlSB.append(" from oss_group");
		try {
			return this.getJdbcTemplate().queryForList(this.getSlaveDS(), sqlSB.toString(), new Object[] {}, rowMapper);
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
		sqlSB.append(" from oss_group");
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
	 * 获取分组列表
	 * 
	 * @param beginIndex
	 * @param maxLength
	 * @return
	 */
	public List<OSSGroup> get(int beginIndex, int maxLength) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" select ");
		sqlSB.append(COLUMNNAME);
		sqlSB.append(" from oss_group");
		sqlSB.append(" order by group_id asc ");
		sqlSB.append(" limit ?, ?");
		try {
			return this.getJdbcTemplate().queryForList(this.getSlaveDS(), sqlSB.toString(), new Object[] {}, rowMapper);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 删除分组
	 * 
	 * @param groupId
	 * @return
	 */
	public boolean delete(int groupId) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" delete ");
		sqlSB.append(" from oss_group");
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
	 * 新增分组
	 * 
	 * @param groupName
	 * @param hide
	 * @param readOnly
	 * @param remark
	 * @return
	 */
	public boolean persist(String groupName, boolean hide, boolean readOnly, String remark) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" insert into oss_group( ");
		sqlSB.append(COLUMNNAME);
		sqlSB.append(") values(?,?,?,?,?) ");
		try {
			int groupId = sequenceBuilder.nextValue("oss_group");
			if (groupId <= 0) {
				return false;
			}
			this.getJdbcTemplate().executeUpdate(this.getMasterDS(), sqlSB.toString(),
					new Object[] { groupId, groupName, hide, readOnly, remark });
			return true;
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 修改分组信息
	 * 
	 * @param groupId
	 * @param groupName
	 * @param hide
	 * @param readOnly
	 * @param remark
	 * @return
	 */
	public boolean merger(int groupId, String groupName, boolean hide, boolean readOnly, String remark) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" update oss_group ");
		sqlSB.append(" set group_name=?,hide=?,read_only=?,remark=? ");
		sqlSB.append(" where group_id = ? ");
		try {
			this.getJdbcTemplate().executeUpdate(this.getMasterDS(), sqlSB.toString(),
					new Object[] { groupName, hide, readOnly, remark, groupId });
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
	 * @param groupId
	 * @param hide
	 * @return
	 */
	public boolean mergerHide(int groupId, boolean hide) {
		StringBuffer sqlSB = new StringBuffer();
		sqlSB.append(" update into oss_group ");
		sqlSB.append(" set hide=? ");
		sqlSB.append(" where group_id = ? ");
		try {
			this.getJdbcTemplate().executeUpdate(this.getMasterDS(), sqlSB.toString(), new Object[] { hide, groupId });
			return true;
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return false;
	}

}
