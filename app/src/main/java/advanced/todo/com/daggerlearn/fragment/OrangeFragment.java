package advanced.todo.com.daggerlearn.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import advanced.todo.com.daggerlearn.R;
import advanced.todo.com.daggerlearn.bean.Fruits;
import advanced.todo.com.daggerlearn.bean.OrangeBean;
import advanced.todo.com.daggerlearn.di.component.DaggerFruitComponent;
import advanced.todo.com.daggerlearn.di.component.DaggerOrangeComponent;
import advanced.todo.com.daggerlearn.di.component.FruitComponent;
import advanced.todo.com.daggerlearn.di.component.OrangeComponent;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrangeFragment extends Fragment {


	@BindView(R.id.tv_fruit)
	TextView mTvFruit;

	Unbinder mUnbinder;

	@Inject
	OrangeBean mOrangeBean;
	@Inject
	Fruits mFruits;

	public OrangeFragment() {
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		FruitComponent fruitComponent = DaggerFruitComponent.create();
		OrangeComponent orangeComponent = DaggerOrangeComponent.builder()
				.fruitComponent(fruitComponent)
				.build();
		orangeComponent.inject(this);
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_chinese, container, false);

		mUnbinder = ButterKnife.bind(this, rootView);

		mTvFruit.setText(mFruits.toString());
		mTvFruit.append("\n");
		mTvFruit.append(mOrangeBean.toString());

		return rootView;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		if (null != mUnbinder) {
			mUnbinder.unbind();
		}
	}
}
