/**
 * 
 */
package com.vernon.oss.common.db;

/**
 * Jdbc异常类
 * 
 * @author Vernon.Chen
 *
 */
@SuppressWarnings("serial")
public class JdbcException extends Exception {

	/**
	 * 
	 */
	public JdbcException() {
		super("JdbcException");
	}

	/**
	 * @param message
	 */
	public JdbcException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public JdbcException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public JdbcException(String message, Throwable cause) {
		super(message, cause);
	}

}
