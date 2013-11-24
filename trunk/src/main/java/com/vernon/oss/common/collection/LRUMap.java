/**
 * 
 */
package com.vernon.oss.common.collection;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * LRUMap: 实现最近最少使用原则的Map <br/>
 * 1.在调用get()，put()方法的时候，影响到的元素会被放置在Iterator的首部<br/>
 * 2.遍历时不能进行put、get操作，否则会抛出ConcurrentModificationException异常<br/>
 * 3.已修改为线程安全的<br/>
 * 
 * @author Vernon.Chen
 * 
 */
public class LRUMap<K, V>
		extends LinkedHashMap<K, V> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1870117397529686755L;

	// 因为LRUMap在读的时候也有写操作,所以不使用ReadWriteLock
	private final ReentrantLock lock = new ReentrantLock();

	private final int maxSize;

	/**
	 * 构造函数
	 * 
	 * @param initCapacity int 此map的初始化大小
	 * @param maxSize int 此map最大容量，如map插入的数值超过此大小，最早被访问的元素将会被抛弃
	 */
	public LRUMap(int initCapacity, int maxSize) {
		super(initCapacity, 0.75f, true);
		this.maxSize = maxSize;
	}

	/**
	 * @param maxSize 此map的最大容量，初始大小为最大容量的1/4
	 */
	public LRUMap(int maxSize) {
		super(maxSize >> 2, 0.75f, true);
		this.maxSize = maxSize;
	}

	/**
	 * 删除
	 */
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return this.size() >= maxSize;
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.LinkedHashMap#get(java.lang.Object)
	 */
	@Override
	public V get(Object key) {
		try {
			lock.lock();
			return super.get(key);
		} finally {
			lock.unlock();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.HashMap#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V put(K key, V val) {
		try {
			lock.lock();
			return super.put(key, val);
		} finally {
			lock.unlock();
		}
	}
}
