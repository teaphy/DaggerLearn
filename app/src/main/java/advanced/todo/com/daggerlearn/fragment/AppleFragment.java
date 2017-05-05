package advanced.todo.com.daggerlearn.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import advanced.todo.com.daggerlearn.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppleFragment extends Fragment {


	@BindView(R.id.tv_fruit)
	TextView mTvFuit;

	Unbinder mUnbinder;

	public AppleFragment() {
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_chinese, container, false);

		mUnbinder = ButterKnife.bind(this, rootView);

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
