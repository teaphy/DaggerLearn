package advanced.todo.com.daggerlearn.di.module;

import android.app.Activity;

import advanced.todo.com.daggerlearn.activity.BookActivity;
import advanced.todo.com.daggerlearn.di.component.BookSubcomponent;
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
@Module(subcomponents = BookSubcomponent.class)
public abstract class BookModule {
	@Binds
	@IntoMap
	@ActivityKey(BookActivity.class)
	abstract AndroidInjector.Factory<? extends Activity> bindBookAndroidInjectorFactory(BookSubcomponent.Builder builder);
}