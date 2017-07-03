package com.advanced.todo.daggerlearn.di.module;


import com.advanced.todo.daggerlearn.activity.OrangeFragment;
import com.advanced.todo.daggerlearn.di.component.OrangeSubcomponent;
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
