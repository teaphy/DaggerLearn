package advanced.todo.com.daggerlearn.application;

import advanced.todo.com.daggerlearn.di.component.DaggerTodoComponent;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * @author Tiany
 * @desc
 * @date 2017/4/28
 */
public class TodoApplication extends DaggerApplication{

	public void onCreate() {
		super.onCreate();
	}

	@Override
	protected AndroidInjector<TodoApplication> applicationInjector() {
		return DaggerTodoComponent.builder().create(this);
	}
}
