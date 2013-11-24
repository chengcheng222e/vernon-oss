/**
 * 
 */
package com.vernon.oss.common.db;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

/**
 * 利用反射机制直接映射列名到对象
 * 
 * @author Vernon.Chen
 *
 * @param <T>
 */
public class ReflectRowMapper<T> implements RowMapper<T> {

	private Logger logger = Logger.getLogger(this.getClass());

	private Class<T> classDefinition;

	public ReflectRowMapper(Class<T> classDefinition) {
		this.classDefinition = classDefinition;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ku6g.common.db.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	public T mapRow(ResultSet rs, int rowNum) throws SQLException {
		if (classDefinition == null) {
			return null;
		}
		try {
			ResultSetMetaData metaData = rs.getMetaData();
			Map<String, Object> map = new HashMap<String, Object>();
			for (int i = 0; i < metaData.getColumnCount(); i++) {
				map.put(metaData.getColumnName(i + 1), rs.getObject(i + 1));
			}
			T result = classDefinition.newInstance();
			BeanUtils.populate(result, map);
			return result;
		} catch (IllegalAccessException e) {
			logger.error(e);
		} catch (InstantiationException e) {
			logger.error(e);
		} catch (InvocationTargetException e) {
			logger.error(e);
		}
		return null;
	}

}
