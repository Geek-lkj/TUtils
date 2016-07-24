package cn.lkj.TUtils;

import java.util.HashMap;
import java.util.Map;

import android.graphics.Bitmap;

/**
 * 全局Object HashMap
 * 第一次运行请调用本类init初始化
 * @author LKJ
 * 
 */
public final class DUtils {

	private DUtils() {
	}

	private static HashMap<String, Object> map;

	public static void init() {
		if (map == null) {
			map = new HashMap<String, Object>();
		}
	}
	/**
	 * 设置数据
	 * @param key
	 * @param obj
	 */
	public void setData(String key, Object obj) {
		map.put(key, obj);
	}
	/**
	 * 获取数据
	 * @param key
	 * @param 是否从集合中清除该数据 true为删除 false为保留
	 * @return
	 */
	public Object getData(String key, boolean isDelete) {
		Object obj = map.get(key);
		if (isDelete) {
			map.remove(key);
		}
		return obj;
	}
	/**
	 * 清除数据
	 * @param key
	 */
	public void removeData(String key) {
		map.remove(key);

	}

}
