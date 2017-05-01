package advanced.todo.com.daggerlearn.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import advanced.todo.com.daggerlearn.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

/**
 * @author Tiany
 * @desc
 * @date 2017/4/28
 */
public abstract class BaseActivity extends AppCompatActivity {

	@BindView(R.id.toolBar)
	Toolbar mToolbar;

	protected Context mContext;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		AndroidInjection.inject(this);
		super.onCreate(savedInstanceState);
		setContentView(getLayoutId());

		ButterKnife.bind(this);

		mContext = this;

		initToolBar();

		initData();

		initView();

		setListener();
	}

	private void initToolBar() {

		mToolbar.setTitle(initTitle());
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

	protected abstract int getLayoutId();

	protected abstract String initTitle();

	protected abstract void initData();

	protected abstract void initView();

	protected abstract void setListener();

	protected abstract void killMySelf();

}
