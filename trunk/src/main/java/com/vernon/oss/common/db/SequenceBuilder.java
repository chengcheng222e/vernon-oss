/**
 * 
 */
package com.vernon.oss.common.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import com.vernon.oss.common.collection.Pair;

/**
 * 序列引擎,基于序列方式的序号生成机制
 * 
 * @author Vernon.Chen
 *
 */
public class SequenceBuilder
		extends JdbcDaoSupport {

	/**
	 * sequence pool
	 */
	private static final HashMap<String, Pair<Integer, Integer>> _POOL = new HashMap<String, Pair<Integer, Integer>>();
	/**
	 * sequence private lock
	 */
	private static final Map<String, ReentrantLock> _LOCKS = new HashMap<String, ReentrantLock>();
	/**
	 * public lock
	 */
	private static final ReentrantLock _LOCK = new ReentrantLock();

	/**
	 * default auto increment value
	 */
	private int increment = 20;
	/**
	 * dataSource name
	 */
	private String dsName;

	/**
	 * 构造函数
	 * 
	 * @param dsName
	 */
	public SequenceBuilder(String dsName) {
		this.dsName = dsName;
	}

	/**
	 * 构造函数
	 * 
	 * @param dsName
	 * @param increment
	 */
	public SequenceBuilder(String dsName, int increment) {
		this.dsName = dsName;
		if (increment > 0) {
			this.increment = increment;
		}
	}

	/**
	 * 获得下一个序列值,序列值对应sequence_name每次+1,应用重启可能导致序列值不连续
	 * 
	 * @param sequenceName
	 * @return
	 */
	public final int nextValue(String sequenceName) {
		int result = -1;
		// 键
		final String _pool_key = dsName + ":" + sequenceName;
		// 缓冲池中的对象
		Pair<Integer, Integer> pair = _POOL.get(_pool_key);
		// 局部锁对象
		ReentrantLock lock = _LOCKS.get(_pool_key);

		// 开启全局锁
		if (pair == null) {
			_LOCK.lock();
			try {
				pair = _POOL.get(_pool_key);
				if (pair == null) {
					int value = this.valueCreator(sequenceName);
					if (value == 0 || value + this.increment <= 0) {
						value = this.valueCreator(sequenceName);
					}
					if (value > 0) {
						pair = new Pair<Integer, Integer>(value, value + increment);
						lock = new ReentrantLock();
						_LOCKS.put(_pool_key, lock);
						_POOL.put(_pool_key, pair);
					}

				}
			} finally {
				_LOCK.unlock();
			}
		}

		if (pair != null) {
			lock.lock();
			try {
				// 重新获取一次
				pair = _POOL.get(_pool_key);
				Integer value = pair.getKey();
				if (value >= pair.getValue() || value <= 0) {
					value = this.valueCreator(sequenceName);
					if (value == 0 || value + this.increment <= 0) {
						value = this.valueCreator(sequenceName);
					}
					if (value > 0) {
						result = value;
						pair = new Pair<Integer, Integer>(value + 1, increment + value);
						_POOL.put(dsName + ":" + sequenceName, pair);
					}
				} else {
					result = value;
					pair.setKey(value + 1);
				}
			} finally {
				lock.unlock();
			}
		}
		return result;
	}

	/**
	 * value creator
	 * 
	 * @param sequenceName
	 * @return
	 */
	protected int valueCreator(String sequenceName) {
		int result = 0;
		Connection connection = ConnectionProvider.getConnection(this.dsName);
		if (connection == null) {
			return result;
		}
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection.prepareStatement("lock tables sequence write").execute();
			preparedStatement = connection.prepareStatement("select next_value from sequence where sequence_name=?");
			preparedStatement.setString(1, sequenceName);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				result = resultSet.getInt(1);
			}
			if (result < 0 || result + increment < 0) {
				System.out.println("nextValue cycle!");
				preparedStatement = connection
						.prepareStatement("update sequence set next_value = ? where sequence_name=?");
				preparedStatement.setInt(1, increment + 1);
				preparedStatement.setString(2, sequenceName);
				preparedStatement.executeUpdate();
				result = 1;
			} else if (result == 0) {// 该表的next_value不存在
				preparedStatement = connection
						.prepareStatement("insert into sequence(sequence_name,next_value) values(?,?)");
				preparedStatement.setString(1, sequenceName);
				preparedStatement.setInt(2, increment + 1);
				preparedStatement.executeUpdate();
				result = 1;
			} else {
				preparedStatement = connection
						.prepareStatement("update sequence set next_value = next_value + ? where sequence_name=?");
				preparedStatement.setInt(1, increment);
				preparedStatement.setString(2, sequenceName);
				preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			logger.info(e);
		} finally {
			try {
				connection.prepareStatement("unlock tables").execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionProvider.release(connection, preparedStatement, resultSet);
		}
		return result;
	}
}
