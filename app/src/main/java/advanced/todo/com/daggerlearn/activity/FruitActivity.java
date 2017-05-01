package advanced.todo.com.daggerlearn.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import advanced.todo.com.daggerlearn.R;
import advanced.todo.com.daggerlearn.base.BaseActivity;
import advanced.todo.com.daggerlearn.bean.AppleBean;
import advanced.todo.com.daggerlearn.bean.Fruits;
import advanced.todo.com.daggerlearn.bean.OrangeBean;
import advanced.todo.com.daggerlearn.di.component.DaggerFruitComponent;
import advanced.todo.com.daggerlearn.di.component.FruitComponent;
import advanced.todo.com.daggerlearn.di.module.OrangeModule;
import advanced.todo.com.daggerlearn.di.qualifier.Type;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FruitActivity extends AppCompatActivity {

	@BindView(R.id.tv_fruit)
	TextView tvFruit;
	@BindView(R.id.toolBar)
	Toolbar mToolbar;

	@Type("color")
	@Inject
	AppleBean appleColorBean;
	@Type("name")
	@Inject
	AppleBean appleNameBean;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		FruitComponent fruitComponent = DaggerFruitComponent.builder()
				                                .build();
		fruitComponent.inject(this);
		super.onCreate(savedInstanceState);
		setContentView(getLayoutId());

		ButterKnife.bind(this);

		initToolBar();

		//  appleColorBean:AppleBean{name='null', price=0.0, color='red'}
		Log.d("test", "appleColorBean:" + appleColorBean.toString());
		//  appleNameBean:AppleBean{name='红富士', price=6.88, color='null'}
		Log.d("test", "appleNameBean:" + appleNameBean.toString());
	}

	protected int getLayoutId() {
		return R.layout.activity_fruit;
	}

	private void initToolBar() {

		mToolbar.setTitle("水果");
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
}
