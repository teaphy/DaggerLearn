package com.advanced.todo.daggerlearn.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.advanced.todo.daggerlearn.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;


/**
 * @author Tiany
 * @desc
 * @date 2017/4/28
 */
public class SingleTextAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
	/**
	 * Same as QuickAdapter#QuickAdapter(Context,int) but with
	 * some initialization data.
	 *
	 * @param layoutResId The layout resource id of each item.
	 * @param data        A new list is created out of this one to avoid mutable list
	 */
	public SingleTextAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
		super(layoutResId, data);
	}

	/**
	 * Implement this method and use the helper to adapt the view to the given item.
	 *
	 * @param helper A fully initialized helper.
	 * @param item   The item that needs to be displayed.
	 */
	@Override
	protected void convert(BaseViewHolder helper, String item) {
		helper.setText(R.id.tv_singleText, item);
	}
}
