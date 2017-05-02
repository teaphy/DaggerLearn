package advanced.todo.com.daggerlearn.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import advanced.todo.com.daggerlearn.R;
import advanced.todo.com.daggerlearn.bean.AppleBean;
import advanced.todo.com.daggerlearn.bean.BananaBean;
import advanced.todo.com.daggerlearn.bean.GreenTeaBean;
import advanced.todo.com.daggerlearn.bean.OrangeBean;
import advanced.todo.com.daggerlearn.di.component.DaggerDrinkComponent;
import advanced.todo.com.daggerlearn.di.component.DaggerFruitComponent;
import advanced.todo.com.daggerlearn.di.component.DrinkComponent;
import advanced.todo.com.daggerlearn.di.component.FruitComponent;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DrinkActivity extends AppCompatActivity {

	@BindView(R.id.tv_fruit)
	TextView tvFruit;
	@BindView(R.id.toolBar)
	Toolbar mToolbar;

	@Inject
	OrangeBean orangeA;
	@Inject
	OrangeBean orangeB;

	@Inject
	BananaBean bananaA;
	@Inject
	BananaBean bananaB;

	@Inject
	GreenTeaBean greenTeaA;
	@Inject
	GreenTeaBean greenTeaB;

	@Inject
	AppleBean appleBeanA;
	@Inject
	AppleBean appleBeanB;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		DrinkComponent fruitComponent = DaggerDrinkComponent.builder()
				.build();
		fruitComponent.inject(this);
		super.onCreate(savedInstanceState);
		setContentView(getLayoutId());

		ButterKnife.bind(this);

		initToolBar();


		// Drink - orangeA:advanced.todo.com.daggerlearn.bean.OrangeBean@db77b6b
		Log.d("test", "Drink - orangeA:" + orangeA.toString());
		// Drink - orangeB:advanced.todo.com.daggerlearn.bean.OrangeBean@db77b6b
		Log.d("test", "Drink - orangeB:" + orangeB.toString());

		// Drink - bananaA:advanced.todo.com.daggerlearn.bean.BananaBean@1e7c56c8
		Log.d("test", "Drink - bananaA:" + bananaA.toString());
		// Drink - bananaB:advanced.todo.com.daggerlearn.bean.BananaBean@4121361
		Log.d("test", "Drink - bananaB:" + bananaB.toString());

		// Drink - greenTeaA:advanced.todo.com.daggerlearn.bean.GreenTeaBean@186932dd
		Log.d("test", "Drink - greenTeaA:" + greenTeaA.toString());
		// Drink - greenTeaB:advanced.todo.com.daggerlearn.bean.GreenTeaBean@26382e52
		Log.d("test", "Drink - greenTeaB:" + greenTeaB.toString());


		// Drink - greenTeaA:advanced.todo.com.daggerlearn.bean.GreenTeaBean@186932dd
		Log.d("test", "Drink - appleBeanA:" + appleBeanA.toString());
		// Drink - greenTeaB:advanced.todo.com.daggerlearn.bean.GreenTeaBean@26382e52
		Log.d("test", "Drink - appleBeanB:" + appleBeanB.toString());

		tvFruit.setText(orangeA.toString());
		tvFruit.append("\n");
		tvFruit.append(orangeB.toString());
		tvFruit.append("\n");
		tvFruit.append(bananaA.toString());
		tvFruit.append("\n");
		tvFruit.append(bananaB.toString());
		tvFruit.append("\n");
		tvFruit.append(greenTeaA.toString());
		tvFruit.append("\n");
		tvFruit.append(greenTeaB.toString());
		tvFruit.append("\n");
		tvFruit.append(appleBeanA.toString());
		tvFruit.append("\n");
		tvFruit.append(appleBeanB.toString());
	}

	protected int getLayoutId() {
		return R.layout.activity_fruit;
	}

	private void initToolBar() {

		mToolbar.setTitle("Fruit");
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
