/**
 * 
 */
package com.vernon.oss.common.task;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 任务调度器,采用线程池调度
 * 
 * @author Vernon.Chen
 * @date 2013-2-5
 */
public class TaskExecutor {

	static {
		/**
		 * java hook method, by java VM exist before execute.
		 */
		Runtime.getRuntime().addShutdownHook(new Thread() {
			/*
			 * (non-Javadoc)
			 * @see java.lang.Thread#run()
			 */
			@Override
			public void run() {
				shutdown();
			}

		});
	}

	private static final ExecutorService executorService = Executors.newCachedThreadPool();

	/**
	 * add task to task pool
	 * 
	 * @param task 任务
	 * @param repeatInterval 循环调度时间,Millis
	 */
	public static void addTask(final Task task, final long repeatInterval) {
		Callable<Object> callable = new Callable<Object>() {
			@Override
			public Object call() throws Exception {
				try {
					long sleepInterval = repeatInterval;
					while (true) {
						Thread.sleep(sleepInterval);
						if (executorService.isShutdown() || executorService.isTerminated()) {
							break;
						}
						long beginTimeMillis = System.currentTimeMillis();
						task.execute();
						long endTimeMillis = System.currentTimeMillis();
						long useTimeMillis = endTimeMillis - beginTimeMillis;
						sleepInterval = repeatInterval - useTimeMillis;
						if (sleepInterval < 0) {
							sleepInterval = 0;
						}
					}
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
				return null;
			}
		};
		executorService.submit(callable);
	}

	/**
	 * shutdown taskExecutor
	 */
	public static void shutdown() {
		executorService.shutdown();
	}
}
