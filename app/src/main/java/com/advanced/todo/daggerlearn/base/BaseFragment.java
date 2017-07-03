package com.advanced.todo.daggerlearn.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * @author Tiany
 * @desc
 * @date 2017/4/28
 */
public abstract class BaseFragment extends Fragment {

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		initData();
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View rootView = inflater.inflate(getLayoutId(), container, false);

		ButterKnife.bind(this, rootView);

		initView();

		setListener();

		return rootView;
	}

	protected abstract int getLayoutId();

	protected abstract void initData();

	protected abstract void initView();

	protected abstract void setListener();

	protected abstract void killMySelf();
}
