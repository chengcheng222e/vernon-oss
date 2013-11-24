/**
 * 
 */
package com.vernon.oss.common.db;

import java.sql.Connection;

/**
 * 主键生成器
 * 
 * @author Vernon.Chen
 *
 */
public interface KeyGenerate {
	/**
	 * 主键生成的方法,可返回NULL
	 * 
	 * @param connection
	 * @return
	 */
	public Integer getKey(Connection connection);

}
