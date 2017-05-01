package advanced.todo.com.daggerlearn.di.module;

import android.app.Activity;

import advanced.todo.com.daggerlearn.activity.MainActivity;
import advanced.todo.com.daggerlearn.activity.StudentActivity;
import advanced.todo.com.daggerlearn.di.component.MainSubcomponent;
import advanced.todo.com.daggerlearn.di.component.StudentSubcomponent;
import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * @author Tiany
 * @desc
 * @date 2017/4/28
 */
@Module(subcomponents = MainSubcomponent.class)
public abstract class MainModule {
	@Binds
	@IntoMap
	@ActivityKey(MainActivity.class)
	abstract AndroidInjector.Factory<? extends Activity>
	bindYourActivityInjectorFactory(MainSubcomponent.Builder builder);
}
