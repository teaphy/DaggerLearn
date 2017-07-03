package com.advanced.todo.daggerlearn.di.component;

import com.advanced.todo.daggerlearn.activity.FruitActivity;
import com.advanced.todo.daggerlearn.di.module.OrangeModule;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * @author todo
 * @desc
 * @date 2017/5/7
 */
@Subcomponent(modules = OrangeModule.class)
public interface FruitSubcomponent extends AndroidInjector<FruitActivity> {

	@Subcomponent.Builder
	abstract class Builder extends AndroidInjector.Builder<FruitActivity> {

	}
}