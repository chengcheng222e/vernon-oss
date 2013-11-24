package com.vernon.oss.common.collection;

import java.io.Serializable;

/**
 *
 * @author Vernon.Chen
 * @version 1.0 2012-11-19
 */
public class Pair<K, V>
	implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8364297969782349043L;

	private K key;
	private V value;

	public Pair() {
		super();
	}

	public Pair(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Pair [key=" + key + ", value=" + value + "]";
	}

}
