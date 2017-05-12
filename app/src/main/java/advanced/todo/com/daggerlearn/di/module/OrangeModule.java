package advanced.todo.com.daggerlearn.di.module;

import android.app.Activity;
import android.support.v4.app.Fragment;


import advanced.todo.com.daggerlearn.activity.OrangeFragment;
import advanced.todo.com.daggerlearn.di.component.FruitSubcomponent;
import advanced.todo.com.daggerlearn.di.component.OrangeSubcomponent;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

/**
 * @author Tiany
 * @desc
 * @date 2017/5/10
 */
@Module(subcomponents = OrangeSubcomponent.class)
public abstract class OrangeModule {

	@Binds
	@IntoMap
	@FragmentKey(OrangeFragment.class)
	abstract AndroidInjector.Factory<? extends android.support.v4.app.Fragment> bindOrangeInjectorFactory(OrangeSubcomponent.Builder builder);
}
