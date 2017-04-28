package advanced.todo.com.daggerlearn.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import advanced.todo.com.daggerlearn.R;
import advanced.todo.com.daggerlearn.adapter.SingleTextAdapter;
import advanced.todo.com.daggerlearn.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

	@BindView(R.id.rv_daggerList)
	RecyclerView mRvDaggerList;

	List<String> mList;
	SingleTextAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ButterKnife.bind(this);
	}

	@Override
	protected int getLayoutId() {
		return R.layout.activity_main;
	}

	@Override
	protected String initTitle() {
		return "DaggerLearn";
	}

	@Override
	protected void initData() {
		mList = new ArrayList<>();
		mList.addAll(Arrays.asList(getResources().getStringArray(R.array.learnList)));
		mAdapter = new SingleTextAdapter(R.layout.item_single_text, mList);
	}

	@Override
	protected void initView() {
		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
		mRvDaggerList.setLayoutManager(linearLayoutManager);
		mRvDaggerList.setAdapter(mAdapter);
	}

	@Override
	protected void setListener() {

	}

	@Override
	protected void killMySelf() {
		finish();
	}
}
