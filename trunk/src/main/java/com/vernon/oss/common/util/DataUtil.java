package com.vernon.oss.common.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 * 数据生成工具类
 * 
 * @date 2013-1-27
 * @author Vernon.Chen
 */
public class DataUtil {

	private static Random random = new Random();

	/**
	 * 从参数范围内获取一个随机数
	 * 
	 * @param firstValue 开始值
	 * @param lastValue 结束值
	 * @return
	 */
	public static int randomNumber(int firstValue, int lastValue) {
		int choices = lastValue - firstValue + 1;
		return (int) Math.floor(Math.random() * choices + firstValue);
	}

	/**
	 * 返回随机ID
	 * 
	 * @return
	 */
	public static long randomId() {
		return random.nextLong();
	}

	/**
	 * 从list中随机返回一个对象
	 * 
	 * @param <T>
	 * @param list
	 * @return
	 */
	public static <T> T randomOne(List<T> list) {
		List<T> temp = randomSome(list, 1);
		return null != temp && temp.size() > 0 ? temp.get(0) : null;
	}

	/**
	 * 从list中返回随机个对象
	 * 
	 * @param <T> 类型
	 * @param list List
	 * @return
	 */
	public static <T> List<T> randomSome(List<T> list) {
		return randomSome(list, random.nextInt(list.size()));
	}

	/**
	 * 从list中随机返回count个对象
	 * 
	 * @param <T> 类型
	 * @param list List
	 * @param count 数量
	 * @return
	 */
	public static <T> List<T> randomSome(List<T> list, int count) {
		if (null == list || list.size() == 0) {
			return null;
		}
		Collections.shuffle(list);
		return subSome(list, 0, count);
	}

	/**
	 * 从list中from开始返回count个对象
	 * 
	 * @param <T>
	 * @param list List
	 * @param from 开始值
	 * @param count 数量
	 * @return
	 */
	public static <T> List<T> subSome(List<T> list, int from, int count) {
		if (list == null || from > list.size()) {
			return null;
		}
		if (from + count > list.size()) {
			return list.subList(from, list.size());
		}
		return list.subList(from, count);
	}

	/**
	 * 倒序list
	 * 
	 * @param <T> 类型
	 * @param list List
	 * @return
	 */
	public static <T> List<T> revert(List<T> list) {
		if (list == null || list.size() == 0) {
			return null;
		}
		// 构建堆栈, 并对list进行出栈操作
		Stack<T> stack = new Stack<T>();
		List<T> temp = new ArrayList<T>();
		for (T t : list) {
			stack.push(t);
		}
		while (!stack.empty()) {
			temp.add(stack.pop());
		}
		return temp;
	}
}
