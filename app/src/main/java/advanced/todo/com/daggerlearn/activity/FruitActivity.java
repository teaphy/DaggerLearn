package advanced.todo.com.daggerlearn.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.Set;

import javax.inject.Inject;

import advanced.todo.com.daggerlearn.R;
import advanced.todo.com.daggerlearn.bean.AppleBean;
import advanced.todo.com.daggerlearn.bean.Fruits;
import advanced.todo.com.daggerlearn.di.component.DaggerFruitComponent;
import advanced.todo.com.daggerlearn.di.component.FruitComponent;
import advanced.todo.com.daggerlearn.di.module.AppleModule;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FruitActivity extends AppCompatActivity {

	@BindView(R.id.tv_fruit)
	TextView tvFruit;
	@BindView(R.id.toolBar)
	Toolbar mToolbar;

	@Inject
	Fruits mFruits;

	@Inject
	AppleBean mAppleBean;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		FruitComponent fruitComponent = DaggerFruitComponent.builder()
				.build();
		fruitComponent.inject(this);
		fruitComponent.addAppleSubcomponent(new AppleModule());
		super.onCreate(savedInstanceState);
		setContentView(getLayoutId());

		ButterKnife.bind(this);

		initToolBar();

		tvFruit.setText(mFruits.toString());
		tvFruit.append("/n");
		tvFruit.append(mAppleBean.toString());


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
}
