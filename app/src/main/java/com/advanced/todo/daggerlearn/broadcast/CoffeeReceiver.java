package com.advanced.todo.daggerlearn.broadcast;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

import javax.inject.Inject;

import com.advanced.todo.daggerlearn.bean.AppleBean;
import dagger.android.DaggerBroadcastReceiver;

/**
 * @author Tiany
 * @desc
 * @date 2017/5/11
 */
public class CoffeeReceiver extends DaggerBroadcastReceiver {

	public static final String ACTION_COFFEE = "com.todo.daggerlearn.coffee";

	@Inject
	AppleBean mAppleBean;

	@Override
	public void onReceive(Context context, Intent intent) {
		super.onReceive(context, intent);

		if (TextUtils.equals(intent.getAction(), ACTION_COFFEE)) {
			Toast.makeText(context, "这是一杯" + mAppleBean.getName() + "味咖啡", Toast.LENGTH_SHORT).show();
		}
	}
}
