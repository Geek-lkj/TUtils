package cn.lkj.TUtils.adapter;

import java.util.ArrayList;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * ViewPager������
 * 
 * @author LKJ
 * 
 */
public class ViewPagerAdapter extends PagerAdapter {

	public ArrayList<View> list = new ArrayList<View>();

	/**
	 * ���ü�������
	 * 
	 * @param list
	 */
	public void setList(ArrayList<View> list) {
		this.list = list;
		notifyDataSetChanged();
	}

	/**
	 * ��ȡ��������
	 * 
	 * @return
	 */
	public ArrayList<View> getList() {
		return list;
	}

	/**
	 * ���ҳ��
	 * 
	 * @param iv
	 */
	public void addView(View iv) {
		notifyDataSetChanged();
		list.add(iv);
	}

	/**
	 * ɾ������
	 */
	public void removeList() {
		list.clear();
		notifyDataSetChanged();
	}

	/**
	 * ��ȡָ����View
	 * 
	 * @param position
	 * @return
	 */
	public View getView(int position) {
		return list.get(position);
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public boolean isViewFromObject(View view, Object obj) {
		return view == obj;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		container.addView((View) list.get(position));
		return list.get(position);
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);
	}

}