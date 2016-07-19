package cn.lkj.TUtils;

import android.util.Log;

/**
 * Log������
 * 
 * @author LKJ
 * 
 */
public final class L {
	/** �Ƿ����ģʽ */
	public static boolean is_debug = true;

	private L() {
	}

	/**
	 * ��ӡLog
	 * 
	 * @param text
	 */
	public static void D(String text) {
		if (is_debug) {
			Log.d("Log", text);
		}
	}

	/**
	 * ��ӡLog
	 * 
	 * @param text
	 */
	public static void D(int text) {
		if (is_debug) {
			Log.d("Log", text + "");
		}
	}

	/**
	 * ��ӡLog
	 * 
	 * @param text
	 */
	public static void D(boolean text) {
		if (is_debug) {
			Log.d("Log", text + "");
		}
	}

	/**
	 * ��ӡLog
	 * 
	 * @param Object
	 */
	public static void D(Object text) {
		if (is_debug) {
			Log.d("Log", text + "");
		}
	}

	/**
	 * ��ӡLog
	 * 
	 * @param text
	 */
	public static void D(char text) {
		if (is_debug) {
			Log.d("Log", text + "");
		}
	}
}
