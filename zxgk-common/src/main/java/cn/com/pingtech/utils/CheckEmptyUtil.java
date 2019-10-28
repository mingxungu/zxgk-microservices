package cn.com.pingtech.utils;

import java.util.Collection;
import java.util.Map;


/**
 * @author gumx
 * @title: CheckEmptyUtil
 * @description: 判空工具类
 * @date 2019/8/27 13:31
 */
public class CheckEmptyUtil {


	public static boolean isEmpty(String str) {
		if (str == null || str.trim().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 字符串是否不为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		// 如果为空，返回false
		return !isEmpty(str);
	}


	public static boolean isEmpty(Object[] objs) {
		if (objs == null || objs.length <= 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isNotEmpty(Object[] objs) {
		// 如果为空，返回false
		return !isEmpty(objs);
	}


	public static boolean isEmpty(Collection list) {
		if (list == null || list.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * list是否不为空
	 * 
	 * @param list
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static boolean isNotEmpty(Collection list) {
		// 如果为空，返回false
		return !isEmpty(list);
	}

	/**
	 * map是否为空
	 * 
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static boolean isEmpty(Map map) {
		if (map == null || map.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * map是否不为空
	 * 
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static boolean isNotEmpty(Map map) {
		return !isEmpty(map);
	}

}
