/**
 * 
 */
package com.vernon.oss.common.db;

import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * 基于JNDI的DataSource创建器
 * 
 * @author Vernon.Chen
 *
 */
class JNDIDataSourceCreator implements DataSourceCreator {

	private static final Map<String, DataSource> _POOL = new HashMap<String, DataSource>();

	public DataSource execute(String dataSourceName) {
		DataSource dataSource = null;
		if (dataSourceName != null && dataSourceName.trim().length() > 0) {
			synchronized (_POOL) {
				if (_POOL.containsKey(dataSourceName)) {
					dataSource = _POOL.get(dataSourceName);
				} else {
					dataSource = this.creatorDataSource(dataSourceName);
					if (dataSource != null) {
						_POOL.put(dataSourceName, dataSource);
					}
				}
			}
		}
		return dataSource;
	}

	protected DataSource creatorDataSource(String dataSourceName) {
		try {
			return (DataSource) new InitialContext()
					.lookup("java:comp/env/jdbc/" + dataSourceName);
		} catch (NamingException e) {
			System.err
					.println("JNDIDataSourceCreator creatorDataSource failed,dataSourceName["
							+ dataSourceName + "] not find by Context");
		}
		return null;
	}
}
