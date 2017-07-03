package com.advanced.todo.daggerlearn.di.component;

import com.advanced.todo.daggerlearn.activity.MainActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * @author todo
 * @desc
 * @date 2017/5/7
 */
@Subcomponent
public interface MainSubcomponent extends AndroidInjector<MainActivity> {

	@Subcomponent.Builder
	abstract class Builder extends AndroidInjector.Builder<MainActivity> {

	}
}
