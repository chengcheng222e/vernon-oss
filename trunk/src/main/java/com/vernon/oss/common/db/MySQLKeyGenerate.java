/**
 * 
 */
package com.vernon.oss.common.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * MySQL的主键生成器
 * 
 * @author Vernon.Chen
 *
 */
public class MySQLKeyGenerate implements KeyGenerate {

	public Integer getKey(Connection connection) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement("select last_insert_id()");
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} catch (Exception ignored) {
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ignored) {
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException ignored) {
				}
			}
		}

		return null;
	}

}
