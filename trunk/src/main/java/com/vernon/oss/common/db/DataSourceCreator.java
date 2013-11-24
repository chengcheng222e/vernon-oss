/**
 * 
 */
package com.vernon.oss.common.db;

import javax.sql.DataSource;

/**
 * DataSource的创建器
 * 
 * @author Vernon.Chen
 *
 */
interface DataSourceCreator {
	/**
	 * creator DataSource method,creator DataSoure by dataSource Name
	 * 
	 * @param dataSourceName
	 * @return
	 */
	DataSource execute(String dataSourceName);

}
