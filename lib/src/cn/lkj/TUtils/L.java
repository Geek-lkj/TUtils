package cn.lkj.TUtils;

import android.util.Log;

/**
 * Log工具类
 * 
 * @author LKJ
 * 
 */
public final class L {
	/** 是否调试模式 */
	public static boolean is_debug = true;

	private L() {
	}

	/**
	 * 打印Log
	 * 
	 * @param text
	 */
	public static void D(String text) {
		if (is_debug) {
			Log.d("Log", text);
		}
	}

	/**
	 * 打印Log
	 * 
	 * @param text
	 */
	public static void D(int text) {
		if (is_debug) {
			Log.d("Log", text + "");
		}
	}

	/**
	 * 打印Log
	 * 
	 * @param text
	 */
	public static void D(boolean text) {
		if (is_debug) {
			Log.d("Log", text + "");
		}
	}

	/**
	 * 打印Log
	 * 
	 * @param Object
	 */
	public static void D(Object text) {
		if (is_debug) {
			Log.d("Log", text + "");
		}
	}

	/**
	 * 打印Log
	 * 
	 * @param text
	 */
	public static void D(char text) {
		if (is_debug) {
			Log.d("Log", text + "");
		}
	}
}
