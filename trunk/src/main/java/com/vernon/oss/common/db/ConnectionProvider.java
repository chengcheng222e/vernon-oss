/**
 * 
 */
package com.vernon.oss.common.db;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

/**
 * 数据库连接提供者
 * 
 * @author Vernon.Chen
 * 
 */
public class ConnectionProvider {

	private static Logger logger = Logger.getLogger(ConnectionProvider.class);

	/**
	 * transactioin support
	 */
	private static ThreadLocal<Map<String, Connection>> transaction = new ThreadLocal<Map<String, Connection>>();

	/**
	 * dataSource creator,creator dataSource by it.
	 */
	private static DataSourceCreator dataSourceCreator = null;
	/**
	 * proxool configure file
	 */
	public static File proxoolConfig = null;
	/**
	 * init state
	 */
	public static volatile Boolean noInitial = true;

	/**
	 * 
	 */
	private ConnectionProvider() {
	}

	/**
	 * set proxoolConfig
	 * 
	 * @param fileName
	 */
	public static void setProxoolConfig(String fileName) {
		try {
			Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(fileName);
			if (urls == null || !urls.hasMoreElements()) {
				throw new java.lang.RuntimeException("no proxool config find! please put " + fileName
						+ " in your classpath");
			}
			if (urls.hasMoreElements()) {
				String filepath = urls.nextElement().getFile();
				// 对于文件路径有空格做处理
				filepath = filepath.replace("%20", " ");
				System.out.println("proxool filepath:" + filepath);
				setProxoolConfig(new File(filepath));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * set ConnectionProvider get DataSource by Proxool
	 */
	public static void setProxoolConfig(File proxoolConfig) {
		if (noInitial) {
			ConnectionProvider.proxoolConfig = proxoolConfig;
			initial();
		}
	}

	/**
	 * set ConnectionProvider get DataSource by JNDI
	 */
	public static void setJNDIConfig() {
		if (noInitial) {
			logger.info(" set jndi");
			initial();
		}
	}

	/**
	 * 开启对简单事务的支持
	 */
	public static void openTransaction() {
		if (transaction.get() == null) {
			Map<String, Connection> connections = new HashMap<String, Connection>();
			transaction.set(connections);
		}

	}

	/**
	 * 是否开启了对简单事务的支持
	 * 
	 * @return
	 */
	public static boolean isTransaction() {
		return transaction.get() != null;
	}

	/**
	 * 事务提交
	 */
	public static void closeTransaction() {
		Map<String, Connection> connections = transaction.get();
		if (connections == null) {
			return;
		}
		transaction.remove();
		for (String dsName : connections.keySet()) {
			Connection connection = connections.get(dsName);
			if (connection == null) {
				continue;
			}
			release(connection);
		}
	}

	/**
	 * Get Connection By DataSourceName
	 * 
	 * @param dataSourceName
	 * @return
	 */
	public static Connection getConnection(String dataSourceName) {
		if (isTransaction()) {
			Connection connection = transaction.get().get(dataSourceName);
			if (connection == null) {
				logger.debug("ConnectionProvider Transaction Open, getConnection From DataSource!");
				connection = getConnectionFromDS(dataSourceName);
				if (connection != null) {
					transaction.get().put(dataSourceName, connection);
				}
			} else {
				logger.debug("ConnectionProvider Transaction Open, getConnection From ThreadLocal!");
			}
			return connection;
		} else {
			return getConnectionFromDS(dataSourceName);
		}
	}

	/**
	 * Get Connection By DataSourceName
	 * 
	 * @param dataSourceName
	 * @return
	 */
	public static Connection getConnectionFromDS(String dataSourceName) {
		Connection connection = null;
		try {
			if (dataSourceCreator != null) {
				DataSource dataSource = dataSourceCreator.execute(dataSourceName);
				if (dataSource != null) {
					connection = dataSource.getConnection();
				}
			}
		} catch (SQLException e) {
			logger.error("ConnectionProvision getConnection failed,erro:" + e.getMessage());
		}
		return connection;
	}

	/**
	 * initial dataSourceCreator
	 */
	private static void initial() {
		if (noInitial) {
			if (proxoolConfig != null && proxoolConfig.exists()) {
				logger.info(" proxool init by proxoolConfig !");
				dataSourceCreator = new ProxoolDataSourceCreator(proxoolConfig);
			} else {
				logger.info("JNDI init !");
				dataSourceCreator = new JNDIDataSourceCreator();
			}
			noInitial = false;
		}
	}

	/**
	 * release connection , statement ,resultset
	 * 
	 * @param connection
	 * @param statement
	 * @param resultSet
	 */
	public static void release(Connection connection, Statement statement, ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				logger.error("ResultSet release faild! error:" + e.getMessage());
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				logger.error("Statement release faild! error:" + e.getMessage());
			}
		}
		if (connection != null && !isTransaction()) {
			try {
				connection.close();
			} catch (SQLException e) {
				logger.error("Connection release faild! error:" + e.getMessage());
			}
		}
	}

	/**
	 * release connection
	 * 
	 * @param connection
	 */
	public static void release(Connection connection) {

		if (connection != null && !isTransaction()) {
			try {
				connection.close();
			} catch (SQLException e) {
				logger.error("Connection release faild! error:" + e.getMessage());
			}
		}
	}

	/**
	 * release connection and statement
	 * 
	 * @param connection
	 * @param statement
	 */
	public static void release(Connection connection, Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				logger.error("Statement release faild! error:" + e.getMessage());
			}
		}
		if (connection != null && !isTransaction()) {
			try {
				connection.close();
			} catch (SQLException e) {
				logger.error("Connection release faild! error:" + e.getMessage());
			}
		}
	}

}
