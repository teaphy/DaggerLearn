package com.advanced.todo.daggerlearn.di.component;

import com.advanced.todo.daggerlearn.broadcast.CoffeeReceiver;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * @author Tiany
 * @desc
 * @date 2017/5/11
 */
@Subcomponent
public interface CoffeeReceiverSubcomponent extends AndroidInjector<CoffeeReceiver> {
	@Subcomponent.Builder
	public abstract class Builder extends AndroidInjector.Builder<CoffeeReceiver> {

	}
}
