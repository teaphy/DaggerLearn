package advanced.todo.com.daggerlearn.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import javax.inject.Inject;

import advanced.todo.com.daggerlearn.R;
import advanced.todo.com.daggerlearn.base.BaseActivity;
import advanced.todo.com.daggerlearn.bean.StudentBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public class StudentActivity extends BaseActivity {

	@BindView(R.id.tv_stu)
	TextView tvStu;

	@Inject
	StudentBean studentBean;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ButterKnife.bind(this);
		// Log：student:StudentBean{no=1, name='赵四', areaBean=AreaBean{provice='四川', city='成都'}, scoreBean=ScoreBean{chinese=90.5, math=78.0}}
		Log.d("test", "student:" + studentBean.toString());
		tvStu.setText(studentBean.toString());
	}

	@Override
	protected int getLayoutId() {
		return R.layout.activity_student;
	}

	@Override
	protected String initTitle() {
		return "Student";
	}

	@Override
	protected void initData() {

	}

	@Override
	protected void initView() {

	}

	@Override
	protected void setListener() {

	}

	@Override
	protected void killMySelf() {

	}
}
