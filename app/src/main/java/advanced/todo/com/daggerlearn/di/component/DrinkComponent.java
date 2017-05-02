package advanced.todo.com.daggerlearn.di.component;

import javax.inject.Singleton;

import advanced.todo.com.daggerlearn.activity.DrinkActivity;
import advanced.todo.com.daggerlearn.activity.FruitActivity;
import advanced.todo.com.daggerlearn.di.module.DrinkModule;
import advanced.todo.com.daggerlearn.di.module.FruitModule;
import advanced.todo.com.daggerlearn.di.scope.TodoScope;
import dagger.Component;

/**
 * @author todo
 * @desc
 * @date 2017/4/29
 */
@Singleton
@TodoScope
@Component(modules = {DrinkModule.class})
public interface DrinkComponent {

	void inject(DrinkActivity activity);
}
