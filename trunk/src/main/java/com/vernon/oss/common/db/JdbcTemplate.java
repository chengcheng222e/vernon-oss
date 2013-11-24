/**
 * 
 */
package com.vernon.oss.common.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Jdbc操作的模板类,提供对数据库访问方法的封装
 * 
 * @author Vernon.Chen
 *
 */
public class JdbcTemplate {

	/**
	 * 查询一个T型列表
	 * 
	 * @param <T>
	 * @param dsName
	 * @param sql
	 * @param args
	 * @param classDefinition
	 * @return
	 * @throws JdbcException
	 */
	public <T> List<T> queryForList(String dsName, String sql, Object[] args,
			Class<T> classDefinition) throws JdbcException {
		long begin = System.currentTimeMillis();
		Connection connection = ConnectionProvider.getConnection(dsName);
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (connection == null) {
			throw new JdbcException("Connection for DataSource<" + dsName
					+ "> not find!");
		}
		try {

			ps = connection.prepareStatement(sql);
			new PreparedStatementSetter(args).setValues(ps);
			rs = ps.executeQuery();
			List<T> list = new ArrayList<T>();
			while (rs.next()) {
				Object result = rs.getObject(1);
				try {
					list.add(classDefinition.cast(result));
				} catch (ClassCastException e) {
					// System.err.println("class cast exception!");
					e.printStackTrace();
				}
			}
			long end = System.currentTimeMillis();
			if (end - begin >= 500) {
				System.out.println(" sql[" + sql + "]" + " time:"
						+ (end - begin));
			}

			return list;
		} catch (SQLException e) {
			throw new JdbcException(e);
		} finally {
			ConnectionProvider.release(connection, ps, rs);
		}
	}

	/**
	 * 查询一个T型字段
	 * 
	 * @param <T>
	 * @param dsName
	 * @param sql
	 * @param args
	 * @param classDefinition
	 * @return
	 * @throws JdbcException
	 */
	public <T> T queryForObject(String dsName, String sql, Object[] args,
			Class<T> classDefinition) throws JdbcException {
		long begin = System.currentTimeMillis();
		Connection connection = ConnectionProvider.getConnection(dsName);
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (connection == null) {
			throw new JdbcException("Connection for DataSource<" + dsName
					+ "> not find!");
		}
		try {
			ps = connection.prepareStatement(sql);
			new PreparedStatementSetter(args).setValues(ps);
			rs = ps.executeQuery();
			Object result = null;
			if (rs.next()) {
				result = rs.getObject(1);
			}
			if (result != null) {
				try {
					return classDefinition.cast(result);
				} catch (ClassCastException e) {
					System.err.println("class cast exception!");
				}
			}
			long end = System.currentTimeMillis();
			if (end - begin >= 500) {
				System.out.println(" sql[" + sql + "]" + " time:"
						+ (end - begin));
			}
			return null;
		} catch (SQLException e) {
			throw new JdbcException(e);
		} finally {
			ConnectionProvider.release(connection, ps, rs);
		}
	}

	/**
	 * 查询后返回一个对象
	 * 
	 * @param dsName
	 *            数据源名
	 * @param sql
	 *            SQL语句
	 * @param args
	 *            SQL语句中的参数
	 * @param rowMapper
	 *            行打包器
	 * @return 返回的对象由行打包器决定
	 * @throws JdbcException
	 */
	public <T> T queryForObject(String dsName, String sql, Object[] args,
			RowMapper<T> rowMapper) throws JdbcException {
		long begin = System.currentTimeMillis();
		Connection connection = ConnectionProvider.getConnection(dsName);
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (connection == null) {
			throw new JdbcException("Connection for DataSource<" + dsName
					+ "> not find!");
		}
		try {
			ps = connection.prepareStatement(sql);
			new PreparedStatementSetter(args).setValues(ps);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rowMapper.mapRow(rs, 1);
			}
			long end = System.currentTimeMillis();
			if (end - begin >= 500) {
				System.out.println(" sql[" + sql + "]" + " time:"
						+ (end - begin));
			}
			return null;
		} catch (SQLException e) {
			throw new JdbcException(e);
		} finally {
			ConnectionProvider.release(connection, ps, rs);
		}
	}

	/**
	 * 查询后返回一个对象
	 * 
	 * @param dsName
	 *            数据源名
	 * @param sql
	 *            SQL语句
	 * @param rowMapper 行打包器
	 * @return 返回的对象由行打包器决定
	 * @throws JdbcException
	 */
	public <T> T queryForObject(String dsName, String sql,
			RowMapper<T> rowMapper) throws JdbcException {
		return this.queryForObject(dsName, sql, null, rowMapper);
	}

	/**
	 * 查询返回一个MAP对象
	 * 
	 * @param dsName
	 *            数据源名
	 * @param sql
	 *            SQL语句
	 * @return 返回对象是由MAP包裹的 （Key:列名 value:值）
	 * @throws JdbcException
	 */
	public Map<String, Object> queryForMap(String dsName, String sql)
			throws JdbcException {
		return this.queryForObject(dsName, sql, null, new MapRowMapper());
	}

	/**
	 * 查询返回一个MAP对象
	 * 
	 * @param dsName
	 *            数据源名
	 * @param sql
	 *            SQL语句
	 * @param args
	 *            SQL语句中的参数
	 * @return 返回对象是由MAP包裹的 （Key:列名 value:值）
	 * @throws JdbcException
	 */
	public Map<String, Object> queryForMap(String dsName, String sql,
			Object[] args) throws JdbcException {
		return this.queryForObject(dsName, sql, args, new MapRowMapper());
	}

	/**
	 * 返回一个对象列表
	 * 
	 * @param dsName
	 *            数据源名
	 * @param sql
	 *            SQL语句
	 * @param args
	 *            SQL语句中的参数
	 * @param rowMapper
	 *            行打包器
	 * @return 返回的对象由行打包器返回对象组成的ArrayList
	 * @throws JdbcException
	 */
	public <T> List<T> queryForList(String dsName, String sql, Object[] args,
			RowMapper<T> rowMapper) throws JdbcException {
		long begin = System.currentTimeMillis();
		Connection connection = ConnectionProvider.getConnection(dsName);
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (connection == null) {
			throw new JdbcException("Connection for DataSource<" + dsName
					+ "> not find!");
		}
		try {
			ps = connection.prepareStatement(sql);
			new PreparedStatementSetter(args).setValues(ps);
			rs = ps.executeQuery();
			List<T> list = new ArrayList<T>();
			int rowNum = 0;
			while (rs.next()) {
				rowNum++;
				list.add(rowMapper.mapRow(rs, rowNum));
			}
			long end = System.currentTimeMillis();
			if (end - begin >= 500) {
				System.out.println(" sql[" + sql + "]" + " time:"
						+ (end - begin));
			}
			return list;
		} catch (SQLException e) {
			throw new JdbcException(e);
		} finally {
			ConnectionProvider.release(connection, ps, rs);
		}
	}

	/**
	 * 返回一个对象列表
	 * 
	 * @param dsName
	 *            数据源名
	 * @param sql
	 *            SQL语句
	 * @param rowMapper
	 *            行打包器
	 * @return 返回的对象由行打包器返回对象组成的ArrayList
	 * @throws JdbcException
	 */
	public <T> List<T> queryForList(String dsName, String sql,
			RowMapper<T> rowMapper) throws JdbcException {
		return this.queryForList(dsName, sql, null, rowMapper);
	}

	/**
	 * 查询返回一个Map对象列表
	 * 
	 * @param dsName
	 *            数据源名
	 * @param sql
	 *            SQL语句
	 * @return 返回的对象Map组成的ArrayList,Map是由(Key:列名,value:值)组成
	 * @throws JdbcException
	 */
	public List<Map<String, Object>> queryForList(String dsName, String sql)
			throws JdbcException {
		return this.queryForList(dsName, sql, null, new MapRowMapper());
	}

	/**
	 * 查询返回一个Map对象列表
	 * 
	 * @param dsName
	 *            数据源名
	 * @param sql
	 *            SQL语句
	 * @parame args SQL语句的参数
	 * @return 返回的对象Map组成的ArrayList,Map是由(Key:列名,value:值)组成
	 * @throws JdbcException
	 */
	public List<Map<String, Object>> queryForList(String dsName, String sql,
			Object[] args) throws JdbcException {
		return this.queryForList(dsName, sql, args, new MapRowMapper());
	}

	/**
	 * 执行命令性SQL语句 返回执行状态
	 * 
	 * @param dsName
	 *            数据源名
	 * @param sql
	 *            SQL语句
	 * @param args
	 *            SQL语句参数
	 * @return 成功返回true
	 * @throws JdbcException
	 */
	public boolean execute(String dsName, String sql, Object[] args)
			throws JdbcException {
		long begin = System.currentTimeMillis();
		Connection connection = ConnectionProvider.getConnection(dsName);
		PreparedStatement ps = null;
		if (connection == null) {
			throw new JdbcException("Connection for DataSource<" + dsName
					+ "> not find!");
		}
		try {
			ps = connection.prepareStatement(sql);
			new PreparedStatementSetter(args).setValues(ps);
			boolean result = ps.execute();
			long end = System.currentTimeMillis();
			if (end - begin >= 500) {
				System.out.println(" sql[" + sql + "]" + " time:"
						+ (end - begin));
			}
			return result;
		} catch (SQLException e) {
			throw new JdbcException(e);
		} finally {
			ConnectionProvider.release(connection, ps);
		}
	}

	/**
	 * 执行命令性SQL语句 返回执行状态
	 * 
	 * @param dsName
	 *            数据源名
	 * @param sql
	 *            SQL语句
	 * @param args
	 *            SQL语句参数
	 * @return 返回值为int型，一般代表SQL语句影响到的行数
	 * @throws JdbcException
	 */
	public int executeUpdate(String dsName, String sql, Object[] args)
			throws JdbcException {
		long begin = System.currentTimeMillis();
		Connection connection = ConnectionProvider.getConnection(dsName);
		PreparedStatement ps = null;
		if (connection == null) {
			throw new JdbcException("Connection for DataSource<" + dsName
					+ "> not find!");
		}
		try {
			ps = connection.prepareStatement(sql);
			new PreparedStatementSetter(args).setValues(ps);
			int result = ps.executeUpdate();
			long end = System.currentTimeMillis();
			if (end - begin >= 500) {
				System.out.println(" sql[" + sql + "]" + " time:"
						+ (end - begin));
			}
			return result;
		} catch (SQLException e) {
			throw new JdbcException(e);
		} finally {
			ConnectionProvider.release(connection, ps);
		}
	}

	/**
	 * 执行insert SQL语句 返回自增长主键的值
	 * 
	 * @param dsName
	 *            数据源名
	 * @param sql
	 *            SQL语句
	 * @param args
	 *            SQL语句参数
	 * @return 返回值如果为NULL 代表SQL语句执行不成功,否则返回一个>1的数字,对应于自增长字段的值
	 * @throws JdbcException
	 */
	public Integer executeUpdate(String dsName, String sql, Object[] args,
			KeyGenerate keyGenerate) throws JdbcException {
		long begin = System.currentTimeMillis();
		Connection connection = ConnectionProvider.getConnection(dsName);
		PreparedStatement ps = null;
		if (connection == null) {
			throw new JdbcException("Connection for DataSource<" + dsName
					+ "> not find!");
		}
		try {
			ps = connection.prepareStatement(sql);
			new PreparedStatementSetter(args).setValues(ps);
			ps.executeUpdate();
			Integer key = keyGenerate.getKey(connection);
			long end = System.currentTimeMillis();
			if (end - begin >= 500) {
				System.out.println(" sql[" + sql + "]" + " time:"
						+ (end - begin));
			}
			return key;
		} catch (SQLException e) {
			throw new JdbcException(e);
		} finally {
			ConnectionProvider.release(connection, ps);
		}
	}

	public static void main(String[] args) {
		ConnectionProvider.setProxoolConfig("proxool.xml");
		JdbcTemplate template = new JdbcTemplate();

		try {
			Long i = template.queryForObject("test",
					"select count(0) from test.t", new Object[] {}, Long.class);
			System.out.println(i);
		} catch (JdbcException e) {
			e.printStackTrace();
		}

	}
}
