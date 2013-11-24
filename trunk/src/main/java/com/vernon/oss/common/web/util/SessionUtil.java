package com.vernon.oss.common.web.util;

import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

/**
 *
 * @author Vernon.Chen
 * @version 1.0 2012-11-22
 */
public class SessionUtil {

	/**
	 * 删除对象
	 * 
	 * @param session
	 * @param attributeName
	 * @return
	 */
	public static Object removeAttribute(HttpSession session, String attributeName) {
		Object obj = getAttributeForObject(session, attributeName, null);
		session.removeAttribute(attributeName);
		return obj;
	}

	/**
	 * 清空所有attribute
	 * 
	 * @param session
	 */
	public static void clearAttribute(HttpSession session) {
		Enumeration<String> enumeration = session.getAttributeNames();
		while (enumeration.hasMoreElements()) {
			String attributeName = enumeration.nextElement();
			removeAttribute(session, attributeName);
		}
	}

	/**
	 * 设置
	 * 
	 * @param session
	 * @param attributeName
	 * @param value
	 * @return
	 */
	public static Object setAttribute(HttpSession session, String attributeName, Object value) {
		if (session == null) {
			throw new NullPointerException("HttpSession NULL!");
		}
		Object obj = getAttributeForObject(session, attributeName, value);
		session.setAttribute(attributeName, value);
		return obj;
	}

	/**
	 * 获取对象
	 * 
	 * @param session
	 * @param attributeName
	 * @param defaultValue
	 * @return
	 */
	public static Object getAttributeForObject(HttpSession session, String attributeName, Object defaultValue) {
		if (session == null) {
			throw new NullPointerException("HttpSession NULL!");
		}
		Object attributeValue = session.getAttribute(attributeName);
		if (attributeValue == null) {
			attributeValue = defaultValue;
		}
		return attributeValue;
	}

	/**
	 * 获取字符串
	 * 
	 * @param session
	 * @param attributeName
	 * @param defaultValue
	 * @return
	 * @throws NullPointerException
	 */
	public static String getAttributeForString(HttpSession session, String attributeName, String defaultValue)
			throws NullPointerException {
		Object attributeValue = SessionUtil.getAttributeForObject(session, attributeName, defaultValue);
		if (attributeValue != null) {
			if (attributeValue instanceof String) {
				return (String) attributeValue;
			}
		}
		return defaultValue;
	}

	/**
	 * 获取整形数字
	 * 
	 * @param session
	 * @param attributeName
	 * @param defaultValue
	 * @return
	 * @throws NullPointerException
	 */
	public static Integer getAttributeForInteger(HttpSession session, String attributeName, Integer defaultValue)
			throws NullPointerException {
		Object attributeValue = SessionUtil.getAttributeForObject(session, attributeName, defaultValue);
		if (attributeValue != null) {
			if (attributeValue instanceof Integer) {
				return (Integer) attributeValue;
			}
		}
		return defaultValue;
	}

	/**
	 * 获取长整形数字
	 * 
	 * @param session
	 * @param attributeName
	 * @param defaultValue
	 * @return
	 * @throws NullPointerException
	 */
	public static Long getAttributeForLong(HttpSession session, String attributeName, Long defaultValue)
			throws NullPointerException {
		Object attributeValue = SessionUtil.getAttributeForObject(session, attributeName, defaultValue);
		if (attributeValue != null) {
			if (attributeValue instanceof Long) {
				return (Long) attributeValue;
			}
		}
		return defaultValue;
	}

	/**
	 * 获取双精度浮点型数字
	 * 
	 * @param session
	 * @param attributeName
	 * @param defaultValue
	 * @return
	 * @throws NullPointerException
	 */
	public static Double getAttributeForDouble(HttpSession session, String attributeName, Double defaultValue)
			throws NullPointerException {
		Object attributeValue = SessionUtil.getAttributeForObject(session, attributeName, defaultValue);
		if (attributeValue != null) {
			if (attributeValue instanceof Double) {
				return (Double) attributeValue;
			}
		}
		return defaultValue;
	}

	/**
	 * 获取浮点型数字
	 * 
	 * @param session
	 * @param attributeName
	 * @param defaultValue
	 * @return
	 * @throws NullPointerException
	 */
	public static Float getAttributeForFloat(HttpSession session, String attributeName, Float defaultValue)
			throws NullPointerException {
		Object attributeValue = SessionUtil.getAttributeForObject(session, attributeName, defaultValue);
		if (attributeValue != null) {
			if (attributeValue instanceof Float) {
				return (Float) attributeValue;
			}
		}
		return defaultValue;
	}

	/**
	 * 获取短整形数字
	 * 
	 * @param session
	 * @param attributeName
	 * @param defaultValue
	 * @return
	 * @throws NullPointerException
	 */
	public static Short getAttributeForShort(HttpSession session, String attributeName, Short defaultValue)
			throws NullPointerException {
		Object attributeValue = SessionUtil.getAttributeForObject(session, attributeName, defaultValue);
		if (attributeValue != null) {
			if (attributeValue instanceof Short) {
				return (Short) attributeValue;
			}
		}
		return defaultValue;
	}

	/**
	 * 获取字节对象
	 * 
	 * @param session
	 * @param attributeName
	 * @param defaultValue
	 * @return
	 * @throws NullPointerException
	 */
	public static Byte getAttributeForByte(HttpSession session, String attributeName, Byte defaultValue)
			throws NullPointerException {
		Object attributeValue = SessionUtil.getAttributeForObject(session, attributeName, defaultValue);
		if (attributeValue != null) {
			if (attributeValue instanceof Byte) {
				return (Byte) attributeValue;
			}
		}
		return defaultValue;
	}

	/**
	 * 获取时间对象
	 * 
	 * @param session
	 * @param attributeName
	 * @param defaultValue
	 * @return
	 * @throws NullPointerException
	 */
	public static Date getAttributeForDate(HttpSession session, String attributeName, Date defaultValue)
			throws NullPointerException {
		Object attributeValue = SessionUtil.getAttributeForObject(session, attributeName, defaultValue);
		if (attributeValue != null) {
			if (attributeValue instanceof Date) {
				return (Date) attributeValue;
			}
		}
		return defaultValue;
	}

	/**
	 * 获取Map
	 * 
	 * @param <K>
	 * @param <V>
	 * @param session
	 * @param attributeName
	 * @param defaultValue
	 * @return
	 * @throws NullPointerException
	 */
	@SuppressWarnings("unchecked")
	public static <K, V> Map<K, V> getAttributeForMap(HttpSession session, String attributeName, Map<K, V> defaultValue)
			throws NullPointerException {
		Object attributeValue = SessionUtil.getAttributeForObject(session, attributeName, defaultValue);
		if (attributeValue != null) {
			try {
				return (Map<K, V>) attributeValue;
			} catch (ClassCastException ignored) {
			}
		}
		return defaultValue;
	}

	/**
	 * 获取Set
	 * 
	 * @param <T>
	 * @param session
	 * @param attributeName
	 * @param defaultValue
	 * @return
	 * @throws NullPointerException
	 */
	@SuppressWarnings("unchecked")
	public static <T> Set<T> getAttributeForSet(HttpSession session, String attributeName, Set<T> defaultValue)
			throws NullPointerException {
		Object attributeValue = SessionUtil.getAttributeForObject(session, attributeName, defaultValue);
		if (attributeValue != null) {
			try {
				return (Set<T>) attributeValue;
			} catch (ClassCastException ignored) {
			}
		}
		return defaultValue;
	}

	/**
	 * 获取List
	 * 
	 * @param <T>
	 * @param session
	 * @param attributeName
	 * @param defaultValue
	 * @return
	 * @throws NullPointerException
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> getAttributeForList(HttpSession session, String attributeName, List<T> defaultValue)
			throws NullPointerException {
		Object attributeValue = SessionUtil.getAttributeForObject(session, attributeName, defaultValue);
		if (attributeValue != null) {
			try {
				return (List<T>) attributeValue;
			} catch (ClassCastException ignored) {
			}
		}
		return defaultValue;
	}

	/**
	 * 获取名称列表
	 * 
	 * @param session
	 * @return
	 */
	public static String[] getAttributeNames(HttpSession session) {
		Enumeration<String> enumeration = session.getAttributeNames();
		if (enumeration != null) {
			String[] attributeNames = new String[16];
			int cursor = 0;
			while (enumeration.hasMoreElements()) {
				if (cursor >= attributeNames.length) {
					String[] swap = new String[attributeNames.length + (attributeNames.length / 2)];
					System.arraycopy(attributeNames, 0, swap, 0, attributeNames.length);
					attributeNames = swap;
				}
				attributeNames[cursor] = enumeration.nextElement();
				cursor++;
			}
			if (attributeNames.length > cursor) {
				String[] swap = new String[cursor];
				System.arraycopy(attributeNames, 0, swap, 0, cursor);
				attributeNames = swap;
			}
			return attributeNames;
		}
		return null;
	}
}
