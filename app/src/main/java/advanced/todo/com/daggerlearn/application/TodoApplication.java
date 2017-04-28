package advanced.todo.com.daggerlearn.application;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import advanced.todo.com.daggerlearn.di.component.DaggerTodoComponent;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * @author Tiany
 * @desc
 * @date 2017/4/28
 */
public class TodoApplication extends Application  implements HasActivityInjector {

	@Inject
	DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

	@Override
	public void onCreate() {
		super.onCreate();
		DaggerTodoComponent.create()
				.inject(this);
	}
	/**
	 * Returns an {@link AndroidInjector} of {@link Activity}s.
	 */
	@Override
	public AndroidInjector<Activity> activityInjector() {
		return dispatchingActivityInjector;
	}
}
