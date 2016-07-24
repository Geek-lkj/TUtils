package cn.lkj.TUtils;

import java.util.HashMap;
import java.util.Map;

import android.graphics.Bitmap;

/**
 * ȫ��Object HashMap
 * ��һ����������ñ���init��ʼ��
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
	 * ��������
	 * @param key
	 * @param obj
	 */
	public void setData(String key, Object obj) {
		map.put(key, obj);
	}
	/**
	 * ��ȡ����
	 * @param key
	 * @param �Ƿ�Ӽ�������������� trueΪɾ�� falseΪ����
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
	 * �������
	 * @param key
	 */
	public void removeData(String key) {
		map.remove(key);

	}

}
