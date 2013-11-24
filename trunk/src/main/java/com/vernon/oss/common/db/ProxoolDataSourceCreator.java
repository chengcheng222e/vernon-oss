/**
 * 
 */
package com.vernon.oss.common.db;

import java.io.File;

import javax.sql.DataSource;

import org.logicalcobwebs.proxool.ProxoolDataSource;
import org.logicalcobwebs.proxool.ProxoolException;
import org.logicalcobwebs.proxool.configuration.JAXPConfigurator;

/**
 * 基于Proxool实现的DataSource创建器
 * 
 * @author Vernon.Chen
 *
 */
class ProxoolDataSourceCreator extends JNDIDataSourceCreator {

	/**
	 * ProxoolDataSourceCreator Construct
	 */
	ProxoolDataSourceCreator() {
		// proxool init by ServletConfigurator;
	}

	/**
	 * ProxoolDataSourceCreator Construct
	 * 
	 * @param proxoolConfig
	 */
	ProxoolDataSourceCreator(File proxoolConfig) {
		System.out.println("ProxoolDataSourceCreator Construct proxoolConfig:"
				+ proxoolConfig);
		if (proxoolConfig.exists()) {
			try {
				JAXPConfigurator.configure(proxoolConfig.toString(), false);
			} catch (ProxoolException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tx.db.SimpleDataSourceCreator#creatorDataSource(java.lang.String)
	 */
	@Override
	protected DataSource creatorDataSource(String dataSourceName) {
		return new ProxoolDataSource(dataSourceName);
	}

}
