package advanced.todo.com.daggerlearn.di.component;

import advanced.todo.com.daggerlearn.application.TodoApplication;
import advanced.todo.com.daggerlearn.di.module.AppleModule;
import advanced.todo.com.daggerlearn.di.module.FruitModule;
import advanced.todo.com.daggerlearn.di.module.MainModule;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/**
 * @author Tiany
 * @desc
 * @date 2017/4/28
 */
@Component(modules = {AndroidInjectionModule.class, MainModule.class, FruitModule.class, AppleModule.class})
public interface TodoComponent extends AndroidInjector<TodoApplication> {
	@Component.Builder
	abstract class Builder extends AndroidInjector.Builder<TodoApplication> {}
}
