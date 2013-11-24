package com.vernon.oss.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.vernon.oss.common.db.JdbcDaoSupport;
import com.vernon.oss.common.db.JdbcException;
import com.vernon.oss.common.db.RowMapper;
import com.vernon.oss.common.db.SequenceBuilder;
import com.vernon.oss.domain.OSSOP;

/**
 * 后台操作日志
 * 
 * @author Vernon.Chen
 *
 */
public class OSSOPDao
		extends JdbcDaoSupport {
	
	private static final String COLUMN_NAME = "op_time,user_id,title,content,IP,class_name,remark";

	private static final String TABLE_NAME = "oss_op";

	private RowMapper<OSSOP> rowMapper = new RowMapper<OSSOP>() {

		@Override
		public OSSOP mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			OSSOP op = new OSSOP();
			op.setOpTime(resultSet.getTimestamp("op_time"));
			op.setUserId(resultSet.getInt("user_id"));
			op.setTitle(resultSet.getString("title"));
			op.setContent(resultSet.getString("content"));
			op.setIP(resultSet.getString("IP"));
			op.setClassName(resultSet.getString("class_name"));
			op.setRemark(resultSet.getString("remark"));
			return op;
		}
	};

	/**
	 * 
	 */
	public OSSOPDao() {
		this.masterDSArray = new String[] { "oss" };
		this.slaveDSArray = new String[] { "oss" };
		this.sequenceBuilder = new SequenceBuilder(this.getMasterDS(), 10);
	}

	/**
	 * 获得表名
	 * @return
	 */
	//	private static final String getTableName() {
	//		return TABLE_NAME + DateUtil.date2String(new Date(), "yyyyMM");
	//	}

	/**
	 * 增加操作日志
	 * @param userId		后台用户ID
	 * @param title			操作名
	 * @param content		操作内容
	 * @param IP			操作IP
	 * @param className		操作类名
	 * @param remark		备注
	 * @return				{@link Integer}
	 */
	public int persist(int userId, String title, String content, String IP, String className, String remark) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into ").append(TABLE_NAME);
		sql.append("(").append(COLUMN_NAME).append(") ");
		sql.append(" values(now(),?,?,?,?,?,?)");
		try {
			return this.getJdbcTemplate().executeUpdate(this.getMasterDS(), sql.toString(),
					new Object[] { userId, title, content, IP, className, remark });
		} catch (JdbcException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 查询操作日志列表
	 * @param beginTime		起始时间
	 * @param endTime		结束时间
	 * @param userId		后台用户ID
	 * @param title			操作标题(模糊查询)
	 * @param beginIndex	起始位置
	 * @param maxLength		最大记录数
	 * @return				{@link List<OSSOP>}
	 */
	public List<OSSOP> getOSSOPS(Date beginTime, Date endTime, Integer userId, String title, int beginIndex,
			int maxLength) {
		StringBuilder sql = new StringBuilder();
		sql.append(" select ").append(COLUMN_NAME);
		sql.append(" from ").append(TABLE_NAME);
		sql.append(" where date_format(op_time,'%Y-%m-%d')>=? and date_format(op_time,'%Y-%m-%d')<=? ");

		if (userId != null && userId > 0) {
			sql.append(" and user_id=").append(userId);
		}
		if (title != null && title.length() > 0) {
			sql.append(" and title like ").append("'%").append(title).append("%'");
		}
		sql.append(" order by op_time desc ");
		sql.append(" limit ?,? ");
		try {
			return this.getJdbcTemplate().queryForList(this.getSlaveDS(), sql.toString(),
					new Object[] { beginTime, endTime, beginIndex, maxLength }, rowMapper);
		} catch (JdbcException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 查询操作日志总数
	 * @param beginTime		起始时间
	 * @param endTime		结束时间
	 * @param userId		后台用户ID
	 * @param title			操作标题(模糊查询)
	 * @return				{@link Integer}
	 */
	public int getTotal(Date beginTime, Date endTime, Integer userId, String title) {
		StringBuilder sql = new StringBuilder();
		sql.append(" select count(0) ");
		sql.append(" from ").append(TABLE_NAME);
		sql.append(" where date_format(op_time,'%Y-%m-%d')>=? and date_format(op_time,'%Y-%m-%d')<=? ");
		if (userId != null && userId > 0) {
			sql.append(" and user_id=").append(userId);
		}
		if (title != null && title.length() > 0) {
			sql.append(" and title like ").append("'%").append(title).append("%'");
		}
		try {
			Long result = this.getJdbcTemplate().queryForObject(this.getSlaveDS(), sql.toString(),
					new Object[] { beginTime, endTime }, Long.class);
			return result != null ? result.intValue() : 0;
		} catch (JdbcException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
