package cn.lkj.TUtils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * SharedPreference工具类
 * 
 * 使用前调用本类的init方法
 * 
 * @author LKJ
 * 
 */
public final class SharedPreference_Utils {
	private static String CONFIG_NAME;

	private SharedPreference_Utils() {
	}

	private static SharedPreferences sp;

	/**
	 * 初始化SharedPreference工具类
	 * 
	 * @param context
	 *            上下文对象
	 * @param sharedPreferenceName
	 *            配置文件名
	 */
	public static void init(Context context, String sharedPreferenceName) {
		if (sp == null) {
			sp = context
					.getSharedPreferences(CONFIG_NAME, Context.MODE_PRIVATE);
			CONFIG_NAME = sharedPreferenceName;
		}
	}

	// public static SharedPreferences setSharePreferences() {
	// if (sp == null) {
	// return ZhgzApp.getApplication().getSharedPreferences(CONFIG_NAME,
	// Context.MODE_PRIVATE);
	// } else {
	// return sp;
	// }
	// }

	/**
	 * 设置Boolean
	 * 
	 * @param key
	 * @param value
	 */
	public static void setBoolean(String key, Boolean value) {
		sp.edit().putBoolean(key, value).commit();
	}

	/**
	 * 获取Boolean
	 * 
	 * @param key
	 * @param defValue
	 * @return
	 */
	public static boolean getBoolean(String key, Boolean defValue) {
		return sp.getBoolean(key, defValue);
	}

	/**
	 * 获取Boolean
	 * 
	 * @param key
	 * @return
	 */
	public static boolean getBoolean(String key) {
		return sp.getBoolean(key, false);
	}

	/**
	 * 获取String
	 * 
	 * @param key
	 * @return
	 */
	public static String getString(String key) {
		return sp.getString(key, "");
	}

	/**
	 * 获取String
	 * 
	 * @param key
	 * @return
	 */
	public static String getString(String key, String value) {
		return sp.getString(key, value);
	}

	/**
	 * 设置String
	 * 
	 * @param key
	 * @param value
	 */
	public static void setString(String key, String value) {
		sp.edit().putString(key, value).commit();
	}

}
