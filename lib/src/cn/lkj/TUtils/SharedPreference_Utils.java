package cn.lkj.TUtils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * SharedPreference������
 * 
 * ʹ��ǰ���ñ����init����
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
	 * ��ʼ��SharedPreference������
	 * 
	 * @param context
	 *            �����Ķ���
	 * @param sharedPreferenceName
	 *            �����ļ���
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
	 * ����Boolean
	 * 
	 * @param key
	 * @param value
	 */
	public static void setBoolean(String key, Boolean value) {
		sp.edit().putBoolean(key, value).commit();
	}

	/**
	 * ��ȡBoolean
	 * 
	 * @param key
	 * @param defValue
	 * @return
	 */
	public static boolean getBoolean(String key, Boolean defValue) {
		return sp.getBoolean(key, defValue);
	}

	/**
	 * ��ȡBoolean
	 * 
	 * @param key
	 * @return
	 */
	public static boolean getBoolean(String key) {
		return sp.getBoolean(key, false);
	}

	/**
	 * ��ȡString
	 * 
	 * @param key
	 * @return
	 */
	public static String getString(String key) {
		return sp.getString(key, "");
	}

	/**
	 * ��ȡString
	 * 
	 * @param key
	 * @return
	 */
	public static String getString(String key, String value) {
		return sp.getString(key, value);
	}

	/**
	 * ����String
	 * 
	 * @param key
	 * @param value
	 */
	public static void setString(String key, String value) {
		sp.edit().putString(key, value).commit();
	}

}
