/**
 * 
 */
package com.vernon.oss.common.task;

/**
 * 任务调度接口
 * 
 * @author Vernon.Chen
 * @date 2013-2-5
 */
public interface Task {
	/**
	 * task processore method, task control thread execute it.
	 * 
	 * @throws Exception
	 */
	public void execute() throws Exception;

}
