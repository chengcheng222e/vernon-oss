/**
 * 
 */
package com.vernon.oss.common.db;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 行打包器
 * 
 * @author Vernon.Chen
 *
 * @param <T>
 */
public interface RowMapper<T> {
	/**
	 * 对ResultSet返回的每一行数据进行封装的方法,用作行数据与BEAN的映射
	 * 
	 * @param resultSet
	 * @param rowNum
	 * @return
	 * @throws SQLException
	 */
	public T mapRow(ResultSet resultSet, int rowNum) throws SQLException;

}
