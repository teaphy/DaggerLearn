package advanced.todo.com.daggerlearn.application;

import android.support.v4.app.Fragment;

import javax.inject.Inject;

import advanced.todo.com.daggerlearn.di.component.DaggerTodoComponent;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * @author Tiany
 * @desc
 * @date 2017/4/28
 */
public class TodoApplication extends DaggerApplication implements HasSupportFragmentInjector{

	@Inject
	DispatchingAndroidInjector<Fragment> fragmentSupportInjector;

	public void onCreate() {
		super.onCreate();
	}

	@Override
	protected AndroidInjector<TodoApplication> applicationInjector() {
		return DaggerTodoComponent.builder().create(this);
	}

	@Override
	public AndroidInjector<Fragment> supportFragmentInjector() {
		return fragmentSupportInjector;
	}
}
