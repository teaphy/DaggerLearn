package advanced.todo.com.daggerlearn.di.module;

import android.app.Activity;

import advanced.todo.com.daggerlearn.activity.StudentActivity;
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
@Module(subcomponents = StudentSubcomponent.class)
public abstract class StudentModule {
	@Binds
	@IntoMap
	@ActivityKey(StudentActivity.class)
	abstract AndroidInjector.Factory<? extends Activity>
	bindYourActivityInjectorFactory(StudentSubcomponent.Builder builder);
}
