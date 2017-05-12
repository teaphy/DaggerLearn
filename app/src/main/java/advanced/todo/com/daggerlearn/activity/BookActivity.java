package advanced.todo.com.daggerlearn.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import advanced.todo.com.daggerlearn.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.DaggerActivity;
import dagger.android.support.DaggerAppCompatActivity;

public class BookActivity extends DaggerAppCompatActivity {

	@BindView(R.id.toolBar)
	Toolbar mToolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_book);


		ButterKnife.bind(this);

		initToolBar();
	}

	private void initToolBar() {

		mToolbar.setTitle("Book");
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
