package advanced.todo.com.daggerlearn.activity;

import com.google.auto.value.AutoAnnotation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Map;

import javax.inject.Inject;

import advanced.todo.com.daggerlearn.R;
import advanced.todo.com.daggerlearn.bean.AppleBean;
import advanced.todo.com.daggerlearn.di.component.DaggerDrinkComponent;
import advanced.todo.com.daggerlearn.di.component.DrinkComponent;
import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.MapKey;

public class DrinkActivity extends AppCompatActivity {

	@BindView(R.id.tv_fruit)
	TextView tvFruit;
	@BindView(R.id.toolBar)
	Toolbar mToolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		DrinkComponent drinkComponent = DaggerDrinkComponent.builder()
				.build();
		drinkComponent.inject(this);
		super.onCreate(savedInstanceState);
		setContentView(getLayoutId());

		ButterKnife.bind(this);

		initToolBar();
	}

	protected int getLayoutId() {
		return R.layout.activity_drink;
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
