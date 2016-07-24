package cn.lkj.TUtils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.lidroid.xutils.BitmapUtils;

/**
 * UI View ��ع�����
 * 
 * �����һ��ʹ�ñ�������init��ʼ��
 * @author LKJ
 * 
 * �������
 * 
 * dpתΪpx					dp2px(int)
 * 
 * pxתΪdp					px2dp(int)
 * 
 * XMLתΪView				inflate(int)
 * 
 * ��ȡLayoutInflater		getLayoutInflater()
 * 
 * ��ȡResources				getResources()
 * 
 * ������ԴID��ȡ�ַ���		getStringRes(int)
 * 
 * ������ԴID��ȡ�ַ�������	getStringArrRes(int)
 * 
 * ��������ͼƬע��ImageView httpGetBitMap
 */
public final class VUtils {

	private static Context mContext;
	private static BitmapUtils btu;

	private VUtils() {
	}

	public static void init(Context context) {
		if (mContext == null) {
			mContext = context;
		}
	}

	/**
	 * dpתpx
	 * 
	 * @param dp
	 * @return px
	 */
	public static int dp2px(int dp) {
		DisplayMetrics displayMetrics = mContext.getResources()
				.getDisplayMetrics();
		float density = displayMetrics.density;
		float densityDpi = displayMetrics.densityDpi;
		return (int) (density * dp + 0.5);
	}

	/**
	 * pxתdp
	 * 
	 * @param dp
	 * @return px
	 */
	public static int px2dp(int px) {
		DisplayMetrics displayMetrics = mContext.getResources()
				.getDisplayMetrics();
		float density = displayMetrics.density;
		float densityDpi = displayMetrics.densityDpi;
		return (int) (density / px + 0.5);
	}

	/**
	 * ����layout����View
	 * 
	 * @param XML��Դ�ļ�ID
	 * @return View
	 */
	public static View inflate(int xmlResId) {
		return View.inflate(mContext, xmlResId, null);
	}

	/**
	 * ��ȡLayoutInflater
	 * 
	 * @return
	 */
	public static LayoutInflater getLayoutInflater() {
		return LayoutInflater.from(mContext);
	}

	/**
	 * ��ȡ��Դ����
	 * 
	 * @return
	 */
	public static Resources getResources() {
		return mContext.getResources();
	}

	/**
	 * ��ȡ��Դ�ַ���
	 * 
	 * @param resId
	 * @return
	 */
	public static String getStringRes(int resId) {
		return getResources().getString(resId);
	}

	/**
	 * ��ȡ��Դ�ַ�������
	 * 
	 * @param resId
	 * @return
	 */
	public static String[] getStringArrRes(int resId) {
		return getResources().getStringArray(resId);
	}
	
	/**
	 * ��������ͼƬע��ImageView
	 * @param iv
	 * @param url
	 */
	public static void httpGetBitMap(ImageView iv,String url){
		if(btu == null){
			btu = new BitmapUtils(mContext);
		}
		btu.display(iv, url);
	}

}
