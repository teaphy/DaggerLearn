package com.advanced.todo.daggerlearn.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.advanced.todo.daggerlearn.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class FruitActivity extends AppCompatActivity implements HasSupportFragmentInjector {

	@BindView(R.id.tv_fruit)
	TextView tvFruit;
	@BindView(R.id.toolBar)
	Toolbar mToolbar;

	@Inject
	DispatchingAndroidInjector<android.support.v4.app.Fragment> fragmentInjector;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		AndroidInjection.inject(this);
		super.onCreate(savedInstanceState);
		setContentView(getLayoutId());
		ButterKnife.bind(this);

		initToolBar();
	}

	protected int getLayoutId() {
		return R.layout.activity_fruit;
	}

	private void initToolBar() {

		mToolbar.setTitle("Fruit");
		mToolbar.setNavigationIcon(R.mipmap.ic_back);
		setSupportActionBar(mToolbar);
		//关键下面两句话，设置了回退按钮，及点击事件的效果
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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


	@Override
	public AndroidInjector<android.support.v4.app.Fragment> supportFragmentInjector() {
		return fragmentInjector;
	}
}
