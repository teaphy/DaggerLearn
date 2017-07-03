package com.advanced.todo.daggerlearn.di.module;

import android.content.BroadcastReceiver;

import com.advanced.todo.daggerlearn.di.component.CoffeeReceiverSubcomponent;
import com.advanced.todo.daggerlearn.broadcast.CoffeeReceiver;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.BroadcastReceiverKey;
import dagger.multibindings.IntoMap;

/**
 * @author Tiany
 * @desc
 * @date 2017/5/11
 */
@Module(subcomponents = CoffeeReceiverSubcomponent.class)
public abstract class CoffeeModule {

	@Binds
	@IntoMap
	@BroadcastReceiverKey(CoffeeReceiver.class)
	abstract AndroidInjector.Factory<? extends BroadcastReceiver> bind(CoffeeReceiverSubcomponent.Builder builder);
}

