package com.advanced.todo.daggerlearn.di.module;

import android.app.Activity;

import com.advanced.todo.daggerlearn.di.component.DrinkSubcomponent;
import com.advanced.todo.daggerlearn.activity.DrinkActivity;

import dagger.Binds;
import dagger.Module;
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