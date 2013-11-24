package com.vernon.oss.common.cache;

import com.vernon.oss.common.collection.Pair;

/**
 * 本地单对象缓冲
 * 
 * @author Vernon.Chen
 * @version 1.0 2012-11-19
 */
public class SingleCache<V> {
	private Pair<V, Long> _CACHE;

	/**
	 * 本地缓冲构造对象
	 * 
	 */
	public SingleCache() {
	}

	/**
	 * 本地获取缓冲对象
	 * 
	 * @return
	 */
	public V getKey() {
		if (_CACHE == null || System.currentTimeMillis() > _CACHE.getValue()) {
			return null;
		}
		return _CACHE.getKey();
	}

	/**
	 * 写一个对象到本地缓冲
	 * 
	 * @param value
	 * @param TTL
	 * @return
	 */
	public boolean put(V value, int TTL) {
		_CACHE = new Pair<V, Long>(value, System.currentTimeMillis() + TTL * 1000);
		return true;
	}

	/**
	 * 删除本地缓冲中与Key对应的对象并返回
	 * 
	 * @return
	 */
	public boolean remove() {
		_CACHE = null;
		return true;
	}

	/**
	 * 清空缓冲
	 * 
	 * @return
	 */
	public boolean clear() {
		return remove();
	}

}
