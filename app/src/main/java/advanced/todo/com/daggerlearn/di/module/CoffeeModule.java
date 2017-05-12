package advanced.todo.com.daggerlearn.di.module;

import android.app.Activity;
import android.content.BroadcastReceiver;

import advanced.todo.com.daggerlearn.broadcast.CoffeeReceiver;
import advanced.todo.com.daggerlearn.di.component.CoffeeReceiverSubcomponent;
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

