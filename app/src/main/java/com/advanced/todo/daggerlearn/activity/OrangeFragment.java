package com.advanced.todo.daggerlearn.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.advanced.todo.daggerlearn.R;

import javax.inject.Inject;

import com.advanced.todo.daggerlearn.bean.AppleBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrangeFragment extends Fragment{

	@BindView(R.id.tv_orange)
	TextView mTvOrange;

	@Inject
	AppleBean mAppleBean;

	@Override
	public void onAttach(Context context) {
		AndroidSupportInjection.inject(this);
		super.onAttach(context);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_orange, container, false);

		ButterKnife.bind(this, rootView);

		// AppleBean{name='这是一个苹果'}
		Log.d("testTodo", mAppleBean.toString());
		mTvOrange.setText(mAppleBean.toString());
		return rootView;
	}

}
