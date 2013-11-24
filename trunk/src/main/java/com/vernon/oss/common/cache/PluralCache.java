package com.vernon.oss.common.cache;

import com.vernon.oss.common.collection.LRUMap;
import com.vernon.oss.common.collection.Pair;


/**
 * 本地多对象缓冲
 *
 * @author Vernon.Chen
 * @version 1.0 2012-11-19
 */
public class PluralCache<K, V> {
	private final LRUMap<K, Pair<V, Long>> _CACHE;

	/**
	 * 本地缓冲构造函数
	 * 
	 * @param maxSize 最大缓冲量
	 */
	public PluralCache(int maxSize) {
		_CACHE = new LRUMap<K, Pair<V, Long>>(maxSize);
	}

	/**
	 * 根据Key获取到对应的Value
	 * 
	 * @param key
	 * @return
	 */
	public V get(K key) {
		Pair<V, Long> pair = _CACHE.get(key);
		if (pair == null || System.currentTimeMillis() > pair.getValue()) {
			return null;
		}
		return pair.getKey();
	}

	/**
	 * 写入一个对象到本地缓冲
	 * 
	 * @param key
	 * @param valye
	 * @param TTL
	 * @return
	 */
	public boolean put(K key, V valye, int TTL) {
		return _CACHE.put(key, new Pair<V, Long>(valye, System.currentTimeMillis() + TTL * 1000)) != null;
	}

	/**
	 * 删除一个缓冲对象
	 * 
	 * @param key
	 * @return
	 */
	public boolean remove(K key) {
		_CACHE.remove(key);
		return true;
	}

	/**
	 * 清空本地缓存
	 * 
	 * @return
	 */
	public boolean clear() {
		_CACHE.clear();
		return true;
	}

	public static void main(String[] args) {
		PluralCache<String, String> cache = new PluralCache<String, String>(10000);
		cache.put("1000", "My", 1);
		// System.out.println(cache.get("1000"));
		try {
			Thread.sleep(100);
			System.out.println("sleep 100 ms ");
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println(cache.get("1000"));
		try {
			Thread.sleep(200);
			System.out.println("sleep 200 ms ");
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println(cache.get("1000"));
		try {
			Thread.sleep(500);
			System.out.println("sleep 500 ms ");
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println(cache.get("1000"));
		try {
			Thread.sleep(1000);
			System.out.println("sleep 1000 ms ");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(cache.get("1000"));

	}
}
