package advanced.todo.com.daggerlearn.di.module;

import android.app.Activity;

import advanced.todo.com.daggerlearn.activity.DrinkActivity;
import advanced.todo.com.daggerlearn.di.component.DrinkSubcomponent;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * @author Tiany
 * @desc
 * @date 2017/5/11
 */
@Module(subcomponents = DrinkSubcomponent.class)
public abstract class DrinkModule {
	@Binds
	@IntoMap
	@ActivityKey(DrinkActivity.class)
	abstract AndroidInjector.Factory<? extends Activity> bind(DrinkSubcomponent.Builder builder);
}