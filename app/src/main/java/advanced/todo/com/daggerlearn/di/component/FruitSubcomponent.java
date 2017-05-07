package advanced.todo.com.daggerlearn.di.component;

import advanced.todo.com.daggerlearn.activity.FruitActivity;
import advanced.todo.com.daggerlearn.di.module.AppleModule;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * @author todo
 * @desc
 * @date 2017/5/7
 */
@Subcomponent(modules = AppleModule.class)
public interface FruitSubcomponent extends AndroidInjector<FruitActivity> {

	@Subcomponent.Builder
	abstract class Builder extends AndroidInjector.Builder<FruitActivity> {

	}
}