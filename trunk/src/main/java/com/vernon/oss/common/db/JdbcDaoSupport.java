/**
 * 
 */
package com.vernon.oss.common.db;

import java.util.Random;

import org.apache.log4j.Logger;

/**
 * Jdbc Dao的基本支撑类,应用在使用Jdbc的时候可以继承该类实现,内部对部分常用的操作进行了封装
 * 
 * @author Vernon.Chen
 *
 */
public class JdbcDaoSupport {

	protected Logger logger = Logger.getLogger(this.getClass());

	protected JdbcTemplate jdbcTemplate = new JdbcTemplate();

	protected String[] masterDSArray;

	protected String[] slaveDSArray;

	protected SequenceBuilder sequenceBuilder;

	/**
	 * @return the jdbcTemplate
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * @param jdbcTemplate
	 *            the jdbcTemplate to set
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * @return the sequenceBuilder
	 */
	public SequenceBuilder getSequenceBuilder() {
		return sequenceBuilder;
	}

	/**
	 * @param sequenceBuilder
	 *            the sequenceBuilder to set
	 */
	public void setSequenceBuilder(SequenceBuilder sequenceBuilder) {
		this.sequenceBuilder = sequenceBuilder;
	}

	/**
	 * @return the masterDSArray
	 */
	public String[] getMasterDSArray() {
		return masterDSArray;
	}

	/**
	 * @return the slaveDSArray
	 */
	public String[] getSlaveDSArray() {
		return slaveDSArray;
	}

	/**
	 * @param masterDSArray
	 *            the masterDSArray to set
	 */
	public void setMasterDSArray(String[] masterDSArray) {
		this.masterDSArray = masterDSArray;
	}

	/**
	 * @param slaveDSArray
	 *            the slaveDSArray to set
	 */
	public void setSlaveDSArray(String[] slaveDSArray) {
		this.slaveDSArray = slaveDSArray;
	}

	/**
	 * get Master DataSource String, Random By Master DS Array
	 * 
	 * @return
	 */
	protected final String getMasterDS() {
		if (masterDSArray == null) {
			return null;
		}
		return masterDSArray[new Random().nextInt(masterDSArray.length)];
	}

	/**
	 * get Slave DataSource String, Random By Slave DS Array
	 * 
	 * @return
	 */
	protected final String getSlaveDS() {
		if (slaveDSArray == null) {
			return null;
		}
		return slaveDSArray[new Random().nextInt(slaveDSArray.length)];
	}

	/**
	 * get Table Name by baseName,factory and parameter
	 * 
	 * @param baseTableName
	 * @param factor
	 * @param parameter
	 * @return
	 */
	protected final String getTableName(String baseTableName, Integer factor,
			Integer parameter) {
		if (baseTableName == null) {
			return null;
		}
		if (factor == null || parameter == null || factor <= 1) {
			return baseTableName;
		}
		return baseTableName + parameter % factor;
	}

}
