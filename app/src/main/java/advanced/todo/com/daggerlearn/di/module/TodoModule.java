package advanced.todo.com.daggerlearn.di.module;

import advanced.todo.com.daggerlearn.application.TodoApplication;
import dagger.Module;

/**
 * @author Tiany
 * @desc
 * @date 2017/4/28
 */
@Module()
public abstract class TodoModule {
	private TodoApplication mApplication;

	public TodoModule(TodoApplication application) {
		mApplication = application;
	}
}
