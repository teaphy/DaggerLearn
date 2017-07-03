package com.advanced.todo.daggerlearn.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.advanced.todo.daggerlearn.R;
import com.advanced.todo.daggerlearn.broadcast.CoffeeReceiver;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;

public class DrinkActivity extends AppCompatActivity {

	@BindView(R.id.toolBar)
	Toolbar mToolbar;
	@BindView(R.id.acb_coffee)
	AppCompatButton mAcbCoffee;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		AndroidInjection.inject(this);
		super.onCreate(savedInstanceState);
		setContentView(getLayoutId());

		ButterKnife.bind(this);

		initToolBar();
	}

	protected int getLayoutId() {
		return R.layout.activity_drink;
	}

	private void initToolBar() {

		mToolbar.setTitle("Drink");
		mToolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
		mToolbar.setNavigationIcon(R.mipmap.ic_back);
		setSupportActionBar(mToolbar);

		mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				killMySelf();
			}
		});
	}

	private void killMySelf() {
		finish();
	}

	@OnClick(R.id.acb_coffee)
	public void onViewClicked() {
		Intent intent = new Intent();
		intent.setAction(CoffeeReceiver.ACTION_COFFEE);
		sendBroadcast(intent);
	}
}
