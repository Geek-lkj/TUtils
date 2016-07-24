package cn.lkj.TUtils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.lidroid.xutils.BitmapUtils;

/**
 * UI View 相关工具类
 * 
 * 程序第一次使用本类请用init初始化
 * @author LKJ
 * 
 * 本类包括
 * 
 * dp转为px					dp2px(int)
 * 
 * px转为dp					px2dp(int)
 * 
 * XML转为View				inflate(int)
 * 
 * 获取LayoutInflater		getLayoutInflater()
 * 
 * 获取Resources				getResources()
 * 
 * 根据资源ID获取字符串		getStringRes(int)
 * 
 * 根据资源ID获取字符串数组	getStringArrRes(int)
 * 
 * 加载网络图片注入ImageView httpGetBitMap
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
	 * dp转px
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
	 * px转dp
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
	 * 根据layout返回View
	 * 
	 * @param XML资源文件ID
	 * @return View
	 */
	public static View inflate(int xmlResId) {
		return View.inflate(mContext, xmlResId, null);
	}

	/**
	 * 获取LayoutInflater
	 * 
	 * @return
	 */
	public static LayoutInflater getLayoutInflater() {
		return LayoutInflater.from(mContext);
	}

	/**
	 * 获取资源对象
	 * 
	 * @return
	 */
	public static Resources getResources() {
		return mContext.getResources();
	}

	/**
	 * 获取资源字符串
	 * 
	 * @param resId
	 * @return
	 */
	public static String getStringRes(int resId) {
		return getResources().getString(resId);
	}

	/**
	 * 获取资源字符串数组
	 * 
	 * @param resId
	 * @return
	 */
	public static String[] getStringArrRes(int resId) {
		return getResources().getStringArray(resId);
	}
	
	/**
	 * 加载网络图片注入ImageView
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
