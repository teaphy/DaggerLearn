package advanced.todo.com.daggerlearn.di.component;

import advanced.todo.com.daggerlearn.activity.DrinkActivity;
import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/**
 * @author Tiany
 * @desc
 * @date 2017/5/11
 */
@Subcomponent
public interface DrinkSubcomponent extends AndroidInjector<DrinkActivity> {

	@Subcomponent.Builder
	public abstract class Builder extends AndroidInjector.Builder<DrinkActivity> {

	}
}