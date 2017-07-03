package com.advanced.todo.daggerlearn.di.module;

import android.app.Activity;

import com.advanced.todo.daggerlearn.activity.FruitActivity;
import com.advanced.todo.daggerlearn.bean.AppleBean;
import com.advanced.todo.daggerlearn.di.component.FruitSubcomponent;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * @author todo
 * @desc
 * @date 2017/5/7
 */
@Module(subcomponents = FruitSubcomponent.class)
public abstract class FruitModule {
	@Binds
	@IntoMap
	@ActivityKey(FruitActivity.class)
	abstract AndroidInjector.Factory<? extends Activity> bindFruit(FruitSubcomponent.Builder builder);

	@Provides
	static AppleBean provideApple() {
		return new AppleBean("苹果");
	}
}