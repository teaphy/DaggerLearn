package advanced.todo.com.daggerlearn.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import advanced.todo.com.daggerlearn.R;
import advanced.todo.com.daggerlearn.adapter.SingleTextAdapter;
import advanced.todo.com.daggerlearn.base.BaseActivity;
import advanced.todo.com.daggerlearn.bean.Fruits;
import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.Component;
import dagger.Module;
import dagger.android.AndroidInjection;

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
		mRvDaggerList.addOnItemTouchListener(new OnItemClickListener() {
			@Override
			public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
				switch (position) {
					case 0:
						startActivity(new Intent(mContext, FruitActivity.class));
						break;
					case 1:

						break;
					case 2:

						break;
					default:
						break;
				}
			}
		});
	}

	@Override
	protected void killMySelf() {
		finish();
	}
}
