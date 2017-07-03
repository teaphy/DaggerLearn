package com.advanced.todo.daggerlearn.di.component;

import com.advanced.todo.daggerlearn.activity.OrangeFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * @author Tiany
 * @desc
 * @date 2017/5/10
 */
@Subcomponent
public interface OrangeSubcomponent extends AndroidInjector<OrangeFragment> {

	@Subcomponent.Builder
	public abstract class Builder extends AndroidInjector.Builder<OrangeFragment> {

	}
}
