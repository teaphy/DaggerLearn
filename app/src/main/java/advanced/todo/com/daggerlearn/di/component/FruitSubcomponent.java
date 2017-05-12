package advanced.todo.com.daggerlearn.di.component;

import advanced.todo.com.daggerlearn.activity.FruitActivity;
import advanced.todo.com.daggerlearn.di.module.OrangeModule;
import advanced.todo.com.daggerlearn.di.scope.ActivityScope;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * @author todo
 * @desc
 * @date 2017/5/7
 */
@Subcomponent(modules = OrangeModule.class)
public interface FruitSubcomponent extends AndroidInjector<FruitActivity> {

	@Subcomponent.Builder
	abstract class Builder extends AndroidInjector.Builder<FruitActivity> {

	}
}