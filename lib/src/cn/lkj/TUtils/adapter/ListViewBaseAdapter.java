package cn.lkj.TUtils.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * ����ListView�������� ����д���� �̳б���ʵ��getView��������
 * 
 * @author LKJ
 * 
 * @param <T>
 */
public abstract class ListViewBaseAdapter<T> extends BaseAdapter {
	public ArrayList<T> list = new ArrayList<T>();
	public Context mContext;

	public ListViewBaseAdapter(Context mContext) {
		this.mContext = mContext;
	}

	/**
	 * ��Ӽ���
	 * 
	 * @param list
	 */
	public void addList(ArrayList<T> list) {
		this.list.clear();
		this.list.addAll(list);
		notifyDataSetChanged();
	}

	/**
	 * ����������
	 */
	public void cleanList() {
		list.clear();
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public abstract View getView(int position, View convertView,
			ViewGroup parent);

}
