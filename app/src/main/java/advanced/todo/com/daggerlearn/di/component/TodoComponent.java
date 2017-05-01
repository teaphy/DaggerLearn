package advanced.todo.com.daggerlearn.di.component;

import advanced.todo.com.daggerlearn.application.TodoApplication;
import advanced.todo.com.daggerlearn.di.module.MainModule;
import advanced.todo.com.daggerlearn.di.module.StudentModule;
import advanced.todo.com.daggerlearn.di.module.TodoModule;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * @author Tiany
 * @desc
 * @date 2017/4/28
 */
@Component(modules = {AndroidInjectionModule.class, TodoModule.class, StudentModule.class, MainModule.class})
public interface TodoComponent {
	void inject(TodoApplication application);
}
