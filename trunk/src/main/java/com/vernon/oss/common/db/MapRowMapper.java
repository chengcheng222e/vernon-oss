/**
 * 
 */
package com.vernon.oss.common.db;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * 默认的Map行打包器,打包返回的对应于<key:字段名,value:值>
 * 
 * @author Vernon.Chen
 *
 */
public class MapRowMapper implements RowMapper<Map<String, Object>> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tx.db.jdbc.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	public Map<String, Object> mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		Map<String, Object> map = new HashMap<String, Object>();
		ResultSetMetaData metaData = rs.getMetaData();
		for (int i = 0; i < metaData.getColumnCount(); i++) {
			map.put(metaData.getColumnName(i + 1), rs.getObject(i + 1));
		}
		return map;
	}

}
